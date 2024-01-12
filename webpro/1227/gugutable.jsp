<%@page import="com.itextpdf.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border : 10px solid lightblue;
	border-spacing: 20px;
}
td { 
	border : none; 
	border-bottom : 1px solid skyblue;
	width : 35px;
	height : 35px;
	text-align : center;
}

</style>
</head>
<body>

<%
	String str="<table border = '1'>";
	String gugu=request.getParameter("gugu");
	int dan = Integer.parseInt(gugu);
	
	str += "<tr>";
		for (int i = 1; i < 10 ; i++) {
			str += "<td>"+dan+"</td>";
			str += "<td>*</td>";
			str += "<td>"+i+"</td>";
			str += "<td>=</td>";
			str += "<td>"+(dan*i)+"</td>";
		str += "</tr>";
	}
	str += "</table>";
%>

<%=str%>

</body>
</html>