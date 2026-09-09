<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <% %> script let tag use to write java code in html body in jsp page --%>
	<%-- <%= %> expression tag use to print java variable and object in jsp page --%>

	<%
	for (int i = 1; i <= 10; i++) {
	%>

	<h1><%=i%>Hello World
	</h1>

	<%
	}
	%>
</body>
</html>