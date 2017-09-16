<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>

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

<body bgcolor="#E9F8F3" oncontextmenu="event.returnValue=true" style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">





<link rel="stylesheet" type="text/css" href="../../javascript/ext/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="../../javascript/ext/examples/form/forms.css" />
<script language="javascript" src="../../javascript/winopen/winopen.js"></script>
<script language="javascript" src="../../javascript/winopen/winopenm.js"></script>

 <div align=center style="position:absolute;left:20px;right:20px;">
	<div style="width:100%;">

        <div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
        <div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
		<div style="height:780px">



<style>
body {
	font-family: Arial,"宋体";
	font-size:9pt;
}
td { font-size:12px;;
}
.mousehand{
	cursor:hand;
}
	

table.TabBarLevel1 td{
 border:0px solid #CCCCCC;
 height:20px;
 background-color:#66ccff;
}


table.TabBarLevel1 td.Selected{
 border-bottom-width:0px;
 background-color:orange;
}
table.TabBarLevel1 td.Black{
 border-left-width:0px;
 border-top-width:0px;
 border-right-width:0px;
 background-color:#eeeeee;
}

table.Content{
 border-left:1px solid #CCCCCC;
 border-right:1px solid #CCCCCC;
 border-bottom:1px solid #CCCCCC;
}
</style>
<script language="javascript">
function switchTab(tabpage,tabid,action,type,num){
	var oItem = document.getElementById(tabpage);   
	for(var i=1;i<4;i++){
		var x = document.getElementById(type + 'Tab' + i);	
		//alert(x);
		x.className = "mousehand";
		//var y = x.getElementsByTagName('a');
		//y[0].style.color="#333333";
	}	

	document.getElementById(tabid).className = "Selected";
	//gethotimagelist(type+'_'+action);
	divimagelist_all.innerHTML =document.getElementById("nseer"+num).innerHTML;
}
</script>

<body onload="switchTab('TabPage1','imageTab3','全部信息','image','3')">

<table  class="TABLE_STYLE2">
 <tr height=20 class="TR_STYLE1">
 <td  class="TD_STYLE3">
 <td  class="TD_HANDBOOK_STYLE1">您正在做的业务是：产品设计--产品档案管理--产品档案查询</td>
 </tr>
</table>
<table  class="TABLE_STYLE2">
 <tr height=20 class="TR_STYLE1">
 <td  class="TD_STYLE3">
 <div  class="DIV_STYLE1"><input type="button" onmouseover=this.className='btn3_mouseover' onmouseout=this.className='btn3_mouseout' onmousedown=this.className='btn3_mousedown' onmouseup=this.className='btn3_mouseup' class="BUTTON_STYLE1" value="打印" style="width: 50; " onClick="javascript:winopen('query_print.jsp?product_ID=02020001010100100008')">&nbsp;<input type="button" onmouseover=this.className='btn3_mouseover' onmouseout=this.className='btn3_mouseout' onmousedown=this.className='btn3_mousedown' onmouseup=this.className='btn3_mouseup' class="BUTTON_STYLE1" value="返回" onClick="history.back();"></div></td>
 </tr>
</table>

<table  class="TABLE_STYLE2">
  <tr>
    <td><table  class="TabBarLevel1" id="TabPage1">
      <tr align="center">
        <td width="80" id="imageTab1" valign="middle" class="mousehand" onclick="javascript:switchTab('TabPage1','imageTab1','主信息','image','1');">主信息</td>
        <td width="7" class="Black">&nbsp;</td>
        <td width="80" id="imageTab2" valign="middle" class="mousehand" onclick="javascript:switchTab('TabPage1','imageTab2','辅助信息','image','2');">辅助信息</td>
		 <td width="7" class="Black">&nbsp;</td>
		<td width="80" id="imageTab3" valign="middle" class="Selected" onclick="javascript:switchTab('TabPage1','imageTab3','全部信息','image','3');">全部信息</td>
        <td width="7" class="Black">&nbsp;</td>
        <td width="" align="right" class="Black">&nbsp;&nbsp;</td>
      </tr>  
    </table>
     <div id="divimagelist_all">&nbsp;</div></td>
  </tr>
</table>

<div id=nseer1 style="display:none">
 <table bordercolor=#000000  bordercolorlight=#000000 bordercolordark=#000000 border=0 cellspacing=1 cellpadding=1 bgcolor=#ffffff align=center class="TABLE_STYLE7">
 <tr style="background-image:url(../../images/line.gif)"><td colspan="4"><div style="width:100%; height:12; padding:3px; color:#FFFFFF; font-weight:bold ">主信息</div></td></tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">档案编号 </td>
 <td colspan="3" valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">02020001010100100008&nbsp;</td>
</tr>
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">产品名称</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">三星手机&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">制造商</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">三星&nbsp;</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">I级分类</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">电子&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">II级分类</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">计算机&nbsp;</td>
  </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">III级分类</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">服务器&nbsp;</td>
	 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">产品简称</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">手机&nbsp;</td>
