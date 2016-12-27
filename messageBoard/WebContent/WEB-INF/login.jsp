<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>管理员登录</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Affiliate Flat Login Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Poiret+One' rel='stylesheet' type='text/css'>
</head>
<body>
	<!-- main -->
		<div class="main">
			<h1>用户登录</h1>
			<form action="${pageContext.request.contextPath}/admin/login" method="post">
				<input type="text" name="username" placeholder="账号" onfocus="this.placeholder = '';" onblur="if (this.placeholder == '') {this.placeholder = '账号';}">
				<input type="password" name="password" placeholder="密码" onfocus="this.placeholder = '';" onblur="if (this.placeholder == '') {this.placeholder = '密码';}">
				<input type="submit" value="登录">&nbsp;<input type="button" value="注册">
			</form>
			<br>
			${erro}
		</div>
		<div class="footer">
			<p>留言板登录</p>
		</div>
	<!-- //main -->
</body>
</html>