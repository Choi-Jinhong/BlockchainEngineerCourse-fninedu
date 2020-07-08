package spring.mvc.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UploadController {
   
   @Autowired
   UploadDaoInter dao;
   
   @GetMapping("/list") //����������.. �ε��� ���� �������ϸ� ������/��Ʈ
   public ModelAndView list() {
      
      ModelAndView model = new ModelAndView();
      int totalcount = dao.getTotalCount();
      List<UploadDto> list = dao.getAllDatas();
      
      model.addObject("list", list);
      model.addObject("totalcount", totalcount);
      model.setViewName("upload/uploadList");
      
      return model;
   }
   
   //�۾��� ������ ���� ���̰�
   @GetMapping("/form")
   public String form() {
      
      return "upload/uploadForm";
   }
   
   //�����Է��� db�����ư ������ ��... ���������
   @PostMapping("/write")
   public String write(@ModelAttribute UploadDto dto, HttpServletRequest request) {
      
      //photo: ��Ƽ��Ʈ: �ֿܼ� ������
      System.out.println("�̹�����: " + dto.getPhoto().getOriginalFilename());
      //��Ĺ������ ��θ� ���ؾ� ������Ʈ ��θ� ���� �� �ִ� 
      //web-inf/save���
      String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
      System.out.println("path= " + path);
      
      //�̹����� path�� ����
      FileOutputStream fos = null;
      
      try {
         fos = new FileOutputStream(path + "\\" + dto.getPhoto().getOriginalFilename());
         
         byte []uploadData = dto.getPhoto().getBytes();
         fos.write(uploadData);
         
         
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         
      } finally {
         try {
            fos.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
      }//dto �� �����µ� �̹��� �̸� �ȵ���
      //�̹��� �̸��� dto�� ����
      //db�� �����ؾ� ���߿� ������ �� ����
      dto.setPhotoname(dto.getPhoto().getOriginalFilename());
      
      //insert
      dao.insertUpload(dto);
      
      return "redirect:list"; //list��Ʈ�ѷ�
      
   }
   
   //���� �� �ٽ� ����Ʈ��
   @GetMapping("/delete")
   public String delete(@RequestParam String num,
         HttpServletRequest request) {
      
      String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
      System.out.println("path=" + path);
      
      //�����ϱ� ���� ���� ó��
      //�������ϸ��� ��������? 
      String fileName = dao.getData(num).getPhotoname();
      
      //���ϰ�ü ����.. ���� �����Ѵٸ� ����
      File file = new File(path + "\\" + fileName);
      if(file.exists()) //�����ϸ� true
         file.delete();
      
      
      dao.deleteUpload(num);
      return "redirect:list";
   }
   
   
   //������ư ������ �������� ���´�
   @GetMapping("/updateform") //����Ʈ�� ������ư
   public ModelAndView updateform(@RequestParam String num) {
      
      ModelAndView model = new ModelAndView();
      UploadDto dto = dao.getData(num);
      model.addObject("dto", dto);
      model.setViewName("upload/updateForm");
      
      return model;
   }
   
   
   //db���� ������ ���� �� ����Ʈ��
   @PostMapping("/update")
   public String update(@ModelAttribute UploadDto dto,
         HttpServletRequest request) {
      
      //photo: ��Ƽ��Ʈ: �ֿܼ� ������
      System.out.println("�̹�����: " + dto.getPhoto().getOriginalFilename());
      //��Ĺ������ ��θ� ���ؾ� ������Ʈ ��θ� ���� �� �ִ� 
      //web-inf/save���
      String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
      System.out.println("path= " + path);
      
      //�̹����� path�� ����
      FileOutputStream fos = null;
      
      try {
         fos = new FileOutputStream(path + "\\" + dto.getPhoto().getOriginalFilename());
         
         byte []uploadData = dto.getPhoto().getBytes();
         fos.write(uploadData);
         
         
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         
      } finally {
         try {
            fos.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
      }//dto �� �����µ� �̹��� �̸� �ȵ���
      //�̹��� �̸��� dto�� ����
      //db�� �����ؾ� ���߿� ������ �� ����      
      
      
      //�����̹��� �����ϰ�,
         //�����ϱ� ���� ���� ó��
         //�������ϸ��� ��������? 
         String fileName = dao.getData(dto.getNum()).getPhotoname();
            
         //���ϰ�ü ����.. ���� �����Ѵٸ� ����
         File file = new File(path + "\\" + fileName);
         if(file.exists()) //�����ϸ� true
            file.delete();
      
      
      dto.setPhotoname(dto.getPhoto().getOriginalFilename());
      
      //update
      dao.updateUpload(dto);
      
      return "redirect:list"; //list��Ʈ�ѷ�
      
   }
   

}