<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<p align="center">Phd Management System</p>
		<form action="Login">
			<table align="center">
				<tr>
					<td>Login:</td>
					<td><input type="text" name="username" style="width: 166px;"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"
						style="width: 166px;"></td>
				</tr>
				<tr>
					<td><input type="submit" name="sendBtn" value="Login"
						style="background-position: right" align="right"></td>
					<td><input type="submit" name="clearBtn" value="Clear"></td>
				</tr>

			</table>
		</form>

	</h1>



	<form action="PhdListServletMap"></form>
</body>
</html>