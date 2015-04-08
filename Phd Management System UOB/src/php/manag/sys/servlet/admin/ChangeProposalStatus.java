package php.manag.sys.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

public class ChangeProposalStatus extends HttpServlet
{
	private static final long serialVersionUID = 3679454722520368334L;

	@Override
	// catches the button's action if clicked to establish connection and gets
	// the entered values of ubNumber and status.
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{

		String username = (String) getServletContext( ).getAttribute( "username" );
		// Check if it is a valid session.
		if( username == null )
		{
			// No valid session so send him back to the login page
			response.sendRedirect( "login.jsp" );
			return;
		}

		// Return to the main menu, when the back button is pressed
		if( request.getParameter( "mainMenu" ) != null )
		{
			response.sendRedirect( "adminMenu.jsp" );
			return;
		}

		if( request.getParameter( "statusChangeBtn" ) != null )
		{
			String ubNumber = request.getParameter( "listUBNumbers" );
			String status = request.getParameter( "status" );

			SqlLiteDatabase sql = new SqlLiteDatabase( );
			sql.updatePropsStatus( ubNumber, status );

			request.getRequestDispatcher( "adminMenu.jsp" ).forward( request, response );
		}

		// Calling when Logout Button is selected
		if( request.getParameter( "logout" ) != null )
		{
			getServletContext( ).removeAttribute( "username" );
			response.sendRedirect( "login.jsp" );
			return;
		}
	}

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		super.doPost( request, response );
	}

}
