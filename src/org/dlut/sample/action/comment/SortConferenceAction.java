package org.dlut.sample.action.comment;


import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.comment.Conference;
import org.dlut.sample.service.comment.SortConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/sortConference")
public class SortConferenceAction extends BaseAction implements ModelDriven<Conference>{
	private Conference conference = new Conference();
	
	@Autowired
	private SortConferenceService sortConferenceService;
	
	@Override
	public Conference getModel(){
		return conference;
	}
	@Action(value="querySortConference", results={@Result(name="success", location="/pages/byCategories.jsp", type="dispatcher")})
	public String querySortConference(){
		List<Conference> sortConferenceList = sortConferenceService.sortConference(conference);
		request.setAttribute("conByCategoriesList", sortConferenceList);
		return "success";
	}
	
	

}
