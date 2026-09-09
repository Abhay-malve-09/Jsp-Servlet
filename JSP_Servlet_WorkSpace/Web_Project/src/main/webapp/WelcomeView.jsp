<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>
			Welcome To Online Result System<%=user != null ? "(" + user.getFirstName() + ")" : ""%></h1>


	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>