<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="commons/meta.jsp"%>
<style>
.resizeDivClass
{
position:relative;
background-color:#DEDBD6;
width:2;
z-index:1;
left:expression(this.parentElement.offsetWidth-1);
cursor:e-resize;

}
</style>

<script language="javascript">

function MouseDownToResize(obj){
obj.mouseDownX=event.clientX;
obj.pareneTdW=obj.parentElement.offsetWidth;
obj.pareneTableW=theObjTable.offsetWidth;
obj.setCapture();
}
function MouseMoveToResize(obj){
    if(!obj.mouseDownX) return false;
    var newWidth=obj.pareneTdW*1+event.clientX*1-obj.mouseDownX;
    if(newWidth>0)
    {
obj.parentElement.style.width = newWidth;
theObjTable.style.width=obj.pareneTableW*1+event.clientX*1-obj.mouseDownX;
}
}
function MouseUpToResize(obj){
obj.releaseCapture();
obj.mouseDownX=0;
}

</script>


<STYLE>
A:visited {
	TEXT-DECORATION: none
}
A:active {
	TEXT-DECORATION: none
}
A:hover {
	TEXT-DECORATION: underline overline
}
A:link {
	TEXT-DECORATION: none
}
.t {
	LINE-HEIGHT: 1.4
}
BODY {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt;
	scrollbar-face-color :#F1F1F1;
	SCROLLBAR-HIGHLIGHT-COLOR: #F1F1F1;
	SCROLLBAR-SHADOW-COLOR: buttonface;
	SCROLLBAR-3DLIGHT-COLOR: buttonhighlight;
	SCROLLBAR-TRACK-COLOR: #868686
	SCROLLBAR-DARKSHADOW-COLOR: buttonshadow;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
TD {
	FONT-FAMILY: å®ä½; FONT-SIZE: 9pt
}
DIV {
	FONT-FAMILY: å®ä½; FONT-SIZE: 9pt
}
FORM {
	FONT-FAMILY: å®ä½; FONT-SIZE: 9pt
}
OPTION {
	FONT-FAMILY: å®ä½; FONT-SIZE: 9pt
}
P {
	FONT-FAMILY: å®ä½; FONT-SIZE: 9pt
}
TD {
	FONT-FAMILY: å®ä½; FONT-SIZE: 9pt
}
BR {
	FONT-FAMILY: å®ä½; FONT-SIZE: 9pt
}

</STYLE>

<STYLE>
.gray {
	CURSOR: hand; FILTER: gray
}
.style3 {
	font-size: 16px;
	font-weight: bold;
}
.TABLE_STYLE11{
	border: 1px solid;
	border-collapse: collapse;
	width: 95%;
	
}
.TABLE_STYLE1{
	border: 1px solid;
	border-collapse: collapse;
	width: 95%;
	
}
.TABLE_STYLE2{
	width: 95%;
	
}
.TABLE_STYLE3{
	width: 100%;
	
}
.TABLE_STYLE4{
	width: 95%;
	
}
.TABLE_STYLE5{
	border: 1px solid;
	border-collapse: collapse;
	width: 95%;
	
}
.TABLE_STYLE6{
	width: 820;	
}
.TABLE_STYLE7{
	border: 1px solid;
	border-collapse: collapse;
	width: 100%;	
}
.ALL-STYLE{
	border: 1px ridge #666666;
	border-color:#DEDBD6;

}
.TR_STYLE1{

}
.TR_STYLE2{

}
.style8 {color: #000066}



.TD_HANDBOOK_STYLE1 {
	vertical-align : top ;
	width:100%;
	color:#0000FF;
}

.TD_STYLE1{
  background-image:url(/erp/images/line7.gif);
}

.TD_STYLE2{
border-spacing: 1px;
}
.TD_STYLE3{

}
.TD_STYLE4{

}
.TD_STYLE5{

}
.TD_STYLE6{

}
.TD_STYLE7{
  background-image:url(/erp/images/line4.gif);
}
.TD_STYLE8{

}
.SUBMIT_STYLE1{
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid

}
.BUTTON_STYLE1{
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
}
.RESET_STYLE1{
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
}
.RADIO_STYLE1{

}
.CHECKBOX_STYLE1{

}
.SELECT_STYLE1{
width:100%;
}
.SELECT_STYLE2{
width:100%;
}
.TEXTAREA_STYLE1{
width:100%;
}
.DIV_STYLE1{

float :right ;
vertical-align : top ;

}
.DIV_STYLE2{

float :center ;
vertical-align : top ;

}
.INPUT_STYLE1{
width:100%
}
.INPUT_STYLE3{
BORDER-BOTTOM:  1px solid #000000;
BORDER-left:  0px ;
BORDER-right:  0px ;
BORDER-top:  0px ;
width:100%
}
.INPUT_STYLE4{
BORDER-BOTTOM:  0px;
BORDER-left:  0px ;
BORDER-right:  0px ;
BORDER-top:  0px ;
width:100%
}
.INPUT_STYLE5{
background-color:#FFFFCC;
BORDER-BOTTOM:  0px;
BORDER-left:  0px ;
BORDER-right:  0px ;
BORDER-top:  0px ;
width:100%
}
.INPUT_STYLE6{
background-color:#FFFAAA;
BORDER-BOTTOM:  0px;
BORDER-left:  0px ;
BORDER-right:  0px ;
BORDER-top:  0px ;
width:100%
}

.FILE_STYLE1{
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
}
.btn3_mouseout {
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
}
.btn3_mouseover {
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#D7E7FA); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
}
.btn3_mousedown
{
 BORDER-RIGHT: #FFE400 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #FFE400 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #FFE400 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #FFE400 1px solid
}
.btn3_mouseup {
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
}



</STYLE>
</head>


<body bgcolor="#ebf3fb" oncontextmenu="event.returnValue=true"  style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">






<script language="javascript" src="../../javascript/winopen/winopen.js"></script>

 <table  class="TABLE_STYLE3">
 <tr height=20 class="TR_STYLE1">
 <td  class="TD_HANDBOOK_STYLE1">您正在做的业务是：生产管理--内部生产管理--生产查询</td>
 </tr>
</table>
<table align=center class="TABLE_STYLE6">
 <tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8"><input type="button" class="BUTTON_STYLE1" value="关闭窗口" onClick="history.go(-1)"></td> 
 </tr>
 </table>

<div  class="DIV_STYLE2">
<table cellspacing=0 cellpadding=0 width=950 align=center border=0 bgcolor="#FFFFFF">
<tbody>
<tr> 
<td valign=bottom align=center class="TABLE_STYLE6" rowspan=2> 
<table cellspacing=0 cellpadding=0 width="100%" border=0 style="BORDER-RIGHT: #333333 1px solid; BORDER-TOP: #333333 1px solid; BORDER-LEFT: #333333 1px solid; BORDER-BOTTOM: #333333 1px solid;">
<tbody> 
<tr>
<td colspan="4" height="10"><table width="100%"><tr><td>
<table align=center class="TABLE_STYLE4">
 <tr height=20 class="TR_STYLE1">
 <td align=center height=5 class="TD_STYLE5">&nbsp;</td>
 </tr>
 </table>
<table align=center class="TABLE_STYLE4">
 <tr height=20 class="TR_STYLE1">
 <td align=center height=5 class="TD_STYLE5"><font size="4"><b>生产登记单</b></font></td>
 </tr>
 </table>
<table align=center class="TABLE_STYLE4">
 <tr height=20 class="TR_STYLE1">
 <td align=center height=5 class="TD_STYLE5">&nbsp;</td>
 </tr>
 </table>
 <table align=center class="TABLE_STYLE4" id=theObjTable>
	<tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">派工单编号：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.manufactureId}&nbsp;</td>
	 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">工序名称：</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${mprocedure.procedureName}&nbsp;</td>
	</tr>
 <tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">实际工时数：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${mprocedure.realLabourHourAmount}&nbsp;</td>
	 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">实际工时成本：</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${mprocedure.realSubtotal}&nbsp;</td>
	</tr>
</table>
<table align=center class="TABLE_STYLE4">
 <tr height=20 class="TR_STYLE1">
 <td align=center height=5 class="TD_STYLE5">&nbsp;</td>
 </tr>
 </table>
<TABLE bordercolor=#000000 bordercolorlight=#848284 bordercolordark=#eeeeee border=1 cellspacing=0 cellpadding=0 align=center class="TABLE_STYLE5">
 <tr height=20 bgcolor=#D2E9FF class="TR_STYLE2">
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="5%">序号</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="8%">负责人</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">描述 </td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="8%">本次工时数 </td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">单位工时成本</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">本次工时成本（元）</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="8%">登记人</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="15%">登记时间</td> 
 </tr>

 <tr height=20 class="TR_STYLE1">
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${mprocedure.detailsNumber}&nbsp;</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${manufacture.designer}&nbsp;</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${manufacture.productDescribe}&nbsp;</td>	 
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${mprocedure.realLabourHourAmount}&nbsp;</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${mprocedure.costPrice}&nbsp;</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${mprocedure.realSubtotal}&nbsp;</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${manufacture.register}&nbsp;</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${registerTime}&nbsp;</td>	 
 </tr>

</table>
</td></tr></table></td>
</tr>
<tr>
<td colspan="3" nowrap width="56">
</td></td>
</tr>
<tr>
<td colspan="3" nowrap  height="100"></td>
<td></td>
</tr>

<tr valign="bottom">
<td colspan="4" nowrap align="center"></td>
</tr>
</td>
<tr>
<td colspan="4" nowrap align="right"></td>
</tr>
</tbody>
</table>
</td>
<td width=1 bgcolor=#ffffff height=2></td>
<td width=1 bgcolor=#ffffff height=2></td>
<td width=1 bgcolor=#ffffff height=2></td>
</tr>
<tr>
<td width=1 bgcolor=#333333 height=120></td>
<td width=1 bgcolor=#666666 height=120></td>
<td width=1 bgcolor=#999999 height=120></td>
</tr>
<tr valign=top align=right> 
<td colspan=4> 
<table cellspacing=0 cellpadding=0 align=center class="TABLE_STYLE6" border=0>
<tbody> 
<tr> 
<td bgcolor=#333333 height=1></td>
</tr>
<tr> 
<td bgcolor=#666666 height=1></td>
</tr>
<tr> 
<td bgcolor=#999999 height=1></td>
</tr>
</tbody>
</table>
</td>
</tr>
<tr valign=center align=right> 
<td colspan=4> </td>
</tr>
</tbody>
</table>
</div>
</body>
</html>
 