package com.grade.web.domains;

public class StudentBean {

	private String hacbun, jubun, name;

	public String getHacbun() {
		return hacbun;
	}

	public void setHacbun(String hacbun) {
		this.hacbun = hacbun;
	}

	public String getJubun() {
		return jubun;
	}

	public void setJubun(String jubun) {
		this.jubun = jubun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentBean [hacbun=" + hacbun + ", jubun=" + jubun + ", name=" + name + "]";
	}
	
	
	
}
