package test.model;

public class ProductDTO {
	String name;
	int cnt;
	String productday;
	
	public ProductDTO(String name, int cnt, String productday) {
		this.name = name;
		this.cnt = cnt;
		this.productday = productday;
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

	public String getProductday() {
		return productday;
	}

	public void setProductday(String productday) {
		this.productday = productday;
	}
	
}
