package php.manag.sys.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Crunchify.com
 */

public class AddApplication extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -810903093372580449L;
	private PrintWriter out;
	private int applicationNr;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// Receiving the applicationNr from the viewApplication page
		ServletContext context = getServletContext( );
		if( context.getAttribute( "applicationNr" ) != null )
		{
			applicationNr = (Integer) context.getAttribute( "applicationNr" );
		}

		// Receiving the username from the login page
		String username = (String) context.getAttribute( "username" );

		// Creating a Html writer object to modify the webpage on runtime
		out = response.getWriter( );

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
			String firstName = request.getParameter( "firstName" );
			String middleName = request.getParameter( "middleName" );
			String lastName = request.getParameter( "lastName" );
			String eMail = request.getParameter( "eMail" );
			String dateOfBirth = request.getParameter( "dateOfBirth" );
			String gender = request.getParameter( "gender" );

			String discipline = request.getParameter( "discipline" );
			String titleOfresearch = request.getParameter( "titleOfresearch" );
			String highestAward = request.getParameter( "highestAward" );
			String qualificationHighestAward = request.getParameter( "qualificationHighestAward" );
			String otherAward = request.getParameter( "otherAward" );
			String qualificationOtherAward = request.getParameter( "qualificationOtherAward" );

			// checking for a valid mail address
			if( !isValidEmailAddress( eMail ) )
			{
				showAlert( "Mail Address is not valid" );
			}

			// check the ub number for digits
			if( !isValidDigit( ubNumber ) )
			{
				showAlert( "UB number are only digits" );
			}

			// Every field needs to be filled, otherwise a alert will inform the
			// user
			else if( firstName.equals( "" ) || lastName.equals( "" ) || discipline.equals( "" ) || titleOfresearch.equals( "" ) || highestAward.equals( "" ) || qualificationHighestAward.equals( "" ) || otherAward.equals( "" ) || qualificationOtherAward.equals( "" ) )
			{
				showAlert( "Please fill every field with your details" );
			}
			// All correct and saving the data into the database
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

	}

	public boolean isValidEmailAddress( String email )
	{
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile( ePattern );
		java.util.regex.Matcher m = p.matcher( email );
		return m.matches( );
	}

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

	public void showAlert( String alertText )
	{
		out.println( "<script type=\"text/javascript\">" );
		out.println( "alert('" + alertText + "');" );
		out.println( "location='addApplication.jsp';" );
		out.println( "</script>" );
	}

}