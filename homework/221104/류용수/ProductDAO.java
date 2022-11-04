package com.test.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProductDAO {
	public int insertProduct( ProductDTO ProductModel);
	public ArrayList<ProductDTO> selectProduct();
	public ArrayList<ProductDTO> selectProductOr(HashMap<String, Object> arg);
}
