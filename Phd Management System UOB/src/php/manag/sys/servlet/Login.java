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

public class Login extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2443648499957228483L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{

		// Calling when Send Button got pressed
		if( request.getParameter( "sendBtn" ) != null )
		{
			// reading the user input
			String username = request.getParameter( "username" );
			String password = request.getParameter( "password" );

			// Testing if the user has entered values to the fields. Otherwise
			// he will be redirect to the loginFailure page
			if( username.equals( "" ) || password.equals( "" ) )
			{
				request.getRequestDispatcher( "loginFailure.jsp" ).forward( request, response );
			}
			else
			{ // Verifying the user for existence in the database
				SqlLiteDatabase sql = new SqlLiteDatabase( );
				String result = sql.dbValidUser( username, password );

				// Depending on the user type, it will open different interfaces
				if( result.equals( "professor" ) )
				{
					// request.getRequestDispatcher( "PhdListServlet.jsp"
					// ).forward(
					// request, response );
				}
				else if( result.equals( "admin" ) )
				{
					request.getRequestDispatcher( "adminMenu.jsp" ).forward( request, response );
				}
				else
				{
					// Such a user doesn't exist in the database
					request.getRequestDispatcher( "loginFailure.jsp" ).forward( request, response );
				}

				PrintWriter out = response.getWriter( );
			}
		}
		// Calling this clauses when the Clear Button got pressed
		else if( request.getParameter( "clearBtn" ) != null )
		{
			request.setAttribute( "hintField", "hintField" );
			request.getRequestDispatcher( "login.jsp" ).forward( request, response );
		}

	}
}