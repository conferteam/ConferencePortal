package org.dlut.sample.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.dlut.sample.pojo.friendship.User;

/**
 * Action base action
 */
public class BaseAction implements ServletRequestAware, ServletResponseAware,
		ServletContextAware{
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
		
	protected ServletContext context;
	public User user= new User(1);
	
	@Override
	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	
}