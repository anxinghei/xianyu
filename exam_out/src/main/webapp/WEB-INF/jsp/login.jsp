<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<br/>
	${msg}
	<form action="login" method="post">
		<table>
			<tr>
            	<td>用户名</td>
            	<td><input name="name" type="text"></td>
        	</tr>
			<tr>
            	<td>密码</td>
            	<td><input name="password" type="password"></td>
        	</tr>
 			<tr class="submitTR">
            	<td colspan="2" align="center">
               		<button type="submit">登录</button>
            	</td>
         	</tr>
         </table>
		<br/><br/>
		<a href="toregister">免费注册</a>
	</form>
</body>
</html>