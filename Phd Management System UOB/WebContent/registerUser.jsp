<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register new-user Page</title>
</head>
<body>

	<form action="RegisterUser" method="post">

		<table border="1" cellpadding="5">
			<tr>
				<td>Username:</td>
				<td><input name="username" value='<%=((request.getAttribute( "username") == null) ? "" : request.getAttribute( "username")) %>' type="text" maxlength="49"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input name="password" type="text" maxlength="49"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name="email" value='<%=((request.getAttribute( "email") == null) ? "" : request.getAttribute( "email")) %>' type="text" maxlength="49"></td>
			</tr>
			<tr>
				<td>Role:</td>
				<td><select name="roleUser">
						<option value="professor">professor</option>
						<option value="admin">admin</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="registerUser" value="Register"></td>
				<td><input type="submit" name="clearUser" value="Clear"></td>
			</tr>
			<tr>
				<td></td>
				<td>${requestScope.Error_Message}</td>
			</tr>
		</table>

	</form>
</body>
</html>