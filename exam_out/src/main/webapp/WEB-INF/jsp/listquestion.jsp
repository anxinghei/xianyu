<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.over 
{
width:100px;
height:20px;
overflow: hidden
}
.all 
{
width:150px;
}
</style>
<script type="text/javascript" async="true">
    function qq_onclick(){
    	var text_2=document.getElementById("all");
    	text_2.removeAttribute("hidden");
    	}
    function qq_close(){
    	var text_1=document.getElementById("all");
    	text_1.setAttribute("hidden",true);
    	}
</script>
<title>题目选择</title>
</head>
<body>
	<a href="catelist?subid=${USER_SESSION.subid}">返回</a>
	<br/>
	<form action="addtoexam" method="post">
	 <table width="1500" >
    	<tr>    		
            <th>题目</th>
        </tr>
		<c:forEach items="${questions}" var="question">
          	<tr>
          		<td>
          			<input type="checkbox" name="ids" value="${question.getId()}"/>
          		</td>
          		<td>
          			<div >${question.getContent()}</div>
          		
          		</td>
<!--           		<td> -->
<!--                     <button onclick="qq_onclick()" style="width: 50px; height: 20px;">详情</button> -->
<!--                 </td> -->
          	</tr>
          	<tr id="all" hidden="hidden">
          		<th >
          			<div class="all">${question.getContent()}</div>
          		</th>
          	</tr>
        </c:forEach>
     </table>
     <tr colspan="20" align="center">
     	<td>
          	试卷名：<input type="text" name="examname" value="examname"/>
        </td>
        <td>
        <button type="submit">创建试卷</button>
        </td>
     </tr>
    </form>  
</body>
</html>