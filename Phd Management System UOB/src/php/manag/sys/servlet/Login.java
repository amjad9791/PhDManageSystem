package php.manag.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

public class Login extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2443648499957228483L;

	@Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
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
				request.setAttribute( "Error_Message",  "Enter a username and a password" );
				request.getRequestDispatcher( "login.jsp" ).forward( request, response );
			}
			else
			{ // Verifying the user for existence in the database
				SqlLiteDatabase sql = new SqlLiteDatabase( );
				String result = sql.dbValidUser( username, password );

				// Depending on the user type, it will open different interfaces
				if( result.equals( "professor" ) )
				{
					// Saving the username to carry it on to certain servlets
					getServletContext( ).setAttribute( "username", username );
					getServletContext( ).setAttribute( "role", "professor" );

					//Start the viewApplication to list all current applications
					request.getRequestDispatcher("ViewApplication").forward(request, response);
				}
				else if( result.equals( "admin" ) )
				{
					// Saving the username to carry it on to certain servlets
					getServletContext( ).setAttribute( "username", username );
					getServletContext( ).setAttribute( "role", "admin" );
					request.getRequestDispatcher( "adminMenu.jsp" ).forward( request, response );
				}
				else
				{
					// Such a user doesn't exist in the database
					request.setAttribute( "Error_Message",  "The user doesn't exist (Wrong username or password)" );
					request.getRequestDispatcher( "login.jsp" ).forward( request, response );
				}
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