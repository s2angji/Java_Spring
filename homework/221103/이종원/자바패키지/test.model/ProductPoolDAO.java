package test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public String insertProduct(String product_name, int product_ea, String product_date) {
		try {
			conn = dataSource.getConnection();			
			String sql = "insert into product (product_name,product_ea,product_date) values (?,?,?)";		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_name);
			pstmt.setInt(2, product_ea);
			pstmt.setString(3,product_date);			
			int nCnt = pstmt.executeUpdate(); // pstmt.execute()보다 더성능이 낫다. 반영된 갯수를 int로 리턴
			
			conn.close(); // dbpool 에 connection 반납
			
			return "추가성공 " + nCnt + "개";
			
		} catch (SQLException e) {
			return "추가실패 "+ e.getMessage();
		}		
	}	
	
	
	public ArrayList<ProductDTO> selectProduct() {
		ArrayList<ProductDTO> arr = new ArrayList<ProductDTO>();
		
	    try{
	        conn = dataSource.getConnection();	
	        String sql ="select * from product";	        
			stmt = conn.createStatement();  
	        rs= stmt.executeQuery(sql); //select
	        while( rs.next())
	        {
	            String product_name = rs.getString("product_name");
	            int product_ea = rs.getInt("product_ea");
	            String product_date = rs.getString("product_date");
	            arr.add(new ProductDTO(product_name,product_ea,product_date));
	            
	        }
	        rs.close();
	        conn.close();
	        return arr;
	    }catch( Exception ex){
	    	//System.out.println("selectStudent() 에러 : " + ex.getMessage() );
	    	return null;
	    }		
		
	}
}
