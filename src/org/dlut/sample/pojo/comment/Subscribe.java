package org.dlut.sample.pojo.comment;


public class Subscribe {
	
	private Integer subscribe_once_id;
	private Integer subscribe_long_id;
	private Integer confer_id;
	private Integer user_id;
	public Integer getSubscribe_once_id() {
		return subscribe_once_id;
	}
	public void setSubscribe_once_id(Integer subscribe_once_id) {
		this.subscribe_once_id = subscribe_once_id;
	}
	public Integer getSubscribe_long_id() {
		return subscribe_long_id;
	}
	public void setSubscribe_long_id(Integer subscribe_long_id) {
		this.subscribe_long_id = subscribe_long_id;
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
	
	public Subscribe() {
		super();
	}
	public Subscribe(Integer subscribe_once_id, Integer subscribe_long_id,
			Integer confer_id, Integer user_id) {
		super();
		this.subscribe_once_id = subscribe_once_id;
		this.subscribe_long_id = subscribe_long_id;
		this.confer_id = confer_id;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Subscribe [subscribe_once_id=" + subscribe_once_id
				+ ", subscribe_long_id=" + subscribe_long_id + ", confer_id="
				+ confer_id + ", user_id=" + user_id + "]";
	}
	
	
	
	
}
