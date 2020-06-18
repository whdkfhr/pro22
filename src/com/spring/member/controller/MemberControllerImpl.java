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
	
	// setter 메소드
	// action-service.xml에서 호출하는 메소드로 MemberServiceImpl객체를 매개변수로 받아
	// 위 memberService변수에 주입
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// member/listMembers.do 중에서... 확장자면 .do를 제외한 listMembers를 반환
		String viewName = getViewName(request);
		
		// db로부터 검색한 모든 회원정보들(MemberVO객체들)을 저장하고 있는 ArrayList를 반환 받는다.
		List<MemberVO> membersList = memberService.listMembers();
		
		// ModelAndView 객체에 응답할 데이터 M + 뷰페이지 V 만 저장
		ModelAndView mav = new ModelAndView(viewName);	// 뷰이름 listMembers 저장
		mav.addObject("membersList", membersList);	// 응답할 조회한 데이터 M 저장
		
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
