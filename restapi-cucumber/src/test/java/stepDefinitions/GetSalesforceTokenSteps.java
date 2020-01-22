package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Test;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Config.Environments;
import utils.ApiExtensions;

public class GetSalesforceTokenSteps {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	   @Test
	   public void Login() throws IOException {
		   
			 res=given().spec(ApiExtensions.requestSpecification("salesfoce"));
			 response =res.when().post(Environments.LoginPath);
			 System.out.println(response);
		   
	   }
	   
	   
	/*
	 * @Given("^I perform authentication for \"([^\"]*)\" with params$") public void
	 * i_perform_authentication_for_something_with_params() throws Throwable {
	 * res=given().spec(ApiExtensions.requestSpecification("salesfoce")); response
	 * =res.when().post(Environments.LoginPath); System.out.println(response); }
	 * 
	 * @Given("^I perform GET operation on Account object in \"([^\"]*)\" environment$"
	 * ) public void
	 * i_perform_get_operation_on_account_object_in_something_environment(String
	 * devUrl) throws Throwable { throw new PendingException(); }
	 * 
	 * @Then("^I should see label name as Account$") public void
	 * i_should_see_label_name_as_account() throws Throwable { throw new
	 * PendingException(); }
	 * 
	 * 
	 */

}
