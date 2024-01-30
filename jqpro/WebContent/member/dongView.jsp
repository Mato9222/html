<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// controller 에서 저장한 데이터 꺼내기
	List<ZipVO> list = (List<ZipVO>)request.getAttribute("list");
	// list객체를 json형태의 문자열로 직렬화 success로 보내기
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String res = gson.toJson(list); // [ { }, { }, { }... ]
	
	out.print(res);
	out.flush();
	
%>

