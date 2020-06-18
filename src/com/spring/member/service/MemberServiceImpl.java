package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	// MemberDAO�� ���Թ޾� ������ ����
	private MemberDAO memberDAO;
	
	// setter �޼ҵ�
	// action-service.xml���� ȣ���ϴ� �޼ҵ�� MemberDAOImpl ��ü�� �Ű������� ���޹޾�..
	// �� ��������� memberDAO�� ���� ��Ű�� �޼ҵ�.
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
	
		// db�κ��� ��� ȸ���������(MemberVO��)�� �˻��Ͽ� -> ArrayList �迭�� ��� ������ ����
		List<MemberVO> membersList = null;
		membersList = memberDAO.selectAllMembers();
		
		// MemberControllerImpl �������� ��ȯ��
		return membersList;
	}
	
}
