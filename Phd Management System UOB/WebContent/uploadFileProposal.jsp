<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="php.manag.sys.db.SqlLiteDatabase"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head></head>
<body>


	<form name="uploadSelection" action="UploadDownloadFileServlet"
		method="post" enctype="multipart/form-data">
		
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
		</select> <input type="file" name="fileName"> <br> <input
			type="submit" value="Upload">
	</form>
</body>
</html>