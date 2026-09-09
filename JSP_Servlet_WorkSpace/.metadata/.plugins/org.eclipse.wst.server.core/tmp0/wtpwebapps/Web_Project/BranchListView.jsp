<%@page import="com.rays.bean.BranchBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
	List<BranchBean> list = (List) request.getAttribute("list");
	Iterator<BranchBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Branch List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: skyblue">
				<th>id</th>
				<th>branchName</th>
				<th>city</th>
				<th>managerName</th>
				<th>contactNo</th>
			</tr>

			<%
			while (it.hasNext()) {
				BranchBean bean = it.next();
			%>

			<tr align="center" style="background-color: lightgrey">
				<td><%=bean.getId()%></td>
				<td><%=bean.getBranchName()%></td>
				<td><%=bean.getCity()%></td>
				<td><%=bean.getManagerName()%></td>
				<td><%=bean.getContactNo()%></td>
			</tr>

			<%
			}
			%>

		</table>

	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>