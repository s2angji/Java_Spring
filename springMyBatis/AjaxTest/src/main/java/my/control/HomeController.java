package my.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.SpringVersion;

import java.text.DateFormat;
import java.util.Date;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Locale;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.apache.commons.dbcp.BasicDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;

@Controller
public class HomeController 
{
	@Autowired
	BasicDataSource dataSource;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		return "home"; // forward: view a.jsp 
	}
	
	@RequestMapping(value = "/jsoncall", method = RequestMethod.GET,
			produces = "application/json; charset=utf8")
	public @ResponseBody String jsoncall(Model model) 
	{
		//[{"name":"홍길동","age":20},{"name":"홍길동","age":20}]
		JSONArray jarr = new JSONArray();
		
		JSONObject jo1 = new JSONObject();
		jo1.put("name", "홍길동");
		jo1.put("age", 20);
		
		JSONObject jo2 = new JSONObject();
		jo2.put("name", "이순신");
		jo2.put("age", 30);
		
		jarr.add(jo1);
		jarr.add(jo2);
		return jarr.toJSONString();  
	}	
	
	@RequestMapping(value = "/jsoncalldb", method = RequestMethod.GET,
			produces = "application/json; charset=utf8")
	public @ResponseBody String jsoncalldb(Model model) 
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
