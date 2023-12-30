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
<table border="1">
<%
	for (int i =1; i <= 9; i++) {
%>
	<tr>
<%
		for (int j = 1; j <= 9 ; j++ ) {
%>
		<td><%= i*j %></td>
<%
		}
%>
		</tr>
<%
	}
%>

</table>
</body>
</html>