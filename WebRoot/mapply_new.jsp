<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>生产计划审核</title>
<%@ include file="commons/meta.jsp"%>
</head>
<body style="width:95%;height:80%;">

	<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
		<c:redirect url="login.jsp" />
	</c:if>
	<form action="mapplyController/submitlist.do" method="post">
		<h2 style="text-align:center;">新生产计划单</h2>
		<div align="right">
			<a href="#" class="easyui-linkbutton" onclick="goFileList()">添加产品</a>&nbsp;<a
				href="#" class="easyui-linkbutton" onclick="goSubmit()">提交</a>
		</div>
		<!-- 新增菜单信息窗口 -->
		<div id="fileWindow"></div>

		<div>
			<table>
				<tbody>
					<tr>
						<td colspan="2">生产理由：新发生</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td colspan="2">登记人：<input type="text" id="register"
							name="register" value="${NEWER_USER_LOGIN_INFO.username }"
							readonly="readonly">
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td colspan="2">登记时间：<input type="text" readonly="readonly" id="newclock" name="newclock"><SCRIPT
								type=text/javascript>
							var clock = new Clock();
							clock.display(document.getElementById("newclock"));
						</SCRIPT></td>
					</tr>
				</tbody>
			</table>
		</div>
		<table id="filetable" border="1px">
			<thead>
				<tr>
					<th style="width: 100px">产品名称</th>
					<th style="width: 100px">产品编号</th>
					<th style="width: 100px">产品描述</th>
					<th style="width: 100px">用途类型</th>
					<th style="width: 100px">数量</th>
					<th style="width: 100px">单位</th>
					<th style="width: 100px">单价(元)</th>
					<th style="width: 100px">小计(元)</th>
					<th style="width: 100px">设计人</th>
					<th style="width: 100px">操作</th>
				</tr>
			</thead>
		</table>
		<p></p>
		<div>
			备注：<br> <br>
			<textarea id="remark" name="remark" style="width: 50%; height: 100px"></textarea>
		</div>
	</form>
	<script type="text/javascript">
		function closeWindowOfMenuView() {
			$("#checkWindow").window("close", true);
		}
		function goFileList() {
			$("#fileWindow").window({
				title : "添加产品",
				width : 1100,
				height : 500,
				modal : true,
				minimizable : false,
				href : "mapply_filelist.jsp"
			});
		}
		//计算总额
		function amouttotal(productId) {
			var a = document.getElementsByName("productId");
			var b = document.getElementsByName("amount");
			var c = document.getElementsByName("total");
			var d = document.getElementsByName("listPrice");
			for (var i = 0; i < a.length; i++) {
				if (a[i].value == productId) {
					c[i].value = b[i].value * d[i].value;
				}
			}
		}
		//给表格添加产品数据
		function add(productId, productName, productDescribe, type,
				personalUnit, listPrice, register) {
			//$("#filetable").insertRow[0];
			var length = document.getElementById("filetable").rows.length;
			if (length > 1) {
				var a = document.getElementsByName("productId");
				for (var i = 0; i < a.length; i++) {
					if (a[i].value == productId) {
						return false;
					}
				}
			}
			var x = document.getElementById('filetable').insertRow(1);
			var c1 = x.insertCell(0);
			var c2 = x.insertCell(1);
			var c3 = x.insertCell(2);
			var c4 = x.insertCell(3);
			var c5 = x.insertCell(4);
			var c6 = x.insertCell(5);
			var c7 = x.insertCell(6);
			var c8 = x.insertCell(7);
			var c9 = x.insertCell(8);
			var c10 = x.insertCell(9);
			c1.innerHTML = "<input type='text' id='productName' name='productName' readonly='readonly' value='"+productName+"'>";
			c2.innerHTML = "<input type='text' id='productId' name='productId' readonly='readonly' value='"+productId+"'>";
			c3.innerHTML = "<input type='text' id='productDescribe' name='productDescribe' readonly='readonly' value='"+productDescribe+"'>";
			c4.innerHTML = "<input type='text' id='type' name='type' readonly='readonly' value='"+type+"'>";
			c5.innerHTML = "<input type='number' id='amount' name='amount' value='0' onblur=amouttotal('"
					+ productId + "')>";
			c6.innerHTML = "<input type='text' id='personalUnit' name='personalUnit' readonly='readonly' value='"+personalUnit+"'>";
			c7.innerHTML = "<input type='text' id='listPrice' name='listPrice' readonly='readonly' value='"+listPrice+"'>";
			c8.innerHTML = "<input type='number' id='total' name='total' readonly='readonly' value='0'>";
			c9.innerHTML = "<input type='text' id='designer' name='designer' readonly='readonly' value='"+register+"'>";
			c10.innerHTML = "<a href='#' onclick=removeRow('" + productId
					+ "')>删除</a>";
		}
		//提交表格数据
		function goSubmit() {
			var flag = window.confirm("是否提交？");
			if (flag) {
				var table = document.getElementById("filetable");
				var productId = document.getElementsByName("productId");
				var productIds = [];
				var amount = document.getElementsByName("amount");
				var amounts = [];
				for (var a = 0; a < amount.length; a++) {
					if (amount[a].value <= 0) {
						alert("产品数量不符合规则！");
						return;
					}
				}
				for (var a = 0; a < productId.length; a++) {
					productIds.push(productId[a].value);
					amounts.push(amount[a].value);
				}
				var register = document.getElementById("register").value;
				var remark = document.getElementById("remark").value;
				$.get("mapplyController/submitlist.do?productIds="
						+ productIds.join(",") + "&&amounts="
						+ amounts.join(",") + "&&register=" + register
						+ "&&remark=" + remark, function(data) {
					$.messager.show({
						title : "提示",
						msg : "提交" + data + "条数据成功!"
					});
					for (var i = 0; i < productIds.length; i++) {
						table.deleteRow(i + 1);
					}
				});
			}
		}
	</script>
</body>
<script type="text/javascript">
	$(function(){
		var time=new Date();
		var year=time.getFullYear();
		var month=time.getMonth()+1;
		var date=time.getDate();
		var hour=time.getHours();
		var minute=time.getMinutes();
		var second=time.getSeconds();
		$("#newclock").val(year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second);
	});
</script>
</html>





