package php.manag.sys.db;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection; // Use classes in java.sql package
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.sun.org.apache.regexp.internal.recompile;

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
	public boolean insertApplication( String ubNumber, String firstName, String middleName, String lastname, String email, String birthday, String gender, String discipline, String titleOfresearch, String highestAward, String qualificationHighestAward, String otherAward, String qualificationOtherAward, String createrUser )
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

			query = "INSERT INTO `application` (`ubNumber`, `firstName`, `middleName`, `lastName`, `email`, `birthday`, `gender`, `discipline`, `titleOfresearch`, `highestAward`, `qualiHighAward`, `otherAward`, `qualiOtherAward`,  `createrUser`) VALUES	( '" + ubNumber + "', '" + firstName + "', '" + middleName + "', '" + lastname + "', '" + email + "', '" + date[ 2 ] + "-" + date[ 0 ] + "-" + date[ 1 ] + "', '" + gender + "', '" + discipline + "', '" + titleOfresearch + "', '" + highestAward + "', '" + qualificationHighestAward + "', '" + otherAward + "', '" + qualificationOtherAward + "', '" + createrUser + "' );";
			System.out.println( "The SQL query is: " + query ); // Echo For
			// debugging

			stmt.executeUpdate( query );
			return true;
		}
		catch( SQLException ex )
		{
			return false;
			
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
		password = encryptPassword( password );

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

	public boolean isAlreadySupervisor( String username, int applicationNr )
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
			String strSelect = "SELECT * FROM supervisor WHERE supervisorName = '" + username + "' AND app_id = '" + applicationNr + "';";
			System.out.println( "The SQL query is: " + strSelect ); // Echo For
			                                                        // debugging
			System.out.println( );

			ResultSet rset = stmt.executeQuery( strSelect );

			// Step 4: Process the ResultSet by scrolling the cursor forward via
			// next().
			// For each row, retrieve the contents of the cells with
			// getXxx(columnName).
			System.out.println( "The records selected are:" );

			if( rset.next( ) )
			{
				return true;
			}
			else
			{
				return false;
			}

		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		return false;
	}

	public boolean updateApplication( String appNr, String ubNumber, String firstName, String middleName, String lastname, String email, String birthday, String gender, String discipline, String titleOfresearch, String highestAward, String qualificationHighestAward, String otherAward, String qualificationOtherAward, String createrUser )
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

			query = "UPDATE application SET ubNumber = " + ubNumber + ", firstName = '" + firstName + "', middleName = '" + middleName + "', lastName = '" + lastname + "', email = '" + email + "', birthday = '" + date[ 2 ] + "-" + date[ 0 ] + "-" + date[ 1 ] + "', gender = '" + gender + "', discipline = '" + discipline + "', titleOfresearch = '" + titleOfresearch + "', highestAward = '" + highestAward + "', qualiHighAward = '" + qualificationHighestAward + "', otherAward = '" + otherAward + "', qualiOtherAward = '" + qualificationOtherAward + "' WHERE app_id = " + appNr + ";";
			System.out.println( "The SQL query is: " + query ); // Echo For
			// debugging

			stmt.executeUpdate( query );
			return true;
		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
			return false;
		}

	}

	public boolean addSupervisor( String username, int applicationNr )
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

			query = "INSERT INTO supervisor (app_id, supervisorName) VALUES ('" + applicationNr + "', '" + username + "');";
			System.out.println( "The SQL query is: " + query ); // Echo For
			// debugging

			stmt.executeUpdate( query );
			return true;
		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
			return false;
		}

	}

	public boolean deleteSupervisor( String username, int applicationNr )
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

			query = "DELETE FROM supervisor WHERE app_id = " + applicationNr + " AND supervisorName = '" + username + "';";
			System.out.println( "The SQL query is: " + query ); // Echo For
			// debugging

			stmt.executeUpdate( query );
			return true;
		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
			return false;
		}

	}

	public boolean hasSufficientSupervisor( int applicationNr )
	{
		int result = 0;

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
			String strSelect = "SELECT COUNT(*) AS number FROM supervisor WHERE app_id = " + applicationNr + ";";
			System.out.println( "The SQL query is: " + strSelect ); // Echo For
			                                                        // debugging
			System.out.println( );

			ResultSet rset = stmt.executeQuery( strSelect );

			// Step 4: Process the ResultSet by scrolling the cursor forward via
			// next().
			// For each row, retrieve the contents of the cells with
			// getXxx(columnName).
			while( rset.next( ) )
			{ // Move the cursor to the next row
				result = Integer.parseInt( rset.getString( "number" ) );
				System.out.println( "Number of supervisor: " + result );
			}

			if( result >= 2 )
			{
				return true;
			}
			else
			{
				return false;
			}

		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		return false;
	}

	public int numberOfApplications( )
	{
		int result = 0;

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
			String strSelect = "SELECT MAX(app_id) AS number FROM application;";
			System.out.println( "The SQL query is: " + strSelect ); // Echo For
			                                                        // debugging
			System.out.println( );

			ResultSet rset = stmt.executeQuery( strSelect );

			// Step 4: Process the ResultSet by scrolling the cursor forward via
			// next().
			// For each row, retrieve the contents of the cells with
			// getXxx(columnName).
			while( rset.next( ) )
			{ // Move the cursor to the next row
				result = Integer.parseInt( rset.getString( "number" ) );
				System.out.println( "Number of Applications: " + result );
			}

			return result;

		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		return 0;
	}

	public void createUser( String username, String password, String email, String roleUser )
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
			query = "INSERT INTO `user` (`username`, `password`, `email`, `role`) VALUES	( '" + username + "', '" + password + "', '" + email + "', '" + roleUser + "');";
			System.out.println( "The SQL query is: " + query ); // Echo For
			// debugging

			stmt.executeUpdate( query );
		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
	}

	public ArrayList< Integer > listOfUBNumbers( )
	{
		ArrayList< Integer > list = new ArrayList< Integer >( );

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
			String strSelect = "SELECT ubNumber AS number FROM application;";
			System.out.println( "The SQL query is: " + strSelect ); // Echo For
			                                                        // debugging
			System.out.println( );

			ResultSet rset = stmt.executeQuery( strSelect );

			// Step 4: Process the ResultSet by scrolling the cursor forward via
			// next().
			// For each row, retrieve the contents of the cells with
			// getXxx(columnName).
			while( rset.next( ) )
			{ // Move the cursor to the next row
				list.add( Integer.parseInt( rset.getString( "number" ) ) );

			}

			return list;

		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		return null;
	}

	/**
	 * @param sortIsActivated
	 *            has to set to TRUE, if a sorting is desired. False for the
	 *            regular SQL, that query all records from applicants
	 * @param columnForSort
	 *            if the previous parameter is TRUE, the SQL will group it by
	 *            the particular column
	 * @param sortType
	 *            here are TWO PARAMETERS. The first parameter is "+" and will
	 *            affect that the query is ascending order (normal order). The
	 *            second parameter is "-"
	 * @return
	 */
	public ArrayList< ListApplicationContainer > listOfApplications( ArrayList< ListFilterContainer > filterList, String search )
	{
		ArrayList< ListApplicationContainer > list = new ArrayList< ListApplicationContainer >( );

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
			String strSelect = "SELECT app.app_id, app.ubNumber, app.firstName, app.middleName, app.lastName,app.email,app.birthday, app.gender,app.discipline,app.titleOfresearch,app.highestAward,app.qualiHighAward,app.otherAward,app.qualiOtherAward,app.createrUser,app.timestamp, sta.id_status, sta.id_value,GROUP_CONCAT(sv.supervisorName) AS supervisorName FROM application AS app  JOIN app_status_values AS sta ON app.id_status = sta.id_status LEFT JOIN supervisor AS sv ON sv.app_id = app.app_id WHERE app.app_id LIKE '%" + search + "%' OR app.ubNumber LIKE '%" + search + "%' OR app.firstName LIKE '%" + search + "%' OR app.middleName LIKE '%" + search + "%' OR app.lastName LIKE '%" + search + "%' OR app.email LIKE '%" + search + "%' OR app.birthday LIKE '%" + search + "%' OR app.gender LIKE '%" + search + "%' OR app.discipline LIKE '%" + search + "%' OR app.titleOfresearch LIKE '%" + search + "%' OR app.highestAward LIKE '%" + search + "%' OR app.qualiHighAward LIKE '%" + search + "%' OR app.otherAward LIKE '%" + search + "%' OR app.qualiOtherAward LIKE '%" + search + "%' OR app.createrUser LIKE '%" + search + "%' OR sta.id_value LIKE '%" + search + "%' OR supervisorName LIKE '%" + search + "%' GROUP BY app.app_id";
			StringBuilder sbQuery = new StringBuilder( strSelect );

			// It will append the filters. If the ArrayList is empty, then there
			// are no filters
			if( filterList.size( ) > 0 )
			{
				sbQuery.append( " ORDER BY " );
				for( ListFilterContainer element : filterList )
				{
					String append = element.getKeyDatabaseField( ) + " " + element.getValueSort( ) + ", ";
					sbQuery.append( append );
				}
				sbQuery.delete( sbQuery.length( ) - 2, sbQuery.length( ) - 1 );
			}

			sbQuery.append( ";" );

			System.out.println( "The SQL query is: " + sbQuery.toString( ) ); // Echo
																			  // For
			// debugging
			System.out.println( );

			ResultSet rset = stmt.executeQuery( sbQuery.toString( ) );

			// Step 4: Process the ResultSet by scrolling the cursor forward via
			// next().
			// For each row, retrieve the contents of the cells with
			// getXxx(columnName).
			while( rset.next( ) )
			{ // Move the cursor to the next row
				ListApplicationContainer element = new ListApplicationContainer( );
				element.setApp_id( rset.getInt( "app_id" ) );
				element.setId_status( rset.getInt( "id_status" ) );
				element.setUbNumber( rset.getInt( "ubNumber" ) );
				element.setFirstName( rset.getString( "firstName" ) );
				element.setMiddleName( rset.getString( "middleName" ) );
				element.setLastName( rset.getString( "lastName" ) );
				element.setEmail( rset.getString( "email" ) );
				element.setBirthday( rset.getDate( "birthday" ) );

				element.setGender( rset.getString( "gender" ) );
				element.setDiscipline( rset.getString( "discipline" ) );
				element.setTitleOfResearch( rset.getString( "titleOfresearch" ) );
				element.setHighestAward( rset.getString( "highestAward" ) );
				element.setQualiHighAward( rset.getString( "qualiHighAward" ) );
				element.setOtherAward( rset.getString( "otherAward" ) );
				element.setQualiOtherAward( rset.getString( "qualiOtherAward" ) );
				element.setCreaterUser( rset.getString( "createrUser" ) );
				element.setTimestamp( rset.getTimestamp( "timestamp" ) );
				element.setId_value( rset.getString( "id_value" ) );
				element.setSupervisorName( rset.getString( "supervisorName" ) );

				// Add the colected informations to the major list
				list.add( element );
			}

			return list;

		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		return null;
	}

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

	public void insertFile( String ubNumber, String filePath )
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
			query = "INSERT INTO `app_file` (`ubNumber`, `filePath`) VALUES ( " + ubNumber + ", '" + filePath + "');";
			System.out.println( "The SQL query is: " + query ); // Echo For
			// debugging

			stmt.executeUpdate( query );
		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
	}

	public boolean jUnit_query( String query )
	{
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
			String strSelect = query;
			System.out.println( "The SQL query is: " + strSelect ); // Echo For
			                                                        // debugging

			ResultSet rset = stmt.executeQuery( strSelect );

			// Step 4: Process the ResultSet by scrolling the cursor forward via
			// next().
			// For each row, retrieve the contents of the cells with
			// getXxx(columnName).
			while( rset.next( ) )
			{ // Move the cursor to the next row
				return true;
			}

		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		return false;
	}
	
	public boolean jUnit_update( String query )
	{
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

			System.out.println( "The SQL query is: " + query ); // Echo For
			// debugging

			stmt.executeUpdate( query );
			return true;
		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
			return false;
		}

	}
	
	public void updatePropsStatus( String ubNumber, String status )
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
			

			switch( status)
            {
				case "current":
					query = "UPDATE application SET id_status = '0' WHERE ubNumber =  '" + ubNumber + "';";
					break;
				case "pending":
					query = "UPDATE application SET id_status = '1' WHERE ubNumber =  '" + ubNumber + "';";
					break;
				case "complete":
					query = "UPDATE application SET id_status = '2' WHERE ubNumber =  '" + ubNumber + "';";
					break;

				default:
					break;
			}
					
			System.out.println( "The SQL query is: " + query ); // Echo For
			// debugging

			stmt.executeUpdate( query );
		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}

	}

}