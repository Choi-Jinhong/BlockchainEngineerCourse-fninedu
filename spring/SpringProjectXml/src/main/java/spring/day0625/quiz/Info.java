package spring.day0625.quiz;

public class Info {
	
	//������� �̸�, ���̷� �����
	private String name;
	private String age;
	
	//����Ʈ������
	public Info() {
		
	}
	
	//�̸�, ���̸� ���ڷ� �޴� ������ �����
	Info(String name, String age){
		this.name=name;
		this.age=age;
		
	}
	
	//setter, getter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	

}
