
//点击“关注的人参加的会议”事件
function followConference(){   
	document.all.ly.style.display="block";   
	document.all.ly.style.width=document.body.clientWidth;   
	document.all.ly.style.height=document.body.clientHeight;   
	document.all.Layer3.style.display="block"; 
}
//点击“添加好友”事件
function addFriend(avatar,username,email,user_id){   
	document.all.ly.style.display="block";   
	document.all.ly.style.width=document.body.clientWidth;   
	document.all.ly.style.height=document.body.clientHeight;   
	document.all.Layer2.style.display="block"; 

	var ava="<img src=\""+avatar+"\" style=\"border-radius:50%;width:70px;height:70px;\" class=\"img-responsive\" alt=\"profilePicture\"/>";
	document.getElementById("avatar").innerHTML=ava;
	
	var temp="<b style=\"color: #14171a;font-size: 18px;font-weight: bold;\">"+username+"</b><br><b style=\"font-weight: normal;font-size: 18px;color: #657786;\">"+email+"</b>";
	document.getElementById("usernameEmail").innerHTML=temp;
	document.getElementById("user_id").value=user_id;
}
//点击“验证消息”事件
function friendNotice(){   
	document.all.ly.style.display="block";   
	document.all.ly.style.width=document.body.clientWidth;   
	document.all.ly.style.height=document.body.clientHeight;   
	document.all.Layer1.style.display="block"; 
}
//点击“接受”好友申请事件
function accept(user_id,notice_id){
 	var traget=document.getElementById(notice_id);
 	traget.style.display="none";
	$.ajax({
      		url:"/ConferencePortal/chat/acceptFriend.action",
      		data:{
      			send_user_id:user_id,
      			notice_id:notice_id
      		}
      	});
}

//点击“拒绝”好友申请事件
function refuse(notice_id){
 	var traget=document.getElementById(notice_id);
 	traget.style.display="none";
	$.ajax({
      		url:"/ConferencePortal/chat/refuseFriend.action",
      		data:{
      			notice_id:notice_id
      		}
      	});
}
//点击“提交”好友申请事件
function submit(){
	$.ajax({
      		url:"/ConferencePortal/chat/insertFriendNotice.action",
      		data:{
      			get_user_id:document.getElementById("user_id").value,
      			text:$("#text").val()
      		}
      	});
}
//点击“关注”事件
function insertFollow(user_id){
	$.ajax({
		url:"/ConferencePortal/friendship/insertFollow.action",
		data:{
			user1_id:user_id
		}
	});
}