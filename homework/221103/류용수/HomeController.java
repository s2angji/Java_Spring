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
import test.model.ProductDTO;
import test.model.ProductPoolDAO;
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
	
	//@Autowired
	//BasicDataSource dataSource;
	
	@Autowired
	StudentPoolDAO poolDAO;
	
	@Autowired
	ProductPoolDAO ProductDAO;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		//myData.setMyData(100);
		return "home"; // forward: view a.jsp 
	}
	
	@RequestMapping(value = "/beantest", method = RequestMethod.GET)
	public String beantest( Model model) 
	{
		int n = myData.getMyData();
		System.out.println("mydata:"+n);
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println( std.getMyData().getMyData() );
		
		return "home"; // forward: view a.jsp 
	}
	@RequestMapping(value = "/myobsity", method = RequestMethod.GET)
	public String myobsity( int tall, int weight, Model model) 
	{
//		Obesity o = new Obesity();
		o.calcObesity(tall, weight);
		model.addAttribute("result", o.getResult());
		model.addAttribute("img", o.getImg());
		return "04.resultObsity";  
	}	

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(String myname, int myage, String mybirth, Model model) 
	{
		StudentDAO stdDAO = new StudentDAO();
		String result = stdDAO.insertData(myname, myage, mybirth);
		model.addAttribute("result",result);
		return "insertView";  
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select( Model model) 
	{
		StudentDAO stdDAO = new StudentDAO();
		ArrayList<StudentDTO> arr = stdDAO.selectStudent();
		model.addAttribute("arr",arr);
		return "selectView";  
	}
	
	@RequestMapping(value = "/insertPool", method = RequestMethod.GET)
	public String insertPool( Model model) 
	{		
		//StudentPoolDAO stdDAO		
		String result = poolDAO.insertStudent("컴퓨터", 20, "2011-01-02");
		model.addAttribute("result",result);
		
		/*
		try {
			String sql = "insert into student values(?,?,?)"; 
			Connection conn = dataSource.getConnection();
			//Statement stmt = conn.createStatement();
			//stmt.execute(sql);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "디비풀");
			pstmt.setInt(2, 50);
			pstmt.setString(3, "2017-03-12");
			//pstmt.execute();
			int nCnt = pstmt.executeUpdate();
			conn.close();
			model.addAttribute("result","추가성공"+nCnt);
		}catch(Exception err) {
			model.addAttribute("추가실패",err.getMessage());
		}*/
		
		return "insertView";  
	}	
	
	@RequestMapping(value = "/productInsert", method = RequestMethod.GET)
	public String productInsert(String pname, int pnum, String pdate, Model model) 
	{
		String result = ProductDAO.insertProduct(pname, pnum, pdate);
		model.addAttribute("result",result);
		return "productInsertView";  
	}
	
	@RequestMapping(value = "/productSelect", method = RequestMethod.GET)
	public String productSelect( Model model) 
	{
		ArrayList<ProductDTO> arr = ProductDAO.selectProduct();
		model.addAttribute("arr",arr);
		return "productSelectView";  
	}	
	
}




