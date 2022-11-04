package com.test.mybatis;

import java.util.ArrayList;

public interface ProductDAO {
	public ArrayList<ProductDTO> select();
	public int insert(ProductDTO productDTO);
//	public ArrayList<ProductDTO> selectsearch(); 
}
