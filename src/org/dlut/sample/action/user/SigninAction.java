package org.dlut.sample.action.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.user.UserInfoSimple;
import org.dlut.sample.service.user.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/signin")

public class SigninAction extends BaseAction implements ModelDriven<UserInfoSimple> {
	
	private UserInfoSimple user = new UserInfoSimple();
	private Map<String, Object> map;
	
	public Map<String, Object> getMap() {
		return map;
	}
	
	@JSON(serialize=false)
	public UserInfoSimple getUser() {
		return user;
	}
	@Autowired
	private SigninService signinService;

	@Override
	@JSON(serialize=false)
	public UserInfoSimple getModel() {
		return user;
	}

	@Action(value="inquire", results={@Result(name="success",type="json")})
	public String inquire(){
		System.out.println(user);
		map = new HashMap<String, Object>();
		if(signinService.inquire(user).isEmpty()==true){ //如果没有查找到对应用户
			map.put("result", "fail");
		}
		else{
			map.put("result", "success");
			request.getSession().setAttribute("user_id", user.getId());
			request.getSession().setAttribute("user_email", user.getEmail());
		}
		return "success";
	}
}