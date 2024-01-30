<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.buyer.service.ServiceImpl"%>
<%@page import="kr.or.ddit.buyer.service.IService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터를 안가져왔어 
	String name = request.getParameter("name");

	IService service = ServiceImpl.getInstance();
	
	BuyerVO list = service.detail(name);
	
	request.setAttribute("list", list);
	
	request.getRequestDispatcher("/buyer/nameView.jsp").forward(request, response);

%>