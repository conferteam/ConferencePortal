package org.dlut.sample.pojo.user;

public class ProblemAnswer {
	private Integer id;
	private String email;
	private String problem;
	private String answer;

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

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public ProblemAnswer() {
		super();
	}

	public ProblemAnswer(Integer id, String email, String problem, String answer) {
		super();
		this.id = id;
		this.email = email;
		this.problem = problem;
		this.answer = answer;
	}

	public ProblemAnswer(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ",problem=" + problem + ", answer=" + answer + "]";
	}

}