

//时间date，是否自己isSelf，内容text
function addMessage(msg){
	//alert(msg.text);
	var box = $("#msgtmp").clone(); 	//复制一份模板，取名为box
	box.show();							//设置box状态为显示
	box.appendTo("#chatContent");		//把box追加到聊天面板中
	
	box.find('[ff="date"]').html(msg.date); 		//在box中设置时间
	box.find('[ff="text"]').html(msg.text); 	//在box中设置内容
	var tmp="<img class=\"am-comment-avatar\" src=\""+msg.avatar+"\"/>";
	box.find('[ff="img"]').html(tmp);		//显示头像
	box.addClass(msg.isSelf? 'am-comment-flip':'');	//右侧显示
	box.css((msg.isSelf? 'margin-left':'margin-right'),"20%");//外边距
	
	$("#ChatBox div:eq(0)").scrollTop(999999); 	//滚动条移动至最底部
	
}