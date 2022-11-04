package my.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.SpringVersion;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Locale;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.mybatis.ProductDAOImpl;
import com.test.mybatis.ProductDTO;
import com.test.mybatis.StudentDAOImpl;
import com.test.mybatis.StudentDTO;

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
	
	@Autowired
	StudentDAOImpl daoImpl;
	
	@Autowired
	ProductDAOImpl productDao;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		return "home"; // forward: view a.jsp 
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) 
	{
		return "insertform";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(String name, int cnt, String birth, Model model) 
	{
		int n = productDao.insert( new ProductDTO(name, cnt, birth) );
		model.addAttribute("result", "추가성공:"+n);
		return "home";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<ProductDTO> products = productDao.select();
		model.addAttribute("products", products);
		return "listview";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model) 
	{
		return "searchform";
	}
	
//	@RequestMapping(value = "/search", method = RequestMethod.POST)
//	public String search(String name, Model model) 
//	{
//		int n = productDao.insert( new ProductDTO(name) );
//		model.addAttribute("result", "추가성공:"+n);
//		return "home";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)
//	public String insert(Model model) 
//	{
//		int n = daoImpl.insertStudent( new StudentDTO("마이바티스",30,"2022-11-12") );
//		model.addAttribute("result", "추가성공:"+n);
//		return "insertView";
//	}
	
}




