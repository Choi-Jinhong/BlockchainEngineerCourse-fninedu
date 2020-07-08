package spring.day0625.anno2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TireMain {

	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("oracledb/annoContext.xml");
		
		//getBean�� name�� �����ϸ� Ŭ���������� �������� �ƴϸ� ��Ȯ�� �̸����� �����´�
		//�����ҽÿ� tireController
		
		
		TireController tc=(TireController)app.getBean("TIRECONT");
		tc.process();

	}

}
