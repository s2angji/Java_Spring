package com.test.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SqlSession sqlSession;	
	
	@Override
	public int insertProduct(ProductDTO ProductModel) {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		int n = mapper.insertProduct(ProductModel);
		return n;
	}

	@Override
	public ArrayList<ProductDTO> selectProduct() {
		// TODO Auto-generated method stub
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		ArrayList<ProductDTO>  arr = mapper.selectProduct();
		return arr;
	}
	
	@Override
	public ArrayList<ProductDTO> selectProductOr(HashMap<String, Object> arg) {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		ArrayList<ProductDTO>  arr = mapper.selectProductOr(arg);
		return arr;
	}	

}
