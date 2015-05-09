<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="php.manag.sys.db.SqlLiteDatabase"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="php.manag.sys.db.SqlLiteDatabase"%>
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
	  margin-left: 237px;
  }
  .auto-style4 {
	  margin-top: 71;
  }
  .auto-style5 {
	  margin-left: 0px;
  }
  .auto-style6 {
	  margin-left: 154px;
  }
  .auto-style7 {
	  margin-left: 86px;
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
	  <form name="ChangeProposalStatus" action="ChangeProposalStatus" class="auto-style5">
		<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
			url="<%=SqlLiteDatabase.DB_URL%>" user="<%=SqlLiteDatabase.USER%>"
			password="<%=SqlLiteDatabase.PASSWORD%>" />
		<sql:query var="listUbNumbers" dataSource="${myDS}">
		SELECT DISTINCT ubNumber FROM application;
		</sql:query>
		<select name="listUBNumbers">
			<c:forEach var="user" items="${listUbNumbers.rows}">

				<option value="${user.ubNumber}">${user.ubNumber}</option>

			</c:forEach>
		</select> <select name="status">
		
		<option value="current">current</option>
				<option value="pending">pending</option>
				<option value="complete">complete</option>
		
		
		</select>
		<input type="submit" name="statusChangeBtn" value="Change Status"> <br>
		<br>
		  <input type="submit" name="logout" value="Logout" class="auto-style7" style="width: 163px; height: 26px"><input type="submit" name="mainMenu" value="Main Menu" class="auto-style6" style="width: 148px"><br>
	</form>          </div>	

      		  
	
	</div><!--close site_content-->	
    <div id="footer" class="auto-style4" style="height: 45px">  
    </div><!--close footer-->		
  </div><!--close main-->	
</body>
</html>
