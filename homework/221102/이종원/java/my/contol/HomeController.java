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
		return "a"; // forward : view a.jsp
	}	

    // test/formproc
	@RequestMapping(value = "/formproc", method = RequestMethod.GET)
	public String formproc(HttpServletRequest request, Model model) {
		
		// query string 처리한다. myname=홍길동&myage=22
		String name = request.getParameter("myname");
		String age  = request.getParameter("myage");		
		model.addAttribute("myname",name);
		model.addAttribute("myage",age);
		return "01.view"; // forward : view 01.view.jsp
	}		
	
    // test/param
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String param(String myname, int myage, String mybirth, Model model) {
		
		model.addAttribute("myname",myname);
		model.addAttribute("myage",myage);		// 형변환 자동된다.
		model.addAttribute("mybirth",mybirth);
		
		String[] myarr = {"사과", "딸기", "포도"};
		model.addAttribute("myarr",myarr);		// 형변환 자동된다.
		
		return "02.view"; // forward : view 02.view.jsp
	}		
	
    // test/hap
	@RequestMapping(value = "/hap", method = RequestMethod.GET)
	public String hap(int su1, int su2, Model model) {
		int hap = 0;
		hap = su1 + su2;
		model.addAttribute("hap",hap);
		
		return "exam01.view"; // forward : view exam01.view.jsp
	}	
	
    // test/numcalc
	@RequestMapping(value = "/numcalc", method = RequestMethod.GET)
	public String numcalc(int su1, int su2, Model model) {
		model.addAttribute("hap",su1+su2);
		
		return "exam01.view"; // forward : view exam01.view.jsp
	}		
	
    // test/fat - 비만도
	@RequestMapping(value = "/fat", method = RequestMethod.GET)
	public String fat(float myheight, float myweight, Model model) {
		float bi = 0;
		bi = (float) ((myweight /(myheight - 100) * 0.85) * 100);
		
		String result = "";
		String img = "";
		if (bi <= 90) {
			result = "저체중";
			img = "che1.png";
		} else if (bi > 90 && bi <= 110) {
			result = "정상";			
			img = "che2.png";			
		} else if (bi > 110 && bi <= 120) {
			result = "과체중";			
			img = "che3.png";			
		} else if (bi > 120) {
			result = "비만";	
			img = "che4.png";			
		}
		

		model.addAttribute("result",result);
		model.addAttribute("img",img);		
		
		model.addAttribute("myheight",myheight);
		model.addAttribute("myweight",myweight);
		
		return "exam1_1.view"; // forward : view exam1_1.view.jsp
	}	
	
	
	
    // test/pizza - 피자주문신청
	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public String pizza(String myname,String mytel,String myemail, String size, String[] topping, String mytime,String mytxt, Model model) {
		
		model.addAttribute("myname",myname);
		model.addAttribute("mytel",mytel);		
		model.addAttribute("myemail",myemail);
		model.addAttribute("mysize",size);
		model.addAttribute("topping",topping);		
		model.addAttribute("mytime",mytime);	
		model.addAttribute("mytxt",mytxt);				
				
		return "exam1_2.view"; // forward : view exam1_2.view.jsp
	}		
	
}


