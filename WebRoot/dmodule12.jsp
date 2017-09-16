<%--
	author:SONG
--%>
<%@ page language="java" import="java.util.Date" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title></title>
<%@ include file="commons/meta.jsp"%>
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
	<h2 style="text-align:center;">物料组成设计单</h2>
	<div>
		<div align="right">
			<form action="UpdateState.do" method="post">
				<span class="radioSpan"> <input type="radio" id="checkTag1"
					name="checkTag" value="S001-2" checked="checked">未通过 <input
					type="radio" id="checkTag2" name="checkTag" value="S001-1">通过
				</span> <input type="submit" value="确认">
		</div>
	</div>
	<div align="center">
		<table align="center" border="0"
			style="height:50;width:400;margin: 10px;">
			<tr>
				<td align="left">设计单编号:</td>
				<td><input type="hidden" value="${dmodule.designId }"
					name="designId" />${dmodule.designId }</td>
				<td align="right">设计人:</td>
				<td>${dmodule.designer }</td>
			</tr>
			<tr>
				<td align="left">产品编号:</td>
				<td>${dmodule.productId }</td>
				<td align="right">产品名称:</td>
				<td>${dmodule.productName }</td>
			</tr>
		</table>
		<table align="center" width="460" height="100" border="1"
			cellspacing="0" cellpadding="0" style="margin: 10px;">
			<tr>
				<td style="width:20;height:10">序号</td>
				<td style="width:20;height:10">物料名称</td>
				<td style="width:20;height:10">物料编号</td>
				<td style="width:10;height:10">用途类型</td>
				<td style="width:10;height:10">描述</td>
				<td style="width:10;height:10">数量</td>
				<td style="width:10;height:10">单位</td>
				<td style="width:10;height:10">单价(元)</td>
				<td style="width:10;height:10">小计(元)</td>
			</tr>
			<c:forEach items="${dmDetails }" var="dm" varStatus="rows">
				<tr>
					<td>${rows.index + 1 }</td>
					<td name="productName">${dm.productName }</td>
					<td name="productId">${dm.productId }</td>
					<td name="type">${dm.type=='Y001-2'?'物料':'包装' }</td>
					<td name="productDescribe">${dm.productDescribe }</td>
					<td name="amount">${dm.amount }</td>
					<td name="amountUnit">${dm.amountUnit }</td>
					<td name="costPrice">${dm.costPrice }</td>
					<td name="subtotal">${dm.subtotal}</td>
				</tr>
			</c:forEach>
		</table>
		<table align="center">
			<tr>
				<td colspan="1">物料总成本</td>
				<td colspan="3"><input type="text" style="border:none"
					id="costPriceSum" readonly="readonly" value="${subt }" /></td>
			</tr>
			<tr>
				<td align="left">审核人</td>
				<td><input type="text" id="register" style="border:none"
					name="checker" value="${NEWER_USER_LOGIN_INFO.username }"
					readonly="readonly"></td>
				<td align="right">审核时间</td>
				<td><fmt:formatDate value="<%=new Date()%>"
						pattern="yyyy年MM月dd日HH点mm分ss秒 " /></td>
			</tr>
			<tr>
				<td>设计要求</td>
				<td colspan="3"><textarea id="moduleDescribe"
						class="easyui-validatebox" required="true" style="height:100px;"
						name="moduleDescribe">${dmodule.moduleDescribe }</textarea></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
