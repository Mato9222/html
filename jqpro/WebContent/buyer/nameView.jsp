<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BuyerVO list = (BuyerVO) request.getAttribute("list");
%>
	{
		"buyer_name" : "<%=list.getBuyer_name() %>",
		"buyer_bank" : "<%=list.getBuyer_bank() %>",
		"buyer_bankno" : "<%=list.getBuyer_bankno() %>",
		"buyer_bankname" : "<%=list.getBuyer_bankname() %>",
		"buyer_comtel" : "<%=list.getBuyer_comtel() %>"
		
	}
	





