<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="static/js/jquery.min.js"></script>	
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 	
<script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div id="preloader">
	<div id="divstatus">
		&nbsp;
	</div>
</div>
<div class="container">
	<div class="" id="login-wrapper">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div id="logo-login">
					<h1>
					<span>出卷系统</span>
					<h3 style="color: red">${msg}</h3>
					</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="account-box">
					<form role="form" action="login"  method="post" id="loginForm">
						<div class="form-group">
							<label for="inputUsernameEmail">账号</label>
							<input type="text" placeholder="请输入账号"  name="name" id="name"  class="form-control">
						</div>
						<div class="form-group">
							<label for="inputPassword">密码</label>
							<input type="password" placeholder="请输入密码" name="password" id="password"  class="form-control">
						</div>
						<button class="btn btn-primary btn-block" type="submit">登录</button>
					</form><br/>
					<a href="toregister">免费注册</a>
				</div>
			</div>
		</div>
	</div>
</div>	
</body>
</html>