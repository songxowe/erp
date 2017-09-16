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
 <td  class="TD_HANDBOOK_STYLE1"><small>您正在做的业务是：产品设计--产品档案管理--产品档案删除管理--产品档案永久删除</small></td>
 </tr>
</table>	
    
    <!-- 1.显示表格数据 -->
    <div style="margin-top: 10px">
      <table id="dfileDataGrid">
      
      </table>
    </div>    
  </div>
  <script type="text/javascript">
  	$(function(){
  		// 2.自动加载表格数据
  		$("#dfileDataGrid").datagrid({
  			url:"xyfDfileController_recoveryList.do",
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
          		field : 'productClass',
          		title : '档次级别',
         		width : 50,
          		sortable : true,
          		formatter: function(value,row,index){
					if (value=="D001-1"){
						return "高档";
					} else if(value=="D001-2"){
						return "中档";
					} else {
						return "低档";
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
				title : "恢复",
				width : 100,
				formatter : function(value, rowData, rowIndex){
					var id = rowData["id"];
					return "<a href='xyfdfilerealdeleteconfirm.jsp?id="+id+"'>永久删除</a>";
				}
			}]],
        	pagination : true,// -- 分页设置 ----
        	pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
        	pageList : [ 2, 5, 10, 15, 20 ],// 设置每页条数的列表
        	sortName : "productId", // sort:排序列 (默认)
        	sortOrder : "asc"  // order:升序/降序 (默认)
  		});
  		
  	});
  </script>
  
  </body>
</html>