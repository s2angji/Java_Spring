package my.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.vo.Exam1_1VO;

@Controller
public class Exam1Controller {
	
	@RequestMapping("/exam1")
	public String exam1(double height, double weight, Model model) {
		double averge = ((height - 100) * 0.85);
		
		double fatter = (weight / averge) * 100 ;
		String result = "";
		
		if(fatter <= 90) {
			result = "저체중";
		}else if(fatter >= 91 && fatter <= 109) {
			result = "정상";
		}else if(fatter >= 110 && fatter <= 119) {
			result = "과체중";
		}else if(fatter >= 120) {
			result = "비만";
		}
		
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("result", result);
		
		return "exam1";
	}
	
	@RequestMapping("/exam1_1")
	public String exam1_1(Exam1_1VO exam1_1VO, Model model) {
		System.out.println(exam1_1VO.toString());
		model.addAttribute("models", exam1_1VO);
		return "exam1_1";
	}
	
}
