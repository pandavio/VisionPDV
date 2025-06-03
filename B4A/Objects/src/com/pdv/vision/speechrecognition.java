package com.pdv.vision;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class speechrecognition extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.pdv.vision.speechrecognition");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.pdv.vision.speechrecognition.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.JavaObject _jo = null;
public anywheresoftware.b4a.objects.IntentWrapper _recognizerintent = null;
public boolean _initialized = false;
public Object _targetmodule = null;
public com.pdv.vision.main _main = null;
public com.pdv.vision.starter _starter = null;
public com.pdv.vision.b4xpages _b4xpages = null;
public com.pdv.vision.b4xcollections _b4xcollections = null;
public com.pdv.vision.httputils2service _httputils2service = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private JO As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 4;BA.debugLine="Private RecognizerIntent As Intent";
_recognizerintent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private Initialized As Boolean";
_initialized = false;
 //BA.debugLineNum = 7;BA.debugLine="Private TargetModule As Object ' 新增：保存回调的页面（B4XMa";
_targetmodule = new Object();
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public String  _destroy() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Public Sub Destroy";
 //BA.debugLineNum = 55;BA.debugLine="JO.RunMethod(\"destroy\", Null)";
_jo.RunMethod("destroy",(Object[])(__c.Null));
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _target) throws Exception{
innerInitialize(_ba);
anywheresoftware.b4j.object.JavaObject _ctx = null;
Object _event = null;
 //BA.debugLineNum = 11;BA.debugLine="Public Sub Initialize(Target As Object)";
 //BA.debugLineNum = 12;BA.debugLine="TargetModule = Target";
_targetmodule = _target;
 //BA.debugLineNum = 14;BA.debugLine="JO.InitializeStatic(\"android.speech.SpeechRecogni";
_jo.InitializeStatic("android.speech.SpeechRecognizer");
 //BA.debugLineNum = 15;BA.debugLine="Dim ctx As JavaObject";
_ctx = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 16;BA.debugLine="ctx.InitializeContext";
_ctx.InitializeContext(ba);
 //BA.debugLineNum = 17;BA.debugLine="JO = JO.RunMethod(\"createSpeechRecognizer\", Array";
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_jo.RunMethod("createSpeechRecognizer",new Object[]{(Object)(_ctx.getObject())})));
 //BA.debugLineNum = 19;BA.debugLine="If Not(IsRecognitionAvailable) Then";
if (__c.Not(_isrecognitionavailable())) { 
 //BA.debugLineNum = 20;BA.debugLine="Log(\"Speech Recognition Not Available\")";
__c.LogImpl("76160393","Speech Recognition Not Available",0);
 //BA.debugLineNum = 21;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 24;BA.debugLine="RecognizerIntent.Initialize(\"android.speech.actio";
_recognizerintent.Initialize("android.speech.action.RECOGNIZE_SPEECH",BA.ObjectToString(__c.Null));
 //BA.debugLineNum = 25;BA.debugLine="RecognizerIntent.PutExtra(\"android.speech.extra.L";
_recognizerintent.PutExtra("android.speech.extra.LANGUAGE_PREFERENCE",(Object)("en"));
 //BA.debugLineNum = 26;BA.debugLine="RecognizerIntent.PutExtra(\"calling_package\", Appl";
_recognizerintent.PutExtra("calling_package",(Object)(__c.Application.getPackageName()));
 //BA.debugLineNum = 27;BA.debugLine="RecognizerIntent.PutExtra(\"android.speech.extra.L";
_recognizerintent.PutExtra("android.speech.extra.LANGUAGE_MODEL",(Object)("web_search"));
 //BA.debugLineNum = 28;BA.debugLine="RecognizerIntent.PutExtra(\"android.speech.extra.M";
_recognizerintent.PutExtra("android.speech.extra.MAX_RESULTS",(Object)(1));
 //BA.debugLineNum = 30;BA.debugLine="Dim Event As Object = JO.CreateEvent(\"android.spe";
_event = _jo.CreateEvent(ba,"android.speech.RecognitionListener","Received",(Object)(""));
 //BA.debugLineNum = 31;BA.debugLine="JO.RunMethod(\"setRecognitionListener\", Array(Even";
_jo.RunMethod("setRecognitionListener",new Object[]{_event});
 //BA.debugLineNum = 33;BA.debugLine="Initialized = True";
_initialized = __c.True;
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public boolean  _isinitialized() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Public Sub IsInitialized As Boolean";
 //BA.debugLineNum = 37;BA.debugLine="Return Initialized";
if (true) return _initialized;
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return false;
}
public boolean  _isrecognitionavailable() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo1 = null;
 //BA.debugLineNum = 40;BA.debugLine="Public Sub IsRecognitionAvailable As Boolean";
 //BA.debugLineNum = 41;BA.debugLine="Dim JO1 As JavaObject";
