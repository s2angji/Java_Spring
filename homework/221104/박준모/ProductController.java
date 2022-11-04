package my.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.dbcp.BasicDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.mybatis.ProductDAOImpl;
import com.test.mybatis.ProductDTO;

@Controller
public class ProductController {
	
	@Autowired
	BasicDataSource dataSource;

	@Autowired
	ProductDAOImpl daoImpl;

	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public String insertPool(ProductDTO productDTO, Model model) {

		int n = daoImpl.insertProduct(productDTO);
		model.addAttribute("result", "추가 성공 : " + n);

		return "insertView";
	}

	@RequestMapping(value = "/selectProduct", method = RequestMethod.GET)
	public String selectProduct(Model model) {
		ArrayList<ProductDTO> arr = daoImpl.selectProduct();
		model.addAttribute("arr", arr);

		return "selectProduct";
	}
	
	@RequestMapping(value = "/selectProductWhere", method = RequestMethod.GET)
	public String selectProductWhere(String product, Model model) {

		ArrayList<ProductDTO> arr = daoImpl.selectProductWhere(product);
		model.addAttribute("arr", arr);

		return "selectProduct";
	}
	
	@RequestMapping(value = "/selectProductAjax", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public @ResponseBody String jsoncalldb(Model model) {

		JSONArray jarr = new JSONArray();
		
		ArrayList<ProductDTO> arr = daoImpl.selectProduct();
			
		for(ProductDTO product : arr) {
				JSONObject jo = new JSONObject();
				jo.put("product", product.getProduct());
				jo.put("count", product.getCount());
				jo.put("date", product.getDate());
				jarr.add(jo);
		}

		return jarr.toJSONString();
	}
	
}
