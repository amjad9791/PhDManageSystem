package php.manag.sys.JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import php.manag.sys.servlet.Login;

public class Login_Test
{
	Login lgin  ;
	@BeforeClass
	public static void setUpBeforeClass( ) throws Exception
	{
	}

	@Before
	public void setUp( ) throws Exception
	{
		
		lgin = new	Login();

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

}
