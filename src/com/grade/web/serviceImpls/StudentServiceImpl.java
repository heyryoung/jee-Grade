package com.grade.web.serviceImpls;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grade.web.daoImpls.StudentDaoImpl;
import com.grade.web.daos.StudentDao;
import com.grade.web.studentServices.StudentService;

public class StudentServiceImpl implements StudentService{
	private StudentDao sDao;
	
	public StudentServiceImpl() {
		sDao = new StudentDaoImpl();
	}
	
	@Override // 학번을 확인하여 성적을 읽는다.
	public void readAllStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("student", sDao.findAllStudent());
		return ;
	}
	

}
