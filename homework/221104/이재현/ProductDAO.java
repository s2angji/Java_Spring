package com.test.mybatis;

import java.util.ArrayList;
import java.util.Map;

public interface ProductDAO {
	
	ArrayList<ProductModel> selectProduct();
	
	ArrayList<ProductModel> searchProduct(String productName);
	
	int insertProduct(Map<String, Object> map);
}
