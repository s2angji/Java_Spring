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

import my.aoptest.Hello;
import my.aoptest.HelloAdvice;

import org.springframework.ui.Model;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;


@Controller
public class HomeController {

	@Autowired
	HelloAdvice hello;
	@Autowired
	Hello hello1;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		hello.method1();
		hello1.testA();
		hello1.testB();
		
		return "home"; // forward: view home.jsp
	}
	
}
