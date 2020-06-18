<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 컨텍스트 주소 저장 --%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회한 회원정보 출력</title>
</head>
<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
			<td><b>이메일</b></td>
			<td><b>가입날짜</b></td>
		</tr>
		
	<c:forEach var="memberVO" items="${membersList}">
		<tr align="center">
			<td>${memberVO.id}</td>
			<td>${memberVO.pwd}</td>
			<td>${memberVO.name}</td>
			<td>${memberVO.email}</td>
			<td>${memberVO.joinDate}</td>
		</tr>
	</c:forEach>
	</table>
	
	<a href="${contextPath}/member/memberForm.do"><h1 style="text-align: center;">회원가입</h1></a>
</body>
</html>