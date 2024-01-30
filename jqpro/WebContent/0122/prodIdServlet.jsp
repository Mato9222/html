<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="kr.or.ddit.pard.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
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
	// 요청시 전송 데이터 받기
	//String id = request.getParameter("id");

	// 직렬화 된 데이터를 stream을 이용하여 가져온다.
	StringBuffer buf = new StringBuffer();
	String line = null;
	
	BufferedReader reader = request.getReader();
	while((line = reader.readLine()) != null) {
		buf.append(line);
	};
	
	String reqdata = buf.toString();
	
	Gson gson = new Gson();
	ProdVO vo = gson.fromJson(reqdata, ProdVO.class);
	// vo.setProd_id("P10100001") 형태

	String id = vo.getProd_id();

	// service객체 얻기
	IProdService service = ProdServiceImpl.getInstance();
	
	// service 메소드 호출 - 결과값 - ProdVO
	ProdVO list = service.selectById(id);
	
	// 결과값을 request에 저장
	request.setAttribute("pvo", list);
	
	// view페이지로 이동 - /0122/prodIdView.jsp
	request.getRequestDispatcher("/0122/prodIdView.jsp").forward(request, response);
	
%>

</body>
</html>