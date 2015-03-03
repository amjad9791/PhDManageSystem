<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

	<form action="AddApplication">
		<table>
			<thead>
				<tr>
					<td>First Name:</td>
					<td><input name="firstName"></td>
					<td>Gender:</td>
					<td><select name="gender">
							<option value="m">Male</option>
							<option value="w">Female</option>
					</select></td>
					<td>Cell</td>
				</tr>
				<tr>
					<td>Middle Name:</td>
					<td><input name="middleName"></td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input name="lastName"></td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input name="eMail"></td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><input class="myDate" type="text" name="dateOfBirth"
						size="10" value="" />&nbsp;(mm/dd/yyyy)</td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
				</tr>
			</thead>
		</table>
		<table></table>
		<input type="submit" name="addApplication" value="Add Application">
	</form>
</body>
</html>