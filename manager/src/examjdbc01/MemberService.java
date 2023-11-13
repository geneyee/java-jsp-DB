package examjdbc01;

import java.util.List;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// ����ϱ�
	public boolean regist(MemberVo vo) {
		
		if(memberDao.selectMember(vo.getNum()) == null) {
			memberDao.insertMember(vo);
			return true;
		}
		return false;
	}
	
	// ��ȸ
	public MemberVo read(int num) {
		return memberDao.selectMember(num);
	}
	
	// ��ü ��ȸ
	public List<MemberVo> listAll(){
		return memberDao.selectAll();
	}
	
	// ����
	public void edit(MemberVo vo) {
		MemberVo searchMember = memberDao.selectMember(vo.getNum());
		
		if(searchMember.getMemberPw().equals(vo.getMemberPw())) {
			memberDao.updateMember(vo);
		}
	}
	
	// Ż��
	public void remove(int num) {
		memberDao.deleteMember(num);
	}
}