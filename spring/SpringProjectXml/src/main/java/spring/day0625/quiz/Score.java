package spring.day0625.quiz;

public class Score {
	
	//�������3���� �����(java, jsp, spring)
	int java, jsp, spring;
	

	//����Ʈ������
	public Score() {
		
	}
	
	//3������ ��� ���ڷ� �޴� �����ڸ� ����� 
	public Score(int java, int jsp, int spring){
		
		this.java=java;
		this.jsp=jsp;
		this.spring=spring;
		
	}

	//setter,getter ���� �޾ƿ���
	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getJsp() {
		return jsp;
	}

	public void setJsp(int jsp) {
		this.jsp = jsp;
	}

	public int getSpring() {
		return spring;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}
	
	

	
	
	

}