_jo1 = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 42;BA.debugLine="JO1.InitializeContext";
_jo1.InitializeContext(ba);
 //BA.debugLineNum = 43;BA.debugLine="Return JO.RunMethod(\"isRecognitionAvailable\", Arr";
if (true) return BA.ObjectToBoolean(_jo.RunMethod("isRecognitionAvailable",new Object[]{(Object)(_jo1.getObject())}));
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return false;
}
public Object  _received_event(String _methodname,Object[] _args) throws Exception{
anywheresoftware.b4j.object.JavaObject _results = null;
anywheresoftware.b4a.objects.collections.List _matches = null;
String _text = "";
 //BA.debugLineNum = 58;BA.debugLine="Private Sub Received_Event (MethodName As String,";
 //BA.debugLineNum = 59;BA.debugLine="Select MethodName";
switch (BA.switchObjectToInt(_methodname,"onResults","onError")) {
case 0: {
 //BA.debugLineNum = 61;BA.debugLine="Dim Results As JavaObject = Args(0)";
_results = new anywheresoftware.b4j.object.JavaObject();
_results = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_args[(int) (0)]));
 //BA.debugLineNum = 62;BA.debugLine="Dim Matches As List = Results.RunMethod(\"getStr";
_matches = new anywheresoftware.b4a.objects.collections.List();
_matches = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_results.RunMethod("getStringArrayList",new Object[]{(Object)("results_recognition")})));
 //BA.debugLineNum = 63;BA.debugLine="If Matches.Size > 0 Then";
if (_matches.getSize()>0) { 
 //BA.debugLineNum = 64;BA.debugLine="Dim Text As String = Matches.Get(0)";
_text = BA.ObjectToString(_matches.Get((int) (0)));
 //BA.debugLineNum = 65;BA.debugLine="Log(\"语音识别内容: \" & Text)";
__c.LogImpl("76553607","语音识别内容: "+_text,0);
 //BA.debugLineNum = 66;BA.debugLine="CallSub2(TargetModule, \"SpeechRecognition_Resu";
__c.CallSubNew2(ba,_targetmodule,"SpeechRecognition_Result",(Object)(_text));
 };
 break; }
case 1: {
 //BA.debugLineNum = 69;BA.debugLine="Log(\"语音识别出错\")";
__c.LogImpl("76553611","语音识别出错",0);
 //BA.debugLineNum = 70;BA.debugLine="CallSub2(TargetModule, \"SpeechRecognition_Error";
__c.CallSubNew2(ba,_targetmodule,"SpeechRecognition_Error",_args[(int) (0)]);
 break; }
}
;
 //BA.debugLineNum = 73;BA.debugLine="Return Null ' ⭐ 加上这一行！确保所有路径都有返回";
if (true) return __c.Null;
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return null;
}
public String  _startlistening() throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Public Sub StartListening";
 //BA.debugLineNum = 47;BA.debugLine="JO.RunMethod(\"startListening\", Array(RecognizerIn";
_jo.RunMethod("startListening",new Object[]{(Object)(_recognizerintent.getObject())});
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public String  _stoplistening() throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Public Sub StopListening";
 //BA.debugLineNum = 51;BA.debugLine="JO.RunMethod(\"stopListening\", Null)";
_jo.RunMethod("stopListening",(Object[])(__c.Null));
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
