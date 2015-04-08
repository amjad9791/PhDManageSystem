<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="php.manag.sys.db.SqlLiteDatabase"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>Upload applications Page</title>
</head>
<body>


	<form name="uploadSelection" action="UploadFileProposal" method="post"
		enctype="multipart/form-data">

		<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
			url="<%=SqlLiteDatabase.DB_URL%>" user="<%=SqlLiteDatabase.USER%>"
			password="<%=SqlLiteDatabase.PASSWORD%>" />
		<sql:query var="listUbNumbers" dataSource="${myDS}">
		SELECT ubNumber FROM application WHERE ubNumber NOT IN ( SELECT ubNumber FROM app_file);
		</sql:query>
		<select name="listUBNumbers">
			<c:forEach var="user" items="${listUbNumbers.rows}">

				<option value="${user.ubNumber}">${user.ubNumber}</option>

			</c:forEach>
		</select> <input type="file" name="fileName"> <br> <input
			type="submit" value="Upload">

		<%=( ( request.getAttribute( "Error_Message" ) == null ) ? "" : request.getAttribute( "Error_Message" ) )%>
		<br>
		<input type="submit" name="mainMenu" value="Main Menu"><br>
		<input type="submit" name="logout" value="Logout"><br>
	</form>
	<p>
</body>
</html>