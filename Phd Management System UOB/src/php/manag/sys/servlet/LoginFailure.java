package php.manag.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Crunchify.com
 */

public class LoginFailure extends HttpServlet
{

	@Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{

		// Calling when Back Button got pressed
		request.getRequestDispatcher( "login.jsp" ).forward( request, response );

	}
}