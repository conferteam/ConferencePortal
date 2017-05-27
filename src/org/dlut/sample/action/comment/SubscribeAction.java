package org.dlut.sample.action.comment;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.comment.Subscribe;
import org.dlut.sample.service.comment.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/Subscribe")
public class SubscribeAction extends BaseAction implements ModelDriven<Subscribe>{
	private Subscribe subscribe = new Subscribe();
	
	@Autowired
	private SubscribeService subscribeService;
	
	@Override
	public Subscribe getModel(){
		return subscribe;
	}
	//单次订阅
	@Action(value="insertSubscribeOnce", results={@Result(name="success", location="/pages/byCategories.jsp", type="dispatcher")})
	public String insertSubscribeOnce(){
		request.getSession().setAttribute("user_id", 111);     //测试数据
		int user_id=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		subscribe.setUser_id(user_id);
		subscribeService.insertSubscribeOnce(subscribe);
		return "success";
	}
	//长期订阅
	@Action(value="insertSubscribeLong", results={@Result(name="success", location="/pages/byCategories.jsp", type="dispatcher")})
	public String insertSubscribeLong(){
		request.getSession().setAttribute("user_id", 111);     //测试数据
		int user_id=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		subscribe.setUser_id(user_id);
		subscribeService.insertSubscribeLong(subscribe);
		return "success";
	}
	//取消长期订阅
	@Action(value="deleteSubscribeLong", results={@Result(name="success", location="/pages/byCategories.jsp", type="dispatcher")})
	public String deleteSubscribeLong(){
		request.getSession().setAttribute("user_id", 111);     //测试数据
		int user_id=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		subscribe.setUser_id(user_id);
		subscribeService.deleteSubscribeLong(subscribe);
		return "success";
	}
	//取消单次订阅
	@Action(value="deleteSubscribeOnce", results={@Result(name="success", location="/pages/byCategories.jsp", type="dispatcher")})
	public String deleteSubscribeOnce(){
		request.getSession().setAttribute("user_id", 111);     //测试数据
		int user_id=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		subscribe.setUser_id(user_id);
		subscribeService.deleteSubscribeOnce(subscribe);
		return "success";
	}
}
