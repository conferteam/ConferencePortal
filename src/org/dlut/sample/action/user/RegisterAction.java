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
import org.dlut.sample.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/register")
public class RegisterAction extends BaseAction implements ModelDriven<UserInfoSimple> {

	private UserInfoSimple user = new UserInfoSimple();
	private Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	@JSON(serialize = false)
	public UserInfoSimple getUser() {
		return user;
	}

	@Autowired
	private RegisterService registerService;

	@Override
	@JSON(serialize = false)
	public UserInfoSimple getModel() {
		return user;
	}

	@Action(value = "insert", results = { @Result(name = "success", type = "json") })
	public String insert() {
		System.out.println(user);
		System.out.println(user.getUsername());
			
			
		map = new HashMap<String, Object>();
		if (registerService.inquire(user).isEmpty() == true) { // 如果数据库没有对应email
			registerService.insert(user);
			this.map.put("result", "success");
		} else {
			this.map.put("result", "fail");
		}
		return "success";
	}

}