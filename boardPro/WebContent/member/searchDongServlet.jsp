<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	// 요청시 전송 데이터 받기
	String dong = request.getParameter("dong"); 	
		
	// service 객체 얻기
	IMemberService service = MemberServiceImpl.getInstance();
	
	// service 메소드 호출 - 결과값 받기
	List<ZipVO> list = service.selectByDong(dong);
	
	// request에 결과값 저장
	request.setAttribute("list", list);
	
	// View 페이지로 이동 
	request.getRequestDispatcher("/member/dongView.jsp").forward(request, response);
%>
</body>
</html>