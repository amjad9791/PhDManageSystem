package php.manag.sys.servlet.admin;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet( "/MyServlet" )
public class ViewApplication extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private int tableSize;
	private String username;
	private String role;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewApplication( )
	{
		super( );
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// Receiving the username from the login page
		ServletContext context = getServletContext( );
		username = (String) context.getAttribute( "username" );
		role = (String) context.getAttribute( "role" );

		out = response.getWriter( );
		out.println( "Hello Unleashed..." );

		// Verifying which button got pressed - First the Button Supervisor
		int i = 1;
		while( i < tableSize )
		{
			String act = request.getParameter( "butSupervisorYes_" + i );
			if( act != null )
			{
				System.out.println( "butSupervisorYes_" + i );
				return;
			}
			i++;
		}
		// Here the buttons of Supervisor No. That means, if a user already
		// assigned a application, he can reject the agreement again.
		i = 1;
		while( i < tableSize )
		{
			String act = request.getParameter( "butSupervisorNo_" + i );
			if( act != null )
			{
				System.out.println( "butSupervisorNo_" + i );
				return;
			}
			i++;
		}
		
		// Here the buttons for editing the applications. That means, that the admin can edit the applicaitons
		i = 1;
		while( i < tableSize )
		{
			String act = request.getParameter( "butEditApp_" + i );
			if( act != null )
			{
				//Set the raw number to query the data for the editing process
				getServletContext( ).setAttribute( "applicationNr", i );
				System.out.println( "butEditApp_" + i );
				queryValuesOfApplication(request, i);
				request.getRequestDispatcher( "addApplication.jsp" ).forward( request, response );
				return;
			}
			i++;
		}

		createTable( );
	}

	private void queryValuesOfApplication( HttpServletRequest request, int applicationNr  )
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

		try( Connection conn = DriverManager.getConnection( SqlLiteDatabase.DB_URL, SqlLiteDatabase.USER, SqlLiteDatabase.PASSWORD ); // MySQL

		// Step 2: Allocate a "Statement" object in the Connection
		Statement stmt = conn.createStatement( ); )
		{
			// Step 3: Execute a SQL SELECT query, the query result
			// is returned in a "ResultSet" object.
			String strSelect = "SELECT * FROM application WHERE id = '" + applicationNr + "';";
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
				request.setAttribute( "ubNumber", rset.getString( "ubNumber" ) );
				request.setAttribute( "firstName", rset.getString( "firstName" ) );
				request.setAttribute( "middleName", rset.getString( "middleName" ) );
				request.setAttribute( "lastName", rset.getString( "lastName" ) );
				request.setAttribute( "email", rset.getString( "email" ) );
				String birthday = rset.getString( "birthday" );
				String[ ] date = birthday.split( "-" );
				
				request.setAttribute( "birthday", date[1] + "/" + date[2] + "/" + date[0]);				
				request.setAttribute( "gender", rset.getString( "gender" ) );
				request.setAttribute( "discipline", rset.getString( "discipline" ) );
				request.setAttribute( "titleOfresearch", rset.getString( "titleOfresearch" ) );
				request.setAttribute( "highestAward", rset.getString( "highestAward" ) );
				request.setAttribute( "qualiHighAward", rset.getString( "qualiHighAward" ) );
				request.setAttribute( "otherAward", rset.getString( "otherAward" ) );
				request.setAttribute( "qualiOtherAward", rset.getString( "qualiOtherAward" ) );
				

			}

		}
		catch( SQLException ex )
		{
			ex.printStackTrace( );
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
	    
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	public void createTable( )
	{
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			e.printStackTrace( );
		}
		try
		{
			Connection cnx = DriverManager.getConnection( SqlLiteDatabase.DB_URL, SqlLiteDatabase.USER, SqlLiteDatabase.PASSWORD );
			Statement st = cnx.createStatement( );
			ResultSet rs = st.executeQuery( "Select * from application" );
			tableSize = 1;

			out.println( "<HTML>" );
			// Start on the body
			out.println( "<BODY>" );
			out.println( "<form action='ViewApplication'>" );
			out.println( "<CENTER>" );
			out.println( "<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=50% >" );
			while( rs.next( ) )
			{

				out.println( "<tr>" );
				out.print( "<td>" + rs.getString( "id" ) + "</td>" );
				out.print( "<td>" + rs.getString( "firstName" ) + "</td>" );
				out.print( "<td>" + rs.getString( "middleName" ) + "</td>" );
				out.print( "<td>" + rs.getString( "lastName" ) + "</td>" );
				out.print( "<td>" + rs.getString( "email" ) + "</td>" );
				out.print( "<td>" + rs.getString( "birthday" ) + "</td>" );
				out.print( "<td>" + rs.getString( "gender" ) + "</td>" );
				out.print( "<td>" + rs.getString( "discipline" ) + "</td>" );
				out.print( "<td>" + rs.getString( "titleOfresearch" ) + "</td>" );
				out.print( "<td>" + rs.getString( "highestAward" ) + "</td>" );
				out.print( "<td>" + rs.getString( "qualiHighAward" ) + "</td>" );
				out.print( "<td>" + rs.getString( "otherAward" ) + "</td>" );
				out.print( "<td>" + rs.getString( "qualiOtherAward" ) + "</td>" );
				out.print( "<td>" + rs.getString( "timestamp" ) + "</td>" );

				// Different views: This buttons are only necessary for
				// professors
				if( role.equals( "professor" ) )
				{
					out.println( "<td><input type='submit' name='butSupervisorYes_" + tableSize + "' value='Become Supervisor'</td>" );
					out.println( "<td><input type='submit' name='butSupervisorNo_" + tableSize + "' value='Reject supervisor task'</td>" );
				}

				// Different views: This buttons are only necessary for
				// professors
				if( role.equals( "admin" ) )
				{
					out.println( "<td><input type='submit' name='butEditApp_" + tableSize + "' value='Edit application'</td>" );
				}

				out.println( "</tr>" );
				tableSize++;
			}
		}
		catch( Exception ex )
		{
			System.out.println( ex.getMessage( ) );
		}

		out.println( "</table>" );
		out.println( "</CENTER>" );
		out.println( "</form>" );
		out.println( "</BODY></HTML>" );
	}
}
