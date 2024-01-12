<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#s1 {
	color : blue;
}	
#s2 {
	color : red;
}	
</style>
</head>
<body>
 <%!
private Connection conn = null;
private ResultSet rs = null;
private PreparedStatement ps = null;

private String driver ="oracle.jdbc.driver.OracleDriver";
private String url ="jdbc:oracle:thin:@localhost:1521:xe";
private String user ="JSY90";
private String password ="java";
%>

<%
	// 입력값 가져옴
	String userId = request.getParameter("id");

	//OracleDriver 클래스를 로드시킨다
	Class.forName(driver);
	
	// db 연결 객체
	conn=DriverManager.getConnection(url, user, password);
	
	//sql쿼리문 작성
	String sql = "select mem_id from member where mem_id=?";
	
	//실행 객체 
	ps = conn.prepareStatement(sql);
	
	//실행문에 값 셋팅 (몇번째 파라미터, 들어갈 변수)
	ps.setString(1, userId);
	
	//실행
	rs = ps.executeQuery();
	
	// 실행결과 비교하기 - 사용가능불가능 상태 출력
	if( rs.next()) { %>
		<span id="s1"><%=userId %></span> 는 사용<span id="s2">불가능</span> 아이디 입니다.
<% 	} else { %>
		<span id="s1"><%=userId %></span> 는 사용<span id="s2">가능</span> 아이디 입니다.
<%	}%>

</body>
</html>