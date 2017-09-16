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

	
		<table id="dfiledatagrid1"></table>
		<script type="text/javascript">
		$(function() {
			$("#dfiledatagrid1").datagrid({
				title : "",
				width : 835,
				height : 320,
				rownumbers : true,
				url : "xinYouDmoduleController_list.do",
				columns : [ [

				{
					field : "designId",
					title : "设计单编号",
					width : 100,
					height : 40
				}, {
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
					field : "designer",
					title : "设计人",
					width : 100,
					height : 40
				}, {
					field : "registerTime",
					title : "登记时间",
					width : 100,
					height : 40
				}, {
					field : "costPriceSum",
					title : "物料总成本",
					width : 100,
					height : 40
				},{
					field : "op1",
					title : "审核",
					width : 100,
					height : 40,
					formatter : function(value, rowData, rowIndex) {
						var dmoduleId = rowData["id"];
						var url = "dmoduleControllerlist.do?id=" + dmoduleId;
						return  " <a href="+url+"  >审核</a>";
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