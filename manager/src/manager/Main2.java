package manager;

import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDao memberDao = new MemberDao();
		
		//C(insert)
		MemberVo vo1 = new  MemberVo(1, "test1", "1234", "nick1");
		MemberVo vo2 = new  MemberVo(2, "test2", "1234", "nick2");
		MemberVo vo3 = new  MemberVo(3, "test3", "1234", "nick3");
		
		memberDao.inserMember(vo1);
		memberDao.inserMember(vo2);
		memberDao.inserMember(vo3);
		
		System.out.println("저장완료");
		
		//R(select)
		List<MemberVo> ls = memberDao.selectAll();
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체 조회 완료");
		
		MemberVo vo = null;
		vo = memberDao.selectMember(1);
		System.out.println(vo);
		
		vo = memberDao.selectMember(4);
		System.out.println(vo);
		System.out.println("조회완료");
		
		//U(update)
		vo = memberDao.selectMember(1);
		System.out.println(vo);
		
		if(vo != null) {
			vo.setMemberPw("4231");
			vo.setNickName("1nick");
			memberDao.updateMember(vo);
		}
		
		vo = memberDao.selectMember(1);
		System.out.println(vo);
		System.out.println("수정완료");
		
		//D(delete)
		memberDao.deleteMember(2);
		ls = memberDao.selectAll();
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체 조회 완료");
		
		memberDao.deleteAll();
		ls = memberDao.selectAll();
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체 조회 완료");
	}

}
