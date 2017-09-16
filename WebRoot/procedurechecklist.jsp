<%--
	author:SONG
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>用户管理</title>
		<%@ include file="commons/meta.jsp"%>
		<script type="text/javascript">
</script>
	</head>

	<body>
		<div style="margin: 10px 30px;">
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"
				onclick="user_obj.showEdit('edit')">审核</a>&nbsp;&nbsp;

			<!-- 用户信息窗口 -->
			<div id="editUser">

			</div>
			<!-- 设定用户角色信息窗口 -->
					<div id="userRole">

					</div>

			<!-- 用户列表的工具栏设置 -->
			

			<!-- 用户列表显示 -->
			<div style="margin-top: 20px;">
				<table id="userDataGrid11">

				</table>

			</div>
		</div>
		<script type="text/javascript">
	$(function() {
		user_obj = {
			/* search : function() {//查询
				$("#userDataGrid11").datagrid(
						"load",
						{
							username : $.trim($("#username").val()),
							status : $("#status").val()
						});
			},
			remove : function(){
				var rows = $("#userDataGrid11").datagrid("getSelections");
				if(rows.length > 0) {
					$.messager.confirm("消息","确认真的要删除所选的数据吗",function(flag){
						if(flag){
							var ids = [];
							for(var i=0;i<rows.length;i++){
								ids.push(rows[i].categoryId);
							}
							$.ajax({
								type : "post",
								url : "categories_remove.do",
								data : {
									ids : ids.join(","),
								},
								beforeSend : function(){
									$("#userDataGrid11").datagrid("loading");
								},
								success : function(data){
									if(data) {
										$("#userDataGrid11").datagrid("loaded");
										$("#userDataGrid11").datagrid("load");
										$("#userDataGrid11").datagrid("unselectAll");
										$.messager.show({
											title : "提示",
											msg : data + "个用户被删除"
										});
									}
								}
							});
						}
					});
				}else {
					$.messager.alert("警告", "请选中要删除的数据","warning");
				}
			},
			setUserRole:function(){
				var url = "userrole.jsp";
				var id = 0;
				var user = "";
				var rows = $("#userDataGrid11").datagrid("getSelections");
				if(rows.length == 1){
					id = rows[0].id;
					username = rows[0].username;
					url += "?id="+id+"&username="+username;
				}
				else if(rows.length>1){
					$.messager.alert("警告", "不能选中多行","warning");
					return;
				}else if(rows.length==0){
					$.messager.alert("警告","必须选中一个用户","warning");
					return;
				}
				$("#userRole").window({
					title : '用户角色授权管理',
					width : 950,
					height : 450,
					modal : true,
					minimizable : false,
					href : url
				});
			}, */
			showEdit : function(state){
				var url = "mdesignProcedure_checkfind.do";
				var info = "";
				var id = 0;
				if(state == 'add') {//新增
					info = "新增用户信息";
				}else {//修改
					info = "添加工序信息";
					var rows = $("#userDataGrid11").datagrid("getSelections");
					if(rows.length == 1){
						id = rows[0].productId;
						url += "?productId="+id;
					}else{
						$.messager.alert("警告", "必须选中一行", "warning");
						return;
					}
				}
				window.location.href=url;
				/* $('#divtabs').tabs('add',{    
    title:'产品工序审核',    
    content:'<iframe id="10" frameborder="0" scrolling="true" src="' + url + '" style="width:100%;height:100%;position:relative;"></iframe>',    
    closable:true,    
    tools:[{    
        iconCls:'icon-mini-refresh',    
        handler:function(){    
            alert('refresh');    
        }    
    }]    
}); */  
			}		
		}

		$("#userDataGrid11").datagrid( {
			url : "mdesignProcedure_checklist.do",
			title : "生产工序审核列表",
			fitColumns : true,
			striped : true,
			rownumbers : true,
			columns : [ [ {
				field : "id",
				title : "序号",
				width : 100,
				checkbox : true,
				sortable : true
			}, {
				field : "designId",
				title : "设计单编号 ",
				width : 100,
				sortable : true
			}, {
				field : "productId",
				title : "产品编号",
				width : 100,
				sortable : true
			}, {
				field : "productName",
				title : "产品名称",
				width : 100,
				sortable : true
			}, {
				field : "designer",
				title : "设计人",
				width : 100,
				sortable : true
			}, {
				field : "registerTime",
				title : "登记时间",
				width : 100,
				sortable : true
			} , {
				field : "costPriceSum",
				title : "工时总成本",
				width : 100,
				sortable : true
			} ] ],
			toolbar : "#searchUserForm",
			pagination : true,
			pageSize : 2,
			pageList : [ 2, 5, 10, 15, 20 ],
			sortName : "id",
			sortOrder : "asc",
		});
	});
</script>
	</body>
</html>
