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
	// Autowired 는 생성된 객체의 참조변수를 넣어준다.
	@Autowired
	MyData myData;
	
	@Autowired	
	Student std;
	
	@Autowired		
	Obesity o;
	
	@Autowired		
	BasicDataSource dataSource;
	
	@Autowired
	StudentPoolDAO poolDAO;
	
	@Autowired
	ProductPoolDAO productPoolDAO;	
	
    // test/home
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		MyData obj = new MyData();
//		obj.setMyData(100);
//		obj.getMyData();
		
		
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
	
	
	
	
    // test/beantest
	@RequestMapping(value = "/beantest", method = RequestMethod.GET)
	public String beantest(Model model) {
		
//		MyData obj = new MyData();
//		obj.setMyData(100);
//		obj.getMyData();	
		
		int n = myData.getMyData();
		System.out.println("mydata : " + n);
		System.out.println(std.getName());
		System.out.println(std.getAge());		
		System.out.println(std.getMyData().getMyData());			

		return "home"; // forward : view home.jsp
	}		
	

	
    // test/obesity - 비만도
	@RequestMapping(value = "/obesity", method = RequestMethod.GET)
	public String obesity(String tall, String weight, Model model) {

//		Obesity o = new Obesity();
		o.calcObesity(tall, weight);

		model.addAttribute("result",o.getResult());
		model.addAttribute("img",o.getImg());		
				
		return "exam1_1.view"; // forward : view exam1_1.view.jsp
	}		
	
	
    // test/dbConCheck - MariaDB 연결확인해 본다.
	@RequestMapping(value = "/dbConCheck", method = RequestMethod.GET)
	public String dbConCheck(Locale locale, Model model) {
		return "connection_test"; // forward : connection_test.jsp
	}	
	
	
    // test/insert 
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {

		StudentDAO stdDAO = new StudentDAO();
		String result = stdDAO.insertData("aaa", 40, "1979-11-12");
		model.addAttribute("result",result);
							
		return "insertView"; // forward : view insertView.jsp
	}			
	
    // test/insert2
	@RequestMapping(value = "/insert2", method = RequestMethod.GET)
	public String insert2(String name, int age, String birth, Model model) {

		StudentDAO stdDAO = new StudentDAO();
		String result = stdDAO.insertData(name, age, birth);
		model.addAttribute("result",result);
							
		return "insertView"; // forward : view insertView.jsp
	}		
	
	
    // test/select
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select( Model model) {

		StudentDAO stdDAO = new StudentDAO();
		ArrayList<StudentDTO> arr = stdDAO.selectStudent();
		model.addAttribute("arr",arr);
							
		return "selectView"; // forward : view insertView.jsp
	}			
	
	

    // test/insertPool 
	@RequestMapping(value = "/insertPool", method = RequestMethod.GET)
	public String insertPool(Model model) {
/*		
		try {
			String sql = "insert into student values (?,?,?)";
			// dbpool 에서 사용하지 않는 connection 받는다.
			Connection conn = dataSource.getConnection();
//			Statement stmt = conn.createStatement();
//			stmt.execute(sql);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "강호동");
			pstmt.setInt(2, 39);
			pstmt.setString(3,"1998-06-05");			
			int nCnt = pstmt.executeUpdate(); // pstmt.execute()보다 더성능이 낫다. 반영된 갯수를 int로 리턴
			
			conn.close(); // dbpool 에 connection 반납
			
			model.addAttribute("result","추가성공 " + nCnt + "개");
			
		} catch (SQLException e) {
			model.addAttribute("result","추가실패 "+ e.getMessage());
		}
*/		
		// StudentPoolDAO stdDAO = new StudentPoolDAO(); 를
		// 자바빈으로 등록하고 poolDAO
		String result = poolDAO.insertStudent("네이버", 56, "1997-12-04");
		model.addAttribute("result",result);
			
		return "insertView"; // forward : view insertView.jsp
	}	

	
	
    // test/insertProductPool 
	@RequestMapping(value = "/insertProductPool", method = RequestMethod.GET)
	public String insertProductPool(String product_name, int product_ea, String product_date,Model model) {
		
		// ProductPoolDAO productDAO = new ProductPoolDAO(); 를
		// 자바빈으로 등록하고 poolDAO
		String result = productPoolDAO.insertProduct(product_name, product_ea, product_date);
		model.addAttribute("result",result);
			
		return "insertProductView"; // forward : view insertProductView.jsp
	}		
	
	// test/selectProductPool
	@RequestMapping(value = "/selectProductPool", method = RequestMethod.GET)
	public String selectProductPool( Model model) {

		ArrayList<ProductDTO> arr = productPoolDAO.selectProduct();
		model.addAttribute("arr",arr);
							
		return "selectProductView"; // forward : view selectProductView.jsp
	}				
}


