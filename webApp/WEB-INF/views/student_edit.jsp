<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/student/save" method="post">
		<input type="hidden" name="id" value="${student.id}" />
		姓名：<input type="text" name="name" required value='${student.name}' /><br />
		年龄：<input type="number" name="age" required min="1" value='${student.age}' /><br />
		<input type="submit" value="${student == null?'保存':'更新'}" />
	</form>

</body>
</html>