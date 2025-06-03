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

	Private ServerUrl As String
	Private ServerPingUrl As String
	Private GoogleApiKey As String
	Private cam As CamEx2
	Private rp As RuntimePermissions
	Private su As StringUtils
	Private TTS1 As TTS
	Private MyTaskIndex As Int
	Private speech As SpeechRecognition
	Private autoTimer As Timer
	
	Private isProcessing As Boolean = False
	Private lastDescription As String = ""
	
	Private flp As FusedLocationProvider
	Private locationTimer As Timer
	Private currentAddress As String = ""
	Private ShouldRequestAddressOnNextLocation As Boolean = False
	Private ShouldSpeakAddressOnNextLocation As Boolean = False
	Private CurrentMode As String = "normal" ' "outdoor", "indoor", "normal"
	
	'Disigner
	Private lblTop As Label
	Private lblLocation As Label
	Private pnlPreview As Panel
	
	Private btnOutMode As Button
	Private btnInMode As Button
	Private btnNoMode As Button
	Private btnStopAll As Button
	
	Private lblAiTitle As Label
	Private lblResponseTxt As Label
	
	Private btnVoiceAsk As Button
	Private btnCapture As Button
End Sub

Public Sub Initialize
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	' 读取api
	ReadApiKeysFromConfig
	' 唤醒服务器
	WakeupServer
	' 初始化颜色
	UpdateButtonColors(btnStopAll)
	' 语音TTS
	speech.Initialize(Me)
	TTS1.Initialize("TTS1")
	' 自动倒数
	autoTimer.Initialize("autoTimer", 5000)
	autoTimer.Enabled = False
	' 定位时间
	locationTimer.Initialize("locationTimer", 5 * 60 * 1000)
	locationTimer.Enabled = True

	' 请求麦克风权限
	rp.CheckAndRequest(rp.PERMISSION_RECORD_AUDIO)
	Wait For B4XPage_PermissionResult(Permission As String, Result As Boolean)
	If Permission = rp.PERMISSION_RECORD_AUDIO And Result = False Then
		ToastMessageShow("未授权麦克风权限，语音功能将不可用", True)
	End If
	
	' 请求定位权限
	rp.CheckAndRequest(rp.PERMISSION_ACCESS_FINE_LOCATION)
	Wait For B4XPage_PermissionResult(Permission As String, Result As Boolean)
	If Result Then
		InitLocationService
	Else
		ToastMessageShow("未授权位置权限，无法定位", False)
	End If
	
	' 启动相机
	Wait For (InitCamera) Complete (Success As Boolean)
	If Success = False Then
		ToastMessageShow("相机启动失败", True)
	End If
End Sub

Private Sub InitCamera As ResumableSub
	Dim Success As Boolean = False
	rp.CheckAndRequest(rp.PERMISSION_CAMERA)
	Wait For B4XPage_PermissionResult(Permission As String, Result As Boolean)
	If Result = False Then Return False

	cam.Initialize(pnlPreview)
	Wait For(cam.OpenCamera(False)) Complete (TaskIndex As Int)
	If TaskIndex > 0 Then
		MyTaskIndex = TaskIndex
		Wait For(cam.PrepareSurface(MyTaskIndex)) Complete (PrepareSuccess As Boolean)
		If PrepareSuccess Then
			cam.StartPreview(MyTaskIndex, False)
			Success = True
		End If
	End If
	Return Success
End Sub

Private Sub WakeupServer
	Dim jobWake As HttpJob
	jobWake.Initialize("Wakeup", Me)
	jobWake.Download(ServerPingUrl)
	jobWake.GetRequest.Timeout = 10000
End Sub

Sub TTS1_Ready (Success As Boolean)
	Log("TTS Ready: " & Success)
End Sub

Sub autoTimer_Tick
	If isProcessing Then Return
	isProcessing = True
	TakeAndSendPicture("请描述前方")
End Sub

Private Sub btnVoiceAsk_Click
	UpdateButtonColors(btnVoiceAsk)
	If speech.IsInitialized Then
		speech.StartListening
	Else
		ToastMessageShow("语音识别未初始化", False)
	End If
End Sub

Sub SpeechRecognition_Error(ErrorCode As Int)
	ToastMessageShow("语音识别失败", False)
End Sub

