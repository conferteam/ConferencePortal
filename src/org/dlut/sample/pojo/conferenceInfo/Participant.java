package org.dlut.sample.pojo.conferenceInfo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 参会启事
 * @author vipga
 *
 */
public class Participant {

	//参会启事ID
	private int participant_id;
	
	//会议缩写,会议缩写和年份组成
	private String confer_abbreviate;
	
	//会议ID
	private int conference_id;
	
	//会议名称
	private String conference_name;
	
	//会议类别
	private String conference_class;
	
	//会议开始日期
	private Timestamp conference_date;
	
	//会议门票价格
	private BigDecimal conference_fare;
	
	//会议召开地点
	private String conference_location;
	
	//会议网站
	private String conference_link;
	
	public int getParticipant_id() {
		return participant_id;
	}

	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}

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

	public Timestamp getConference_date() {
		return conference_date;
	}

	public void setConference_date(Timestamp conference_date) {
		this.conference_date = conference_date;
	}

	public BigDecimal getConference_fare() {
		return conference_fare;
	}

	public void setConference_fare(BigDecimal conference_fare) {
		this.conference_fare = conference_fare;
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

	public Participant() {
		super();
	}
	
	public Participant(int participant_id, String confer_abbreviate,
			int conference_id, String conference_name, String conference_class,
			Timestamp conference_date, BigDecimal conference_fare,
			String conference_location, String conference_link) {
		super();
		this.participant_id = participant_id;
		this.confer_abbreviate = confer_abbreviate;
		this.conference_id = conference_id;
		this.conference_name = conference_name;
		this.conference_class = conference_class;
		this.conference_date = conference_date;
		this.conference_fare = conference_fare;
		this.conference_location = conference_location;
		this.conference_link = conference_link;
	}

	@Override
	public String toString() {
		return "Participant [participant_id=" + participant_id
				+ ", confer_abbreviate=" + confer_abbreviate
				+ ", conference_id=" + conference_id + ", conference_name="
				+ conference_name + ", conference_class=" + conference_class
				+ ", conference_date=" + conference_date + ", conference_fare="
				+ conference_fare + ", conference_location="
				+ conference_location + ", conference_link=" + conference_link
				+ "]";
	}
	
	
	
	
}
