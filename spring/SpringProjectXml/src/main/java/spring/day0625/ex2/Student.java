package spring.day0625.ex2;

public class Student {
	
	String name;
	String hp;
	
	//������ ����...����Ʈ
	public Student() {
		name="default";
		hp="010-1111-2222";
	}
	
	//������ ����...���
	public Student(String name, String hp) {
		
		this.name=name;
		this.hp=hp;
		
	}
	
	//��¸޼���
	public void write()
	{
		System.out.println("name: "+name+", hp: "+hp);
	}
	

}
