package com.test.mybatis;

import java.util.ArrayList;

public interface StudentDAO {
	public int insertStudent( StudentDTO studentModel);
	public ArrayList<StudentDTO> selectStudent();
}
