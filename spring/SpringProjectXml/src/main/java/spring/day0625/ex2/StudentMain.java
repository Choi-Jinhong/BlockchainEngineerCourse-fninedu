package spring.day0625.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//xml�� ���ؼ� ��ü����
		
	ApplicationContext app2=new ClassPathXmlApplicationContext("spring/test2/appContext2.xml");
	
	Student s1=app2.getBean("stu", Student.class); //���1
		s1.write();
		
	Student s2=(Student)app2.getBean("stu"); //���2
	s2.write();
	}

}
