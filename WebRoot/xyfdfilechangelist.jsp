<%--
  author:XU
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>    
    <title>产品档案管理</title>
    <%@ include file="commons/meta.jsp"%>
    <style type="text/css">
    	.TD_HANDBOOK_STYLE1 {
			vertical-align : top ;
			width:100%;
			color:#0000FF;
		}
		.TR_STYLE2{

		}
		.TABLE_STYLE2{
			width: 95%;
		}
    </style>
  </head>
  <c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
    <c:redirect url="login.jsp"/>
  </c:if>
  <body bgcolor="#E9F8F3" oncontextmenu="event.returnValue=true" style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">
  <!-- 0.easyui显示数据 -->
  <div style="margin: 10px 30px">
  
  	<table  class="TABLE_STYLE2">

 		<tr height=20 class="TR_STYLE1">
 			<td class="TD_HANDBOOK_STYLE1"><small>您正在做的业务是：产品设计--产品档案管理--产品档案变更</small></td>
 		</tr>
	</table>
  
  	<!-- 菜单列表的工具栏设置 -->
	<div id="searchDfileForm" style="padding: 10px;">
		<div style="padding: 0 0 0 6px;">
		<table>
			<tr>
    			<th>请选择产品I级分类</th>
    			<td>
    				<select id="firstKindName" name="firstKindName">
					<option value=-1>请选择</option>
				</select>
    			</td>
    				<th>请选择产品II级分类</th>
    			<td>
    				<select id="secondKindName" name="secondKindName">
						<option value=-1>请选择</option>
				</select>
    			</td>
    			<th>请选择产品III级分类</th>
    			<td>
    			 <select id="thirdKindName" name="thirdKindName" >
						<option value=-1>请选择</option>
				</select>
    			</td>
    		</tr>
    		<tr>
    			<th>请选择产品用途类型：</th>
    			<td>
    				<select id="type" name="type">
    					<option value="">请选择</option>
    					<option value="Y001-1">商品</option>
    					<option value="Y001-2">物料</option>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<th>请输入建档时间</th>
    			<td colspan="6">
    			 <input id="beginTime" placeholder="开始日期" type="date" /> 至<input id="endTime" placeholder="结束日期" type="date" />
    			</td>
    		</tr>
		</table>
		<a href="#" class="easyui-linkbutton" iconCls="icon-search"
			onclick=dfile_obj.search();>查询</a>			
		</div>
	</div>
    
    <!-- 1.显示表格数据 -->
    <div style="margin-top: 10px">
      <table id="dfileDataGrid">
      
      </table>
    </div>    
  </div>
  <script type="text/javascript">
  	$(function(){
  		$.post("<%=request.getContextPath()%>/xyfDfileController_findAll.do",function(data){
		  $("#firstKindName").empty();
		  $(data).find("type").each(function(index){
		  var id=$("id",$(data).find("type")[index]).text();
		  var name=$("name",$(data).find("type")[index]).text();
          $("#firstKindName").append("<option value='"+id+"'>"+name+"</option>");		  
		  });//返回一个集合
		},
		"xml"
		);
		//改变一级分类时触发
		$("#firstKindName").change(function(){
		 $.post("<%=request.getContextPath()%>/xyfDfileController_findAll.do",{"pid":$("#firstKindName").val()},function(data){
		 $("#secondKindName").empty();
		 $("#thirdKindName").empty();
		 $("#thirdKindName").append("<option value=-1>请选择</option>");	
		 $(data).find("type").each(function(index){
		  var id=$("id",$(data).find("type")[index]).text();
		  var name=$("name",$(data).find("type")[index]).text();
          $("#secondKindName").append("<option value='"+id+"'>"+name+"</option>");	
		 });
		 },
		 "xml"
		 );
		});
		//改变二级分类时触发
		$("#secondKindName").change(function(){
		$.post("<%=request.getContextPath()%>/xyfDfileController_findAll.do", {"pid" : $("#secondKindName").val()}, function(data) {
		$("#thirdKindName").empty();
		$(data).find("type").each(
		function(index) {
		var id = $("id",$(data).find("type")[index]).text();
		var name = $("name",$(data).find("type")[index]).text();
		$("#thirdKindName").append("<option value='"+id+"'>" + name+ "</option>");
		});
		}, 
		"xml"
		);
		});
  	
  		dfile_obj={
  			editRow : undefined,
  			search:function(){
  				$("#dfileDataGrid").datagrid('load',{
  					firstKindName : $("#firstKindName").val(),
  					secondKindName : $("#secondKindName").val(),
  					thirdKindName : $("#thirdKindName").val(),
  					type : $("#type").val(),
  					beginTime : $("#beginTime").val(),
           			endTime : $("#endTime").val()
  				});
  			}
  		};
  		
  		// 2.自动加载表格数据
  		$("#dfileDataGrid").datagrid({
  			url:"xyfDfileController.do",
  			title:"产品列表",
  			fitColumns : true, // 自动展开/收缩列
		    striped : true,    // 显示斑马线效果
		    rownumbers : true, // 行号
		    columns:[[{ // -- 列开始 ---------
          		field : 'productId',  // field 名必需与json中的名一致
          		title : '产品编号',
          		width : 100,
          		sortable : true
        	},{
          		field : 'productName',
          		title : '产品名称',
          		width : 50,
          		sortable : true
        	},{
          		field : 'type',
          		title : '用途类型',
         		width : 50,
          		sortable : true,
          		formatter: function(value,row,index){
					if (value=="Y001-1"){
						return "商品";
					} else {
						return "物料";
					}
				}
        	},{
          		field : 'firstKindName',
          		title : 'I级分类',
         		width : 50,
          		sortable : true
        	},{
          		field : 'secondKindName',
          		title : 'II级分类',
         		width : 50,
          		sortable : true
        	},{
          		field : 'thirdKindName',
          		title : 'III级分类',
         		width : 50,
          		sortable : true
        	},{
          		field : 'responsiblePerson',
          		title : '产品经理',
         		width : 50,
          		sortable : true
        	},{
				field : "op1",
				title : "档案变更",
				width : 100,
				formatter : function(value, rowData, rowIndex){
					var id = rowData["id"];
					return "<a href='xyfDfileController_change.do?id="+id+"'>档案变更</a>";
				}
			}]],
        	toolbar : "#searchDfileForm",
        	pagination : true,// -- 分页设置 ----
        	pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
        	pageList : [ 2, 5, 10, 15, 20 ],// 设置每页条数的列表
        	sortName : "productId", // sort:排序列 (默认)
        	sortOrder : "asc" // order:升序/降序 (默认)
  		});
  		
  	});
 </script>
  </body>
</html>