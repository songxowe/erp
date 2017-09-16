<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>生产计划审核</title>
<%@ include file="commons/meta.jsp"%>
</head>

<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>

<body>
	<!-- 0.easyui显示数据 -->
	<div style="margin: 10px 30px">
		<!-- 3.设置 toolbar -->
		<div id="searchFileForm" style="padding: 10px">
			<!-- 4.条件查询 -->
			<div style="padding: 0 0 0 6px; width: 944px">
				&nbsp;&nbsp;&nbsp;&nbsp; <input placeholder="产品名称" type="text"
					id="productName" name="productName" size="6" style="width: 194px; " />
				<a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="apply_obj.search();">查询</a>
			</div>

		</div>

		<!-- 1.显示表格数据 -->
		<div style="margin-top: 10px">
			<table id="fileDataGrid">
			</table>
		</div>
		<!-- 新增菜单信息窗口 -->
		<div id="checkWindow"></div>
		<form id="checkForm" action="mapplyController/checkPage.do"
			method="post">
			<input type="hidden" id="applyId" name="applyId">
		</form>
	</div>

	<script type="text/javascript">
		$(function() {
			apply_obj = {
				editRow : undefined,
				search : function() { // 5.条件查询
					$("#fileDataGrid").datagrid('load', {
						applyId : $.trim($("#productName").val()),
					});
				}
			}

			// 2.自动加载表格数据
			$("#fileDataGrid")
					.datagrid(
							{
								url : "mapplyController/filelist.do",
								title : '过审商品列表',
								fitColumns : true, // 自动展开/收缩列
								striped : true, // 显示斑马线效果
								rownumbers : true, // 行号
								columns : [ [
										{ // -- 列开始 ---------
											field : "productId", // field 名必需与json中的名一致
											title : "产品编号",
											width : 50,
											sortable : true
										},
										{
											field : "productName",
											title : "产品名称",
											width : 150,
											sortable : true
										},
										{
											field : "productDescribe",
											title : "产品描述",
											width : 150,
											sortable : true,
										},
										{
											field : "register",
											title : "设计人",
											width : 50,
											sortable : true,
										},
										{
											field : "type",
											title : "用途类型",
											width : 50,
											sortable : true,
											formatter:function(value,row,index){
												return "商品";
											}
										},
										{
											field : "personalUnit",
											title : "单位",
											width : 50,
											sortable : true
										},
										{
											field : "listPrice",
											title : "单价(元)",
											width : 100,
											sortable : true,
										},
										{
											field : "op",
											title : "操作",
											width : 100,
											formatter : function(value,
													rowData, rowIndex) {
												var productId = rowData["productId"];
												var productName = rowData["productName"];
												var productDescribe = rowData["productDescribe"];
												var type = rowData["type"];
												var personalUnit = rowData["personalUnit"];
												var realCostPrice = rowData["listPrice"];
												var register = rowData["register"];
												return "<a href='#' onclick=add('"
														+ productId
														+ "','"
														+ productName
														+ "','"
														+ productDescribe
														+ "','"
														+ type
														+ "','"
														+ personalUnit
														+ "','"
														+ realCostPrice
														+ "','"
														+ register
														+ "')>添加</a>";
											}
										} ] ], // -- 列结束 ---------
								toolbar : "#searchFileForm",
								pagination : true, // -- 分页设置 ----
								pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
								pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
								sortName : "applyId", // sort:排序列 (默认)
								sortOrder : "asc", // order:升序/降序 (默认)
							});
		});		
		function removeRow(productId) {
			var t = document.getElementById("filetable");
			var a = document.getElementsByName("productId");
			for (var i = 0; i < a.length; i++) {
				if (a[i].value == productId) {
					var flag = window.confirm("是否删除产品编号为 " + productId
							+ " 的产品？");
					if (flag) {
						t.deleteRow(i + 1);
					}
				}
			}
		}
	</script>
</body>
</html>





