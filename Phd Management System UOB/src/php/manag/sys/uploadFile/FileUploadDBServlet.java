package php.manag.sys.uploadFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import php.manag.sys.db.SqlLiteDatabase;

@WebServlet( "/uploadServlet" )
@MultipartConfig( maxFileSize = 16177215 )
// upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
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

		// Calling when Logout Button is selected
		if( request.getParameter( "logout" ) != null )
		{
			getServletContext( ).removeAttribute( "username" );
			response.sendRedirect( "login.jsp" );
			return;
		}

		// gets values of text fields
		String ubNumbers = request.getParameter( "listUBNumbers" );

		InputStream inputStream = null; // input stream of the upload file

		// obtains the upload file part in this multipart request
		Part filePart = request.getPart( "fileName" );
		if( filePart != null )
		{
			// prints out some information for debugging
			System.out.println( filePart.getName( ) );
			System.out.println( filePart.getSize( ) );
			System.out.println( );

			//Set error if no file is selected
			if(filePart.getSize( ) <= 0){
				request.setAttribute( "Error_Message", "No file is selected" );
				request.getRequestDispatcher( "uploadFileProposal.jsp" ).forward( request, response );
				return;
			}
			
			// only PDF files are allowed
			if( filePart.getContentType( ).equals( "application/pdf" ) )
			{
				// obtains input stream of the upload file
				inputStream = filePart.getInputStream( );
			}
			else
			{
				// Set error message to inform user about the file type
				request.setAttribute( "Error_Message", "Only PDF files are allowed" );
				request.getRequestDispatcher( "uploadFileProposal.jsp" ).forward( request, response );
				return;
			}
		}

		Connection conn = null; // connection to the database
		String message = null; // message will be sent back to client

		try
		{
			// connects to the database
			DriverManager.registerDriver( new com.mysql.jdbc.Driver( ) );
			// database connection settings
			conn = DriverManager.getConnection( SqlLiteDatabase.DB_URL, SqlLiteDatabase.USER, SqlLiteDatabase.PASSWORD );

			// constructs SQL statement
			String sql = "INSERT INTO app_file (ubNumber, file) values (?, ?)";
			PreparedStatement statement = conn.prepareStatement( sql );
			statement.setInt( 1, Integer.parseInt( ubNumbers ) );

			if( inputStream != null )
			{
				// fetches input stream of the upload file for the blob column
				statement.setBlob( 2, inputStream );
			}

			// sends the statement to the database server
			int row = statement.executeUpdate( );
			if( row > 0 )
			{
				message = "File uploaded and saved into database";
				request.getRequestDispatcher( "adminMenu.jsp" );
			}
		}
		catch( SQLException ex )
		{
			message = "ERROR: " + ex.getMessage( );
			ex.printStackTrace( );
		}
		finally
		{
			if( conn != null )
			{
				// closes the database connection
				try
				{
					conn.close( );
				}
				catch( SQLException ex )
				{
					ex.printStackTrace( );
				}
			}
			// sets the message in request scope
			request.setAttribute( "Message", message );

			// forwards to the message page
			request.getRequestDispatcher( "adminMenu.jsp" ).forward( request, response );
		}
	}
}