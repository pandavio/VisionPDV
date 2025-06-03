package com.pdv.vision;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.pdv.vision.b4xmainpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.pdv.vision.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public String _serverurl = "";
public String _serverpingurl = "";
public String _googleapikey = "";
public com.pdv.vision.camex2 _cam = null;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public anywheresoftware.b4a.objects.StringUtils _su = null;
public anywheresoftware.b4a.obejcts.TTS _tts1 = null;
public int _mytaskindex = 0;
public com.pdv.vision.speechrecognition _speech = null;
public anywheresoftware.b4a.objects.Timer _autotimer = null;
public boolean _isprocessing = false;
public String _lastdescription = "";
public uk.co.martinpearman.b4a.fusedlocationprovider.FusedLocationProviderWrapper _flp = null;
public anywheresoftware.b4a.objects.Timer _locationtimer = null;
public String _currentaddress = "";
public boolean _shouldrequestaddressonnextlocation = false;
public boolean _shouldspeakaddressonnextlocation = false;
public String _currentmode = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbltop = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllocation = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlpreview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnoutmode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btninmode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnomode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnstopall = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblaititle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblresponsetxt = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnvoiceask = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncapture = null;
public com.pdv.vision.main _main = null;
public com.pdv.vision.starter _starter = null;
public com.pdv.vision.b4xpages _b4xpages = null;
public com.pdv.vision.b4xcollections _b4xcollections = null;
public com.pdv.vision.httputils2service _httputils2service = null;
public String  _autotimer_tick() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Sub autoTimer_Tick";
 //BA.debugLineNum = 123;BA.debugLine="If isProcessing Then Return";
if (_isprocessing) { 
if (true) return "";};
 //BA.debugLineNum = 124;BA.debugLine="isProcessing = True";
_isprocessing = __c.True;
 //BA.debugLineNum = 125;BA.debugLine="TakeAndSendPicture(\"请描述前方\")";
