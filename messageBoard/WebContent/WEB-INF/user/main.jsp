<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
/* body {
	margin-top: 70px;
}  */
</style>
<script>
	
	$(document).ready(function() {
		/* $("#editor").emojioneArea({
			autoHideFilters : true
		}); */
		query_messages(1);
	});
	function query_messages(currentPage) {
		src = "${pageContext.request.contextPath}/message/query";
		$.ajax({
			url:src,
			type:"POST",
			data:"&currentPage="+currentPage,
			success:function(data){
				data = eval("("+data+")");
				list = data.lists;
				page = data.page;
				var content="";
				$("#accordion").empty();
				$("#page_main").empty();
				$.each(list, function(i, item) {
					/* alert(page.pageSize); */
					content += "<div class='message-div'>"+
					"<ul class='list-group' style='border: 0px;'>"+
					"<li class='list-group-item' style='border: 0px;'>"+
						"<div>"+
							"<img src='${pageContext.request.contextPath}/images/"+item.head+"' class='reply_img' />"+
							"<div>"+
								"<span class='reply_content'> <font color='blue'>"+item.nickname+"</font>"+
									"&nbsp;"+item.content+""+
								"</span>"+
								"<br /> "+
								"<span class='time'>"+item.time+"</span>"+
								"&nbsp;<span>"+
									"<font size='1' color='#0066CC'>"+(item.floor)+"楼</font>"+
								"</span>"+
								"<a data-toggle='collapse' data-parent='#accordion' href='#collapse"+i+"'>"+
									"<button type='button' class='btn btn-xs btn-link' data-toggle='tooltip' title='点击显示回复'>查看回复</button>"+
								"</a>"+
							"</div>"+
						"</div>"+
					"</li>"+
				"</ul>"+

				"<div class='btn-group' style='float: right; margin-top: -67px; margin-right: 30px;'>"+
					"<button class='btn btn-default btn-xs'>操作</button>"+
					"<button data-toggle='dropdown' class='btn btn-default dropdown-toggle btn-xs'>"+
						"<span class='caret'></span>"+
					"</button>"+
					"<ul class='dropdown-menu'>"+
						"<li>"+
							"<a href='javascript:reply_message_main("+item.messageId+", \""+item.content+"\");'>回复</a>"+
						"</li>";
						;
							
					if (item.userId == "${user.userId}") {
						content += ""+
						"<li>"+
							"<a href='javascript:update_message_main("+item.messageId+", \""+item.content+"\");'>修改</a>"+
						"</li>"+
						"<li>"+
							"<a href='javascript:del_message_main("+item.messageId+");'>删除</a>"+
						"</li>";
					} else {
						content += ""+
						"<li class='disabled'>"+
							"<a href='javascript:void(0);'>修改</a>"+
						"</li>"+
						"<li class='disabled'>"+
							"<a href='javascript:void(0);'>删除</a>"+
						"</li>";
					}
					
					content += ""+
							"</ul>"+
						"</div>"+
					"</div>"+
		
					"<div id='collapse"+i+"' class='panel-collapse collapse reply-all'>"+
						"<div class='panel-body'>"+
							"<ul id='reply_id"+i+"' class='list-group reply_list'>"+
								
							"</ul>"+
						"</div>"+
					"</div>";
					
					
					$("#accordion").append(content);
					content=""
					
					query_reply_message(item.messageId, i);
				});
				
				var string = "";
				for(var i=1; i<=page.pageCount; i++){
					if (i==1) {
						if (currentPage == 1) {
							string += "<li class='disabled'><a>上一页</a></li>";
						} else {
							string += "<li><a href='javascript:query_messages("+(currentPage-1)+")'>上一页</a></li>";
						}
					} 
					
					if (i == currentPage) {
						string += "<li class='active'><a>"+i+"</a></li>";
					} else {
						string += "<li><a href='javascript:query_messages("+i+")'>"+i+"</a></li>";
					}
					
					
					if (i == page.pageCount) {
						if (currentPage == page.pageCount) {
							string += "<li class='disabled'><a>下一页</a></li>";
						} else {
							string += "<li><a href='javascript:query_messages("+(currentPage+1)+")'>下一页</a></li>";
						}
					} 
					
				}
				
				$("#page_main").append(string);
			}
		});
	}
	
	function query_reply_message(messageId, i) {
		src = "${pageContext.request.contextPath}/reply/query";
		$.ajax({
			url : src,
			type : "POST",
			async : "false",
			data : "&messageId=" + messageId,
			success : function(data) {
				/* alert(data); */
				data = eval("(" + data + ")");
				list = data.lists;
				sc = "#reply_id" + i;
				$(sc).empty();
				$.each(list,function(i, item) {
					$(sc).append(
							"<li class='list-group-item ' style='border: 0px;'>"+
							"<div>"+
								"<img src='${pageContext.request.contextPath}/images/"+item.head+"' class='reply_img' />"+
								"<div>"+
									"<span class='reply_content'> <font color='blue'>"+item.nickname+"</font>"+
										"&nbsp;"+item.content+""+
									"</span> <br />"+
									"<span class='time'>"+item.time+"</span>"+
								"</div>"+
							"</div>"+
						"</li>"
					);
				});
			}
		});
	}
	
	function del_message_main(messageId) {
		var flag = confirm("确定删除吗？");
		if (!flag) {
			return;
		}
		src = "${pageContext.request.contextPath}/message/delete";
		$.ajax({
			url:src,
			type:"POST",
			data:"&messageId="+messageId,
			success:function(data){
				data = eval("("+data+")");
				if (data.status == "success") {
					alert("删除成功");
					location.reload();
				} else {
					alert("删除失败");
				}
			}
		});
	}
	
	function reply_message_main(messageId, content) {
		$("#reply_messageId").val(messageId);
		$("#reply_input").val(content);
		$("#reply_message_base").click();
	}
	
	function update_message_main(messageId, content) {
		$("#message-update").click();
		$("#hidden_message_main_id").val(messageId);
		$("#message_content_main").val(content);
	}
	
	function save_message_main() {
		if ($("#message_content_main").val() == "") {
			alert("内容不能为空");
		} else {
			$('#form_main').submit();
		}
	}
	
	function save_reply() {
		if ($("#reply_input").val() == "") {
			alert("内容不能为空");
		} else {
			$('#reply_form').submit();
		}
	}
	
	function close_modal() {
		$("body").scrollTop(0);
		$("html").scrollTop(0);
		/* $("#base_content").css('position', 'relative');
		$("#base_content").css('top', '100px'); */
		/* $("body").css('overflow', 'hidden'); */
	}
	
	$(document).ready(function() {
		$("#message_content_main").emojioneArea({
			autoHideFilters : true
		});
		$("#reply_input").emojioneArea({
			autoHideFilters : true
		});
	});
</script>
<!--留言修改-->
	<a id="message-update" href="#message-update-div" role="button"
		class="btn" data-toggle="modal"></a>
	<div class="modal fade" id="message-update-div" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">留言修改</h4>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath}/message/update" method="post" id="form_main">
						<input id="hidden_message_main_id" type="hidden" name="messageId">
						<input type="hidden" name="type" value="main">
						<input id="message_content_main" class="form-control" id="message_main_update_input" name="content" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" onclick="javascript:void(0);">关闭</button>
					<button type="button" onclick="save_message_main()"
						class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div class="panel panel-info pane-main well">
		<div class="panel-heading">
			<h3 class="panel-title">留言(${total_message})</h3>
		</div>

		<div class="panel-body accordion-group" id="accordion">

		</div>




		<div class="panel-footer" style="height: 20px;">
			<center>
				<ul id="page_main" class="pagination pagination-sm page-main">
				</ul>
			</center>
		</div>
	</div>