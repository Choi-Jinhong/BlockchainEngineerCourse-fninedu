package upload.data;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	@GetMapping("/upload/uploadform")
	public String uploadform()
	{
		return "upload/uploadForm"; //jsp�ּ�
	}
	
	@PostMapping("/upload/upload")
	public ModelAndView upload(@RequestParam MultipartFile photo,
			@RequestParam String msg, HttpServletRequest request)
	{
		
		//�̹����� ���ε��� ��α��ϱ�
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
		
		//���ϸ�
		String fileName=photo.getOriginalFilename();
		
		//�̹��� ���忡 �ʿ��� fileUpload�� ���� ����� ����Ŭ����
		SpringFileWriter fileWriter=new SpringFileWriter();
		
		//�̹��� ���� �޼ҵ� ȣ��
		fileWriter.writeFile(photo, path, fileName);
		
		ModelAndView model=new ModelAndView();
		model.addObject("msg", msg);
		model.addObject("fileName", fileName);
		model.setViewName("upload/uploadResult");
		
		return model;
	}
}
