package php.manag.sys.db;

public class ListFilterContainer
{
	String keyDatabaseField;
	String valueSort;
	
	public ListFilterContainer( )
    {
	    keyDatabaseField = "";
	    valueSort = "";
    }
	
	public ListFilterContainer( String keyDatabaseField,  String valueSort)
    {
	    this.keyDatabaseField = keyDatabaseField;
	    this.valueSort = valueSort;
    }

	public String getKeyDatabaseField( )
	{
		return keyDatabaseField;
	}

	public void setKeyDatabaseField( String keyDatabaseField )
	{
		this.keyDatabaseField = keyDatabaseField;
	}

	public String getValueSort( )
	{
		return valueSort;
	}

	public void setValueSort( String valueSort )
	{
		this.valueSort = valueSort;
	}
}
