<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>工序物料审核</title>
		<%@ include file="commons/meta.jsp"%>
	</head>
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	  <c:redirect url="login.jsp"/>
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
      <div style="margin-bottom: 10px">
        
      </div>
    	<!-- 新增菜单信息窗口 -->
			<div id="ediMenu">

			</div>
      <!-- 4.条件查询 -->
    </div>
    
    <!-- 1.显示表格数据 -->
    <div style="margin-top: 10px">
      <table id="designGrid">
      
      </table>
    </div>
  </div>
	
	<script type="text/javascript">
	  $(function(){
		  emp_obj = { 
       editRow : undefined,
       search : function(){ // 5.条件查询
         $("#designGrid").datagrid('load',{
           productId : $.trim($("#productId").val()),
         });
       }
		  };
		  		  
		  // 2.自动加载表格数据
		  $("#designGrid").datagrid({
			  url : "procedureController2.do",
			  title : '工序设计审核单',
		    fitColumns : true, // 自动展开/收缩列
		    striped : true,    // 显示斑马线效果
		    rownumbers : true, // 行号
		    columns:[[{ // -- 列开始 ---------
          field : 'designId',  // field 名必需与json中的名一致
          title : '工序设计单编号',
          width : 100,
          sortable : true
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
          field : 'designModuleTag',
          title : '设计单状态',
          width : 100,
          sortable : true,
          		  formatter : function(value,row,index){
					if(value=="G002-1"){
						return "已提交";
					}if(value=="G002-2"){
						return "已审核";
					}else{
						return "未设计";
					}}
        },{
          field : 'checkTag',
          title : '审核状态',
          width : 100,
          sortable : true,
          		  formatter : function(value,row,index){
					if(value=="S001-1"){
						return "通过";
					}if(value=="S001-2"){
						return "未通过审核";
					}else{
						return "等待审核";
					}}
        },{
				field : "op1",
				title : "查看详细",
				width : 100,
				formatter : function(value, rowData, rowIndex){
					var designId = rowData["designId"];
					return "<a href='#' onclick=getMenu('"+designId+"')>查看详细</a>"
					//return "<a href='detailslist.jsp?designId="+designId+"' >查看</a>"
				}
			}]], // -- 列结束 ---------
        toolbar : "#searchEmpForm",
        pagination : true, // -- 分页设置 ----
        pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
        pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
        sortName : "productId", // sort:排序列 (默认)
        sortOrder : "asc",  // order:升序/降序 (默认)
        
        // 11.在用户完成编辑一行的时候触发(点击 保存 按钮)，参数包括：
        // rowIndex：编辑行的索引，索引从0开始。
        // rowData：对应于完成编辑的行的记录。
        // changes：更改后的字段(键)/值对。
        onAfterEdit : function(rowIndex, rowData, changes){
          $("#save,#redo").hide();
          
          // 从上一次的提交获取改变的所有行
          var inserted = $("#designGrid").datagrid("getChanges","inserted");
          var updated = $("#designGrid").datagrid("getChanges","updated");
          var url = "empController_save.do";
          var state = "";
          if(inserted.length > 0){ // 新增
            state = "新增";
          }
          if(updated.length > 0){ // 修改
            state = "修改";
          }
          // alert(rowData.ename+" "+rowData.empno+" "+state);
          
          $.ajax({
            url : url,
            type : "post",
            data : {"designId":rowData.designId,"productId":rowData.productId,
                    "productName":rowData.productName,"designer":rowData.designer,
                    "registerTime":rowData.registerTime,"costPriceSum":rowData.costPriceSum
                   },
            beforeSend : function(){
              // 显示载入状态
              $("#designGrid").datagrid("loading");
            },
            success : function(data){
              if(data){
                // 隐藏载入状态
                $("#designGrid").datagrid("loaded");
                // 加载和显示第一页的所有行
                $("#designGrid").datagrid("load");
                // 取消选择所有当前页中所有的行
                $("#designGrid").datagrid("unselectAll");
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
        onDblClickRow : function(rowIndex, rowData){
          if (emp_obj.editRow != undefined) {
            $("#designGrid").datagrid("endEdit", emp_obj.editRow);
          }
          if (emp_obj.editRow == undefined) {
            $("#designGrid").datagrid("beginEdit", rowIndex);
            $("#save,#redo").show();
            emp_obj.editRow = rowIndex;
          }
        } // -- end onDblClickRow() ---
        
		  });
	  });
	  
		function getMenu(designId){
		$("#ediMenu").window({
			title : "工序设计单审核",
			width : 950,
			height : 550,
			modal : true,
			minimizable : false,
			href : "goAuditss.do?designId="+designId
		});
	}
	</script>
</body>
</html>