Private Sub btnCapture_Click
	UpdateButtonColors(btnCapture)
	If isProcessing Then Return
	isProcessing = True
	TakeAndSendPicture("请描述前方")
End Sub

Private Sub TakeAndSendPicture(QuestionText As String)
	Wait For(cam.FocusAndTakePicture(MyTaskIndex)) Complete (Data() As Byte)
	If Data.Length = 0 Then
		ToastMessageShow("拍照失败", False)
		isProcessing = False
		Return
	End If

	Dim imgBase64 As String = su.EncodeBase64(Data)

	' 判断语言（是否中文）
	Dim isChinese As Boolean = False
	For i = 0 To QuestionText.Length - 1
		Dim ch As String = QuestionText.CharAt(i)
		If Asc(ch) >= 0x4e00 And Asc(ch) <= 0x9fff Then
			isChinese = True
			Exit
		End If
	Next

	' 设置 system_prompt
	Dim system_prompt As String
	Select CurrentMode
		Case "outdoor"
			If isChinese Then
				system_prompt = "请用中文回答。我是一名视障人士，目前处于户外街道模式。请优化描述风格以便快速理解，并重点描述前方是否有斑马线、红绿灯、障碍物、围栏、盲道或沟渠。"
			Else
				system_prompt = "Please answer in English. I am a blind person in outdoor street mode. Please describe clearly any crosswalks, traffic lights, obstacles, fences, tactile paths, or drains in front."
			End If
		Case "indoor"
			If isChinese Then
				system_prompt = "请用中文回答。我是一名视障人士，目前处于室内商场模式。请优化描述风格以便快速理解，并关注是否有厕所、入口、出口或大门等重要设施。"
			Else
				system_prompt = "Please answer in English. I am a blind person in indoor mode. Please clearly describe any restrooms, entrances, exits, or main doors visible in the scene."
			End If
		Case Else
			If isChinese Then
				system_prompt = "请用中文回答。我是一名视障人士。请描述图像内容并简洁明了。"
			Else
				system_prompt = "Please answer in English. I am a blind person. Please provide a concise description of the scene."
			End If
	End Select

	' 创建 JSON 请求体
	Dim json As String = $"{"image": "${imgBase64}", "question": "${QuestionText}", "system_prompt": "${system_prompt}"}"$

	Dim job As HttpJob
	job.Initialize("AI", Me)
	job.PostString(ServerUrl, json)
	job.GetRequest.SetContentType("application/json")
End Sub

Private Sub btnOutMode_Click
	UpdateButtonColors(btnOutMode)
	CurrentMode = "outdoor"
	autoTimer.Interval = 10000 ' 10秒自动提问
	autoTimer.Enabled = True
	locationTimer.Interval = 60000 ' 60秒定位
	locationTimer.Enabled = True
	ToastMessageShow("户外街道模式已开启", False)
	TTS1.Speak("户外街道模式已开启", False)
End Sub

Private Sub btnInMode_Click
	UpdateButtonColors(btnInMode)
	CurrentMode = "indoor"
	autoTimer.Interval = 30000 ' 30秒自动提问
	autoTimer.Enabled = True
	locationTimer.Enabled = False ' 停止自动定位
	ToastMessageShow("室内商场模式已开启", False)
	TTS1.Speak("室内商场模式已开启", False)
End Sub

Private Sub btnNoMode_Click
	UpdateButtonColors(btnNoMode)
	CurrentMode = "normal"
	autoTimer.Interval = 30000
	autoTimer.Enabled = True
	locationTimer.Interval = 60000
	locationTimer.Enabled = True
	ToastMessageShow("普通综合模式已开启", False)
	TTS1.Speak("普通综合模式已开启", False)
End Sub

Private Sub lblResponseTxt_Click
	If lastDescription.Trim.Length > 0 Then
		TTS1.Speak(lastDescription, False)
	Else
		ToastMessageShow("当前没有内容可重播", False)
	End If
End Sub

