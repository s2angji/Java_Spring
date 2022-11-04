package com.test.mybatis;

import java.util.ArrayList;

public interface ProductDAO {
	public int insertProduct(ProductDTO studentModel);
	public ArrayList<ProductDTO> selectProduct();
	public ArrayList<ProductDTO> selectProductWhere(String name);
}
