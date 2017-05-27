<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserAll</title>
</head>
<body>

<div>
	This is UserAll.jsp.
</div>

<hr>

<div>
	<c:forEach items="${userList }" var="user">
		${user.username }<br>
	</c:forEach>
</div>

<hr>

<div>
	<form action="<%=request.getContextPath()%>/user/insert.action" method = "post">
		<input name="id" placeholder="Id">
		<input name="username" placeholder="Username">
		<input name="password" placeholder="Password" type = "password">
		<button type="submit">添加</button>
	</form>
</div>

</body>
</html>