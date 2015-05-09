<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
  <title>ARaynorDesign Template</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
  <style type="text/css">
.auto-style1 {
	color: #FFFFFF;
	font-size: medium;
}
  .auto-style3 {
	  margin-top: 1px;
	  margin-left: 290px;
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
	  <form action="RegisterUser" method="post">

		<table border="1" cellpadding="5">
			<tr>
				<td>Username:</td>
				<td><input name="username"
					value='<%=( ( request.getAttribute( "username" ) == null ) ? "" : request.getAttribute( "username" ) )%>'
					type="text" maxlength="49"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input name="password" type="text" maxlength="49"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name="email"
					value='<%=( ( request.getAttribute( "email" ) == null ) ? "" : request.getAttribute( "email" ) )%>'
					type="text" maxlength="49"></td>
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
		<br>
		<input type="submit" name="mainMenu" value="Main Menu"><br>
		<input type="submit" name="logout" value="Logout"><br>
	</form>          </div>	

      		  
	
	</div><!--close site_content-->	
    <div id="footer" class="auto-style4" style="height: 45px">  
    </div><!--close footer-->		
  </div><!--close main-->	
</body>
</html>