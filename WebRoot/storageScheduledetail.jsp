<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库存安全配置单制定第二页面</title>
    <%@ include file="commons/meta.jsp"%>
    <script type="text/javascript">
    </script>
  </head>
  
  <body bgcolor="#ccccff" style="width:75%;">
  <form action="<%=request.getContextPath() %>/storageScheduleController_findById.do" id="storageSdetail" method="post">
  	
  	<div align="right" style="width: 990px">
  
  	<a href="<%=request.getContextPath() %>/storageSchedulequery.jsp" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-back'">返回</a>
  	</div>
    <table  bgcolor="#ffffff" cellspacing="0" border="1" style=" ;border-right-width: 5;border-bottom-width: 5"align="center" >
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    <tr style="border: hidden;">
    <th colspan="6" style="border: hidden;" align="center">入库调度单</th>
    </tr>
         <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
     <tr style="border: hidden;">
    <td colspan="3" style="border: hidden;">
		<label>入库单编号：<input readonly="readonly" name="payId" value="${storageSchedule.payId}" style="border: hidden;" /></label>
		<input type="hidden" name="id" value="${storageSchedule.id}">
	</td>
    </tr >
    <tr>
    <td colspan="3" style="border: hidden;"><label>入库理由：<input  name="reason"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 287px" readonly="readonly" value="${storageSchedule.reason}"/></label></td>
    <td colspan="3" style="border: hidden;"><label>入库详细理由：<input  name="reasonexact"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 305px" readonly="readonly" value="${storageSchedule.reasonexact}"/></label></td>
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
    	<td bgcolor="#ccffff" >应入库件数</td>
    	<td bgcolor="#ccffff" >已入库件数</td>
    	<td bgcolor="#ccffff" >存放地址集合</td>
    	<td bgcolor="#ccffff" >调度</td>
    </tr>
	<c:forEach items="${list}" var="l" varStatus="status">
    <tr style="text-align: center;border: hidden">
    	<td bgcolor="#ffcc33"><input type="text" name="storeName" style="border: hidden;background-color:#ffcc33;text-align: center;"value="${status.index+1}" readonly="readonly"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="productName" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${l.productName}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="productId" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${l.productId}" /></td>
    	<td bgcolor="#ffcc33"><input type="text" name="demandAmountb" style="border: hidden; background-color:#ffcc33; text-align: center;" readonly="readonly" value="${l.demandAmountb}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="realAmoutb" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${l.realAmoutb}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="locName" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${l.locName}"/></td>
    	<td bgcolor="#ffcc33"><a style="border: hidden;background-color:#ffcc33;text-align: center;" href="storageScheduleController_modify.do?productId=${l.productId}&payId=${storageSchedule.payId}&id=${storageSchedule.id}&sid=${sid}">调度</a></td>
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
