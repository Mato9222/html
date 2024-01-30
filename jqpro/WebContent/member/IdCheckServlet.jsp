<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
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
	//여기는 서블릿 컨트롤러다

	// 요청시 전송 데이터 받기 
	//String memId = request.getParameter("id"); 직렬화하기전.ver
	StringBuffer buf = new StringBuffer();
	String line = null;
	
	BufferedReader reader = request.getReader();
	while((line = reader.readLine()) != null) {
		buf.append(line);
	};
	
	String reqdata = buf.toString(); // {"mem_id" : "입력값"}
	//역직렬화 - 객체 형태로 변환 
	Gson gson = new Gson();
	MemberVO vo = gson.fromJson(reqdata, MemberVO.class);
	//직렬화 완료 ? 
	
	String memId = vo.getMem_id();
	
	// service 객체 얻기
	IMemberService service = MemberServiceImpl.getInstance();
	
	// service 메소드 호출 - 결과값 받기 
	String res = service.selectById(memId);
	
	// 결과값을 request에 저장하기 
	request.setAttribute("res", res);
	
	// view페이지로 이동
	request.getRequestDispatcher("/member/idView.jsp").forward(request, response);

%>
</body>
</html>