function locking(avatar,username,email,user_id){   
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
function submit(){
	$.ajax({
      		url:"/ConferencePortal/chat/insertFriendNotice.action",
      		data:{
      			get_user_id:document.getElementById("user_id").value,
      			text:$("#text").val()
      		}
      	});
}
function insertFollow(user_id){
	$.ajax({
		url:"/ConferencePortal/friendship/insertFollow.action",
		data:{
			user1_id:user_id
		}
	});
}

//人名nickname，时间date，是否自己isSelf，内容content
function addMessage(msg){
	
	var box = $("#msgtmp").clone(); 	//复制一份模板，取名为box
	box.show();							//设置box状态为显示
	box.appendTo("#chatContent");		//把box追加到聊天面板中
	var tmp="<img class=\"am-comment-avatar\" src=\""+msg.avatar+"\"/>";
	box.find('[ff="img"]').html(tmp);		//显示头像
	box.find('[ff="username"]').html(msg.username); //在box中设置昵称
	box.find('[ff="date"]').html(msg.date); 		//在box中设置时间
	box.find('[ff="text"]').html(msg.text); 	//在box中设置内容
	box.addClass(msg.isSelf? 'am-comment-flip':'');	//右侧显示
	box.css((msg.isSelf? 'margin-left':'margin-right'),"20%");//外边距
	
	$("#ChatBox div:eq(0)").scrollTop(999999); 	//滚动条移动至最底部
	
}