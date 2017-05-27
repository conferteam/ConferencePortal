package org.dlut.sample.pojo.user;

public class UserInfoPages {
	private Integer pages;
	private Integer pagesend;
	private Integer id; //代表用户id
	
	public void setId(Integer id){
		this.id=id;
	}
	
	public Integer getId(){
		return id;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPagesend(Integer pagesend) {
		this.pagesend = pagesend;
	}

	public Integer getPagesend() {
		return pagesend;
	}

	public UserInfoPages() {
		super();
	}

	public UserInfoPages(Integer pages, Integer pagesend, Integer id) {
		super();
		this.pages = pages;
		this.pagesend = pagesend;
		this.id=id;
	}

	@Override
	public String toString() {
		return "User [pages" + pages+ "]";
	}

}