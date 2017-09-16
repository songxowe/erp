<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<!-- 显示查询出的出库页 -->
<!DOCTYPE HTML >
<html>
	<head>
	<%@ include file="commons/meta.jsp"%>
	</head>
	
	<body bgcolor="#E9F8F3" oncontextmenu="event.returnValue=true" style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">
 			<div id="editsg1"></div>
 			<div style="margin-top: 20px;">
				<table id="dfiledatagrid6">

				</table>

			</div>
<script type="text/javascript">
$(function(){
	$("#dfiledatagrid6").datagrid({
		title:"当前等待登记的出库登记总数:",
		width:800,
		height:320,
		rownumbers:true,
		url:"zjsSgatherController_list2.do",
		columns:[[
			
			{field:"gatherId",title:"出库单编号",width:100,height:40},
			{field:"reason",title:"出库理由",width:100,height:40,
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
			 
			},
			{field:"reasonexact",title:"出库详细理由",width:100,height:40},
			{field:"registerTime",title:"登记时间",width:100,height:40},
			{field:"amountSum",title:"总件数",width:100,height:40},
			{field:"costPriceSum",title:"总金额",width:100,height:40},
			{field:"op1",title:"复核",width:100,height:40,
			formatter : function(value, rowData, rowIndex){
					var sgdId = rowData["id"];
					return "<a href='#' onclick=getMenu("+sgdId+")>复核</a>"
				}
			}
			
			]],
			toolbar : "#searchRoleForm",
			pagination : true,
			pageSize : 10,
			pageList : [ 2, 5, 10, 15, 20 ],
			sortName : "productId",
			sortOrder : "asc"
			
	});
});

function getMenu(id){
		$("#editsg1").window({
			title : "查看菜单详情",
			width : 550,
			height : 480,
			modal : true,
			minimizable : false,
			href : "zjsSgDetailsController_fuheview.do?id="+id
		});
	}
</script>
 	
 	</body>

</html>
