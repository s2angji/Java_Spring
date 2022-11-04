package com.test.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertStudent(StudentDTO studentModel) {
		StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
		int n = mapper.insertStudent(studentModel);
		return n;
	}

	@Override
	public ArrayList<StudentDTO> selectStudent() {
		StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
		ArrayList<StudentDTO> arr = mapper.selectStudent();
		return arr;
	}

	@Override
	public ArrayList<StudentDTO> selectStudentOrder() {
		StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
		ArrayList<StudentDTO> arr = mapper.selectStudentOrder();
		return arr;
	}

	@Override
	public ArrayList<StudentDTO> selectStudentWhere(String name) {
		StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
		ArrayList<StudentDTO> arr = mapper.selectStudentWhere(name);
		return arr;
	}

	@Override
	public ArrayList<StudentDTO> selectStudentOr(HashMap<String, Object> arg) {
		StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
		ArrayList<StudentDTO> arr = mapper.selectStudentOr(arg);
		return arr;
	}
	
}
