$(function() {
	// 见 easy-ui API
	// 树控件读取URL。子节点的加载依赖于父节点的状态。
	// 当展开一个封闭的节点，如果节点没有加载子节点，
	// 它将会把节点id的值作为http请求参数并命名为'id'，
	// 通过URL发送到服务器上面检索子节点
	// menuAction_index.action?id=1
	$("#tree").tree( {
		url : "menuController_index.do",
		lines : true,
		animate : true,
		onClick : function(node) {
			var flag = $("#divtabs").tabs("exists", node.text);
			if (!flag) {//选项卡面板不存在
				var content = '<iframe scrolling="no" frameborder="0"'+
		           'src="'+node.url+'" style="width:100%;height:100%;"></iframe>';
				$("#divtabs").tabs("add", {
					title : node.text,
					closable : true,
					content : content
				});
			}else{
				$('#divtabs').tabs('close',node.text);
				var content = '<iframe scrolling="no" frameborder="0"'+
		           'src="'+node.url+'" style="width:100%;height:100%;"></iframe>';
				$("#divtabs").tabs("add", {
					title : node.text,
					closable : true,
					content : content
				});
				/*var content = '<iframe scrolling="no" frameborder="0"'+
		           'src="'+node.url+'" style="width:100%;height:100%;"></iframe>';
				$("#divtabs").tabs("add", {
					title : node.text,
					closable : true,
					content : content
				});*/
			}
		}
	});
});