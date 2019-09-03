package com.grade.web.studentServices;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.grade.web.domains.GradeBean;

public interface GradeService {

	public void createGrade(GradeBean param) throws IOException;
	
	void readGrade(HttpServletRequest request, GradeBean param) throws IOException;

	
}
