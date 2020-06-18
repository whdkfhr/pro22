package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {

	private MemberService memberService;
	
	// setter �޼ҵ�
	// action-service.xml���� ȣ���ϴ� �޼ҵ�� MemberServiceImpl��ü�� �Ű������� �޾�
	// �� memberService������ ����
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// member/listMembers.do �߿���... Ȯ���ڸ� .do�� ������ listMembers�� ��ȯ
		String viewName = getViewName(request);
		
		// db�κ��� �˻��� ��� ȸ��������(MemberVO��ü��)�� �����ϰ� �ִ� ArrayList�� ��ȯ �޴´�.
		List<MemberVO> membersList = memberService.listMembers();
		
		// ModelAndView ��ü�� ������ ������ M + �������� V �� ����
		ModelAndView mav = new ModelAndView(viewName);	// ���̸� listMembers ����
		mav.addObject("membersList", membersList);	// ������ ��ȸ�� ������ M ����
		
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName;
	}
	
}
