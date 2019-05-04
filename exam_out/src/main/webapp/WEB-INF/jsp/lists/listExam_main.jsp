<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<div>
	<table width="200" bsub="1">
    	<tr>
            <th>试卷名</th>
        </tr>
		<c:forEach items="${exams}" var="exam">
          	<tr>
          		<th>
          			<a href="examitemsList?examid=${exam.id}">${exam.getName()}</a>
          		</th>
          	</tr>
        </c:forEach>
     </table> 
    <%@include file="../lists/pages_main.jsp"%> 
</div>