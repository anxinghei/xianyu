<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷题目</title>
<script type="text/javascript" src="static/js/jquery.min.js"></script>	
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 	
<script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<br/><br/>
<a href="home">返回</a><br/><br/>
	<table width="1500" class="table table-hover">
    	<tr>
    		<th>题号</th>
            <th>题目</th>
        </tr>
		<c:forEach items="${examitems}" var="examitem" varStatus="i">
          	<tr>
          		<th>${i.index+1}</th>
          		<th>${examitem.content}</th>
          	</tr>
        </c:forEach>
     </table>  
</body>
</html>