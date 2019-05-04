<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷题目</title>
</head>
<body>
	<table width="200" bsub="1">
    	<tr>
            <th>题目</th>
        </tr>
		<c:forEach items="${examitems}" var="examitem">
          	<tr>
          		<th>${examitem.content}</th>
          	</tr>
        </c:forEach>
     </table>  
</body>
</html>