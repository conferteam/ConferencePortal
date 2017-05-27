var ruleemail =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/  // 设置email过滤规则

$(document).ready(function(){
	$("#submitinfo").click(function(){
		if(ruleemail.test($("#emailinput").val())){
			$.ajax({
				type:"post",
				url:"/ConferencePortal/passwordforget/emailinquire.action",
				data:{
					email:$("#emailinput").val()
				},
				dataType:"json",
				success:function(result){
					if(result.model.email=="success"){
						window.location.href="/ConferencePortal/pages/user/passwordforget2.html";
					}else if(result.model.email=="unset"){
						window.alert("该邮箱未设置密码找回问题");
					}
					else{
						window.alert("邮箱不存在");
					}
				}
			})
		}
		else{
			window.alert("邮箱格式错误");
		}
	})
})