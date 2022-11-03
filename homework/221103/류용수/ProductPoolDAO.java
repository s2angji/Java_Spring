package test.model;

import java.sql.*;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductPoolDAO 
{
	@Autowired
	BasicDataSource dataSource;
	
	Connection conn = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs = null;
	
	public String insertProduct(String pname, int pnum, String pdate)
	{
		try {
			String sql = "insert into product values(?,?,?)";
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,pname);
			pstmt.setInt(2, pnum);
			pstmt.setString(3, pdate);
			int nCnt = pstmt.executeUpdate(); //insert, delete, update
			conn.close();
			return "추가성공:"+nCnt;
		}catch( Exception err) {
			return "추가실패:"+err.getMessage();
		}		
	}
	
	public ArrayList<ProductDTO> selectProduct()
	{
		ArrayList<ProductDTO> arr = new ArrayList<ProductDTO>();
		   try{
		        String sql ="select * from product";
		        Connection conn = dataSource.getConnection();
				stmt = conn.createStatement();  
		        rs= stmt.executeQuery(sql); //select
		        while( rs.next())
		        {
		            String pname = rs.getString("productname");
		            int pnum = rs.getInt("productnmb");
		            Date pdate = rs.getDate("productdate");		           
		            arr.add( new ProductDTO(pname, pnum, pdate.toString() ) );
		        }
		        rs.close();
		        conn.close();
		        return arr;
		    }catch( Exception ex){
		    	System.out.println("select error:"+ex.getMessage());
		    	return null;
		    }		
	}	
	
}




