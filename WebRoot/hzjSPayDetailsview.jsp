<%--
  author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>审核详情</title>
<%@ include file="../commons/meta.jsp"%>

</head>
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>

<body>
	<style>
.input {
	width: 200px;
	height: 20px;
	border: 1px solid #95B8E7;
}

.btn {
	width: 100px;
	height: 20px;
	border: 1px solid #95B8E7;
}
</style>
	<h2 style="text-align:center;">入库申请单</h2>
		<div>
			<div align="right">
				<span class="radioSpan"> <input type="radio" id="checkTag1"
					name="checkTag" value="S001-2" checked="checked">未通过 <input
					type="radio" id="checkTag2" name="checkTag" value="S001-1">通过
				</span> <a id="btn" href="#" class="easyui-linkbutton"
					onclick="check('${spay.payId }')">确认</a>&nbsp;<a
					href="javascript:closeWindowOfMenuView()" class="easyui-linkbutton">返回</a>&nbsp;
			</div>
		</div>
		<div>
			<table width="650" height="100" border="1" style="margin: 10px;">
				<tr>
					<td colspan="8">申请单编号：${spay.payId }</td>
				</tr>
				<tr>
					<td colspan="4">入库人:${spay.storer }</td>
					<td colspan="4">入库理由:${spay.reason}</td>
				</tr>
				
				<tr>
					<th>序号</th>
					<th>产品名称</th>
					<th>产品编号</th>
					<th>描述</th>
					<th>数量</th>
					<th>单位</th>
					<th>成本单价(元)</th>
					<th>小计(元)</th>
				</tr>
				<c:forEach var="spaydetails" items="${spaydetails2 }">
				<tr>
					<td>${spaydetails.id }</td>
					<td>${spaydetails.productName }</td>
					<td>${spaydetails.productId }</td>
					<td>${spaydetails.productDescribe }</td>
					<td>${spaydetails.amount}</td>
					<td>${spaydetails.amountUnit }</td>
					<td>${spaydetails.costPrice}</td>
					<td>${spaydetails.subtotal}</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4">总件数:${spay.amountSum}</td>
					<td colspan="4">总金额:${spay.costPriceSum }</td>
				</tr>
			</table>

			<div style="margin: 10px;">
				&nbsp;&nbsp;登记人：<input readonly="readonly" value="${spay.register}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登记时间：
				<fmt:formatDate value="${spay.registerTime}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</div>
			<p></p>
			<div style="margin: 10px;">
				&nbsp;&nbsp;审核人：<input id="checker" name="checker"
					class="easyui-validatebox" data-options="validType:'maxLength[20]'" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核时间：<SPAN
					id="checkTime"></SPAN>
				<SCRIPT type=text/javascript>
					var clock = new Clock();
					clock.display(document.getElementById("checkTime"));
				</SCRIPT>
				</br> </br> <br/> &nbsp;&nbsp;备&nbsp;注：<input id="remark" name="remark">
			</div>
	</div>
	<script type="text/javascript">
	function closeWindowOfMenuView() {
		$("#editPayId").window("close", true);
	}
	function check(payId) {
		var check = "不通过";
		var checkTag = "";
		if (document.getElementById("checkTag1").checked) {
			check = "不通过";
			checkTag = document.getElementById("checkTag1").value;
		}
		if (document.getElementById("checkTag2").checked) {
			check = "通过";
			checkTag = document.getElementById("checkTag2").value;
		}
		var flag = window.confirm("该表单审核" + check + ",是否提交？");
		if (flag) {
			var checker = $("#checker").val();
			var remark = $("#remark").val();
			$.ajax({
				cache : true,
				type : "POST",
				url : "hzjspayController_check.do",
				data : {
					"payId" : payId,
					"checker" : checker,
					"checkTag" : checkTag,
					"remark" : remark
				},
				async : false,
				success : function(data) {
					if (data) {
						$.messager.show({
							title : "提示",
							msg : "审核" + data + "条数据成功!"
						});
						$("#empDataGrid").datagrid("load", {});
						$("#editPayId").window("close", true);
						$("#empDataGrid").combotree("reload");
					}
				}
			});
		}
	}
	</script>
</body>
</html>





