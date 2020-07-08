package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {

	 @GetMapping("sawonForm") //�����ּҴ� index���� ��ũ�ϹǷ� �̸��� �����ؾ� �� public String
	
	 public String sawonform() { 
		 
		 return "sawonform";
		 }
	

	@PostMapping("read2")
	public ModelAndView sawonlist(@ModelAttribute SawonDto dto) {
		ModelAndView model = new ModelAndView();

		model.addObject("dto", dto);
		return model;
	}

}
