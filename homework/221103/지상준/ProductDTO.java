package test.model;

public class ProductDTO {
	String name;
	int num;
	String date;
	
	public ProductDTO(String name, int num, String date) {
		super();
		this.name = name;
		this.num = num;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
