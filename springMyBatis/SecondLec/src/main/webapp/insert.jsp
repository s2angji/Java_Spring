<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page import="java.sql.*"%>
<%	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		out.print("드라이버로딩 성공");
	} catch (Exception ex) {
		out.print("드라이버로딩 실패");
	}
	String oracleURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
	
	String id = "root";
	String pass = "1234";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
    try{
        String sql ="insert into student(name, age, birth) values('홍길동', 20, '1999-12-15')";
		conn = DriverManager.getConnection(oracleURL, id, pass);
		stmt = conn.createStatement();  
		stmt.execute(sql);
		conn.close();
		out.print("추가성공");

    }catch( Exception ex){
        out.print( ex.getMessage() );
    }
%>




