package my.control;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ReportController 
{
    	
	@RequestMapping(value = "/report1", method = RequestMethod.GET)
	public String numcalc(int tall, int weight, String result, Model model) {
			
		//표준체중 = (신장-100) * 0.85
		//비만도 = 현재체중/표준체중*100
		
		float result1 = (float) ((tall - 100) * 0.85) ;
		float result2 = weight / result1 * 100;
		String result3 = "";
		if(result2 <= 90) {
			result3 = "저체중";
		}else if(result2 <110 ) {
			result3 = "정상";
		}else if(result2 < 120) {
			result3 = "과체중";
		}else if(120 < result2 ) {
			result3 = "비만";
		}
		
		model.addAttribute("tall", + tall);
		model.addAttribute("weight", + weight );
		model.addAttribute("result",  result3 );
	

		return "report1view"; //forward: view 01.view.jsp
	}
	

	

}


