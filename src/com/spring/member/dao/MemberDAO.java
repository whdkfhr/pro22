package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {
	
	// 모든 회원정보 검색해서 반환
	public List<MemberVO> selectAllMembers() throws DataAccessException;
	
	// 새로운 회원을 db에 추가
	public int addMember(MemberVO memberVO) throws DataAccessException;
}
