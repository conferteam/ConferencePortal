package org.dlut.sample.action.user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.user.UserInfo;
import org.dlut.sample.service.user.getUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/userinfo")
public class UserInfoEditAction extends BaseAction implements ModelDriven<UserInfo> {

	private UserInfo user = new UserInfo();

	@JSON(serialize = false)
	public UserInfo getUser() {
		return user;
	}

	@Autowired
	private getUserInfoService getUserInfoService;

	@Override
	public UserInfo getModel() {
		user.setPassword(null);
		user.setOldpassword(null); // 返回前端前去除密码
		return user;
	}

	@Action(value = "passwordreset", results = { @Result(name = "success", type = "json") })
	public String passwordReset() {
		System.out.println(user);
		if (request.getSession().getAttribute("forgetemail") != null) {
			if (request.getSession().getAttribute("Answer") != null) {
				user.setEmail(request.getSession().getAttribute("forgetemail").toString());
				getUserInfoService.passwordreset(user);
				user.setEmail("success");
				request.getSession().setAttribute("forgetemail", null);
				request.getSession().setAttribute("Answer", null); //设置两个值为空，防止出问题
			} else {
				user.setEmail("fail");
			}
		} else {
			user.setEmail("fail");
		}

		return "success";
	}

	@Action(value = "userinfoedit", results = { @Result(name = "success", type = "json") })
	public String userinfoedit() {
		request.getSession().setAttribute("user_email", "1@1.1"); // 假装前台传了一个有email的session过来,session部分完成可以删除
		if (request.getSession().getAttribute("user_email") != null) { // 将所有返回的消息全部写入email这个属性中
			user.setEmail(request.getSession().getAttribute("user_email").toString());
			System.out.println(user);
			if (getUserInfoService.inquire(user).isEmpty() == false) { // 如果数据库有对应email
				if (user.getOldpassword() == null && user.getPassword() == null) { // 没有密码时
					getUserInfoService.insertnopassword(user);
					user.setEmail("success");
				} else if (getUserInfoService.inquire(user).get(0).getPassword() == user.getOldpassword()) { // 如果输入旧密码和现密码相同
					getUserInfoService.insert(user);
					user.setEmail("success");
				} else { // 输入旧密码和现密码不相同
					user.setEmail("fail");
				}
			} else { // 数据库认为没有对应的email，即认为未登录
				user.setEmail("unsignin");
			}
		} else { // 当发现session中没有email时，向前台传数据表示未登录
			user.setEmail("unsignin");
		}
		return "success";
	}
}