package resources;

public enum Resources {
	
	CreateUser("/public-api/users"),
	GetUser("public-api/users"),
	UpdateUser("public-api/users/"),
	DeleteUser("public-api/users/");

	private String resource;
	
	Resources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource.toString();
	}
	

}
