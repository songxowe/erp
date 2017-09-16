<%--
  author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>登记详情</title>
<%@ include file="../commons/meta.jsp"%>

</head>
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	<c:redirect url="login.jsp" />
</c:if>

<body bgcolor="#ccccff" >
	 <form action="<%=request.getContextPath() %>/fzjspayController_modifySotreTag.do" id="a" method="post" >
  	<input type="hidden" name="ID" value="${spa.id}" />
  	<div align="right" style="width: 990px">
  	<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="sub" onClick="queren()">提交</a>
  	<a href="javascript:closeWindowOfMenuView()" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-back'">返回</a>
  	</div>
	<!--  
		<div>
			<div align="right">
				<span class="radioSpan"> 
				<input type="radio" id="checkTag1" name="checkTag" 
				       value="S001-2" checked="checked">未通过
			    <input type="radio" id="checkTag2" name="checkTag" 
			    value="S001-0">通过
				</span> <a id="btn" href="#" class="easyui-linkbutton"
					onclick="check('${sgd.parentId}')">确认</a>
					&nbsp;<a href="javascript:closeWindowOfMenuView()" 
					class="easyui-linkbutton">返回</a>&nbsp;
					<input type="hidden" id="${sga.id}}" name="Id">
			</div>
			-->
	<table  bgcolor="#ffffff" cellspacing="0" border="1" style=" ;border-right-width: 5;border-bottom-width: 5"align="center" >
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    <tr style="border: hidden;" >
    <h2 colspan="6" style="border: hidden;text-align:center;">入库单</h2>
    </tr>
         <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
     <tr style="border: hidden;">
	<td colspan="3" style="border: hidden;">
	<label>入库单编号：<input readonly="readonly" name="payId" value="${spa.payId}" style="border: hidden;" /></label>
	</td>	
	</tr>
	<tr>
	<td colspan="3" style="border: hidden;">
		<c:if test="${spa.reason=='R001-1'}">
	<label>入库理由:<input readonly="readonly" name="mz" value="生产入库" style="border: hidden;" />
	</label>	
	</c:if>
	<c:if test="${spa.reason=='R001-2'}">
	<label>入库理由:<input readonly="readonly" name="mz" value="库存初始" style="border: hidden;" />
	</label>	
	</c:if>
	<c:if test="${spa.reason=='R001-3'}">
	<label>入库理由:<input readonly="readonly" name="mz" value="赠送" style="border: hidden;" />
	</label>	
	</c:if>
	<c:if test="${spa.reason=='R001-4'}">
	<label>入库理由:<input readonly="readonly" name="mz" value="内部归还" style="border: hidden;" />
	</label>	
	</c:if>
	<c:if test="${spa.reason=='R001-5'}">
	<label>入库理由:<input readonly="readonly" name="mz" value="其他归还" style="border: hidden;" />
	</label>	
	</c:if>
	<input type="hidden" name="reason" value="${spa.reason}"/>
		</td>
		<td colspan="3" style="border: hidden;">
	<label>入库详细理由:<input readonly="readonly" name="reasonexact" value="${spa.reasonexact}" style="border: hidden;" /></label>	
		</td>
		</tr>
		
		<tr style="text-align: center;border: hidden;">
    	<td bgcolor="#ccffff" >产品编号</td>
    	<td bgcolor="#ccffff" >产品名称</td>
    	<td bgcolor="#ccffff" >库房名称</td>
    	<td bgcolor="#ccffff" >当前库存数量</td>
    	<td bgcolor="#ccffff" >应出库件数</td>
    	<td bgcolor="#ccffff" >已出库件数</td>
    	<td bgcolor="#ccffff" >本次出库数量</td>
    	<td bgcolor="#ccffff" >复核序列号</td>
    </tr>
    
     
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    <c:forEach items="${sp}" var="sp">
    	 <tr style="text-align: center;border: hidden">
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="productId"  style="border: hidden;background-color:#ffcc33;text-align: center;" value="${sp.productId }"/></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="productName" style="border: hidden;background-color:#ffcc33;text-align: center;"  value="${sp.productName }"/></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="storeName" style="border: hidden;background-color:#ffcc33;text-align: center;"  value="${scel.storeName}" /></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="paidAmountSum" style="border: hidden; background-color:#ffcc33; text-align: center;"  value="${spa.paidAmountSum }"/></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="demandAmountb" style="border: hidden;background-color:#ffcc33;text-align: center;"  value="${spa.demandAmountb}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="realAmoutb" style="border: hidden;background-color:#ffcc33;text-align: center;"  value="${spa.realAmoutb }"/></td>
    	<td bgcolor="#ffcc33"><input type="text"  name="nowAmountb" style="border: hidden;background-color:#ffcc33;text-align: center;"  /></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="parentId" style="border: hidden;background-color:#ffcc33;text-align: center;"  value="${sp.parentId}"/></td>
    </tr>
    </c:forEach>
    <tr>
	<td colspan="3" style="border: hidden;">
	<label>应入库总件数:<input readonly="readonly" name="demandAmountAllb" value="${spa.demandAmountAllb}" style="border: hidden;" /></label>	
		</td>
		<td colspan="3" style="border: hidden;">
	<label>已入库总件数:<input readonly="readonly" name="realAmountAllb" value="${spa.realAmountAllb }" style="border: hidden;" /></label>	
		</td>
		</tr>
		
		<tr>
	<td colspan="3" style="border: hidden;">
	<label>应入库总成本:<input readonly="readonly" name="demandSalAllb" value="${spa.demandSalAllb}" style="border: hidden;" /></label>	
		</td>
		<td colspan="3" style="border: hidden;">
	<label>已入库总成本:<input readonly="readonly" name="realSalAllb" value="${spa.realSalAllb }" style="border: hidden;" /></label>	
		</td>
		</tr>
		
		<tr>
    <td colspan="3" style="border: hidden;"><label>登记人：<input  name="register"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom-width:1  ;border-color: #000000; width: 287px" /></label></td>
	<td colspan="3" style="border: hidden;">
	登记时间:<SPAN id="registerTime"></SPAN>
				<SCRIPT type=text/javascript>
					var clock = new Clock();
					clock.display(document.getElementById("registerTime"));
				</SCRIPT>

    </tr>	
		</table>
			
	<script type="text/javascript">
	function closeWindowOfMenuView() {
		$("#editsg2").window("close", true);
	}
	
	function queren(){
	  
	  var i=window.confirm("是否确认提交?");
	   if(i){
	     document.getElementById("a").submit();
	   }
	}
	function check(parentId) {
		alert("第一个"+parentId)
		var check = "不通过";
		var checkTag = "";
		if (document.getElementById("checkTag1").checked) {
			check = "不通过";
			checkTag = document.getElementById("checkTag1").value;
		}
		if (document.getElementById("checkTag2").checked) {
			check = "通过";
			checkTag = document.getElementById("checkTag2").value;
		}
		var flag = window.confirm("该表单审核" + check + ",是否提交？");
		if (flag) {
			alert("第二个"+parentId)
			var checker = $("#checker").val();
			var remark = $("remark").val();
			$.ajax({
				cache : true,
				type : "POST",
				url : "zjsSgDetailsController_check.do",
				data : {
					"parentId" : parentId,
					"checker" : checker,
					"checkTag" : checkTag,
					"remark" : remark
				},
				async : false,
				success : function(data) {
					if (data) {
						$.messager.show({
							title : "提示",
							msg : "审核" + data + "条数据成功!"
						});
						$("#mapplyDataGrid").datagrid("load", {});
						$("#editPayId").window("close", true);
					}
				}
			});
		}
	}
	</script>
	</form>
</body>
</html>





