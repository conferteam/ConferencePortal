
var query = location.search.slice(1).split('&').map(item => { // 自动截取链接搜索部分
	var r = {}
	var list = item.split('=');
	r[list[0]] = list[1];
	return r
}).reduce((prev, next) => { return Object.assign(prev, next) },{});

$(document).ready(function(){ // 初始化
	$("#email").text(query.email);
})

$(document).ready(function(){ // 关于提交
	$("#submitinfo").click(function(){
		$.ajax({
			type:"post",
			url:"/ConferencePortal/userinfo/passwordreset.action",
			data:{
				password:$("#passwordinput").val()
			},
			dataType:"json",
			success:function(result){
				if(result.model.email=="success"){
					window.alert("修改成功");
					location.href="/ConferencePortal/pages/signin.jsp";
				}
				else{
					location.href="/ConferencePortal/pages/user/passwordforget.html";
				}
			}
		})
	})
})