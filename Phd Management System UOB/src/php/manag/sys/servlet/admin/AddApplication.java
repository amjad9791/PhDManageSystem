package php.manag.sys.servlet.admin;

import java.io.IOException;

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

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		out = response.getWriter( );
		// Calling when AddApplication Button is selected
		if( request.getParameter( "addApplication" ) != null )
		{
			// Receive all the entered values out of the form
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
			//Every field needs to be filled, otherwise a alert will inform the user
			else if( firstName.equals( "" ) || lastName.equals( "" ) || discipline.equals( "" ) || titleOfresearch.equals( "" ) || highestAward.equals( "" ) || qualificationHighestAward.equals( "" ) || otherAward.equals( "" ) || qualificationOtherAward.equals( "" ) )
			{
				showAlert( "Please fill every field with your details" );
			}
			//All correct and saving the data into the database
			else
			{

				SqlLiteDatabase sql = new SqlLiteDatabase( );
				sql.insertApplication( firstName, middleName, lastName, eMail, dateOfBirth, gender, discipline, titleOfresearch, highestAward, qualificationHighestAward, otherAward, qualificationOtherAward );
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

	public void showAlert( String alertText )
	{
		out.println( "<script type=\"text/javascript\">" );
		out.println( "alert('" + alertText + "');" );
		out.println( "location='addApplication.jsp';" );
		out.println( "</script>" );
	}

}