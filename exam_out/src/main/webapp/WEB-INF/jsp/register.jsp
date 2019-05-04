<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>免费注册</title>
</head>
<body>
	<a href="tologin">返回登录界面</a>
	<br/>
	${zhuce}
	<form method="post" id="addForm" action="register" enctype="multipart/form-data">
        <table>
             <tr>
                  <td>用户名</td>
                  <td><input  id="name" name="name" type="text" class="form-control"></td>
             </tr>
             <tr>
                  <td>密码</td>
                  <td><input id="password" name="password" type="text" /></td>
             </tr>
             <tr>
                  <td>学院编号</td>
                  <td><input id="subid" name="subid" type="text" /></td>
             </tr>
             <tr class="submitTR">
                  <td colspan="2" align="center">
                      <button type="submit" class="btn btn-success">免费注册</button>
                  </td>
             </tr>
         </table>
    </form>
	<br/><br/>
    <%@include file="../jsp/lists/listSubjects_register.jsp"%> 

</body>
</html>