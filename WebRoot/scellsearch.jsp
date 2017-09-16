<%--
  author:LI
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>制定库存安全配置单</title>
    <%@ include file="commons/meta.jsp"%>
  </head>

  <c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
    <c:redirect url="login.jsp"/>
  </c:if>
  <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  <body>
  <!-- 0.easyui显示数据 -->
  <div style="margin: 10px 30px">
    <!-- 3.设置 toolbar -->
    <div id="searchScellForm" style="padding: 10px">
    
      <!-- 4.条件查询 -->
      <div style="padding: 0 0 0 6px">
        &nbsp;
      	<table>
    		<tr>
    			<th>请选择产品I级分类<th>
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
    			<th>请选择配置单状态</th>
    			<td>
    				<select id="checkTag">
    					<option></option>
    					<option value="S005-1">等待</option>
    					<option value="S005-2">完成</option>
    					<option value="S005-3">执行</option>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<th>请输入登记时间</th>
    			<td colspan="7">
    			 <input class="Wdate" type="text" onClick="WdatePicker()" id="firstdate" placeholder="开始日期"/>至<input class="Wdate" type="text" onClick="WdatePicker()"  id="lastdate" placeholder="结束日期"/>
    			</td>
    		</tr>
    		<tr>
    			<th>请输入关键字</th>
    			<td colspan="7">
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
           firstdate:$("#firstdate").val(),
           lastdate:$("#lastdate").val(),
           str:$("#str").val(),
           checkTag:$("#checkTag").val(),
         });
       }
       };
       
		  // 2.自动加载表格数据
		  $("#scellDataGrid").datagrid({
			  url : "scellController_three.do",
			  title : '产品列表',
		    fitColumns : true, // 自动展开/收缩列
		    striped : true,    // 显示斑马线效果
		    rownumbers : true, // 行号
		    columns:[[{ // -- 列开始 ---------
          field : 'storeId',  // field 名必需与json中的名一致
          title : '配置单编号',
          width : 110,
          sortable : true,
          formatter : function(value, rowData, rowIndex){
					var proid = rowData["storeId"];
					var proname=rowData["productName"];
					return "<a href='scellController_check3.do?proid="+proid+"'>"+proid+"</a>";
				}
        },{
          field : 'productId',
          title : '产品编号',
          width : 100,
          sortable : true,
        },{
          field : 'productName',
          title : '产品名',
          width : 70,
          sortable : true,
        },{
          field : 'productClass',
          title : '配置单状态',
          width : 70,
          sortable : true,
        },{
          field : 'checkTag',
          title : '复核状态',
          width : 100,
          sortable : true,
        }, ]], // -- 列结束 ---------
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





