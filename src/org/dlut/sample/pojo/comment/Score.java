package org.dlut.sample.pojo.comment;

import java.sql.Timestamp;

public class Score {
	private Integer user_id;
	private Integer confer_id;
	private Integer evaluation_score;
	private Integer score_times;
	private Timestamp confer_date;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public Integer getConfer_id() {
		return confer_id;
	}
	public void setConfer_id(Integer confer_id) {
		this.confer_id = confer_id;
	}
	public Integer getEvaluation_score() {
		return evaluation_score;
	}
	public void setEvaluation_score(Integer evaluation_score) {
		this.evaluation_score = evaluation_score;
	}
	public Integer getScore_times() {
		return score_times;
	}
	public void setScore_times(Integer score_times) {
		this.score_times = score_times;
	}

	
	public Timestamp getConfer_date() {
		return confer_date;
	}
	public void setConfer_date(Timestamp confer_date) {
		this.confer_date = confer_date;
	}
	public Score() {
		super();
	}
	public Score(Integer user_id, Integer confer_id, Integer evaluation_score,
			Integer score_times, Timestamp confer_date) {
		super();
		this.user_id = user_id;
		this.confer_id = confer_id;
		this.evaluation_score = evaluation_score;
		this.score_times = score_times;
		this.confer_date = confer_date;
	}
	@Override
	public String toString() {
		return "Score [user_id=" + user_id + ", confer_id=" + confer_id
				+ ", evaluation_score=" + evaluation_score + ", score_times="
				+ score_times + ", confer_date=" + confer_date + "]";
	}
		
}
