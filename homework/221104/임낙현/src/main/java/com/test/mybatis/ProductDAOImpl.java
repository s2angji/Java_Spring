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
	public int insertProduct(ProductDTO productModel) {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		int n = mapper.insertProduct(productModel);
		return n;
	}

	@Override
	public ArrayList<ProductDTO> selectProduct() {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		ArrayList<ProductDTO> arr = mapper.selectProduct();
		return arr;
	}

	@Override
	public ArrayList<ProductDTO> selectProductWhere(String name) {
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		ArrayList<ProductDTO> arr = mapper.selectProductWhere(name);
		return arr;
	}

	
}
