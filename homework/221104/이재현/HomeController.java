package my.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
import com.test.mybatis.ProductModel;
import com.test.mybatis.StudentDAOImpl;
import com.test.mybatis.StudentModel;

@Controller
public class HomeController {

	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	StudentDAOImpl studentDAOImpl;
	
	@Autowired
	ProductDAOImpl productDAOImpl;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/jsonCall", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String jsonCall(Locale locale, Model model) {
		JSONObject jo1 = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		jo1.put("name", "홍길동");
		jo1.put("age", 20);
		
		
		JSONObject jo2 = new JSONObject();
		jo2.put("name", "이순신");
		jo2.put("age", 30);
		
		jarr.add(jo1);
		jarr.add(jo2);
		
		return jarr.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/jsonCallDb", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String jsonCallDb(Locale locale, Model model) {
		JSONArray jarr = new JSONArray();
		
		try {
			String sql = "select * from student";
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				JSONObject jo = new JSONObject();
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Date birth = rs.getDate("birth");
				jo.put("name", name);
				jo.put("age", age);
				jo.put("birth", birth.toString());
				
				jarr.add(jo);
			}
			conn.close();
			return jarr.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/insertUseMyBatis", method = RequestMethod.GET)
	public String insertUserMyBatis(Model model) {
		int n = studentDAOImpl.insertStudent(new StudentModel("mybatis", 11, "2025-11-11"));
		model.addAttribute("result", "성공 ! > " + n);
		return "insertUserMyBatisView";
	}

	@RequestMapping(value = "/selectUserMyBatis", method = RequestMethod.GET)
	public String selectUserMyBatis(Model model) {
		ArrayList<StudentModel> arr = studentDAOImpl.selectStudent(); 
		model.addAttribute("arr", arr);
		return "selectUserMyBatisView";
	}
	
	@RequestMapping(value = "/selectUserOrderMyBatis", method = RequestMethod.GET)
	public String selectUserOrderMyBatis(Model model) {
		ArrayList<StudentModel> arr = studentDAOImpl.selectStudentOrder(); 
		model.addAttribute("arr", arr);
		return "selectUserOrderMyBatisView";
	}

	@RequestMapping(value = "/selectUserWhereMyBatis", method = RequestMethod.GET)
	public String selectUserWhereMyBatis(Model model) {
		ArrayList<StudentModel> arr = studentDAOImpl.selectStudentWhere("홍길동"); 
		model.addAttribute("arr", arr);
		return "selectUserWhereMyBatisView";
	}	
	
	@RequestMapping(value = "/selectUserWhereOrMyBatis", method = RequestMethod.GET)
	public String selectUserWhereOrMyBatis(Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", 10);
		ArrayList<StudentModel> arr = studentDAOImpl.selectStudentWhereOr(map); 
		model.addAttribute("arr", arr);
		return "selectUserWhereMyBatisView";
	}	
	
	@RequestMapping(value = "/selectProduct", method = RequestMethod.GET)
	public String selectProduct(Model model) {
		ArrayList<ProductModel> arr = productDAOImpl.selectProduct(); 
		model.addAttribute("arr", arr);
		return "selectProduct";
	}	
	
	@RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
	public String searchProduct(Model model, String productName) {
		ArrayList<ProductModel> arr = productDAOImpl.searchProduct(productName); 
		model.addAttribute("arr", arr);
		return "searchProduct";
	}
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public String insertProduct(Model model, String productName, int productCount, String productDate) {
		Map<String, Object> map = new HashMap<>();
		map.put("productName", productName);
		map.put("productCount", productCount);
		map.put("productDate", productDate);
		int n = productDAOImpl.insertProduct(map); 
		model.addAttribute("map", map);
		model.addAttribute("result", "삽입 개수 : " + n);
		return "insertProduct";
	}
	
	
}