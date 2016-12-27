<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
</head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">
.form-group {
	background-color: #E2E2E2;
	box-shadow: 3px 3px 8px #ADADAD;
	margin-top: 140px;
	margin-left: 550px;
	font-family: "";
}

div img {
	width: 100px;
	height: 100px;
	border-radius: 100px;
}
</style>

<body>
	<!--<div class="col-xs-6 col-sm-5"></div>-->

	<div class="form-group" style="width: 250px;">
		<div class="to">
			<center>
				<img src="${pageContext.request.contextPath}/images/img4.bmp" />
			</center>
		</div>
		<form action="${pageContext.request.contextPath}/user/login" method="post">
			<label for="exampleInputEmail1">账户：</label>
			<input class="form-control" placeholder="username" name="username">
			<label for="exampleInputPassword1">密码：</label> 
			<input type="password" class="form-control"  placeholder="Password" name="password"> 
			<label for="exampleInputFile">
				验证码：<img src="${pageContext.request.contextPath}/images/QQ.jpg"
				alt="Responsive image" class="img-rounded" style="width: 70px; height: 30px;">
			</label> 
			<br />
			<button type="submit" class="btn btn-info" style="width: 160px;">登录</button>
			<button type="button" class="btn btn-primary" style="width: 70px;">注册</button>
		</form>
	</div>
	</div>

</body>

</html>