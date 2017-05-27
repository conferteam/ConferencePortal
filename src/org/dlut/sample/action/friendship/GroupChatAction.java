package org.dlut.sample.action.friendship;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.friendship.Confer;
import org.dlut.sample.pojo.friendship.GroupChat;
import org.dlut.sample.pojo.friendship.User;
import org.dlut.sample.service.friendship.GroupChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/groupChat")
public class GroupChatAction extends BaseAction implements ModelDriven<GroupChat>{
	@Autowired
	private GroupChatService groupChatService;
	private GroupChat groupChat=new GroupChat();
	
	@Override
	public GroupChat getModel() {
		return groupChat;
	}
		
	//查询群组消息列表、会议信息、参会人员列表 。参数为conference_id
	@Action(value="queryAll", results={@Result(name="success", location="/pages/friendship/groupChat.jsp", type="dispatcher")})
	public String queryAll(){
		List<GroupChat> groupChatList = groupChatService.queryGroupChat(groupChat);
		request.setAttribute("groupChatList", groupChatList);
		
		Confer conference = groupChatService.queryConference(groupChat);
		request.setAttribute("conference", conference);
		
		//记录自己的id 查询除自己以外的参会人员
		groupChat.setUser_id(user.getUser_id());
		List<User> userList = groupChatService.queryUserList(groupChat);
		request.setAttribute("userList", userList);
		
		request.setAttribute("user", user);
		return "success";
	}
	//插入一条私信
	@Action(value="insertGroupChat", results={@Result(name="success", location="", type="dispatcher")})
	public String insertGroupChat(){
		
		groupChat.setUser_id(user.getUser_id());
		groupChat.setDate(new Date());
		
		//处理有格式的私信，在"前加入\
		String temp=groupChat.getText();
		int i=temp.lastIndexOf("\"");
		while(temp!="" && i!=-1)
		{
			groupChat.setText(temp.substring(0, i)+"\\"+groupChat.getText().substring(i));
			if(i-1>=0)
				temp=temp.substring(0,i);
			i=temp.lastIndexOf("\"");
		}
		
		groupChatService.insertGroupChat(groupChat);
		
		return "success";
	}
}
