package com.pdv.vision.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_mainpage{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[MainPage/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 4;BA.debugLine="lblTop.Left = 0%x"[MainPage/General script]
views.get("lbltop").vw.setLeft((int)((0d / 100 * width)));
//BA.debugLineNum = 5;BA.debugLine="lblTop.Top = 0%y"[MainPage/General script]
views.get("lbltop").vw.setTop((int)((0d / 100 * height)));
//BA.debugLineNum = 6;BA.debugLine="lblTop.Width = 100%x"[MainPage/General script]
views.get("lbltop").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="lblTop.Height = 40dip"[MainPage/General script]
views.get("lbltop").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 9;BA.debugLine="lblLocation.Left = 2%x"[MainPage/General script]
views.get("lbllocation").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 10;BA.debugLine="lblLocation.Top = lblTop.Bottom+1%y"[MainPage/General script]
views.get("lbllocation").vw.setTop((int)((views.get("lbltop").vw.getTop() + views.get("lbltop").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 11;BA.debugLine="lblLocation.Width = 96%x"[MainPage/General script]
views.get("lbllocation").vw.setWidth((int)((96d / 100 * width)));
//BA.debugLineNum = 12;BA.debugLine="lblLocation.Height = 80dip"[MainPage/General script]
views.get("lbllocation").vw.setHeight((int)((80d * scale)));
//BA.debugLineNum = 14;BA.debugLine="pnlPreview.Left = lblLocation.Left"[MainPage/General script]
views.get("pnlpreview").vw.setLeft((int)((views.get("lbllocation").vw.getLeft())));
//BA.debugLineNum = 15;BA.debugLine="pnlPreview.Top = lblLocation.Bottom"[MainPage/General script]
views.get("pnlpreview").vw.setTop((int)((views.get("lbllocation").vw.getTop() + views.get("lbllocation").vw.getHeight())));
//BA.debugLineNum = 16;BA.debugLine="pnlPreview.Width = 60%x"[MainPage/General script]
views.get("pnlpreview").vw.setWidth((int)((60d / 100 * width)));
//BA.debugLineNum = 17;BA.debugLine="pnlPreview.Height = 40%y"[MainPage/General script]
views.get("pnlpreview").vw.setHeight((int)((40d / 100 * height)));
//BA.debugLineNum = 19;BA.debugLine="btnOutMode.Left = pnlPreview.Right+2%x"[MainPage/General script]
views.get("btnoutmode").vw.setLeft((int)((views.get("pnlpreview").vw.getLeft() + views.get("pnlpreview").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 20;BA.debugLine="btnOutMode.Top = pnlPreview.Top"[MainPage/General script]
views.get("btnoutmode").vw.setTop((int)((views.get("pnlpreview").vw.getTop())));
//BA.debugLineNum = 21;BA.debugLine="btnOutMode.Width = 100%x/3"[MainPage/General script]
views.get("btnoutmode").vw.setWidth((int)((100d / 100 * width)/3d));
//BA.debugLineNum = 22;BA.debugLine="btnOutMode.Height = 60dip"[MainPage/General script]
views.get("btnoutmode").vw.setHeight((int)((60d * scale)));
//BA.debugLineNum = 24;BA.debugLine="btnInMode.Left = btnOutMode.Left"[MainPage/General script]
views.get("btninmode").vw.setLeft((int)((views.get("btnoutmode").vw.getLeft())));
//BA.debugLineNum = 25;BA.debugLine="btnInMode.Top = btnOutMode.Bottom+1%y"[MainPage/General script]
views.get("btninmode").vw.setTop((int)((views.get("btnoutmode").vw.getTop() + views.get("btnoutmode").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 26;BA.debugLine="btnInMode.Width = btnOutMode.Width"[MainPage/General script]
views.get("btninmode").vw.setWidth((int)((views.get("btnoutmode").vw.getWidth())));
//BA.debugLineNum = 27;BA.debugLine="btnInMode.Height = btnOutMode.Height"[MainPage/General script]
views.get("btninmode").vw.setHeight((int)((views.get("btnoutmode").vw.getHeight())));
//BA.debugLineNum = 29;BA.debugLine="btnNoMode.Left = btnOutMode.Left"[MainPage/General script]
views.get("btnnomode").vw.setLeft((int)((views.get("btnoutmode").vw.getLeft())));
//BA.debugLineNum = 30;BA.debugLine="btnNoMode.Top = btnInMode.Bottom+1%y"[MainPage/General script]
views.get("btnnomode").vw.setTop((int)((views.get("btninmode").vw.getTop() + views.get("btninmode").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 31;BA.debugLine="btnNoMode.Width = btnOutMode.Width"[MainPage/General script]
views.get("btnnomode").vw.setWidth((int)((views.get("btnoutmode").vw.getWidth())));
//BA.debugLineNum = 32;BA.debugLine="btnNoMode.Height = btnOutMode.Height"[MainPage/General script]
views.get("btnnomode").vw.setHeight((int)((views.get("btnoutmode").vw.getHeight())));
//BA.debugLineNum = 34;BA.debugLine="btnStopAll.Left = btnOutMode.Left"[MainPage/General script]
views.get("btnstopall").vw.setLeft((int)((views.get("btnoutmode").vw.getLeft())));
//BA.debugLineNum = 35;BA.debugLine="btnStopAll.Top = btnNoMode.Bottom+1%y"[MainPage/General script]
views.get("btnstopall").vw.setTop((int)((views.get("btnnomode").vw.getTop() + views.get("btnnomode").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 36;BA.debugLine="btnStopAll.Width = btnOutMode.Width"[MainPage/General script]
views.get("btnstopall").vw.setWidth((int)((views.get("btnoutmode").vw.getWidth())));
//BA.debugLineNum = 37;BA.debugLine="btnStopAll.Height = btnOutMode.Height"[MainPage/General script]
views.get("btnstopall").vw.setHeight((int)((views.get("btnoutmode").vw.getHeight())));
//BA.debugLineNum = 39;BA.debugLine="lblAiTitle.Left = pnlPreview.Left"[MainPage/General script]
views.get("lblaititle").vw.setLeft((int)((views.get("pnlpreview").vw.getLeft())));
//BA.debugLineNum = 40;BA.debugLine="lblAiTitle.Top = pnlPreview.Bottom+1%y"[MainPage/General script]
views.get("lblaititle").vw.setTop((int)((views.get("pnlpreview").vw.getTop() + views.get("pnlpreview").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 41;BA.debugLine="lblAiTitle.Width = lblLocation.Width"[MainPage/General script]
views.get("lblaititle").vw.setWidth((int)((views.get("lbllocation").vw.getWidth())));
//BA.debugLineNum = 42;BA.debugLine="lblAiTitle.Height = 40dip"[MainPage/General script]
views.get("lblaititle").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 44;BA.debugLine="lblResponseTxt.Left = lblAiTitle.Left"[MainPage/General script]
views.get("lblresponsetxt").vw.setLeft((int)((views.get("lblaititle").vw.getLeft())));
//BA.debugLineNum = 45;BA.debugLine="lblResponseTxt.Top = lblAiTitle.Bottom"[MainPage/General script]
views.get("lblresponsetxt").vw.setTop((int)((views.get("lblaititle").vw.getTop() + views.get("lblaititle").vw.getHeight())));
//BA.debugLineNum = 46;BA.debugLine="lblResponseTxt.Width = lblLocation.Width"[MainPage/General script]
views.get("lblresponsetxt").vw.setWidth((int)((views.get("lbllocation").vw.getWidth())));
//BA.debugLineNum = 47;BA.debugLine="lblResponseTxt.Height = 25%y"[MainPage/General script]
views.get("lblresponsetxt").vw.setHeight((int)((25d / 100 * height)));
//BA.debugLineNum = 49;BA.debugLine="btnCapture.Left = 2%x"[MainPage/General script]
views.get("btncapture").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 50;BA.debugLine="btnCapture.Bottom = 98%y"[MainPage/General script]
views.get("btncapture").vw.setTop((int)((98d / 100 * height) - (views.get("btncapture").vw.getHeight())));
//BA.debugLineNum = 51;BA.debugLine="btnCapture.Width = 100%x/2 - 10dip"[MainPage/General script]
views.get("btncapture").vw.setWidth((int)((100d / 100 * width)/2d-(10d * scale)));
//BA.debugLineNum = 52;BA.debugLine="btnCapture.Height = 10%y"[MainPage/General script]
views.get("btncapture").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 54;BA.debugLine="btnVoiceAsk.Left = btnCapture.Right+2%x"[MainPage/General script]
views.get("btnvoiceask").vw.setLeft((int)((views.get("btncapture").vw.getLeft() + views.get("btncapture").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 55;BA.debugLine="btnVoiceAsk.Top = btnCapture.Top"[MainPage/General script]
views.get("btnvoiceask").vw.setTop((int)((views.get("btncapture").vw.getTop())));
//BA.debugLineNum = 56;BA.debugLine="btnVoiceAsk.Width = btnCapture.Width"[MainPage/General script]
views.get("btnvoiceask").vw.setWidth((int)((views.get("btncapture").vw.getWidth())));
//BA.debugLineNum = 57;BA.debugLine="btnVoiceAsk.Height = btnCapture.Height"[MainPage/General script]
views.get("btnvoiceask").vw.setHeight((int)((views.get("btncapture").vw.getHeight())));

}
}