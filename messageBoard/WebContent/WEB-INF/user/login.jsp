<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<style>
body {
	/*background: url(img/stock-photo-189877643.jpg);*/
	background: #1B6D85;
}

.body {
	margin: 0 auto;
	/*text-align: center;*/
	width: 300px;
	height: 300px;
	border: 1px solid gainsboro;
	margin-top: 200px;
	-moz-box-shadow: 2px 2px 5px #333333;
	-webkit-box-shadow: 2px 2px 5px #333333;
	box-shadow: 2px 2px 5px #333333;
}

.body form {
	margin: 10px;
	margin-top: 40px;
}

.body div {
	margin: 15px;
}

img {
	margin-left: 20px;
}

.form-control-xxx {
	width: 120px;
	display: inline;
}

#submit {
	margin-left: 35px;
	margin-right: 90px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
	<div class="body">
		<form role="form" class="bs-example bs-example-form">
			<div>
				<input class="form-control" placeholder="用户名" />
			</div>
			<div>
				<input type="password" name="" class="form-control" placeholder="密   码" />
			</div>
			<div class="from-group">
				<input type="password"
					class="form-control input-sm form-control-xxx" placeholder="验证码" />
				<img src="img/12822929018610.jpg" width="90px" height="35px" />
			</div>
			<div class="checkbox">
				<label><input type="checkbox" />自动登录</label>
			</div>
			<button id="submit" type="submit" class="btn btn-success">登录</button>
			<button class="btn btn-info">注册</button>
		</form>
	</div>
</body>

</html>