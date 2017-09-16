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
.style8 {
	color: #000066
}
.TD_HANDBOOK_STYLE1 {
	vertical-align: top;
	width: 100%;
	color: #0000FF;
}
.TD_STYLE2 {
	border-spacing: 1px;
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
	<table class="TABLE_STYLE2" width="100%">
		<tr height=20 class="TR_STYLE1">
			<td class="TD_HANDBOOK_STYLE1">您正在做的业务是：生产管理--内部生产管理--生产登记复核（<a
				href="javascript:winopens('../../main/responsiblePerson.htm')">
					责任人控制</a>）
			</td>
		</tr>
	</table>
	<table class="TABLE_STYLE2" width="100%">
		<tr height=20 class="TR_STYLE1">
			<td class="TD_STYLE3">当前等待复核登记的生产派工单总数：<div style="display:inline"><c:if test="${BNUM==null}">0</c:if>${BNUM}<c:remove var="BNUM"/></div>例</td>
		</tr>
	</table>
<body>
	<div style="margin-top: 20px;">
			<table id="workorderDataGrid">		
			</table>
		</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#workorderDataGrid").datagrid({
			url:"lbManufactureController_review.do",
			fitColumns : true,
			striped : true,
			columns:[[
			{
				field:"manufactureId",
				title:"生产派工单编号",
				width:"220"
			},{
				field:"productId",
				title:"产品编号",
				width:"150"
			},{
				field:"productName",
				title:"产品名称",
				width:"150"
			},{
				field:"amount",
				title:"数量",
				width:"60"
			},{
				field:"applyIdGroup",
				title:"出库单号集合",
				width:"160"
			},{
				field:"registerTime",
				title:"登记时间",
				width:"180",
				formatter: function (value, row, index) {
                                var date = new Date(value);
                                var year = date.getFullYear().toString();
                                var month = (date.getMonth() + 1);
                                var day = date.getDate().toString();
                                var hour = date.getHours().toString();
                                var minutes = date.getMinutes().toString();
                                var seconds = date.getSeconds().toString();
                                if (month < 10) {
                                    month = "0" + month;
                                }
                                if (day < 10) {
                                    day = "0" + day;
                                }
                                if (hour < 10) {
                                    hour = "0" + hour;
                                }
                                if (minutes < 10) {
                                    minutes = "0" + minutes;
                                }
                                if (seconds < 10) {
                                    seconds = "0" + seconds;
                                }
                                return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
                            }
				
			},{
				field:"checkTag",
				title:"复核",
				width:"50",
				formatter:function(value,row,index){
					var temp=row["manufactureId"];
					url="lbManufactureController_checkreview.do?manufactureId="+temp;
						return "<a href="+url+">复核</a>";
				}
			}
			]],
			pagination:"true",
			pageSize:5,
			pageList:[2,5,10,15],
			sortName:"MANUFACTURE_ID",
			sortOrder:"asc"
		});
	});
</script>
</html>