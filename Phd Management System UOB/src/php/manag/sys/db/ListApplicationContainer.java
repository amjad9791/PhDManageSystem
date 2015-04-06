package php.manag.sys.db;

import java.sql.Timestamp;
import java.util.Date;

public class ListApplicationContainer
{

	int app_id;
	int id_status;
	int ubNumber;
	String firstName;
	String middleName;
	String lastName;
	String email;
	Date birthday;
	String gender;
	String discipline;
	String titleOfResearch;
	String highestAward;
	String qualiHighAward;
	String otherAward;
	String qualiOtherAward;
	String createrUser;
	String id_value;
	String supervisorName;
	boolean file;
	Timestamp timestamp;

	public ListApplicationContainer( )
	{
		app_id = 0;
		id_status = 0;
		ubNumber = 0;
		firstName = "";
		middleName = "";
		lastName = "";
		email = "";
		// birthday = new Data();
		gender = "";
		discipline = "";
		titleOfResearch = "";
		highestAward = "";
		qualiHighAward = "";
		otherAward = "";
		qualiOtherAward = "";
		createrUser = "";
		file = false;
		// timestamp = new Data();
	}

	public int getApp_id( )
	{
		return app_id;
	}

	public void setApp_id( int app_id )
	{
		this.app_id = app_id;
	}

	public int getId_status( )
	{
		return id_status;
	}

	public void setId_status( int id_status )
	{
		this.id_status = id_status;
	}

	public int getUbNumber( )
	{
		return ubNumber;
	}

	public void setUbNumber( int ubNumber )
	{
		this.ubNumber = ubNumber;
	}

	public String getFirstName( )
	{
		return firstName;
	}

	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	public String getMiddleName( )
	{
		return middleName;
	}

	public void setMiddleName( String middleName )
	{
		this.middleName = middleName;
	}

	public String getLastName( )
	{
		return lastName;
	}

	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	public String getEmail( )
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public Date getBirthday( )
	{
		return birthday;
	}

	public void setBirthday( Date birthday )
	{
		this.birthday = birthday;
	}

	public String getGender( )
	{
		return gender;
	}

	public void setGender( String gender )
	{
		this.gender = gender;
	}

	public String getDiscipline( )
	{
		return discipline;
	}

	public void setDiscipline( String discipline )
	{
		this.discipline = discipline;
	}

	public String getTitleOfResearch( )
	{
		return titleOfResearch;
	}

	public void setTitleOfResearch( String titleOfResearch )
	{
		this.titleOfResearch = titleOfResearch;
	}

	public String getHighestAward( )
	{
		return highestAward;
	}

	public void setHighestAward( String highestAward )
	{
		this.highestAward = highestAward;
	}

	public String getQualiHighAward( )
	{
		return qualiHighAward;
	}

	public void setQualiHighAward( String qualiHighAward )
	{
		this.qualiHighAward = qualiHighAward;
	}

	public String getOtherAward( )
	{
		return otherAward;
	}

	public void setOtherAward( String otherAward )
	{
		this.otherAward = otherAward;
	}

	public String getQualiOtherAward( )
	{
		return qualiOtherAward;
	}

	public void setQualiOtherAward( String qualiOtherAward )
	{
		this.qualiOtherAward = qualiOtherAward;
	}

	public String getCreaterUser( )
	{
		return createrUser;
	}

	public void setCreaterUser( String createrUser )
	{
		this.createrUser = createrUser;
	}

	public Date getTimestamp( )
	{
		return timestamp;
	}

	public void setTimestamp( Timestamp timestamp )
	{
		this.timestamp = timestamp;
	}

	public String getId_value( )
	{
		return id_value;
	}

	public void setId_value( String id_value )
	{
		this.id_value = id_value;
	}

	public String getSupervisorName( )
	{
		return supervisorName;
	}

	public void setSupervisorName( String supervisorName )
	{
		if( supervisorName == null )
		{
			this.supervisorName = "";
		}
		else
		{
			this.supervisorName = supervisorName;
		}
	}

	public boolean isFile( )
	{
		return file;
	}

	public void setFile( boolean file )
	{
		this.file = file;
	}

}
