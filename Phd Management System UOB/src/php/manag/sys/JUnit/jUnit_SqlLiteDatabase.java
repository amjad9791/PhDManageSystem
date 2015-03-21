package php.manag.sys.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import php.manag.sys.db.SqlLiteDatabase;

public class jUnit_SqlLiteDatabase
{

	private SqlLiteDatabase sql;

	@Before
	public void setUp( ) throws Exception
	{
		sql = new SqlLiteDatabase( );
	}

	@Test
	public void testInsertApplication( )
	{
		//Create test environment
		String ubNumber = "1111111";
		 String firstName = "Junit";
		String middleName = "Junit";
		String lastname = "Junit";
		String email = "Junit@junit.uk";
		String birthday = "01/02/2000";//(mm/dd/yyyy)
		String gender  = "f";
		String discipline = "Mechanical";
		String titleOfresearch  = "JunitTitle";
		String highestAward  = "Msc. Junit";
		String qualificationHighestAward = "Quali Junit";
		String otherAward = "Bsc. Junit";
		String qualificationOtherAward = "Junit";
		String createrUser  = "Junit";
		
		assertTrue( "Application successfully inserted", sql.insertApplication( ubNumber, firstName, middleName, lastname, email, birthday, gender, discipline, titleOfresearch, highestAward, qualificationHighestAward, otherAward, qualificationOtherAward, createrUser ) );
	}

	@Test
	public void testDbValidUser( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testIsAlreadySupervisor( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testUpdateApplication( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testAddSupervisor( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testDeleteSupervisor( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testHasSufficientSupervisor( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testNumberOfApplications( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testCreateUser( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testListOfUBNumbers( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testListOfApplications( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testInsertFile( )
	{
		fail( "Not yet implemented" );
	}

}
