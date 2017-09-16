<%--
  author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<!-- 显示查询出的商品页 -->
<!DOCTYPE HTML >
<html>
<head>
<%@ include file="commons/meta.jsp"%>
</head>

<body bgcolor="#ffffff" oncontextmenu="event.returnValue=true"
	style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">


	<table id="dfiledatagrid"></table>
	<script type="text/javascript">
		$(function() {
			$("#dfiledatagrid").datagrid({
				title : "",
				width : 835,
				height : 320,
				rownumbers : true,
				url : "dfileController.do",
				columns : [ [

				{
					field : "productId",
					title : "产品编号",
					width : 100,
					height : 40
				}, {
					field : "productName",
					title : "产品名称",
					width : 100,
					height : 40
				}, {
					field : "authorize1",
					title : "档次级别",
					width : 100,
					height : 40,
					formatter : function(value, rowData, rowIndex) {
						var temp = rowData["productClass"];
						if (temp == "D001-1") {
							return "高档";
						} else if (temp == "D001-1") {
							return "中档";
						} else {
							return "低端";
						}
					}
				}, {
					field : "firstKindName",
					title : "一级分类",
					width : 100,
					height : 40
				}, {
					field : "secondKindName",
					title : "二级分类",
					width : 100,
					height : 40
				}, {
					field : "thirdKindName",
					title : "三级分类",
					width : 100,
					height : 40
				}, {
					field : "authorize",
					title : "用途类型",
					width : 100,
					formatter : function(value, rowData, rowIndex) {
						var temp = rowData["type"];
						if (temp == "Y001-1") {
							return "商品";
						} else {
							return "包装";
						}
					}
				}, {
					field : "op1",
					title : "定制设计单",
					width : 100,
					height : 40,
					formatter : function(value, rowData, rowIndex) {
						var dmoduleId = rowData["id"];
						var url = "dfileControllerlist.do?id=" + dmoduleId;
						return " <a href="+url+"  >定制设计单</a>";
					}
				},

				] ],
				toolbar : "#searchRoleForm",
				pagination : true,
				pageSize : 5,
				pageList : [ 2, 5, 10, 15, 20 ],
				sortName : "productId",
				sortOrder : "asc"

			});
		});
	</script>
</body>

</html>