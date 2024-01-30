<%@page import="kr.or.ddit.pard.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	ProdVO pvo = (ProdVO) request.getAttribute("pvo");

%>
	{
		"prod_id" : "<%=pvo.getProd_id() %>",
		"prod_name" : "<%=pvo.getProd_name() %>",
		"prod_buyer" : "<%=pvo.getProd_buyer() %>",
		"prod_lgu" : "<%=pvo.getProd_lgu() %>",
		"prod_cost" : "<%=pvo.getProd_cost() %>",
		"prod_price" : "<%=pvo.getProd_price() %>",
		"prod_sale" : "<%=pvo.getProd_sale() %>"
	}

