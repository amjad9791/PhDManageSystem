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
  <style type="text/css">
  .auto-style1 {
	  margin-left: 0px;
  }
  .auto-style2 {
	  margin-top: 0px;
  }
  .auto-style3 {
	  font-size: small;
  }
  .auto-style4 {
	  font-size: medium;
	  color: #FFFFFF;
  }
  </style>
</head>

<body>
  <div id="main">	
	<div id="site_content">
      <div id="site_heading">
	    <h1>PAMS</h1>	
	    <h2>University of Bradford</h2>
	  </div><!--close site_heading-->
	  <div id="header">
	    <div id="menubar">
	    <form action="Login" class="auto-style2" style="width: 959px; height: 38px ">
			<table align="center"  >
				<tr>
					<td style="width: 45px " class="auto-style3">
					<span class="auto-style4">Login</span>:</td>
					<td><input type="text" name="username" autocomplete="off" style="width: 166px;"></td>
					<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>
			
					<td style="width: 61px"><span class="auto-style4">Password:</span> </td>
					<td><input type="password" name="password"
						style="width: 166px;" autocomplete="off" >
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>

					<td>
					<input type="submit" name="sendBtn" value="Login"
						style="background-position: right; width: 60px;" align="right" class="auto-style1"></td>
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>

					<td>
					<input type="submit" name="clearBtn" value="Clear" style="width: 61px"></td>
				</tr>

			</table>
		</form>
        </div><!--close menubar-->
        <div>
                </div>
      </div><!--close header-->	  
	  <div id="banner_image">
	    <div id="slider-wrapper">        
          <div id="slider" class="nivoSlider">
            <img src="images/slide1.jpg" alt="" />
            <img src="images/slide2.jpg" alt="" />
		  </div><!--close slider-->
		</div><!--close slider_wrapper-->
	  </div><!--close banner_image-->			  
	    <!--close content-->	    

        <!--close sidebar_container-->  
	  
    </div><!--close site_content-->	
    <div id="footer">  
      
    </div><!--close footer-->	
  </div><!--close main-->	
</body>
</html>
