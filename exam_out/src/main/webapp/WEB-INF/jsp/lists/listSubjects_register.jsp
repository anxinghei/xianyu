<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<div>
	<table width="150" bsub="1">
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