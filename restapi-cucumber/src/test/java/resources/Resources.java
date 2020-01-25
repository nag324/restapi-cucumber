package resources;
//enum is special class in java which has collection of constants or  methods
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
		return resource;
	}
	

}
