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
	public String home(Locale locale, Model model) {
		// control
		return "a"; //포워딩 view a.jsp
	}	

	@RequestMapping(value = "/formproc", method = RequestMethod.GET)
	public String formproc(HttpServletRequest request, Model model) {
		String name = request.getParameter("myname");
		String age = request.getParameter("myage");
		//String nage = Integer.parseInt(request.getParameter("myage"));
		model.addAttribute("myname", name);
		model.addAttribute("myage", age);
		return "01.view";
	}
	
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String param(String myname, int myage, String mybirth, Model model) {
		
		model.addAttribute("myname", myname);
		model.addAttribute("myage", myage);
		model.addAttribute("mybirth", mybirth);
		String[] myarr = {"사과","딸기","포도"};
		model.addAttribute("myarr", myarr);
		return "02.view";
	}
	
	@RequestMapping(value = "/numcalc", method = RequestMethod.GET)
	public String numcalc(int num1,int num2, Model model) {
		
		model.addAttribute("result", num1 + num2);

		return "03.calcview";
	}
	
	@RequestMapping(value = "/firstq01", method = RequestMethod.GET)
	public String firstq01(int num1,int num2, Model model) {
		
		double avg01 = (num1 - 100) * 0.85;
		double avg02 = (num2/avg01) * 100;
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);		
		model.addAttribute("result01", avg01);
		model.addAttribute("result02", avg02);

		return "firstq01view";
	}
	
	@RequestMapping(value = "/firstq02", method = RequestMethod.GET)
	public String firstq02(String myname, String mytel, String myemail, String color, String topping, String mytime, String mytxt , Model model) {
		
		model.addAttribute("myname", myname);
		model.addAttribute("mytel", mytel);
		model.addAttribute("myemail", myemail);
		model.addAttribute("color", color);
		String[] myarr = {topping};
		model.addAttribute("myarr", myarr);
		model.addAttribute("mytime", mytime);
		model.addAttribute("mytxt", mytxt);
		return "firstq02view";
	}
	
}


