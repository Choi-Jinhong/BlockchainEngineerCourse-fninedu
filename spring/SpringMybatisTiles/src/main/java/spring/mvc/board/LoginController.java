package spring.mvc.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.data.MemberDao;

@Controller
public class LoginController {
	
	@Autowired
	MemberDao dao;
	
	
	/*
	 * @GetMapping("/login/login") public String loginform() { return
	 * "/login/loginForm"; }
	 */
	
	@GetMapping("/login/login")
	public ModelAndView loginform(HttpSession session)
	{
		ModelAndView model=new ModelAndView();
		String loginok=(String)session.getAttribute("loginok");
		String id=(String)session.getAttribute("idok");
		String save=(String)session.getAttribute("saveok");
		
		if(loginok==null)
		{
			model.addObject("id", id==null?"":id);
			//ó�� ���� ������� �� �ΰ��̸� ����ϱ� ���ؼ� 
			model.addObject("save",save==null || save.equals("no")?"no":"yes");
			model.setViewName("/login/loginForm");
		}
		else //�α��� ����
		{
			String name=dao.getName(id);
			model.addObject("name", name);
			model.setViewName("/login/logoutForm");
		}
		return model;
	}
	
	//�α���ó��
	@PostMapping("/login/loginproc")
	public String loginproc(HttpSession session,
			@RequestParam String id,
			@RequestParam String pass,
			@RequestParam(value="idsave",required = false) String idsave)
	//@RequestParam�� true�̹Ƿ� ���̵� ������°� �ƴҶ� �α��� ���� �߻�
	{		
		//���̵� ���� üũ ���ص� ���� �ȳ��� ó������ �� 
		boolean sw=dao.isLogin(id, pass);
		
		//������ ���ǿ� 3���� ����
		if(sw)
		{
			session.setMaxInactiveInterval(60*60*8); 
			//8�ð� ���� ���ǻ������� �����ϸ� 30�� ����
			
			session.setAttribute("loginok", "yes");
			session.setAttribute("idok", id);
			
			//���̵����忡 üũ���ϸ� null���̹Ƿ�
			if(idsave==null)		
				session.setAttribute("saveok", "no");
			else
				session.setAttribute("saveok", "yes");
			
		}
		
		//���̵�� ����� ������ ���������� �α׾ƿ������� �����Ѵ�
		//���������� ���޼��� ����� �ٽ� �α��� 
		if(sw)
			return "redirect:login";
		else
		return "/login/passFail";
	}
	
		//�α׾ƿ��� ����...�α׾ƿ������� loginok�� ����� idok�� ���ܳ��´�
	@GetMapping("/login/logout")	
	public String logout(HttpSession session)
		{
			session.removeAttribute("loginok");  //�α���������
			return "redirect:login";

		}
		
		
}
