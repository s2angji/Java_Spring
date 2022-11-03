package test.model;

import java.sql.Connection;
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

	public String insertProduct(String productName, int productCount, String productDate) {
		try {
			String sql = "insert into product values(?, ?, ?)";
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			pstmt.setInt(2, productCount);
			pstmt.setString(3, productDate);

			int nCnt = pstmt.executeUpdate();
			conn.close();
			return "추가성공 : " + nCnt;
		} catch (Exception e) {
			e.printStackTrace();
			return "추가 실패 : " + e.getMessage();
		}
	}

	public ArrayList<?> selectProduct() {
		ArrayList<ProductDTO> arr = new ArrayList<>();
		try {
			String sql = "select * from product";
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String productName = rs.getString("product_name");
				int productCount = rs.getInt("product_count");
				String productDate = String.valueOf(rs.getDate("product_date"));

				arr.add(new ProductDTO(productName, productCount, productDate));
			}
			rs.close();
			conn.close();
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
