package com.test.mybatis;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<ProductModel> selectProduct() {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		ArrayList<ProductModel> list = mapper.selectProduct();
		return list;
	}

	@Override
	public ArrayList<ProductModel> searchProduct(String productName) {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		ArrayList<ProductModel> list = mapper.searchProduct(productName);
		return list;
	}

	@Override
	public int insertProduct(Map<String, Object> map) {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		int n = mapper.insertProduct(map);
		return n;
	}

}
