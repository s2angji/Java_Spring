package my.control;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.model.ProductDTO;
import test.model.ProductPoolDAO;
import test.model.StudentDAO;
import test.model.StudentDTO;

@Controller
public class ProductController {
	
	@Autowired
	ProductPoolDAO productPoolDAO;
	
	@RequestMapping("/productInsert")
	public String productInsert(String productName, int productCount, String productionDate, Model model) {
		String result = productPoolDAO.insertProduct(productName, productCount, productionDate);
		model.addAttribute("result", result);
		return "insertView";
	}
	
	@RequestMapping("/productSelect")
	public String productSelect(Model model) {
		ArrayList<ProductDTO> arr = productPoolDAO.selectProduct();
		model.addAttribute("arr", arr);
		return "productView";
	}

}
