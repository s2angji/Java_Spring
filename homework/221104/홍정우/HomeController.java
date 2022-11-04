package my.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

import org.apache.commons.dbcp.BasicDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.mybatis.ProductDAOImpl;
import com.test.mybatis.ProductDTO;
import com.test.mybatis.StudentDAOImpl;
import com.test.mybatis.StudentDTO;


@Controller
public class HomeController {
	
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	StudentDAOImpl daoImpl;
	
	@Autowired
	ProductDAOImpl productImpl;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/jsoncall", 
					method = RequestMethod.GET,
					produces = "application/json; charset=utf8")
	public String jsoncall(Model model) {
		JSONArray jarr = new JSONArray();
		
		JSONObject jo1 = new JSONObject();
		jo1.put("name", "홍길동");
		jo1.put("age", "20");
		
		JSONObject jo2 = new JSONObject();
		jo2.put("name", "이순신");
		jo2.put("age", "10");
		
		jarr.add(jo1);
		jarr.add(jo2);
		return jarr.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
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
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		int n = daoImpl.insertStudent(new StudentDTO("마이바티스", 20,"2022-11-04"));
		model.addAttribute("result", "추가성공"+n);
		return "insertView";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(Model model) {
		ArrayList<StudentDTO> arr = daoImpl.selectStudent();
		model.addAttribute("arr", arr);
		return "selectView";
	}
	
	@RequestMapping(value = "/selectOrder", method = RequestMethod.GET)
	public String selectOrder(Model model) {
		ArrayList<StudentDTO> arr = daoImpl.selectStudentOrder();
		model.addAttribute("arr", arr);
		return "selectView";
	}
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public String insertProductLast(Model model, String productName, int cnt, String date) {
		int n = productImpl.insertProduct(new ProductDTO(productName, cnt, date));
		model.addAttribute("result", "추가성공"+n);
		return "insertProductView";
	}
	
	@RequestMapping(value = "/selectProduct", method = RequestMethod.GET)
	public String selectProduct(Model model) {
		ArrayList<ProductDTO> arr = productImpl.selectProduct();
		model.addAttribute("arr", arr);
		return "selectProductView";
	}
	
	@RequestMapping(value = "/selectOneProduct", method = RequestMethod.GET)
	public String selectOneProduct(Model model, String productName) {
		ArrayList<ProductDTO> arr = productImpl.selectOneProduct(productName);
		model.addAttribute("arr", arr);
		return "selectOneProductView";
	}
	
	
}
