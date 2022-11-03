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
import test.model.StudentDAO;
import test.model.StudentDTO;
import test.model.StudentPoolDAO;

import org.springframework.ui.Model;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;


@Controller
public class HomeController {
	
	@Autowired
	MyData myData; // bean에서 등록한 id랑 변수명이 같아야 함 !!
	
	@Autowired
	Student std;
	
	@Autowired
	Obesity o;
	
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	StudentPoolDAO poolDAO;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		MyData myData = new MyData();
//		myData.setMyData(100);
//		myData.getMyData();
		
		return "home"; // forward: view home.jsp
	}
	
	@RequestMapping(value = "/beantest", method = RequestMethod.GET)
	public String beantest(Locale locale, Model model) {
		
		// 웹 에서 컨트롤러가 빈번하게 불릴 때 마다, 객체를 매번 생성하는 문제가 발생 !!
//		MyData myData = new MyData();
//		myData.setMyData(100);
//		myData.getMyData();
		
		int n = myData.getMyData();
		System.out.println("mydata:" + n);
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getMyData().getMyData());
		
		return "home"; // forward: view home.jsp
	}
	
	@RequestMapping(value = "/myobesity", method = RequestMethod.GET)
	public String myobesity(int tall, int weight, Model model) {
		
		o.calcObesity(tall, weight);
		model.addAttribute("result", o.getResult());
		model.addAttribute("img", o.getImg());
		
		return "04.resultObesity";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		
		StudentDAO stdDAO = new StudentDAO();
		String result = stdDAO.insertData("스프링", 40, "1979-11-12");
		model.addAttribute("result", result);
		
		return "insertView";
	}
	
	@RequestMapping(value = "/studentInsert", method = RequestMethod.GET)
	public String studentInsert(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String birth = request.getParameter("birth");
		
		StudentDAO stdDAO = new StudentDAO();
		String result = stdDAO.insertData(name, age, birth);
		model.addAttribute("result", result);
		
		return "insertView";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(Model model) {
		
		StudentDAO stdDAO = new StudentDAO();
		ArrayList<StudentDTO> arr = stdDAO.selectStudent();
		model.addAttribute("arr", arr);
		return "selectView";
	}
	
	@RequestMapping(value = "/insertPool", method = RequestMethod.GET)
	public String insertPool(Model model) {
		
//		StudentPoolDAO stdDAO = new StudentPoolDAO();
		String result = poolDAO.insertStudent("컴퓨터", 20, "2011-01-02");
		model.addAttribute("result", result);
		
//		try {
//			// dbpool에서 사용하지 않는 connection
//			String sql = "insert into student values(?,?,?)";
//			Connection conn = dataSource.getConnection();
////			Statement stmt = conn.createStatement();
////			stmt.execute(sql);
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "디비풀");
//			pstmt.setInt(2, 50);
//			pstmt.setString(3, "2017-03-12");
//			int nCnt = pstmt.executeUpdate(); // executeUpdate() insert, delete, update 반영된 갯수를 반환함
//			conn.close(); // dbpool로 connection 반납
//			
//			model.addAttribute("result", "추가 성공: " + nCnt);
//		} catch (Exception err) {
//			System.out.println("추가 실패: " + err.getMessage());
//		}
//		
////		model.addAttribute("result", result);
		return "insertView";
	}
}
