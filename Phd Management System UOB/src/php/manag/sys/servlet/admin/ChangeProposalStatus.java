package php.manag.sys.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import php.manag.sys.db.SqlLiteDatabase;

public class ChangeProposalStatus extends HttpServlet
{

	@Override //catches the button's action if clicked to establish connection and gets the entered values of ubNumber and status. 
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{

		if( request.getParameter( "statusChangeBtn" ) != null )
		{
			String ubNumber = request.getParameter( "listUBNumbers" );
			String status = request.getParameter( "status" );

			SqlLiteDatabase sql = new SqlLiteDatabase( );
			sql.updatePropsStatus( ubNumber, status );

		}

		request.getRequestDispatcher( "adminMenu.jsp" ).forward( request, response );

	}

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		super.doPost( request, response );
	}

}
