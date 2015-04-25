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
		// 1 Case: Given value without "@" and " . "
		String email1 = "john1991gamilcom";
		assertFalse( "Email form is missing @ and a dot ", app.isValidEmailAddress( email1 ) );
		
		// 2 Case: Given value without "@"
		String email2 = "john1991gamil.com";
		assertFalse( "Email form is missing a dot", app.isValidEmailAddress( email2 ) );

		// 3 Case:  Given value rubbish values
        String email3 = "32efwddf32";
		assertFalse( "Email value is not in the right form", app.isValidEmailAddress( email3 ) );

		// 4 Case: Given value is a with "@" and " . "
		String email4 = "john123@gmail.com";
		assertTrue( "Email value is in the right form", app.isValidEmailAddress( email4 ) );
	}

	@Test
	public void testIsValidDigit( )
	{
		//1 Case: Given value is a string
		String str = "test";
		assertFalse(  "String value is not number" , app.isValidDigit( str ));
		
		//2 Case: Given value is a integer
		str = "2";
		assertTrue(  "String value is a number" , app.isValidDigit( str ));
		
		
	}

}
