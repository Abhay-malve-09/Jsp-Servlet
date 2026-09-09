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
	<form action="ProductCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">Add Product</h1>

			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
			<h3 style="color: red"><%=err != null ? err : ""%></h3>

			<table>

				<tr>
					<th>Product Name:<font color="red">*</font></th>
					<td><input type="text" name="productName" value=""
						placeholder="enter productName"></td>
				</tr>

				<tr>
					<th>Price:<font color="red">*</font></th>
					<td><input type="number" name="price" value=""
						placeholder="enter price"></td>
				</tr>

				<tr>
					<th>Quantity:<font color="red">*</font></th>
					<td><input type="number" name="quantity" value=""
						placeholder="enter your quantity"></td>
				</tr>

				<tr>
					<th>Category:<font color="red">*</font></th>
					<td><input type="text" name="category" value=""
						placeholder="enter your category"></td>
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