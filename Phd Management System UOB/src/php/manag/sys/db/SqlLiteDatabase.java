package php.manag.sys.db;

import java.sql.Connection; // Use classes in java.sql package
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDK 7 and above
public class SqlLiteDatabase
{
	// JDBC driver name and database URL
	public static final String DB_URL = "jdbc:mysql://localhost:8888/phdmanagsys";

	// Database credentials
	public static final String USER = "jerry";
	public static final String PASSWORD = "siemens";

	/**
	 * @param username
	 *            The desired username from the loginScreen
	 * @param password
	 *            The password according to the username above
	 * @return Valid values are "admin", "user" or null. Null represents either
	 *         the user is not existing or the entered password ist wrong
	 */
	public void insertApplication( String firstName, String middleName, String lastname, String email, String birthday, String gender )
	{
//		String query = "";
//		try( Connection conn = DriverManager.getConnection( DB_URL, USER, PASSWORD ); // MySQL
//		     Statement stmt = conn.createStatement( ); )
//		{
//			String[] date = birthday.split( "/" ) ;
//			date.
////			query = "INSERT INTO `application` (`firstName`, `middleName`, `lastName`, `email`, `birthday`, `gender`) VALUES	('" + firstName + "', '" + middleName + "', '" + lastname + "', '" + email + "', '" + date[2] + "-" + date[1] + "-" + "-" + date[0] + "', '" + gender + "');";
//			System.out.println( "The SQL query is: " + query ); // Echo For
//			// debugging
//
//			stmt.executeUpdate( query );
//		}
//		catch( SQLException ex )
//		{
//			ex.printStackTrace( );
//		}
	}

	/**
	 * @param username
	 *            The desired username from the loginScreen
	 * @param password
	 *            The password according to the username above
	 * @return Valid values are "admin", "user" or null. Null represents either
	 *         the user is not existing or the entered password ist wrong
	 */
	public String dbValidUser( String username, String password )
	{
		String result = "";
		int rowCount = 0;
		try(
		// Step 1: Allocate a database "Connection" object
		Connection conn = DriverManager.getConnection( DB_URL, USER, PASSWORD ); // MySQL

		// Step 2: Allocate a "Statement" object in the Connection
		Statement stmt = conn.createStatement( ); )
		{
			// Step 3: Execute a SQL SELECT query, the query result
			// is returned in a "ResultSet" object.
			String strSelect = "SELECT role FROM user WHERE username = '" + username + "' AND password = '" + password + "';";
			System.out.println( "The SQL query is: " + strSelect ); // Echo For
			                                                        // debugging
			System.out.println( );

			ResultSet rset = stmt.executeQuery( strSelect );

			// Step 4: Process the ResultSet by scrolling the cursor forward via
			// next().
			// For each row, retrieve the contents of the cells with
			// getXxx(columnName).
			System.out.println( "The records selected are:" );

			while( rset.next( ) )
			{ // Move the cursor to the next row
				result = rset.getString( "role" );
				System.out.println( result );
				++rowCount;
			}
			System.out.println( "Total number of records = " + rowCount );

		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources

		if( rowCount == 0 )
		{
			return "";
		}
		return result;
	}

}