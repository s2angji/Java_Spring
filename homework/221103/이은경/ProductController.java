package my.control;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.model.ProductDTO;
import test.model.ProductPoolDAO;


@Controller
public class ProductController 
{
	@Autowired
	ProductPoolDAO pdtDAO;
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public String insertPool(String name, int cnt, String date, Model model) {
		pdtDAO.insertProduct(name, cnt, date);
		return "redirect:/test/selectView";
	}

	@RequestMapping(value = "/selectView", method = RequestMethod.GET)
	public String selectView(Model model) {
		ArrayList<ProductDTO> arr = pdtDAO.selectProduct();
		model.addAttribute("arr",arr);
		return "pdtView";
	}
}
