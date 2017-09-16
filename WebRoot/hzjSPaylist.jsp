<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>审核查询</title>
<%@ include file="commons/meta.jsp"%>
<script src="js/Clock.js"></script>
</head>

<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>

<body>
	<!-- 0.easyui显示数据 -->
	<div style="margin: 10px 30px">
		<!-- 3.设置 toolbar -->
		<div id="searchEmpForm" style="padding: 10px">
			
			<!-- 新增菜单信息窗口 -->
			<div id="editPayId">

			</div>
		</div>

		<!-- 1.显示表格数据 -->
		<div style="margin-top: 10px">
			<table id="empDataGrid">

			</table>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			emp_obj = {
				modify : function() { // 7.审核操作
					$("#save,#redo").show();
					if (this.editRow == undefined) {
						// 在第一行的位置插入一个新行
						$("#empDataGrid").datagrid("insertRow", {
							index : 0, // 数据行索引
							row : {}
						});

						//将第一行设为可编辑状态
						$("#empDataGrid").datagrid("beginEdit", 0);
						this.editRow = 0;
					}
				},
				search : function() {//查询
					//获得选中的树节点
					var menutree = $("#parentMenuSelect").combotree("tree");
					var node = menutree.tree("getSelected");
					var nodeId = 0;
					if (node != null)
						nodeId = node.id;
					// alert(nodeId);
					$("#menuDataGrid").datagrid("load", {
						name : $.trim($("#name").val()),
						descn : $("#descn").val(),
						parentId : nodeId
					});
				}

			}

			// 2.自动加载表格数据
			$("#empDataGrid").datagrid(
					{
						url : "hzjspayController.do",
						title : '入库列表',
						fitColumns : true, // 自动展开/收缩列
						striped : true, // 显示斑马线效果
						rownumbers : true, // 行号
						columns : [ [
								{ // -- 列开始 ---------
									field : 'payId', // field 名必需与json中的名一致
									title : '入库编号',
									width : 50,
									sortable : true
								},
								{
									field : 'reason',
									title : '入库理由',
									width : 150,
									sortable : true,
									
								},
								{
									field : 'registerTime',
									title : '入库日期',
									width : 100,
									sortable : true,
									
								},
								{
									field : 'amountSum',
									title : '总件数',
									width : 100,
									sortable : true,
									
								},
								{
									field : 'costPriceSum',
									title : '总金额',
									width : 100,
									sortable : true,
									
								},
								{
									field : "op1",
									title : "操作",
									width : 100,
									formatter : function(value, rowData,
											rowIndex) {
										var id = rowData["id"];
										return "<a  href='#' onclick=getPayId('"+ id +"')>审核</a>" 
									}
								} ] ], // -- 列结束 ---------
						toolbar : "#searchEmpForm",
						pagination : true, // -- 分页设置 ----
						pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
						pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
						sortName : "payId", // sort:排序列 (默认)
						sortOrder : "asc", // order:升序/降序 (默认)

						// 11.在用户完成编辑一行的时候触发(点击 保存 按钮)，参数包括：
						// rowIndex：编辑行的索引，索引从0开始。
						// rowData：对应于完成编辑的行的记录。
						// changes：更改后的字段(键)/值对。
						onAfterEdit : function(rowIndex, rowData, changes) {
							
							// alert(rowData.ename+" "+rowData.empno+" "+state);

							$.ajax({
								url : url,
								type : "post",
								data : {
									"payId" : rowData.payId,
									"reason" : rowData.reason,
									"registerTime" : rowData.registerTime,
									"amountSum" : rowData.amountSum,
									"costPriceSum" : rowData.costPriceSum
								},
								beforeSend : function() {
									// 显示载入状态
									$("#empDataGrid").datagrid("loading");
								},
								success : function(data) {
									if (data) {
										// 隐藏载入状态
										$("#empDataGrid").datagrid("loaded");
										// 加载和显示第一页的所有行
										$("#empDataGrid").datagrid("load");
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
		function getPayId(id) {
		
			$("#editPayId").window({
				title : "查看入库明细",
				width : 750,
				height : 480,
				modal : true,
				minimizable : false,
				href : "hzjspayController_view.do?id=" + id
			});
		}
		
	</script>
</body>
</html>





