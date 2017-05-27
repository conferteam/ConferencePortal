package org.dlut.sample.action.conferenceInfo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.conferenceInfo.Participant;
import org.dlut.sample.service.conferenceInfo.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/conferenceInfo")
public class ParticipantAction extends BaseAction implements ModelDriven<Participant>{
	
	private Participant participant = new Participant();
	
	@Autowired
	private ParticipantService participantService;

	@Override
	public Participant getModel() {
		if(null == participant){
			participant = new Participant();
		}
		return participant;
	}

	@Action(value="insertParticipant", results={@Result(name="success", location="/pages/index.jsp", type="dispatcher")})
	public String insert(){
		System.out.println(participant);
		participantService.insert(participant);
		return "success";
	}
	
	
}
