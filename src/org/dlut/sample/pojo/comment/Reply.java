package org.dlut.sample.pojo.comment;

import java.sql.Timestamp;

public class Reply {
	private Integer reply_id;
	private Integer evaluation_id;
	private Integer from_id;
	private Integer to_id;
	private String fromname;
	private String toname;
	private String content;
	private Timestamp reply_date;
	private Integer confer_id;
	public Integer getConfer_id() {
		return confer_id;
	}
	public void setConfer_id(Integer confer_id) {
		this.confer_id = confer_id;
	}
	public Integer getReply_id() {
		return reply_id;
	}
	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}
	public Integer getEvaluation_id() {
		return evaluation_id;
	}
	public void setEvaluation_id(Integer evaluation_id) {
		this.evaluation_id = evaluation_id;
	}
	public Integer getFrom_id() {
		return from_id;
	}
	public void setFrom_id(Integer from_id) {
		this.from_id = from_id;
	}
	public Integer getTo_id() {
		return to_id;
	}
	public void setTo_id(Integer to_id) {
		this.to_id = to_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getReply_date() {
		return reply_date;
	}
	public void setReply_date(Timestamp reply_date) {
		this.reply_date = reply_date;
	}
	
	public String getFromname() {
		return fromname;
	}
	public void setFromname(String fromname) {
		this.fromname = fromname;
	}
	public String getToname() {
		return toname;
	}
	public void setToname(String toname) {
		this.toname = toname;
	}
	public Reply() {
		super();
	}

	public Reply(Integer reply_id, Integer evaluation_id, Integer from_id,
			Integer to_id, String fromname, String toname, String content,
			Timestamp reply_date) {
		super();
		this.reply_id = reply_id;
		this.evaluation_id = evaluation_id;
		this.from_id = from_id;
		this.to_id = to_id;
		this.fromname = fromname;
		this.toname = toname;
		this.content = content;
		this.reply_date = reply_date;
	}
	@Override
	public String toString() {
		return "{'reply_id':" + reply_id + ", 'evaluation_id':"
				+ evaluation_id + ", 'from_id':" + from_id + ", 'to_id':" + to_id
				+ ", 'fromname':'" + fromname + "', 'toname':'" + toname
				+ "', 'content':'" + content + "', 'reply_date':'" + reply_date + "'}";
	}
}
