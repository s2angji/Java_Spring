package test.model;

import java.sql.*;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {

	@Autowired
	BasicDataSource dataSource;

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	public String insertProduct(String name, int num, String date) {

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("insert into products values(?, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setInt(2, num);
			pstmt.setString(3, date);
			int nCnt = pstmt.executeUpdate();
			conn.close();
			return "추가 성공: " + nCnt;
		} catch (Exception err) {
			return "추가 실패: " + err.getMessage();
		}
	}
	
	public ArrayList<ProductDTO> selectStudent() {
		
		ArrayList<ProductDTO> arr = new ArrayList<ProductDTO>();
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs= stmt.executeQuery("select * from products");

			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("num");
				Date birth = rs.getDate("date");
				arr.add(new ProductDTO(name, age, birth.toString()));
			}
			rs.close();
			conn.close();
			return arr;
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
}
