package php.manag.sys.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

/**
 * @author Crunchify.com
 */

public class AddApplication extends HttpServlet
{

	private static final long serialVersionUID = -810903093372580449L;
	private int applicationNr;

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// Receiving the applicationNr from the viewApplication page
		ServletContext context = getServletContext( );

		if( context.getAttribute( "applicationNr" ) != null )
		{
			applicationNr = (Integer) context.getAttribute( "applicationNr" );
		}

		// Receiving the username from the login page
		String username = (String) context.getAttribute( "username" );

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

		// Filling the form with the values of an application. This happens when
		// the admin wants to edit a existing application
		if( applicationNr > 0 )
		{

		}

		// Calling when AddApplication Button is selected
		if( request.getParameter( "addApplication" ) != null )
		{
			// Receive all the entered values out of the form
			String ubNumber = request.getParameter( "ubNumber" );
			request.setAttribute( "ubNumber", ubNumber );
			String firstName = request.getParameter( "firstName" );
			request.setAttribute( "firstName", firstName );
			String middleName = request.getParameter( "middleName" );
			request.setAttribute( "middleName", middleName );
			String lastName = request.getParameter( "lastName" );
			request.setAttribute( "lastName", lastName );
			String eMail = request.getParameter( "eMail" );
			request.setAttribute( "email", eMail );
			String dateOfBirth = request.getParameter( "dateOfBirth" );
			request.setAttribute( "birthday", dateOfBirth );
			String gender = request.getParameter( "gender" );
			request.setAttribute( "gender", gender );
			String discipline = request.getParameter( "discipline" );
			request.setAttribute( "discipline", discipline );
			String titleOfresearch = request.getParameter( "titleOfresearch" );
			request.setAttribute( "titleOfresearch", titleOfresearch );
			String highestAward = request.getParameter( "highestAward" );
			request.setAttribute( "highestAward", highestAward );
			String qualificationHighestAward = request.getParameter( "qualificationHighestAward" );
			request.setAttribute( "qualiHighAward", qualificationHighestAward );
			String otherAward = request.getParameter( "otherAward" );
			request.setAttribute( "otherAward", otherAward );
			String qualificationOtherAward = request.getParameter( "qualificationOtherAward" );
			request.setAttribute( "qualiOtherAward", qualificationOtherAward );

			// Every field needs to be filled, otherwise a alert will inform the
			// user. Other Awards is an optional field
		    if( firstName.equals( "" ) || lastName.equals( "" ) || discipline.equals( "" ) || titleOfresearch.equals( "" ) || highestAward.equals( "" ) || qualificationHighestAward.equals( "" ) )
			{
				request.setAttribute( "Error_Message", "Please fill every field with your details" );
				request.getRequestDispatcher( "addApplication.jsp" ).forward( request, response );
			}
			// checking for a valid mail address
		    else if( !isValidEmailAddress( eMail ) )
			{
				request.setAttribute( "Error_Message", "Email Address is not valid" );
				request.getRequestDispatcher( "addApplication.jsp" ).forward( request, response );
			}
			// check the ub number for digits
			else if( !isValidDigit( ubNumber ) )
			{
				request.setAttribute( "Error_Message", "Numeric values only in UB number" );
				request.getRequestDispatcher( "addApplication.jsp" ).forward( request, response );
			}
			// check the first name and lastname are only characters 
			else if( isValidDigit( firstName ) || isValidDigit( middleName ) || isValidDigit( lastName ) )
			{
				request.setAttribute( "Error_Message", "Only characters in first name, middle name, last name" );
				request.getRequestDispatcher( "addApplication.jsp" ).forward( request, response );
			} 
			// All correct and it is alright to save the data into the database
			else
			{
				// Here are two cases, the first is that the admin register a
				// complete new application or the admin wants to edit a
				// existing application. If the value of application greater
				// than 0, the user intend to edit a application

				if( applicationNr > 0 )
				{
					SqlLiteDatabase sql = new SqlLiteDatabase( );
					sql.updateApplication( Integer.toString( applicationNr ), ubNumber, firstName, middleName, lastName, eMail, dateOfBirth, gender, discipline, titleOfresearch, highestAward, qualificationHighestAward, otherAward, qualificationOtherAward, username );
					applicationNr = 0;
					request.getRequestDispatcher( "ViewApplication" ).forward( request, response );
				}
				else
				{
					SqlLiteDatabase sql = new SqlLiteDatabase( );
					sql.insertApplication( ubNumber, firstName, middleName, lastName, eMail, dateOfBirth, gender, discipline, titleOfresearch, highestAward, qualificationHighestAward, otherAward, qualificationOtherAward, username );
					applicationNr = 0;
					request.getRequestDispatcher( "adminMenu.jsp" ).forward( request, response );
				}
			}
		}

		// Calling when Logout Button is selected
		if( request.getParameter( "logout" ) != null )
		{
			getServletContext( ).removeAttribute( "username" );
			response.sendRedirect( "login.jsp" );
			return;
		}

	}

	/**
	 * Validates the email address for correctness
	 * @param email the gives address will be validate
	 * @return true if it is valid otherwise false
	 */
	public boolean isValidEmailAddress( String email )
	{
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile( ePattern );
		java.util.regex.Matcher m = p.matcher( email );
		return m.matches( );
	}

	/**
	 * It validates numbers
	 * @param the given parameter has to be any string
	 * @return true if the parameter consists numbers otherwise false
	 */
	public boolean isValidDigit( String value )
	{
		try
		{
			Integer.parseInt( value );
			return true;
		}
		catch( NumberFormatException e )
		{
			return false;
		}
	}

}