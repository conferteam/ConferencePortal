package org.dlut.sample.action.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.user.UserInfo;
import org.dlut.sample.pojo.user.UserInfoPages;
import org.dlut.sample.service.user.getUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/userinfo")
public class UserInfoPagesAction extends BaseAction implements ModelDriven<UserInfoPages> {

	private UserInfoPages pages = new UserInfoPages();
	private Map<String, Object> map;
	private UserInfo user= new UserInfo();
	
	public Map<String, Object> getMap() { //���÷���map,������map�洢�󲿷�����
		return map;
	}

	@JSON(serialize = false)
	public UserInfo getUser() { //���ò�����user
		return user;
	}
	
	@JSON(serialize = false)
	public UserInfoPages getPages() {
		return pages;
	}

	@Autowired
	private getUserInfoService getUserInfoService; //���÷�����

	@Override
	@JSON(serialize = false)
	public UserInfoPages getModel() { //�����������ò�����
		return pages;
	}

	@Action(value = "getpages", results = { @Result(name = "success", type = "json") }) //��ȡ�������Ͻ�������
	public String GetPages() {
		request.getSession().setAttribute("user_email", "1@1.1");
		request.getSession().setAttribute("user_id", "1"); //����session�Ѿ�����
		
		map=new HashMap<String,Object>();
		user.setEmail(request.getSession().getAttribute("user_email").toString());
		user=getUserInfoService.inquire(user).get(0);
		map.put("email", user.getEmail());
		map.put("id", user.getId());
		map.put("points", user.getPoints());
		map.put("username", user.getUsername()); //���ػ������û���Ϣ
		
		map.put("my_confer", getUserInfoService.getMyConferTop2(user)); //�õ��Ҳ���Ļ����ǰ������������my_confer
		
		map.put("my_subscribe", getUserInfoService.getMySubscribeTop2(user));//�õ��Ҷ��Ļ����ǰ������������my_subscribe
		
		map.put("count", getUserInfoService.getConferCount()); //��ȡ�ܻ������
		
		pages.setPages(pages.getPages()*5-5);
		pages.setPagesend(pages.getPages()+5);
		map.put("confer", getUserInfoService.getConferAll(pages));
		
		return "success";
	}

	@Action(value = "getconfer", results = { @Result(name = "success", type = "json") }) //��ȡ�Ҳ���Ļ�������Ҷ��ĵĻ��飬ȡ����pagesendֵ
	public String GetConfer(){
		request.getSession().setAttribute("user_email", "1@1.1");
		request.getSession().setAttribute("user_id", "1"); //����session�Ѿ�����
		
		map=new HashMap<String,Object>();
		
		pages.setId(Integer.parseInt(request.getSession().getAttribute("user_id").toString()));
		
		if(pages.getPagesend()==1){ //�����ѯ����Ϊ1�������ѯ����Ļ���
			map.put("count", getUserInfoService.getMyConferCount(pages.getId())); //��ȡ�Ҳ���Ļ�����ܸ���
			pages.setPages(pages.getPages()*5-5);
			pages.setPagesend(pages.getPages()+5); //������ҳ��ת�����������Ŀ��ʼ�������λ��
			map.put("my_confer", getUserInfoService.getMyConfer(pages)); //�õ��̶�ҳ���Ҳ���Ļ���
		}
		else if(pages.getPagesend()==2){ //�����ѯ����Ϊ2�������ѯ���ĵĻ���
			map.put("count", getUserInfoService.getMySubscribeCount(pages.getId())); //��ȡ�Ҳ���Ļ�����ܸ���
			pages.setPages(pages.getPages()*5-5);
			pages.setPagesend(pages.getPages()+5); //������ҳ��ת�����������Ŀ��ʼ�������λ��
			map.put("my_confer", getUserInfoService.getMySubscribe(pages)); //�õ��̶�ҳ���Ҳ���Ļ���
		}
		else{} //�����������ǰ̨���˸��£�ɶ������
		
		
		return "success";
	}
	
}