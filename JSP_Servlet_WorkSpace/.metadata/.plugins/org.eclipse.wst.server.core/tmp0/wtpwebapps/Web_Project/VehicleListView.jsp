<%@page import="java.util.Iterator"%>
<%@page import="com.rays.bean.VehicleBean"%>
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
	List<VehicleBean> list = (List) request.getAttribute("list");
	Iterator<VehicleBean> it = list.iterator();
	
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	int pageNo = (int) request.getAttribute("pageNo");
	%>
	
		<%@ include file="Header.jsp"%>
		
		
<!-- 	<form action="UserListCtl" method="post"> -->
	<form action="VehicleListCtl.do" method="post">

	<div align="center">

		<h1>Vehicle List</h1>
		
		<h3 style="color: red"><%=err != null ? err : ""%></h3>
			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>


             <input type="hidden" name="pageNo" value="<%=pageNo%>">
             
             		<table>
				<tr>
					<td><input type="text" name="vehicleName" value=""
						placeholder="search by vehicleName"></td>
					<td><input type="text" name="model" value=""
						placeholder="search by model"></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>
             
		<table border="1px" width="100%">

			<tr style="background-color: skyblue">
				<th><input type="checkbox"
						onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)"></th>
				<th>id</th>
				<th>vehicleName</th>
				<th>model</th>
				<th>color</th>
				<th>price</th>
			</tr>

			<%
			while (it.hasNext()) {
				VehicleBean bean = it.next();
			%>

			<tr align="center" style="background-color: lightgrey">
				<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getVehicleName()%></td>
				<td><%=bean.getModel()%></td>
				<td><%=bean.getColor()%></td>
				<td><%=bean.getPrice()%></td>
			</tr>

			<%
			}
			%>

		</table>

            <h3>
				pageNo=<%=pageNo%>
			</h3>
	</div>

    <table width="100%">
			<tr>
				<!-- <td><input type="submit" name="operation" value="previous"></td> -->
				<td><input type="submit" name="operation" value="previous"
					<%=pageNo == 1 ? "disabled" : ""%>></td>
				<td align="center"><input type="submit" name="operation"
					value="delete"></td>
				<td align="right"><input type="submit" name="operation"
					value="next" <%=list.size() < 5 ? "disabled" : ""%>></td>
			</tr>
		</table>
	</form>
	
	<%@ include file="Footer.jsp"%>
	

</body>
</html>