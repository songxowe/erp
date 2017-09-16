
<%--
	  author:LI
	--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>登记查询页面</title>
<%@ include file="commons/meta.jsp"%>
</head>

<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>
<script language="javascript" type="text/javascript"
	src="My97DatePicker/WdatePicker.js"></script>
<body>
	<!-- 0.easyui显示数据 -->
	<div style="margin: 10px 30px">
		<!-- 3.设置 toolbar -->
		<div id="searchScellForm" style="padding: 10px">

			<!-- 4.条件查询 -->
			<div style="padding: 0 0 0 6px">
				&nbsp;
				<table>
					<tr>
						<th>请输入关键字</th>
						<td colspan="6"><input type="text" id="payId"
							placeholder="关键字查询" />&nbsp;&nbsp;&nbsp;<a href="#" class="easyui-linkbutton"
							iconCls="icon-search" onclick="scell_obj.search();">查询</a></td>
					</tr>
				</table>

			</div>
		</div>
		<!-- 1.显示表格数据 -->
		<div style="margin-top: 10px">
			<table id="scellDataGrid">

			</table>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			scell_obj = {
				editRow : undefined,
				search : function() { // 5.条件查询
					$("#scellDataGrid").datagrid('load', {
						payId : $.trim($("#payId").val()),
					});
				}
			}

			// 2.自动加载表格数据
			$("#scellDataGrid").datagrid({
				url : "hzjspayController_query.do",
				title : '入库申请列表',
				fitColumns : true, // 自动展开/收缩列
				striped : true, // 显示斑马线效果
				rownumbers : true, // 行号
				columns : [ [ { // -- 列开始 ---------
					field : 'payId', // field 名必需与json中的名一致
					title : '入库编号',
					width : 50,
					sortable : true
				}, {
					field : 'reason',
					title : '入库理由',
					width : 100,
					sortable : true,
					editor : {
						type : "validatebox",
						options : {
							required : true
						}
					}
				}, {
					field : 'amountSum',
					title : '总件数',
					width : 100,
					sortable : true,
					editor : { // 编辑器 (新增/修改时编辑字段)
						type : "numberbox",
						options : {
							required : true,
							min : 1,
							precision : 2
						}
					}
				}, {
					field : 'registerTime',
					title : '登记时间',
					width : 100,
					sortable : true,
					editor : {
						type : "datebox",
						options : {
							required : true
						}
					}
				}, {
					field : 'checkTag',
					title : '审核状态',
					width : 100,
					sortable : true,
					formatter : function(value,row,index){
					if(value=="S001-1"){
						return "已通过审核";
					}if(value=="S001-2"){
						return "未通过审核";
					}else{
						return "等待审核";
					}
					},
					editor : { // 编辑器 (新增/修改时编辑字段)
						type : "numberbox",
						options : {
							required : true,
							min : 1,
							precision : 2
						}
					}
				}, {
					field : 'storeTag',
					title : '库存状态',
					width : 100,
					sortable : true,
					formatter : function(value,row,index){
					if(value=="K002-1"){
						return "已入库";
					}if(value=="K002-0"){
						return "等待入库";
					}else{
						return "等待";
					}
					}
					}] ], // -- 列结束 ---------
				toolbar : "#searchScellForm",
				pagination : true, // -- 分页设置 ----
				pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
				pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
				sortName : "productId", // sort:排序列 (默认)
				sortOrder : "asc", // order:升序/降序 (默认)  
			});
		});
	</script>
</body>
</html>





