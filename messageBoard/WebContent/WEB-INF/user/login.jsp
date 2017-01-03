<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<style>
body {
	/*background: url(img/stock-photo-189877643.jpg);*/
	background: ghostwhite;
	overflow: hidden;
}

.body {
	margin: 0 auto;
	/*text-align: center;*/
	width: 380px;
	height: 320px;
	border: 1px solid gainsboro;
	margin-top: 200px;
	-moz-box-shadow: 2px 2px 5px #333333;
	-webkit-box-shadow: 2px 2px 5px #333333;
	box-shadow: 2px 2px 5px #333333;
}

.body form {
	/*margin: 30px;
				margin-top: 40px;*/
	
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

.user {
	width: 250px;
	display: inline;
}

.psw {
	width: 250px;
	display: inline;
}

.login {
	width: 380px;
	height: 360px;
}

.pane-login {
	margin-left: 60px;
	margin-top: -10px;
}

.pane-register {
	margin-left: 15px;
	margin-top: -10px;
}

button[type="submit"] {
	width: 160px;
	margin-top: 10px;
	display: inline;
	margin-left: 60px;
	margin-right: 90px;
}

button[type="button"] {
	width: 160px;
	margin-top: 10px;
	display: inline;
	margin-left: 40px;
	margin-right: 90px;
}
</style>

<script type="text/javascript">
	
	$(document).ready(function(){
	  if ("${erro}" !="") {
		$(":button").css("margin-left","60px");
	  }
	});

	function changeImg() {
		var imgSrc = $("#imgCode");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}
	
	//时间戳     
	//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     
	function chgUrl(url){     
	    var timestamp = (new Date()).valueOf();     
	    if((url.indexOf("&")>=0)){     
	        urlurl = url + "×tamp=" + timestamp;     
	    }else{     
	        urlurl = url + "?timestamp=" + timestamp;     
	    }
	    return urlurl;     
	}
	
	function check(form) {

       if(form.userName.value=='') {
              alert("请输入用户帐号!");
              form.userName.focus();
              return false;
         }
	     if(form.password.value==''){
              alert("请输入登录密码!");
              form.password.focus();
              return false;
	     }
		
	     isRightCode(form);
	    /*  formsubmit(); */
	}
	
	function formsubmit() {
		document.getElementById("loginform").submit();
		return true;
	}
	
	function isRightCode(form){  
	    var code = $("#codeInput").val();     
	    code = "c=" + code;
	    $.ajax({
	        type:"POST",     
	        url:"${pageContext.request.contextPath}/result/validateCode",     
	        data:code,   
	        success:function callback(data){
	        	/* alert(data) */
	        	if (data != "") {
		        	$("#info").html(data); 
				} else {
					$("#info").html("");
					formsubmit();
					/* $("#loginform").action="${pageContext.request.contextPath}/user/login";
					alert($("#loginform").submit()); */
				}
	        }
	    });
	}
	
	/* 验证密码 */
	function checkPsw(form) {
		if (form.password.value != form.repeat.value) {
			alert("两次密码不一致");
			return false;
		}
		return true;
	}
</script>

</head>

<body>

	<div class="body">

		<div class="tabbable" id="tabs-603080">
			<ul class="nav nav-tabs">
				<li class="active pane-login"><a href="#panel-667979"
					data-toggle="tab">
						<h4>用户登录</h4>
				</a></li>
				<li class="pane-register"><a href="#panel-516375"
					data-toggle="tab">
						<h4>用户注册</h4>
				</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active login" id="panel-667979">
					<form id="loginform" action="${pageContext.request.contextPath}/user/login"
						method="post" >
						<div>
							<input class="form-control user" name="userName"
								placeholder="用户名" required />
						</div>
						<div>
							<input type="password" name="password" class="form-control psw"
								placeholder="密   码" required />
						</div>
						<div class="from-group">
							<input id="codeInput" onblur="isRightCode()"
								class="form-control input-sm form-control-xxx" placeholder="验证码"/>
								<img id="imgCode"
								src="${pageContext.request.contextPath}/verifyCode" 
								height="35px" onclick="changeImg()" />
							<font color="red" size="2">
								<span id="info"></span>
							</font>
						</div>
						<span>
							<font color="red" style="margin-left: 20px;">${erro}</font>
						</span>
						<button type="button" onclick="check(this.form)" class="btn btn-primary">登录</button>
					</form>
				</div>
				<div class="tab-pane" id="panel-516375">
					<form action="${pageContext.request.contextPath}/user/register" method="post" class="bs-example bs-example-form" onsubmit="return checkPsw(this)">
						<div>
							<input class="form-control user" name="userName" placeholder="用户名" required />
						</div>
						<div>
							<input type="password" class="form-control psw"
								name="password" placeholder="密   码" required />
						</div>
						<div class="from-group">
							<input type="password" class="form-control psw"
								name="repeat" placeholder="确认密码" required />
						</div>
						<button type="submit" class="btn btn-info">注册</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>