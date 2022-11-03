package test.model;

public class ProductDTO {
	String product_name;
	int product_ea;
	String product_date;
	
	public ProductDTO(String product_name, int product_ea, String product_date) {
		this.product_name = product_name;
		this.product_ea = product_ea;
		this.product_date = product_date;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_ea() {
		return product_ea;
	}

	public void setProduct_ea(int product_ea) {
		this.product_ea = product_ea;
	}

	public String getProduct_date() {
		return product_date;
	}

	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}
	
	
}
