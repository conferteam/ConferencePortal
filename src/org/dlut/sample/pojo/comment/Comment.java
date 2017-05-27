package org.dlut.sample.pojo.comment;

import java.sql.Timestamp;

public class Comment {

	private Integer evaluation_id;
    private Integer user_id;
    private String username;
    private Integer score;
    private String text_evaluation;
    private Timestamp evaluation_Time;
    private Integer confer_id;
    private String avatar;
	public Integer getEvaluation_id() {
		return evaluation_id;
	}

	public void setEvaluation_id(Integer evaluation_id) {
		this.evaluation_id = evaluation_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getText_evaluation() {
		return text_evaluation;
	}

	public void setText_evaluation(String text_evaluation) {
		this.text_evaluation = text_evaluation;
	}

	public Timestamp getEvaluation_Time() {
		return evaluation_Time;
	}

	public void setEvaluation_Time(Timestamp evaluation_Time) {
		this.evaluation_Time = evaluation_Time;
	}

	public Integer getConfer_id() {
		return confer_id;
	}

	public void setConfer_id(Integer confer_id) {
		this.confer_id = confer_id;
	}
	
    public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Comment(Integer evaluation_id, Integer user_id, Integer score,
			String text_evaluation, Timestamp evaluation_Time,
			Integer confer_id) {
		super();
		this.evaluation_id = evaluation_id;
		this.user_id = user_id;
		this.score = score;
		this.text_evaluation = text_evaluation;
		this.evaluation_Time = evaluation_Time;
		this.confer_id = confer_id;
	}

	public Comment(Integer evaluation_id, Integer user_id, Integer score,
			String text_evaluation, Timestamp evaluation_Time,
			Integer confer_id, String avatar) {
		super();
		this.evaluation_id = evaluation_id;
		this.user_id = user_id;
		this.score = score;
		this.text_evaluation = text_evaluation;
		this.evaluation_Time = evaluation_Time;
		this.confer_id = confer_id;
		this.avatar = avatar;
	}

	public Comment(Integer evaluation_id, Integer user_id, String username,
			Integer score, String text_evaluation, Timestamp evaluation_Time,
			Integer confer_id, String avatar) {
		super();
		this.evaluation_id = evaluation_id;
		this.user_id = user_id;
		this.username = username;
		this.score = score;
		this.text_evaluation = text_evaluation;
		this.evaluation_Time = evaluation_Time;
		this.confer_id = confer_id;
		this.avatar = avatar;
	}

	public Comment() {
		super();
	}

	@Override
	public String toString() {
		return "Comment [evaluation_id=" + evaluation_id + ", user_id="
				+ user_id + ", username=" + username + ", score=" + score
				+ ", text_evaluation=" + text_evaluation + ", evaluation_Time="
				+ evaluation_Time + ", confer_id=" + confer_id + ", avatar="
				+ avatar + "]";
	}
}
