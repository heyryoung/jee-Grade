package com.grade.web.daoImpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.grade.web.daos.StudentDao;
import com.grade.web.domains.StudentBean;

public class StudentDaoImpl implements StudentDao{
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
	public void insertStudent(StudentBean param) {
		
		try {
			File file = new File(FILE_PATH+"Student.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(String.format("%s,%s,%s", param.getHacbun(),param.getJubun(),param.getName()));
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public StudentBean[] findAllStudent() throws IOException {
		
		StudentBean[] params = new StudentBean[10];
		String str = "";
		File file = new File(FILE_PATH+"Student.txt");
		int cnt=0;
		if (file.exists()) {
			FileReader in = new FileReader(file);
			BufferedReader br = new BufferedReader(in);
			String line="";
			String[] temp = new String[3];
			while ((line = br.readLine()) !=null) {
				StudentBean sb = new StudentBean();
				temp = line.split(",");
				sb.setHacbun(temp[0]);
				sb.setJubun(temp[1]);
				sb.setName(temp[2]);
				params[cnt] = sb;
				cnt++;
			}
			br.close();
		}
		
		StudentBean[] newParams = new StudentBean[cnt];
		
		for (int i = 0; i < newParams.length; i++) {
			newParams[i] = params[i];
		}
		
		return newParams;
	}
	
	
	
	public StudentBean findStudent(String jubun) throws IOException {
		
		StudentBean params = new StudentBean();
		String str = "";
		File file = new File(FILE_PATH+"Student.txt");
		
		if (file.exists()) {
			FileReader in = new FileReader(file);
			BufferedReader br = new BufferedReader(in);
			String line="";
			String[] temp = new String[3];
			while ((line = br.readLine()) !=null) {
				temp = line.split(",");
				if (jubun.equals(temp[1])) {
					params.setHacbun(temp[0]);
					params.setJubun(temp[1]);
					params.setName(temp[2]);
					break;
				}
			}
			br.close();
		}
		return params;
	}
	
	
	
	
	
}
