package org.dlut.sample.pojo.friendship;

import java.util.Date;

public class Messages {
	private Integer notice_id;
	private Integer get_user_id;
	private String text;
	private Date date;
	private Integer send_user_id;
	
	private Integer user_id;
	private String username;
    private String avatar;
    private String email;
    private String points;
    
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
	private Boolean follow;
    
	public Integer getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}
	public Integer getGet_user_id() {
		return get_user_id;
	}
	public void setGet_user_id(Integer get_user_id) {
		this.get_user_id = get_user_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getSend_user_id() {
		return send_user_id;
	}
	public void setSend_user_id(Integer send_user_id) {
		this.send_user_id = send_user_id;
	}
	
}
