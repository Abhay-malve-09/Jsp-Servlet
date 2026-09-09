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
	<!-- <form action="VehicleCtl" method="post">
 -->
 <form action="VehicleCtl.do" method="post">
 
		<div align="center">

			<h1 style="color: darkblue;">Add Vehicle</h1>

			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
			<h3 style="color: red"><%=err != null ? err : ""%></h3>

			<table>

				<tr>
					<th>Vehicle Name:<font color="red">*</font></th>
					<td><input type="text" name="vehicleName" value=""
						placeholder="enter vehicleName"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("vehicleName", request)%></td>
				</tr>

				<tr>
					<th>Model:<font color="red">*</font></th>
					<td><input type="text" name="model" value=""
						placeholder="enter model"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("model", request)%></td>
				</tr>

				<tr>
					<th>Color:<font color="red">*</font></th>
					<td><input type="" name="color" value=""
						placeholder="enter your color"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("color", request)%></td>
				</tr>

				<tr>
					<th>Price:<font color="red">*</font></th>
					<td><input type="number" name="price" value=""
						placeholder="enter your price"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("price", request)%></td>
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