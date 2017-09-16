<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ include file="commons/meta.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'procedure.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function UpdateParent() {
	 
		var tab1 = window.opener.document.getElementById("tab1");
		var a= window.opener.document.getElementsByName("checkbox");
		for(var i=0;i<a.length;i++){
		//alert(a[i].value);
		if(a[i].value==1){
		  return false;
		}
		}
		var newTr = tab1.insertRow();
		var newTd0 = newTr.insertCell();
		var newTd1 = newTr.insertCell();
		var newTd2 = newTr.insertCell();
		var newTd3 = newTr.insertCell();
		var newTd4 = newTr.insertCell();
		var newTd5 = newTr.insertCell();
		var newTd6 = newTr.insertCell();
		newTd0.innerHTML = "<input type='checkbox'  class='CHECKBOX_STYLE1' value='1' name='checkbox' id='checkLine'>" ;
 		newTd1.innerHTML = "<input  class='INPUT_STYLE4' name='procedureName' value='组装' readonly='readonly' type='text' >";
 		newTd2.innerHTML ="<input  class='INPUT_STYLE4' name='procedureID' value='1' readonly='readonly' type='text' >";
 		newTd3.innerHTML = "<input  class='INPUT_STYLE4' name='procedureDescribe' type='hidden' >";
 		newTd4.innerHTML ="<input  class='INPUT_STYLE5' name='labourHourAmount' type='text'>";
 		newTd5.innerHTML ="<input  class='INPUT_STYLE5' name='amountUnit' type='text'>";
 		newTd6.innerHTML ="<input  class='INPUT_STYLE5' name='costPriceSum' type='text'>";
	}
	function UpdateParent2() {
		var tab1 = window.opener.document.getElementById("tab1");
		var a= window.opener.document.getElementsByName("checkbox");
		for(var i=0;i<a.length;i++){
		//alert(a[i].value);
		if(a[i].value==2){
		  return false;
		}
		}
		var newTr = tab1.insertRow();
		var newTd0 = newTr.insertCell();
		var newTd1 = newTr.insertCell();
		var newTd2 = newTr.insertCell();
		var newTd3 = newTr.insertCell();
		var newTd4 = newTr.insertCell();
		var newTd5 = newTr.insertCell();
		var newTd6 = newTr.insertCell();
		newTd0.innerHTML = "<input type='checkbox'  class='CHECKBOX_STYLE1' value='2' name='checkbox' id='checkLine'>" ;
 		newTd1.innerHTML = "<input  class='INPUT_STYLE4' name='procedureName' readonly='readonly' type='text' value='包装'>";
 		newTd2.innerHTML ="<input  class='INPUT_STYLE4' name='procedureID' readonly='readonly' type='text'value='2' >";
 		newTd3.innerHTML = "<input  class='INPUT_STYLE4' name='procedureDescribe' type='hidden' >";
 		newTd4.innerHTML ="<input  class='INPUT_STYLE5' name='labourHourAmount' type='text'>";
 		newTd5.innerHTML ="<input  class='INPUT_STYLE5' name='amountUnit' type='text'>";
 		newTd6.innerHTML ="<input  class='INPUT_STYLE5' name='costPriceSum' type='text'>";
	}
	function UpdateParent3() {
		var tab1 = window.opener.document.getElementById("tab1");
		var a= window.opener.document.getElementsByName("checkbox");
		for(var i=0;i<a.length;i++){
		//alert(a[i].value);
		if(a[i].value==3){
		  return false;
		}
		}
		var newTr = tab1.insertRow();
		var newTd0 = newTr.insertCell();
		var newTd1 = newTr.insertCell();
		var newTd2 = newTr.insertCell();
		var newTd3 = newTr.insertCell();
		var newTd4 = newTr.insertCell();
		var newTd5 = newTr.insertCell();
		var newTd6 = newTr.insertCell();
		newTd0.innerHTML = "<input type='checkbox'  class='CHECKBOX_STYLE1' value='3' name='checkbox' id='checkLine'>" ;
 		newTd1.innerHTML = "<input  class='INPUT_STYLE4' name='procedureName' readonly='readonly' value='测试' type='text' >";
 		newTd2.innerHTML ="<input  class='INPUT_STYLE4' name='procedureID' readonly='readonly' value='3' type='text' >";
 		newTd3.innerHTML = "<input  class='INPUT_STYLE4' name='procedureDescribe' type='hidden' >";
 		newTd4.innerHTML ="<input  class='INPUT_STYLE5' name='labourHourAmount' type='text' id='labourHourAmount'>";
 		newTd5.innerHTML ="<input  class='INPUT_STYLE5' name='amountUnit' type='text'>";
 		newTd6.innerHTML ="<input  class='INPUT_STYLE5' name='costPriceSum' type='text' id='costPrice'>";
	}
	function childInvokeParent() {
		var parentVairous = window.opener.window.parentVairous;
		alert(parentVairous);
	}
</script>

</head>

<body>
	<form action="" method="post">
		<table class="TABLE_STYLE3" width="100%">
			<tr height=20 class="TR_STYLE1">
				<td>产品名称</td>
				<td>产品编号</td>
				<td>产品描述</td>
				<td>操作</td>
			</tr>
			<tr>
				<td><input type="text" readonly="readonly" value="1" id="id1" style="border: none;"></td>
				<td><input type="text" readonly="readonly" value="组装"
					id="name1" style="border: none;"></td>
				<td>组装</td>
				<td><input type="button" value="添加" onclick="UpdateParent();"></td>
			</tr>
			<tr>
				<td><input type="text" readonly="readonly" value="2" id="id2" style="border: none;"></td>
				<td><input type="text" readonly="readonly" value="包装"
					id="name2" style="border: none;"></td>
				<td>组装</td>
				<td><input type="button" value="添加" onclick="UpdateParent2();"/></td>
			</tr>
			<tr>
				<td><input type="text" readonly="readonly" value="3" id="id3" style="border: none;"></td>
				<td><input type="text" readonly="readonly" value="测试"
					id="name3" style="border: none;"></td>
				<td>测试</td>
				<td><input type="button" value="添加" onclick="UpdateParent3();"/></td>
			</tr>
		</table>

	</form>
</body>
</html>