Private Sub btnStopAll_Click
	UpdateButtonColors(btnStopAll)
	Log("🛑 停止所有模式")

	' 停止自动提问与定位定时器
	autoTimer.Enabled = False
	locationTimer.Enabled = False

	' 停止语音识别
	If speech.IsInitialized Then
		Try
			speech.StopListening
		Catch
			Log(LastException.Message)
		End Try
	End If

	' 停止正在进行的 TTS 播报
	If TTS1.IsInitialized Then
		Try
			TTS1.Stop
		Catch
			Log(LastException.Message)
		End Try
	End If

	' 停止拍照流程标志
	isProcessing = False
	ToastMessageShow("所有功能已暂停", False)
	TTS1.Speak("所有功能已暂停", False)
End Sub

Public Sub HandleBackPressed(ignore As Boolean)
	Dim sf As Object = xui.Msgbox2Async("你确定要退出应用吗？", "退出应用", "是", "取消", "", Null)
	Wait For (sf) Msgbox_Result (Result As Int)
	If Result = xui.DialogResponse_Positive Then
		ExitApplication
	End If
End Sub

Private Sub locationTimer_Tick
	If CurrentMode = "outdoor" Or CurrentMode = "normal" Then
		RequestCurrentAddress(False) ' 不播报地址
	End If
End Sub

Private Sub SpeechRecognition_Result(Text As String)
	Log("识别到内容: " & Text)
	If isProcessing Then
		Log("⚠️ 正在处理，跳过")
		Return
	End If

	autoTimer.Enabled = False  ' 确保不会跳入循环
	isProcessing = True

	If Text.Contains("位置") Or Text.Contains("坐标") Or Text.Contains("哪里") Then
		If CurrentMode = "indoor" Then
			RequestCurrentAddress(True)
		Else
			ShouldRequestAddressOnNextLocation = True
			ShouldSpeakAddressOnNextLocation = True
		End If
	Else
		TakeAndSendPicture(Text)
	End If

	' 👇不要启用自动提问
	' autoTimer.Enabled = True
	UpdateButtonColors(btnStopAll)
End Sub

Private Sub ReadApiKeysFromConfig
	Try
		Dim su As StringUtils
		Dim configText As String = File.ReadString(File.DirAssets, "config.txt")
		Dim lines() As String = Regex.Split("\n", configText)
		For Each line As String In lines
			If line.StartsWith("GOOGLE_MAPS_KEY=") Then
				GoogleApiKey = line.Replace("GOOGLE_MAPS_KEY=", "").Trim
			Else If line.StartsWith("SERVER_URL=") Then
				ServerUrl = line.Replace("SERVER_URL=", "").Trim
			Else If line.StartsWith("SERVER_PING_URL=") Then
				ServerPingUrl = line.Replace("SERVER_PING_URL=", "").Trim
			End If
		Next
	Catch
		Log("⚠️ 无法读取 config.txt: " & LastException.Message)
		ToastMessageShow("配置文件读取失败", True)
	End Try
End Sub


' ⭐ GPS部分
Private Sub InitLocationService
	flp.Initialize("flp")
	flp.Connect
End Sub

Sub flp_ConnectionSuccess
	Log("FLP连接成功")
	Dim lr As LocationRequest
	lr.Initialize
	lr.SetInterval(0)
	flp.RequestLocationUpdates(lr)
End Sub

Sub flp_ConnectionFailed(ConnectionResult1 As Int)
	Log("FLP连接失败")
End Sub

Sub flp_ConnectionSuspended
	Log("FLP连接挂起")
End Sub

Sub flp_LocationChanged(Location1 As Location)
	Dim lat As Double = Location1.Latitude
	Dim lon As Double = Location1.Longitude
	Log($"当前位置: ${lat}, ${lon}"$)

	' 始终请求地址，但默认不播报
	If ShouldRequestAddressOnNextLocation Then
		ShouldRequestAddressOnNextLocation = False
		RequestGeoAddress(lat, lon, ShouldSpeakAddressOnNextLocation)
	Else
		RequestGeoAddress(lat, lon, False) ' 每次更新都显示地址，但不播报
	End If
End Sub

Private Sub RequestCurrentAddress(ShouldSpeak As Boolean)
	If flp.IsConnected = False Then
		Log("FLP未连接")
		Return
	End If

	Dim Location1 As Location = flp.GetLastKnownLocation
	If Location1.IsInitialized Then
		Dim lat As Double = Location1.Latitude
		Dim lon As Double = Location1.Longitude
		Dim url As String = $"https://maps.googleapis.com/maps/api/geocode/json?latlng=${lat},${lon}&language=zh-CN&key=${GoogleApiKey}"$
		Dim jobGeo As HttpJob
		jobGeo.Initialize("GeoAddress", Me)
		jobGeo.Tag = ShouldSpeak
		jobGeo.Download(url)
	Else
		Log("没有获取到LastKnownLocation")
	End If
