package resources;
//enum is special class in java which has collection of constants or  methods
public enum Resources {
	
	SalesforceLogin("/services/oauth2/token"),
	SalesforceApp("/services/data/v37.0/sobjects/Account");

	private String resource;
	
	Resources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
