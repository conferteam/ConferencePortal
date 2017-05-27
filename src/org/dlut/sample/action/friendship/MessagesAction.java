package org.dlut.sample.action.friendship;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.friendship.FollowConference;
import org.dlut.sample.pojo.friendship.Messages;
import org.dlut.sample.pojo.friendship.User;
import org.dlut.sample.service.friendship.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/messages")
public class MessagesAction extends BaseAction implements ModelDriven<User>{
	
	@Autowired
	private MessagesService messagesService;
	
	@Override
	public User getModel() {
		return user;
	}

	//查询
	@Action(value="queryAll", results={@Result(name="success", location="/pages/friendship/messages.jsp", type="dispatcher")})
	public String queryAll(){

		//查询私信列表
		List<Messages> messagesList = messagesService.queryAll(user);
		//֪messagesList依据send_user_id和get_user_id来筛选最新私信消息，显示到私信列表。
		messagesList=removeDuplicateSendUserId(messagesList);
		request.setAttribute("messagesList", messagesList);
		
		//查询好友列表
		List<User> friendsList = messagesService.queryFriends(user);
		request.setAttribute("friendsList", friendsList);
		
		//查询关注列表
		List<User> followList = messagesService.queryFollow(user);
		request.setAttribute("followList", followList);
		
		//查询被关注列表
		List<User> beFollowedList = messagesService.queryBeFollowed(user);
		request.setAttribute("beFollowedList", beFollowedList);
		
		//查询最新的好友申请
		Messages friendNotice=messagesService.queryFriendNotice(user);
		request.setAttribute("friendNotice", friendNotice);
		
		//查询所有好友请求
		List<Messages> friendNoticeList = messagesService.queryAllFriendNotice(user);
		request.setAttribute("friendNoticeList", friendNoticeList);
		
		//查询关注的人参加的会议最新一条
		FollowConference followConference=messagesService.queryFollowConference(user);
		request.setAttribute("followConference", followConference);
		
		//查询关注的人参加的会议所有
		List<FollowConference> followConferenceList=messagesService.queryAllFollowConference(user);
		request.setAttribute("followConferenceList", followConferenceList);
		
		return "success";
	}
	
	//查询好友列表
	@Action(value="queryFriends", results={@Result(name="success", location="/pages/friendship/messages.jsp", type="dispatcher")})
	public String queryFriends(){
		List<User> friendsList = messagesService.queryFriends(user);
		request.setAttribute("friendsList", friendsList);
		return "success";
	}
	//查询关注列表
	@Action(value="queryFollow", results={@Result(name="success", location="/pages/friendship/messages.jsp", type="dispatcher")})
	public String queryFollow(){
		List<User> followList = messagesService.queryFollow(user);
		request.setAttribute("followList", followList);
		return "success";
	}
	//查询被关注列表
	@Action(value="queryBeFollowed", results={@Result(name="success", location="/pages/friendship/messages.jsp", type="dispatcher")})
	public String queryBeFollowed(){
		List<User> beFollowedList = messagesService.queryBeFollowed(user);
		request.setAttribute("beFollowedList", beFollowedList);
		return "success";
	}
	
	public List<Messages> removeDuplicateSendUserId(List<Messages> messagesList)
	{
		List<Messages> list= new java.util.ArrayList();
	    Set<Integer> set=new HashSet<Integer>();
	       for (Messages messages : messagesList) {
	            if (messages == null) {
	                continue;
	            }
	    
	            Integer  send_user_id = messages.getSend_user_id();
	            Integer  get_user_id = messages.getGet_user_id();
	            if (send_user_id != null) {
	                if (send_user_id!=user.getUser_id()&&!set.contains(send_user_id)) { 
	                	set.add(send_user_id);
	                	list.add(messages);
	          
	                } else if(get_user_id!=user.getUser_id()&&!set.contains(get_user_id)){
	                	set.add(get_user_id);
	                	list.add(messages);
	                	
	                }
	                else
	                	continue;
	            }   
	       }
	       set.clear();
	       return list;
	}
}
