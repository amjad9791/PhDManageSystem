package php.manag.sys.servlet;

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

			// checking for a valid mail address
			if( !isValidEmailAddress( eMail ) )
			{
				showAlert( "Mail Address is not valid" );
			}

			SqlLiteDatabase sql = new SqlLiteDatabase( );
			sql.insertApplication( firstName, middleName, lastName, eMail, dateOfBirth, gender );

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
	
	public void convertDateToSql(String date){
//		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
//		format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
//
//		java.util.Date date2 = format.parse(date);
//
//		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	}
}