<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>入库调度</title>
    <%@ include file="commons/meta.jsp"%>
	    <script type="text/javascript">
	    function click(){
	    	alert("hasjkh");
 	   var a= $("#storageUnit").value;
 	   var b=$("#demandAmounta").value;
 	   if(parseInt(a)!=parseInt(b)){
 		 a.value="";
 		 alert("本次入库数量错误，请重新输入!");
 	   }else{
 		   document.getElementById("storageSupdate").submit();
 	   }
 	   //href="<%=request.getContextPath() %>/storageScheduleController_finally.do?productId=${storageSchedule.productId}
    }
    </script>					
  </head>
  
  <body bgcolor="#ccccff" style="width:60%;">
  <form action="<%=request.getContextPath() %>/storageScheduleController_finally.do?sid=${sid}&payId=${payId}" id="storageSupdate" method="post">
  	<input type="hidden" name="sid" value="${sid}">
  	<input type="hidden" name="payId" value="${payId}">
  	<div align="right" style="width: 990px;position:absolute;left:100px;">
  	<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="sub" href="<%=request.getContextPath() %>/storageScheduleController_finally.do?productId=${storageSchedule.productId}&sid=${sid}&payId=${payId}&demandAmountb=${demandAmountb}">提交</a>
  	<a href="javascript:history.go(-1)" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-back'">返回</a>
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
		<label>入库单编号：<input readonly="readonly" name="payId" value="${payId}" style="border: hidden;" /></label>
	</td>
     <td colspan="3" style="border: hidden;">
		<label>产品编号：<input readonly="readonly" name="productId" value="${storageSchedule.productId}" style="border: hidden;" /></label>
	</td>
    </tr >
    <tr>
    <td colspan="3" style="border: hidden;"><label>产品名称：<input  name="reason"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 287px" readonly="readonly" value="${storageSchedule.productName}"/></label></td>
    <td colspan="3" style="border: hidden;"><label>产品单价：<input  name="reasonexact"  style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 305px" readonly="readonly" value="${storageSchedule.productPrice}"/></label></td>
    </tr>
    <tr style="border: hidden;">
    <td colspan="6" style="border: hidden;">
    &nbsp;
    </td>
    </tr>
    <tr style="text-align: center;border: hidden;">
    	<td bgcolor="#ccffff" >序号</td>
    	<td bgcolor="#ccffff" >产品名称</td>
    	<td bgcolor="#ccffff" >库存地址编号</td>
    	<td bgcolor="#ccffff" >库存地址名称</td>
    	<td bgcolor="#ccffff" >存储单元简称</td>
    	<td bgcolor="#ccffff" >当前可存放数量</td>
    	<td bgcolor="#ccffff" >本次入库数量</td>
    </tr>

    <tr style="text-align: center;border: hidden">
    	<td bgcolor="#ffcc33"><input type="text" name="storeName" style="border: hidden;background-color:#ffcc33;text-align: center;"value="1"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="productName" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${storageSchedule.productName}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="productId" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${storageSchedule.locId}" /></td>
    	<td bgcolor="#ffcc33"><input type="text" name="demandAmountb" style="border: hidden; background-color:#ffcc33; text-align: center;" readonly="readonly" value="${storageSchedule.locName}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="realAmoutb" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${storageSchedule.splName}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" name="locName" style="border: hidden;background-color:#ffcc33;text-align: center;" readonly="readonly" value="${storageSchedule.currentAmount}"/></td>
    	<td bgcolor="#ffcc33"><input type="text" id="demandAmountb" name="demandAmountb" style="border: hidden;background-color:#ffcc33;text-align: center;" value="${storageSchedule.demandAmountb }"/></td>
    </tr>
    <tr><td colspan="3" style="border: hidden;">登记人：<input type="text" name="register" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 287px" readonly="readonly" value="${storageSchedule.register }"/></td>
    	<td colspan="3" style="border: hidden;">登记时间：<input type="text" name="" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 287px" readonly="readonly" value="${registerTime }"/></td>
    </tr>
     <tr><td colspan="3" style="border: hidden;">应入库数：<input type="text" name="" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 287px" readonly="readonly" value="${storageSchedule.demandAmountb }"/></td>
    	<td colspan="3" style="border: hidden;">已入库数：<input type="text" name="" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 287px" readonly="readonly" value="${storageSchedule.realAmoutb }"/></td>
    </tr>
    <tr><td colspan="3" style="border: hidden;">应入库成本：<input type="text" name="" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 287px" readonly="readonly" value="${storageSchedule.demandAmountb *storageSchedule.productPrice}"/></td>
    	<td colspan="3" style="border: hidden;">已入库成本：<input type="text" name="" style=" border-top: thin;border-left:thin;border-right:thin;border-bottom:thin ; width: 287px" readonly="readonly"value="${storageSchedule.realAmoutb *storageSchedule.productPrice}"/></td>
    </tr>
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
