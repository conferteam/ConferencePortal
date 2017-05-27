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
		user.setOldpassword(null); // ����ǰ��ǰȥ������
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
				request.getSession().setAttribute("Answer", null); //��������ֵΪ�գ���ֹ������
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
		request.getSession().setAttribute("user_email", "1@1.1"); // ��װǰ̨����һ����email��session����,session������ɿ���ɾ��
		if (request.getSession().getAttribute("user_email") != null) { // �����з��ص���Ϣȫ��д��email���������
			user.setEmail(request.getSession().getAttribute("user_email").toString());
			System.out.println(user);
			if (getUserInfoService.inquire(user).isEmpty() == false) { // ������ݿ��ж�Ӧemail
				if (user.getOldpassword() == null && user.getPassword() == null) { // û������ʱ
					getUserInfoService.insertnopassword(user);
					user.setEmail("success");
				} else if (getUserInfoService.inquire(user).get(0).getPassword() == user.getOldpassword()) { // ���������������������ͬ
					getUserInfoService.insert(user);
					user.setEmail("success");
				} else { // ���������������벻��ͬ
					user.setEmail("fail");
				}
			} else { // ���ݿ���Ϊû�ж�Ӧ��email������Ϊδ��¼
				user.setEmail("unsignin");
			}
		} else { // ������session��û��emailʱ����ǰ̨�����ݱ�ʾδ��¼
			user.setEmail("unsignin");
		}
		return "success";
	}
}