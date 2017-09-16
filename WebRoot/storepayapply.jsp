<%--
	author:SONG
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date = format.format(new Date());
%>

<!DOCTYPE HTML>
<html>
<head>
<title>用户管理</title>
<%@ include file="commons/meta.jsp"%>
<script type="text/javascript">
	function preview() {
		var costPrice = document.getElementsByName("costPrice");
		var amount = document.getElementsByName("amount");
		var subtotal = document.getElementsByName("subtotal");
		var amountSum = document.getElementById("amountSum");
		var costPriceSum = document.getElementById("costPriceSum");
		var sum = 0;
		var pricesum = 0;
		for (var i = 0; i < costPrice.length; i++) {
			subtotal[i].value = costPrice[i].value * amount[i].value;
			sum += parseInt(amount[i].value);
			pricesum += parseInt(subtotal[i].value);
		}
		amountSum.value = sum;
		costPriceSum.value = pricesum;
	}
</script>
<style type="text/css">
table.gridtable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}

table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>

</head>

<body style="height:50%;width:80%;">

	<div style="margin: 10px 30px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add"
			onclick="user_obj.setUserRole();">添加产品</a>&nbsp;&nbsp; <a href="#"
			class="easyui-linkbutton" iconCls="icon-remove"
			onclick="user_obj.delSelect()">删除产品</a>&nbsp;&nbsp; <a href="#"
			class="easyui-linkbutton" iconCls="icon-edit" onclick="preview()">预览</a>
	</div>
	<h1 style="text-align:center">入库申请单</h1>
	<br>
	<form id="shenchen" action="paystorebuildController.do" method="post">
		<div align="center">
			入库人：<input type="text" name="storer" id="storer"
				style="text-decoration: underline;" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			入库理由：<select id="reason" name="reason">
				<option value="普通出库">普通入库</option>
				<option value="生产调度">生产调度</option>
			</select>
		</div>
		<br> <br>
		<div style="height:150px; ">
			<table id="tab1" class="gridtable" align="center">
				<tr>
					<th width="5%"></th>
					<th width="10%">产品ID</th>
					<th width="10%">产品编号</th>
					<th width="10%">产品名称</th>
					<th width="10%">产品类型</th>
					<th width="8%">产品单位</th>
					<th width="10%">产品成本</th>
					<th width="10%">数量</th>
					<th width="10%">小计</th>
				</tr>
			</table>
		</div>
		<div align="center">
			总件数：<input id="amountSum" name="amountSum" style="border: none;">
			总金额：<input id="costPriceSum" name="costPriceSum"
				style="border: none;"><br> <br> <br>登记人：<input
				id="register" name="register" style="border: none;"> 登记时间：<input
				type="text" name="registerTime" value="<%=date%>"
				style="border: none;" /><br> <br> 备注： <input type="text"
				id="remark" name="remark" size="20" style="width:200px;height:50px;" />
			<input type="button" value="提交" onclick="yanzhen()">
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			user_obj = {
				delSelect : function() {
					var checkboxs = document.getElementsByName("isChecked");
					var table = document.getElementById("tab1");
					var tr = table.getElementsByTagName("tr");
					for (var i = 0; i < checkboxs.length; i++) {
						if (tr.length == 1) {
							checkboxs[i].checked = false;
							return;
						}
						if (checkboxs[i].checked == true) {
							user_obj.removeTr(checkboxs[i]);
							i = -1;
						}
					}
				},
				removeTr : function(obj) {
					var sTr = obj.parentNode.parentNode;
					sTr.parentNode.removeChild(sTr);
				},

				search : function() {//查询
					$("#userDataGrid").datagrid("load", {
						username : $.trim($("#username").val()),
						status : $("#status").val()
					});
				},

				setUserRole : function() {
					window.open("payfilelist.jsp", '_blank',
							'width=600,height=400,top=100px,left=0px');
				},
			};
		});

		function yanzhen() {
			var storer1 = document.getElementById("storer").value;
			var register1 = document.getElementById("register").value;
			if (storer1 == "") {
				alert("入库人不能为空");
				return;
			}
			if (register1 == "") {
				alert("登记人不能为空");
				return;
			} else {
				document.getElementById("shenchen").submit();
			}

		}
	</script>
</body>
</html>
