package spring.day0625.ex3;

public class PersonData {
	
	private String sawonname;
	private int pay;
	private String ipsaday;
	
	//����Ʈ������
	PersonData() {
		
	}
	
	
	//������� �����ڷ� ����
	PersonData(String sname) {
		sawonname=sname;
				
	}


	//����, �Ի絥�̴� setter�� ����
	
	public int getPay() {
		return pay;
	}


	public String getSawonname() {
		return sawonname;
	}


	public void setSawonname(String sawonname) {
		this.sawonname = sawonname;
	}


	public void setPay(int pay) {
		this.pay = pay;
	}


	public String getIpsaday() {
		return ipsaday;
	}


	public void setIpsaday(String ipsaday) {
		this.ipsaday = ipsaday;
	}
		

}
