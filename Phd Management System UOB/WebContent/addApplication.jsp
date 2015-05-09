<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
  <title>ARaynorDesign Template</title>
  <meta name="description" content="free website template" />
  <meta name="keywords" content="enter your keywords here" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.easing.min.js"></script>
  <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
  <script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
  </script>
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
  <style type="text/css">
.auto-style1 {
	color: #FFFFFF;
	font-size: medium;
}
  .auto-style3 {
	  margin-top: 1px;
	margin-left: 129px;
}
  .auto-style4 {
	margin-top: 71;
}
  </style>
</head>

<body>
  <div id="main">	
	<div id="site_content">
      <div id="site_heading">
	    <h1>PhD Application Management System</h1>	
	    <h2>University Of Bradford</h2>
	  </div><!--close site_heading-->
	  <div id="header">
	    <div id="menubar">
         
        </div><!--close menubar-->
      </div><!--close header-->	  
	  	  
	    <!--close content-->	

      		  
	
	  <div id="content" class="auto-style3" style="height: 241px; width: 786px;">
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
	</form>

	      </div>	

      		  
	
	</div><!--close site_content-->	
    <div id="footer" class="auto-style4" style="height: 45px">  
    </div><!--close footer-->		
  </div><!--close main-->	
</body>
</html>
