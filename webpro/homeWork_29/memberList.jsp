<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border : 1px solid #01DFD7;
}
td {
	width : 150px;
	height : 50px;
	text-align : center;
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
	//String userId = request.getParameter("id");

	// OracleDriver 클래스를 로드시킨다
	Class.forName(driver);
	
	// db 연결 객체
	conn=DriverManager.getConnection(url, user, password);
	
	// sql쿼리문 작성
	String sql = "select mem_id,mem_name,mem_hp from member";
	
	// 실행 객체 
	ps = conn.prepareStatement(sql);
	
	// 실행문에 값 셋팅 (몇번째 파라미터, 들어갈 변수)
	//ps.setString(1, userId);
	
	// 실행  rs.next?
	rs = ps.executeQuery();
	
	// 실행결과 비교하기 - 사용가능불가능 상태 출력
	String str="<table border ='1'> <tr><td>아이디</td><td>이  름</td><td>전화번호</td></tr>";
	while(rs.next()) {
		String userId = rs.getString("MEM_ID");
		String userName = rs.getString("MEM_NAME");
		String userHp = rs.getString("MEM_HP");
	str += "<td>"+userId+"</td>";
	str += "<td>"+userName+"</td>";
	str += "<td>"+userHp+"</td>";
			str += "</tr>";
	}
%>

<%=str %>

</body>
</html>