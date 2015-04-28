<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	    <h1>PAMS</h1>	
	    <h2>University Of Bradford</h2>
	  </div><!--close site_heading-->
	  <div id="header">
	    <div id="menubar">
          <ul id="menu">
            <li class="auto-style1">Log Out</li>
            <li class="current">&nbsp;&nbsp;&nbsp; <a href="ourwork.html">Home</a></li>
            <li></li>
            <li></li>
          </ul>
        </div><!--close menubar-->
      </div><!--close header-->	  
	  	  
	    <!--close content-->	

      		  
	
	  <div id="content" class="auto-style3" style="height: 241px; width: 786px;">
	  <form action="AdminMenu" method="post" style="height: 187px">
		<input type="submit"  name="addApplication" value="Add Application" style="width: 500px; height: 40px; "><br>
		<input type="submit" name="viewResponses" value="View Responses" style="width: 500px; height: 40px; "><br>
		<input type="submit" name="addUser" value="Add User" style="width: 500px; height: 40px;"><br>
		<input type="submit" name="uploadFile" value="Upload File" style="width: 500px; height: 40px;"><br>
		<input type="submit" name="changeProposalStatus" value="Change Propsal Status" style="width: 500px;height: 40px; "><br>
		<input type="submit" name="logout" value="Logout" style="width: 500px; height: 40px; "><br>
	</form>
          </div>	
          

      		  
	
	</div><!--close site_content-->	
    <div id="footer" class="auto-style4" style="height: 45px">  
    </div><!--close footer-->		
  </div><!--close main-->	
</body>