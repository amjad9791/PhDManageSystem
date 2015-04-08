package php.manag.sys.uploadFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

/**
 * A servlet that retrieves a file from MySQL database and lets the client
 * downloads the file.
 * 
 * @author www.codejava.net
 */
@WebServlet( "/downloadFileServlet" )
public class DBFileDownloadServlet extends HttpServlet
{
    private static final long serialVersionUID = 2864237624174068030L;
	// size of byte buffer to send file
	private static final int BUFFER_SIZE = 4096;
	private Integer applicationNr;

	@Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		//Receive the Application Number
		applicationNr = (Integer) request.getAttribute( "applicationNr" );


		Connection conn = null; // connection to the database

		try
		{
			// connects to the database
			DriverManager.registerDriver( new com.mysql.jdbc.Driver( ) );
			// database connection settings
			conn = DriverManager.getConnection( SqlLiteDatabase.DB_URL, SqlLiteDatabase.USER, SqlLiteDatabase.PASSWORD );

			// queries the database
			String sql = "SELECT af.ubNumber AS ubNumber, af.file AS file FROM app_file AS af LEFT JOIN application AS app ON app.ubNumber = af.ubNumber WHERE app.app_id = ?";
			PreparedStatement statement = conn.prepareStatement( sql );
			statement.setInt( 1, applicationNr );
			System.out.println("Download File Sql: " + statement.toString( ));

			ResultSet result = statement.executeQuery( );
			if( result.next( ) )
			{
				// gets file name and file blob data
				String fileName = result.getString( "ubNumber" );
				Blob blob = result.getBlob( "file" );
				InputStream inputStream = blob.getBinaryStream( );
				int fileLength = inputStream.available( );

				System.out.println( "fileLength = " + fileLength );

				ServletContext context = getServletContext( );

				// sets MIME type for the file download
				String mimeType = context.getMimeType( fileName );
				if( mimeType == null )
				{
					mimeType = "application/octet-stream";
				}

				// set content properties and header attributes for the response
				response.setContentType( mimeType );
				response.setContentLength( fileLength );
				String headerKey = "Content-Disposition";
				String headerValue = String.format( "attachment; filename=\"%s\"", fileName + ".pdf" );
				response.setHeader( headerKey, headerValue );

				// writes the file to the client
				OutputStream outStream = response.getOutputStream( );

				byte[ ] buffer = new byte[ BUFFER_SIZE ];
				int bytesRead = -1;

				while( ( bytesRead = inputStream.read( buffer ) ) != -1 )
				{
					try
                    {
	                    outStream.write( buffer, 0, bytesRead );
                    }
                    catch( Exception e )
                    {
                    	System.out.println("java.io.IOException:");
                    }
				}

				inputStream.close( );
				outStream.close( );
			}
			else
			{
				// no file found
				System.out.println("File not found for the id: " + applicationNr);
			}
		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
			System.out.println("SQL Error: " + ex.getMessage( ) );
		}
		catch( IOException ex )
		{
			ex.printStackTrace( );
			System.out.println("IO Error: " + ex.getMessage( ));
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
		}
	}
}