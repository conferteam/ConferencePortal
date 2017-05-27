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
public class UserAvatarGetAction extends BaseAction implements ModelDriven<UserInfo> {

	private UserInfo user = new UserInfo();

	@JSON(serialize = false)
	public UserInfo getUser() {
		return user;
	}

	@Autowired
	private getUserInfoService getUserInfoService;

	@Override
	public UserInfo getModel() {
		user.setId(null);
		user.setOldpassword(null);
		user.setPassword(null);
		return user;
	}

	@Action(value = "useravatarget", results = { @Result(name = "success", type = "json") })
	public String UserAvatarGet() {
		request.getSession().setAttribute("user_email", "1@1.1"); // ��װǰ̨����һ����email��session����,session������ɿ���ɾ��
		if (request.getSession().getAttribute("user_email") != null) {
			user.setEmail(request.getSession().getAttribute("user_email").toString());
			System.out.println(user);
			if (getUserInfoService.inquire(user).isEmpty() == false) { // ������ݿ��ж�Ӧemail
				user = getUserInfoService.inquire(user).get(0);
			} else { // ���ݿ���Ϊû�ж�Ӧ��email������Ϊδ��¼

			}
		} else { // ������session��û��emailʱ����ǰ̨�����ݱ�ʾδ��¼

		}
		return "success";
	}
	

}