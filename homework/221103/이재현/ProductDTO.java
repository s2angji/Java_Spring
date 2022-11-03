package test.model;

public class ProductDTO {

	private String productName;
	private int productCount;
	private String productDate;

	public ProductDTO(String productName, int productCount, String productDate) {
		this.productName = productName;
		this.productCount = productCount;
		this.productDate = productDate;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

}
