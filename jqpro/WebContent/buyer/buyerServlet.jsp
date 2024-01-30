<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.buyer.service.IService"%>
<%@page import="kr.or.ddit.buyer.service.ServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	IService service = ServiceImpl.getInstance();

	List<BuyerVO> list = service.menu();
	
	request.setAttribute("list", list);
	
	request.getRequestDispatcher("/buyer/buyerView.jsp").forward(request, response);


%>
