<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>register</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/register.js"></script>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/css/T/register.css"
	rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		<div class="header">
<%-- 			<a class="header-logo" href="index.html"> <img
				src="<%=request.getContextPath()%>/images/confer.png"
				alt="Conference">
			</a> --%>
		</div>
		</br></br></br></br>
		<div class="main">
			<div class="main-tab">
				<a id="register"
					href="<%=request.getContextPath()%>/pages/register.jsp">注册</a> <a
					id="signin" href="<%=request.getContextPath()%>/pages/signin.jsp">登录</a>
			</div>
			<div>
				<input id="emailinput" type="text" class="form-control form-input"
					name="email" placeholder="电子邮箱（必须）"> <input id="nameinput"
					type="text" class="form-control form-input" name="username"
					placeholder="用户名/昵称（选填）"> <input id="passwordinput"
					type="password" class="form-control form-input" name="password"
					placeholder="密码（必填，至少六个字符）"> <input id="repasswordinput"
					type="password" class="form-control form-input"
					placeholder="确认密码（必填）">
				<button id="submitinfo" type="button"
					class="btn btn-default btn-submit">注册</button>
			</div>
		</div>
	</div>

</body>
</html>
