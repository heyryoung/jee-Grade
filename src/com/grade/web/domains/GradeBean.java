package com.grade.web.domains;

import java.io.Serializable;

public class GradeBean implements Serializable{

	private static final long serialVersionID = 1L;
	
	private String hacbun="", jubun="", name="", kor="0", eng="0", math="0", soci="0";

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

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getSoci() {
		return soci;
	}

	public void setSoci(String soci) {
		this.soci = soci;
	}

	@Override
	public String toString() {
		return "StudentBean [hacbun=" + hacbun + ", jubun=" + jubun + ", name=" + name + ", kor=" + kor + ", eng=" + eng
				+ ", math=" + math + ", soci=" + soci + "]";
	} 
	
	
	
	
	
	
	
}
