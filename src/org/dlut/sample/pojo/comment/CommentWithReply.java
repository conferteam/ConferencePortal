package org.dlut.sample.pojo.comment;

import java.sql.Timestamp;
import java.util.List;

public class CommentWithReply {

	private Integer evaluation_id;
    private Integer user_id;
    private String username;
    private Integer score;
    private String text_evaluation;
    private Timestamp evaluation_Time;
    private Integer confer_id;
    private String avatar;
    private List<Reply> reply_of_comment;
    
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

	public List<Reply> getReply_of_comment() {
		return reply_of_comment;
	}

	public void setReply_of_comment(List<Reply> reply_of_comment) {
		this.reply_of_comment = reply_of_comment;
	}

	public CommentWithReply() {
		super();
	}

	public CommentWithReply(Integer evaluation_id, Integer user_id,
			Integer score, String text_evaluation, Timestamp evaluation_Time,
			Integer confer_id, String avatar, List<Reply> reply_of_comment) {
		super();
		this.evaluation_id = evaluation_id;
		this.user_id = user_id;
		this.score = score;
		this.text_evaluation = text_evaluation;
		this.evaluation_Time = evaluation_Time;
		this.confer_id = confer_id;
		this.avatar = avatar;
		this.reply_of_comment = reply_of_comment;
	}
	
	public CommentWithReply(Comment comment,List<Reply> replyList)
	{
		super();
		this.evaluation_id = comment.getEvaluation_id();
		this.user_id = comment.getUser_id();
		this.username=comment.getUsername();
		this.score = comment.getScore();
		this.text_evaluation = comment.getText_evaluation();
		this.evaluation_Time = comment.getEvaluation_Time();
		this.confer_id = comment.getConfer_id();
		this.avatar = comment.getAvatar();
		this.reply_of_comment = replyList;
	}
	
	public CommentWithReply(Integer evaluation_id, Integer user_id,
			String username, Integer score, String text_evaluation,
			Timestamp evaluation_Time, Integer confer_id, String avatar,
			List<Reply> reply_of_comment) {
		super();
		this.evaluation_id = evaluation_id;
		this.user_id = user_id;
		this.username = username;
		this.score = score;
		this.text_evaluation = text_evaluation;
		this.evaluation_Time = evaluation_Time;
		this.confer_id = confer_id;
		this.avatar = avatar;
		this.reply_of_comment = reply_of_comment;
	}

	@Override
	public String toString() {
		return "CommentWithReply [evaluation_id=" + evaluation_id
				+ ", user_id=" + user_id + ", username=" + username
				+ ", score=" + score + ", text_evaluation=" + text_evaluation
				+ ", evaluation_Time=" + evaluation_Time + ", confer_id="
				+ confer_id + ", avatar=" + avatar + ", reply_of_comment="
				+ reply_of_comment + "]";
	}

}