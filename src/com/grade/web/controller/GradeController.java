package com.grade.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grade.web.daoImpls.StudentDaoImpl;
import com.grade.web.daos.StudentDao;
import com.grade.web.serviceImpls.GradeServiceImpl;
import com.grade.web.serviceImpls.StudentServiceImpl;
import com.grade.web.studentBeans.GradeBean;
import com.grade.web.studentServices.GradeService;
import com.grade.web.studentServices.StudentService;

@WebServlet("*.do")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 진입."); 

		actionDo(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 진입./////"); 
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("EUC-KR");
		
		GradeBean param = new GradeBean();
		param.setJubun(request.getParameter("jubun"));
		param.setName(request.getParameter("name")); 
		param.setKor(request.getParameter("kor"));
		param.setEng(request.getParameter("eng"));
		param.setMath(request.getParameter("math"));
		param.setSoci(request.getParameter("soci"));
		
		String viewPage = null;
		GradeService gs = new GradeServiceImpl();
		StudentService ss = new StudentServiceImpl();
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/write.do")) {
			gs = new GradeServiceImpl();
			gs.createGrade(param);
			viewPage = "/gradeScore.do";
		} else if(com.equals("/gradeScore.do")) {
			gs = new GradeServiceImpl();
			gs.readGrade(request,param);
			viewPage = "gradeScore.jsp";
		} else if(com.equals("/studentList.do")) {
			ss = new StudentServiceImpl();
			ss.readAllStudent(request,response);
			viewPage = "studentList.jsp";
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
	
}
