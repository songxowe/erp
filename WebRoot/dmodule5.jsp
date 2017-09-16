<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>物料组成设计单</title>
<%@ include file="commons/meta.jsp"%>
</head>

<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>

<body>
	<form action="xinYouDmoduleController_save.do" method="post">
		<h2 style="text-align:center;">物料组成设计单</h2>
		<div align="right">
			<a href="#" class="easyui-linkbutton" onclick="goFileList()">添加产品</a>&nbsp;
			<input type="submit" value="提交" />
		</div>
		<!-- 新增菜单信息窗口 -->
		<div id="fileWindow"></div>

		<div>
			<table>
				<tbody>
					<tr>

						<td colspan="2">产品编号：</td>
						<td ><input type="hidden" name="productId2"
							value="${dfile.productId }">${dfile.productId }</td>
					</tr>
					<br>
					<tr>
						<td colspan="2">产品名称：</td>
						<td name="productName1">${dfile.productName }</td>
						<td colspan="2">设计人：</td>
						<td><input type="text" id="designer" name="designer"
							value="${NEWER_USER_LOGIN_INFO.username}" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<br> <br>
		<div style="width: 70%">
			<table id="filetable" border="1" cellspacing="0" cellpadding="0"
				style="width: 100%">
				<thead>
					<tr style="width: 70%;height: 10%">
						<td>产品名称</td>
						<td>产品编号</td>
						<td>产品描述</td>
						<td>用途类型</td>
						<td>数量</td>
						<td>单位</td>
						<td>计划成本单价单价(元)</td>
						<td>小计(元)</td>
						<td>操作</td>
					</tr>
				</thead>
			</table>
		</div>
		<p></p>
		<div>
			登记人：<span>${dfile.register }</span>&nbsp;&nbsp;&nbsp; 登记时间：<input
				class="easyui-datetimebox" name="registerTime"
				data-options="required:true,showSeconds:false" value=""
				style="width:150px"> <br> <br>设计要求：<br> <br>
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
				width : 750,
				height : 320,
				modal : true,
				minimizable : false,
				href : "dmodule4.jsp"
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
			var x = document.getElementById('filetable').insertRow();
			var c1 = x.insertCell();
			var c2 = x.insertCell();
			var c3 = x.insertCell();
			var c4 = x.insertCell();
			var c5 = x.insertCell();
			var c6 = x.insertCell();
			var c7 = x.insertCell();
			var c8 = x.insertCell();
			var c9 = x.insertCell();
			c1.innerHTML = "<input type='text' id='productName' name='productName' readonly='readonly' value='"+productName+"'>";
			c2.innerHTML = "<input type='text' id='productId' name='productId' readonly='readonly' value='"+productId+"'>";
			c3.innerHTML = "<input type='text' id='productDescribe' name='productDescribe' readonly='readonly' value='"+productDescribe+"'>";
			c4.innerHTML = "<input type='text' id='type' name='type' readonly='readonly' value='"+type+"'>";
			c5.innerHTML = "<input type='number' id='amount' name='amount' value='0' onblur=amouttotal('"
					+ productId + "')>";
			c6.innerHTML = "<input type='text' id='personalUnit' name='personalUnit' readonly='readonly' value='"+personalUnit+"'>";
			c7.innerHTML = "<input type='text' id='costPrice' name='costPrice' readonly='readonly' value='"+costPrice+"'>";
			c8.innerHTML = "<input type='number' id='subtotal' name='subtotal' readonly='readonly' value='0'>";
			c9.innerHTML = "<a href='#' onclick=removeRow('" + productId
					+ "')>删除</a>";
		}
		//提交表格数据
		function goSubmit() {
			var flag = window.confirm("是否提交？");
			if (flag) {
				//var productId1 = document.getElementsByName("productId1");//商品编号
				//var productName1 = document.getElementsByName("productName1");//商品名称
				//var designer = document.getElementsByName("designer");//设计人
				//var registerTime = document.getElementsByName("registerTime");//登记时间
				//var moduleDescribe = document
				//		.getElementsByName("moduleDescribe");//设计要求
				var amount = document.getElementsByName("amount");//数量
				var subtotal = document.getElementsByName("subtotal");//小计
				var amounts = [];
				var subtotals = [];
				for (var a = 0; a < amount.length; a++) {
					if (amount[a].value <= 0) {
						alert("产品数量不符合规则！");
						return;
					}
				}
				for (var a = 0; a < amounts.length; a++) {
					subtotals.push(subtotal[a].value);
					amounts.push(amount[a].value);
				}
				$.get(
						"mapplyController/xinYouDmoduleController_save.do?designer="
								+ designer.join(",") + "&&registerTime="
								+ registerTime.join(",") + "&&amounts="
								+ amounts.join(",") + "&&subtotals="
								+ subtotals.join(",") + "&&productId1="
								+ productId1.join(",") + "&&productName1="
								+ productName1.join(",") + "&&moduleDescribe="
								+ moduleDescribe, function(data) {
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
</html>