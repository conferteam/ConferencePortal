package org.dlut.sample.action.friendship;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.friendship.Messages;
import org.dlut.sample.pojo.friendship.User;
import org.dlut.sample.service.friendship.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/chat")
public class ChatAction extends BaseAction implements ModelDriven<Messages>{
	@Autowired
	private ChatService chatService;
	private Messages messages=new Messages();
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public Messages getModel(){
		return messages;
	}
	//插入一条好友申请
	@Action(value="insertFriendNotice", results={@Result(name="success", location="", type="dispatcher")})
	public String insertFriendNotice(){
		messages.setSend_user_id(user.getUser_id());
		messages.setDate(new Date());
		chatService.insertFriendNotice(messages);
		
		return "success";
	}
	//接受好友请求，添加好友关系，删除好友请求
	@Action(value="acceptFriend", results={@Result(name="success", location="", type="dispatcher")})
	public String acceptFriend(){
		messages.setGet_user_id(user.getUser_id());
		//默认get_user_id<send_user_id
		if(messages.getGet_user_id()>messages.getSend_user_id())
		{
			Integer temp=messages.getGet_user_id();
			messages.setGet_user_id(messages.getSend_user_id());
			messages.setSend_user_id(temp);
		}

		chatService.acceptFriend(messages);
		return "success";
	}	
	//拒绝好友请求，删除好友请求
	@Action(value="refuseFriend", results={@Result(name="success", location="", type="dispatcher")})
	public String refuseFriend(){
		chatService.refuseFriend(messages);
		return "success";
	}	
	//查询与某个好友私信列表
	@Action(value="queryChat", results={@Result(name="success", location="/pages/friendship/chat.jsp", type="dispatcher")})
	public String queryChat(){
		//get_user_id是好友id,send_user_id是本人id
		messages.setSend_user_id(user.getUser_id());
		
		//私信列表
		List<Messages> chatList = chatService.queryChat(messages);
		request.setAttribute("chatList", chatList);
		
		//好友的个人信息
		User friendsUser=new User(messages.getGet_user_id());
		friendsUser=chatService.queryUser(friendsUser);
		request.setAttribute("friendsUser", friendsUser);
		
		//用户本人信息
		user=chatService.queryUser(user);
		request.setAttribute("user", user);
		
		return "success";
	}
	//插入一条私信
	@Action(value="insertChat", results={@Result(name="success", location="", type="dispatcher")})
	public String insertChat(){
		
		messages.setSend_user_id(user.getUser_id());
		messages.setDate(new Date());
		//处理有格式的私信，在"前加入\
		String temp=messages.getText();
		int i=temp.lastIndexOf("\"");
		while(temp!="" && i!=-1)
		{
			messages.setText(temp.substring(0, i)+"\\"+messages.getText().substring(i));
			if(i-1>=0)
				temp=temp.substring(0,i);
			i=temp.lastIndexOf("\"");
		}
		
		chatService.insertChat(messages);
		
		return "success";
	}
}