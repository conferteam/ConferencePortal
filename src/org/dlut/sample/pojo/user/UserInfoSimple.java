package org.dlut.sample.pojo.user;

public class UserInfoSimple {
	private Integer id;
	private String email;
	private String username;
	private String password;
	private Integer points;
	private Integer follow;

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

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getFollow() {
		return follow;
	}

	public void setFollow(Integer follow) {
		this.follow = follow;
	}

	public UserInfoSimple() {
		super();
	}

	public UserInfoSimple(Integer id, String email, String username, String password) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.points = 0;
		this.follow = 0;
	}

	public UserInfoSimple(String email, String username, String password) {
		super();
		this.email=email;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ",username=" + username + ", password=" + password + ", points="
				+ points + ", follow=" + follow + "]";
	}

}