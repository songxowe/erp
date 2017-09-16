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
		$.post("<%=request.getContextPath()%>/xyfDfileController_findAll.do",function(data){
		  $("#firstKindName").empty();
		  $(data).find("type").each(function(index){
		  var id=$("id",$(data).find("type")[index]).text();
		  var name=$("name",$(data).find("type")[index]).text();
          $("#firstKindName").append("<option value='"+id+"'>"+name+"</option>");		  
		  });//返回一个集合
		},
		"xml"
		);
		//改变一级分类时触发
		$("#firstKindName").change(function(){
		 $.post("<%=request.getContextPath()%>/xyfDfileController_findAll.do",{"pid":$("#firstKindName").val()},function(data){
		 $("#secondKindName").empty();
		 $("#thirdKindName").empty();
		 $("#thirdKindName").append("<option value=-1>请选择</option>");	
		 $(data).find("type").each(function(index){
		  var id=$("id",$(data).find("type")[index]).text();
		  var name=$("name",$(data).find("type")[index]).text();
          $("#secondKindName").append("<option value='"+id+"'>"+name+"</option>");	
		 });
		 },
		 "xml"
		 );
		});
		//改变二级分类时触发
		$("#secondKindName").change(function(){
		$.post("<%=request.getContextPath()%>/xyfDfileController_findAll.do", {"pid" : $("#secondKindName").val()}, function(data) {
		$("#thirdKindName").empty();
		$(data).find("type").each(
		function(index) {
		var id = $("id",$(data).find("type")[index]).text();
		var name = $("name",$(data).find("type")[index]).text();
		$("#thirdKindName").append("<option value='"+id+"'>" + name+ "</option>");
		});
		}, 
		"xml"
		);
		});
  	
	});
</script>
<script type="text/javascript">
function validateProductName() {
	var productName = document.getElementById("productName").value;
	$.ajax({
		type : "POST",
		url : "xyfDfileController_validate.do",
		data : "productName=" + productName,
		success : function(data) {
			if (data==null||data=="") {
				alert("抱歉！用户名已存在！");
			} 
		}
	});
}	
</script>
<script>
text.oninput=function(){
  text.setCustomValidity("");
};
text.oninvalid=function(){
  text.setCustomValidity("请输入正确的格式");
};
</script>
 <script type="text/javascript">
function checkKind(){
	if($("#productName").val()==null||$("#productName").val()==""){
		alert("产品名不能为空");
		return;
	}else if($("#firstKindName").val()=="-1"||$("#secondKindName").val()=="-1"||$("#thirdKindName").val()=="-1"){
		alert("请选择产品分类");
		return;
	} else if($("#listPrice").val()==null||$("#listPrice").val()==""){
		alert("市场单价不能为空");
		return;
	}else if($("#costPrice").val()==null||$("#costPrice").val()==""){
		alert("计划成本单价不能为空");
		return;
	}else{
		$("#fileForm").submit();
	}
}
</script>
</head>

<body bgcolor="#E9F8F3" oncontextmenu="event.returnValue=true" style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">

<%-- <c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
    <c:redirect url="login.jsp"/>
  </c:if> --%>      
<div class="x-box-mr">       
<div class="x-box-mc">
<div style="height:50px">
<table class="TABLE_STYLE2">
 <tr height="20" class="TR_STYLE1">
 <td class="TD_HANDBOOK_STYLE1">您正在做的业务是：产品设计--产品档案管理--产品档案登记</td>
 </tr>
</table>
</div>
</div>

</div>

<form id="fileForm" action="xyfDfileController_save.do">
<div style="position:absolute;left:900px;top:18px;"><input type="button" value="提交" onclick="checkKind();"/>&nbsp&nbsp<input type="reset" value="清除" /></div>
 
