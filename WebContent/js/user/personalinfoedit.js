var rulepassword = /^(\w){6,20}$/ // 设置过滤规则

$(document).ready(function() {// 初始化
	$.ajax({
		type : "post",
		url : "/ConferencePortal/userinfo/getuserinfo.action",
		data : {},
		dataType : "json",
		success : function(result) {
			console.log(result.model.email);
			$("#email").text(result.model.email);
			$("#usernameinput").val(result.model.username);
			if (result.model.follow == 1) {
				document.getElementById("followcheck").checked = true;
			} else {
				document.getElementById("followcheck").checked = false;
			}
		}
	})
})

function processresult(result){ //处理返回结果
	if(result=="success"){
		window.alert("修改成功");
	}
	else if(result=="fail"){
		window.alert("旧密码不正确，修改失败");
	}
	else{
		window.alert("未登录，即将跳转至登录界面");
		window.location.href="/ConferencePortal/pages/signin.jsp";
	}
	$("#oldpasswordinput").val("");
	$("#passwordinput").val("");
	$("#repasswordinput").val("");
}

$(document).ready(
		function() { // 关于提交按钮
			$("#submitinfo").click(
					function() {
						console.log(document.getElementById("followcheck").checked);
						if (!($("#oldpasswordinput").val()
								|| $("#passwordinput").val() || $(
								"#repasswordinput").val())) {// 全为空，认为不设置密码
							$.ajax({
								type : "post",
								url : "/ConferencePortal/userinfo/userinfoedit.action",
								data : {
									username : $("#usernameinput").val(),
									follow : document.getElementById("followcheck").checked==true?1:0
								},
								dataType : "json",
								success : function(result) {
									processresult(result.model.email);
								}
							})
						} else if ($("#passwordinput").val() != $(
								"#repasswordinput").val()) {
							console.log($("#passwordinput").val());
							console.log($("#repasswordinput").val());
							window.alert("密码与重复密码不一致");
						} else if ($("#oldpasswordinput").val() == $(
								"#passwordinput").val()) {
							window.alert("旧密码不能与新密码一致");
						} else if (rulepassword.test($("#passwordinput").val())
								&& rulepassword.test($("#oldpasswordinput")
										.val())) {
							$.ajax({
								type : "post",
								url : "/ConferencePortal/userinfo/userinfoedit.action",
								data : {
									username : $("#usernameinput").val(),
									oldpassword : $("#oldpasswordinput").val(),
									password : $("#passwordinput").val(),
									follow : document.getElementById("followcheck").checked==true?1:0
								},
								dataType : "json",
								success : function(result) {
									processresult(result.model.email);
								}
							})
						} else {
							window.alert("密码或旧密码过短或存在非法字符");
						}
					})
		})