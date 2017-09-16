<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../commons/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>菜单管理</title>
<%@ include file="../commons/meta.jsp"%>
<head>
<STYLE>
A:visited {
	TEXT-DECORATION: none
}

A:active {
	TEXT-DECORATION: none
}

A:hover {
	TEXT-DECORATION: underline overline
}

A:link {
	TEXT-DECORATION: none
}

.t {
	LINE-HEIGHT: 1.4
}

BODY {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt;
	scrollbar-face-color: #F1F1F1;
	SCROLLBAR-HIGHLIGHT-COLOR: #F1F1F1;
	SCROLLBAR-SHADOW-COLOR: buttonface;
	SCROLLBAR-3DLIGHT-COLOR: buttonhighlight;
	SCROLLBAR-TRACK-COLOR: #868686 SCROLLBAR-DARKSHADOW-COLOR: buttonshadow;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

TD {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

DIV {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

FORM {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

OPTION {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

P {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

TD {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

BR {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}
</STYLE>

<STYLE>
.gray {
	CURSOR: hand;
	FILTER: gray
}

.style3 {
	font-size: 16px;
	font-weight: bold;
}

.TABLE_STYLE11 {
	border: 1px solid;
	border-collapse: collapse;
	width: 95%;
}

.TABLE_STYLE1 {
	border: 1px solid;
	border-collapse: collapse;
	width: 95%;
}

.TABLE_STYLE2 {
	width: 95%;
}

.TABLE_STYLE3 {
	width: 100%;
}

.TABLE_STYLE4 {
	width: 95%;
}

.TABLE_STYLE5 {
	border: 1px solid;
	border-collapse: collapse;
	width: 95%;
}

.TABLE_STYLE6 {
	width: 820;
}

.TABLE_STYLE7 {
	border: 1px solid;
	border-collapse: collapse;
	width: 100%;
}

.ALL-STYLE {
	border: 1px ridge #666666;
	border-color: #DEDBD6;
}

.TR_STYLE1 {
	
}

.TR_STYLE2 {
	
}

.style8 {
	color: #000066
}

.TD_HANDBOOK_STYLE1 {
	vertical-align: top;
	width: 100%;
	color: #0000FF;
}

.TD_STYLE1 {
	background-image: url(/erp/images/line7.gif);
}

.TD_STYLE2 {
	border-spacing: 1px;
}

.TD_STYLE3 {
	
}

.TD_STYLE4 {
	
}

.TD_STYLE5 {
	
}

.TD_STYLE6 {
	
}

.TD_STYLE7 {
	background-image: url(/erp/images/line4.gif);
}

.TD_STYLE8 {
	
}

.SUBMIT_STYLE1 {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.BUTTON_STYLE1 {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.RESET_STYLE1 {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.RADIO_STYLE1 {
	
}

.CHECKBOX_STYLE1 {
	
}

.SELECT_STYLE1 {
	width: 100%;
}

.SELECT_STYLE2 {
	width: 100%;
}

.TEXTAREA_STYLE1 {
	width: 100%;
}

.DIV_STYLE1 {
	float: right;
	vertical-align: top;
}

.DIV_STYLE2 {
	float: center;
	vertical-align: top;
}

.INPUT_STYLE1 {
	width: 100%
}

.INPUT_STYLE3 {
	BORDER-BOTTOM: 1px solid #000000;
	BORDER-left: 0px;
	BORDER-right: 0px;
	BORDER-top: 0px;
	width: 100%
}

.INPUT_STYLE4 {
	BORDER-BOTTOM: 0px;
	BORDER-left: 0px;
	BORDER-right: 0px;
	BORDER-top: 0px;
	width: 100%
}

.INPUT_STYLE5 {
	background-color: #FFFFCC;
	BORDER-BOTTOM: 0px;
	BORDER-left: 0px;
	BORDER-right: 0px;
	BORDER-top: 0px;
	width: 100%
}

.INPUT_STYLE6 {
	background-color: #FFFAAA;
	BORDER-BOTTOM: 0px;
	BORDER-left: 0px;
	BORDER-right: 0px;
	BORDER-top: 0px;
	width: 100%
}

.FILE_STYLE1 {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.btn3_mouseout {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.btn3_mouseover {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#D7E7FA);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.btn3_mousedown {
	BORDER-RIGHT: #FFE400 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #FFE400 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #FFE400 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #FFE400 1px solid
}

.btn3_mouseup {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}
</STYLE>

</head>
<body bgcolor="#ebf3fb" oncontextmenu="event.returnValue=true"
	style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">
	<form
		action="<%=request.getContextPath() %>/dispatchController_addd.do?id=${apply.id}&productId=${apply.productId}"
		method="post">
		<div class="DIV_STYLE2">
			<table cellspacing=0 cellpadding=0 width=800px align=center border=0
				bgcolor="#FFFFFF">
				<tbody>
					<tr>
						<td valign=bottom align=center class="TABLE_STYLE6" rowspan=2>
							<table cellspacing=0 cellpadding=0 width=1000px border=0
								style="BORDER-RIGHT: #333333 1px solid; BORDER-TOP: #333333 1px solid; BORDER-LEFT: #333333 1px solid; BORDER-BOTTOM: #333333 1px solid;">
								<tbody>

									<tr>
										<td colspan="4" height="10"><table width="100%">
												<tr>
													<td>
														<table align=center class="TABLE_STYLE4">
															<tr height=20 class="TR_STYLE1">
																<td align=center height=5 class="TD_STYLE5"><font
																	size="4"><b>生产派工单</b></font></td>
															</tr>
														</table>
														<table align=center class="TABLE_STYLE4">
															<tr>
																<td bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">工单制定人：</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="40%"><input type="text" name="proName" /></td>
																<td bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">出库单编号：</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="40%"></td>
															</tr>
															<tr height=20 class="TR_STYLE1">
																<td bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">产品编号：</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="40%">${apply.productId}</td>
																<td bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">产品名称：</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="40%">${apply.productName}</td>
															</tr>
															<tr height=20 class="TR_STYLE1">
																<td bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">数量：</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="40%">${apply.amount}</td>
																<td bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">描述：${apply.productDescribe}</td>
															</tr>
														</table>
														<table align=center class="TABLE_STYLE4">
															<tr height=20 class="TR_STYLE1">
																<td align=center height=5 class="TD_STYLE5"></td>
															</tr>
														</table>
														<table bordercolor=#000000 bordercolorlight=#848284
															bordercolordark=#eeeeee border=1 cellspacing=0
															cellpadding=0 align=center class="TABLE_STYLE5"
															id=theObjTable>
															<tr height=20 bgcolor=#D2E9FF class="TR_STYLE2">
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="5%">序号</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="13%">工序名称</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="11%">工序编号</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="13%">描述</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="11%">工时数(小时)</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="13%">单位工时成本(元)</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="13%">工时成本小计(元)</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="8%">查看物料</td>
																<c:forEach items="${list}" var="str" varStatus="rows">
															</tr>
															<tr height=20 class="TR_STYLE1">
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.id }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.procedureName }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.procedureId }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.procedureDescribe }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.labourHourAmount }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.costPrice }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.subtotal }</td>

																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">
																	<a href="#" onclick="dispatchsee(${str.id },${apply.amount })">查看物料
																</a>
																</td>
															</tr>
															</c:forEach>
														</table>
														<table align=center class="TABLE_STYLE4">
															<tr height=20 class="TR_STYLE1">
																<td align=center height=5 class="TD_STYLE5"></td>
															</tr>
														</table>
														<TABLE align=center class="TABLE_STYLE4">
															<tr height=20 class="TR_STYLE1">
																<th bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">登记人：</th>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="40%"><input type="text" name="register" value="${apply.register}"/></td>
																<th bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">登记时间：</th>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="40%"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${apply.registerTime}"/></td>
															</tr>
															<tr height=20 class="TR_STYLE1">
																<td bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">备注：</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="89%" colspan="3"><textarea rows=4
																		class="TEXTAREA_STYLE1" name="remark"></textarea></td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
							</table>
							</div> <input type="submit" value="提交" />
							</form>
							<div id="dis_see"></div> <script type="text/javascript">
								function dispatchsee(id,amount) {
									$("#dis_see")
											.window(
													{
														title : "制定工序物料设计单",
														width : "100%",
														height : "100%",
														modal : true,
														minimizable : false,
														href : "dispatchController_see.do?id="
																+ id + "&amount="+amount
													});
								}
							</script>
</body>

</html>