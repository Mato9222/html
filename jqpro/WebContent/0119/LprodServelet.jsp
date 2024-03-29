<%@page import="kr.or.ddit.lprod.vo.lprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.lprod.service.LprodServiceImpl"%>
<%@page import="kr.or.ddit.lprod.service.ILprodService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청시 전송데이터 받기
	
	// service객체 얻기
	ILprodService service = LprodServiceImpl.getInstance();

	// service 메소드 호출 - 결과값 받기 - List<LprodVO>
	List<lprodVO> list = service.selectLprod();
	
	// 결과값을 request에 저장
	request.setAttribute("listval", list);
	
	// setAttribute("name", 결과값);

	// View 페이지로 이동 - forward - lprodView.jsp
	request.getRequestDispatcher("/0119/lprodView.jsp").forward(request, response);

%>