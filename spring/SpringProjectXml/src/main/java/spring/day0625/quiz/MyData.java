package spring.day0625.quiz;

public class MyData {
	
	//Score, Info Ŭ������ ��������� ����
	Score score;
	Info info;
	
	
	//Score, Info �� ���� ���Թ޴� ������ �����
	public MyData(Score score, Info info) {
		this.score=score;
		this.info=info;
		
	}
	

	//��¸޼���(writeData�� �����)
	//���->�̸�,java,jsp,spring�� ����ϴ� �޼���
	public void writeData()
	{
		System.out.println("***������***");
		System.out.println("�̸�: "+info.getName());
		System.out.println("����: "+info.getAge());
		System.out.println("java����: "+score.getJava());
		System.out.println("jsp����: "+score.getJsp());
		System.out.println("spring����: "+score.getSpring());
		
	}
	
	

}
