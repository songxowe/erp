<%--
  author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>审核详情</title>
<%@ include file="commons/meta.jsp"%>
<script src="js/Clock.js"></script>
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
</head>
<body>

	<h2 style="text-align:center;">生产计划单</h2>
	<div>
		<div align="right">
			<span class="radioSpan"> <input type="radio" id="checkTag1"
				name="checkTag" value="S001-2" checked="checked">未通过 <input
				type="radio" id="checkTag2" name="checkTag" value="S001-1">通过
			</span> <a id="btn" href="#" class="easyui-linkbutton"
				onclick="check('${mapply.applyId}')">确认</a>&nbsp;<a
				href="javascript:history.go(-1)" class="easyui-linkbutton">返回</a>&nbsp;
		</div>

	</div>
	<div>
		<table width="670" height="100" border="1" style="margin: 10px;">
			<tr>
				<th colspan="5">计划单编号：${mapply.applyId}</th>
			</tr>
			<tr>
				<th>产品编号</th>
				<th>产品名称</th>
				<th>描述</th>
				<th>数量</th>
				<th>出库单编号集合</th>
			</tr>
			<tr>
				<td>${mapply.productId }</td>
				<td>${mapply.productName }</td>
				<td>${mapply.productDescribe }</td>
				<td>${mapply.amount}</td>
				<td></td>
			</tr>
		</table>
		<div style="margin: 10px;">
			登记人：<input readonly="readonly" value="${mapply.register}" />&nbsp;&nbsp;登记时间：
			<fmt:formatDate value="${mapply.registerTime}" type="both" />
		</div>
		<p></p>
		<div style="margin: 10px;">
			审核人：<input id="checker" name="checker"
				value="${NEWER_USER_LOGIN_INFO.username}" readonly="readonly" /><input
				type="hidden" id="mapplyId" name="mapplyId"
				value="${mapply.applyId}">&nbsp;&nbsp; 审核时间：<input type="text" style="border:none" readonly="readonly" id="newclock" name="newclock">
			<SCRIPT type=text/javascript>
				var clock = new Clock();
				clock.display(document.getElementById("checkclock"));
			</SCRIPT>
			<script type="text/javascript">
				function closeWindowOfMenuView() {
					$("#checkWindow").window("close", true);
				}
				function check(applyId) {
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
						var mapplyId = $("#mapplyId").val();
						var checker = $("#checker").val();
						$.ajax({
							cache : true,
							type : "POST",
							url : "/softfactory/mapplyController/check.do",
							data : {
								"mapplyId" : mapplyId,
								"checker" : checker,
								"checkTag" : checkTag
							},
							async : false,
							success : function(data) {
								if (data) {
									$.messager.show({
										title : "提示",
										msg : "审核" + data + "条数据成功!"
									});
									window.location.href="/softfactory/mapply_checklist.jsp";
								}
							}
						});
					}
				}
			</script>
		</div>
	</div>

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





