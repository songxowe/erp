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
.SUBMIT_STYLE1{
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid

}
.BUTTON_STYLE1{
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
}
.RESET_STYLE1{
 BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
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
 <table  class="TABLE_STYLE3">
 <tr height=20 class="TR_STYLE1">
 <td  class="TD_HANDBOOK_STYLE1">您正在做的业务是：生产管理--内部生产管理--复核登记（<a href="javascript:winopens('../../main/responsiblePerson.htm')">
责任人控制</a>）</td>
 </tr>
 </table>
 <div style="display:block;position:absolute;left:950px;">
 <table align=right class="TABLE_STYLE6">
 <tr height=20 class="TR_STYLE1">
<!--  <td bordercolorlight=#848284 bordercolordark=#eeeeee align=center class="TD_STYLE8"><input type="button" onmouseover=this.className='btn3_mouseover' onmouseout=this.className='btn3_mouseout' onmousedown=this.className='btn3_mousedown' onmouseup=this.className='btn3_mouseup' class="BUTTON_STYLE1" value="返回" onClick="history.back()"></td>  -->
 </tr>
 </table>
 </div>
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
 <td align=center height=5 class="TD_STYLE5"><font size="4"><b>生产派工单</b></font></td>
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
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">出库单编号：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${gatherId}&nbsp;</td>
</tr>
<tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">产品编号：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.productId}&nbsp;</td>
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">产品名称：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.productName}&nbsp;</td>
</tr>
<tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">描述&nbsp;：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.productDescribe}&nbsp;</td>
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">数量&nbsp;：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.amount}&nbsp;</td>
 </tr>
</table>
<table align=center class="TABLE_STYLE4">
 <tr height=20 class="TR_STYLE1">
 <td align=center height=5 class="TD_STYLE5">&nbsp;</td>
 </tr>
 </table>
<TABLE bordercolor=#000000 bordercolorlight=#848284 bordercolordark=#eeeeee border=1 cellspacing=0 cellpadding=0 align=center class="TABLE_STYLE5">
 <tr height=20 bgcolor=#D2E9FF class="TR_STYLE2">
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="8%">工序名称</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">设计工时数</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">实际工时数</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">设计工时成本(元)</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">实际工时成本</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="13%">设计物料成本(元)</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="11%">实际物料成本</td>
 <c:if test="true">
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="7%">
 <c:if test="true">
 登记复核
 </c:if>
 </td>
 </c:if>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="7%">
 <c:if test="true">
  交接复核&nbsp;
 </c:if>
 </td>
 </tr>
<c:forEach items="${mlist}" var="list">
	 <tr height=20 class="TR_STYLE1">
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${list.procedureName}&nbsp;</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${list.labourHourAmount}&nbsp;</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${list.realLabourHourAmount}&nbsp;</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${list.subtotal}&nbsp;</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${list.realSubtotal}&nbsp;</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${list.moduleSubtotal}&nbsp;</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${list.realModuleSubtotal}&nbsp;</td>
<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">
<c:if test="${list.procedureFinishTag=='G004-2'}">
	<a href="lbManufactureController_checkmaterial.do?id=${manufacture.id}&mid=${list.id}">复核</a>
</c:if>
<c:if test="${list.procedureFinishTag=='G004-3'||list.procedureFinishTag=='G004-1'}">
	完成
</c:if>
</td>
<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">
<c:if test="${list.procedureTransferTag=='G005-1'}">
  <a href="#" onclick="gooNew()">交接复核</a>
</c:if>
<c:if test="${list.procedureTransferTag=='G005-2'}">
  	完成
</c:if>
</td>
</tr>
</c:forEach>
</table>
<table align=center class="TABLE_STYLE4">
 <tr height=20 class="TR_STYLE1">
 <td align=center height=5 class="TD_STYLE5">&nbsp;</td>
 </tr>
 </table>
<table align=center class="TABLE_STYLE4">
<tr height=20 class="TR_STYLE1">
	 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">设计工时总成本：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.labourCostPriceSum}&nbsp;</td>
	 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">设计物料总成本：</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.moduleCostPriceSum}&nbsp;</td>
</tr>
	<tr height=20 class="TR_STYLE1">
	 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">实际工时总成本：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.realLabourCostPriceSum}&nbsp;</td>
	 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">实际物料总成本：</td>
	 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.realModuleCostPriceSum}&nbsp;</td>
 </tr>
	<tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">登记人&nbsp;&nbsp;：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.register}&nbsp;</td>
	 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">登记时间：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${registerTime}&nbsp;</td>
</tr>
	<tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">复核人&nbsp;&nbsp;：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${manufacture.checker}&nbsp;</td>
	 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">复核时间：</td>
 <td bordercolor=#DEDBD6 align=left class="TD_STYLE2" width="37%">${checkTime}&nbsp;</td>
 </tr>
	<tr height=20 class="TR_STYLE1">
 <td bordercolorlight=#848284 bordercolordark=#eeeeee align=right class="TD_STYLE8" width="13%">备注&nbsp;&nbsp;&nbsp;：</td>
<td bordercolor=#DEDBD6 align=left class="TD_STYLE2" colspan="3" width="87%">${manufacture.remark}&nbsp;</textarea>
</td>
 </tr>
</table>
</td></tr></table></td>
</tr>
</div>
</tbody>
</table>
</td>
</tr>
</tbody>
</table>
</div>
<form id="myform" action="lbManufactureController_finish.do" method="post">
<input type="hidden" name="id" value="${manufacture.id}">
<c:forEach items="${mlist}" var="list">
	<c:if test="${list.procedureFinishTag=='G004-1'&&list.procedureTransferTag=='G005-1'}">
		<input type="hidden" name="mid" value="${list.id}">
	</c:if>
</c:forEach>
<input type="hidden" id="ramount" name="ramount">
</form>
<div id="newadd"></div>
<script type="text/javascript">
	function gooNew(){
		$("#newadd").window({
			title:"确认窗口",
			href:"lbfhinput.jsp",
			width:1100,
			height:550
		});
	}		
</script>
</body>
</html>
