package php.manag.sys.db;

import java.sql.Connection; // Use classes in java.sql package
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.font.CreatedFontTracker;

// JDK 7 and above
public class SqlLiteDatabase
{
	// JDBC driver name and database URL
	public static final String DB_URL = "jdbc:mysql://localhost:8888/phdmanagsys";

	// Database credentials
	public static final String USER = "jerry";
	public static final String PASSWORD = "siemens";

	/**
	 * inserts a Applciation will all required data into the Database
	 */
	public void insertApplication( String ubNumber, String firstName, String middleName, String lastname, String email, String birthday, String gender, String discipline, String titleOfresearch, String highestAward, String qualificationHighestAward, String otherAward, String qualificationOtherAward, String createrUser )
	{
		String query = "";
		// Step 1: Allocate a database "Connection" object
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			e.printStackTrace( );
		}
		try( Connection conn = DriverManager.getConnection( DB_URL, USER, PASSWORD ); // MySQL
		     Statement stmt = conn.createStatement( ); )
		{
			String[ ] date = birthday.split( "/" );

			query = "INSERT INTO `application` (`ubNumber`, `firstName`, `middleName`, `lastName`, `email`, `birthday`, `gender`, `discipline`, `titleOfresearch`, `highestAward`, `qualiHighAward`, `otherAward`, `qualiOtherAward`,  `createrUser`) VALUES	( '" + ubNumber + "', '" + firstName + "', '" + middleName + "', '" + lastname + "', '" + email + "', '" + date[ 2 ] + "-" + date[ 1 ] + "-" + "-" + date[ 0 ] + "', '" + gender + "', '" + discipline + "', '" + titleOfresearch + "', '" + highestAward + "', '" + qualificationHighestAward + "', '" + otherAward + "', '" + qualificationOtherAward + "', '" + createrUser + "' );";
			System.out.println( "The SQL query is: " + query ); // Echo For
			// debugging

			stmt.executeUpdate( query );
		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
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

		// Step 1: Allocate a database "Connection" object
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			e.printStackTrace( );
		}

		try( Connection conn = DriverManager.getConnection( DB_URL, USER, PASSWORD ); // MySQL

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