package com.test.mybatis;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertStudent(StudentDTO studentModel) {
		// TODO Auto-generated method stub
		StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
		int n = mapper.insertStudent(studentModel);
		return n;
	}

	@Override
	public ArrayList<StudentDTO> selectStudent() {
		// TODO Auto-generated method stub
		StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
		ArrayList<StudentDTO>  arr = mapper.selectStudent();
		return arr;
	}
}
