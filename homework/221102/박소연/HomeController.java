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
    //test/home
	@RequestMapping(value = "/formnum", method = RequestMethod.GET)
	public String home(int num1, int num2, HttpServletRequest request, Model model) {
		
		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		int result =num1 +num2;
		model.addAttribute("result", result);
		return "01.view"; 
	}	
	
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String param(String myname, int myage, String mybirth,HttpServletRequest request, Model model) {
		
	
		model.addAttribute("myname", myname);
		model.addAttribute("myage", myage);
		model.addAttribute("mybirth", mybirth);
		
		String[] myarr= {"사과","딸기","포도"};
		model.addAttribute("myarr",myarr);
		
		return "02.view"; 
	}	
	
	
	@RequestMapping(value = "/quiz1", method = RequestMethod.GET)
	public String quiz1(int height, int weight, HttpServletRequest request, Model model) {
		
		double result;
		double bmi;
		
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		
		result=(height-100)*0.85;
		bmi = (weight/result)*100;
		
		model.addAttribute("result", result);
		model.addAttribute("bmi", bmi);
		
		
		return "02.view"; 
	}	
}


