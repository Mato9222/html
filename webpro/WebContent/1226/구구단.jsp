<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border : 20px solid lightblue;
	border-spacing: 25px;
}
td { 
	border : 1px solid ;
	width : 30px;
	height : 30px;
	text-align : center;
	padding : 10px;
}

</style>
</head>
<body>
<%
	String str="<table border = '1'>";

	for (int i = 1; i < 10 ; i++) {
		str += "<tr>";
		for (int j = 1 ; j < 10 ; j++) {
			str += "<td>"+i*j+"</td>";
		}
		str += "</tr>";
	}
	str += "</table>";
%>

<%=str%>

</body>
</html>