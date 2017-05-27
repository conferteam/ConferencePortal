<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>sign in</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/signin.js"></script>
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
		<div class="main">
			<div class="main-tab">
				<a id="register"
					href="<%=request.getContextPath()%>/pages/register.jsp">注册</a>
				<!-- 注册按钮 -->
				<a id="signin" href="<%=request.getContextPath()%>/pages/signin.jsp">登录</a>
				<!-- 登录按钮 -->
			</div>
			<div>
				<!-- 记录错误 -->
				<input id="emailinput" type="text" class="form-control form-input"
					placeholder="电子邮箱"> <input id="passwordinput"
					type="password" class="form-control form-input" placeholder="密码">
				<button id="submitinfo" type="button"
					class="btn btn-default btn-submit">登录</button>
				<div class=forget-tab>
					<a class="forget-pass"
						href="/ConferencePortal/pages/user/passwordforget.html">忘记密码？</a>
				</div>
			</div>

		</div>
	</div>
</body>


</html>