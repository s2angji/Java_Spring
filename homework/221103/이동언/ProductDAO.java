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
public class ProductDAO {

	@Autowired
	BasicDataSource dataSource;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public String insertProduct(String name, int cnt, String productday) {
		try {
			String sql = "insert into product values (?, ?, ?)";
			// dbpool에서 사용하지 않는 Connection Return
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, cnt);
			pstmt.setString(3, productday);
//			pstmt.execute();
			int nCnt = pstmt.executeUpdate(); // insert delete update -> 반영된 갯수 반환
			conn.close(); // dbpool에 컨넥션 반납
			return "추가성공: " + nCnt;
		} catch (Exception err) {
			return "추가실패: " + err.getMessage();
		}
	}
	
	public ArrayList<ProductDTO> selectProduct() {
		ArrayList<ProductDTO> arr = new ArrayList<>();
		try {
			String sql = "select * from product";
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("productNm");
				int cnt = rs.getInt("count");
				Date productday = rs.getDate("productDt");
				arr.add(new ProductDTO(name, cnt, productday.toString()));
			}
			rs.close();
			stmt.close();
			conn.close();
			return arr;
		} catch (Exception err) {
			return null;
		}
	}
}
