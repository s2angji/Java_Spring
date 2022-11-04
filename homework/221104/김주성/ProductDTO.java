package com.test.mybatis;

public class ProductDTO {
	
	String name;
	int count;
	String createDate;

	public ProductDTO() {
		// TODO Auto-generated constructor stub
		this.name = "";
		this.count = 0;
		this.createDate ="";
	}
	

	public ProductDTO(String name, int count, String createDate) {

		this.name = name;
		this.count = count;
		this.createDate = createDate;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	

}
