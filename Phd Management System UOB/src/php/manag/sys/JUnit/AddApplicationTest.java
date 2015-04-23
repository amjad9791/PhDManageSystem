package php.manag.sys.JUnit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import php.manag.sys.servlet.admin.AddApplication;

public class AddApplicationTest
{
	AddApplication app;

	@Before
	public void setUp( ) throws Exception
	{
		 app = new AddApplication( );
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse( )
	{
//		fail( "Not yet implemented" );
	}

	@Test
	public void testIsValidEmailAddress( )
	{
//		fail( "Not yet implemented" );
	}

	@Test
	public void testIsValidDigit( )
	{
		//1 Case: Given value is a string
		String str = "test";
		assertFalse(  "String value is not number" , app.isValidDigit( str ));
		
		//1 Case: Given value is a integer
		str = "2";
		assertTrue(  "String value is a number" , app.isValidDigit( str ));
		
		
	}

}
