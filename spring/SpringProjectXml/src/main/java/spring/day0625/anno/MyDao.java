package spring.day0625.anno;

import org.springframework.stereotype.Component;

@Component

public class MyDao implements DaoInter {

	@Override
	public void insertData(String str) {
		System.out.println("str����Ÿ db�� �߰� ����!!!");

	}

	@Override
	public void deleteData(String num) {
		System.out.println("num�� �ش��ϴ� ����Ÿ ���� ����!!!");

	}

}
