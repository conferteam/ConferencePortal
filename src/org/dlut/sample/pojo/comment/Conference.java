package org.dlut.sample.pojo.comment;

import java.util.Date;

/**
 * 征稿启事信息
 * @author 
 *
 */
public class Conference {
	
	//会议缩写，由会议缩写和年份组�?
	private String confer_abbreviate;
	
	//会议ID
	private int conference_id;
	
	//会议名称
	private String conference_name;
	
	//会议类别
	private String conference_class;
	
	//会议�?��日期
	private Date conference_date;
	
	//征稿截止日期
	private Date paper_due;
	
	//会议召开地点
	private String conference_location;
	
	//会议网站
	private String conference_link;
	
	//会议�?��
	private String conference_abstract;
	
	//会议类别ID
	private Integer categories_id;
	
	//会议�?��的平均分
	private float confer_score;
	

	public String getConfer_abbreviate() {
		return confer_abbreviate;
	}

	public void setConfer_abbreviate(String confer_abbreviate) {
		this.confer_abbreviate = confer_abbreviate;
	}

	public int getConference_id() {
		return conference_id;
	}

	public void setConference_id(int conference_id) {
		this.conference_id = conference_id;
	}

	public String getConference_name() {
		return conference_name;
	}

	public void setConference_name(String conference_name) {
		this.conference_name = conference_name;
	}

	public String getConference_class() {
		return conference_class;
	}

	public void setConference_class(String conference_class) {
		this.conference_class = conference_class;
	}

	public Date getConference_date() {
		return conference_date;
	}

	public void setConference_date(Date conference_date) {
		this.conference_date = conference_date;
	}

	public Date getPaper_due() {
		return paper_due;
	}

	public void setPaper_due(Date paper_due) {
		this.paper_due = paper_due;
	}

	public String getConference_location() {
		return conference_location;
	}

	public void setConference_location(String conference_location) {
		this.conference_location = conference_location;
	}

	public String getConference_link() {
		return conference_link;
	}

	public void setConference_link(String conference_link) {
		this.conference_link = conference_link;
	}
	
	public String getConference_abstract() {
		return conference_abstract;
	}

	public void setConference_abstract(String conference_abstract) {
		this.conference_abstract = conference_abstract;
	}

	public Integer getCategories_id() {
		return categories_id;
	}

	public void setCategories_id(Integer categories_id) {
		this.categories_id = categories_id;
	}
	
	public float getConfer_score() {
		return confer_score;
	}

	public void setConfer_score(float confer_score) {
		this.confer_score = confer_score;
	}

	public Conference() {
		super();
	}

	
	public Conference(String confer_abbreviate, int conference_id,
			String conference_name, String conference_class,
			Date conference_date, Date paper_due, String conference_location,
			String conference_link, String conference_abstract,
			Integer categories_id) {
		super();
		this.confer_abbreviate = confer_abbreviate;
		this.conference_id = conference_id;
		this.conference_name = conference_name;
		this.conference_class = conference_class;
		this.conference_date = conference_date;
		this.paper_due = paper_due;
		this.conference_location = conference_location;
		this.conference_link = conference_link;
		this.conference_abstract = conference_abstract;
		this.categories_id = categories_id;
	}

	public Conference(String conference_name, Date conference_date,
			String conference_location, String conference_abstract, String conference_class) {
		super();
		this.conference_name = conference_name;
		this.conference_date = conference_date;
		this.conference_location = conference_location;
		this.conference_abstract = conference_abstract;
		this.conference_class = conference_class;
	}

	@Override
	public String toString() {
		return "Conference [confer_abbreviate=" + confer_abbreviate
				+ ", conference_id=" + conference_id + ", conference_name="
				+ conference_name + ", conference_class=" + conference_class
				+ ", conference_date=" + conference_date + ", paper_due="
				+ paper_due + ", conference_location=" + conference_location
				+ ", conference_link=" + conference_link
				+ ", conference_abstract=" + conference_abstract
				+ ", categories_id=" + categories_id + ", confer_score="
				+ confer_score + "]";
	}

	
	

}
