package com.test.mybatis;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<ProductDTO> select() {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		return mapper.select();
	}
	@Override
	public int insert(ProductDTO productDTO) {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		return mapper.insert(productDTO);
	}
//	public ArrayList<ProductDTO> selectsearch(); 
	
	
}
