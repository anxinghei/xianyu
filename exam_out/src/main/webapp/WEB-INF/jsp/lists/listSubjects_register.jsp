<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="static/js/jquery.min.js"></script>	
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 	
<script src="static/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
    
<div>
	<table width="150" bsub="1" class="table table-hover">
    	<tr>
        	<th>ID</th>
            <th>学院名</th>
        </tr>
		<c:forEach items="${subs}" var="sub">
          	<tr>
          		<th>${sub.getId()}</th>
          		<th>${sub.getName()}</th>
          	</tr>
        </c:forEach>
     </table> 
    <%@include file="../lists/pages_register.jsp"%> 
</div>

</body>
</html>