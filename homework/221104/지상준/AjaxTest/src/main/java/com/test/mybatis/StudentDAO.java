package com.test.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

public interface StudentDAO {
	public int insertStudent(StudentDTO studentModel);
	public ArrayList<StudentDTO> selectStudent();
	public ArrayList<StudentDTO> selectStudentOrder();
	public ArrayList<StudentDTO> selectStudentWhere(String name);
	public ArrayList<StudentDTO> selectStudentOr(HashMap<String, Object> arg);
}