_takeandsendpicture("请描述前方");
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public void  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
ResumableSub_B4XPage_Created rsub = new ResumableSub_B4XPage_Created(this,_root1);
rsub.resume(ba, null);
}
public static class ResumableSub_B4XPage_Created extends BA.ResumableSub {
public ResumableSub_B4XPage_Created(com.pdv.vision.b4xmainpage parent,anywheresoftware.b4a.objects.B4XViewWrapper _root1) {
this.parent = parent;
this._root1 = _root1;
}
com.pdv.vision.b4xmainpage parent;
anywheresoftware.b4a.objects.B4XViewWrapper _root1;
String _permission = "";
boolean _result = false;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 51;BA.debugLine="Root = Root1";
parent._root = _root1;
 //BA.debugLineNum = 52;BA.debugLine="Root.LoadLayout(\"MainPage\")";
parent._root.LoadLayout("MainPage",ba);
 //BA.debugLineNum = 54;BA.debugLine="ReadApiKeysFromConfig";
parent._readapikeysfromconfig();
 //BA.debugLineNum = 56;BA.debugLine="WakeupServer";
parent._wakeupserver();
 //BA.debugLineNum = 58;BA.debugLine="UpdateButtonColors(btnStopAll)";
parent._updatebuttoncolors(parent._btnstopall);
 //BA.debugLineNum = 60;BA.debugLine="speech.Initialize(Me)";
parent._speech._initialize /*String*/ (ba,parent);
 //BA.debugLineNum = 61;BA.debugLine="TTS1.Initialize(\"TTS1\")";
parent._tts1.Initialize(ba,"TTS1");
 //BA.debugLineNum = 63;BA.debugLine="autoTimer.Initialize(\"autoTimer\", 5000)";
parent._autotimer.Initialize(ba,"autoTimer",(long) (5000));
 //BA.debugLineNum = 64;BA.debugLine="autoTimer.Enabled = False";
parent._autotimer.setEnabled(parent.__c.False);
 //BA.debugLineNum = 66;BA.debugLine="locationTimer.Initialize(\"locationTimer\", 5 * 60";
parent._locationtimer.Initialize(ba,"locationTimer",(long) (5*60*1000));
 //BA.debugLineNum = 67;BA.debugLine="locationTimer.Enabled = True";
parent._locationtimer.setEnabled(parent.__c.True);
 //BA.debugLineNum = 70;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_RECORD_AUDIO)";
parent._rp.CheckAndRequest(ba,parent._rp.PERMISSION_RECORD_AUDIO);
 //BA.debugLineNum = 71;BA.debugLine="Wait For B4XPage_PermissionResult(Permission As S";
parent.__c.WaitFor("b4xpage_permissionresult", ba, this, null);
this.state = 15;
return;
case 15:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 72;BA.debugLine="If Permission = rp.PERMISSION_RECORD_AUDIO And Re";
if (true) break;

case 1:
//if
this.state = 4;
if ((_permission).equals(parent._rp.PERMISSION_RECORD_AUDIO) && _result==parent.__c.False) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 73;BA.debugLine="ToastMessageShow(\"未授权麦克风权限，语音功能将不可用\", True)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence("未授权麦克风权限，语音功能将不可用"),parent.__c.True);
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 77;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_ACCESS_FINE_LOCA";
parent._rp.CheckAndRequest(ba,parent._rp.PERMISSION_ACCESS_FINE_LOCATION);
 //BA.debugLineNum = 78;BA.debugLine="Wait For B4XPage_PermissionResult(Permission As S";
parent.__c.WaitFor("b4xpage_permissionresult", ba, this, null);
this.state = 16;
return;
case 16:
//C
this.state = 5;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 79;BA.debugLine="If Result Then";
if (true) break;

case 5:
//if
this.state = 10;
if (_result) { 
this.state = 7;
}else {
this.state = 9;
}if (true) break;

case 7:
//C
this.state = 10;
 //BA.debugLineNum = 80;BA.debugLine="InitLocationService";
parent._initlocationservice();
 if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 82;BA.debugLine="ToastMessageShow(\"未授权位置权限，无法定位\", False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence("未授权位置权限，无法定位"),parent.__c.False);
 if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 86;BA.debugLine="Wait For (InitCamera) Complete (Success As Boolea";
parent.__c.WaitFor("complete", ba, this, parent._initcamera());
this.state = 17;
return;
case 17:
//C
this.state = 11;
_success = (Boolean) result[0];
;
 //BA.debugLineNum = 87;BA.debugLine="If Success = False Then";
if (true) break;

case 11:
//if
this.state = 14;
if (_success==parent.__c.False) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 88;BA.debugLine="ToastMessageShow(\"相机启动失败\", True)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence("相机启动失败"),parent.__c.True);
 if (true) break;

case 14:
//C
this.state = -1;
;
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _b4xpage_permissionresult(String _permission,boolean _result) throws Exception{
}
public void  _complete(boolean _success) throws Exception{
}
public String  _btncapture_click() throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Private Sub btnCapture_Click";
 //BA.debugLineNum = 142;BA.debugLine="UpdateButtonColors(btnCapture)";
_updatebuttoncolors(_btncapture);
 //BA.debugLineNum = 143;BA.debugLine="If isProcessing Then Return";
if (_isprocessing) { 
if (true) return "";};
 //BA.debugLineNum = 144;BA.debugLine="isProcessing = True";
_isprocessing = __c.True;
 //BA.debugLineNum = 145;BA.debugLine="TakeAndSendPicture(\"请描述前方\")";
_takeandsendpicture("请描述前方");
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public String  _btninmode_click() throws Exception{
 //BA.debugLineNum = 211;BA.debugLine="Private Sub btnInMode_Click";
 //BA.debugLineNum = 212;BA.debugLine="UpdateButtonColors(btnInMode)";
_updatebuttoncolors(_btninmode);
 //BA.debugLineNum = 213;BA.debugLine="CurrentMode = \"indoor\"";
_currentmode = "indoor";
 //BA.debugLineNum = 214;BA.debugLine="autoTimer.Interval = 30000 ' 30秒自动提问";
_autotimer.setInterval((long) (30000));
 //BA.debugLineNum = 215;BA.debugLine="autoTimer.Enabled = True";
_autotimer.setEnabled(__c.True);
 //BA.debugLineNum = 216;BA.debugLine="locationTimer.Enabled = False ' 停止自动定位";
_locationtimer.setEnabled(__c.False);
 //BA.debugLineNum = 217;BA.debugLine="ToastMessageShow(\"室内商场模式已开启\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("室内商场模式已开启"),__c.False);
 //BA.debugLineNum = 218;BA.debugLine="TTS1.Speak(\"室内商场模式已开启\", False)";
_tts1.Speak("室内商场模式已开启",__c.False);
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return "";
}
public String  _btnnomode_click() throws Exception{
 //BA.debugLineNum = 221;BA.debugLine="Private Sub btnNoMode_Click";
 //BA.debugLineNum = 222;BA.debugLine="UpdateButtonColors(btnNoMode)";
_updatebuttoncolors(_btnnomode);
 //BA.debugLineNum = 223;BA.debugLine="CurrentMode = \"normal\"";
_currentmode = "normal";
 //BA.debugLineNum = 224;BA.debugLine="autoTimer.Interval = 30000";
_autotimer.setInterval((long) (30000));
 //BA.debugLineNum = 225;BA.debugLine="autoTimer.Enabled = True";
_autotimer.setEnabled(__c.True);
 //BA.debugLineNum = 226;BA.debugLine="locationTimer.Interval = 60000";
_locationtimer.setInterval((long) (60000));
 //BA.debugLineNum = 227;BA.debugLine="locationTimer.Enabled = True";
_locationtimer.setEnabled(__c.True);
 //BA.debugLineNum = 228;BA.debugLine="ToastMessageShow(\"普通综合模式已开启\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("普通综合模式已开启"),__c.False);
 //BA.debugLineNum = 229;BA.debugLine="TTS1.Speak(\"普通综合模式已开启\", False)";
_tts1.Speak("普通综合模式已开启",__c.False);
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public String  _btnoutmode_click() throws Exception{
 //BA.debugLineNum = 200;BA.debugLine="Private Sub btnOutMode_Click";
 //BA.debugLineNum = 201;BA.debugLine="UpdateButtonColors(btnOutMode)";
_updatebuttoncolors(_btnoutmode);
 //BA.debugLineNum = 202;BA.debugLine="CurrentMode = \"outdoor\"";
_currentmode = "outdoor";
 //BA.debugLineNum = 203;BA.debugLine="autoTimer.Interval = 10000 ' 10秒自动提问";
_autotimer.setInterval((long) (10000));
 //BA.debugLineNum = 204;BA.debugLine="autoTimer.Enabled = True";
_autotimer.setEnabled(__c.True);
 //BA.debugLineNum = 205;BA.debugLine="locationTimer.Interval = 60000 ' 60秒定位";
_locationtimer.setInterval((long) (60000));
 //BA.debugLineNum = 206;BA.debugLine="locationTimer.Enabled = True";
_locationtimer.setEnabled(__c.True);
 //BA.debugLineNum = 207;BA.debugLine="ToastMessageShow(\"户外街道模式已开启\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("户外街道模式已开启"),__c.False);
 //BA.debugLineNum = 208;BA.debugLine="TTS1.Speak(\"户外街道模式已开启\", False)";
_tts1.Speak("户外街道模式已开启",__c.False);
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return "";
}
public String  _btnstopall_click() throws Exception{
 //BA.debugLineNum = 240;BA.debugLine="Private Sub btnStopAll_Click";
 //BA.debugLineNum = 241;BA.debugLine="UpdateButtonColors(btnStopAll)";
_updatebuttoncolors(_btnstopall);
 //BA.debugLineNum = 242;BA.debugLine="Log(\"🛑 停止所有模式\")";
__c.LogImpl("71572866","🛑 停止所有模式",0);
 //BA.debugLineNum = 245;BA.debugLine="autoTimer.Enabled = False";
_autotimer.setEnabled(__c.False);
 //BA.debugLineNum = 246;BA.debugLine="locationTimer.Enabled = False";
_locationtimer.setEnabled(__c.False);
 //BA.debugLineNum = 249;BA.debugLine="If speech.IsInitialized Then";
if (_speech._isinitialized /*boolean*/ ()) { 
 //BA.debugLineNum = 250;BA.debugLine="Try";
try { //BA.debugLineNum = 251;BA.debugLine="speech.StopListening";
_speech._stoplistening /*String*/ ();
 } 
       catch (Exception e9) {
			ba.setLastException(e9); //BA.debugLineNum = 253;BA.debugLine="Log(LastException.Message)";
__c.LogImpl("71572877",__c.LastException(ba).getMessage(),0);
 };
 };
 //BA.debugLineNum = 258;BA.debugLine="If TTS1.IsInitialized Then";
if (_tts1.IsInitialized()) { 
 //BA.debugLineNum = 259;BA.debugLine="Try";
try { //BA.debugLineNum = 260;BA.debugLine="TTS1.Stop";
_tts1.Stop();
 } 
       catch (Exception e16) {
			ba.setLastException(e16); //BA.debugLineNum = 262;BA.debugLine="Log(LastException.Message)";
__c.LogImpl("71572886",__c.LastException(ba).getMessage(),0);
 };
 };
 //BA.debugLineNum = 267;BA.debugLine="isProcessing = False";
_isprocessing = __c.False;
 //BA.debugLineNum = 268;BA.debugLine="ToastMessageShow(\"所有功能已暂停\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("所有功能已暂停"),__c.False);
 //BA.debugLineNum = 269;BA.debugLine="TTS1.Speak(\"所有功能已暂停\", False)";
_tts1.Speak("所有功能已暂停",__c.False);
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
return "";
}
public String  _btnvoiceask_click() throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Private Sub btnVoiceAsk_Click";
 //BA.debugLineNum = 129;BA.debugLine="UpdateButtonColors(btnVoiceAsk)";
_updatebuttoncolors(_btnvoiceask);
 //BA.debugLineNum = 130;BA.debugLine="If speech.IsInitialized Then";
if (_speech._isinitialized /*boolean*/ ()) { 
 //BA.debugLineNum = 131;BA.debugLine="speech.StartListening";
_speech._startlistening /*String*/ ();
 }else {
 //BA.debugLineNum = 133;BA.debugLine="ToastMessageShow(\"语音识别未初始化\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("语音识别未初始化"),__c.False);
 };
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private ServerUrl As String";
_serverurl = "";
 //BA.debugLineNum = 10;BA.debugLine="Private ServerPingUrl As String";
_serverpingurl = "";
 //BA.debugLineNum = 11;BA.debugLine="Private GoogleApiKey As String";
_googleapikey = "";
 //BA.debugLineNum = 12;BA.debugLine="Private cam As CamEx2";
_cam = new com.pdv.vision.camex2();
 //BA.debugLineNum = 13;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 14;BA.debugLine="Private su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 15;BA.debugLine="Private TTS1 As TTS";
_tts1 = new anywheresoftware.b4a.obejcts.TTS();
 //BA.debugLineNum = 16;BA.debugLine="Private MyTaskIndex As Int";
_mytaskindex = 0;
 //BA.debugLineNum = 17;BA.debugLine="Private speech As SpeechRecognition";
_speech = new com.pdv.vision.speechrecognition();
 //BA.debugLineNum = 18;BA.debugLine="Private autoTimer As Timer";
_autotimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 20;BA.debugLine="Private isProcessing As Boolean = False";
_isprocessing = __c.False;
 //BA.debugLineNum = 21;BA.debugLine="Private lastDescription As String = \"\"";
_lastdescription = "";
 //BA.debugLineNum = 23;BA.debugLine="Private flp As FusedLocationProvider";
_flp = new uk.co.martinpearman.b4a.fusedlocationprovider.FusedLocationProviderWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private locationTimer As Timer";
_locationtimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 25;BA.debugLine="Private currentAddress As String = \"\"";
_currentaddress = "";
 //BA.debugLineNum = 26;BA.debugLine="Private ShouldRequestAddressOnNextLocation As Boo";
_shouldrequestaddressonnextlocation = __c.False;
 //BA.debugLineNum = 27;BA.debugLine="Private ShouldSpeakAddressOnNextLocation As Boole";
_shouldspeakaddressonnextlocation = __c.False;
 //BA.debugLineNum = 28;BA.debugLine="Private CurrentMode As String = \"normal\" ' \"outdo";
_currentmode = "normal";
 //BA.debugLineNum = 31;BA.debugLine="Private lblTop As Label";
_lbltop = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private lblLocation As Label";
_lbllocation = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private pnlPreview As Panel";
_pnlpreview = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private btnOutMode As Button";
_btnoutmode = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private btnInMode As Button";
_btninmode = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private btnNoMode As Button";
_btnnomode = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private btnStopAll As Button";
_btnstopall = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private lblAiTitle As Label";
_lblaititle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private lblResponseTxt As Label";
_lblresponsetxt = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private btnVoiceAsk As Button";
_btnvoiceask = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private btnCapture As Button";
_btncapture = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _flp_connectionfailed(int _connectionresult1) throws Exception{
 //BA.debugLineNum = 347;BA.debugLine="Sub flp_ConnectionFailed(ConnectionResult1 As Int)";
 //BA.debugLineNum = 348;BA.debugLine="Log(\"FLP连接失败\")";
__c.LogImpl("72031617","FLP连接失败",0);
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return "";
}
public String  _flp_connectionsuccess() throws Exception{
uk.co.martinpearman.b4a.fusedlocationprovider.LocationRequest _lr = null;
 //BA.debugLineNum = 339;BA.debugLine="Sub flp_ConnectionSuccess";
 //BA.debugLineNum = 340;BA.debugLine="Log(\"FLP连接成功\")";
__c.LogImpl("71966081","FLP连接成功",0);
 //BA.debugLineNum = 341;BA.debugLine="Dim lr As LocationRequest";
_lr = new uk.co.martinpearman.b4a.fusedlocationprovider.LocationRequest();
 //BA.debugLineNum = 342;BA.debugLine="lr.Initialize";
_lr.Initialize();
 //BA.debugLineNum = 343;BA.debugLine="lr.SetInterval(0)";
_lr.SetInterval((long) (0));
 //BA.debugLineNum = 344;BA.debugLine="flp.RequestLocationUpdates(lr)";
_flp.RequestLocationUpdates((com.google.android.gms.location.LocationRequest)(_lr.getObject()));
 //BA.debugLineNum = 345;BA.debugLine="End Sub";
return "";
}
public String  _flp_connectionsuspended() throws Exception{
 //BA.debugLineNum = 351;BA.debugLine="Sub flp_ConnectionSuspended";
 //BA.debugLineNum = 352;BA.debugLine="Log(\"FLP连接挂起\")";
__c.LogImpl("72097153","FLP连接挂起",0);
 //BA.debugLineNum = 353;BA.debugLine="End Sub";
return "";
}
public String  _flp_locationchanged(anywheresoftware.b4a.gps.LocationWrapper _location1) throws Exception{
double _lat = 0;
double _lon = 0;
 //BA.debugLineNum = 355;BA.debugLine="Sub flp_LocationChanged(Location1 As Location)";
 //BA.debugLineNum = 356;BA.debugLine="Dim lat As Double = Location1.Latitude";
_lat = _location1.getLatitude();
 //BA.debugLineNum = 357;BA.debugLine="Dim lon As Double = Location1.Longitude";
_lon = _location1.getLongitude();
 //BA.debugLineNum = 358;BA.debugLine="Log($\"当前位置: ${lat}, ${lon}\"$)";
__c.LogImpl("72162691",("当前位置: "+__c.SmartStringFormatter("",(Object)(_lat))+", "+__c.SmartStringFormatter("",(Object)(_lon))+""),0);
 //BA.debugLineNum = 361;BA.debugLine="If ShouldRequestAddressOnNextLocation Then";
if (_shouldrequestaddressonnextlocation) { 
 //BA.debugLineNum = 362;BA.debugLine="ShouldRequestAddressOnNextLocation = False";
_shouldrequestaddressonnextlocation = __c.False;
 //BA.debugLineNum = 363;BA.debugLine="RequestGeoAddress(lat, lon, ShouldSpeakAddressOn";
_requestgeoaddress(_lat,_lon,_shouldspeakaddressonnextlocation);
 }else {
 //BA.debugLineNum = 365;BA.debugLine="RequestGeoAddress(lat, lon, False) ' 每次更新都显示地址，但";
_requestgeoaddress(_lat,_lon,__c.False);
 };
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return "";
}
public void  _handlebackpressed(boolean _ignore) throws Exception{
ResumableSub_HandleBackPressed rsub = new ResumableSub_HandleBackPressed(this,_ignore);
rsub.resume(ba, null);
}
public static class ResumableSub_HandleBackPressed extends BA.ResumableSub {
public ResumableSub_HandleBackPressed(com.pdv.vision.b4xmainpage parent,boolean _ignore) {
this.parent = parent;
this._ignore = _ignore;
}
com.pdv.vision.b4xmainpage parent;
boolean _ignore;
Object _sf = null;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 273;BA.debugLine="Dim sf As Object = xui.Msgbox2Async(\"你确定要退出应用吗？\",";
_sf = parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence("你确定要退出应用吗？"),BA.ObjectToCharSequence("退出应用"),"是","取消","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null)));
 //BA.debugLineNum = 274;BA.debugLine="Wait For (sf) Msgbox_Result (Result As Int)";
parent.__c.WaitFor("msgbox_result", ba, this, _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 275;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 276;BA.debugLine="ExitApplication";
parent.__c.ExitApplication();
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _initcamera() throws Exception{
ResumableSub_InitCamera rsub = new ResumableSub_InitCamera(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_InitCamera extends BA.ResumableSub {
public ResumableSub_InitCamera(com.pdv.vision.b4xmainpage parent) {
this.parent = parent;
}
com.pdv.vision.b4xmainpage parent;
boolean _success = false;
String _permission = "";
boolean _result = false;
int _taskindex = 0;
boolean _preparesuccess = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 93;BA.debugLine="Dim Success As Boolean = False";
_success = parent.__c.False;
 //BA.debugLineNum = 94;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CAMERA)";
parent._rp.CheckAndRequest(ba,parent._rp.PERMISSION_CAMERA);
 //BA.debugLineNum = 95;BA.debugLine="Wait For B4XPage_PermissionResult(Permission As S";
parent.__c.WaitFor("b4xpage_permissionresult", ba, this, null);
this.state = 15;
return;
case 15:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 96;BA.debugLine="If Result = False Then Return False";
if (true) break;

case 1:
//if
this.state = 6;
if (_result==parent.__c.False) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 98;BA.debugLine="cam.Initialize(pnlPreview)";
parent._cam._initialize /*String*/ (ba,parent._pnlpreview);
 //BA.debugLineNum = 99;BA.debugLine="Wait For(cam.OpenCamera(False)) Complete (TaskInd";
parent.__c.WaitFor("complete", ba, this, parent._cam._opencamera /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent.__c.False));
this.state = 16;
return;
case 16:
//C
this.state = 7;
_taskindex = (Integer) result[0];
;
 //BA.debugLineNum = 100;BA.debugLine="If TaskIndex > 0 Then";
if (true) break;

case 7:
//if
this.state = 14;
if (_taskindex>0) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 101;BA.debugLine="MyTaskIndex = TaskIndex";
parent._mytaskindex = _taskindex;
 //BA.debugLineNum = 102;BA.debugLine="Wait For(cam.PrepareSurface(MyTaskIndex)) Comple";
parent.__c.WaitFor("complete", ba, this, parent._cam._preparesurface /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent._mytaskindex));
this.state = 17;
return;
case 17:
//C
this.state = 10;
_preparesuccess = (Boolean) result[0];
;
 //BA.debugLineNum = 103;BA.debugLine="If PrepareSuccess Then";
if (true) break;

case 10:
//if
this.state = 13;
if (_preparesuccess) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 104;BA.debugLine="cam.StartPreview(MyTaskIndex, False)";
parent._cam._startpreview /*String*/ (parent._mytaskindex,parent.__c.False);
 //BA.debugLineNum = 105;BA.debugLine="Success = True";
_success = parent.__c.True;
 if (true) break;

case 13:
//C
this.state = 14;
;
 if (true) break;

case 14:
//C
this.state = -1;
;
 //BA.debugLineNum = 108;BA.debugLine="Return Success";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_success));return;};
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 47;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public String  _initlocationservice() throws Exception{
 //BA.debugLineNum = 334;BA.debugLine="Private Sub InitLocationService";
 //BA.debugLineNum = 335;BA.debugLine="flp.Initialize(\"flp\")";
_flp.Initialize(ba,"flp");
 //BA.debugLineNum = 336;BA.debugLine="flp.Connect";
_flp.Connect();
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return "";
}
public String  _jobdone(com.pdv.vision.httpjob _job) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _georoot = null;
anywheresoftware.b4a.objects.collections.List _results = null;
anywheresoftware.b4a.objects.collections.Map _result = null;
anywheresoftware.b4a.objects.collections.Map _responsemap = null;
String _desc = "";
 //BA.debugLineNum = 389;BA.debugLine="Sub JobDone(job As HttpJob)";
 //BA.debugLineNum = 390;BA.debugLine="If job.JobName = \"Wakeup\" Then";
if ((_job._jobname /*String*/ ).equals("Wakeup")) { 
 //BA.debugLineNum = 391;BA.debugLine="Log(\"✅ Render服务器唤醒完成\")";
__c.LogImpl("72293762","✅ Render服务器唤醒完成",0);
 //BA.debugLineNum = 392;BA.debugLine="job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 393;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 396;BA.debugLine="If job.JobName = \"GeoAddress\" Then";
if ((_job._jobname /*String*/ ).equals("GeoAddress")) { 
 //BA.debugLineNum = 397;BA.debugLine="If job.Success Then";
if (_job._success /*boolean*/ ) { 
 //BA.debugLineNum = 398;BA.debugLine="Try";
try { //BA.debugLineNum = 399;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 400;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ ());
 //BA.debugLineNum = 401;BA.debugLine="Dim geoRoot As Map = parser.NextObject";
_georoot = new anywheresoftware.b4a.objects.collections.Map();
_georoot = _parser.NextObject();
 //BA.debugLineNum = 402;BA.debugLine="Dim results As List = geoRoot.Get(\"results\")";
_results = new anywheresoftware.b4a.objects.collections.List();
_results = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_georoot.Get((Object)("results"))));
 //BA.debugLineNum = 403;BA.debugLine="If results.Size > 0 Then";
if (_results.getSize()>0) { 
 //BA.debugLineNum = 404;BA.debugLine="Dim result As Map = results.Get(0)";
_result = new anywheresoftware.b4a.objects.collections.Map();
_result = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_results.Get((int) (0))));
 //BA.debugLineNum = 405;BA.debugLine="currentAddress = result.Get(\"formatted_addres";
_currentaddress = BA.ObjectToString(_result.Get((Object)("formatted_address")));
 //BA.debugLineNum = 406;BA.debugLine="lblLocation.Text = \"地址：\" & currentAddress";
_lbllocation.setText(BA.ObjectToCharSequence("地址："+_currentaddress));
 //BA.debugLineNum = 407;BA.debugLine="Log(\"定位到：\" & currentAddress)";
__c.LogImpl("72293778","定位到："+_currentaddress,0);
 //BA.debugLineNum = 408;BA.debugLine="If job.Tag = True Then";
if ((_job._tag /*Object*/ ).equals((Object)(__c.True))) { 
 //BA.debugLineNum = 409;BA.debugLine="TTS1.Speak(\"你现在在 \" & currentAddress, False)";
_tts1.Speak("你现在在 "+_currentaddress,__c.False);
 };
 };
 } 
       catch (Exception e23) {
			ba.setLastException(e23); //BA.debugLineNum = 413;BA.debugLine="Log(\"地址解析失败：\" & LastException.Message)";
__c.LogImpl("72293784","地址解析失败："+__c.LastException(ba).getMessage(),0);
 };
 }else {
 //BA.debugLineNum = 416;BA.debugLine="Log(\"Geo定位请求失败: \" & job.ErrorMessage)";
__c.LogImpl("72293787","Geo定位请求失败: "+_job._errormessage /*String*/ ,0);
 };
 //BA.debugLineNum = 418;BA.debugLine="job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 419;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 422;BA.debugLine="If job.Success Then";
if (_job._success /*boolean*/ ) { 
 //BA.debugLineNum = 423;BA.debugLine="Try";
try { //BA.debugLineNum = 424;BA.debugLine="Log(\"服务器返回：\" & job.GetString)";
__c.LogImpl("72293795","服务器返回："+_job._getstring /*String*/ (),0);
 //BA.debugLineNum = 425;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 426;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ ());
 //BA.debugLineNum = 427;BA.debugLine="Dim responseMap As Map = parser.NextObject";
_responsemap = new anywheresoftware.b4a.objects.collections.Map();
_responsemap = _parser.NextObject();
 //BA.debugLineNum = 428;BA.debugLine="Dim desc As String";
_desc = "";
 //BA.debugLineNum = 429;BA.debugLine="If responseMap.ContainsKey(\"answer\") Then";
if (_responsemap.ContainsKey((Object)("answer"))) { 
 //BA.debugLineNum = 430;BA.debugLine="desc = responseMap.Get(\"answer\")";
_desc = BA.ObjectToString(_responsemap.Get((Object)("answer")));
 }else {
 //BA.debugLineNum = 432;BA.debugLine="Log(\"⚠️ answer字段未找到\")";
__c.LogImpl("72293803","⚠️ answer字段未找到",0);
 //BA.debugLineNum = 433;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 436;BA.debugLine="If desc.Trim.Length > 0 Then";
if (_desc.trim().length()>0) { 
 //BA.debugLineNum = 437;BA.debugLine="If desc <> lastDescription Then";
if ((_desc).equals(_lastdescription) == false) { 
 //BA.debugLineNum = 438;BA.debugLine="lastDescription = desc";
_lastdescription = _desc;
 //BA.debugLineNum = 439;BA.debugLine="lblResponseTxt.Text = desc";
_lblresponsetxt.setText(BA.ObjectToCharSequence(_desc));
 //BA.debugLineNum = 440;BA.debugLine="Log(\"服务器返回：\" & desc)";
__c.LogImpl("72293811","服务器返回："+_desc,0);
 //BA.debugLineNum = 441;BA.debugLine="UpdateButtonColors(btnStopAll) ' ✅ 播报前恢复按钮颜色";
_updatebuttoncolors(_btnstopall);
 //BA.debugLineNum = 442;BA.debugLine="TTS1.Speak(desc, False)";
_tts1.Speak(_desc,__c.False);
 //BA.debugLineNum = 443;BA.debugLine="ToastMessageShow(desc, False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_desc),__c.False);
 }else {
 //BA.debugLineNum = 445;BA.debugLine="Log(\"⚠️ 跳过重复回答\")";
__c.LogImpl("72293816","⚠️ 跳过重复回答",0);
 };
 }else {
 //BA.debugLineNum = 448;BA.debugLine="ToastMessageShow(\"无回答内容\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("无回答内容"),__c.False);
 };
 } 
       catch (Exception e59) {
			ba.setLastException(e59); //BA.debugLineNum = 451;BA.debugLine="Log(\"解析失败：\" & LastException.Message)";
__c.LogImpl("72293822","解析失败："+__c.LastException(ba).getMessage(),0);
 //BA.debugLineNum = 452;BA.debugLine="ToastMessageShow(\"AI返回解析失败\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("AI返回解析失败"),__c.False);
 };
 }else {
 //BA.debugLineNum = 455;BA.debugLine="Log(\"上传失败: \" & job.ErrorMessage)";
__c.LogImpl("72293826","上传失败: "+_job._errormessage /*String*/ ,0);
 //BA.debugLineNum = 456;BA.debugLine="ToastMessageShow(\"上传失败，请检查网络\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("上传失败，请检查网络"),__c.False);
 };
 //BA.debugLineNum = 458;BA.debugLine="job.Release";
_job._release /*String*/ ();
 //BA.debugLineNum = 459;BA.debugLine="isProcessing = False";
_isprocessing = __c.False;
 //BA.debugLineNum = 460;BA.debugLine="End Sub";
return "";
}
public String  _lblresponsetxt_click() throws Exception{
 //BA.debugLineNum = 232;BA.debugLine="Private Sub lblResponseTxt_Click";
 //BA.debugLineNum = 233;BA.debugLine="If lastDescription.Trim.Length > 0 Then";
if (_lastdescription.trim().length()>0) { 
 //BA.debugLineNum = 234;BA.debugLine="TTS1.Speak(lastDescription, False)";
_tts1.Speak(_lastdescription,__c.False);
 }else {
 //BA.debugLineNum = 236;BA.debugLine="ToastMessageShow(\"当前没有内容可重播\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("当前没有内容可重播"),__c.False);
 };
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public String  _locationtimer_tick() throws Exception{
 //BA.debugLineNum = 280;BA.debugLine="Private Sub locationTimer_Tick";
 //BA.debugLineNum = 281;BA.debugLine="If CurrentMode = \"outdoor\" Or CurrentMode = \"norm";
if ((_currentmode).equals("outdoor") || (_currentmode).equals("normal")) { 
 //BA.debugLineNum = 282;BA.debugLine="RequestCurrentAddress(False) ' 不播报地址";
_requestcurrentaddress(__c.False);
 };
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return "";
}
public String  _readapikeysfromconfig() throws Exception{
String _configtext = "";
String[] _lines = null;
String _line = "";
 //BA.debugLineNum = 312;BA.debugLine="Private Sub ReadApiKeysFromConfig";
 //BA.debugLineNum = 313;BA.debugLine="Try";
try { //BA.debugLineNum = 314;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 315;BA.debugLine="Dim configText As String = File.ReadString(File.";
_configtext = __c.File.ReadString(__c.File.getDirAssets(),"config.txt");
 //BA.debugLineNum = 316;BA.debugLine="Dim lines() As String = Regex.Split(\"\\n\", config";
_lines = __c.Regex.Split("\\n",_configtext);
 //BA.debugLineNum = 317;BA.debugLine="For Each line As String In lines";
{
final String[] group5 = _lines;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_line = group5[index5];
 //BA.debugLineNum = 318;BA.debugLine="If line.StartsWith(\"GOOGLE_MAPS_KEY=\") Then";
if (_line.startsWith("GOOGLE_MAPS_KEY=")) { 
 //BA.debugLineNum = 319;BA.debugLine="GoogleApiKey = line.Replace(\"GOOGLE_MAPS_KEY=\"";
_googleapikey = _line.replace("GOOGLE_MAPS_KEY=","").trim();
 }else if(_line.startsWith("SERVER_URL=")) { 
 //BA.debugLineNum = 321;BA.debugLine="ServerUrl = line.Replace(\"SERVER_URL=\", \"\").Tr";
_serverurl = _line.replace("SERVER_URL=","").trim();
 }else if(_line.startsWith("SERVER_PING_URL=")) { 
 //BA.debugLineNum = 323;BA.debugLine="ServerPingUrl = line.Replace(\"SERVER_PING_URL=";
_serverpingurl = _line.replace("SERVER_PING_URL=","").trim();
 };
 }
};
 } 
       catch (Exception e15) {
			ba.setLastException(e15); //BA.debugLineNum = 327;BA.debugLine="Log(\"⚠️ 无法读取 config.txt: \" & LastException.Messa";
__c.LogImpl("71835023","⚠️ 无法读取 config.txt: "+__c.LastException(ba).getMessage(),0);
 //BA.debugLineNum = 328;BA.debugLine="ToastMessageShow(\"配置文件读取失败\", True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("配置文件读取失败"),__c.True);
 };
 //BA.debugLineNum = 330;BA.debugLine="End Sub";
return "";
}
public String  _requestcurrentaddress(boolean _shouldspeak) throws Exception{
anywheresoftware.b4a.gps.LocationWrapper _location1 = null;
double _lat = 0;
double _lon = 0;
String _url = "";
com.pdv.vision.httpjob _jobgeo = null;
 //BA.debugLineNum = 369;BA.debugLine="Private Sub RequestCurrentAddress(ShouldSpeak As B";
 //BA.debugLineNum = 370;BA.debugLine="If flp.IsConnected = False Then";
if (_flp.IsConnected()==__c.False) { 
 //BA.debugLineNum = 371;BA.debugLine="Log(\"FLP未连接\")";
__c.LogImpl("72228226","FLP未连接",0);
 //BA.debugLineNum = 372;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 375;BA.debugLine="Dim Location1 As Location = flp.GetLastKnownLocat";
_location1 = new anywheresoftware.b4a.gps.LocationWrapper();
_location1 = _flp.GetLastKnownLocation();
 //BA.debugLineNum = 376;BA.debugLine="If Location1.IsInitialized Then";
if (_location1.IsInitialized()) { 
 //BA.debugLineNum = 377;BA.debugLine="Dim lat As Double = Location1.Latitude";
_lat = _location1.getLatitude();
 //BA.debugLineNum = 378;BA.debugLine="Dim lon As Double = Location1.Longitude";
_lon = _location1.getLongitude();
 //BA.debugLineNum = 379;BA.debugLine="Dim url As String = $\"https://maps.googleapis.co";
_url = ("https://maps.googleapis.com/maps/api/geocode/json?latlng="+__c.SmartStringFormatter("",(Object)(_lat))+","+__c.SmartStringFormatter("",(Object)(_lon))+"&language=zh-CN&key="+__c.SmartStringFormatter("",(Object)(_googleapikey))+"");
 //BA.debugLineNum = 380;BA.debugLine="Dim jobGeo As HttpJob";
_jobgeo = new com.pdv.vision.httpjob();
 //BA.debugLineNum = 381;BA.debugLine="jobGeo.Initialize(\"GeoAddress\", Me)";
_jobgeo._initialize /*String*/ (ba,"GeoAddress",this);
 //BA.debugLineNum = 382;BA.debugLine="jobGeo.Tag = ShouldSpeak";
_jobgeo._tag /*Object*/  = (Object)(_shouldspeak);
 //BA.debugLineNum = 383;BA.debugLine="jobGeo.Download(url)";
_jobgeo._download /*String*/ (_url);
 }else {
 //BA.debugLineNum = 385;BA.debugLine="Log(\"没有获取到LastKnownLocation\")";
__c.LogImpl("72228240","没有获取到LastKnownLocation",0);
 };
 //BA.debugLineNum = 387;BA.debugLine="End Sub";
return "";
}
public String  _requestgeoaddress(double _lat,double _lon,boolean _speak) throws Exception{
String _url = "";
com.pdv.vision.httpjob _jobgeo = null;
 //BA.debugLineNum = 462;BA.debugLine="Private Sub RequestGeoAddress(lat As Double, lon A";
 //BA.debugLineNum = 463;BA.debugLine="If GoogleApiKey = \"\" Then";
if ((_googleapikey).equals("")) { 
 //BA.debugLineNum = 464;BA.debugLine="Log(\"⚠️ Google API Key 未初始化\")";
__c.LogImpl("72359298","⚠️ Google API Key 未初始化",0);
 //BA.debugLineNum = 465;BA.debugLine="ToastMessageShow(\"缺少 Google API Key\", True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("缺少 Google API Key"),__c.True);
 //BA.debugLineNum = 466;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 468;BA.debugLine="Dim url As String = $\"https://maps.googleapis.com";
_url = ("https://maps.googleapis.com/maps/api/geocode/json?latlng="+__c.SmartStringFormatter("",(Object)(_lat))+","+__c.SmartStringFormatter("",(Object)(_lon))+"&key="+__c.SmartStringFormatter("",(Object)(_googleapikey))+"");
 //BA.debugLineNum = 469;BA.debugLine="Dim jobGeo As HttpJob";
_jobgeo = new com.pdv.vision.httpjob();
 //BA.debugLineNum = 470;BA.debugLine="jobGeo.Initialize(\"GeoAddress\", Me)";
_jobgeo._initialize /*String*/ (ba,"GeoAddress",this);
 //BA.debugLineNum = 471;BA.debugLine="jobGeo.Tag = speak";
_jobgeo._tag /*Object*/  = (Object)(_speak);
 //BA.debugLineNum = 472;BA.debugLine="jobGeo.Download(url)";
_jobgeo._download /*String*/ (_url);
 //BA.debugLineNum = 473;BA.debugLine="End Sub";
return "";
}
public String  _speechrecognition_error(int _errorcode) throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Sub SpeechRecognition_Error(ErrorCode As Int)";
 //BA.debugLineNum = 138;BA.debugLine="ToastMessageShow(\"语音识别失败\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("语音识别失败"),__c.False);
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public String  _speechrecognition_result(String _text) throws Exception{
 //BA.debugLineNum = 286;BA.debugLine="Private Sub SpeechRecognition_Result(Text As Strin";
 //BA.debugLineNum = 287;BA.debugLine="Log(\"识别到内容: \" & Text)";
__c.LogImpl("71769473","识别到内容: "+_text,0);
 //BA.debugLineNum = 288;BA.debugLine="If isProcessing Then";
if (_isprocessing) { 
 //BA.debugLineNum = 289;BA.debugLine="Log(\"⚠️ 正在处理，跳过\")";
__c.LogImpl("71769475","⚠️ 正在处理，跳过",0);
 //BA.debugLineNum = 290;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 293;BA.debugLine="autoTimer.Enabled = False  ' 确保不会跳入循环";
_autotimer.setEnabled(__c.False);
 //BA.debugLineNum = 294;BA.debugLine="isProcessing = True";
_isprocessing = __c.True;
 //BA.debugLineNum = 296;BA.debugLine="If Text.Contains(\"位置\") Or Text.Contains(\"坐标\") Or";
if (_text.contains("位置") || _text.contains("坐标") || _text.contains("哪里")) { 
 //BA.debugLineNum = 297;BA.debugLine="If CurrentMode = \"indoor\" Then";
if ((_currentmode).equals("indoor")) { 
 //BA.debugLineNum = 298;BA.debugLine="RequestCurrentAddress(True)";
_requestcurrentaddress(__c.True);
 }else {
 //BA.debugLineNum = 300;BA.debugLine="ShouldRequestAddressOnNextLocation = True";
_shouldrequestaddressonnextlocation = __c.True;
 //BA.debugLineNum = 301;BA.debugLine="ShouldSpeakAddressOnNextLocation = True";
_shouldspeakaddressonnextlocation = __c.True;
 };
 }else {
 //BA.debugLineNum = 304;BA.debugLine="TakeAndSendPicture(Text)";
_takeandsendpicture(_text);
 };
 //BA.debugLineNum = 309;BA.debugLine="UpdateButtonColors(btnStopAll)";
_updatebuttoncolors(_btnstopall);
 //BA.debugLineNum = 310;BA.debugLine="End Sub";
return "";
}
public void  _takeandsendpicture(String _questiontext) throws Exception{
ResumableSub_TakeAndSendPicture rsub = new ResumableSub_TakeAndSendPicture(this,_questiontext);
rsub.resume(ba, null);
}
public static class ResumableSub_TakeAndSendPicture extends BA.ResumableSub {
public ResumableSub_TakeAndSendPicture(com.pdv.vision.b4xmainpage parent,String _questiontext) {
this.parent = parent;
this._questiontext = _questiontext;
}
com.pdv.vision.b4xmainpage parent;
String _questiontext;
byte[] _data = null;
String _imgbase64 = "";
boolean _ischinese = false;
int _i = 0;
String _ch = "";
String _system_prompt = "";
String _json = "";
com.pdv.vision.httpjob _job = null;
int step9;
int limit9;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 149;BA.debugLine="Wait For(cam.FocusAndTakePicture(MyTaskIndex)) Co";
parent.__c.WaitFor("complete", ba, this, parent._cam._focusandtakepicture /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent._mytaskindex));
this.state = 39;
return;
case 39:
//C
this.state = 1;
_data = (byte[]) result[0];
;
 //BA.debugLineNum = 150;BA.debugLine="If Data.Length = 0 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_data.length==0) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 151;BA.debugLine="ToastMessageShow(\"拍照失败\", False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence("拍照失败"),parent.__c.False);
 //BA.debugLineNum = 152;BA.debugLine="isProcessing = False";
parent._isprocessing = parent.__c.False;
 //BA.debugLineNum = 153;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 156;BA.debugLine="Dim imgBase64 As String = su.EncodeBase64(Data)";
_imgbase64 = parent._su.EncodeBase64(_data);
 //BA.debugLineNum = 159;BA.debugLine="Dim isChinese As Boolean = False";
_ischinese = parent.__c.False;
 //BA.debugLineNum = 160;BA.debugLine="For i = 0 To QuestionText.Length - 1";
if (true) break;

case 5:
//for
this.state = 12;
step9 = 1;
limit9 = (int) (_questiontext.length()-1);
_i = (int) (0) ;
this.state = 40;
if (true) break;

case 40:
//C
this.state = 12;
if ((step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9)) this.state = 7;
if (true) break;

case 41:
//C
this.state = 40;
_i = ((int)(0 + _i + step9)) ;
if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 161;BA.debugLine="Dim ch As String = QuestionText.CharAt(i)";
_ch = BA.ObjectToString(_questiontext.charAt(_i));
 //BA.debugLineNum = 162;BA.debugLine="If Asc(ch) >= 0x4e00 And Asc(ch) <= 0x9fff Then";
if (true) break;

case 8:
//if
this.state = 11;
if (parent.__c.Asc(BA.ObjectToChar(_ch))>=((int)0x4e00) && parent.__c.Asc(BA.ObjectToChar(_ch))<=((int)0x9fff)) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 163;BA.debugLine="isChinese = True";
_ischinese = parent.__c.True;
 //BA.debugLineNum = 164;BA.debugLine="Exit";
this.state = 12;
if (true) break;
 if (true) break;

case 11:
//C
this.state = 41;
;
 if (true) break;
if (true) break;

case 12:
//C
this.state = 13;
;
 //BA.debugLineNum = 169;BA.debugLine="Dim system_prompt As String";
_system_prompt = "";
 //BA.debugLineNum = 170;BA.debugLine="Select CurrentMode";
if (true) break;

case 13:
//select
this.state = 38;
switch (BA.switchObjectToInt(parent._currentmode,"outdoor","indoor")) {
case 0: {
this.state = 15;
if (true) break;
}
case 1: {
this.state = 23;
if (true) break;
}
default: {
this.state = 31;
if (true) break;
}
}
if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 172;BA.debugLine="If isChinese Then";
if (true) break;

case 16:
//if
this.state = 21;
if (_ischinese) { 
this.state = 18;
}else {
this.state = 20;
}if (true) break;

case 18:
//C
this.state = 21;
 //BA.debugLineNum = 173;BA.debugLine="system_prompt = \"请用中文回答。我是一名视障人士，目前处于户外街道模式。请优";
_system_prompt = "请用中文回答。我是一名视障人士，目前处于户外街道模式。请优化描述风格以便快速理解，并重点描述前方是否有斑马线、红绿灯、障碍物、围栏、盲道或沟渠。";
 if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 175;BA.debugLine="system_prompt = \"Please answer in English. I a";
_system_prompt = "Please answer in English. I am a blind person in outdoor street mode. Please describe clearly any crosswalks, traffic lights, obstacles, fences, tactile paths, or drains in front.";
 if (true) break;

case 21:
//C
this.state = 38;
;
 if (true) break;

case 23:
//C
this.state = 24;
 //BA.debugLineNum = 178;BA.debugLine="If isChinese Then";
if (true) break;

case 24:
//if
this.state = 29;
if (_ischinese) { 
this.state = 26;
}else {
this.state = 28;
}if (true) break;

case 26:
//C
this.state = 29;
 //BA.debugLineNum = 179;BA.debugLine="system_prompt = \"请用中文回答。我是一名视障人士，目前处于室内商场模式。请优";
_system_prompt = "请用中文回答。我是一名视障人士，目前处于室内商场模式。请优化描述风格以便快速理解，并关注是否有厕所、入口、出口或大门等重要设施。";
 if (true) break;

case 28:
//C
this.state = 29;
 //BA.debugLineNum = 181;BA.debugLine="system_prompt = \"Please answer in English. I a";
_system_prompt = "Please answer in English. I am a blind person in indoor mode. Please clearly describe any restrooms, entrances, exits, or main doors visible in the scene.";
 if (true) break;

case 29:
//C
this.state = 38;
;
 if (true) break;

case 31:
//C
this.state = 32;
 //BA.debugLineNum = 184;BA.debugLine="If isChinese Then";
if (true) break;

case 32:
//if
this.state = 37;
if (_ischinese) { 
this.state = 34;
}else {
this.state = 36;
}if (true) break;

case 34:
//C
this.state = 37;
 //BA.debugLineNum = 185;BA.debugLine="system_prompt = \"请用中文回答。我是一名视障人士。请描述图像内容并简洁明了。";
_system_prompt = "请用中文回答。我是一名视障人士。请描述图像内容并简洁明了。";
 if (true) break;

case 36:
//C
this.state = 37;
 //BA.debugLineNum = 187;BA.debugLine="system_prompt = \"Please answer in English. I a";
_system_prompt = "Please answer in English. I am a blind person. Please provide a concise description of the scene.";
 if (true) break;

case 37:
//C
this.state = 38;
;
 if (true) break;

case 38:
//C
this.state = -1;
;
 //BA.debugLineNum = 192;BA.debugLine="Dim json As String = $\"{\"image\": \"${imgBase64}\",";
_json = ("{\"image\": \""+parent.__c.SmartStringFormatter("",(Object)(_imgbase64))+"\", \"question\": \""+parent.__c.SmartStringFormatter("",(Object)(_questiontext))+"\", \"system_prompt\": \""+parent.__c.SmartStringFormatter("",(Object)(_system_prompt))+"\"}");
 //BA.debugLineNum = 194;BA.debugLine="Dim job As HttpJob";
_job = new com.pdv.vision.httpjob();
 //BA.debugLineNum = 195;BA.debugLine="job.Initialize(\"AI\", Me)";
_job._initialize /*String*/ (ba,"AI",parent);
 //BA.debugLineNum = 196;BA.debugLine="job.PostString(ServerUrl, json)";
_job._poststring /*String*/ (parent._serverurl,_json);
 //BA.debugLineNum = 197;BA.debugLine="job.GetRequest.SetContentType(\"application/json\")";
_job._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _tts1_ready(boolean _success) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Sub TTS1_Ready (Success As Boolean)";
 //BA.debugLineNum = 119;BA.debugLine="Log(\"TTS Ready: \" & Success)";
__c.LogImpl("7917505","TTS Ready: "+BA.ObjectToString(_success),0);
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public String  _updatebuttoncolors(anywheresoftware.b4a.objects.ButtonWrapper _activebutton) throws Exception{
int _defaultcolor = 0;
int _activecolor = 0;
int _stopcolor = 0;
 //BA.debugLineNum = 476;BA.debugLine="Private Sub UpdateButtonColors(ActiveButton As But";
 //BA.debugLineNum = 477;BA.debugLine="Dim defaultColor As Int = xui.Color_White";
_defaultcolor = _xui.Color_White;
 //BA.debugLineNum = 478;BA.debugLine="Dim activeColor As Int = 0xFF00CC00  ' 绿色";
_activecolor = ((int)0xff00cc00);
 //BA.debugLineNum = 479;BA.debugLine="Dim stopColor As Int = 0xFFFF4444    ' 红色";
_stopcolor = ((int)0xffff4444);
 //BA.debugLineNum = 481;BA.debugLine="If ActiveButton = btnOutMode Then";
if ((_activebutton).equals(_btnoutmode)) { 
 //BA.debugLineNum = 482;BA.debugLine="btnOutMode.Color = activeColor";
_btnoutmode.setColor(_activecolor);
 }else {
 //BA.debugLineNum = 484;BA.debugLine="btnOutMode.Color = defaultColor";
_btnoutmode.setColor(_defaultcolor);
 };
 //BA.debugLineNum = 486;BA.debugLine="If ActiveButton = btnInMode Then";
if ((_activebutton).equals(_btninmode)) { 
 //BA.debugLineNum = 487;BA.debugLine="btnInMode.Color = activeColor";
_btninmode.setColor(_activecolor);
 }else {
 //BA.debugLineNum = 489;BA.debugLine="btnInMode.Color = defaultColor";
_btninmode.setColor(_defaultcolor);
 };
 //BA.debugLineNum = 491;BA.debugLine="If ActiveButton = btnNoMode Then";
if ((_activebutton).equals(_btnnomode)) { 
 //BA.debugLineNum = 492;BA.debugLine="btnNoMode.Color = activeColor";
_btnnomode.setColor(_activecolor);
 }else {
 //BA.debugLineNum = 494;BA.debugLine="btnNoMode.Color = defaultColor";
_btnnomode.setColor(_defaultcolor);
 };
 //BA.debugLineNum = 496;BA.debugLine="If ActiveButton = btnStopAll Then";
if ((_activebutton).equals(_btnstopall)) { 
 //BA.debugLineNum = 497;BA.debugLine="btnStopAll.Color = stopColor";
_btnstopall.setColor(_stopcolor);
 }else {
 //BA.debugLineNum = 499;BA.debugLine="btnStopAll.Color = defaultColor";
_btnstopall.setColor(_defaultcolor);
 };
 //BA.debugLineNum = 501;BA.debugLine="If ActiveButton = btnVoiceAsk Then";
if ((_activebutton).equals(_btnvoiceask)) { 
 //BA.debugLineNum = 502;BA.debugLine="btnVoiceAsk.Color = activeColor";
_btnvoiceask.setColor(_activecolor);
 }else {
 //BA.debugLineNum = 504;BA.debugLine="btnVoiceAsk.Color = defaultColor";
_btnvoiceask.setColor(_defaultcolor);
 };
 //BA.debugLineNum = 506;BA.debugLine="If ActiveButton = btnCapture Then";
if ((_activebutton).equals(_btncapture)) { 
 //BA.debugLineNum = 507;BA.debugLine="btnCapture.Color = activeColor";
_btncapture.setColor(_activecolor);
 }else {
 //BA.debugLineNum = 509;BA.debugLine="btnCapture.Color = defaultColor";
_btncapture.setColor(_defaultcolor);
 };
 //BA.debugLineNum = 511;BA.debugLine="End Sub";
return "";
}
public String  _wakeupserver() throws Exception{
com.pdv.vision.httpjob _jobwake = null;
 //BA.debugLineNum = 111;BA.debugLine="Private Sub WakeupServer";
 //BA.debugLineNum = 112;BA.debugLine="Dim jobWake As HttpJob";
_jobwake = new com.pdv.vision.httpjob();
 //BA.debugLineNum = 113;BA.debugLine="jobWake.Initialize(\"Wakeup\", Me)";
_jobwake._initialize /*String*/ (ba,"Wakeup",this);
 //BA.debugLineNum = 114;BA.debugLine="jobWake.Download(ServerPingUrl)";
_jobwake._download /*String*/ (_serverpingurl);
 //BA.debugLineNum = 115;BA.debugLine="jobWake.GetRequest.Timeout = 10000";
_jobwake._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().setTimeout((int) (10000));
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "JOBDONE"))
	return _jobdone((com.pdv.vision.httpjob) args[0]);
if (BA.fastSubCompare(sub, "SPEECHRECOGNITION_ERROR"))
	return _speechrecognition_error(((Number)args[0]).intValue());
if (BA.fastSubCompare(sub, "SPEECHRECOGNITION_RESULT"))
	return _speechrecognition_result((String) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
