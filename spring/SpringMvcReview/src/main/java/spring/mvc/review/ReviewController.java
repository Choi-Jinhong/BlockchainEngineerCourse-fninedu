package spring.mvc.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewController {
	
	
	//���� ��Ʈ�� �����ҽ� �������� ȭ��
	//@RequestMapping(value="/",method=RequestMethod.POST)
	@GetMapping("/") //����ȭ���� ��Ʈ
	public String sawonForm()
	{
		return "sawonForm"; //�������� jsp
	}
	
	@GetMapping("info") //���� action�� �̸��� ���ƾ�
	public ModelAndView sawoninfo(@ModelAttribute SawonDto dto)
	{
		ModelAndView model = new ModelAndView();
		
		model.addObject("dto", dto);
		model.setViewName("sawonInfo"); //jsp
		
		return model;
	}

}
