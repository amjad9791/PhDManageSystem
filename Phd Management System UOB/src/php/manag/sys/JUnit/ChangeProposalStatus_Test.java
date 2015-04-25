package php.manag.sys.JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import php.manag.sys.servlet.admin.ChangeProposalStatus;

public class ChangeProposalStatus_Test
{ 
	 ChangeProposalStatus ch;

	@BeforeClass
	public static void setUpBeforeClass( ) throws Exception
	{
	}

	@Before
	public void setUp( ) throws Exception
	{
		ch= new ChangeProposalStatus();
	
	}

	@After
	public void tearDown( ) throws Exception
	{
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse( )
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse( )
	{
		fail( "Not yet implemented" );
	}

}
