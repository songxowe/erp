<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>菜单管理</title>
<%@ include file="../commons/meta.jsp"%>
<head>
</STYLE>
</head>
<body bgcolor="#ebf3fb" oncontextmenu="event.returnValue=true"
	style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">
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
																<th align=center height=5 class="TD_STYLE5"><font
																	size="4"><b>生产派工单</b></font></th>
															</tr>
														</table>
														<table align=center class="TABLE_STYLE4">
															<tr height=20 class="TR_STYLE1">
																<th bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">设计单编号：</th>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="40%">${ms.designId}</td>
																<th bordercolorlight=#848284 bordercolordark=#eeeeee
																	align=right class="TD_STYLE8" width="10%">工序名称：</th>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="40%">${ms.procedureName}</td>
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
																	width="13%">物料名称</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="11%">物料编号</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="13%">描述</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="11%">本工序数量</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="13%">单位</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="13%">单价(元)</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																	width="13%">小计(元)</td>
																<c:forEach items="${list}" var="str" varStatus="rows">
															</tr>
															<tr height=20 class="TR_STYLE1">
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.id }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.productName }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.productId }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.productDescribe }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.amount }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.costPrice }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.subtotal }</td>
																<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.subtotal }</td>
															</tr>
															</c:forEach>
														</table>
														<table align=center class="TABLE_STYLE4">
															<tr height=20 class="TR_STYLE1">
																<td align=center height=5 class="TD_STYLE5"></td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
							</table>
							</div>
</body>
</html>