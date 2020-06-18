package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {
	
	// ��� ȸ������ �˻��ؼ� ��ȯ
	public List<MemberVO> selectAllMembers() throws DataAccessException;
	
	// ���ο� ȸ���� db�� �߰�
	public int addMember(MemberVO memberVO) throws DataAccessException;
}
