<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/editor/css/emojione.sprites.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/editor/css/emojionearea.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/editor/js/emojione.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/editor/js/emojionearea.min.js"></script>

<style>
body {
	margin-top: 70px;
	overflow-x: hidden;
	font-family: "楷体";
}

.body {
	-moz-box-shadow: 0px 0px 2px #333333;
	-webkit-box-shadow: 0px 0px 2px #333333;
	box-shadow: 0px 0px 2px #333333;
}

table[class="userinfo"] tr {
	height: 25px;
}

hr {
	margin-left: 10px;
	margin-right: 10px;
}

#modal-619842 {
	visibility: hidden;
}
#message-update {
	visibility: hidden;
}
#reply_message_base {
	visibility: hidden;
}
</style>
<script>

	function asclick() {
		$("#modal-619842").click();
	}

	$(document).ready(function() {
		$("#editor").emojioneArea({
			autoHideFilters : true
		});
	});

	function updateMessage() {
		$("#message-update").click();
	}
	
	function saveMessage() {
		if ($("#editor").val() == "") {
			alert("内容不能为空");
		} else {
			$('#form1').submit();
		}
	}
</script>
</head>

<body>
	<nav class="navbar navbar-fixed-top navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="javascript:void(0);">留言板</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a></a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li></li>
					<li><a href="${pageContext.request.contextPath}/page/main">首页</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a></a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li></li>
					<li><a href="${pageContext.request.contextPath}/page/me">个人档案</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a></a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li></li>
					<li><a href="javascript:void(0);" onclick="asclick()">发布留言</a>
					</li>
				</ul>

				<!-- 判断是否管理员 -->
				<c:if test="${user.power == 0}">
					<ul class="nav navbar-nav">
						<li><a></a></li>
					</ul>
					<ul class="nav navbar-nav">
						<li></li>
						<li><a href="${pageContext.request.contextPath}/page/manager">管理用户</a></li>
					</ul>
				</c:if>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/user/logout"> <font color="red">注销</font>
					</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/page/me">欢迎你，${user.nickName}</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="row clearfix">
		<div class="col-md-2 column">
			<a id="reply_message_base" href="#reply_to_message" role="button"
			class="btn" data-toggle="modal"></a>
		</div>
		<div id="base_content" class="col-md-8 column body">
			<jsp:include page="${page}"></jsp:include>
		</div>
		<div class="col-md-2 column">
			<a id="modal-619842" href="#modal-container-619842" role="button"
				class="btn" data-toggle="modal">13</a>
		</div>
	</div>

	<!--弹窗-->
	<div class="modal fade" id="modal-container-619842" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">发布留言</h4>
				</div>
				<div class="modal-body">
					<form id="form1" action="${pageContext.request.contextPath}/message/add"
						method="post">
						<textarea id="editor" name="content"></textarea>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" onclick="saveMessage()" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!--留言修改-->
	<div class="modal fade" id="reply_to_message" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">留言回复</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="${pageContext.request.contextPath}/reply/add" method="post" id="reply_form">
						<div class="form-group">
							<div class="col-sm-12">
								<input type="hidden" id="reply_messageId" name="messageId" />
								<input class="form-control" id="reply_input" name="content" />
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" onclick="javascript:void(0);">关闭</button>
					<button type="button" onclick="save_reply()"
						class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>