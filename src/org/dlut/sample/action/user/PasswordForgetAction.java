package org.dlut.sample.action.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.service.user.PasswordForgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.dlut.sample.pojo.user.ProblemAnswer;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/passwordforget")
public class PasswordForgetAction extends BaseAction implements ModelDriven<ProblemAnswer> {

	private ProblemAnswer user = new ProblemAnswer();

	@JSON(serialize = false)
	public ProblemAnswer getUser() {
		return user;
	}

	@Autowired
	private PasswordForgetService passwordforgetService;

	@Override
	public ProblemAnswer getModel() {
		user.setAnswer(null);
		return user;
	}

	@Action(value = "emailinquire", results = { @Result(name = "success", type = "json") })
	public String InquireProblem() {
		System.out.println(user);
		if (passwordforgetService.inquireemail(user).isEmpty() == false) { // 如果在数据库查询到对应的email
			user = passwordforgetService.inquireemail(user).get(0);
			System.out.println(user);
			if (user.getProblem() == null) {
				user.setEmail("unset");
			} else {
				request.getSession().setAttribute("forgetemail", user.getEmail());
				request.getSession().setAttribute("Problem", user.getProblem());
				request.getSession().setAttribute("Answer", null);
				user.setEmail("success");
			}
		} else {
			user.setEmail("fail");
		}
		return "success";
	}

	@Action(value = "inquire", results = { @Result(name = "success", type = "json") })
	public String Inquire() {
		if (request.getSession().getAttribute("forgetemail") != null) {
			user.setEmail(request.getSession().getAttribute("forgetemail").toString());
			user.setProblem(request.getSession().getAttribute("Problem").toString());
		} else {
			user.setEmail(null);
		}
		return "success";
	}
	
	
	@Action(value = "verify", results = { @Result(name = "success", type = "json") })
	public String verify() {
		if (request.getSession().getAttribute("forgetemail") != null) {
			user.setEmail(request.getSession().getAttribute("forgetemail").toString());
			user.setProblem(request.getSession().getAttribute("Problem").toString());
			if(passwordforgetService.inquireemail(user).get(0).getAnswer().equals(user.getAnswer())){
				request.getSession().setAttribute("Answer", "true");
				user.setEmail("success");
			}else{
				user.setEmail("false");
			}
		} else {
			user.setEmail("false");
		}
		return "success";
	}

	/*
	 * @Action(value = "problemset", results = { @Result(name = "success", type
	 * = "json") }) public String ProblemSet() {
	 * request.getSession().setAttribute("user_email", "1@1.1"); //
	 * ��װǰ̨����һ����email��session����,session������ɿ���ɾ�� if
	 * (request.getSession().getAttribute("user_email") != null) {
	 * user.setEmail(request.getSession().getAttribute("user_email").toString())
	 * ; System.out.println(user); if
	 * (getUserInfoService.inquireproblem(user).isEmpty() == false) { //
	 * ������ݿ��ж�Ӧemail getUserInfoService.insertproblem(user); } else { //
	 * ���ݿ���Ϊû�ж�Ӧ��email������Ϊδ��¼
	 * 
	 * } } else { // ������session��û��emailʱ����ǰ̨�����ݱ�ʾδ��¼
	 * 
	 * } return "success"; }
	 */

}