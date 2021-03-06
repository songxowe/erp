<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>工序物料设计单</title>
		<%@ include file="commons/meta.jsp"%>
	</head>
<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	  <c:redirect url="login.jsp"/>
	</c:if>
  
  <body   oncontextmenu="event.returnValue=true"
	style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff")>
			<div style="text-align: center;">
  	<h2>工序物料设计单</h2>
  </div>
	
	<form action="" method="post">
   <table  class="TABLE_STYLE4">
			<tr height=20 class="TR_STYLE1">
				<td>设计单详细物料设计完成，需要进行审核！</td>
				</td>
			</tr>
		</table> <br><br>
		<div style="text-align: center;">
			 <p>工序单编号：${MdProcedure.designId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;产品编号：${MdProcedure.productId} </p><br>
      <p>产品名称：${MdProcedure.productName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;设计人：<u>${MdProcedure.designer}</u></p>
		</div><br>
		<table bordercolor=#000000 bordercolorlight=#848284
			bordercolordark=#eeeeee border=1 cellspacing=0 cellpadding=0
			align=center class="TABLE_STYLE5">
			<tr height=20 bgcolor=#D2E9FF class="TR_STYLE2">
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>序号</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2" style="width: 132px; "><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>工序名称</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2" style="width: 256px; "><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>工序编号</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2" style="width: 240px; "><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>描述</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>工时数（小时）</td>
				<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"><font
					class="resizeDivClass" onmousedown="MouseDownToResize(this);"
					onmousemove="MouseMoveToResize(this);"
					onmouseup="MouseUpToResize(this);"></font>工时成本小计（元）</td>
			</tr>
			<tr height=20 class="TR_STYLE1">
				<c:forEach items="${MdpDetails}" var="str" varStatus="rows">
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${rows.index + 1 }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.procedureName }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.procedureId }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.procedureDescribe }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.labourHourAmount }</td>
					<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.subtotal }</td>
					
			</tr>
			</c:forEach>
			</form>
		</table><br><br><br>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工时总成本：${MdProcedure.costPriceSum }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;物料总成本：<u>${SubtotalAll }</u></p><br><br>
		
  </body>
</html>