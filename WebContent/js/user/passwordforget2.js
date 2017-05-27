

$(document).ready(function(){ //初始化
	$.ajax({
		type:"post",
		url:"/ConferencePortal/passwordforget/inquire.action",
		data:{},
		dataType:"json",
		success:function(result){
			if(result.model.email!=null){
				$("#email").val(result.model.email);
				$("#problem").text(result.model.problem);
			}
			else{
				window.location.href="/ConferencePortal/pages/user/passwordforget.html";
			}
		}
	})
})

$(document).ready(function(){ //关于提交按钮
	$("#submitinfo").click(function(){
		if($("#answer").length==0){
			window.alert("请输入密码提示问题答案");
		}
		else{
			$.ajax({
				type:"post",
				url:"/ConferencePortal/passwordforget/verify.action",
				data:{
					answer:$("#answer").val()
				},
				dataType:"json",
				success:function(result){
					if(result.model.email=="success"){
						window.alert("重置完成，进入重置界面");
						window.location.href="/ConferencePortal/pages/user/passwordreset.html?email="+$("#email").text();
					}
					else{
						window.alert("答案错误");
					}
				}
			})
		}
	})
})