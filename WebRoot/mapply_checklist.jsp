<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>生产计划审核</title>
<%@ include file="commons/meta.jsp"%>
</head>
<body>
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>

	<!-- 0.easyui显示数据 -->
	<div style="margin: 10px 30px">
		<!-- 3.设置 toolbar -->
		<div id="searchMapplyForm" style="padding: 10px">
			<!-- 4.条件查询 -->
			<div style="padding: 0 0 0 6px; width: 944px">
				&nbsp;&nbsp;&nbsp;&nbsp; <input placeholder="生产计划编号"
					type="text" id="applyid" name="applyid" size="6" style="width: 194px; " /> <a
					href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="apply_obj.search();">查询</a>
			</div>

		</div>

		<!-- 1.显示表格数据 -->
		<div style="margin-top: 10px">
			<table id="mapplyDataGrid">

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
					$("#mapplyDataGrid").datagrid('load', {
						applyId : $.trim($("#applyid").val()),
					});
				}
			}

			// 2.自动加载表格数据
			$("#mapplyDataGrid").datagrid(
					{
						url : "mapplyController/list.do",
						title : '当前等待审核的生产计划',
						fitColumns : true, // 自动展开/收缩列
						striped : true, // 显示斑马线效果
						rownumbers : true, // 行号
						columns : [ [
								{ // -- 列开始 ---------
									field : "applyId", // field 名必需与json中的名一致
									title : "生产计划编号",
									width : 50,
									sortable : true
								},
								{
									field : "designer",
									title : "计划制定人",
									width : 50,
									sortable : true
								},
								{
									field : "register",
									title : "登记人",
									width : 100,
									sortable : true
								},
								{
									field : "registerTime",
									title : "登记时间",
									width : 100,
									sortable : true
								},
								{
									field : "remark",
									title : "备注",
									width : 100,
									sortable : true,
								},
								{
									field : "op",
									title : "操作",
									width : 100,
									formatter : function(value, rowData,
											rowIndex) {
										var applyId = rowData["applyId"];
										var url="mapplyController/checkPage.do?applyId=" + applyId;
										return "<a href="+url+">审核</a>";
									}
								} ] ], // -- 列结束 ---------
						toolbar : "#searchMapplyForm",
						pagination : true, // -- 分页设置 ----
						pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
						pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
						sortName : "applyId", // sort:排序列 (默认)
						sortOrder : "asc", // order:升序/降序 (默认)
					});
		});
		//查看指定审核详情
		function getApply(applyId) {
			$("#checkWindow").window({
				title : "审核详情",
				width : 700,
				height : 400,
				modal : true,
				minimizable : false,
				href : "mapplyController/checkPage.do?applyId=" + applyId
			});
		}
	</script>
</body>
</html>





