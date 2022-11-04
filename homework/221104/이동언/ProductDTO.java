package com.test.mybatis;

public class ProductDTO {
	String name;
	int cnt;
	String productdt;
	
	public ProductDTO() {
		this.name ="";
		this.cnt = 0;
		this.productdt = "";
	}
	
	public ProductDTO(String name, int cnt, String productdt) {
		this.name = name;
		this.cnt = cnt;
		this.productdt = productdt;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getProductdt() {
		return productdt;
	}
	public void setProductdt(String productdt) {
		this.productdt = productdt;
	}
}
