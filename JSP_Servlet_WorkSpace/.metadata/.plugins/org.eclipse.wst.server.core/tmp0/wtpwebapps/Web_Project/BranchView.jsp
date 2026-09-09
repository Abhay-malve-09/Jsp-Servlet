<%@page import="com.rays.util.ServletUtility"%>
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
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>
	<form action="BranchCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">Add Branch</h1>

			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
			<h3 style="color: red"><%=err != null ? err : ""%></h3>

			<table>

				<tr>
					<th>Branch Name:<font color="red">*</font></th>
					<td><input type="text" name="branchName" value=""
						placeholder="enter branchName"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("branchName", request)%></td>
				</tr>

				<tr>
					<th>City:<font color="red">*</font></th>
					<td><input type="text" name="city" value=""
						placeholder="enter city"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("city", request)%></td>
				</tr>

				<tr>
					<th>ManagerName:<font color="red">*</font></th>
					<td><input type="text" name="managerName" value=""
						placeholder="enter your managerName"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("managerName", request)%></td>
				</tr>

				<tr>
					<th>ContactNo:<font color="red">*</font></th>
					<td><input type="text" name="contactNo" value=""
						placeholder="enter your contactNo"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("contactNo", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="save"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>