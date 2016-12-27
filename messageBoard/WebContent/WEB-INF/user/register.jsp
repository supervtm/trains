<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" ></script>
	<style>
	.body{
		background: #269ABC;
	}
	.form-group{
		width: 300px;
		
		margin-left: 500px;		
	}	
	.family{
		font-family: "微软雅黑";
		font-size: 15px;
		
	}
		
	</style>
	<body class="body">
		<form role="form">
  <div class="form-group">
    <label for="exampleInputEmail1">昵称</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
   <div class="form-group">
    <label for="exampleInputPassword1">确认密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  
  <div class="family"> 
  	        <label>性别：</label>
            <input type="radio" name="radio-btn" />男
        
            <input type="radio" name="radio-btn" />女
  </div>
  <div><label class="family">所在地:</label><select class="form-control input-sm">
  	<option>浙江</option>
      <option>江苏</option>
       <option>北京</option>
     <option>上海</option></select>
  </div>
  <button type="button" class="btn btn-primary btn-lg btn-block">立即注册</button>
  </div>
</form>
	</body>
</html>
