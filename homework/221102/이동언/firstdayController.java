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
public class firstdayController 
{
    
	@RequestMapping(value = "/firstquestion", method = RequestMethod.GET)
	public String firstquestion(int height, int weight, Model model) {
		
		float pyojun = (float)((height-100)*0.85);
		float bimando = (float)(weight/pyojun)*100;
		String status;
		
		if(bimando <= 90) {
			status = "저체중";
		} else if (bimando <= 110) {
			status = "정상";
		} else if (bimando <= 120) {
			status = "과체중";
		} else {
			status = "비만";
		}
		
		
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("pyojun", pyojun);
		model.addAttribute("bimando", bimando);
		model.addAttribute("status", status);
		
		return "1.question"; // forward: view a.jsp
	}	
	
	@RequestMapping(value = "/secondquestion", method = RequestMethod.GET)
	public String secondquestion(String myname, String mytel,
			String myemail, String size, String[] topping,
			String mytime, String mytxt, Model model) {
		
		
		model.addAttribute("name", myname);
		model.addAttribute("telnum", mytel);
		model.addAttribute("email", myemail);
		model.addAttribute("size", size);
		model.addAttribute("topping", topping);
		model.addAttribute("time", mytime);
		model.addAttribute("needs", mytxt);
		
		
		return "2.question"; // forward: view a.jsp
	}	

}


