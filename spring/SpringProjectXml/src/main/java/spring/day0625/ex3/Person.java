package spring.day0625.ex3;

public class Person {
	PersonData data; //Ŭ������ ������ �����
	
	public Person(PersonData data) {
		super();
		this.data=data;
	}
	
	//��¹��޼ҵ�
	public void writeData()
	{
		System.out.println("�����: "+data.getSawonname());
		System.out.println("�޿�: "+data.getPay());
		System.out.println("�Ի���: "+data.getIpsaday());
		
	}

}
