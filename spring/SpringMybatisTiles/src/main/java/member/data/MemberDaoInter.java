package member.data;

import java.util.List;

public interface MemberDaoInter {
	
	public List<MemberDto> getAllDatas();
	public void insertMember(MemberDto dto);
	
	//getDData
	public MemberDto getData(String num);
	
	//update
	public void updateMember(MemberDto dto);
	
	//delete
	public void deleteMember(String num);
	
	//���̵���üũ
	public boolean isLogin(String id, String pass);
	
	//���Ӿ��
	public String getName(String id);
	
}
