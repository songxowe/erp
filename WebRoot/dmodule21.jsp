<%--
  author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<!-- 物料组成设计单查询 -->
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
				title : "物料组成设计单查询",
				width : 835,
				height : 320,
				rownumbers : true,
				url : "xinYouDmoduleControllerlist2.do",
				columns : [ [ {
					field : "designId",
					title : "设计单编号",
					width : 100,
					height : 40
				},

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
					field : "authorize",
					title : "审核状态",
					width : 100,
					formatter : function(value, rowData, rowIndex) {
						var temp = rowData["checkTag"];
						if (temp == "S001-1") {
							return "审核通过";
						} else {
							return "审核未通过";
						}
					}
				}, {
					field : "op1",
					title : "详情",
					width : 100,
					height : 40,
					formatter : function(value, rowData, rowIndex) {
						var dmoduleId = rowData["id"];
						var url = "dmoduleControllernotice.do?id=" + dmoduleId;
						return " <a href="+url+"  >详单</a>";
					}
				}, ] ],
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
