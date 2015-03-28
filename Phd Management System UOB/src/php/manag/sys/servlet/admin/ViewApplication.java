package php.manag.sys.servlet.admin;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.ListApplicationContainer;
import php.manag.sys.db.ListFilterContainer;
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
	private ArrayList< ListApplicationContainer > listOfApplications;
	private ArrayList< ListFilterContainer > filterList;
	private String search;

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
	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		SqlLiteDatabase sql = new SqlLiteDatabase( );
		// Creating a Html writer object to modify the webpage on runtime
		out = response.getWriter( );
		
		// Receiving the username from the login page
		ServletContext context = getServletContext( );
		username = (String) context.getAttribute( "username" );
		role = (String) context.getAttribute( "role" );
		
		//Get Value from search textfield
		search = request.getParameter( "searchField" );
		if(search == null) {
			search = "";
		}

		// If clause for the filter functionality. It collects the desired
		// filter conditions
		filterList = new ArrayList< ListFilterContainer >( );
		if( request.getParameter( "filter" ) != null )
		{
			// Collecting the filter values
			filterList = radioButFilter( request );
			listOfApplications = sql.listOfApplications( filterList, search );
			request.setAttribute( "listOfApplications", listOfApplications );
			request.getRequestDispatcher( "viewApplication.jsp" ).forward( request, response );
			return;
		}

		// Query how many records are in the application
		tableSize = sql.numberOfApplications( );

		// Query all records in the table application and forward it to the jsp
		listOfApplications = sql.listOfApplications( filterList, search );
		request.setAttribute( "listOfApplications", listOfApplications );

		// Verifying which button got pressed - First the Button Supervisor
		supervisorButtonListener( request, response, sql );
		editButtonListener( request, response );

		// Forward to the application jsp
		request.getRequestDispatcher( "viewApplication.jsp" ).forward( request, response );
	}

	/**
	 * @param request If clause for the filter functionality. It collects the desired filter conditions
	 */
    private ArrayList<ListFilterContainer> radioButFilter( HttpServletRequest request )
    {
    	ArrayList<ListFilterContainer> filterList = new ArrayList< ListFilterContainer >( );
	    String value = request.getParameter( "radApp_id" );
	    //Collecting the APP ID value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "app_id", value ));
	    }

	    value = request.getParameter( "radUBNumber" );
	    //Collecting the UB Number value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer(  "ubNumber", value ));
	    }
	    
	    value = request.getParameter( "radFirstName" );
	    //Collecting the radFirstName value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer(  "firstName", value ));
	    }
	    
	    value = request.getParameter( "radMiddleName" );
	    //Collecting the middleName value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer(  "middleName", value ));
	    }
	    
	    value = request.getParameter( "radLastName" );
	    //Collecting the lastName value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer(  "lastName", value ));
	    }
	    
	    value = request.getParameter( "radEmail" );
	    //Collecting the email value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "email", value) );
	    }
	    
	    value = request.getParameter( "radBirthday" );
	    //Collecting the birthday value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer(  "birthday", value ));
	    }
	    
	    value = request.getParameter( "radGender" );
	    //Collecting the gender value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "gender", value ));
	    }
	    
	    value = request.getParameter( "radDiscipline" );
	    //Collecting the discipline value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "discipline", value ));
	    }
	    
	    value = request.getParameter( "radTitleOfResearch" );
	    //Collecting the titleOfresearch value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "titleOfresearch", value) );
	    }
	    
	    value = request.getParameter( "radHA" );
	    //Collecting the highestAward value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer(  "highestAward", value) );
	    }
	    
	    value = request.getParameter( "radQualiHA" );
	    //Collecting the qualiHighAward value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "qualiHighAward", value ));
	    }
	    
	    value = request.getParameter( "radOA" );
	    //Collecting the otherAward value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "otherAward", value) );
	    }
	    
	    value = request.getParameter( "radQualiOA" );
	    //Collecting the qualiOtherAward value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "qualiOtherAward", value) );
	    }
	    
	    value = request.getParameter( "radCreater" );
	    //Collecting the createrUser value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "createrUser", value ));
	    }
	    
	    value = request.getParameter( "radStatus" );
	    //Collecting the id_status value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "id_status", value ));
	    }
	    
	    value = request.getParameter( "radSupervisor" );
	    //Collecting the id_status value from the RadioButton in the View Apllication Interface
	    if(value !=null){
	    	filterList.add( new ListFilterContainer( "supervisorName", value ));
	    }
	    return filterList;
    }

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editButtonListener( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// Here the buttons for editing the applications. That means, that the
		// admin can edit the applicaitons
		int i = 1;
		while( i < tableSize )
		{
			String act = request.getParameter( "butEditApp_" + i );
			if( act != null )
			{
				// Set the raw number to query the data for the editing process
				getServletContext( ).setAttribute( "applicationNr", i );
				System.out.println( "butEditApp_" + i );
				queryValuesOfApplication( request, i );
				request.getRequestDispatcher( "addApplication.jsp" ).forward( request, response );
				return;
			}
			i++;
		}
	}

	/**
	 * @param request
	 * @param response
	 * @param sql
	 * @throws ServletException
	 * @throws IOException
	 */
	
	// this function is for checking when the professor wants to be a supervisor on an application if he is already supervisor
	//or otherwise will add the application on their list & update database  
	private void supervisorButtonListener( HttpServletRequest request, HttpServletResponse response, SqlLiteDatabase sql ) throws ServletException, IOException
	{
		int i = 1;
		while( i < tableSize )
		{
			String act = request.getParameter( "butSupervisorYes_" + i );
			if( act != null )
			{

				if( sql.isAlreadySupervisor( username, i ) )
				{
					showAlert( "You are already supervisor of this application" );

				}
				else if( sql.hasSufficientSupervisor( i ) )
				{
					showAlert( "This application has enough supervisors" );
				}
				else
				{
					sql.addSupervisor( username, i );
				}

				// Refresh List because of modifying the table
				listOfApplications = sql.listOfApplications( filterList , search );
				request.setAttribute( "listOfApplications", listOfApplications );

				// request.getRequestDispatcher( "viewApplication.jsp"
				// ).forward( request, response );
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
				sql.deleteSupervisor( username, i );

				// Refresh List because of modifying the table
				listOfApplications = sql.listOfApplications( filterList, search );
				request.setAttribute( "listOfApplications", listOfApplications );
				// request.getRequestDispatcher( "viewApplication.jsp"
				// ).forward( request, response );
				return;
			}
			i++;
		}
	}

	private void queryValuesOfApplication( HttpServletRequest request, int applicationNr )
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
			String strSelect = "SELECT * FROM application WHERE app_id = '" + applicationNr + "';";
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

				request.setAttribute( "birthday", date[ 1 ] + "/" + date[ 2 ] + "/" + date[ 0 ] );
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
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	public void showAlert( String alertText )
	{
		out.println( "<script type=\"text/javascript\">" );
		out.println( "alert('" + alertText + "');" );
		out.println( "location='viewApplication.jsp';" );
		out.println( "</script>" );
	}
}
