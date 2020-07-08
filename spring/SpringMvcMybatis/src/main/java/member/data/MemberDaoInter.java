package member.data;

import java.util.List;

public interface MemberDaoInter {
	
	//�߻�޼���
	public int getTotalCount();
	public List<MemberDto> getAllDatas();
	
	public void insertMember(MemberDto dto);
	public void updateMember(MemberDto dto);
	public void deleteMember(String no);
	public MemberDto getData(String no);
	
	
	

}
