<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>s
	<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="php.manag.sys.db.SqlLiteDatabase"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Proposals Page</title>
</head>
<body>
	<form name="ChangeProposalStatus" action="ChangeProposalStatus">
		<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
			url="<%=SqlLiteDatabase.DB_URL%>" user="<%=SqlLiteDatabase.USER%>"
			password="<%=SqlLiteDatabase.PASSWORD%>" />
		<sql:query var="listUbNumbers" dataSource="${myDS}">
		SELECT ubNumber FROM application;
		</sql:query>
		<select name="listUBNumbers">
			<c:forEach var="user" items="${listUbNumbers.rows}">

				<option value="${user.ubNumber}">${user.ubNumber}</option>

			</c:forEach>
		</select> <select name="status">
		
		<option value="current">current</option>
				<option value="pending">pending</option>
				<option value="complete">complete</option>
		
		
		</select>
		<input type="submit" name="statusChangeBtn" value="Change Status">
		
	</form>

</body>
</html>