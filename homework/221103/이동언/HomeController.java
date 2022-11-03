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

import test.bean.MyData;
import test.bean.Obesity;
import test.bean.Student;
import test.model.ProductDAO;
import test.model.ProductDTO;
import test.model.StudentDAO;
import test.model.StudentDTO;
import test.model.StudentPoolDAO;

import org.springframework.ui.Model;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;


@Controller
public class HomeController 
{
 
	@Autowired
	MyData myData;
	
	@Autowired
	Student std;
	
	@Autowired
	Obesity o;
	
//	@Autowired
//	BasicDataSource dataSource;
	
	@Autowired
	StudentPoolDAO poolDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	// test/home
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// control
		return "home"; // forward: view a.jsp
	}	

	@RequestMapping(value = "/beantest", method = RequestMethod.GET)
	public String beantest(Model model) {
		// control
		
		int n = myData.getMyData();
		System.out.println("myData:"+ n);
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getMyData().getMyData());
		return "home"; // forward: view a.jsp
	}	
	
	@RequestMapping(value="/myobesity", method = RequestMethod.GET)
	public String myobesity(int height, int weight, Model model) {
		
		o.calcObesity(height, weight);
		model.addAttribute("result", o.getResult());
		model.addAttribute("getImg", o.getImg());
		return "myobesity";
		
	}

	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insert(String myname, int myage, String mybirth, Model model) {
		
		StudentDAO stdDAO = new StudentDAO();
		String result = stdDAO.insertData(myname, myage, mybirth);
		model.addAttribute("result", result);
		return "insertView";	
	}
	
	@RequestMapping(value="/select", method = RequestMethod.GET)
	public String select(Model model) {
		
		StudentDAO stdDAO = new StudentDAO();
		ArrayList<StudentDTO> arr = stdDAO.selectStudent();
		model.addAttribute("arr", arr);
		return "selectView";	
	}
	
	@RequestMapping(value="/insertPool", method = RequestMethod.GET)
	public String insertPool(Model model) {
		
		String result = poolDAO.insertStudent("컴퓨터", 23, "2020-02-02");
		model.addAttribute("result", result);
//		try {
//			String sql = "insert into student values (?, ?, ?)";
//			// dbpool에서 사용하지 않는 Connection Return
//			Connection conn = dataSource.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "디비풀");
//			pstmt.setInt(2, 50);
//			pstmt.setString(3, "1999-09-09");
////			pstmt.execute();
//			int nCnt = pstmt.executeUpdate(); // insert delete update -> 반영된 갯수 반환
//			conn.close(); // dbpool에 컨넥션 반납
//			model.addAttribute("result", "추가성공: " + nCnt);
//		} catch (Exception err) {
//			model.addAttribute("result", "추가실패" + err.getMessage());
//		}
		return "insertView";
	}
	
	
	
	/* 2일차 과제 */
	@RequestMapping(value="/question1", method = RequestMethod.GET)
	public String question1(Model model) {
		return "question1";
	}
	
	@RequestMapping(value="/question2", method = RequestMethod.GET)
	public String question2(Model model) {
		return "question2";
	}
	
	@RequestMapping(value="/question2", method = RequestMethod.POST)
	public String question2(String name, int cnt, String productday, Model model) {
		String result = productDAO.insertProduct(name, cnt, productday);
		model.addAttribute("result", result);
		return "question1";
	}
	
	@RequestMapping(value="/question3", method = RequestMethod.GET)
	public String question3(Model model) {
		ArrayList<ProductDTO> arr = productDAO.selectProduct();
		model.addAttribute("arr", arr);
		return "question3";
	}
	
	
}


