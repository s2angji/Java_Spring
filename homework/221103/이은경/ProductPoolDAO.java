package test.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductPoolDAO 
{
	@Autowired
	BasicDataSource dataSource;
	
	Connection conn = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs = null;
	
	public String insertProduct(String name, int cnt, String date)
	{
		try {
			String sql = "insert into product values(?,?,?)";
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setInt(2, cnt);
			pstmt.setString(3, date);
			int nCnt = pstmt.executeUpdate();
			conn.close();
			return "추가성공:"+nCnt;
		}catch( Exception err) {
			return "추가실패:"+err.getMessage();
		}		
	}

	public ArrayList<ProductDTO> selectProduct() {
		ArrayList<ProductDTO> arr = new ArrayList();
		   try{
		        String sql ="select * from product";
		    	Connection conn = dataSource.getConnection();
				stmt = conn.createStatement();  
		        rs= stmt.executeQuery(sql); //select
		        while( rs.next())
		        {
		            String name = rs.getString("name");
		            int cnt = rs.getInt("cnt");
		            Date date = rs.getDate("date");
		            arr.add(new ProductDTO(name, cnt, date.toString()));
		        }
		        rs.close();
		        conn.close();
		        
		        return arr;
		    }catch( Exception ex){
		    	return null;
		    }		
	}
}
