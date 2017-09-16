<%--
  author:LI
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

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
  	 <div id="searchScellForm" style="padding: 10px">
    
      <!-- 4.条件查询 -->
      <div style="padding: 0 0 0 6px">
        &nbsp;
      	<table>
    		<tr>
    			<th>请选择产品I级分类</th>
    			<td>
    				<select id="firstKingName" name="firstKingName">
					<option value=-1>请选择</option>
				</select>
    			</td>
    				<th>请选择产品II级分类</th>
    			<td>
    				<select id="secondKingName" name="secondKingName">
						<option value=-1>请选择</option>
				</select>
    			</td>
    			<th>请选择产品III级分类</th>
    			<td>
    			 <select id="thirdKingName" name="thirdKingName" >
						<option value=-1>请选择</option>
				</select>
    			</td>
    		</tr>
    		<tr>
    			<th>请输入登记时间</th>
    			<td colspan="6">
    			 <input class="Wdate" type="text" onClick="WdatePicker()" id="beginDate" placeholder="开始日期"/>至<input class="Wdate" type="text" onClick="WdatePicker()"  id="endDate" placeholder="结束日期"/>
    			</td>
    		</tr>
    		<tr>
    			<th>请输入关键字</th>
    			<td colspan="6">
    			 <input type="text" id="str" placeholder="关键字查询"/>
    			</td>
    		</tr>
    	</table>
        <a href="#" class="easyui-linkbutton"
           iconCls="icon-search"
           onclick="scell_obj.search();">查询</a>
      </div>
  	</div>
    <!-- 1.显示表格数据 -->
    <div style="margin-top: 10px">
      <table id="scellDataGrid">
      
      </table>
    </div>
  </div>
	
	<script type="text/javascript">
	  $(function(){
	  $.post("<%=request.getContextPath()%>/scellController_findAll.do",function(data){
		  $("#firstKingName").empty();
		  $(data).find("type").each(function(index){
		  var id=$("id",$(data).find("type")[index]).text();
		  var name=$("name",$(data).find("type")[index]).text();
          $("#firstKingName").append("<option value='"+id+"'>"+name+"</option>");		  
		  });//返回一个集合
		},
		"xml"
		);
		//改变一级分类时触发
		$("#firstKingName").change(function(){
		 $.post("<%=request.getContextPath()%>/scellController_findAll.do",{"pid":$("#firstKingName").val()},function(data){
		 $("#secondKingName").empty();
		 $("#thirdKingName").empty();
		 $("#thirdKingName").append("<option value=-1>请选择</option>");	
		 $(data).find("type").each(function(index){
		  var id=$("id",$(data).find("type")[index]).text();
		  var name=$("name",$(data).find("type")[index]).text();
          $("#secondKingName").append("<option value='"+id+"'>"+name+"</option>");	
		 });
		 },
		 "xml"
		 );
		});
		//改变二级分类时触发
		$("#secondKingName").change(function(){
		$.post("<%=request.getContextPath()%>/scellController_findAll.do", {"pid" : $("#secondKingName").val()}, function(data) {
		$("#thirdKingName").empty();
		$(data).find("type").each(
		function(index) {
		var id = $("id",$(data).find("type")[index]).text();
		var name = $("name",$(data).find("type")[index]).text();
		$("#thirdKingName").append("<option value='"+id+"'>" + name+ "</option>");
		});
		}, 
		"xml"
		);
		});
		scell_obj = { 
        editRow : undefined,
        search : function(){ // 5.条件查询
         $("#scellDataGrid").datagrid('load',{
           firstKingName :$("#firstKingName").val(),
           secondKingName:$("#secondKingName").val(),
           thirdKingName:$("#thirdKingName").val(),
            beginDate:$("#beginDate").val(),
          	endDate:$("#endDate").val(),
           str:$("#str").val(),
         });
       }
       };
	  
		  // 2.自动加载表格数据
		  $("#scellDataGrid").datagrid({
			  url : "scellController_four.do",
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
					return "<a href='scellController_check1.do?proid="+proid+"'>变更</a>";
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





