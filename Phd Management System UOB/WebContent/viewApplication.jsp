<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="php.manag.sys.db.SqlLiteDatabase"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP List Users Records</title>
</head>
<body>
	<form action="ViewApplication">
		<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
			url="<%=SqlLiteDatabase.DB_URL%>"
			user="<%=SqlLiteDatabase.USER%>"
			password="<%=SqlLiteDatabase.PASSWORD%>" />

		<sql:query var="listUsers" dataSource="${myDS}">
		SELECT app.app_id, app.ubNumber, app.firstName, app.middleName, app.lastName,app.email,app.birthday, app.gender,app.discipline,app.titleOfresearch,app.highestAward,app.qualiHighAward,app.otherAward,app.qualiOtherAward,app.createrUser,app.timestamp,sta.id_value,GROUP_CONCAT(sv.supervisorName) AS supervisorName FROM application AS app  JOIN app_status_values AS sta ON app.id_status = sta.id_status LEFT JOIN supervisor AS sv ON sv.app_id = app.app_id GROUP BY app.app_id;
	</sql:query>

		<div align="center">
			<table border="1" cellpadding="5">
				<caption>
					<h2>List of applications</h2>
				</caption>
				<tr>
					<th>Number</th>
					<th>UB Number</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Birthday</th>
					<th>Gender</th>
					<th>Discipline</th>
					<th>Title of research</th>
					<th>Highest award (HA)</th>
					<th>Qualification (HA)</th>
					<th>Other Award (OA)</th>
					<th>Qualification (OA)</th>
					<th>Applicant</th>
					<th>Status</th>
					<th>Supervisor</th>
					<th>Function</th>
				</tr>
				<c:forEach var="user" items="${listUsers.rows}">
					<tr>
						<td><c:out value="${user.app_id}" /></td>
						<td><c:out value="${user.ubNumber}" /></td>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.middleName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.birthday}" /></td>
						<td><c:out value="${user.gender}" /></td>
						<td><c:out value="${user.discipline}" /></td>
						<td><c:out value="${user.titleOfresearch}" /></td>
						<td><c:out value="${user.highestAward}" /></td>
						<td><c:out value="${user.qualiHighAward}" /></td>
						<td><c:out value="${user.otherAward}" /></td>
						<td><c:out value="${user.qualiOtherAward}" /></td>
						<td><c:out value="${user.createrUser}" /></td>
						<td><c:out value="${user.id_value}" /></td>
						<td><c:out value="${user.supervisorName}" /></td>
						<c:if test="${applicationScope['role'] == 'professor'}">
							<td><input type="submit"
								name="butSupervisorYes_${user.app_id}" value="Become Supervisor" /></td>
							<td><input type="submit"
								name="butSupervisorNo_${user.app_id}"
								value="Reject supervisor task" /></td>
						</c:if>
						<c:if test="${applicationScope['role'] == 'admin'}">
							<td><input type="submit" name="butEditApp_${user.app_id}"
								value="Edit application" /></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>