
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>出库调度</title>
    <%@ include file="commons/meta.jsp"%>
  </head>
  <body>
  <!-- 0.easyui显示数据 -->
  <div style="margin: 10px 30px">
    <!-- 1.显示表格数据 -->
    <div style="margin-top: 10px">
      <table id="storageScheduleDataGrid">
      
      </table>
    </div>
  </div>
	
	<script type="text/javascript">
	  $(function(){
		  $("#storageScheduleDataGrid").datagrid({
			url : "storageScheduleController.do",
			title : "第一页面",
		    fitColumns : true, // 自动展开/收缩列
		    striped : true,    // 显示斑马线效果
		    rownumbers : true, // 行号
		    columns:[[{ // -- 列开始 ---------
          field : "id",  // field 名必需与json中的名一致
          title : "出库单编号",
          width : 20,
          //checkbox : true,
          sortable : true
        },{
          field : "reason",
          title : "出库理由",
          width : 20,
          sortable : true,
          
        },{
          field : "reasonexact",
          title : "出库详细理由",
          width : 20,
          sortable : true,
          
        },{
            field : "registerTime",
            type : "datebox",
            title : "登记时间",
            width : 20,
            sortable : true,
           
          },{
          field : "amountSum",
          title : "总件数",
          width : 20,
          sortable : true,
         
        },{
            field : "costPriceSum",
            title : "总金额",
            width : 20,
            sortable : true,
            
        },{
            field : "o",
            title : "出库调度",
            width : 20,
            formatter:function(value,rowData,rowIndex){
            	var id= rowData["id"];
            	return "<a href='storageScheduleOutController_findById.do?id="+id+"'>出库调度<a/>";
            }
          }]], // -- 列结束 ---------
        pagination : true, // -- 分页设置 ----
        pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
        pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
        sortName : "id", // sort:排序列 (默认)
        sortOrder : "asc",  // order:升序/降序 (默认)
		  });
	  });
	</script>
</body>
</html>