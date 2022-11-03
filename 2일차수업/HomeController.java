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

import org.springframework.ui.Model;
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
	public String insert(String myname, int myage, String mybirth,
			Model model) 
	{
		StudentDAO stdDAO = new StudentDAO();
		String result =stdDAO.insertData(myname, myage, mybirth);
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
	
}




