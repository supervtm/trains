<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主界面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<style>
body {
	margin-top: 70px;
}

.body {
	-moz-box-shadow: 0px 0px 2px #333333;
	-webkit-box-shadow: 0px 0px 2px #333333;
	box-shadow: 0px 0px 2px #333333;
}

table {
	text-align: center;
}

table th {
	text-align: center;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
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
					<li><a href="#">首页</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a></a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li></li>
					<li><a href="#">个人档案</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a></a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li></li>
					<li><a href="#">我的留言</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a></a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li></li>
					<li><a href="#">发布留言</a></li>
				</ul>
				<!--<ul class="nav navbar-nav"><li><a></a></li></ul>
					<ul class="nav navbar-nav">
						<li></li>
						<li>
							<a href="#">密码重置</a>
						</li>
					</ul>-->
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
					<li><a href=""><font color="red">注销</font></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">欢迎您,${user.nickName}</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="row clearfix">
		<div class="col-md-2 column"></div>
		<div class="col-md-8 column body">
			<jsp:include page="${page}"></jsp:include>
		</div>
		<div class="col-md-2 column"></div>
	</div>
</body>

</html>