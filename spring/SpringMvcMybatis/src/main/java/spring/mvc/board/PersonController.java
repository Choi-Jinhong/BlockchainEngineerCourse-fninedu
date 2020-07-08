package spring.mvc.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import person.data.PersonDao;
import person.data.PersonDto;

@Controller
public class PersonController {
   
   @Autowired
   PersonDao dao;
   
   @GetMapping("/person/list")
   public ModelAndView list()
   {
      ModelAndView model = new ModelAndView();
      
      //dao���� ��ü�����͸� db�κ��� �����´�.
      
      List<PersonDto>list=dao.getAllDatas();
      //request�� list�� �߰��Ѵ�.
      model.addObject("list", list);
      model.addObject("cnt", list.size());
      //�������� jsp�� �����Ѵ�.
      model.setViewName("person/personList");
      return model;
   }
   
   //�ڷ��Է��ϱ� ��ư�� ������ ���� ������
   @GetMapping("/person/personform")
   public String inputform()
   {
	   return "person/personForm";
   }
   
   //�� �Է� �� ���� ��ư�� ������ �Է��� ���� ����ǰ�
   @GetMapping("/person/insert")
   public String insert(@ModelAttribute PersonDto dto)
   {
	   dao.insertPerson(dto);
	   return "redirect: list";
   }
   
   //����Ʈ���� ������ư�� ������ �������� ������
   @GetMapping("/person/updateform")
   public ModelAndView updateform(@RequestParam String num)
   
   {
	   ModelAndView model=new ModelAndView();
	   PersonDto dto=dao.getData(num);
	   model.addObject("dto", dto);
	   model.setViewName("person/personUpdateForm"); //jsp����
	   return model;
   }
   
   //�� �Է� �� ������ �ǰ� 
   @GetMapping("/person/update")
   public String update(@ModelAttribute PersonDto dto)
   {
	   dao.updatePerson(dto);
	   return "redirect: list";
   }
   
   //����Ŭ���ϸ� �����ǰ�
   @GetMapping("/person/delete")
   public String delete(@RequestParam String num)
   {
	   dao.deletePerson(num);
	   return "redirect:list";
	   
   }
   
}