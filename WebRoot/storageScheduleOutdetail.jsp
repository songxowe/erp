<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>出库调度</title>
    <%@ include file="commons/meta.jsp"%>
    <script type="text/javascript">
    </script>
  </head>
  
  <body bgcolor="#ccccff" >
  <form action="<%=request.getContextPath() %>/storageScheduleOutController_findById.do" id="storageSOutdetail" method="post">
  	
  	<div align="right" style="width: 990px">
  
  	<a href="<%=request.getContextPath() %>/storageScheduleOutquery.jsp" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-back'">返回</a>
  	</div>
    <table  bgcolor="#ffffff" cellspacing="0" border="1" style=" ;border-right-width: 5;border-bottom-width: 5"align="center" >
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    <tr style="border: hidden;">
    <th colspan="6" style="border: hidden;" align="center">出库调度单</th>
    </tr>
         <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
     <tr style="border: hidden;">
    <td colspan="3" style="border: hidden;">
		<label>出库单编号：<input readonly="readonly" name="payId" value="${storageScheduleOut.id}" style="border: hidden;" /></label>
	</td>
    </tr >
    <tr>
    <td colspan="3" style="border: hidden;"><label>出库理由：<input  name="reason"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 287px" readonly="readonly" value="${storageScheduleOut.reason}"/></label></td>
    <td colspan="3" style="border: hidden;"><label>出库详细理由：<input  name="reasonexact"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 305px" readonly="readonly" value="${storageScheduleOut.reasonexact}"/></label></td>
    </tr>
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    <tr style="text-align: center;border: hidden;">
    	<td bgcolor="#ccffff" >序号</td>
    	<td bgcolor="#ccffff" >产品名称</td>
    	<td bgcolor="#ccffff" >产品编号</td>
    	<td bgcolor="#ccffff" >应出库件数</td>
    	<td bgcolor="#ccffff" >已出库件数</td>
    	<td bgcolor="#ccffff" >存放地址集合</td>
    	<td bgcolor="#ccffff" >调度</td>
    </tr>
	<c:forEach items="${list}" var="l" varStatus="status">
    <tr style="text-align: center;border: hidden">
    	<td bgcolor="#ffcc33"><input type="text" name="storeName" style="border: hidden;background-color:#ffcc33;text-align: center;"value="${status.index+1}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="productName" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${l.productName}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="productId" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${l.productId}" /></td>
    	<td bgcolor="#ffcc33"><input type="text" name="demandAmountb" style="border: hidden; background-color:#ffcc33; text-align: center;" readonly="readonly" value="${l.demandAmounta}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="realAmoutb" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${l.realAmouta}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="locName" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${l.locName}"/></td>
    	<td bgcolor="#ffcc33"><a style="border: hidden;background-color:#ffcc33;text-align: center;" href="storageScheduleController_modify.do?productId=${l.productId}">调度</a></td>
    </tr>
    </c:forEach>
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
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
