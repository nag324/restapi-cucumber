
package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import utils.Config.Environments;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiExtensions {
	
	public static RequestSpecification request;
	public static Response response;


	public static RequestSpecification requestSpecification(String url) throws IOException
	{
		RequestSpecification request = null;
		switch (url) 
		{
		case "salesforce":
		    if( request==null)
		     {
		    	PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		    	request=new RequestSpecBuilder().setBaseUri(Environments.SalesforceLoginUrl)
		    			  .addQueryParam("grant_type", Environments.GrantType)
		    			  .addQueryParam("client_id", Environments.ClientId)
		    			  .addQueryParam("client_secret", Environments.ClientSecret)
		    			  .addQueryParam("username", Environments.UserName)
		    			  .addQueryParam("password", Environments.Password)
				          .addFilter(RequestLoggingFilter.logRequestTo(log))
				          .addFilter(ResponseLoggingFilter.logResponseTo(log))
				          .setContentType(ContentType.JSON).build();
		    	return request;
		     }

		    	break;

		case "sandbox":
			if(request==null) {
				PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
				request = new RequestSpecBuilder().setBaseUri(Environments.SalesforceSandboxUrl)
						.addFilter(RequestLoggingFilter.logRequestTo(log))
						.addFilter(ResponseLoggingFilter.logResponseTo(log))
						.setContentType(ContentType.JSON).build();
				return request;
			}

		    	break;

		default:
			if(request==null) {
				PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
				request = new RequestSpecBuilder().setBaseUri(Environments.BaseUrl)
						.addFilter(RequestLoggingFilter.logRequestTo(log))
						.addFilter(ResponseLoggingFilter.logResponseTo(log))
						.setContentType(ContentType.JSON).build();
				return request;
			}


		}

	return request;
		
	}


	public static RequestSpecification RunApiWithHeaderToken(String url, String token) throws IOException {
		request=given().spec(requestSpecification(url))
				.header(new Header("Authorization", "Bearer " + token));

		return request;

	}


	/*public static Response ExecuteApiWithPathParams(String method, String path) throws IOException {
		if(method.equalsIgnoreCase("POST"))
			response =request.when().post(path);
		else if(method.equalsIgnoreCase("GET"))
			response =request.when().get(path);
		return response;

	}*/
	

}

