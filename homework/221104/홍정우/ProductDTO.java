package com.test.mybatis;

public class ProductDTO {
	String productName;
	int cnt;
	String date;

	public ProductDTO(String productName, int cnt, String date) {
		super();
		this.productName = productName;
		this.cnt = cnt;
		this.date = date;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