</tr>
<tr height=20 class="TR_STYLE1">
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">用途类型</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">商品&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">档次级别</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">高档&nbsp;</td>
  </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">计量单位</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">台&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">计量值</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">1.0&nbsp;</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">市场单价(元)</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">2,000.00&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">计划成本单价 </td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">1,000.00&nbsp;</td>
   </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">成本单价</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">1,000.00&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">&nbsp;</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td> 
 </tr>
 </table>
 </div>
<div id=nseer2 style="display:none">
 <table bordercolor=#000000  bordercolorlight=#000000 bordercolordark=#000000 border=0 cellspacing=1 cellpadding=1 bgcolor=#ffffff align=center class="TABLE_STYLE7">
 <tr style="background-image:url(../../images/line.gif)"><td colspan="4"><div style="width:100%; height:12; padding:3px; color:#FFFFFF; font-weight:bold ">辅助信息</div></td></tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">保修期</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">替代品名称</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 </tr>
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">替代品编号 </td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">生命周期(年)</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 </tr>
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">单位</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">&nbsp;</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
</tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE7" width="8%" height="65">供应商集合 &nbsp; </td>
<td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">
&nbsp;</td>
 <td height="65" bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE7" width="8%">产品描述 &nbsp; </td>
<td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 </tr>

 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">档案附件</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%"><a href="javascript:winopenm('query_attachment.jsp?id=8&tablename=design_file&fieldname=attachment_name')">
</a>&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">档案变更累计</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%"><a href="javascript:winopen('change_file_dig.jsp?product_ID=02020001010100100008&&time=1800-01-01☆00:00:00.0')">0</a>&nbsp</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">最近变更时间</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%"><a href="javascript:winopen('change_file_dig.jsp?product_ID=02020001010100100008&&time=1800-01-01☆00:00:00.0')">没有变更</a>&nbsp;</td>
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">建档时间</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">2016-10-25 10:39:31.0&nbsp;</td>
 </tr>
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">产品经理</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">登记人</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">newer&nbsp;</td>
  </tr>
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">复核人</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">newer&nbsp;</td>
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">复核时间</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">2016-10-25 10:40:43.0&nbsp;</td>
 </tr>

 </table>
 </div>
<div id=nseer3 style="display:none">
 <table bordercolor=#000000  bordercolorlight=#000000 bordercolordark=#000000 border=0 cellspacing=1 cellpadding=1 bgcolor=#ffffff align=center class="TABLE_STYLE7">
 <tr style="background-image:url(../../images/line.gif)"><td colspan="4"><div style="width:100%; height:12; padding:3px; color:#FFFFFF; font-weight:bold ">主信息</div></td></tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">档案编号 </td>
 <td colspan="3" valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">02020001010100100008&nbsp;</td>
</tr>
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">产品名称</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">三星手机&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">制造商</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">三星&nbsp;</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">I级分类</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">电子&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">II级分类</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">计算机&nbsp;</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">III级分类</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">服务器&nbsp;</td>
	 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">产品简称</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">手机&nbsp;</td>
</tr>
<tr height=20 class="TR_STYLE1">
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">用途类型</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">商品&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">档次级别</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">高档&nbsp;</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">计量单位</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">台&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">计量值</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">1.0&nbsp;</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">市场单价(元)</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">2,000.00&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">计划成本单价 </td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">1,000.00&nbsp;</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">成本单价</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">1,000.00&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">&nbsp;</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 </tr>
 <tr style="background-image:url(../../images/line.gif)"><td colspan="4"><div style="width:100%; height:12; padding:3px; color:#FFFFFF; font-weight:bold ">辅助信息</div></td></tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">保修期</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">替代品名称</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">替代品编号 </td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">生命周期(年)</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">单位</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td> 
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">&nbsp;</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 </tr>
  <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE7" width="8%" height="65">供应商集合 &nbsp; </td>
<td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">
&nbsp;</td>
 <td height="65" bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE7" width="8%">产品描述 &nbsp; </td>
<td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 </tr>

 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">档案附件</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%"><a href="javascript:winopenm('query_attachment.jsp?id=8&tablename=design_file&fieldname=attachment_name')">
</a>&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">档案变更累计</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%"><a href="javascript:winopen('change_file_dig.jsp?product_ID=02020001010100100008&&time=1800-01-01☆00:00:00.0')">0</a>&nbsp</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">最近变更时间</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%"><a href="javascript:winopen('change_file_dig.jsp?product_ID=02020001010100100008&&time=1800-01-01☆00:00:00.0')">没有变更</a>&nbsp;</td>
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">建档时间</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">2016-10-25 10:39:31.0&nbsp;</td>
 </tr>
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">产品经理</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">&nbsp;</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">登记人</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">newer&nbsp;</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">复核人</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">newer&nbsp;</td>
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=left height=20 class="TD_STYLE1" width="8%">复核时间</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="18%">2016-10-25 10:40:43.0&nbsp;</td>
 </tr>

 </table>
 </div>

</div></div>
</div></div></div>
        <div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>
		</div>
</div>

</body>
</html>