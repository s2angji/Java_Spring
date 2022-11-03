package test.model;

public class ProductDTO {

	String name;
	int cnt;
	String date;
	public ProductDTO(String name, int cnt, String date) {
		this.name = name;
		this.cnt = cnt;
		this.date = date;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
