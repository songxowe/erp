<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库存安全配置单制定</title>
    <%@ include file="commons/meta.jsp"%>
    	<script type="text/javascript">
	function add(){
		var minAmount =document.getElementById("minAmount");
		var maxAmount =document.getElementById("maxAmount");
		var maxCapacityAmount=document.getElementById("maxCapacityAmount");
		if(minAmount.value !=""){
			if(isNaN(minAmount.value) == true){
				alert("库存下限请输入数字！");
				minAmount.value="";
			}else{
				if(maxAmount.value !=""){
					if(isNaN(maxAmount.value) == true){
						alert("库存上限请输入数字！");
						maxAmount.value="";
					}else{
						if(parseInt(maxAmount.value) < parseInt(minAmount.value)){
							alert("报警上限不能小于报警下限");
						}else{
							if(maxCapacityAmount.value !=""){
								if(isNaN(maxCapacityAmount.value) == true){
									alert("库存最大容量请输入数字！");
									maxCapacityAmount.value="";
								}else{
									if( parseInt(maxAmount.value) > parseInt(maxCapacityAmount.value)){
										alert("最大库存容量不能小于报警上限！");
									}else{
										document.getElementById('scelladd').submit();
									}
								}
							}else{
								alert("请输入库存最大容量！");
							}
						}
					}
				}else{
					alert("请输入库存报警上限！");
				}
			}
		}else{
			alert("请输入库存报警下限！");
		}
	}
	</script>
  </head>
  
  <body bgcolor="#ccccff" >
  <form action="<%=request.getContextPath() %>/scellController_add.do" id="scelladd" method="post">
  	<input type="hidden" name="firstKingId" value="${scell.firstKingId}">
  	<input type="hidden" name="secondKingId" value="${scell.secondKingId}">
  	<input type="hidden" name="thirdKingId" value="${scell.thirdKingId}">
  	<input type="hidden" name="firstKingName" value="${scell.firstKingName}">
  	<input type="hidden" name="secondKingName" value="${scell.secondKingName}">
  	<input type="hidden" name="thirdKingName" value="${scell.thirdKingName}">
  	<div align="right" style="width: 1061px">
  	<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="sub"  href="#" onclick="add()">提交</a>
  	<a href="scellist.jsp" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-back'">返回</a>
  	</div>
    <table  bgcolor="#ffffff" cellspacing="0" border="1" style=" ;border-right-width: 5;border-bottom-width: 5"align="center" >
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    <tr style="border: hidden;">
    <th colspan="6" style="border: hidden;">安全库存配置单</th>
    </tr>
         <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
     <tr style="border: hidden;">
    <td colspan="3" style="border: hidden;">
		<label>产品名称：<input readonly="readonly" name="productName" value="${scell.productName}" style="border: hidden;" /></label>
	</td>
     <td colspan="3" style="border: hidden;">
		<label>产品编号：<input readonly="readonly" name="productId" value="${scell.productId}" style="border: hidden;" /></label>
	</td>
    </tr >
    <tr>
    <td colspan="3" style="border: hidden;"><label>库存报警下限数：<input  name="minAmount"  id="minAmount"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom-width:1  ;border-color: #000000; width: 287px" value=""/></label></td>
    <td colspan="3" style="border: hidden;"><label>库存报警上限数：<input  name="maxAmount"  id="maxAmount" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom-width:1  ;border-color: #000000; width: 305px" value=""/></label></td>
    </tr>
    <tr style="border: hidden;">
     <td colspan="3"style="border: hidden;"><label>设计人：<input  name="designer"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom-width:1  ;border-color: #000000; width: 349px" value=""/></label></td>
     <td colspan="3"style="border: hidden;"><label>登记人：<input  name="register"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom-width:1  ;border-color: #000000; width: 369px" value=""/></label></td>
    </tr>
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    <tr style="text-align: center;border: hidden;">
    	<td bgcolor="#ccffff" >库房名称</td>
    	<td bgcolor="#ccffff" >储存地址编号</td>
    	<td bgcolor="#ccffff" >储存地址名称</td>
    	<td bgcolor="#ccffff" >储存单元简称</td>
    	<td bgcolor="#ccffff" >最大储存量</td>
    	<td bgcolor="#ccffff" >储存单位</td>
    </tr>

    <tr style="text-align: center;border: hidden">
    	<td bgcolor="#ffcc33"><input type="text" name="storeName" style="border: hidden;background-color:#ffcc33;text-align: center;"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="locId" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${scell.firstKingId }-${scell.secondKingId }-${scell.thirdKingId }"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="locName" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${scell.firstKingName }-${scell.secondKingName }-${scell.thirdKingName}" /></td>
    	<td bgcolor="#ffcc33"><input type="text" name="splName" style="border: hidden; background-color:#ffcc33; text-align: center;"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="maxCapacityAmount" id="maxCapacityAmount" style="border: hidden;background-color:#ffcc33;text-align: center;"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="storageUnit" style="border: hidden;background-color:#ffcc33;text-align: center;"/></td>
    </tr>
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    <tr>
    <td colspan="1" align="right" style="border: hidden;">
    	配置要求：
    </td>
    <td colspan="5" style="border: hidden;">
    <label><textarea rows="5" cols="50" name="config" style="width: 625px; "></textarea></label>
    </td>
    </tr>
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    </table>
    </form>
  </body>
</html>
