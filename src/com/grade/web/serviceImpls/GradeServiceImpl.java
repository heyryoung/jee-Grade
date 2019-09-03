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
		
		sb = sDao.findStudent(param.getJubun()); // Student.txt에서 학생이 존재하는지 찾는다.
		
		//학생이 명부에 없다면, 학번을 생성하고 명부에 입력한다.
		if (sb.getHacbun()==null) {
			String hb = makehacbun(param);
			param.setHacbun(hb);
			sb.setHacbun(hb);
			sb.setJubun(param.getJubun());
			sb.setName(param.getName());
			sDao.insertStudent(sb);
			
		}else {
			//학생이 명부에 있다면 param에 학번을 set한다.
			param.setHacbun(sb.getHacbun());
		}

		//학생의 성적을 각 학생의 성적표에 입력한다.
		dao.insertGrade(param);
	}

	//학번을 생성한다.
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

	@Override // 학번을 확인하여 성적을 읽는다
	public void readGrade(HttpServletRequest request, GradeBean param) throws IOException {
		StudentBean hb = sDao.findStudent(request.getParameter("jubun"));
		param.setHacbun(hb.getHacbun());
		request.setAttribute("student", dao.readeGrade(param));
		return ;
	}
	
	
	
}
