package test.model;

public class ProductDTO {
	String name;
	int cnt;
	String birth;
	
	
	public ProductDTO(String name, int cnt, String birth) {
		this.name = name;
		this.cnt = cnt;
		this.birth = birth;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
}
