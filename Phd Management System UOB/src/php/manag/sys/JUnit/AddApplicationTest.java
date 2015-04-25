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
	public void testIsValidEmailAddress( )
	{
		String str1 = "john1991gamilcom";
		assertFalse(  "String value is not number" , app.isValidEmailAddress( str1 ));
		
		//1 Case: Given value is a integer
		String		str12 = "john123@gmail.com";
		assertTrue(  "String value is a number" , app.isValidEmailAddress( str12 ));
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
