var emailalready = 0; // 表示email是否正确
var passwordalready = 0; // 表示密码是否正确
var repasswordalready = 0;// 表示重复密码是否正确
var repasswordfocus = 0;// 重复密码框是否被聚焦过
var emailused = 0;// 记录是否检查过一次email已被使用
var ruleemail =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/  // 设置email过滤规则
var rulepassword=/^(\w){6,20}$/ //设置过滤规则

$(document).ready(function(){ //关于登录注册按钮
	$("#register").css("color","#efab9b");
	$("#signin").hover(
			function(){
				$("#signin").css("color","#efab9b");
			},
			function(){
				$("#signin").css("color","#ffffff");
			}
	)
})

$(document).ready(function() { // 关于提交按钮
	$("#submitinfo").click(function() {
		if (emailalready == 1 && passwordalready == 1 && repasswordalready == 1 && emailused == 0) { // 满足条件时发送数据
			$.ajax({
				type : "POST",
				url : "/ConferencePortal/register/insert.action",
				data : {
					email : $("#emailinput").val(),
					username : $("#nameinput").val(),
					password : $("#passwordinput").val()},
				dataType : "json",
				success : function(result) {
					console.log(result);
					console.log(result.map.result);
					if (result.map.result == "success") {
						window.alert("注册成功");
						window.location.href = "/ConferencePortal/pages/signin.jsp";
					} else {
						emailused = 1; // 记录了email已被使用
						window.alert("email已被使用");
						$("#passwordinput").val("");
						$("#repasswordinput").val("");
					}
				}
			})
		} else {// 条件不满足时提示错误
			if (emailused == 1) { // email已被使用
				window.alert("email已被使用");
			} else if (emailalready == 0) { // email格式不对或者过短
				window.alert("email格式错误或者包含非法字符或者email过短");
			} else if (passwordalready == 0) {// 密码过短
				window.alert("密码过短或包含非法字符");
			} else {// 重复密码和密码不同
				window.alert("重复的密码和密码不同");
			}
		}
	})
})

$(document).ready(function() { // 关于email
	$("#emailinput").focus(function() { // email输入框获取焦点
		$("#emailinput").removeClass("input-error"); // 错误图标隐藏
		emailalready = 0; // 假定email是错误的，防止出现问题
		emailused = 0;// 认为已经修改过邮箱
	})
	$("#emailinput").blur(function() { // email输入框失去焦点
		var email; // 存放输入的email
		email = document.getElementById("emailinput").value; // 获取输入框内email
		if (email.length == 0) { // 输入框内无内容
			$("#emailinput").removeClass("input-error"); // 错误图标透明
		} else if (email.indexOf('\@') <= 0 // @号在在开头或者不存在
				|| email.indexOf('\.') <= 0 // .号在开头或者不存在
				|| email.indexOf('\.') - email.indexOf('\@') <= 1 // .号在@号之前或者相邻
				|| email.indexOf('\@') != email.lastIndexOf('\@') // 存在不止一个@号
				|| email.length < 5// email位数不足
				|| email.length == email.lastIndexOf('\.') + 1) { // 最后一位是.
			$("#emailinput").addClass("input-error");
		} else if(ruleemail.test($("#emailinput").val())==false){
			$("#emailinput").addClass("input-error");
		} else {
			emailalready = 1;
			$("#emailinput").removeClass("input-error");
		}
	})
})

$(document).ready(function() { // 关于password
	$("#passwordinput").focus(function() { // 密码输入框获取焦点时
		$("#passwordinput").removeClass("input-error"); // 错误图标透明
		passwordalready = 0; // 假定email是错误的，防止出现问题
	})
	$("#passwordinput").blur(function() { // 密码输入框失去焦点
		var password = document.getElementById("passwordinput").value;// 获取密码
		if (password.length == 0) { // 未输入密码
			$("#passwordinput").removeClass("input-error"); // 密码错误标识消失
		} else if (rulepassword.test($("#passwordinput").val())==false){
			$("#passwordinput").addClass("input-error");//密码错误表示显示
		} else if (password != document.getElementById("repasswordinput").value && repasswordfocus == 1) {// 和重复的密码不同
			$("#repasswordinput").addClass("input-error"); // 重复密码错误标识显示
			repasswordalready = 0;
			passwordalready = 1;
		} else {
			$("#repasswordinput").removeClass("input-error");// 隐藏重复密码错误标识
			passwordalready = 1;
			if (repasswordfocus == 1) { // 如果重复密码已经被聚焦过，设置重复密码正确
				repasswordalready = 1;
			}
		}
	})
})

$(document).ready(function() { // 关于重复密码
					$("#repasswordinput").focus(function() { // 重复密码输入框获取焦点
						$("#repasswordinput").removeClass("input-error");// 错误图标透明
						repasswordalready = 0;
						repasswordfocus = 1;
					})
					$("#repasswordinput")
							.blur(
									function() { // 重复密码输入失去焦点
										if (document
												.getElementById("passwordinput").value != document
												.getElementById("repasswordinput").value) {
											$("#repasswordinput").addClass("input-error"); // 显示错误图标
										} else {// 错误图标消失
											$("#repasswordinput").removeClass("input-error");
											repasswordalready = 1;
										}
									});
})

				