End Sub

Sub JobDone(job As HttpJob)
	If job.JobName = "Wakeup" Then
		Log("✅ Render服务器唤醒完成")
		job.Release
		Return
	End If

	If job.JobName = "GeoAddress" Then
		If job.Success Then
			Try
				Dim parser As JSONParser
				parser.Initialize(job.GetString)
				Dim geoRoot As Map = parser.NextObject
				Dim results As List = geoRoot.Get("results")
				If results.Size > 0 Then
					Dim result As Map = results.Get(0)
					currentAddress = result.Get("formatted_address")
					lblLocation.Text = "地址：" & currentAddress
					Log("定位到：" & currentAddress)
					If job.Tag = True Then
						TTS1.Speak("你现在在 " & currentAddress, False)
					End If
				End If
			Catch
				Log("地址解析失败：" & LastException.Message)
			End Try
		Else
			Log("Geo定位请求失败: " & job.ErrorMessage)
		End If
		job.Release
		Return
	End If

	If job.Success Then
		Try
			Log("服务器返回：" & job.GetString)
			Dim parser As JSONParser
			parser.Initialize(job.GetString)
			Dim responseMap As Map = parser.NextObject
			Dim desc As String
			If responseMap.ContainsKey("answer") Then
				desc = responseMap.Get("answer")
			Else
				Log("⚠️ answer字段未找到")
				Return
			End If

			If desc.Trim.Length > 0 Then
				If desc <> lastDescription Then
					lastDescription = desc
					lblResponseTxt.Text = desc
					Log("服务器返回：" & desc)
					UpdateButtonColors(btnStopAll) ' ✅ 播报前恢复按钮颜色
					TTS1.Speak(desc, False)
					ToastMessageShow(desc, False)
				Else
					Log("⚠️ 跳过重复回答")
				End If
			Else
				ToastMessageShow("无回答内容", False)
			End If
		Catch
			Log("解析失败：" & LastException.Message)
			ToastMessageShow("AI返回解析失败", False)
		End Try
	Else
		Log("上传失败: " & job.ErrorMessage)
		ToastMessageShow("上传失败，请检查网络", False)
	End If
	job.Release
	isProcessing = False
End Sub

Private Sub RequestGeoAddress(lat As Double, lon As Double, speak As Boolean)
	If GoogleApiKey = "" Then
		Log("⚠️ Google API Key 未初始化")
		ToastMessageShow("缺少 Google API Key", True)
		Return
	End If
	Dim url As String = $"https://maps.googleapis.com/maps/api/geocode/json?latlng=${lat},${lon}&key=${GoogleApiKey}"$
	Dim jobGeo As HttpJob
	jobGeo.Initialize("GeoAddress", Me)
	jobGeo.Tag = speak
	jobGeo.Download(url)
End Sub

' 颜色控制
Private Sub UpdateButtonColors(ActiveButton As Button)
	Dim defaultColor As Int = xui.Color_White
	Dim activeColor As Int = 0xFF00CC00  ' 绿色
	Dim stopColor As Int = 0xFFFF4444    ' 红色

	If ActiveButton = btnOutMode Then
		btnOutMode.Color = activeColor
	Else
		btnOutMode.Color = defaultColor
	End If
	If ActiveButton = btnInMode Then
		btnInMode.Color = activeColor
	Else
		btnInMode.Color = defaultColor
	End If
	If ActiveButton = btnNoMode Then
		btnNoMode.Color = activeColor
	Else
		btnNoMode.Color = defaultColor
	End If
	If ActiveButton = btnStopAll Then
		btnStopAll.Color = stopColor
	Else
		btnStopAll.Color = defaultColor
	End If
	If ActiveButton = btnVoiceAsk Then
		btnVoiceAsk.Color = activeColor
	Else
		btnVoiceAsk.Color = defaultColor
	End If
	If ActiveButton = btnCapture Then
		btnCapture.Color = activeColor
	Else
		btnCapture.Color = defaultColor
	End If
End Sub