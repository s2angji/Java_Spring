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
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;


@Controller
public class HomeController 
{
	// test/home
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		return "a"; // forward: view a.jsp 
	}
	
	@RequestMapping(value = "/formproc", method = RequestMethod.GET)
	public String formproc( HttpServletRequest request , Model model) 
	{
		// query string 처리 myname=홍길동&myage=20
		String name = request.getParameter("myname");
		String age = request.getParameter("myage");
		int nage = Integer.parseInt( request.getParameter("myage") );
		model.addAttribute("myname", name);
		model.addAttribute("myage", age);
		
		return "01.view"; // forward: view 01.view.jsp 
	}
	
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String param( String myname, int myage, String mybirth, Model model) 
	{
		model.addAttribute("myname", myname);
		model.addAttribute("myage", myage);
		model.addAttribute("mybirth", mybirth);
		String[] myarr = {"사과","딸기","포도"};
		model.addAttribute("myarr", myarr);
		return "02.view";  
	}
	
	@RequestMapping(value = "/numcalc", method = RequestMethod.GET)
	public String numcalc(int num1, int num2, Model model) 
	{
		model.addAttribute("result", num1 + num2);
	
		return "03.calcView";  
	}
	

	
	@RequestMapping(value = "/myobsity", method = RequestMethod.GET)
	public String myobsity(int tall , int weight, Model model) 
	{
		int avrWeight = (int) ((tall-100)*0.85); //표준체중
		int obesity = weight / avrWeight * 100; //비만도


		model.addAttribute("result", obesity);
	
		
		return "04.resultObsity";  
	}


	
}




