package com.test.mybatis;

public class ProductDTO {
	String product;
	int count;
	String date;

	public ProductDTO(String product, int count, String date) {
		this.product = product;
		this.count = count;
		this.date = date;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
