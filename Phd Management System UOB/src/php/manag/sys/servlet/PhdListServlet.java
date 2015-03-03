package php.manag.sys.servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
public class PhdListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private int tableSize;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhdListServlet( )
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
		out = response.getWriter( );
		out.println( "Hello Unleashed..." );

		int i = 0;
		while( i < tableSize )
		{
			String act = request.getParameter( "butLike_" + i );
			if( act != null )
			{
				System.out.println( "butLike_" + i );
				break;
			}
		}

		createTable( );
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
			Connection cnx = DriverManager.getConnection( SqlLiteDatabase.DB_URL, SqlLiteDatabase.USER, SqlLiteDatabase.PASSWORD );
			Statement st = cnx.createStatement( );
			ResultSet rs = st.executeQuery( "Select * from book" );
			tableSize = 0;

			out.println( "<HTML>" );
			// Start on the body
			out.println( "<BODY>" );
			out.println( "<CENTER>" );
			out.println( "<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=50% >" );
			while( rs.next( ) )
			{
				tableSize++;

				out.println( "<tr>" );
				out.print( "<td>" + rs.getString( "id" ) + "</td>" );
				out.print( "<td>" + rs.getString( "title" ) + "</td>" );
				out.print( "<td>" + rs.getString( "isbn" ) + "</td>" );
				out.print( "<td>" + rs.getString( "publisher" ) + "</td>" );
				out.print( "<td>" + rs.getString( "noOfCopies" ) + "</td>" );
				out.print( "<td>" + rs.getString( "noOfResCopies" ) + "</td>" );
				out.println( "<td><input type='submit' name='butLike_" + tableSize + "' value='Like'</td>" );
				out.println( "<td><input type='submit' name='butDislike_" + tableSize + "' value='Dislike'</td>" );

				out.println( "</tr>" );

			}
		}
		catch( Exception ex )
		{
			System.out.println( ex.getMessage( ) );
		}

		out.println( "</table>" );
		out.println( "</CENTER>" );
		out.println( "</BODY></HTML>" );
	}
}
