package spring.mvc.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.data.MemberDaoInter;
import member.data.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	MemberDaoInter dao;
	
	@GetMapping("/member/list")
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		List<MemberDto>list=dao.getAllDatas();
		
		model.addObject("list", list);
		model.addObject("cnt", list.size());
		model.setViewName("/member/memberList"); //Ÿ��������
		return model;
	}
	
	//ȸ������ ������ �� ������
	@GetMapping("/member/insertform")
	public String memberform()
	{
		return "/member/memberForm";
	}
	
	

	//���� �Է��� ȸ������ ������ �ٷ� ȸ��������� ������
	 
	 @PostMapping("/member/insert") 
	 public String insert(MemberDto dto) 
	 {
		 dao.insertMember(dto); 
		 return "redirect:list"; 
	 }
	 
	 
	 @GetMapping("/member/updateform")
	 public ModelAndView updateform(@RequestParam String num)
	 {
		 ModelAndView model = new ModelAndView();
		 MemberDto dto=dao.getData(num);
		 model.addObject("dto", dto);
		 model.setViewName("/member/updateForm");
		 return model;
	 }
	 
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto)
	{
		
		dao.updateMember(dto);
		return "redirect: list";
	}
	
	@GetMapping("/member/delete")
	public String delete(@RequestParam String num)
	{
		dao.deleteMember(num);
		return "redirect:list";
	}
	
	
	
	

}
