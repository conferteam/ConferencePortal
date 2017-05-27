package org.dlut.sample.pojo.friendship;

import java.util.Date;

public class Confer {
	private Integer confer_id;
	private String  confer_name;
	private String  confer_class_id;
	private Date    confer_date;
	private String  confer_location;
	private String  confer_link;
	private Date    paper_due;
	private Integer user_id;
	private String  confer_abstract;
	
	public Integer getConfer_id() {
		return confer_id;
	}
	public void setConfer_id(Integer confer_id) {
		this.confer_id = confer_id;
	}
	public String getConfer_name() {
		return confer_name;
	}
	public void setConfer_name(String confer_name) {
		this.confer_name = confer_name;
	}
	public String getConfer_class_id() {
		return confer_class_id;
	}
	public void setConfer_class_id(String confer_class_id) {
		this.confer_class_id = confer_class_id;
	}
	public Date getConfer_date() {
		return confer_date;
	}
	public void setConfer_date(Date confer_date) {
		this.confer_date = confer_date;
	}
	public String getConfer_location() {
		return confer_location;
	}
	public void setConfer_location(String confer_location) {
		this.confer_location = confer_location;
	}
	public String getConfer_link() {
		return confer_link;
	}
	public void setConfer_link(String confer_link) {
		this.confer_link = confer_link;
	}
	public Date getPaper_due() {
		return paper_due;
	}
	public void setPaper_due(Date paper_due) {
		this.paper_due = paper_due;
	}
	public String getConfer_abstract() {
		return confer_abstract;
	}
	public void setConfer_abstract(String confer_abstract) {
		this.confer_abstract = confer_abstract;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
}