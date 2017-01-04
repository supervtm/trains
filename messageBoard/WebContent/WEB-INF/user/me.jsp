<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body {
	margin-top: 70px;
	overflow: hidden;
} 

#delbtn {
	visibility: visible;
}
</style>
<script>
	$(document).ready(function() {
		query();
	});

	$(document).ready(function() {
		$("#message_content").emojioneArea({
			autoHideFilters : true
		});
	});

	function query() {
		src = "${pageContext.request.contextPath}/message/user";
		$
				.ajax({
					url : src,
					type : "POST",
					async : "false",
					success : function(data) {
						data = eval("(" + data + ")");
						list = data.lists;
						$("#mymessage").empty();
						$
								.each(
										list,
										function(i, item) {
											$("#mymessage")
													.append(
															"<li class='list-group-item message-list'>"
																	+ "<span class='m_content'>"
																	+ item.content
																	+ "</span>"
																	+ "<br />"
																	+ "<span class='time' onMouseOver='vis()' onmouseout='hid()'>"
																	+ ""
																	+ item.time
																	+ ""
																	+ "<a id='delbtn' href='javascript:updateMessage_me("
																	+ item.messageId
																	+ ",\""
																	+ item.content
																	+ "\");'>"
																	+ "&nbsp;<font color='#0C73CF'>修改</font>"
																	+ "</a> "
																	+ "<a id='delbtn' href='javascript:del_me("
																	+ item.messageId
																	+ ");'>"
																	+ "<font color='red'>删除</font>"
																	+ "</a>"
																	+ "</span>"
																	+ "<hr />"
																	+ "<ul id='reply_of_my_message"+i+"' class='list-group reply_list'></ul>"
																	+ "</li>");
											/* alert(item.messageId); */
											queryReply(item.messageId, i);
										});
					}
				});
	}

	function queryReply(messageId, i) {
		src = "${pageContext.request.contextPath}/reply/query";
		$
				.ajax({
					url : src,
					type : "POST",
					async : "false",
					data : "&messageId=" + messageId,
					success : function(data) {
						/* alert(data); */
						data = eval("(" + data + ")");
						list = data.lists;
						sc = "#reply_of_my_message" + i;
						$(sc).empty();
						$
								.each(
										list,
										function(i, item) {
											$(sc)
													.append(
															"<li class='list-group-item ' style='border: 0px;'>"
																	+ "<div>"
																	+ "<img src='${pageContext.request.contextPath}/images/"+item.head+"' class='reply_img' />"
																	+ "<div>"
																	+ "<span class='reply_content'> <font color='blue'>"
																	+ item.nickname
																	+ "</font>"
																	+ "&nbsp;"
																	+ item.content
																	+ ""
																	+ "</span> <br /> <span class='time'>"
																	+ item.time
																	+ "</span>"
																	+ "</div>"
																	+ "</div>"
																	+ "</li>");
										});
					}
				});
	}

	function updateMessage_me(messageId, content) {
		$("#message-update").click();
		$("#hidden_message_id").val(messageId);
		$("#message_content").val(content);
	}
	function saveMessage_me() {
		/* alert($("#message_content").val()); */
		if ($("#message_content").val() != "") {
			$("#form_message_me").submit();
		} else {
			alert("内容不能为空");
		}
	}
	function del_me(messageId) {
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
					query();
				} else {
					alert("删除失败");
				}
			}
		});
	}

	function close_modal() {
		$("body").css('margin-top', '70px');
		$("body").css('overflow', 'hidden');
	}
	
	function update_me() {
		if ($("#update_nickname").val() == "") {
			alert("昵称不能为空");
		} else {
			$("#update_me_form").submit();
		}
		
		
	}
	/* function vis(obj) {
		$(this).children('#delbtn').css('visibility', 'visible');
	}
	function hid(obj) {
		$(this).children('#delbtn').css('visibility', 'hidden');
	} */
</script>
</head>

<div class="row">
	<h3 class="text-center">
		<font color="#28A4C9">我的个人档案</font>
	</h3>
	<hr />
	<div class="col-md-2"></div>
	<div class="col-md-2">
		<img src="${pageContext.request.contextPath}/images/${user.head}"
			class="img-thumbnail" />
	</div>
	<div class="col-md-5">
		<table class="userinfo" style="width: 240px; text-align: left;">
			<tr>
				<td>用户名：</td>
				<td>${user.userName}</td>
			</tr>
			<tr>
				<td>昵称：</td>
				<td>${user.nickName}</td>
			</tr>
			<tr>
				<td>注册时间：</td>
				<td>${user.createTime}</td>
			</tr>
			<tr>
				<td>角色：</td>
				<td><c:if test="${user.power == 0}">
				管理员
				</c:if> <c:if test="${user.power == 1}">
				普通用户
				</c:if></td>
			</tr>
			<tr>
				<td>个人统计：</td>
				<td>${message_user}条留言</td>
			</tr>
		</table>
	</div>
	<div class="col-md-3 column">
		<a id="modal-689809" href="#modal-container-689809" role="button"
			class="btn" data-toggle="modal">修改</a>
		<div class="modal fade" id="modal-container-689809" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">用户信息修改</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="update_me_form" enctype="multipart/form-data"
							method="post" action="${pageContext.request.contextPath}/user/update">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">头像</label>
								<div class="col-sm-10">
									<input type="hidden" value="${user.head}" name="head" />
									<input type="file" class="form-control" id="inputEmail3" name="imageFile" />
								</div>
							</div>
							<div class="form-group">
								<label for="update_nickname" class="col-sm-2 control-label">昵称</label>
								<div class="col-sm-10">
									<input class="form-control" id="update_nickname" value="${user.nickName}" name="nickName"/>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" onclick="update_me()" class="btn btn-primary">保存</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br />
<br />
<div class="row">
	<div class="col-md-2 column"></div>
	<div class="col-md-8 column">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<font color="#4EB0E5">我的留言(${message_user})</font>
			</div>
			<!-- List group -->
			<ul id="mymessage" class="list-group scrollbar">

			</ul>
		</div>
	</div>
	<div class="col-md-2 column"></div>
</div>

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
				<form id="form_message_me" class="form-horizontal"
					action="${pageContext.request.contextPath}/message/update"
					method="post">
					<div class="form-group">
						<!-- <label for="message_content" class="col-sm-2 control-label">内容</label> -->
						<div class="col-sm-12">
							<input type="hidden" name="messageId" id="hidden_message_id" />
							<input id="message_content" name="content"/>
							<!-- <input class="form-control" name="content" id="message_content" /> -->
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" onclick="close_modal()">关闭</button>
				<button type="button" onclick="saveMessage_me()"
					class="btn btn-primary">保存</button>
			</div>
		</div>
	</div>
</div>