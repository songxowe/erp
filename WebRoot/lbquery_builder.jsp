<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="commons/meta.jsp"%>
<style>
.resizeDivClass {
	position: relative;
	background-color: #DEDBD6;
	width: 2;
	z-index: 1;
	left: expression(this.parentElement.offsetWidth-1);
	cursor: e-resize;
}
</style>

<script language="javascript">
	function MouseDownToResize(obj) {
		obj.mouseDownX = event.clientX;
		obj.pareneTdW = obj.parentElement.offsetWidth;
		obj.pareneTableW = theObjTable.offsetWidth;
		obj.setCapture();
	}
	function MouseMoveToResize(obj) {
		if (!obj.mouseDownX)
			return false;
		var newWidth = obj.pareneTdW * 1 + event.clientX * 1 - obj.mouseDownX;
		if (newWidth > 0) {
			obj.parentElement.style.width = newWidth;
			theObjTable.style.width = obj.pareneTableW * 1 + event.clientX * 1
					- obj.mouseDownX;
		}
	}
	function MouseUpToResize(obj) {
		obj.releaseCapture();
		obj.mouseDownX = 0;
	}
</script>


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
<script type="text/javascript">
	function check() {
		if (($("#beginTime").val() == null || $("#beginTime").val() == "")
				&& ($("#endTime").val() != null && $("#endTime").val() != "")
				|| ($("#beginTime").val() != null && $("#beginTime").val() != "")
				&& ($("#endTime").val() == null || $("#endTime").val() == "")) {
			alert("时间选择错误");
			return;
		} else if (($("#beginTime").val() != null || $("#beginTime").val() != "")
				&& ($("#endTime").val() != null || $("#endTime").val() != "")
				&& $("#beginTime").val() > $("#endTime").val()) {
			alert("开始时间不能大于结束时间");
			return;
		}else{
			$("#timeLocateValidation").submit();
		}
	}
</script>
</head>


<body bgcolor="#ebf3fb" oncontextmenu="event.returnValue=true"
	style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">
	<div align=center style="position:absolute;left:20px;right:20px;">
		<form id="timeLocateValidation" class="x-form" method="post"
			action="lbquery_list.jsp">
			<div class="x-box-tl">
				<div class="x-box-tr">
					<div class="x-box-tc"></div>
				</div>
			</div>
			<div class="x-box-ml">
				<div class="x-box-mr">
					<div class="x-box-mc">
						<div style="height:780px">
							<table class="TABLE_STYLE2">
								<tr height=20 class="TR_STYLE1">
									<td class="TD_HANDBOOK_STYLE1">您正在做的业务是：生产管理--内部生产管理--生产查询</td>
								</tr>
								<tr height=20 class="TR_STYLE1">
									<td class="TD_STYLE3">
										<div class="DIV_STYLE1">
											<input type="button" class="SUBMIT_STYLE1" value="查询"
												onclick="check()">
										</div>
									</td>
								</tr>
							</table>

							<table bordercolor=#000000 bordercolorlight=#000000
								bordercolordark=#000000 border=0 cellspacing=1 cellpadding=1
								bgcolor=#EEEEEE align=center class="TABLE_STYLE1" id=theObjTable>
								<tr height=20 class="TR_STYLE1">
									<td bgcolor=#D2E9FF bordercolorlight=#000000
										bordercolordark=#000000 align=left height=20 class="TD_STYLE1"
										width="20%">请输入派工单编号</td>
									<td valign=top bgcolor=#eeeeee bordercolor=#000000
										class="TD_STYLE2" width="80%"><input class="INPUT_STYLE1"
										id="manufactureId" name="manufactureId" type="text"
										style="width: 30%"></td>
								</tr>
								<tr height=20 class="TR_STYLE1">
									<td bgcolor=#D2E9FF bordercolorlight=#000000
										bordercolordark=#000000 align=left height=20 class="TD_STYLE1"
										width="20%">请输入关键字</td>
									<td valign=top bgcolor=#eeeeee bordercolor=#000000
										class="TD_STYLE2" width="80%"><input class="INPUT_STYLE1"
										id="keyword" name="keyword" type="text" style="width: 30%"></td>
								</tr>
								<tr height=20 class="TR_STYLE1">
									<td bgcolor=#D2E9FF bordercolorlight=#000000
										bordercolordark=#000000 align=left height=20 class="TD_STYLE1"
										width="20%">请选择派工单状态</td>
									<td valign=top bgcolor=#eeeeee bordercolor=#000000
										class="TD_STYLE2" width="80%"><select
										class="SELECT_STYLE1" id="status" name="status"
										style="width: 30%;">
											<option value="">&nbsp;</option>
											<option value="00">等待</option>
											<option value="01">执行</option>
											<option value="10">完成</option>
									</select></td>
								</tr>
								<tr height=20 class="TR_STYLE1">
									<td bgcolor=#D2E9FF bordercolorlight=#000000
										bordercolordark=#000000 align=left height=20 class="TD_STYLE1"
										width="20%">请输入派工单登记时间</td>
									<td valign=top bgcolor=#eeeeee bordercolor=#000000
										class="TD_STYLE2" width="80%"><input type="date"
										class="INPUT_STYLE1" name="beginTime" onfocus=""
										id="beginTime" style="width: 14%">至<input type="date"
										class="INPUT_STYLE1" name="endTime" onfocus="" id="endTime"
										style="width: 14%">（YYYY-MM-DD）</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="x-box-bl">
				<div class="x-box-br">
					<div class="x-box-bc"></div>
				</div>
			</div>
	</div>
	</form>
	</div>
</body>
</html>