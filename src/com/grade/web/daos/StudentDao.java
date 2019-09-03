package com.grade.web.daos;

import java.io.IOException;

import com.grade.web.studentBeans.StudentBean;

public interface StudentDao {

	public void insertStudent(StudentBean param);
	public StudentBean[] findAllStudent() throws IOException ;
	public StudentBean findStudent(String jubun) throws IOException ;
}
