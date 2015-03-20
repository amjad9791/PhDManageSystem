<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="php.manag.sys.db.SqlLiteDatabase"%>
<%@ page import="php.manag.sys.db.ListApplicationContainer"%>
<%@ page import="java.util.ArrayList"%>
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
					<th>Admin User</th>
					<th>Status</th>
					<th>Supervisor</th>
					<th>Function</th>
				</tr>

				<%
					// retrieve your list from the request, with casting 
					ArrayList< ListApplicationContainer > list = (ArrayList< ListApplicationContainer >) request.getAttribute( "listOfApplications" );

					// print the information about every category of the list
					for( ListApplicationContainer element : list )
					{
						out.println( "<tr>" );
						out.println( "<td>" + element.getApp_id( ) + "</td>" );
						out.println( "<td>" + element.getUbNumber( ) + "</td>" );
						out.println( "<td>" + element.getFirstName( ) + "</td>" );
						out.println( "<td>" + element.getMiddleName( ) + "</td>" );
						out.println( "<td>" + element.getLastName( ) + "</td>" );
						out.println( "<td>" + element.getEmail( ) + "</td>" );
						out.println( "<td>" + element.getBirthday( ) + "</td>" );
						out.println( "<td>" + element.getGender( ) + "</td>" );
						out.println( "<td>" + element.getDiscipline( ) + "</td>" );
						out.println( "<td>" + element.getTitleOfResearch( ) + "</td>" );
						out.println( "<td>" + element.getHighestAward( ) + "</td>" );
						out.println( "<td>" + element.getQualiHighAward(  ) + "</td>" );
						out.println( "<td>" + element.getOtherAward( ) + "</td>" );
						out.println( "<td>" + element.getQualiOtherAward( ) + "</td>" );
 						out.println( "<td>" + element.getCreaterUser( ) + "</td>" );
						out.println( "<td>" + element.getId_value( ) + "</td>" );
						out.println( "<td>" + element.getSupervisorName( ) + "</td>" );
						
						String role = (String) getServletContext( ).getAttribute( "role" );
						if( role.equals( "professor" ) )
						{
						
							out.println( "<td><input type='submit' name='butSupervisorYes_" + element.getApp_id( ) + "' value='Become Supervisor' /></td>" );
							out.println( "<td><input type='submit' name='butSupervisorNo_" + element.getApp_id( ) + "' value='Reject supervisor task' /></td>" );
						}
						else if( role.equals( "admin" ) )
						{
							out.println( "<td><input type='submit' name='butEditApp_" + element.getApp_id( ) + "' value='Edit application' /></td>" );
						}

						out.println( "</tr>" );
					}
				%>







			</table>
		</div>
	</form>
</body>
</html>