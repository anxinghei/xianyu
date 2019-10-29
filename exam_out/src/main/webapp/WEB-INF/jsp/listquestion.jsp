<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="static/js/jquery.min.js"></script>	
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 	
<script src="static/bootstrap/js/bootstrap.min.js"></script>

<title>题目选择</title>
</head>
<body>
	<br/><br/>
	<a href="catelist?subid=${USER_SESSION.subid}">返回</a>
	<br/><br/>
	<div>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#toAddQuestion">增加题目</button>
	</div><br/>
	<div class="modal fade bs-example-modal-sm" id="toAddQuestion" tabindex="-1"
		role="dialog" aria-labelledby="toAddQuestionLabel">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">增加题目</h4>
				</div><br />
				<div class="pd20">
					<div class="input-group listSeaForm mt10 wb100">
						<span class="input-group-btn"> <span class="btn">题目：</span>
						</span> <input class="form-control" type="text" value="" id="question"
							placeholder="请填写题目内容">
					</div>
				</div><br />
				<div class="modal-footer">
					<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
					<button type="button" class="btn btn-primary wb100" id="addQuestion" onclick="addQuestion(${catid})">添加</button>
				</div>
			</div>
		</div>
	</div>
	<form action="addtoexam" method="post">
	 <table width="1500" class="table table-hover">
    	<tr>    		
            <th></th>
        </tr>
		<c:forEach items="${questions}" var="question">
          	<tr>
          		<td>
          			<input type="checkbox" name="ids" value="${question.getId()}"/>
          		</td>
          		<td>
          			<div >${question.getContent()}</div>
          		
          		</td>
          	</tr>
          	<tr id="all" hidden="hidden">
          		<th >
          			<div>${question.getContent()}</div>
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
    </form>  <br/><br/>
    
<script type="text/javascript" async="true">
    function addQuestion(catid){
    	var question = $("#question").val();
		var page = "addQuestion/"+catid+"?question=" + question;
		$.ajax({
			type : "post",
			url : page,
			data : {
				catid : catid,
				question : question
			},
			contentType : "application/json;charset=UTF-8",
			success : function(result) {
				location.reload();
				alert("题目已添加");
			},
			error : function(result) {
				alert("操作出错啦！请联系管理人员");
			},
			fail : function(result) {
				alert("由于网络不顺畅等原因，无法执行本次操作");
			}
		});
    }
    
</script>
</body>
</html>