package com.grade.web.daos;

import java.io.IOException;

import com.grade.web.domains.GradeBean;
import com.grade.web.domains.StudentBean;

public interface GradeDao {

public void insertGrade(GradeBean param);
public GradeBean[] readeGrade(GradeBean param) throws IOException;
}
