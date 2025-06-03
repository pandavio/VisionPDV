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

	' 主要变量
	Private cam As CamEx2
	Private rp As RuntimePermissions
	Private pnlPreview As B4XView
	Private su As StringUtils
	Private TTS1 As TTS
	Private MyTaskIndex As Int

	' 自动模式
	Private autoTimer As Timer
	Private isProcessing As Boolean = False

	' 新增：去重播报变量
	Private lastDescription As String = ""
End Sub

Public Sub Initialize
	'B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")

	TTS1.Initialize("TTS1")
	cam.Initialize(pnlPreview)
	OpenCamera

	' 初始化定时器
'	autoTimer.Initialize("autoTimer", 5000)
'	autoTimer.Enabled = True
End Sub

Sub TTS1_Ready (Success As Boolean)
	Log("TTS Ready: " & Success)
End Sub

Private Sub OpenCamera
	rp.CheckAndRequest(rp.PERMISSION_CAMERA)
	Wait For B4XPage_PermissionResult(Permission As String, Result As Boolean)
	If Result = False Then
		xui.MsgboxAsync("No camera permission", "Error")
		Return
	End If

	Wait For(cam.OpenCamera(False)) Complete (TaskIndex As Int)
	If TaskIndex > 0 Then
		MyTaskIndex = TaskIndex
		Wait For(cam.PrepareSurface(MyTaskIndex)) Complete (Success As Boolean)
		If Success Then
			cam.StartPreview(MyTaskIndex, False)
		Else
			xui.MsgboxAsync("Camera preview failed", "Error")
		End If
	End If
End Sub

' 手动拍照（仍保留按钮功能）
Private Sub btnCapture_Click
	If isProcessing Then Return
	isProcessing = True
	TakeAndSendPicture
End Sub


' 自动定时器
'Sub autoTimer_Tick
'	If isProcessing Then Return
'	isProcessing = True
'	TakeAndSendPicture
'End Sub

' 拍照并上传
Private Sub TakeAndSendPicture
	Wait For(cam.FocusAndTakePicture(MyTaskIndex)) Complete (Data() As Byte)

	Dim imgBase64 As String = su.EncodeBase64(Data)
	Dim json As String = $"{"image": "${imgBase64}"}"$

	Dim job As HttpJob
	job.Initialize("AI", Me)
	job.PostString("http://192.168.100.84:5000/analyze", json)
	job.GetRequest.SetContentType("application/json")
End Sub

Sub JobDone(job As HttpJob)
	If job.Success Then
		Try
			Log("服务器原始返回：" & job.GetString)

			Dim parser As JSONParser
			parser.Initialize(job.GetString)
			Dim responseMap As Map = parser.NextObject

			Dim desc As String
			If responseMap.ContainsKey("description_zh") Then
				desc = responseMap.Get("description_zh")
			Else If responseMap.ContainsKey("description") Then
				desc = responseMap.Get("description")
			Else
				Log("⚠️ description 字段未找到")
				Return
			End If

			Log("AI 描述: " & desc)

			If desc.Trim.Length > 0 Then
				If desc <> lastDescription Then
					lastDescription = desc
					TTS1.Speak(desc, False)
					ToastMessageShow("AI 语音： " & desc, False)
				Else
					Log("⚠️ 跳过重复播报：" & desc)
				End If
			Else
				ToastMessageShow("AI 无描述内容", False)
			End If
		Catch
			Log("解析失败：" & LastException.Message)
			ToastMessageShow("AI 返回解析失败", False)
		End Try
	Else
		Log("上传失败: " & job.ErrorMessage)
		If job.Response <> Null Then
			Log("状态码: " & job.Response.StatusCode)
			Try
				Log("服务器响应内容: " & job.GetString)
			Catch
				Log("⚠️ 请求失败，无法获取 GetString（可能没有响应文件）")
			End Try
		End If
		ToastMessageShow("上传失败，请检查网络连接或API状态", False)
	End If
	job.Release
	isProcessing = False
End Sub
