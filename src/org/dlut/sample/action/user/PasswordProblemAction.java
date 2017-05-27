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
		request.getSession().setAttribute("user_email", "1@1.1"); // 假装前台传了一个有email的session过来,session部分完成可以删除
		if (request.getSession().getAttribute("user_email") != null) {
			user.setEmail(request.getSession().getAttribute("user_email").toString());
			System.out.println(user);
			if (getUserInfoService.inquireproblem(user).isEmpty() == false) { // 如果数据库有对应email
				user = getUserInfoService.inquireproblem(user).get(0);
				if(user.getProblem()==null){
					user.setEmail("success");
				}
				else{
					user.setEmail("fail");
				}
			} else { // 数据库认为没有对应的email，即认为未登录

			}
		} else { // 当发现session中没有email时，向前台传数据表示未登录

		}
		return "success";
	}

	@Action(value = "problemset", results = { @Result(name = "success", type = "json") })
	public String ProblemSet() {
		request.getSession().setAttribute("user_email", "1@1.1"); // 假装前台传了一个有email的session过来,session部分完成可以删除
		if (request.getSession().getAttribute("user_email") != null) {
			user.setEmail(request.getSession().getAttribute("user_email").toString());
			System.out.println(user);
			if (getUserInfoService.inquireproblem(user).isEmpty() == false) { // 如果数据库有对应email
				getUserInfoService.insertproblem(user);
			} else { // 数据库认为没有对应的email，即认为未登录

			}
		} else { // 当发现session中没有email时，向前台传数据表示未登录

		}
		return "success";
	}
	

}