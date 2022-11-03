package my.control;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.model.ProductDAO;
import test.model.ProductDTO;
import test.model.StudentDAO;
import test.model.StudentDTO;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public String insertProduct(String name, int num, String date, Model model) {
		String result = productDAO.insertProduct(name, num, date);
		model.addAttribute("result", result);
		return "insertProduct";
	}
	
	@RequestMapping(value = "/selectProduct", method = RequestMethod.GET)
	public String select(Model model) {
		ArrayList<ProductDTO> arr = productDAO.selectStudent();
		model.addAttribute("arr", arr);
		return "selectProduct";
	}
}
