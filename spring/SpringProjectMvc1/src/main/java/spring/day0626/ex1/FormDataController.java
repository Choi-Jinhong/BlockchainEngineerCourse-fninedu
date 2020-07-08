package spring.day0626.ex1;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormDataController {
	
	@GetMapping("myform") //�����ּҴ� index���� ��ũ�ϹǷ� �̸��� �����ؾ� ��
	public String form1()
	{
		return "form1";
	}
	
	@GetMapping("/read1")
	//@RequestMapping("/read1") --> �����ϸ� get����
	//get��� �� ����
	public ModelAndView read1(@RequestParam("name") String name,
		 @RequestParam int age,
		 @RequestParam(value="msg",defaultValue = "Happy~")String msg)
	{
		ModelAndView model=new ModelAndView();
		model.addObject("name", name);
		model.addObject("age", age);
		model.addObject("msg", msg);
		
		//������
		model.setViewName("process1");	
		return model;
	}
	
	@PostMapping("read2")
	public ModelAndView read2(@ModelAttribute TestDTO dto)  //dto�� �� ���� ��� �޾ƿ�=@
	{
		ModelAndView model=new ModelAndView();
		//request���� ���� dto�� �޾ƿ´�
			
		model.addObject("dto", dto);
	
		//������
		model.setViewName("process2");
		return model;
	}
	
	
	//3�� �� -> Map���� �� ������ �б�
	@PostMapping(value = "/read3")
	public ModelAndView read3(@RequestParam Map<String, String>map)
	{
		ModelAndView model = new ModelAndView();
		
		String blood=map.get("blood");
		String star=map.get("star");
		
		String data="��������"+blood+", ���ڸ���"+star+"�ڸ��Դϴ�";
		
		
		model.addObject("data", data);
		model.setViewName("process3");
		
		return model;
		
	}
	
	
	//�������� �����ּҸ� �ְ��� �� ��
	@RequestMapping({"/apple","/kiwi","orange"})
	public String process()
	{
		return "process4"; //�������� jsp�̸�
	}
	

}
