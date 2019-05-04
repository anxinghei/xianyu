<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<div >
           一共${page.total}条记录，有${page.pages}页，当前页号：${page.pageNum}
</div>
<div >
    <c:if test="${page.isFirstPage==true}"><a>首页</a></c:if>
   	<c:if test="${page.isFirstPage==false}">
        <a href="toregister?pageNum=${page.firstPage}">首页</a>
    </c:if>
 
  	<c:if test="${page.hasPreviousPage==false}"><a>上一页</a></c:if>
    <c:if test="${page.hasPreviousPage==true}">
       	<a href="toregister?pageNum=${page.prePage}">上一页</a>
   	</c:if>
   
   	<c:if test="${page.hasNextPage==false}"><a>下一页</a></c:if>
   	<c:if test="${page.hasNextPage==true}">
       	<a href="toregister?pageNum=${page.nextPage}">下一页</a>
    </c:if>
    
   	<c:if test="${page.isLastPage==true}"><a>末页</a></c:if>
    <c:if test="${page.isLastPage==false}">
        <a href="toregister?pageNum=${page.lastPage}">末页</a>
    </c:if>
</div>