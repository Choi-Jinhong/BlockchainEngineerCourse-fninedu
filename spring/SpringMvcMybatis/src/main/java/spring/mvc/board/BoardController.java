package spring.mvc.board;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.data.BoardDaointer;
import board.data.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDaointer dao;
	
	//����Ʈ ��¹��� ������ ������
	@GetMapping("/list") //index���� ��ο� ����
	public ModelAndView list()
	{
		
		ModelAndView model=new ModelAndView();
		int totalCount=dao.getTotalCount();
		List<BoardDto> list=dao.getAllDatas();
		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		model.setViewName("board/list");
		return model;
	}
	//���� �Է½� insert�Ǵ� ������
	@PostMapping("/write") //���� �׼ǰ� ��ġ
	public String insert(@ModelAttribute BoardDto dto)
	{
		dao.insertBoard(dto);
		return "redirect:list";
	}
	
	//����Ʈ�� �۾��� ��ư�� Ŭ������ �� ���� �������� ����ó��
	@GetMapping("/writeform") //����Ʈ�� �۾����ư
	public String writeform()
	{
		return "board/writeForm";
	}
	
	//����Ʈ���� ������ ������ content�� ����ǵ��� ����
	@GetMapping("/content") //����Ʈ�� ���� a�±׷� ����� �̸�
	public ModelAndView content(@RequestParam String num)
	{
		ModelAndView model=new ModelAndView();
		BoardDto dto=dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("board/content");
		return model;
	}
	
	//������ư�� ������ �����Ϸ��� ����� �����Ͱ� ���δ�
	@GetMapping("/updateform")
	public ModelAndView updateform(@RequestParam String num)
	{
		ModelAndView model=new ModelAndView();
		BoardDto dto=dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("board/updateForm");
		return model;
	}
	
	//������ �� db���� ������ �����Ǳ�
	@GetMapping("/update")
	public String update(@ModelAttribute BoardDto dto)
	{
		
		dao.updateBoard(dto);
		return "redirect:list";
	
	}
	
	//������ �� �ٷ� list
	@GetMapping("/delete")
	public String delete(@RequestParam String num)
	{
		dao.deleteBoard(num);
		return "redirect:list";
	}
	
	
}
