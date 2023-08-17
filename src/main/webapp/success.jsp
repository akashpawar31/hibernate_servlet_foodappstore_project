<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> succssed</title>
</head>
<body>
<%
	String message = (String)request.getAttribute("message");
	if (message != null) {
	%>
	<h3><%=message%></h3>
	<%
	}
	%>
	<table>
		<tr>
			<td><a href="home.jsp"><button>HOME</button></a></td>
			<td><a href="login.jsp"><button>LOGIN</button></a></td>
		</tr>
	</table>

</body>
</html>