package com.test.mybatis;

public class ProductDTO {

	String name;
	int count;
	String pdate;

	public ProductDTO(String name, int count, String pdate) {
		this.name = name;
		this.count = count;
		this.pdate = pdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
}
