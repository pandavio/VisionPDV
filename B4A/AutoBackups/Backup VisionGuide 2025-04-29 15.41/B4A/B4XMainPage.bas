B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
#End Region

Sub Class_Globals
    Private Root As B4XView
    Private xui As XUI

    ' 摄像头与图片
    Private cam As CamEx2
    Private rp As RuntimePermissions
    Private pnlPreview As B4XView
    Private su As StringUtils
    Private MyTaskIndex As Int

    ' 语音与播报
    Private TTS1 As TTS
    Private sr As SpeechRecognizer

    ' 状态管理
    Private isProcessing As Boolean = False
    Private lastDescription As String = ""
    Private pendingQuestion As String = ""

    ' 按钮
    Private btnCapture As Button
    Private btnAsk As Button
End Sub

Public Sub Initialize
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
    Root = Root1
    Root.LoadLayout("MainPage") ' 布局里必须有 pnlPreview, btnCapture, btnAsk

    TTS1.Initialize("TTS1")
    sr.Initialize(Me, "sr") ' 注意名字和sr_Event匹配

    cam.Initialize(pnlPreview)
    OpenCamera
End Sub

Sub TTS1_Ready (Success As Boolean)
    Log("TTS Ready: " & Success)
End Sub

Private Sub OpenCamera
    rp.CheckAndRequest(rp.PERMISSION_CAMERA)
    Wait For B4XPage_PermissionResult(Permission As String, Result As Boolean)
    If Result = False Then
        xui.MsgboxAsync("没有相机权限", "错误")
        Return
    End If

    Wait For (cam.OpenCamera(False)) Complete (TaskIndex As Int)
    If TaskIndex > 0 Then
        MyTaskIndex = TaskIndex
        Wait For (cam.PrepareSurface(MyTaskIndex)) Complete (Success As Boolean)
        If Success Then
            cam.StartPreview(MyTaskIndex, False)
        Else
            xui.MsgboxAsync("相机预览失败", "错误")
        End If
    End If
End Sub

' ========== 手动拍照按钮 ========== 
Private Sub btnCapture_Click
    If isProcessing Then Return
    pendingQuestion = ""
    isProcessing = True
    TakeAndSendPicture
End Sub

' ========== 点击开始语音提问 ========== 
Private Sub btnAsk_Click
    If isProcessing Then Return
    If sr.IsSupported Then
        rp.CheckAndRequest(rp.PERMISSION_RECORD_AUDIO)
        Wait For B4XPage_PermissionResult (Permission As String, Result As Boolean)
        If Result Then
            TTS1.Speak("请提问", False)
            sr.Listen
        Else
            ToastMessageShow("请允许录音权限才能使用语音识别", False)
        End If
    Else
        ToastMessageShow("设备不支持语音识别", False)
    End If
End Sub

' ========== SpeechRecognizer回调 ========== 
Sub sr_Event(MethodName As String, Args() As Object) As Object
	Log($"sr_Event触发: ${MethodName}"$)
	Select Case MethodName
		Case "onResults"
			Dim results As JavaObject = Args(0)
			Dim texts As List = results.RunMethod("getStringArrayList", Array("results_recognition"))
			Log("🎤 识别到文本: " & texts)
			CallSub3(Me, "sr_Result", True, texts)
		Case "onError"
			Dim errorCode As Int = Args(0)
			Log($"❌ 语音识别错误: ${errorCode}"$)
			CallSub3(Me, "sr_Result", False, Null)
	End Select
	Return Null
End Sub



' ========== 语音识别完成 ========== 
Sub sr_Result(Success As Boolean, Texts As List)
	If Success Then
		If Texts <> Null And Texts.Size > 0 Then
			pendingQuestion = Texts.Get(0)
			Log("用户提问: " & pendingQuestion)
			isProcessing = True
			TakeAndSendPicture
		Else
			ToastMessageShow("没有识别到语音内容", False)
		End If
	Else
		ToastMessageShow("语音识别失败", False)
	End If
End Sub





' ========== 拍照并上传 ========== 
Private Sub TakeAndSendPicture
    Wait For (cam.FocusAndTakePicture(MyTaskIndex)) Complete (Data() As Byte)

    Dim imgBase64 As String = su.EncodeBase64(Data)
    Dim json As String

    If pendingQuestion.Trim.Length > 0 Then
        json = $"{"image": "${imgBase64}", "question": "${pendingQuestion}"}"$
    Else
        json = $"{"image": "${imgBase64}"}"$
    End If

    Dim job As HttpJob
    job.Initialize("AI", Me)
    job.PostString("http://192.168.100.84:5000/analyze", json)
    job.GetRequest.SetContentType("application/json")
End Sub

' ========== 处理服务器返回 ========== 
Sub JobDone(job As HttpJob)
    isProcessing = False

    If job.Success Then
        Try
            Log("服务器原始返回：" & job.GetString)

            Dim parser As JSONParser
            parser.Initialize(job.GetString)
            Dim responseMap As Map = parser.NextObject

            Dim desc As String
            If responseMap.ContainsKey("answer") Then
                desc = responseMap.Get("answer")
            Else If responseMap.ContainsKey("description_zh") Then
                desc = responseMap.Get("description_zh")
            Else If responseMap.ContainsKey("description") Then
                desc = responseMap.Get("description")
            Else
                Log("⚠️ 返回数据中没有 description 字段")
                Return
            End If

            Log("AI 描述/回答: " & desc)

            If desc.Trim.Length > 0 And desc <> lastDescription Then
                lastDescription = desc
                TTS1.Speak(desc, False)
                ToastMessageShow(desc, False)
            Else
                Log("⚠️ 跳过重复播报: " & desc)
            End If
        Catch
            Log("解析失败：" & LastException.Message)
            ToastMessageShow("返回解析失败", False)
        End Try
    Else
        Log("上传失败: " & job.ErrorMessage)
        ToastMessageShow("上传失败，请检查网络或服务器", False)
    End If

    job.Release
End Sub
