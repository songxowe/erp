<%--
  author:XU
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
	<title>产品档案管理</title>
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
<script type="text/javascript">
	$(function(){
		<%-- $.post("<%=request.getContextPath()%>/xyfDfileController_findAll.do",function(data){
		  $("#firstKindName").empty();
		  $(data).find("type").each(function(index){
		  var id=$("id",$(data).find("type")[index]).text();
		  var name=$("name",$(data).find("type")[index]).text();
          $("#firstKindName").append("<option value='"+id+"'>"+name+"</option>");		  
		  });//返回一个集合
		},
		"xml"
		); --%>
		$("#firstKindName").change(function(){
		 $.post("<%=request.getContextPath()%>/xyfDfileController_findAl.do",{"name":$("#firstKindName").val()},function(data){
		 $("#secondKindName").empty();
		 $("#thirdKindName").empty();
		 $("#thirdKindName").append("<option value=-1>请选择</option>");	
		 $(data).find("type").each(function(index){
		  var id=$("id",$(data).find("type")[index]).text();
		  var name=$("name",$(data).find("type")[index]).text();
          $("#secondKindName").append("<option value='"+name+"'>"+name+"</option>");	
		 });
		 },
		 "xml"
		 );
		});
		//改变二级分类时触发
		$("#secondKindName").change(function(){
		$.post("<%=request.getContextPath()%>/xyfDfileController_findAl.do", {"name" : $("#secondKindName").val()}, function(data) {
		$("#thirdKindName").empty();
		$(data).find("type").each(
		function(index) {
		var id = $("id",$(data).find("type")[index]).text();
		var name = $("name",$(data).find("type")[index]).text();
		$("#thirdKindName").append("<option value='"+name+"'>" + name+ "</option>");
		});
		}, 
		"xml"
		);
		});
  	
	});
</script>
</head>

<body bgcolor="#E9F8F3" oncontextmenu="event.returnValue=true" style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">


<div align=center style="position:absolute;left:20px;right:20px">
    <div style="width:100%;">        
        <div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
        <div style="height:780px">
        
<form action="xyfDfileController_checked.do">
<input type="hidden" name="id" value="${id}">
<table  class="TABLE_STYLE2">

 <tr height=20 class="TR_STYLE1">
 <td  class="TD_HANDBOOK_STYLE1">您正在做的业务是：产品设计--产品档案管理--产品档案登记复核</td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td  class="TD_STYLE3">
 <div  class="DIV_STYLE1">
 <input type="submit" value="复核通过" />&nbsp&nbsp<input type="button" value="返回" onclick="window.location='xyfdfilechecklist.jsp'"/>
 </div>
 </td>
 </tr>
</table>

 <table bordercolor=#000000 bordercolorlight=#000000 bordercolordark=#000000 border=0 cellspacing=1 cellpadding=1 bgcolor=#006699 align=center class="TABLE_STYLE1" id=theObjTable>
 <tr><td colspan="4"><div style="width:100%; height:12; padding:3px; color:#FFFFFF; font-weight:bold ">产品信息</div></td></tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">档案编号 </td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="86.5%" colspan="3"><input name="productId" type="hidden" value="${dfile.productId }">${dfile.productId }</td>
 </tr>
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">产品名称</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="37.4%"><input type="text"  class="INPUT_STYLE1" name="productName" style="width:80%" value="${dfile.productName }"></td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">制造商</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="37.4%"><input type="text"  class="INPUT_STYLE1" name="factoryName" style="width:80%" value="${dfile.factoryName }"></td>
 </tr>

<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">I级分类</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%">
 <select  class="SELECT_STYLE1" id="firstKindName" name="firstKindName" style="width:49%">
		<c:forEach items="${dlist}" var="list">
			<c:if test="${list.kindName==dfile.firstKindName }">
			<option value="${list.kindName }" selected>${list.kindName}</option>
			</c:if>
			<c:if test="${list.kindName!=dfile.firstKindName }">
			<option value="${list.kindName}">${list.kindName}</option>			
			</c:if>
		</c:forEach>
		
  </select> 
</td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">II级分类</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%">
 <select  class="SELECT_STYLE1" id="secondKindName" name="secondKindName" style="width:49%">	
		<option value="${dfile.secondKindName }" selected>${dfile.secondKindName }</option>
 </select> 
</td>
</tr>
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">III级分类</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%">
 <select  class="SELECT_STYLE1" id="thirdKindName" name="thirdKindName" style="width:49%">

		<option value="${dfile.thirdKindName }" selected>${dfile.thirdKindName }</option>

 </select>
 </td>
	 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">产品简称</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%"><input type="text"  class="INPUT_STYLE1" name="productNick" style="width:49%" value="${dfile.productNick }"></td>
</tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">用途类型</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%">
 <select  class="SELECT_STYLE1" name="type" style="width:49%">
  
		<c:if test="${dfile.type=='Y001-1' }"><option value="Y001-1">商品</option></c:if>
		<c:if test="${dfile.type=='Y001-2' }"><option value="Y001-2">物料</option></c:if>
		<option value="Y001-1">商品</option>

		<option value="Y001-2">物料</option>

  </select>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">档次级别</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%">
 <select  class="SELECT_STYLE1" name="productClass" style="width:49%">
  
  		<c:if test="${dfile.productClass=='D001-1' }"><option value="D001-1">高档</option></c:if>
  		<c:if test="${dfile.productClass=='D001-2' }"><option value="D001-2">中档</option></c:if>
  		<c:if test="${dfile.productClass=='D001-3' }"><option value="D001-3">低档</option></c:if>
		<option value="D001-1">高档</option>

		<option value="D001-2">中档</option>

		<option value="D001-3">低档</option>


  </select>
