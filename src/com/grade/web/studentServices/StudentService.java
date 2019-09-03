package com.grade.web.studentServices;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface StudentService {

	void readAllStudent(HttpServletRequest request, HttpServletResponse response) throws IOException;

	
}
