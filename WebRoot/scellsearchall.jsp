<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库存安全配置单制定</title>
    <%@ include file="commons/meta.jsp"%>
  </head>
  
  <body bgcolor="#ccccff" >
  <form action="<%=request.getContextPath() %>/scellController_check2.do" id="scelladd" method="post">
  	<input type="hidden" name="storeId" id="storeId" value="${scell2.storeId}" />
  	<div align="right" style="width: 1063px">
  	<a href="scellsearch.jsp" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-back'">返回</a>
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
		<label>产品名称：<input readonly="readonly" name="productName" value="${scell2.productName}" style="border: hidden;" /></label>
	</td>
     <td colspan="3" style="border: hidden;">
		<label>产品编号：<input readonly="readonly" name="productId" value="${scell2.productId}" style="border: hidden;" /></label>
	</td>
    </tr >
    <tr>
    <td colspan="3" style="border: hidden;"><label>库存报警下限数：<input  name="minAmount" readonly="readonly" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom-width:1  ;border-color: #000000; width: 287px" value="${scell2.minAmount }"/></label></td>
    <td colspan="3" style="border: hidden;"><label>库存报警上限数：<input  name="maxAmount" readonly="readonly" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom-width:1  ;border-color: #000000; width: 305px" value="${scell2.maxAmount }"/></label></td>
    </tr>
    <tr style="border: hidden;">
     <td colspan="3"style="border: hidden;"><label>设计人：<input  name="designer" readonly="readonly" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom-width:1  ;border-color: #000000; width: 349px" value="${scell2.designer }"/></label></td>
     <td colspan="3"style="border: hidden;"><label>登记人：<input  name="register" readonly="readonly" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom-width:1  ;border-color: #000000; width: 369px" value="${scell2.register }"/></label></td>
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
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="storeName" style="border: hidden;background-color:#ffcc33;text-align: center;" value="${scell2.storeName }"/></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="locId" style="border: hidden;background-color:#ffcc33;text-align: center;"  value="${scell2.firstKingId }-${scell2.secondKingId }-${scell2.thirdKingId }"/></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="locName" style="border: hidden;background-color:#ffcc33;text-align: center;"  value="${scell2.firstKingName }-${scell2.secondKingName }-${scell2.thirdKingName}" /></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="splName" style="border: hidden; background-color:#ffcc33; text-align: center;"  value="${scell2.splName }"/></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="maxCapacityAmount" style="border: hidden;background-color:#ffcc33;text-align: center;"  value="${scell2.maxCapacityAmount }"/></td>
    	<td bgcolor="#ffcc33"><input type="text" readonly="readonly" name="storageUnit" style="border: hidden;background-color:#ffcc33;text-align: center;"  value="${scell2.storageUnit }"/></td>
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
    <label><textarea readonly="readonly" rows="5" cols="50" name="config" style="width: 625px;">${scell2.config }</textarea></label>
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
