<%--
  author:LI
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>复核库存安全配置单</title>
    <%@ include file="commons/meta.jsp"%>
  </head>

  <c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
    <c:redirect url="login.jsp"/>
  </c:if>
  <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  <body>
  <!-- 0.easyui显示数据 -->
  <div style="margin: 10px 30px">
    <!-- 1.显示表格数据 -->
    <div style="margin-top: 10px">
      <table id="scellDataGrid">
      
      </table>
    </div>
  </div>
	
	<script type="text/javascript">
	  $(function(){
		  // 2.自动加载表格数据
		  $("#scellDataGrid").datagrid({
			  url : "scellController_two.do",
			  title : '产品列表',
		    fitColumns : true, // 自动展开/收缩列
		    striped : true,    // 显示斑马线效果
		    rownumbers : true, // 行号
		    columns:[[{ // -- 列开始 ---------
          field : 'storeId',  // field 名必需与json中的名一致
          title : '配置单编号',
          width : 110,
          sortable : true,
        },{
          field : 'productId',
          title : '产品编号',
          width : 100,
          sortable : true,
        },{
          field : 'productName',
          title : '产品名称',
          width : 100,
          sortable : true,
        },{
          field : 'productType',
          title : '用途类型',
          width : 100,
          sortable : true,
        },{
          field : 'firstKingName',
          title : '一级分类',
          width : 100,
          sortable : true,
        },{
          field : 'secondKingName',
          title : '二级分类',
          width : 100,
          sortable : true,
        },{
          field : 'thirdKingName',
          title : '三级分类',
          width : 100,
          sortable : true,
        },{
          field : 'registerTime',
          title : '登记时间',
          
          width : 100,
          sortable : true,
        }, {
				field : "op1",
				title : "操作",
				width : 100,
				formatter : function(value, rowData, rowIndex){
					var proid = rowData["storeId"];
					var proname=rowData["productName"];
					return "<a href='scellController_check.do?proid="+proid+"'>复核</a>";
				}
			} ]], // -- 列结束 ---------
        toolbar : "#searchScellForm",
        pagination : true, // -- 分页设置 ----
        pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
        pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
        sortName : "productId", // sort:排序列 (默认)
        sortOrder : "asc",  // order:升序/降序 (默认)  
		  });
	  });
	</script>
</body>
</html>





