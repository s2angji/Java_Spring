package test.model;

import java.sql.*;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentPoolDAO {
	
	@Autowired
	BasicDataSource dataSource;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	
	public String insertStudent(String name, int age, String birth) {
		
		try {
			String sql = "insert into student values(?,?,?)";
			Connection conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, birth);
			int nCnt = pstmt.executeUpdate(); // executeUpdate() insert, delete, update 반영된 갯수를 반환함
			conn.close(); // dbpool로 connection 반납
			return "추가 성공: " + nCnt;
		} catch (Exception err) {
			return "추가 실패: " + err.getMessage();
		}
	}
	
}
