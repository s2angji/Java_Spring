package test.model;

import java.sql.*;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentPoolDAO 
{
	@Autowired
	BasicDataSource dataSource;
	
	Connection conn = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	
	public String insertStudent(String name, int age, String birth)
	{
		try {
			String sql = "insert into student values(?,?,?)";
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setInt(2, age);
			pstmt.setString(3, birth);
			int nCnt = pstmt.executeUpdate(); //insert, delete, update
			conn.close();
			return "추가성공:"+nCnt;
		}catch( Exception err) {
			return "추가실패:"+err.getMessage();
		}		
	}
	
}




