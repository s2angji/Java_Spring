package my.control;

import java.util.ArrayList;
import java.util.Locale;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.bean.MyData;
import test.bean.Obesity;
import test.bean.Student;
import test.model.ProductDAO;
import test.model.StudentDAO;
import test.model.StudentPoolDAO;

@Controller
public class HomeController {

	@Autowired
	MyData myData;

	@Autowired
	Student std;

	@Autowired
	Obesity obesity;

	@Autowired
	StudentDAO stdDAO;
	
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	StudentPoolDAO stpDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/beantest", method = RequestMethod.GET)
	public String beanTest(Model model) {
		int test = myData.getMyData();
		System.out.println(test);

		String name = std.getName();
		System.out.println(name);
		System.out.println(std.getMyData().getMyData());

		return "home";
	}

	@RequestMapping(value = "/myObesity", method = RequestMethod.GET)
	public String myObesity(int tall, int weight, Model model) {
		// Obesity obesity = new Obesity();
		obesity.calcObesity(tall, weight);
		model.addAttribute("result", obesity.getResult());
		model.addAttribute("img", obesity.getImg());
		return "04.resultObesity";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String Insert(String name, int age, String birth) {
		String result = stdDAO.insertData(name, age, birth);
		return "insertView";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String Select(Model model) {
		ArrayList<?> arr = stdDAO.selectData();
		System.out.println(arr.toString());
		model.addAttribute("arr", arr);
		
		return "selectView";
	}
	
	@RequestMapping(value = "/insertPool", method = RequestMethod.GET)
	public String insertPool(Model model) {
//		try {
//			String sql = "insert into student values(?, ?, ?)";
//			Connection conn = dataSource.getConnection();
//			Statement stmt = conn.createStatement();
//			stmt.execute(sql);
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "dbPoolTest");
//			pstmt.setInt(2, 1111);
//			pstmt.setString(3, "2022-11-03");
//			
//			int nCnt = pstmt.executeUpdate();
//			conn.close();
//			model.addAttribute("result", "추가성공 : " + nCnt);
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("result", "추가실패 : " + e.getMessage());
//		}
		
		String result = stpDAO.insertStudent("빈인설트테스트", 12, "2022-11-03");
		model.addAttribute("result", result);
		return "insertView";
	}
	
	@GetMapping("/productInsert")
	public String productInsert(String productName, int productCount, String productDate,Model model) {
		String result = productDAO.insertProduct(productName, productCount, productDate);
		model.addAttribute("result", result);
		return "productInsertView";
	}
	
	@GetMapping("/productSelectView")
	public String productView(Model model) {
		ArrayList<?> arr = productDAO.selectProduct();
		model.addAttribute("arr", arr);
		return "productSelectView";
	}
	
}