<%@page import="project_hibernate_foodapp.dto.Items"%>
<%@page import="java.util.List"%>
<%@page import="project_hibernate_foodapp.dto.FoodOrder"%>
<%@page import="project_hibernate_foodapp.dto.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> display menu</title>
</head>
<body>
<%
	List<Menu> menus = (List) request.getAttribute("menus");
	%>
	<table border="2px solid">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Offer</th>
		</tr>
		<%
		for (Menu menu : menus) {
		%>
		<tr>
			<td><%=menu.getId()%></td>
			<td><%=menu.getName()%></td>
			<td><%=menu.getDescription()%></td>
			<td><%=menu.getPrice()%></td>
			<td><%=menu.getOffer()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<h4>Previous orders</h4>
	<%
	FoodOrder foodOrder=(FoodOrder)request.getAttribute("foodorder");
	%>
	<%
	if (foodOrder != null) {
	%>
	<table border="2px solid">
		<tr>
		<%
			for (Items items : foodOrder.getItems()) {
		%>
		<tr>
			<td><%=items.getName()%></td>
			<td><%=items.getDescription()%></td>
			<td><%=items.getPrice()%></td>
			<td><%=items.getOffer()%></td>
			<td><%=items.getQuantity()%></td>
			<td><%=items.getPrice() * items.getQuantity()%></td>
		</tr>
		<%
		}
		}
		
		%>
	</table>
	<a href="login.jsp"><button>StaffLogin</button></a>

</body>
</html>