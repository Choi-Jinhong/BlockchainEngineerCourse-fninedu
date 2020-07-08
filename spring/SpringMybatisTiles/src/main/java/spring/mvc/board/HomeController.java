package spring.mvc.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import info.data.InfoDaoInter;
import info.data.InfoDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private InfoDaoInter dao;
	
	

	//index���� ������ �����ּ� home
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String mainview() {
		
		return "home.tiles"; //jsp�ּҸ� tiles�� value������ ����
	}
	
	//�޴� ���� ������ �����ּ�
	@GetMapping("/info/list")
	/*
	 * public String listview() {
	 * 
	 * //return "list.tiles"; //jsp�ּҸ� tiles�� value������ ���� return "/info/list"; }
	 */
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		List<InfoDto>list=dao.getAllDatas();
		model.addObject("list", list);
		model.setViewName("/info/list"); //Ÿ���� ����
		return model;
	}
	
	
	@GetMapping("/info/insertform")
	public String inputform() {
		//return "input.tiles";
		return "/info/inputForm";
		
	}
	
	@GetMapping("/info/insert")
	public String insert(@ModelAttribute InfoDto dto ) {
		
		dao.insertInfo(dto);
		return "redirect:list";
	}
	
	@GetMapping("/info/updateform")
	public ModelAndView updateform(@RequestParam String num) {
		
		ModelAndView model=new ModelAndView();
		InfoDto dto=dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("/info/updateForm");
		
		return model;
	}
	
	@PostMapping("/info/update")
	public String update(@ModelAttribute InfoDto dto) {
		dao.updateInfo(dto);
		return "redirect:list";
		
	}
	
	@GetMapping("/info/delete")
	public String delete(@RequestParam String num)
	{
		dao.deleteInfo(num);
		return "redirect:list";
	}
	
	
	
	

}
