<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目选择</title>
<script type="text/javascript" src="static/js/jquery.min.js"></script>	
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 	
<script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<br/><br/>
	<a href="home">返回</a>
	<br/><br/>
	 <table width="150" bsub="1" class="table table-bordered">
    	<tr>
        	<th>ID</th>
            <th>科目名</th>
        </tr>
		<c:forEach items="${cates}" var="cate">
          	<tr>
          		<th>${cate.getId()}</th>
          		<th><a href="queslist?catid=${cate.getId()}">${cate.getName()}</a></th>
          	</tr>
        </c:forEach>
     </table>  
</body>
</html>