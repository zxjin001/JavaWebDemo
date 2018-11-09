<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
</head>
<body>
	<h2>学生列表</h2>
	
	<a href="${pageContext.request.contextPath}/student/edit">添加学生</a>
	<table border="1" cellpadding="0" cellspacing="0" width="70%">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${StuList}" var="item" varStatus="vs"> 
		<tr style='background:${vs.count%2==0?"gray":""};'>
		<td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.age}</td>
		<td>
		<a href="${pageContext.request.contextPath}/student/delete?id=${item.id}">删除 </a>
		<a href="${pageContext.request.contextPath}/student/edit?id=${item.id}">编辑 </a>
		</td>
		</c:forEach>
		</tr>
	</table>
</body>
</html>