<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
  <div style="text-align: center;">
  	<h2>工序物料设计单</h2>
  </div>
  <div style="margin: 10px 30px">
    <!-- 3.设置 toolbar -->
    <div id="searchEmpForm" style="padding: 10px">
      <!-- 6.操作按钮 (plain:为true时显示简洁效果)-->
      <div style="margin-bottom: 10px">
        
      </div> 
      <p>工序单编号：${MdProcedure.designId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;产品编号：${MdProcedure.productId} </p>
      <p>产品名称：${MdProcedure.productName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;设计人：${MdProcedure.designer}</p>
    </div>
    <div style="padding: 0 0 0 6px" align="right" >
        &nbsp;
        <a href="${pageContext.request.contextPath}/pm/goMaterial.do?ProductId=${MdProcedure.productId}" class="easyui-linkbutton" data-options="iconCls:'icon-redo'">设计</a>
      </div>
    <!-- 1.显示表格数据 -->
    <div style="margin-top: 10px">
      <table id="pDataGrid">
      
      </table>
    </div>
  </div>
	
	<script type="text/javascript">
	  $(function(){
		  emp_obj = { 
       editRow : undefined,
       search : function(){ // 5.条件查询
         $("#pDataGrid").datagrid('load',{
           procedureName : $.trim($("#procedureName").val()),
         });
       }
		  };
		  		  
		  // 2.自动加载表格数据
		  $("#pDataGrid").datagrid({
			  url : "details/mdpDetailsController.do?designId="+'${MdProcedure.designId}',
			  title : '工序设计单',
		    fitColumns : true, // 自动展开/收缩列
		    striped : true,    // 显示斑马线效果
		    rownumbers : true, // 行号
		    columns:[[{ // -- 列开始 ---------
        field : 'detailsNumber', // field 名必需与json中的名一致
											title : '序号',
											width : 20,
											sortable : true
										},
										{
											field : 'procedureName',
											title : '工序名称',
											width : 50,
											sortable : true,
										},
										{
											field : 'procedureId',
											title : '工序编号',
											width : 50,
											sortable : true,
										},
										{
											field : 'procedureDescribe',
											title : '描述',
											width : 80,
											sortable : true,
										},
										{
											field : 'labourHourAmount',
											title : '工时数（小时）',
											width : 50,
											sortable : true,
										},
										{
											field : 'subtotal',
											title : '工时成本小计（元）',
											width : 50,
											sortable : true
										},
										{
											field : 'moduleSubtotal',
											title : '物料成本小计（元）',
											width : 50,
											sortable : true
										} ] ], // -- 列结束 ---------
        toolbar : "#searchEmpForm",
        pagination : true, // -- 分页设置 ----
        pageSize : 5,// rows:每页显示的记录条数 (page 控件自动计算)
        pageList : [ 5, 10, 15, 20, 50 ],// 设置每页条数的列表
        sortName : "procedureName", // sort:排序列 (默认)
        sortOrder : "asc",  // order:升序/降序 (默认)
        
        // 11.在用户完成编辑一行的时候触发(点击 保存 按钮)，参数包括：
        // rowIndex：编辑行的索引，索引从0开始。
        // rowData：对应于完成编辑的行的记录。
        // changes：更改后的字段(键)/值对。
        onAfterEdit : function(rowIndex, rowData, changes){
          $("#save,#redo").hide();
          
          // 从上一次的提交获取改变的所有行
          var inserted = $("#pDataGrid").datagrid("getChanges","inserted");
          var updated = $("#pDataGrid").datagrid("getChanges","updated");
          var url = "pController_save.do";
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
            data : {
													"detailsNumber" : rowData.detailsNumber,
													"procedureName" : rowData.procedureName,
													"procedureId" : rowData.procedureId,
													"procedureDescribe" : rowData.procedureDescribe,
													"labourHourAmount" : rowData.labourHourAmount,
													"subtotal" : rowData.subtotal,
													"moduleSubtotal" : rowData.moduleSubtotal
												},
            beforeSend : function(){
              // 显示载入状态
              $("#pDataGrid").datagrid("loading");
            },
            success : function(data){
              if(data){
                // 隐藏载入状态
                $("#pDataGrid").datagrid("loaded");
                // 加载和显示第一页的所有行
                $("#pDataGrid").datagrid("load");
                // 取消选择所有当前页中所有的行
                $("#pDataGrid").datagrid("unselectAll");
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
            $("#pDataGrid").datagrid("endEdit", emp_obj.editRow);
          }
          if (emp_obj.editRow == undefined) {
            $("#pDataGrid").datagrid("beginEdit", rowIndex);
            $("#save,#redo").show();
            emp_obj.editRow = rowIndex;
          }
        } // -- end onDblClickRow() ---
        
		  });
	  });
	  


	</script>
	<br><br><br>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工时总成本：${MdProcedure.costPriceSum }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登记时间：<fmt:formatDate value="${MdProcedure.registerTime}" type="date" dateStyle="default" pattern=" yyyy年MM月dd日 E"/></p>
</body>
</html>





