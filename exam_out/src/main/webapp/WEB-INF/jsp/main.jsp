<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户界面</title>
</head>
<body>
	${USER_SESSION.name}  
	<a href="touser">查看已创建试卷</a>
	<a href="logout">退出</a><br/>
	<a href="catelist?subid=${USER_SESSION.subid}">选择科目出题</a>
	
</body>
</html>