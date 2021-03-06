<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>工序物料设计单</title>
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
			<div id="editMenu">

			</div>
      <!-- 4.条件查询 -->
      <div style="padding: 0 0 0 6px">
        &nbsp;
        <input placeholder="产品编号" type="text" id="productId" size="6"/>
        <a href="#" class="easyui-linkbutton"
           iconCls="icon-search"
           onclick="emp_obj.search();">查询</a>
      </div>
    </div>
    
    <!-- 1.显示表格数据 -->
    <div style="margin-top: 10px">
      <table id="empDataGrid">
      
      </table>
    </div>
  </div>
	
	<script type="text/javascript">
	  $(function(){
		  emp_obj = { 
       editRow : undefined,
       search : function(){ // 5.条件查询
         $("#empDataGrid").datagrid('load',{
           productId : $.trim($("#productId").val()),
         });
       }
		  };
		  		  
		  // 2.自动加载表格数据
		  $("#empDataGrid").datagrid({
			  url : "procedureController.do",
			  title : '工序设计单',
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
          editor : {
            type : "validatebox",
            options : {
              required : true
            }
          }
        },{
          field : 'productName',
          title : '产品名称',
          width : 100,
          sortable : true,
          editor : {  // 编辑器 (新增/修改时编辑字段)
            type : "validatebox",
            options : {
              required : true,
              min : 1,
              precision : 2
            }
          }
        },{
          field : 'designer',
          title : '设计人',
          width : 100,
          sortable : true,
          editor : {  // 编辑器 (新增/修改时编辑字段)
            type : "validatebox",
            options : {
              required : true,
              min : 1,
              precision : 2
            }
          }
        },{
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
        },{
          field : 'costPriceSum',
          title : '工时总成本',
          width : 100,
          sortable : true
        },{
				field : "op1",
				title : "制定",
				width : 100,
				formatter : function(value, rowData, rowIndex){
					var id = rowData["id"];
					return "<a href='#' onclick=getMenu('"+id+"')>制定</a>"
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
          var inserted = $("#empDataGrid").datagrid("getChanges","inserted");
          var updated = $("#empDataGrid").datagrid("getChanges","updated");
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
              $("#empDataGrid").datagrid("loading");
            },
            success : function(data){
              if(data){
                // 隐藏载入状态
                $("#empDataGrid").datagrid("loaded");
                // 加载和显示第一页的所有行
                $("#empDataGrid").datagrid("load");
                // 取消选择所有当前页中所有的行
                $("#empDataGrid").datagrid("unselectAll");
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
            $("#empDataGrid").datagrid("endEdit", emp_obj.editRow);
          }
          if (emp_obj.editRow == undefined) {
            $("#empDataGrid").datagrid("beginEdit", rowIndex);
            $("#save,#redo").show();
            emp_obj.editRow = rowIndex;
          }
        } // -- end onDblClickRow() ---
        
		  });
	  });
	  
		function getMenu(id){
		$("#editMenu").window({
			title : "工序物料单设计",
			width : 950,
			height : 550,
			modal : true,
			minimizable : false,
			//href : "detailslist.jsp?designId="+designId
			href : "goDetails.do?id="+id
		});
	}
	</script>
</body>
</html>





