package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	// MemberDAO를 주입받아 저장할 변수
	private MemberDAO memberDAO;
	
	// setter 메소드
	// action-service.xml에서 호출하는 메소드로 MemberDAOImpl 객체를 매개변수로 전달받아..
	// 위 멤버변수인 memberDAO에 주입 시키는 메소드.
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
	
		// db로부터 모든 회우너정보들(MemberVO들)을 검색하여 -> ArrayList 배열에 담아 저장할 변수
		List<MemberVO> membersList = null;
		membersList = memberDAO.selectAllMembers();
		
		// MemberControllerImpl 서블릿으로 반환ㄴ
		return membersList;
	}
	
}
