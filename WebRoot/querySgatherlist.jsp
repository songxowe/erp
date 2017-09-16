
<%--
	  author:LI
	--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>制定库存安全配置单</title>
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
		<div id="searchScellForm1" style="padding: 10px">

			<!-- 4.条件查询 -->
			<div style="padding: 0 0 0 6px">
				&nbsp;
				<table>
					<tr>
						<th>请选择产品I级分类</th>
						<td><select id="firstKingName">
								<option></option>
								<option>电子</option>
								<option>金属</option>
						</select></td>
						<th>请选择产品II级分类</th>
						<td><select id="secondKingName">
								<option></option>
								<option>计算机</option>
						</select></td>
						<th>请选择产品III级分类</th>
						<td><select id="thirdKingName">
								<option></option>
								<option>服务器</option>
						</select></td>
					</tr>
					<tr>
						<th>请输入建档时间</th>
						<td colspan="6"><input class="Wdate" type="text"
							onClick="WdatePicker()" id="beginDate" placeholder="开始日期" />至<input
							class="Wdate" type="text" onClick="WdatePicker()" id="endDate"
							placeholder="结束日期" /></td>
					</tr>
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
			<table id="scellDataGrid8">

			</table>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			scell_obj = {
				editRow : undefined,
				search : function() { // 5.条件查询
					$("#scellDataGrid8").datagrid('load', {
						gatherId : $.trim($("#gatherId").val()),
					});
				}
			}

			// 2.自动加载表格数据
			$("#scellDataGrid8").datagrid({
				url : "zjsSgatherController_list3.do",
				title : '出库申请列表',
				fitColumns : true, // 自动展开/收缩列
				striped : true, // 显示斑马线效果
				rownumbers : true, // 行号
				columns : [ [ { // -- 列开始 ---------
					field : 'gatherId', // field 名必需与json中的名一致
					title : '出库单编号',
					width : 50,
					sortable : true
				}, {
					field : 'reason',
					title : '出库理由',
					width : 100,
					sortable : true,
					formatter:function(value,row,index){
			        if(value=="C002-1"){
			         return"生产领料";
			        }if(value=="C002-2"){
			         return "赠送";
			        }if(value=="C002-3"){
			         return "内部借领";
			        }if(value=="C002-4"){
			         return  "其他借领";
			        }
			        }
				}, {
					field : 'attemperTime',
					title : '完成时间',
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
					field : 'demandAmounta',
					title : '应出库件数',
					width : 100,
					sortable : true,
					editor : {
						type : "datebox",
						options : {
							required : true
						}
					}
				}, {
					field : 'realAmounta',
					title : '已出库件数',
					width : 100,
					sortable : true,
					editor : {
						type : "datebox",
						options : {
							required : true
						}
					}
				},{
					field : 'checkTag',
					title : '出库单状态',
					width : 100,
					sortable : true,
					formatter : function(value,row,index){
					if(value=="S001-1"){
						return "完成";
					}if(value=="S001-2"){
						return "执行";
					}else{
						return "等待";
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
				} ] ], // -- 列结束 ---------
				toolbar : "#searchScellForm1",
				pagination : true, // -- 分页设置 ----
				pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
				pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
				sortName : "gatherId", // sort:排序列 (默认)
				sortOrder : "asc", // order:升序/降序 (默认)  
			});
		});
	</script>
</body>
</html>





