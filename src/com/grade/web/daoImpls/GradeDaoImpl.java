package com.grade.web.daoImpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import com.grade.web.daos.GradeDao;
import com.grade.web.domains.GradeBean;
import com.grade.web.domains.StudentBean;

public class GradeDaoImpl implements GradeDao {

	public static final String FILE_PATH = String.format("C:%sUsers%suser%seclipse-jee%sjee-grade%sWebContent%sresources%stxt%s",
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator);

	
	
	@Override
	public void insertGrade(GradeBean param) {
		//각 학생의 학번에 학생의 성적을 입력한다.
		try {
			File file = new File(FILE_PATH+param.getHacbun()+".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(String.format("%s,%s,%s,%s,%s,%s,%s", param.getHacbun(),param.getJubun(),param.getName(),param.getKor(),param.getEng(),param.getMath(),param.getSoci()));
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public GradeBean[] readeGrade(GradeBean param) throws IOException {
		
		//학생의 모든 성적을 읽어 반환한다.
		GradeBean[] params = new GradeBean[12];
		String str = "";
		File file = new File(FILE_PATH+param.getHacbun()+".txt");
		int cnt=0;
		if (file.exists()) {
			FileReader in = new FileReader(file);
			BufferedReader br = new BufferedReader(in);
			String line="";

			String[] temp = new String[7];
			while ((line = br.readLine()) !=null) {
				GradeBean pr = new GradeBean();
				temp = line.split(",");
				pr.setHacbun(temp[0]);
				pr.setJubun(temp[1]);
				pr.setName(temp[2]);
				pr.setKor(temp[3]);
				pr.setEng(temp[4]);
				pr.setMath(temp[5]);
				pr.setSoci(temp[6]);
				params[cnt] = pr;
				cnt++;
			}
			br.close();
		}
		
		// 성적이 입력되지 않은 학생은 디폴트 값을 넣어주기 위해 객체를 주입한다.
		for (int i = cnt; i < 12; i++) {
			params[i] = new GradeBean();
		}
		
		return params;
	}
	

	
}
