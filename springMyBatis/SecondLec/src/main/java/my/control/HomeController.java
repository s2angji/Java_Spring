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

import org.springframework.ui.Model;
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
		
		return "04.resultObesity"; // forward: view home.jsp
	}
}
