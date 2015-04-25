package php.manag.sys.JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import php.manag.sys.uploadFile.DBFileDownloadServlet;

public class DBFileDownloadServlet_Test
{
	 DBFileDownloadServlet db;
	
	@BeforeClass
	public static void setUpBeforeClass( ) throws Exception
	{
	}

	@Before
	public void setUp( ) throws Exception
	{
		db = new DBFileDownloadServlet();

		
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
