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
<title>View proposals page</title>



</head>
<body>
	<form action="ViewApplication" method="post">
		<div align="center">
			<table border="1" cellpadding="5">
				<caption>
					<h2>List of applications</h2>
					<h3><%=((request.getAttribute( "Error_Message") == null) ? "" : request.getAttribute( "Error_Message")) %></h3>
				</caption>
				<tr>
					<th>App ID<p><input type="radio" value="ASC" name="radApp_id" />+<input type="radio" value="DESC" name="radApp_id" />-</th>
					<th>UB Number<p><input type="radio" value="ASC" name="radUBNumber" />+<input type="radio" value="DESC" name="radUBNumber" />-</th>
					<th>First Name<p><input type="radio" value="ASC" name="radFirstName" />+<input type="radio" value="DESC" name="radFirstName" />-</th>
					<th>Middle Name<p><input type="radio" value="ASC" name="radMiddleName" />+<input type="radio" value="DESC" name="radMiddleName" />-</th>
					<th>Last Name<p><input type="radio" value="ASC" name="radLastName" />+<input type="radio" value="DESC" name="radLastName" />-</th>
					<th>Email<p><input type="radio" value="ASC" name="radEmail" />+<input type="radio" value="DESC" name="radEmail" />-</th>
					<th>Birthday<p><input type="radio" value="ASC" name="radBirthday" />+<input type="radio" value="DESC" name="radBirthday" />-</th>
					<th>Gender<p><input type="radio" value="ASC" name="radGender" />+<input type="radio" value="DESC" name="radGender" />-</th>
					<th>Discipline<p><input type="radio" value="ASC" name="radDiscipline" />+<input type="radio" value="DESC" name="radDiscipline" />-</th>
					<th>Title of research<p><input type="radio" value="ASC" name="radTitleOfResearch" />+<input type="radio" value="DESC" name="radTitleOfResearch" />-</th>
					<th>Highest award (HA)<p><input type="radio" value="ASC" name="radHA" />+<input type="radio" value="DESC" name="radHA" />-</th>
					<th>Qualification (HA)<p><input type="radio" value="ASC" name="radQualiHA" />+<input type="radio" value="DESC" name="radQualiHA" />-</th>
					<th>Other Award (OA)<p><input type="radio" value="ASC" name="radOA" />+<input type="radio" value="DESC" name="radOA" />-</th>
					<th>Qualification (OA)<p><input type="radio" value="ASC" name="radQualiOA" />+<input type="radio" value="DESC" name="radQualiOA" />-</th>
					<th>Admin User<p><input type="radio" value="ASC" name="radCreater" />+<input type="radio" value="DESC" name="radCreater" />-</th>
					<th>Status<p><input type="radio" value="ASC" name="radStatus" />+<input type="radio" value="DESC" name="radStatus" />-</th>
					<th>Supervisor<p><input type="radio" value="ASC" name="radSupervisor" />+<input type="radio" value="DESC" name="radSupervisor" />-</th>
					<th>Search and Filter<p>
							<input name="searchField" type="text" maxlength="49" value=''><input type="submit" name="filter" value="Filter" ></th>
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