package test.model;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
	String oracleURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "1234";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public StudentDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("드라이버로딩"+ex.getMessage());
		}		
	}
	
	public String insertData(String name, int age, String birth)
	{
	   try{
			String sql = String.format("insert into student values('%s',%d,'%s')",
					name,age,birth);
			conn = DriverManager.getConnection(oracleURL, id, pass);
			stmt = conn.createStatement();  
			stmt.execute(sql);
			conn.close();
			return "추가성공";
	    }catch( Exception ex){
	        return "추가실패"+ex.getMessage();
	    }		
	}
	
	public ArrayList<StudentDTO> selectStudent()
	{
		ArrayList<StudentDTO> arr = new ArrayList<StudentDTO>();
	   try{
	        String sql ="select * from student";
			conn = DriverManager.getConnection(oracleURL, id, pass);
			stmt = conn.createStatement();  
	        rs= stmt.executeQuery(sql); //select
	        while( rs.next())
	        {
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            Date birth = rs.getDate("birth");
	            arr.add( new StudentDTO(name, age, birth.toString() ) );
	        }
	        rs.close();
	        conn.close();
	        return arr;
	    }catch( Exception ex){
	    	return null;
	    }		
	}
	
	
}



