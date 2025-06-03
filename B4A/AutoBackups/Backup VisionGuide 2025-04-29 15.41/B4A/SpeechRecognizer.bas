B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=5.5
@EndOfDesignText@
' Class module
Sub Class_Globals
	Private sr As JavaObject
	Private mEventName As String
	Private mTarget As Object
End Sub

Public Sub Initialize (TargetModule As Object, EventName As String)
	mTarget = TargetModule
	mEventName = EventName
	sr = CreateSpeechRecognizer
    
	Dim listener As Object = sr.CreateEvent("android.speech.RecognitionListener", mEventName, Null)
	sr.RunMethod("setRecognitionListener", Array(listener))
	Log("✅ RecognitionListener 已绑定")
End Sub

Private Sub CreateSpeechRecognizer As JavaObject
	Dim ctxt As JavaObject
	ctxt.InitializeContext
	Dim sr As JavaObject
	sr = sr.InitializeStatic("android.speech.SpeechRecognizer").RunMethod("createSpeechRecognizer", Array(ctxt))
    
	' 加上 RecognitionListener
	Dim event As Object = sr.CreateEvent("android.speech.RecognitionListener", "sr", Null)
	sr.RunMethod("setRecognitionListener", Array(event))
    
	Return sr
End Sub


Public Sub IsSupported As Boolean
	Dim ctxt As JavaObject
	ctxt.InitializeContext
	Dim intent As Intent
	intent.Initialize("android.speech.RecognitionService", "")
	Dim services As List = ctxt.RunMethodJO("getPackageManager", Null).RunMethod("queryIntentServices", Array(intent, 0))
	Return services.Size > 0
End Sub

Public Sub Listen
	Dim intent As Intent
	intent.Initialize("android.speech.action.RECOGNIZE_SPEECH", "")
	intent.PutExtra("android.speech.extra.LANGUAGE_MODEL", "free_form")
	intent.PutExtra("android.speech.extra.MAX_RESULTS", 5)
	sr.RunMethod("startListening", Array(intent))
	Log("🎤 正在监听语音输入...")
End Sub

Public Sub StopListening
	sr.RunMethod("stopListening", Null)
End Sub

Public Sub Cancel
	sr.RunMethod("cancel", Null)
End Sub
