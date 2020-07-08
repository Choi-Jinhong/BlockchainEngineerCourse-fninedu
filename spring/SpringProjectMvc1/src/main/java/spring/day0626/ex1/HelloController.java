package spring.day0626.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	
	@RequestMapping(value = "/happy", method=RequestMethod.GET)
	public String hello(Model model)
	{
		//Model�� request���� �����͸� �����ϱ� ���� �������̽�
		//�������� �ڵ��ߴ� request.setAttribute�� ����
		model.addAttribute("name", "������");
		model.addAttribute("addr", "���ﱸ��");
		
		return "result"; //������(WEB-INF/day0626/result.jsp)�� �����Ǿ� �ִ� ��
	}
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	//@GetMapping("/hello.do")  --> �̷� ��� ������ hello.do�� ���� 
	public ModelAndView hello2()
	{
		ModelAndView model=new ModelAndView();
		
		//�𵨿� ������ ����
		model.addObject("sangpum","����");
		model.addObject("price",10000);
	
		//jsp�� ������
		model.setViewName("result2");
		
		return model;
				
	}

}
