package my.control;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mybatis.ProductDAOImpl;
import com.test.mybatis.ProductDTO;

import org.springframework.ui.Model;

@Controller
public class ProductController {
	
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	ProductDAOImpl daoImpl;
	
	@RequestMapping(value = "/homeProduct", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public String insertProduct(String productName, int productCount, String productionDate, Model model) {
	
		int n = daoImpl.insertProduct(new ProductDTO(productName, productCount, productionDate));
		model.addAttribute("result", "추가성공 : " + n);
		
		return "insertView";
	}
	
	@RequestMapping(value = "/selectProduct", method = RequestMethod.GET)
	public String selectProduct(Model model) {
	
		ArrayList<ProductDTO> arr = daoImpl.selectProduct();
		model.addAttribute("arr", arr);
		
		return "selectView";
	}
	
	@RequestMapping(value = "/productSelectWhere", method = RequestMethod.GET)
	public String selectWhere(HttpServletRequest request, Model model) {
	
//		ArrayList<StudentDTO> arr = daoImpl.selectStudentWhere("이상혁");
//		model.addAttribute("arr", arr);
		
		return "selectView";
	}
	
}
