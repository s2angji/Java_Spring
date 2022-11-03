package test.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductPoolDAO {

	@Autowired
	BasicDataSource dataSource;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public String insertProduct(String productName, int productCount, String productionDate) {
		try {
			String sql = "insert into product values(?, ?, ?)";
			Connection conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			pstmt.setInt(2, productCount);
			pstmt.setString(3, productionDate);
			int nCnt = pstmt.executeUpdate();
			conn.close();
			return "추가성공 : " + nCnt;
		} catch (Exception err) {
			return "추가실패 : " + err.getMessage();
		}
	}
	
	public ArrayList<ProductDTO> selectProduct() {
		ArrayList<ProductDTO> arr = new ArrayList<>();
		
		try {
			String sql = "select * from product";
			Connection conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
	        {
	            String name = rs.getString("name");
	            int count = rs.getInt("count");
	            Date pdate = rs.getDate("pdate");
	            arr.add(new ProductDTO(name, count, pdate.toString()));
	        }
	        rs.close();
	        conn.close();
			return arr;
		} catch (Exception err) {
			return null;
		}
	}
	
}
