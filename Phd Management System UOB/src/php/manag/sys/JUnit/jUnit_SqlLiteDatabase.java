package php.manag.sys.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import php.manag.sys.db.SqlLiteDatabase;

public class jUnit_SqlLiteDatabase
{

	private SqlLiteDatabase sql;
	private String ubNumber;
	private String firstName;
	private String lastname;
	private String birthday;
	private String middleName;
	private String email;
	private String gender;
	private String discipline;
	private String highestAward;
	private String titleOfresearch;
	private String qualificationHighestAward;
	private String otherAward;
	private String qualificationOtherAward;
	private String createrUser;

	@Before
	public void setUp( ) throws Exception
	{
		sql = new SqlLiteDatabase( );
	}

	@Test
	public void testInsertApplication( )
	{
		// Create test environment
		ubNumber = "1111111";
		firstName = "Junit";
		middleName = "Junit";
		lastname = "Junit";
		email = "Junit@junit.uk";
		birthday = "01/02/2000";// (mm/dd/yyyy)
		gender = "f";
		discipline = "mechanical";
		titleOfresearch = "JunitTitle";
		highestAward = "Msc. Junit";
		qualificationHighestAward = "Quali Junit";
		otherAward = "Bsc. Junit";
		qualificationOtherAward = "Junit";
		createrUser = "Junit";

		assertTrue( "Application successfully inserted", sql.insertApplication( ubNumber, firstName, middleName, lastname, email, birthday, gender, discipline, titleOfresearch, highestAward, qualificationHighestAward, otherAward, qualificationOtherAward, createrUser ) );
		
		//Clear the environment
		sql.jUnit_update( "DELETE FROM application WHERE firstName = 'Junit';" );
	}

	@Test
	public void testDbValidUser( )
	{
		String admin = "admin";
		String professor = "professor";
		String adminSQL = sql.dbValidUser( "a", "a" );
		String professorSQL = sql.dbValidUser( "p", "p" );

		assertTrue( "The ADMIN user is existing in the Database", admin.equals( adminSQL ) );
		assertTrue( "The PROFESSOR User is existing in the Database", professor.equals( professorSQL ) );
		assertFalse( "The User is existing in the Database", admin.equals( sql.dbValidUser( "FAKE", "FAKE" ) ) && professor.equals( sql.dbValidUser( "FAKE", "FAKE" ) ) );
	}

	@Test
	public void testIsAlreadySupervisor( )
	{
		assertTrue( "Supervisor 1 is inserted", sql.addSupervisor( "Junit", 1000 ) );
		assertTrue( "Supervisor 1 can not be a supervisor, because he is already reported", sql.addSupervisor( "Junit", 1000 ) );
		
		//Clear the environment
		sql.jUnit_update( "DELETE FROM supervisor WHERE supervisorName = 'Junit';" );
	}

	@Test
	public void testUpdateApplication( )
	{
		birthday = "2000-02-01";// (yyyy-mm-dd)
		assertTrue( "Application successfully inserted", sql.jUnit_update( "INSERT INTO `application` (`app_id`, `id_status`, `ubNumber`, `firstName`, `middleName`, `lastName`, `email`, `birthday`, `gender`, `discipline`, `titleOfresearch`, `highestAward`, `qualiHighAward`, `otherAward`, `qualiOtherAward`, `createrUser`, `timestamp`) VALUES (1000, 0, 1111111, 'Junit', 'Junit', 'Junit', 'Junit@junit.uk', '2000-01-02', 'f', 'mechanical', 'JunitTitle', 'Msc. Junit', 'Quali Junit', 'Bsc. Junit', 'Junit', 'Junit', '2015-03-24 02:19:20');" ) );
		birthday = "01/02/2000";// (mm/dd/yyyy)
		assertTrue("Application successfully changed to the first name of JUnit2 ", sql.updateApplication( "1000", "1000", firstName, middleName, lastname, email, birthday, "f", discipline, titleOfresearch, highestAward, qualificationHighestAward, otherAward, qualificationOtherAward, createrUser ));
		//Clear the environment
		sql.jUnit_update( "DELETE FROM application WHERE app_id = '1000';" );
		birthday = "01/02/2000";// (mm/dd/yyyy)
	}

	@Test
	public void testAddSupervisor( )
	{
		String supervisor = "Junit";
		int applicationNr = 1000;
		assertTrue( "Supervisor added", sql.addSupervisor( supervisor, applicationNr ) );
		
		//Clear the environment
		sql.jUnit_update( "DELETE FROM supervisor WHERE app_id = '1000';" );
	}

	@Test
	public void testDeleteSupervisor( )
	{
		String supervisor = "Junit";
		int applicationNr = 1000;
		assertTrue( "Supervisor added", sql.addSupervisor( supervisor, applicationNr ) );
		assertTrue( "Supervisor deleted", sql.deleteSupervisor( supervisor, applicationNr ));
	}

	@Test
	public void testHasSufficientSupervisor( )
	{
		String supervisor1 = "Junit1";
		String supervisor2 = "Junit2";
		int applicationNr = 1000;
		//Case: A third person can not be added
		assertTrue( "Supervisor1 added", sql.addSupervisor( supervisor1, applicationNr ) );
		assertTrue( "Supervisor2 added", sql.addSupervisor( supervisor2, applicationNr ) );
		assertTrue( "Supervisor3 cannot be added", sql.hasSufficientSupervisor( applicationNr ));
		//Clear the environment
		sql.jUnit_update( "DELETE FROM supervisor WHERE app_id = '1000';" );

		//Case: A supervisor can be added
		assertTrue( "Supervisor1 added", sql.addSupervisor( supervisor1, applicationNr ) );
		assertFalse( "Supervisor3 can be added", sql.hasSufficientSupervisor( applicationNr ));
		//Clear the environment
		sql.jUnit_update( "DELETE FROM supervisor WHERE app_id = '1000';" );

	}

	@Test
	public void testNumberOfApplications( )
	{

	}

	@Test
	public void testCreateUser( )
	{

	}

	@Test
	public void testListOfUBNumbers( )
	{

	}

	@Test
	public void testListOfApplications( )
	{

	}

	@Test
	public void testInsertFile( )
	{

	}

}
