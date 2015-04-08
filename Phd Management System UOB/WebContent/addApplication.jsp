<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Application Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="robots" content="noindex,nofollow" />
<title>Dynamically attach jQuery DatePicker to Text box</title>
<link rel="stylesheet" href="/resources/themes/master.css"
	type="text/css" />
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<script
	src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.js"
	type="text/javascript"></script>
<script src="/resources/scripts/mysamplecode.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(
			function() {

				var myCounter = 1;
				$(".myDate").datepicker();

				$("#moreDates").click(
						function() {

							$('.myTemplate').clone().removeClass("myTemplate")
									.addClass("additionalDate").show()
									.appendTo('#importantDates');

							myCounter++;
							$('.additionalDate input[name=inputDate]').each(
									function(index) {
										$(this).addClass("myDate");
										$(this).attr(
												"name",
												$(this).attr("name")
														+ myCounter);
									});

							$(".myDate").on('focus', function() {
								var $this = $(this);
								if (!$this.data('datepicker')) {
									$this.removeClass("hasDatepicker");
									$this.datepicker();
									$this.datepicker("show");
								}
							});

						});

			});
</script>
</head>
<body>

	<form action="AddApplication" method="post">
		<table>
			<thead>
				<tr>
					<td>UB Number:</td>
					<td><input name="ubNumber" type="text" maxlength="8" value='<%=((request.getAttribute( "ubNumber") == null) ? "" : request.getAttribute( "ubNumber")) %>'></td>
					<td></td>
					<td>Discipline:</td>
					<td><select name="discipline">
							<option value="mechanical">Mechanical</option>
							<option value="medical">Medical</option>
							<option value="civil">Civil</option>
							<option value="chemical">Chemical</option>
							<option value="electrical">Electrical</option>
							<option value="computing">Computing</option>
							<option value="filmAndMedia">Film and Media</option>
					</select></td>

				</tr>
				<tr>
					<td>First Name:</td>
					<td><input name="firstName" type="text" maxlength="49" value='<%=((request.getAttribute( "firstName") == null) ? "" : request.getAttribute( "firstName")) %>'></td>
					<td></td>
					<td>Title of Research:</td>
					<td><input name="titleOfresearch" type="text" maxlength="49" value='<%=((request.getAttribute( "titleOfresearch") == null) ? "" : request.getAttribute( "titleOfresearch")) %>'></td>

				</tr>
				<tr>
					<td>Middle Name:</td>
					<td><input name="middleName" type="text" maxlength="49" value='<%=((request.getAttribute( "middleName") == null) ? "" : request.getAttribute( "middleName")) %>'></td>
					<td></td>
					<td>Highest award</td>
					<td><input name="highestAward" type="text" maxlength="49" value='<%=((request.getAttribute( "highestAward") == null) ? "" : request.getAttribute( "highestAward")) %>'></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input name="lastName" type="text" maxlength="49" value='<%=((request.getAttribute( "lastName") == null) ? "" : request.getAttribute( "lastName")) %>'></td>
					<td></td>
					<td>Qualification of highest award</td>
					<td><input name="qualificationHighestAward" type="text" maxlength="49" value='<%=((request.getAttribute( "qualiHighAward") == null) ? "" : request.getAttribute( "qualiHighAward")) %>'></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input name="eMail" type="text" maxlength="49" value='<%=((request.getAttribute( "email") == null) ? "" : request.getAttribute( "email")) %>'></td>
					<td></td>
					<td>Other award</td>
					<td><input name="otherAward" type="text" maxlength="49" value='<%=((request.getAttribute( "otherAward") == null) ? "" : request.getAttribute( "otherAward")) %>'></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><input class="myDate" type="text" name="dateOfBirth"
						size="10"value='<%=((request.getAttribute( "birthday") == null) ? "" : request.getAttribute( "birthday")) %>' />&nbsp;(mm/dd/yyyy)</td>
					<td></td>
					<td>Qualification of other award</td>
					<td><input name="qualificationOtherAward" type="text" maxlength="49" value='<%=((request.getAttribute( "qualiOtherAward") == null) ? "" : request.getAttribute( "qualiOtherAward")) %>'></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><select name="gender" >
							<option value="f">Female</option>
							<option value="m">Male</option>
					</select></td>
					<td></td>
				</tr>
			</thead>
		</table>
		<table></table>
		<input type="submit" name="addApplication" value="Add Application">
		   <%=((request.getAttribute( "Error_Message") == null) ? "" : request.getAttribute( "Error_Message")) %>
		   <input type="submit" name="mainMenu" value="Main Menu"><br>
		   <br><input type="submit" name="logout" value="Logout"><br>
	</form>
</body>
</html>