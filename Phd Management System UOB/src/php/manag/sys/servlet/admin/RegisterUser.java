package php.manag.sys.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

/**
 * @author Crunchify.com
 */

public class RegisterUser extends HttpServlet
{

	private PrintWriter out;
	private static final long serialVersionUID = 6192688008912715427L;

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String username = (String) getServletContext( ).getAttribute( "username" );
		/// Check if it is a valid session.
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

		SqlLiteDatabase sql = new SqlLiteDatabase( );

		// Calling when register Button is selected
		if( request.getParameter( "registerUser" ) != null )
		{
			username = request.getParameter( "username" );
			String password = request.getParameter( "password" );
			String email = request.getParameter( "email" );
			String roleUser = request.getParameter( "roleUser" );

			
			if( username.equals( "" )|| password.equals( "" ) || email.equals( "" ) )
			{
				request.setAttribute( "Error_Message", "Please enter data" );
				request.setAttribute( "username", username );
				request.setAttribute( "email", email );
				request.getRequestDispatcher( "registerUser.jsp" ).forward( request, response );
			}
			else if( !isValidEmailAddress( email ) )
			{
				request.setAttribute( "Error_Message", "The Email Address is not valid" );
				request.setAttribute( "username", username );
				request.setAttribute( "email", email );
				request.getRequestDispatcher( "registerUser.jsp" ).forward( request, response );
			}
			else if( sql.isUserOREmailExisting( username, email ) )
			{
				request.setAttribute( "Error_Message", "The User or email address is already existing. Please choose another" );
				request.setAttribute( "username", username );
				request.setAttribute( "email", email );
				request.getRequestDispatcher( "registerUser.jsp" ).forward( request, response );
			}
			else
			{
				sql.createUser( username, encryptPassword( password ), email, roleUser );
				request.getRequestDispatcher( "adminMenu.jsp" ).forward( request, response );
			}
		}
		// Calling this clauses when the clear Button got pressed
		else if( request.getParameter( "clearUser" ) != null )
		{
			request.getRequestDispatcher( "registerUser.jsp" ).forward( request, response );
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

	
	/**The SHA hash functions are a set of cryptographic hash functions designed by the National Security Agency (NSA)
	 * SHA-1 is believe the most secure hashing algorithm as this article is written
	 * @param password this password gets encrypted 
	 * @return returns the encrpted password
	 */
	private static String encryptPassword( String password )
	{
		String sha1 = "";
		try
		{
			MessageDigest crypt = MessageDigest.getInstance( "SHA-1" );
			crypt.reset( );
			crypt.update( password.getBytes( "UTF-8" ) );
			sha1 = byteToHex( crypt.digest( ) );
		}
		catch( NoSuchAlgorithmException e )
		{
			e.printStackTrace( );
		}
		catch( UnsupportedEncodingException e )
		{
			e.printStackTrace( );
		}
		return sha1;
	}

	private static String byteToHex( final byte[ ] hash )
	{
		Formatter formatter = new Formatter( );
		for( byte b : hash )
		{
			formatter.format( "%02x", b );
		}
		String result = formatter.toString( );
		formatter.close( );
		return result;
	}
}