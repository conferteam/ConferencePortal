package org.dlut.sample.pojo.user;

import java.sql.Date;

public class ConferInfoSimple {
	private Integer confer_id;
	private String confer_name;
	private String confer_class_id; // 这个是会议种类名称，名字里有id只是因为开始设计时打算使用id
	private Date confer_date;
	private String confer_location;
	private Integer user_id;
	private String confer_abstract;
	private String confer_abbreviate;

	public void setConferAbbreviate(String confer_abbreviate) {
		this.confer_abbreviate = confer_abbreviate;
	}

	public String getConferAbbreviate() {
		return confer_abbreviate;
	}

	public void setConferId(Integer confer_id) {
		this.confer_id = confer_id;
	}

	public Integer getConferId() {
		return confer_id;
	}

	public void setConferName(String confer_name) {
		this.confer_name = confer_name;
	}

	public String getConferName() {
		return confer_name;
	}

	public void setConferClassId(String confer_class_id) {
		this.confer_class_id = confer_class_id;
	}

	public String getConferClassId() {
		return confer_class_id;
	}

	public void setConferDate(Date confer_date) {
		this.confer_date = confer_date;
	}

	public Date getConferDate() {
		return confer_date;
	}

	public String getConferLocation() {
		return confer_location;
	}

	public void setConferLocation(String confer_location) {
		this.confer_location = confer_location;
	}

	public Integer getUserId() {
		return user_id;
	}

	public void setUserId(Integer user_id) {
		this.user_id = user_id;
	}

	public String getConferAbstract() {
		return confer_abstract;
	}

	public void setConferAbstract(String confer_abstract) {
		this.confer_abstract = confer_abstract;
	}

	public ConferInfoSimple() {
		super();
	}

	public ConferInfoSimple(Integer confer_id, String confer_name, String confer_class_id, Date confer_date,
			String confer_location, Integer user_id, String confer_abstract, String confer_abbreviate) {
		super();
		this.confer_id = confer_id;
		this.confer_name = confer_name;
		this.confer_class_id = confer_class_id;
		this.confer_date = confer_date;
		this.confer_location = confer_location;
		this.user_id = user_id;
		this.confer_abstract = confer_abstract;
		this.confer_abbreviate = confer_abbreviate;
	}

	@Override
	public String toString() {
		return "ConferInfoSimple" + " confer_id:" + confer_id + " confer_name:" + confer_name + " confer_class_id:"
				+ confer_class_id + " confer_date:" + confer_date + " confer_location:" + confer_location + " user_id:"
				+ user_id + " confer_abstract:" + confer_abstract + " confer_abbreviate:" + confer_abbreviate;
	}

}