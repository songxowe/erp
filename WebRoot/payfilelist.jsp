<%--
	author:SONG
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>添加入库产品</title>
<%@ include file="commons/meta.jsp"%>
<script type="text/javascript">
	
</script>
</head>

<!-- 角色列表显示 -->
<body>
	<div id="divBody" style="margin: 10px 30px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
			onclick=file_obj.add();>添加</a>

	</div>


	<div style="margin-top: 20px;">
		<table id="fileDataGrid">

		</table>

	</div>
	</div>
	<script type="text/javascript">
	$(function() {
	        file_obj = {
	        	        AddRow:function (array)
{
 //添加一行
 var tab1 =window.opener.document.getElementById("tab1");
 var i =tab1.rows.length;
 var Nam="'div1'";
 var Cod="fuJ"+i;
 var newTr=tab1.insertRow();
 //添加列 
 var newTd0 = newTr.insertCell();
 var newTd1 = newTr.insertCell();
 var newTd2 = newTr.insertCell();
 var newTd3 = newTr.insertCell();
 var newTd4 = newTr.insertCell();
 var newTd5 = newTr.insertCell();
 var newTd6 = newTr.insertCell();
 var newTd7 = newTr.insertCell();
 var newTd8 = newTr.insertCell();

//设置列内容和属性
 
 newTd0.innerHTML = "<input width='10px' type='checkbox' id='box1' name='isChecked' onClick='enableItemButton();'/>" ;
 newTd1.innerHTML ="<input width='10px' type='text' id='id' name='id' value='"+array[0]+"' style='border: none;' />" ;
 newTd2.innerHTML ="<input width='10px' type='text' id='productId' name='productId' value='"+array[1]+"' style='border: none;' />" ;
 newTd3.innerHTML ="<input width='10px' type='text' id='productName' name='productName' value='"+array[2]+"' style='border: none;' />" ;
 newTd4.innerHTML ="<input width='10px' type='text' id='type' name='type' value='"+array[3]+"' style='border: none;' />" ;
 newTd5.innerHTML ="<input width='10px' type='text' id='personalUnit' name='personalUnit' value='"+array[4]+"' style='border: none;' />" ; 
 newTd6.innerHTML ="<input width='10px' type='text' id='costPrice' name='costPrice' value='"+array[5]+"' style='border: none;' />" ;

 newTd7.innerHTML ="<input width='10px' type='text' id='amount' name='amount' value='' style='border: none;' onBlur='preview()'/>" ;
 newTd8.innerHTML ="<input width='10px' type='text' id='subtotal' name='subtotal' value='' style='border: none;' />" ;
},
	        add: function(){
	        var rows = $("#fileDataGrid").datagrid("getSelections");
	       // var ids = [];
	        //var productName = [];
	       //var amountUnit = [];
	       //var productId =[];
	      //  var realCostPrice= [];var a = window.opener.document.getElementsByName("id");
	     var a=  window.opener.document.getElementsByName("id");
					for(var i=0;i<a.length;a++){
						if(a[i].value == rows[i].id){
							return false;
						}
					}
	        for(var i=0;i<rows.length;i++){
	                  var row=[];
	                  row.push(rows[i].id);
	                  row.push(rows[i].productId);
	                  row.push(rows[i].productName);
	                  row.push(rows[i].type);
	                  row.push(rows[i].personalUnit);
	                  row.push(rows[i].costPrice);
					//ids.push(rows[i].id);
					//productName.push(rows[i].productName);
					//amountUnit.push(rows[i].amountUnit);
					//productId.push(rows[i].productId);
					//realCostPrice.push(rows[i].realCostPrice);
					
					
					   file_obj.AddRow(row);
							};
							window.close();
				
	        },
	        
		};
	
		
        
		$("#fileDataGrid").datagrid( {
			url : "hzjspaydetailsController.do",
			title : "添加产品",
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
				field : "productId",
				title : "编号",
				width : 100,
				sortable : true
			}, {
				field : "productName",
				title : "名称",
				width : 100,
				sortable : true
			}, {
				field : "type",
				title : "类型",
				width : 100,
				sortable : true,
				formatter : function(value,row,index){
					if(value=="Y001-1"){
						return "商品";
					}if(value=="Y001-2"){
						return "物料";
					}else{
						return "产品";
					}
					},
				}, {
				field : "personalUnit",
				title : "单位",
				width : 100,
				sortable : true
			}, {
				field : "costPrice",
				title : "成本价",
				width : 100,
				sortable : true
				}
			 ] ],
			toolbar : "#searchUserRoleForm",
			pagination : true,
			pageSize : 5,
			pageList : [ 2, 5, 10, 15, 20 ],
			sortName : "id",
			sortOrder : "asc",
		});
		
		$.parser.parse($('#divBody').parent());
		});
	
</script>
</body>
</html>
