package org.dlut.sample.action.conferenceInfo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.conferenceInfo.Conference;
import org.dlut.sample.service.conferenceInfo.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/conferenceInfo")
public class ConferenceAction extends BaseAction implements ModelDriven<Conference>{
	private Conference conference = new Conference();
	 
	@Autowired
	private ConferenceService conferenceService;
	
	@Override
	public Conference getModel(){
		if(null == conference){
			conference = new Conference();
		}
		return conference;
	}

	@Action(value="insert", results={@Result(name="successInsert", location="/pages/index.jsp", type="redirect")})
	public String insert(){
		request.getSession().setAttribute("user_id", 111);
		int userID =Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		conference.setUserId(userID);
		String confer_abbreviate = conference.getConfer_abbreviate();
		System.out.println(confer_abbreviate+"=========================");
		//conference.setConfer_abbreviate(confer_abbreviate );
		System.out.println(conference);
		conferenceService.insert(conference);
		return "successInsert";
	}

	/**
	 * 更新会议详细信息
	 * @return
	 */
	@Action(value="updateCFP", results={@Result(name="successUpdate",location="/pages/index.jsp",type="redirect")})
	public String updateCFP(){
		conferenceService.updateCFP(conference);
		return "successUpdate";
	}
	
	/**
	 * 查询会议
	 * 按举行时间进行查询
	 * @return
	 */
	@Action(value="queryCFP", results={@Result(name="success",location="/pages/conferenceInfo/conference.jsp",type="dispatcher")})
	public String queryInit(){
		List<Conference> conList = conferenceService.queryCFP();
		request.setAttribute("conList", conList);
		System.out.println(conList);
		return "success";
	}
	
	/**
	 * 按会议类别进行查询
	 * @return
	 */
	@Action(value="queryByCategories", results={@Result(name="successByCategories",location="/pages/conferenceInfo/byCategories.jsp",type="dispatcher")})
	public String queryByCategories(){
		List<Conference> conByCategoriesList = conferenceService.queryByCategories(conference);
		request.setAttribute("conByCategoriesList", conByCategoriesList);
		System.out.println(conByCategoriesList);
		return "successByCategories";
	}
	
	/**
	 * 按时间查询
	 * @return
	 */
	@Action(value="queryByDate", results={@Result(name="successDate",location="/pages/conferenceInfo/conferByDate.jsp",type="dispatcher")})
	public String queryByDate(){
		List<Conference> conByDateList = conferenceService.queryByDate();
		request.setAttribute("conByDateList", conByDateList);
		return "successDate";
	}
	
	/**
	 * 查询会议所有类别
	 * 未用
	 * @return
	 */
	@Action(value="queryCategories", results={@Result(name="successCategories",location="/pages/conferenceInfo/conferCategories.jsp",type="dispatcher")})
	public String queryCategories(){
		List<Conference> conCategoriesList = conferenceService.queryCategories();
		request.setAttribute("conCategoriesList", conCategoriesList);
		return "successCategories";
	}
	
	
	/**
	 * 暂时没用到
	 * @return
	 */
	@Action(value="query", results={@Result(name="success",location="/pages/conferenceInfo/categories.jsp",type="dispatcher")})
	public String query(){
		List<Conference> conList = conferenceService.queryCFP();
		List<Conference> conByDateList = conferenceService.queryByDate();
		request.setAttribute("conList", conList);
		request.setAttribute("conByDateList", conByDateList);
		System.out.println(conList);
		System.out.println(conByDateList);
		return "success";
	}
	
	/**
	 * 查询会议详细信息
	 * @return
	 */
	@Action(value="queryDetail", results={@Result(name="successDetail",location="/pages/conferenceInfo/conferenceDetail.jsp",type="dispatcher")})
	public String queryConDetail(){
		List<Conference> conDetailList = conferenceService.queryDetail(conference);
		request.setAttribute("conDetailList", conDetailList);
		return "successDetail";
	}
	
	/**
	 * 
	 * @return
	 */
	@Action(value="queryById", results={@Result(name="successDetail",location="/pages/conferenceInfo/updateCallFpaper.jsp",type="dispatcher")})
	public String queryById(){
		/*System.out.println(conference.getConference_date()+"================");*/
		List<Conference> queryByIdList = conferenceService.queryById(conference);
		request.setAttribute("queryByIdList", queryByIdList);
		return "successDetail";
	}
}
