var emailalready = 0; // 记录email是否正确
var passwordalready = 0; // 记录密码是否正确
var infoerror = 0; // 记录是否已提示过信息错误

$(document).ready(function(){ //关于登录注册按钮
	$("#signin").css("color","#efab9b");
	$("#register").hover(
			function(){
				$("#register").css("color","#000000");
			},
			function(){
				$("#register").css("color","#efab9b");
			}
	)
})

$(document).ready(function() { // 关于email输入框
	$("#emailinput").blur(function() {// email输入框失去焦点时
		infoerror = 0;
		var email; // 存放输入的email
		email = document.getElementById("emailinput").value; // 获取输入框内email
		if (email.length == 0) { // 输入框内无内容
			$("#emailerror").hide(); // 错误图标透明
		} else if (email.indexOf('\@') <= 0 // @号在在开头或者不存在
				|| email.indexOf('\.') <= 0 // .号在开头或者不存在
				|| email.indexOf('\.') - email.indexOf('\@') <= 1 // .号在@号之前或者相邻
				|| email.indexOf('\@') != email.lastIndexOf('\@') // 存在不止一个@号
				|| email.length < 5// email位数不足
				|| email.length == email.lastIndexOf('\.') + 1) { // 最后一位是.
			emailalready = 0;
		} else {
			emailalready = 1;
		}
	})
})

$(document).ready(function() { // 关于密码输入框
	$("#passwordinput").blur(function() { // 密码输入框失去焦点时
		infoerror = 0;
		var password = document.getElementById("passwordinput").value;// 获取密码
		if (password.length < 6) { // 密码长度过短
			passwordalready = 0;
		} else { // 前端无法检测出错误
			passwordalready = 1;

		}
	})
})

$(document).ready(function() { // 关于按钮
	$("#submitinfo").click(function() { // 按下按钮
		$("#errorinfo").hide();
		if (emailalready == 1 && passwordalready == 1 && infoerror == 0) { // 信息全部正确，查询数据库
			$.ajax({
				type : "post",
				url : "/ConferencePortal/signin/inquire.action",
				data : {
					email : $("#emailinput").val(),
					password : $("#passwordinput").val()
				}, // 发送email和password
				dataType : "json", // 接收方式为json
				success : function(result) {
					if (result.map.result == "success") { // 如果返回成功
						window.alert("登录成功");
						
					} else { // 返回失败
						$("#passwordinput").val("");
						window.alert("用户名不存在或密码错误");
						infoerror = 1;
					}
				}
			})
		} else if (infoerror == 1) {
			window.alert("用户名不存在或密码错误");
		} else if (emailalready == 0) {
			window.alert("邮箱格式错误");
		} else {
			window.alert("密码过短");
		}
		
	})
})