package php.manag.sys.JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import php.manag.sys.servlet.admin.AdminMenu;

public class AdminMenu_Test
{
	AdminMenu admin; 
	@BeforeClass
	public static void setUpBeforeClass( ) throws Exception
	{
	}

	@Before
	public void setUp( ) throws Exception
	{
		admin = new AdminMenu( );

	}

	@After
	public void tearDown( ) throws Exception
	{
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse( )
	{
		fail( "Not yet implemented" );
	}

}
