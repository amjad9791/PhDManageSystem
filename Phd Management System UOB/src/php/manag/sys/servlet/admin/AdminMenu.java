package php.manag.sys.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Crunchify.com
 */

public class AdminMenu extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6192688008912715427L;

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String username = (String) getServletContext( ).getAttribute( "username" );
		//Check if it is a valid session.
		if(username == null){
			//No valid session so send him back to the login page		
			response.sendRedirect( "login.jsp" );
			return;
		}
		
		// Calling when AddApplication Button is selected
		if( request.getParameter( "addApplication" ) != null )
		{
			request.getRequestDispatcher( "addApplication.jsp" ).forward( request, response );
		}

		// Calling this clauses when the viewResponses Button got pressed
		else if( request.getParameter( "viewResponses" ) != null )
		{
			getServletContext( ).removeAttribute( "applicationNr" );
			getServletContext( ).setAttribute( "applicationNr", 0 );
			request.getRequestDispatcher( "ViewApplication" ).forward( request, response );
		}

		// Calling this clauses when the pending Button got pressed
		else if( request.getParameter( "addUser" ) != null )
		{
			request.getRequestDispatcher( "registerUser.jsp" ).forward( request, response );
		}

		// Calling when Upload File Button is selected
		else if( request.getParameter( "uploadFile" ) != null )
		{
			request.getRequestDispatcher( "uploadFileProposal.jsp" ).forward( request, response );
		}
		// Calling when ChangePropsalStatus Button is selected
		if( request.getParameter( "changeProposalStatus" ) != null )
		{
			request.getRequestDispatcher( "changeProposalStatus.jsp" ).forward( request, response );
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
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{

	}
}