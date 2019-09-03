package com.grade.web.serviceImpls;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.grade.web.daoImpls.GradeDaoImpl;
import com.grade.web.daoImpls.StudentDaoImpl;
import com.grade.web.daos.GradeDao;
import com.grade.web.daos.StudentDao;
import com.grade.web.studentBeans.GradeBean;
import com.grade.web.studentBeans.StudentBean;
import com.grade.web.studentServices.GradeService;

public class GradeServiceImpl implements GradeService {

	private GradeDao dao;
	private StudentDao sDao;
	
	public GradeServiceImpl() {
		dao = new GradeDaoImpl();
		sDao = new StudentDaoImpl();
	}
	
	@Override
	public void createGrade(GradeBean param) throws IOException {
		
		StudentBean sb = new StudentBean();
		
		sb = sDao.findStudent(param.getJubun());
		System.out.println(sb.toString());
		
		if (sb.getHacbun()==null) {
			String hb = makehacbun(param);
			param.setHacbun(hb);
			sb.setHacbun(hb);
			sb.setJubun(param.getJubun());
			sb.setName(param.getName());
			sDao.insertStudent(sb);
			
		}else {
			param.setHacbun(sb.getHacbun());
		}

		
		dao.insertGrade(param);
	}

	public String makehacbun(GradeBean param) {
		String result="";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		result += sdf.format(dt);
		result +="-"+param.getJubun().substring(6, 7);
		
		for (int i = 0; i < 3; i++) {
			result += (int)(Math.random()*10);
		}
		return result;
	}

	@Override
	public void readGrade(HttpServletRequest request, GradeBean param) throws IOException {
		System.out.println(param.getJubun()+"sdfadfasdf");
		StudentBean hb = sDao.findStudent(param.getJubun());
		System.out.println(hb.toString());
		param.setHacbun(hb.getHacbun());
		System.out.println(param.toString());
		request.setAttribute("student", dao.readeGrade(param));
		return ;
	}
	
	
	
}
