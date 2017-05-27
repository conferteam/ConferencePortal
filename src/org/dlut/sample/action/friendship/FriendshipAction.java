package org.dlut.sample.action.friendship;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.friendship.Friendship;
import org.dlut.sample.service.friendship.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/friendship")
public class FriendshipAction extends BaseAction implements ModelDriven<Friendship>{
	private Friendship friendship = new Friendship();
	
	@Autowired
	private FriendshipService friendshipService;
	
	@Override
	public Friendship getModel() {
		return friendship;
	}
		
	//��ӹ�ע
	@Action(value="insertFollow", results={@Result(name="success", location="", type="dispatcher")})
	public String insertFollow(){
		friendship.setUser2_id(user.getUser_id());
		friendshipService.insertFollow(friendship);
		return "success";
	}
	
	//ɾ����ע
	@Action(value="deleteFollow", results={@Result(name="success", location="/messages/queryAll.action", type="redirect")})
	public String deleteFollow(){
		friendship.setUser2_id(user.getUser_id());
		friendshipService.deleteFollow(friendship);
		return "success";
	}
	//ɾ������,ɾ�������¼
	@Action(value="deleteFriend", results={@Result(name="success", location="/messages/queryAll.action", type="redirect")})
	public String deleteFriend(){
		friendship.setUser2_id(user.getUser_id());
		//��֤user_idС����ǰ
		if(friendship.getUser1_id()>friendship.getUser2_id())
		{
			Integer temp=friendship.getUser1_id();
			friendship.setUser1_id(friendship.getUser2_id());
			friendship.setUser2_id(temp);
		}
		friendshipService.deleteFriend(friendship);
		friendshipService.deleteChat(friendship);
		return "success";
	}
}