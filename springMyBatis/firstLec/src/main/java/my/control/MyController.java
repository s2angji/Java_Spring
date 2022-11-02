package my.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value="/b")
	public String bFn(Model model) {
		return "b"; // b.jsp
	}
	
	@RequestMapping(value = "/221102_homework_1", method = RequestMethod.GET)
	public String homework_1(int height, int weight, Model model) {
		String result;
		
		double tmp = (weight / ((height - 100) * 0.85)) * 100;
		if(tmp < 90)
			result = "저체중";
		else if(90 <= tmp && tmp < 110)
			result = "정상";
		else if(110 <= tmp && tmp < 120)
			result = "과체중";
		else
			result = "비만";
		
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("result", result);
		return "221102_homework_1";  
	}
	
	@RequestMapping(value = "/221102_homework_2", method = RequestMethod.GET)
	public String homework_2(HttpServletRequest request, Model model) {
		
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("tel", request.getParameter("tel"));
		model.addAttribute("email", request.getParameter("email"));
		model.addAttribute("size", request.getParameter("size"));
		model.addAttribute("topping", request.getParameter("topping"));
		model.addAttribute("time", request.getParameter("time"));
		model.addAttribute("txt", request.getParameter("txt"));
		
		return "221102_homework_2";  
	}
}
