package org.dlut.sample.action.user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.user.ProblemAnswer;
import org.dlut.sample.service.user.getUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/userinfo")
public class PasswordProblemAction extends BaseAction implements ModelDriven<ProblemAnswer> {

	private ProblemAnswer user = new ProblemAnswer();

	@JSON(serialize = false)
	public ProblemAnswer getUser() {
		return user;
	}

	@Autowired
	private getUserInfoService getUserInfoService;

	@Override
	public ProblemAnswer getModel() {
		user.setProblem(null);
		user.setAnswer(null);
		return user;
	}
	
	@Action(value = "inquireproblem", results = { @Result(name = "success", type = "json") })
	public String InquireProblem() {
		request.getSession().setAttribute("user_email", "1@1.1"); // ��װǰ̨����һ����email��session����,session������ɿ���ɾ��
		if (request.getSession().getAttribute("user_email") != null) {
			user.setEmail(request.getSession().getAttribute("user_email").toString());
			System.out.println(user);
			if (getUserInfoService.inquireproblem(user).isEmpty() == false) { // ������ݿ��ж�Ӧemail
				user = getUserInfoService.inquireproblem(user).get(0);
				if(user.getProblem()==null){
					user.setEmail("success");
				}
				else{
					user.setEmail("fail");
				}
			} else { // ���ݿ���Ϊû�ж�Ӧ��email������Ϊδ��¼

			}
		} else { // ������session��û��emailʱ����ǰ̨�����ݱ�ʾδ��¼

		}
		return "success";
	}

	@Action(value = "problemset", results = { @Result(name = "success", type = "json") })
	public String ProblemSet() {
		request.getSession().setAttribute("user_email", "1@1.1"); // ��װǰ̨����һ����email��session����,session������ɿ���ɾ��
		if (request.getSession().getAttribute("user_email") != null) {
			user.setEmail(request.getSession().getAttribute("user_email").toString());
			System.out.println(user);
			if (getUserInfoService.inquireproblem(user).isEmpty() == false) { // ������ݿ��ж�Ӧemail
				getUserInfoService.insertproblem(user);
			} else { // ���ݿ���Ϊû�ж�Ӧ��email������Ϊδ��¼

			}
		} else { // ������session��û��emailʱ����ǰ̨�����ݱ�ʾδ��¼

		}
		return "success";
	}
	

}