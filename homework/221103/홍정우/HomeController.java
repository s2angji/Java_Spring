package my.control;

import java.util.ArrayList;
import java.util.Locale;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.bean.Bmi;
import test.bean.MyData;
import test.bean.Student;
import test.model.ProductDAO;
import test.model.ProductDTO;
import test.model.StudentDAO;
import test.model.StudentDTO;
import test.model.StudentPoolDAO;

@Controller
public class HomeController {
	@Autowired
	MyData myData;
	
	@Autowired
	Student std;
	
	@Autowired
	Bmi bmi;
	
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	StudentPoolDAO poolDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/beantest", method = RequestMethod.GET)
	public String beantest(Model model) {
		System.out.println(std.getMyData());
		return "home";
	}
	
	@RequestMapping(value = "/bmi", method = RequestMethod.GET)
	public String bmi(Model model, int height, int weight) {
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		String result = bmi.calcBmi(height, weight);
		model.addAttribute("bmi", result);
		
		System.out.println(result);
		return "home";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		StudentDAO stdDAO = new StudentDAO();
		String result = stdDAO.insertData("스프링", 40, "1979-11-12");
		model.addAttribute("result", result);
		
		return "insertView";
	}
	
	@RequestMapping(value = "/modelTest", method = RequestMethod.GET)
	public String modelTest(Model model, String name, int age, String birth) {
		StudentDAO stdDAO = new StudentDAO();
		String result = stdDAO.insertData(name, age, birth);
		model.addAttribute("result", result);
		
		return "modelTest";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(Model model) {
		StudentDAO stdDAO = new StudentDAO();
		ArrayList<StudentDTO> result = stdDAO.selectStudent();
		model.addAttribute("result", result);
		
		return "selectView";
	}
	
	@RequestMapping(value = "/insertPool", method = RequestMethod.GET)
	public String insertPool(Model model, String name, int age, String birth) {
		String result = poolDAO.insertStudent(name, age, birth);
		model.addAttribute("result", result);
		return "insertView";
	}
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public String insertProduct(Model model, String name, int cnt, String birth) {
		String result = productDAO.insertproduct(name, cnt, birth);
		ArrayList<ProductDTO> result1 = productDAO.selectProduct();
		model.addAttribute("result", result1);
		return "selectProductView";
	}
	
}
