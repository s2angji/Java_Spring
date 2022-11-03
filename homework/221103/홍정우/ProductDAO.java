package test.model;

import java.sql.*;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductDAO 
{
	@Autowired
	BasicDataSource dataSource;
	
	Connection conn = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs = null;
	
	public String insertproduct(String name, int cnt, String birth)
	{
		try {
			String sql = "insert into product values(?,?,?)";
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setInt(2, cnt);
			pstmt.setString(3, birth);
			int nCnt = pstmt.executeUpdate(); //insert, delete, update
			conn.close();
			return "추가성공:"+nCnt;
		}catch( Exception err) {
			return "추가실패:"+err.getMessage();
		}		
	}
	public ArrayList<ProductDTO> selectProduct()
	{
		ArrayList<ProductDTO> arr = new ArrayList<>();
		try {
			String sql = "select * from product";
			Connection conn = dataSource.getConnection();
			stmt = conn.createStatement(); 
	        rs = stmt.executeQuery(sql); //select
	        while( rs.next())
	        {
	            String name = rs.getString("productName");
	            int cnt = rs.getInt("cnt");
	            Date birth = rs.getDate("date");
	            arr.add(new ProductDTO(name, cnt, String.valueOf(birth)));
	            
	        }
	        rs.close();
	        conn.close();
	        return arr;
		}catch( Exception err) {
			return null;
		}		
	}
	
}




