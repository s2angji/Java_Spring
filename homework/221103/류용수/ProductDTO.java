package test.model;

public class ProductDTO {
	String pname;
	int pnum;
	String pdate;
	public ProductDTO(String pname, int pnum, String pdate) {
		this.pname = pname;
		this.pnum = pnum;
		this.pdate = pdate;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
	
}
