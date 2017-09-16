<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE HTML>
<html>
<head>
<title>工序物料设计单</title>
<%@ include file="commons/meta.jsp"%>
</head>
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>

<body oncontextmenu="event.returnValue=true"
	style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff")>
	<div style="text-align: center;">
		<h2>工序物料设计单</h2>
	</div>

	<form id="a" action="<%=request.getContextPath()%>/Modul/goPreview.do"
		method="post">
		<div>
		<div align="right"><a href="javascript:history.go(-1);opener.location.reload()">返回主页</a></div>
		制造:<font color="blue">${MdProcedure.productName }</font>产品，供选择的物料清单如下：&nbsp;;
		</div>
		<br>
		<br>
		<div style="text-align: center;">
			<p>工序单编号：${MdProcedure.designId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工时总成本：${MdProcedure.costPriceSum
				}</p>
			<br>
			<p>设计人：${MdProcedure.designer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登记时间：<fmt:formatDate value="${MdProcedure.registerTime}" type="date" dateStyle="default" pattern=" yyyy年MM月dd日 E"/></p>
		</div>
		<br> <input name="designId" type="hidden"
			value="${MdProcedure.designId }"><input name="id" type="hidden"
			value="${MdProcedure.id}">  <input name="type"
			type="hidden" value="物料">
		<table bordercolor=#000000 bordercolorlight=#848284
			bordercolordark=#eeeeee border=1 cellspacing=0 cellpadding=0
			align=center class="TABLE_STYLE5">
			<tr height=20 bgcolor=#D2E9FF class="TR_STYLE2">
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>序号</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
					style="width: 132px; "><font class="resizeDivClass"
					onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>物料名称</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
					style="width: 256px; "><font class="resizeDivClass"
					onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>物料编号</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
					style="width: 240px; "><font class="resizeDivClass"
					onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>描述</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>设计数量</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>单位</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>单价（元）</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>本工序数量</td>
			</tr>
			<tr height=20 class="TR_STYLE1">
				<c:forEach items="${pms}" var="str" varStatus="rows">
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><input
						name="detailsNumber" type="hidden" value="${rows.index + 1 }">${rows.index + 1 }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><input
						name="productName" type="hidden" value="${str.productName }">${str.productName }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><input
						name="productId" type="hidden" value="${str.productId }">${str.productId }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><input
						name="productDescribe" type="hidden"
						value="${str.productDescribe }">${str.productDescribe }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><input
						id="amountload" name="amountload" type="hidden" value="${str.amount }">${str.amount }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><input
						name="amountUnit" type="hidden" value="${str.amountUnit }">${str.amountUnit }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><input
						name="costPrice" type="hidden" value="${str.costPrice }">${str.costPrice }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">
					<input name="parentId"
			type="hidden" value="${str.detid }"><input 
						id="amount" class="INPUT_STYLE5" name="amount" type="number" required="required"></td>
			</tr>
			</c:forEach>
			</form>
		</table>
		<br>
		<br>
		<div style="text-align: center;">
			<input type="button" onclick="ccc()" value="提交" />
		</div>
		<script type="text/javascript">
			function isreg(str) {
				var reg = /^\+?[1-9]\d*$/;
				return reg.test(str);
			}

			function checkamount() {
				var flag = false;
				var amount = document.getElementsByName("amount");
				//alert("正在验证输入的本工序数量："+amount.length+"个");
				for(var i=0;i<amount.length;i++){
					if(!isreg(amount[i].value)){
						alert("输入的参数有误！请重新输入！");
						return flag;
					}else{
						return true;
					}
				}
			}

			function ccc() {
				var amountload = document.getElementsByName("amountload");
				var amount = document.getElementsByName("amount");
				for(var i=0;i<amountload.length;i++){
					if(amount[i].value == ""){
						alert("本工序数量不能为空！");
						return;
					}
					if(checkamount()){
						if(amount[i].value>amountload[i].value){
							alert("不能大于设计数量！");
							return;
						}
					}
				}document.getElementById("a").submit();
			}
		</script>
</body>
</html>
