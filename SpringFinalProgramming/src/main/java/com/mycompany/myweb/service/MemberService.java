package com.mycompany.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;

@Component
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	public static final int LOGOUT_SUCCESS=0;
	public static final int LOGOUT_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int WITHDRAW_SUCCESS = 0;
	public static final int WITHDRAW_FAIL_MID = 1;
	public static final int WITHDRAW_FAIL_MPASSWORD = 2;
	
	public int join(Member member){	// 리턴 결과가 두 가지인 경우는 void로 처리(성공 or 예외[이건 리턴 값이 없기 때문에])
		memberDao.insert(member);
		return JOIN_SUCCESS;	// 여기선 실패의 경우는 처리하지 않는다 (예외가 발생하기 때문에 예외처리를 해 버리면 트랜잭션 처리를 할 수 없다.)
								// 스프링에서의 유효성 검사는 이 메소드가 실행하기 전에 한다.
	}
	
	public int login(String mid, String mpassword){		// 리턴 결과가 세가지인 경우는 리턴 타입을 정해야 한다_성공 or 실패의 경우 2가지(상수로 처리).
		Member member = memberDao.selectByMid(mid);
		if(member == null){ return LOGIN_FAIL_MID;}
		if(member.getMpassword().equals(mpassword) == false){return LOGIN_FAIL_MPASSWORD;}
		return LOGIN_SUCCESS;
	}
	
	public int logout(String mid){	// 서비스에선 가급적 HttpSesstion을 사용하지 않는게 좋다 (컨트롤러에서 하는게 좋다) service가 session에 종속되기 때문(session이 없으면 실행이 안된다)
		
		return LOGOUT_SUCCESS;
	}
	
	public String findMpassword(String mid, String memail){
		Member member = memberDao.selectByMid(mid);	
		if(member == null) return null;	// 입력한 mid가 존재 하지 않으면 null을 반환하도록 dao를 작성했으므로
		if(member.getMemail().equals(memail) == false) return null;
		return member.getMpassword();
	}
	
	public String findMid(String memail){
		return memberDao.selectByMemail(memail);
	}
	
	public Member info(String mid, String mpassword){
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false) return null;
		return member;
	}
	
	public int modify(Member member){	// 되거나 안되거나 (잘못 된 형식 검사는 여기서 하는 거 아님)
		Member dbMember = memberDao.selectByMid(member.getMid());
		if(dbMember.getMpassword().equals(member.getMpassword()) == false) return MODIFY_FAIL;
		int row = memberDao.update(member);
		if(row != 1) return MODIFY_FAIL;
		return MODIFY_SUCCESS;
	}
	
	public int withdraw(String mid, String mpassword){	// 성공 or 실패 2가지 (패스워드 틀릴 때, 홈쇼핑의 경우 물건 구매해 놓고 탈퇴하면 안되니까)
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false) return WITHDRAW_FAIL_MPASSWORD;
		memberDao.delete(mid);
		logout(mid);
		return WITHDRAW_SUCCESS;
	}
	
	public boolean isMid(String mid){
		Member member = memberDao.selectByMid(mid);
		if(member == null) return false;
			return true;
	}
}
