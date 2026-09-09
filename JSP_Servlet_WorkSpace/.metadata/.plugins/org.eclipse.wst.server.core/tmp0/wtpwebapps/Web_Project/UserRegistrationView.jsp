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

	<form action="UserRegistrationCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">User Registration</h1>

			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
			<h3 style="color: red"><%=err != null ? err : ""%></h3>


			<table>

				<tr>
					<th>First Name:<font color="red">*</font></th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter firstName"></td>
						<td style="color: red"><%=request.getAttribute("firstName") != null ? request.getAttribute("firstName") : "" %></td>
				</tr>

				<tr>
					<th>Last Name:<font color="red">*</font></th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter lastName"></td>
				        <td style="color: red"><%=request.getAttribute("lastName") != null ? request.getAttribute("firstName") : "" %></td>
						
				</tr>

				<tr>
					<th>Login:<font color="red">*</font></th>
					<td><input type="email" name="login" value=""
						placeholder="enter you email"></td>
						<td style="color: red"><%=request.getAttribute("login") != null ? request.getAttribute("login") : "" %></td>
						
				</tr>

				<tr>
					<th>Password:<font color="red">*</font></th>
					<td><input type="password" name="password" value=""
						placeholder="enter you password"></td>
						<td style="color: red"><%=request.getAttribute("password") != null ? request.getAttribute("password") : "" %></td>
						
				</tr>

				<tr>
					<th>Dob:<font color="red">*</font></th>
					<td><input type="date" name="dob" value=""></td>
					<td style="color: red"><%=request.getAttribute("dob") != null ? request.getAttribute("dob") : "" %></td>
					
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="signUp"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>