package php.manag.sys.JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import php.manag.sys.servlet.admin.RegisterUser;

public class RegisterUser_Test
{
	RegisterUser reg;
	@BeforeClass
	public static void setUpBeforeClass( ) throws Exception
	{
	}

	@Before
	public void setUp( ) throws Exception
	{
		reg = new RegisterUser(); 
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
	public void testIsValidEmailAddress( )
	{
		fail( "Not yet implemented" );
	}

}
