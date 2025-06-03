package com.pdv.vision;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class fusedlocation extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.pdv.vision.fusedlocation");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.pdv.vision.fusedlocation.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public uk.co.martinpearman.b4a.fusedlocationprovider.FusedLocationProviderWrapper _flp = null;
public boolean _flpstarted = false;
public Object _parentobject = null;
public String _evnam = "";
public int _intlocationreqrate = 0;
public com.pdv.vision.main _main = null;
public com.pdv.vision.starter _starter = null;
public com.pdv.vision.b4xpages _b4xpages = null;
public com.pdv.vision.b4xcollections _b4xcollections = null;
public com.pdv.vision.httputils2service _httputils2service = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Public FLP As FusedLocationProvider";
_flp = new uk.co.martinpearman.b4a.fusedlocationprovider.FusedLocationProviderWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private flpStarted As Boolean";
_flpstarted = false;
 //BA.debugLineNum = 12;BA.debugLine="Private ParentObject As Object";
_parentobject = new Object();
 //BA.debugLineNum = 13;BA.debugLine="Private evnam As String";
_evnam = "";
 //BA.debugLineNum = 14;BA.debugLine="Private intLocationReqRate As Int";
_intlocationreqrate = 0;
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public uk.co.martinpearman.b4a.fusedlocationprovider.LocationRequest  _createlocationrequest() throws Exception{
uk.co.martinpearman.b4a.fusedlocationprovider.LocationRequest _lr = null;
 //BA.debugLineNum = 50;BA.debugLine="Private Sub CreateLocationRequest As LocationReque";
 //BA.debugLineNum = 51;BA.debugLine="Dim lr As LocationRequest";
_lr = new uk.co.martinpearman.b4a.fusedlocationprovider.LocationRequest();
 //BA.debugLineNum = 52;BA.debugLine="lr.Initialize";
_lr.Initialize();
 //BA.debugLineNum = 53;BA.debugLine="lr.SetInterval(intLocationReqRate)";
_lr.SetInterval((long) (_intlocationreqrate));
 //BA.debugLineNum = 54;BA.debugLine="lr.SetFastestInterval(lr.GetInterval / 2)";
_lr.SetFastestInterval((long) (_lr.GetInterval()/(double)2));
 //BA.debugLineNum = 55;BA.debugLine="lr.SetPriority(lr.Priority.PRIORITY_HIGH_ACCURACY";
_lr.SetPriority(_lr.Priority.PRIORITY_HIGH_ACCURACY);
 //BA.debugLineNum = 56;BA.debugLine="Return lr";
if (true) return _lr;
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return null;
}
public String  _flp_connectionfailed(int _connectionresult1) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Private Sub flp_ConnectionFailed(ConnectionResult1";
 //BA.debugLineNum = 35;BA.debugLine="Log(\"Failed to connect to location provider\")";
__c.LogImpl("915859713","Failed to connect to location provider",0);
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public String  _flp_connectionsuccess() throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Private Sub flp_ConnectionSuccess";
 //BA.debugLineNum = 31;BA.debugLine="Log(\"Connected to location provider\")";
__c.LogImpl("915794177","Connected to location provider",0);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public String  _flp_locationchanged(anywheresoftware.b4a.gps.LocationWrapper _location1) throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Private Sub flp_LocationChanged (Location1 As Loca";
 //BA.debugLineNum = 126;BA.debugLine="CallSub2(ParentObject, evnam & \"_LocationChanged\"";
__c.CallSubNew2(ba,_parentobject,_evnam+"_LocationChanged",(Object)(_location1));
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,String _eventname,Object _parent) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 21;BA.debugLine="Public Sub Initialize(EventName As String, Parent";
 //BA.debugLineNum = 22;BA.debugLine="evnam = EventName";
_evnam = _eventname;
 //BA.debugLineNum = 23;BA.debugLine="FLP.Initialize(\"flp\")";
_flp.Initialize(ba,"flp");
 //BA.debugLineNum = 24;BA.debugLine="FLP.Connect";
_flp.Connect();
 //BA.debugLineNum = 25;BA.debugLine="ParentObject = Parent";
_parentobject = _parent;
 //BA.debugLineNum = 26;BA.debugLine="intLocationReqRate = 10000";
_intlocationreqrate = (int) (10000);
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public String  _restartflp() throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Public Sub RestartFLP";
 //BA.debugLineNum = 117;BA.debugLine="StopFLP";
_stopflp();
 //BA.debugLineNum = 118;BA.debugLine="StartFLP";
_startflp();
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public String  _setlocationrequestinterval(int _lrinterval_b4amillis_b4imeters) throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Public Sub setLocationRequestInterval(LRInterval_B";
 //BA.debugLineNum = 112;BA.debugLine="intLocationReqRate = LRInterval_B4AMillis_B4iMete";
_intlocationreqrate = _lrinterval_b4amillis_b4imeters;
 //BA.debugLineNum = 113;BA.debugLine="RestartFLP";
_restartflp();
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _setparent(Object _parent) throws Exception{
 //BA.debugLineNum = 121;BA.debugLine="Public Sub setParent(Parent As Object)";
 //BA.debugLineNum = 122;BA.debugLine="ParentObject = Parent";
_parentobject = _parent;
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public void  _startflp() throws Exception{
ResumableSub_StartFLP rsub = new ResumableSub_StartFLP(this);
rsub.resume(ba, null);
}
public static class ResumableSub_StartFLP extends BA.ResumableSub {
public ResumableSub_StartFLP(com.pdv.vision.fusedlocation parent) {
this.parent = parent;
}
com.pdv.vision.fusedlocation parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 40;BA.debugLine="Do While FLP.IsConnected = False";
if (true) break;

case 1:
//do while
this.state = 4;
while (parent._flp.IsConnected()==parent.__c.False) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 //BA.debugLineNum = 41;BA.debugLine="Sleep(1000)";
parent.__c.Sleep(ba,this,(int) (1000));
this.state = 8;
return;
case 8:
//C
this.state = 1;
;
 if (true) break;
;
 //BA.debugLineNum = 43;BA.debugLine="If flpStarted = False Then";

case 4:
//if
this.state = 7;
if (parent._flpstarted==parent.__c.False) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 44;BA.debugLine="FLP.RequestLocationUpdates(CreateLocationRequest";
parent._flp.RequestLocationUpdates((com.google.android.gms.location.LocationRequest)(parent._createlocationrequest().getObject()));
 //BA.debugLineNum = 45;BA.debugLine="flpStarted = True";
parent._flpstarted = parent.__c.True;
 if (true) break;

case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _stopflp() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Public Sub StopFLP";
 //BA.debugLineNum = 61;BA.debugLine="If flpStarted Then";
if (_flpstarted) { 
 //BA.debugLineNum = 62;BA.debugLine="FLP.RemoveLocationUpdates";
_flp.RemoveLocationUpdates();
 //BA.debugLineNum = 63;BA.debugLine="flpStarted = False";
_flpstarted = __c.False;
 };
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
