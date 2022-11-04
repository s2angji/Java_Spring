package com.test.mybatis;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertProduct(ProductDTO productDTO) {
		
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		int n = mapper.insertProduct(productDTO);
		return n;
	}


	@Override
	public ArrayList<ProductDTO> selectProduct() {
		// TODO Auto-generated method stub
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		ArrayList<ProductDTO>  arr = mapper.selectProduct();
		return arr;
	}

	
	
}
