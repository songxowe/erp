<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>雇员管理</title>
<%@ include file="../commons/meta.jsp"%>
</head>
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="../login.jsp" />
</c:if>
<body>

	<!-- 
  easyui 步骤:
  1.复制 easyui 所需的 js/css 文件
  2.jsp中引入 js/css
   -->
	<!-- 0.easyui显示数据 -->
	<div style="margin: 10px 30px">
		<!-- 3.设置 toolbar -->
		<div id="searchEmpForm" style="padding: 10px">
			<!-- 6.操作按钮 (plain:为true时显示简洁效果)-->
			<!-- 4.条件查询 -->
			<div style="padding: 0 0 0 6px">
				<input placeholder="商品编号" type="text" id="no" size="6" />&nbsp; <a
					href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="emp_obj.search();">查询</a>
			</div>
		</div>

		<!-- 1.显示表格数据 -->
		<div style="margin-top: 10px">
			<table id="empDataGrid">

			</table>
		</div>
		<div id="empedit"></div>
		
	</div>
<div id="divtabs" ></div>
	<script type="text/javascript">
		$(function() {
			emp_obj = {
				editRow : undefined,
				search : function() { // 5.条件查询
					$("#empDataGrid").datagrid('load', {
						no : $.trim($("#no").val()),
						pname : $.trim($("#pname").val())
						
					});
				}};

			// 2.自动加载表格数据
			$("#empDataGrid").datagrid(
					{
						url : "<%=request.getContextPath()%>/dispatchController.do",
								title : '制定生产派工单',
								fitColumns : true, // 自动展开/收缩列
								striped : true, // 显示斑马线效果
								rownumbers : true, // 行号
								columns : [ [
										{
											field : 'id',
											title : "序号",
											width : 100,
											checkbox : true,
											sortable : true
										},
										{
											field : 'applyId',
											title : '计划单编号',
											width : 150,
											sortable : true,
											editor : {
												type : "validatebox",
												options : {
													required : true
												}
											}
										},
										{
											field : 'productId',
											title : '产品编号',
											width : 150,

											formatter : function(value,
													rowData, rowIndex) {
												var productId = rowData["productId"];
												return "<a href='#' onclick=getMenu('"
														+ productId
														+ "')>"
														+ productId + "</a>";
											}
										},
										{
											field : 'productName',
											title : '产品名称',
											width : 80,
											sortable : true,
											editor : {
												type : "validatebox",
												options : {
													required : true,
													min : 1,
													precision : 2
												}
											}
										},
										{
											field : 'productDescribe',
											title : '描述',
											width : 80,
											sortable : true,
											editor : {
												type : "validatebox",
												options : {
													required : false
												}
											}
										},
										{
											field : 'amount',
											title : '数量',
											width : 80,
											sortable : true,
											editor : { // 编辑器 (新增/修改时编辑字段)
												type : "validatebox",
												options : {
													required : false,
												}
											}
										},
										{
											field : 'checkTime',
											title : '审核时间',
											width : 150,
											sortable : true,
											editor : { // 编辑器 (新增/修改时编辑字段)
												type : "datebox",
												options : {
													required : false,
												}
											}
										},
										{
											field : '生成派工单',
											title : '操作',
											width : 100,
											formatter : function(value,
													rowData, rowIndex) {
												var productId = rowData["productId"];
												var id = rowData["id"];
												return "<a href='#' onclick=getMenu2('"
														+ productId+"','" + id+ "')>生成派工单</a>";
											}
										} ] ], // -- 列结束 ---------
								toolbar : "#searchEmpForm",
								pagination : true, // -- 分页设置 ----
								pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
								pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
								sortName : "no", // sort:排序列 (默认)
								sortOrder : "asc", // order:升序/降序 (默认)
								// 11.在用户完成编辑一行的时候触发(点击 保存 按钮)，参数包括：
								// rowIndex：编辑行的索引，索引从0开始。
								// rowData：对应于完成编辑的行的记录。
								// changes：更改后的字段(键)/值对。
								onAfterEdit : function(rowIndex, rowData,
										changes) {
									$("#save,#redo").hide();

									// 从上一次的提交获取改变的所有行
									var inserted = $("#empDataGrid").datagrid(
											"getChanges", "inserted");
									var updated = $("#empDataGrid").datagrid(
											"getChanges", "updated");
									var url = "categoriesController_save.do";
									var state = "";
									if (inserted.length > 0) { // 新增
										state = "新增";
									}
									if (updated.length > 0) { // 修改
										state = "修改";
									}
									// alert(rowData.ename+" "+rowData.empno+" "+state);

									$.ajax({
										url : url,
										type : "post",
										data : {
											"no" : rowData.no,
											"pname" : rowData.pname,
											"pdescn" : rowData.pdescn
										},
										beforeSend : function() {
											// 显示载入状态
											$("#empDataGrid").datagrid(
													"loading");
										},
										success : function(data) {
											if (data) {
												// 隐藏载入状态
												$("#empDataGrid").datagrid(
														"loaded");
												// 加载和显示第一页的所有行
												$("#empDataGrid").datagrid(
														"load");
												// 取消选择所有当前页中所有的行
												$("#empDataGrid").datagrid(
														"unselectAll");
												$.messager.show({
													title : "提示",
													msg : data + "个雇员被" + state
												});
											}
											emp_obj.editRow = undefined;
										}
									});
								}, // -- end onAfterEdit() -----

								// 在用户双击一行的时候触发，参数包括：
								// rowIndex：点击的行的索引值，该索引值从0开始
								// rowData：对应于点击行的记录
								onDblClickRow : function(rowIndex, rowData) {
									if (emp_obj.editRow != undefined) {
										$("#empDataGrid").datagrid("endEdit",
												emp_obj.editRow);
									}
									if (emp_obj.editRow == undefined) {
										$("#empDataGrid").datagrid("beginEdit",
												rowIndex);
										$("#save,#redo").show();
										emp_obj.editRow = rowIndex;
									}
								} // -- end onDblClickRow() ---

							});
		});
		//查看指定菜单
		function getMenu(productId) {
			$("#dis_view").window({
				title : "制定工序物料设计单",
				width : "30%",
				height : "80%",
				modal : true,
				minimizable : false,
				href : "dispatchController_view.do?productId=" + productId
			});
		}
		function getMenu2(productId,id) {
		var href = "<%=request.getContextPath()%>/dispatchController_add.do?productId=" + productId + "&id="
				+ id;
				window.location.href=href;

	}
	</script>
</body>
</html>