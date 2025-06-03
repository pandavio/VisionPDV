B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.1
@EndOfDesignText@
'Class module
Sub Class_Globals
	Private JO As JavaObject
	Private RecognizerIntent As Intent
	Private Initialized As Boolean

	Private TargetModule As Object ' 新增：保存回调的页面（B4XMainPage）
End Sub

' 初始化（传入目标页面）
Public Sub Initialize(Target As Object)
	TargetModule = Target

	JO.InitializeStatic("android.speech.SpeechRecognizer")
	Dim ctx As JavaObject
	ctx.InitializeContext
	JO = JO.RunMethod("createSpeechRecognizer", Array(ctx))

	If Not(IsRecognitionAvailable) Then
		Log("Speech Recognition Not Available")
		Return
	End If

	RecognizerIntent.Initialize("android.speech.action.RECOGNIZE_SPEECH", Null)
	RecognizerIntent.PutExtra("android.speech.extra.LANGUAGE_PREFERENCE", "en")
	RecognizerIntent.PutExtra("calling_package", Application.PackageName)
	RecognizerIntent.PutExtra("android.speech.extra.LANGUAGE_MODEL", "web_search")
	RecognizerIntent.PutExtra("android.speech.extra.MAX_RESULTS", 1)

	Dim Event As Object = JO.CreateEvent("android.speech.RecognitionListener", "Received", "")
	JO.RunMethod("setRecognitionListener", Array(Event))

	Initialized = True
End Sub

Public Sub IsInitialized As Boolean
	Return Initialized
End Sub

Public Sub IsRecognitionAvailable As Boolean
	Dim JO1 As JavaObject
	JO1.InitializeContext
	Return JO.RunMethod("isRecognitionAvailable", Array(JO1))
End Sub

Public Sub StartListening
	JO.RunMethod("startListening", Array(RecognizerIntent))
End Sub

Public Sub StopListening
	JO.RunMethod("stopListening", Null)
End Sub

Public Sub Destroy
	JO.RunMethod("destroy", Null)
End Sub

Private Sub Received_Event (MethodName As String, Args() As Object) As Object
	Select MethodName
		Case "onResults"
			Dim Results As JavaObject = Args(0)
			Dim Matches As List = Results.RunMethod("getStringArrayList", Array("results_recognition"))
			If Matches.Size > 0 Then
				Dim Text As String = Matches.Get(0)
				Log("语音识别内容: " & Text)
				CallSub2(TargetModule, "SpeechRecognition_Result", Text)
			End If
		Case "onError"
			Log("语音识别出错")
			CallSub2(TargetModule, "SpeechRecognition_Error", Args(0))
	End Select

	Return Null ' ⭐ 加上这一行！确保所有路径都有返回
End Sub

