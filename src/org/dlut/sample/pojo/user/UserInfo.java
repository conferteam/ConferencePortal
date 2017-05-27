package org.dlut.sample.pojo.user;

public class UserInfo {
	private Integer id;
	private String email;
	private String username;
	private String oldpassword;
	private String password;
	private String avatar;
	private Integer points;
	private Integer follow;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public Integer getFollow() {
		return follow;
	}

	public void setFollow(int follow) {
		this.follow = follow;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(Integer id, String email, String username, String password, String oldpassword, Integer follow,
			Integer points, String avatar) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.follow = follow;
		this.oldpassword = oldpassword;
		this.points = points;
		this.avatar = avatar;
	}

	public UserInfo(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ",username=" + username + ", password=" + password
				+ ", oldpassword=" + oldpassword + ", follow=" + follow + ", points=" + points + ", avatar=" + avatar
				+ "]";
	}

}