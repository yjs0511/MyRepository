package ch07.service;

import java.util.List;

import ch07.dao.MemberDao;
import ch07.dto.Member;

public class MemberService {
	public static void main(String[] args){
		MemberDao dao = new MemberDao();
		
		// 아이디 정보를 주고 멤버 정보를 얻기
		Member member = dao.selectByMid("user2");
		System.out.println(member.getMid() + " : " + member.getMname());
		
		// 현재 총 멤버의 정보 얻기
		List<Member> list = dao.selectAll();
		for(Member m : list){
			System.out.println(m.getMid() + " : " + m.getMname());
		}
	}
}
