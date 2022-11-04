package my.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.apache.commons.dbcp.BasicDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@Autowired
	BasicDataSource dataSource;

	@RequestMapping(value = "/select", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public @ResponseBody String select(Model model) 
	{
		//[{"name":"홍길동","age":20},{"name":"홍길동","age":20}]
		JSONArray jarr = new JSONArray();
	   try{
	        String sql ="select * from student";
			Connection conn;
			Statement stmt;
			ResultSet rs;
			conn =dataSource.getConnection();
			stmt = conn.createStatement();  
	        rs= stmt.executeQuery(sql); //select
	        while( rs.next()){
	        	JSONObject jo = new JSONObject();
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            Date birth = rs.getDate("birth");
	            jo.put("name", name);
	            jo.put("age", age);
	            jo.put("birth", birth.toString() );
	            jarr.add(jo);
	        }
	        rs.close();
	        conn.close();
	    }catch( Exception ex){
	    }				
		return jarr.toJSONString();  
	}	
}
