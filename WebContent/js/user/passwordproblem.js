$(document).ready(function(){ //关于初始化
	$.ajax({
		type:"post",
		url:"/ConferencePortal/userinfo/inquireproblem.action",
		data:{},
		dataType:"json",
		success:function(result){
			if(result.model.email!="success"){
				window.alert("已经设置过密码提示问题，将跳转到个人资料界面");
				window.location.href="/ConferencePortal/pages/user/personalinfoedit.html";
			}
		}
	})
})

$(document).ready(function(){ //关于提交按钮
	$("#submitinfo").click(function(){
		if($("#probleminput").val().length<1||$("#probleminput").val().length>=10){
			window.alert("密码提示问题过长或过短");
		}
		else if($("#answerinput").val().length<1||$("#answerinput").val().length>=10){
			window.alert("密码提示答案过长或过短");
		}
		else{
			$.ajax({
				type:"post",
				url:"/ConferencePortal/userinfo/problemset.action",
				data:{
					problem:$("#probleminput").val(),
					answer:$("#answerinput").val()
				},
				dataType:"json",
				success:function(result){
					window.alert("设置成功");
					window.location.href="/ConferencePortal/pages/user/personalinfoedit.html";
				}
			})
		}
	})
})