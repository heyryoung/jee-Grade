package com.grade.web.serviceImpls;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grade.web.daoImpls.GradeDaoImpl;
import com.grade.web.daoImpls.StudentDaoImpl;
import com.grade.web.daos.GradeDao;
import com.grade.web.daos.StudentDao;
import com.grade.web.domains.GradeBean;
import com.grade.web.domains.StudentBean;
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
	
	
	//모든 학생의 모든 학기 성적을 불러와 학기별 등수를 계산하여 1차원 배열에 순서대로 입력함.
	public void calGrade(HttpServletRequest request, HttpServletResponse respones) throws IOException {
		StudentBean[] allStudent = sDao.findAllStudent();
		GradeBean[][]  tempAllGrade = new  GradeBean[allStudent.length][12];
		GradeBean[] tempGrade = new GradeBean[12]; 
		int[][]  tempAllScores = new  int[allStudent.length][12];
		int gradeLength = (allStudent.length*12);
		GradeBean[] allStudentsGrade = new GradeBean[gradeLength];

		int allCnt=0;
		
		// 학생의 성적을 모두 받아옴
		for (int i = 0; i < allStudent.length; i++) {
			GradeBean temp = new GradeBean();
			temp.setHacbun(allStudent[i].getHacbun());
			tempGrade = dao.readeGrade(temp);
			for (int j = 0; j <12; j++) {
				tempAllGrade[i][j]= tempGrade[j];
			}
		} 
		
		for (int i = 0; i < allStudent.length; i++) {
			for (int j = 0; j < 12; j++) {

				tempAllScores[i][j] = Integer.parseInt(tempAllGrade[i][j].getKor()) + Integer.parseInt(tempAllGrade[i][j].getEng()) +Integer.parseInt(tempAllGrade[i][j].getMath()) + Integer.parseInt(tempAllGrade[i][j].getSoci());
			}
		}
		System.out.println("Rmx");
		
	//학기 수 만큼 비교 해야함. 	
	for (int cnt = 0; cnt < 12; cnt++) {
		
		//학기 별 학생 성적 비교 
		for (int i = 0; i < allStudent.length-1; i++) {
			for (int j =  i+1; j < allStudent.length; j++) {
				if (tempAllScores[i][cnt] < tempAllScores[j][cnt]  ) {
					GradeBean  temp = new GradeBean();
					temp = tempAllGrade[i][cnt] ;
					tempAllGrade[i][cnt]  = tempAllGrade[j][cnt] ; 
					tempAllGrade[j][cnt]  = temp;
				}
			}
		}
	}	
	
	
	//비교 후 1차원 배열에 입력함.
	for (int cnt = 0; cnt < 12; cnt++) {
	for (int c=0; c < allStudent.length; c++ ) {
		allStudentsGrade[allCnt] = tempAllGrade[c][cnt];
		if (gradeLength == allCnt) {
			break;
		}
		allCnt++;
		}
	}
	
		request.setAttribute("studentLength", allStudent.length);
		request.setAttribute("student", allStudentsGrade);
		return ;
	}
	
}
