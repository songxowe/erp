<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="commons/taglib.jsp"%>
<%@ include file="commons/meta.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>


<head>

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


<link rel="stylesheet" type="text/css" href="../../javascript/ajax/NeatDialogs.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../../javascript/ext/resources/css/ext-all.css"><script type="text/javascript" src="../../javascript/ajax/NeatDialogs.js"></script>

<script type="text/javascript" src="../../javascript/ext/adapter/yui/yui-utilities.js"></script>
<script type="text/javascript" src="../../javascript/ext/adapter/yui/ext-yui-adapter.js"></script>
<script type="text/javascript" src="../../javascript/ext/ext-all.js"></script>
<script language="javascript" src="../../javascript/ext/examples/dialog/hello.js"></script>
<script language="javascript" src="../../javascript/winopen/winopen.js"></script>

<script language="javascript" src="input_control/validation-framework.js"></script>
<%
    	Date date = new Date();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	String today = df.format(date);
    %>
<form id="mutiValidation" action="mpd_save.do"  method="POST" name="form1">
 <table  class="TABLE_STYLE3">
 <tr height=20 class="TR_STYLE1">
 <td  class="TD_HANDBOOK_STYLE1"></td>
 </tr>
 </table>
<table align=center class="TABLE_STYLE6">
 <tr height=20 class="TR_STYLE1">
 </tr>
</table>
<div  class="DIV_STYLE2">
<table cellspacing=0 cellpadding=0 width=350 align=center border=0 bgcolor="#FFFFFF">
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
 <td align=center height=5 class="TD_STYLE5"><font size="4"><b>生产工序设计单</b></font></td>
 </tr>
 </table>
<table align=center class="TABLE_STYLE4">
 <tr height=20 class="TR_STYLE1">
 <td align=center height=5 class="TD_STYLE5">&nbsp;</td>
 </tr>
 </table>
<table align=center class="TABLE_STYLE4">
<tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="9%">产品名称：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="40%"><input name="productName" type="hidden" value="${mdesignProcedure.productName }">${mdesignProcedure.productName }</td>
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="9%">产品编号：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="40%"><input name="did" type="hidden" value="${mdesignProcedure.id }"><input name="productId" type="hidden" value="${mdesignProcedure.productId }">${mdesignProcedure.productId }</td>

 </tr>

<tr height=20 class="TR_STYLE1">
 
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="14%">设计人&nbsp;&nbsp;：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" colspan="3" width="89%"><input name="checker" type="hidden" value="${NEWER_USER_LOGIN_INFO.username}"><input type="text"  class="INPUT_STYLE3" name="designer" type="text" value="${mdesignProcedure.designer}" style="width:44.8%"></td>
</tr>
</table>
<table align=center class="TABLE_STYLE4">
 <tr height=20 class="TR_STYLE1">
 <td align=center height=5 class="TD_STYLE5">&nbsp;</td>
 </tr>
 </table>
<table  bordercolor=#000000 bordercolorlight=#848284 bordercolordark=#eeeeee border=1 cellspacing=0 cellpadding=0 align=center class="TABLE_STYLE5" id="tab1" cols=1>
<thead>
 <tr height=20 bgcolor=#D2E9FF class="TR_STYLE2">
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">工序名称</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">工序编号</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">描述</td>
<td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">工时数</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">工时单位</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">单位工时成本（元）</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">工时成本小计（元）</td>
 </tr> 
 <c:forEach items="${list }" var="list">
 <tr height=20 bgcolor=#D2E9FF class="TR_STYLE2">
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">${list.procedureName }</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">${list.detailsNumber }</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">${list.procedureDescribe }</td>
<td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">${list.labourHourAmount }</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">${list.amountUnit }</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">${list.costPrice }</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">${list.subtotal }</td>
 <tr>
 </c:forEach>
</thead>
</table>
<table align=center class="TABLE_STYLE4">
 <tr height=20 class="TR_STYLE1">
 <td align=center height=5 class="TD_STYLE5">&nbsp;</td>
 </tr>
 </table>
<table align=center class="TABLE_STYLE4">
<tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="14%">登记人&nbsp;&nbsp;：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="40%"><input type="text"  class="INPUT_STYLE3" name="register" type="text" value="${mdesignProcedure.register}" readonly="readonly"></td>
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="9%">登记时间：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="40%"><input name="registerTime" type="hidden">${mdesignProcedure.registerTime}</td>
 </tr>
<tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="9%">设计要求：</td>
<td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="89%" colspan="3">
<textarea rows=4 class="TEXTAREA_STYLE1" name="procedure_describea"></textarea>
</td>
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
<input type="hidden" name="sumbit_submit" 
 value="null">
</form>



        </div>
        </div>
    </div>
	</div>
</div>
</html>

