package org.dlut.sample.action.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.user.UserInfo;
import org.dlut.sample.pojo.user.UserInfoPages;
import org.dlut.sample.service.user.getUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/userinfo")
public class UserInfoPagesAction extends BaseAction implements ModelDriven<UserInfoPages> {

	private UserInfoPages pages = new UserInfoPages();
	private Map<String, Object> map;
	private UserInfo user= new UserInfo();
	
	public Map<String, Object> getMap() { //设置返回map,并且让map存储大部分数据
		return map;
	}

	@JSON(serialize = false)
	public UserInfo getUser() { //设置不返回user
		return user;
	}
	
	@JSON(serialize = false)
	public UserInfoPages getPages() {
		return pages;
	}

	@Autowired
	private getUserInfoService getUserInfoService; //调用服务器

	@Override
	@JSON(serialize = false)
	public UserInfoPages getModel() { //框下需求，设置不返回
		return pages;
	}

	@Action(value = "getpages", results = { @Result(name = "success", type = "json") }) //获取个人资料界面数据
	public String GetPages() {
		request.getSession().setAttribute("user_email", "1@1.1");
		request.getSession().setAttribute("user_id", "1"); //假设session已经设置
		
		map=new HashMap<String,Object>();
		user.setEmail(request.getSession().getAttribute("user_email").toString());
		user=getUserInfoService.inquire(user).get(0);
		map.put("email", user.getEmail());
		map.put("id", user.getId());
		map.put("points", user.getPoints());
		map.put("username", user.getUsername()); //返回基本的用户信息
		
		map.put("my_confer", getUserInfoService.getMyConferTop2(user)); //得到我参与的会议的前两个，并输入my_confer
		
		map.put("my_subscribe", getUserInfoService.getMySubscribeTop2(user));//得到我订阅会议的前两个，并输入my_subscribe
		
		map.put("count", getUserInfoService.getConferCount()); //获取总会议个数
		
		pages.setPages(pages.getPages()*5-5);
		pages.setPagesend(pages.getPages()+5);
		map.put("confer", getUserInfoService.getConferAll(pages));
		
		return "success";
	}

	@Action(value = "getconfer", results = { @Result(name = "success", type = "json") }) //获取我参与的会议或者我订阅的会议，取决于pagesend值
	public String GetConfer(){
		request.getSession().setAttribute("user_email", "1@1.1");
		request.getSession().setAttribute("user_id", "1"); //假设session已经设置
		
		map=new HashMap<String,Object>();
		
		pages.setId(Integer.parseInt(request.getSession().getAttribute("user_id").toString()));
		
		if(pages.getPagesend()==1){ //如果查询种类为1，代表查询参与的会议
			map.put("count", getUserInfoService.getMyConferCount(pages.getId())); //获取我参与的会议的总个数
			pages.setPages(pages.getPages()*5-5);
			pages.setPagesend(pages.getPages()+5); //将请求页数转换成请求的条目开始与结束的位置
			map.put("my_confer", getUserInfoService.getMyConfer(pages)); //得到固定页数我参与的会议
		}
		else if(pages.getPagesend()==2){ //如果查询种类为2，代表查询订阅的会议
			map.put("count", getUserInfoService.getMySubscribeCount(pages.getId())); //获取我参与的会议的总个数
			pages.setPages(pages.getPages()*5-5);
			pages.setPagesend(pages.getPages()+5); //将请求页数转换成请求的条目开始与结束的位置
			map.put("my_confer", getUserInfoService.getMySubscribe(pages)); //得到固定页数我参与的会议
		}
		else{} //其余情况代表前台有人搞事，啥都不做
		
		
		return "success";
	}
	
}