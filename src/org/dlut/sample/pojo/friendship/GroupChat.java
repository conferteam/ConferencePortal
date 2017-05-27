package org.dlut.sample.pojo.friendship;

import java.util.Date;

public class GroupChat {
	private Integer notice_id;
	private Integer confer_id;
	private Integer user_id;
	private Date date;
	private String text;
	
    private String username;
    private String avatar;
    private String email;
    private String points;
    private Boolean follow;
    
	public Integer getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}
	public Integer getConfer_id() {
		return confer_id;
	}
	public void setConfer_id(Integer confer_id) {
		this.confer_id = confer_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public Boolean getFollow() {
		return follow;
	}
	public void setFollow(Boolean follow) {
		this.follow = follow;
	}
    
}
