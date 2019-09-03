package com.grade.web.studentServices;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.grade.web.studentBeans.GradeBean;

public interface GradeService {

	public void createGrade(GradeBean param) throws IOException;
	
	void readGrade(HttpServletRequest request, GradeBean param) throws IOException;

	
}
