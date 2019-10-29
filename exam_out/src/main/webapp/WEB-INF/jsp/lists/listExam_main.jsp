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

<title>试卷</title>
</head>
<body>
<div>
	<table width="200" bsub="1" class="table table-striped">
    	<tr>
            <th>id</th>
            <th>试卷名</th>
            <th>操作</th>
        </tr>
		<c:forEach items="${exams}" var="exam" varStatus="i">
          	<tr>
          		<th>
          			<div style="width:50px">${i.index+1}</div>
          		</th>
          		<th>
          			<a href="examitemsList?examid=${exam.id}" >${exam.getName()}</a>
          		</th>
          		<th>
          			<button type="button" class="btn btn-primary wb100" onclick="exportWord(${exam.id})">导出</button>
          		</th>       		
          	</tr>
        </c:forEach>
     </table> 
    <%@include file="../lists/pages_main.jsp"%> 
</div>

<script type="text/javascript" async="true">
    function exportWord(id){
		var page = "exportWord/"+id;
		window.open(page,"parent");
    }  
</script>

</body>
</html>