package php.manag.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

import java.io.PrintWriter;

/**
 * @author Crunchify.com
 */

public class LoginFailure extends HttpServlet
{

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{

		// Calling when Back Button got pressed
		request.getRequestDispatcher( "login.jsp" ).forward( request, response );

	}
}