<table bordercolor="#000000" bordercolorlight="#000000" bordercolordark="#000000" border="0" cellspacing="1" cellpadding="1" bgcolor="#006699" align="center" class="TABLE_STYLE1" id="theObjTable">
<tr><td colspan="4"><div style="width:100%; height:12; padding:3px; color:#FFFFFF; font-weight:bold ">产品信息</div></td></tr>
<tr height="20" class="TR_STYLE1">
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%"><font color="red">*</font>产品名称</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="37.4%">
 	<input id="productName" type="text" class="INPUT_STYLE1" style="width:80%" name="productName" onblur="validateProductName()" required="required"/>
 </td>
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%">制造商</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="37.4%"><input type="text" class="INPUT_STYLE1" name="factoryName" style="width:80%"></td>
 </tr>
<tr height="20" class="TR_STYLE1">
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%"><font color="red">*</font>I级分类</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%">
 <select class="SELECT_STYLE1" id="firstKindName" name="firstKindName" style="width:49%">
 		<option value="-1">请选择</option>
  </select> 
</td>
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%"><font color="red">*</font>II级分类</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%">
 <select class="SELECT_STYLE1" id="secondKindName" name="secondKindName" style="width:49%">
 	<option value="-1">请选择</option>
 </select>
</td>
</tr>
<tr height="20" class="TR_STYLE1">
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%"><font color="red">*</font>III级分类</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%">
 <select class="SELECT_STYLE1" id="thirdKindName" name="thirdKindName" style="width:49%">
 	<option value="-1">请选择</option>
 </select>
 </td>
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%">产品简称</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%"><input type="text" class="INPUT_STYLE1" name="productNick" style="width:49%"></td>
		</tr>
 <tr height="20" class="TR_STYLE1">
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%">用途类型</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%">
 <select class="SELECT_STYLE1" name="type" style="width:49%">
  
		<option value="Y001-1">商品</option>

		<option value="Y001-2">物料</option>


  </select>
 </td><td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%">档次级别</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%">
 <select class="SELECT_STYLE1" name="productClass" style="width:49%">
  
		<option value="D001-1">高档</option>

		<option value="D001-2">中档</option>

		<option value="D001-3">低档</option>


  </select>
</td>
</tr>
<tr height="20" class="TR_STYLE1">
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%">计量单位</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%"><input type="text" class="INPUT_STYLE1" name="personalUnit" style="width:49%"></td>
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%">计量值</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%"><input type="text" class="INPUT_STYLE1" name="personalValue" style="width:49%"></td>
				 </tr>
<tr height="20" class="TR_STYLE1">
<td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%"><font color="red">*</font>市场单价(元)</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%"><input type="number" class="INPUT_STYLE1" id="listPrice" name="listPrice" style="width:49%" required="required">请输入数字</td>
 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%"><font color="red">*</font>计划成本单价 </td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%"><input class="INPUT_STYLE1" id="costPrice" name="costPrice" type="number" style="width:49%" required="required">请输入数字</td>
  </tr>
 <tr height="20" class="TR_STYLE1">
<td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE7" width="11%" height="65">供应商集合 &nbsp; </td>
<td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%">
<textarea rows="4" class="TEXTAREA_STYLE1" name="providerGroup" style="width: 232px; "></textarea>
</td>
<td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE7" width="11%" height="65">产品描述 &nbsp; </td>
<td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%">
<textarea rows="4" class="TEXTAREA_STYLE1" name="productDescribe" style="width: 233px; "></textarea>
</td>
</tr>
<tr height="20" class="TR_STYLE1">

 <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%">登记人</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%"><input type="text" class="INPUT_STYLE1" style="width:49%" name="register" value="newer"></td>
  <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%">产品经理</td>
<td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%">
<select class="SELECT_STYLE1" name="responsiblePerson" style="width:49%">
	<option value="">请选择</option>
	<option value="ADAM">ADAM</option>
	<option value="HUGH">HUGH</option>
	<option value="STEVE">STEVE</option>
	<option value="BUCKY">BUCKY</option>
	<option value="TONY">TONY</option>
 </select></td>
 <!-- <td bgcolor="#D2E9FF" bordercolorlight="#000000" bordercolordark="#000000" align="right" class="TD_STYLE1" width="11%">建档时间</td>
 <td valign="top" bgcolor="#eeeeee" bordercolor="#000000" class="TD_STYLE2" width="13%"><input name="registerTime" type="date" width="100%"></td> -->
 
 </tr>
</table>
</form>
</body>
</html>
