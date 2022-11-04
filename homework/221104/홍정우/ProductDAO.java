package com.test.mybatis;

import java.util.ArrayList;

public interface ProductDAO {
	public int insertProduct(ProductDTO productDTO);
	public ArrayList<ProductDTO> selectProduct();
	public ArrayList<ProductDTO> selectOneProduct(String productName);
	
	
}