</td>
</tr>
<tr height=20 class="TR_STYLE1">
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">计量单位</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%"><input type="text"  class="INPUT_STYLE1" name="personalUnit" style="width:49%" value="${dfile.personalUnit }"></td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">计量值</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%"><input type="text"  class="INPUT_STYLE1" name="personalValue" style="width:49%" value="${dfile.personalValue }"></td>
 </tr>
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">市场单价(元)</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%"><input type="text"  class="INPUT_STYLE1" name="listPrice" style="width:49%" value="${dfile.listPrice }"></td>
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">计划成本单价 </td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%"><input type="text"  class="INPUT_STYLE1" name="costPrice" style="width:49%" value="${dfile.costPrice }"></td>
 </tr>
	
 <tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE7" width="11%" height="65">供应商集合 &nbsp; </td>
<td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%">
<textarea rows=4 class="TEXTAREA_STYLE1" name="providerGroup" style="width: 280px; " >${dfile.providerGroup }</textarea>
</td>
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE7" width="11%" height="65">产品描述 &nbsp; </td>
<td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%">
<textarea rows=4 class="TEXTAREA_STYLE1" name="productDescribe" style="width: 280px; ">${dfile.productDescribe }</textarea>
</td>
 </tr>
	
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">产品经理</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%">
 <select class="SELECT_STYLE1" name="responsiblePerson" style="width:49%">
	<option value="${dfile.responsiblePerson }">${dfile.responsiblePerson }</option>
	<option value="ADAM">ADAM</option>
	<option value="HUGH">HUGH</option>
	<option value="STEVE">STEVE</option>
	<option value="BUCKY">BUCKY</option>
	<option value="TONY">TONY</option>
 </select></td>
 
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">登记人</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%"><input type="text"  class="INPUT_STYLE1" name="register" style="width:49%" value="${dfile.register }" readonly="readonly"></td>
 </tr>
	
<tr height=20 class="TR_STYLE1">
 <td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">复核人</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%"><input type="text"  class="INPUT_STYLE1" name="checker" style="width:49%" value=""></td>
<td bgcolor=#D2E9FF bordercolorlight=#000000 bordercolordark=#000000 align=right class="TD_STYLE1" width="11%">登记时间&nbsp;</td>
 <td valign=top bgcolor=#eeeeee bordercolor=#000000 class="TD_STYLE2" width="13%"><input type="text"  class="INPUT_STYLE1" style="width:49%" value="${regisTime }" readonly="readonly"></td>
 </tr>
 </table>
 </form>
  
 </div>
</div>
        </div></div>
        <div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>
    </div>
</div>
<script language="javascript">
 var onecount;
 subcat = new Array();
	 subcat00 = new Array();
  
 subcat[0] = new 
 Array("2","01/电子/01/计算机","01/电子");
	 subcat00[0] = new 
 Array("2","01/计算机","01/电子");
  
 
 onecount=1;
 
 function changelocation(locationid)
  {
  mutiValidation.select2.length = 0; 
 
  var locid=locationid;
  var i;
  mutiValidation.select2.options[mutiValidation.select2.length]=new Option("",""); 
  for (i=0;i < onecount; i++)
  {
 		 if(locid==""||locid==null){mutiValidation.select2.options[mutiValidation.select2.length]=
 			 new Option(subcat00[i][1],subcat[i][1]);}//如果select1为空，则select2选择全部值
  else if (subcat[i][2] == locid)
  { 
   mutiValidation.select2.options[mutiValidation.select2.length] = new Option(subcat00[i][1], 
 subcat[i][1]);
  } 
  } 
 }

 var onecount1;
 subcat1 = new Array();
	 subcat11 = new Array();
  
 subcat1[0] = new Array("2","01/电子/01/计算机/01/服务器","01/电子/01/计算机");
	 subcat11[0] = new Array("2","01/服务器","01/电子/01/计算机");
  
 
 onecount1=1;
 
 function changelocation1(locationid1)
  {
  mutiValidation.select3.length = 0; 
 
  var locid1=locationid1;
  var j;
  mutiValidation.select3.options[mutiValidation.select3.length]=new Option("",""); 
  for (j=0;j < onecount1; j++)
  {
 		 if(locid1==""||locid1==null)
 		 {mutiValidation.select3.options[mutiValidation.select3.length]=new Option(subcat11[j][1],subcat1[j][1]);}
  else if (subcat1[j][2] == locid1){ 
   mutiValidation.select3.options[mutiValidation.select3.length] = new Option(subcat11[j][1],subcat1[j][1]);
  } 
  } 
 }

var onecount2;
 subcat2 = new Array();
	 subcat22 = new Array();
  
 
 onecount2=0;
 
 function changelocation2(locationid2)
  {
  mutiValidation.select4.length = 0; 
 
  var locid2=locationid2;
  var m;
  mutiValidation.select4.options[mutiValidation.select4.length]=new Option("",""); 
  for (m=0;m < onecount2; m++)
  {
 		 if(locid2==""||locid2==null)
 		 {mutiValidation.select4.options[mutiValidation.select4.length]=new Option(subcat22[m][1],subcat2[m][1]);}
  else if (subcat2[m][2] == locid2){ 
   mutiValidation.select4.options[mutiValidation.select4.length] = new Option(subcat22[m][1],subcat2[m][1]);
  } 
  } 
 }
</script>
</body>
</html>
