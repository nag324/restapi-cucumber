package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import models.Result;
import models.User;
import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Config.Environments;
import utils.ApiExtensions;
import utils.Helpers;

public class GetSalesforceTokenSteps {
	
	ResponseSpecification resspec;
	Response response;
    public static String token;

    @Given("I perform authentication for {string} with params")
    public void i_perform_authentication_for_with_params(String url) throws IOException {
        RequestSpecification res=given().spec(ApiExtensions.requestSpecification(url));
        response =res.when().post(Environments.LoginPath);
        token = response.getBody().jsonPath().get("access_token");
     }

    @Given("I perform GET operation on Account object in {string} environment")
    public void i_perform_GET_operation_on_Account_object_in_environment(String url) throws IOException {

        RequestSpecification res2=given().spec(ApiExtensions.requestSpecification(url));
        res2.header(new Header("Authorization", "Bearer " + token));
        response =res2.when().get(Environments.SandboxPath);
    }

    @Then("I should see label name as Account")
    public void i_should_see_label_name_as_Account() {

        String label=Helpers.getJsonPath(response,"objectDescribe.name");
        assertEquals(label, "Account");
    }



    @Then("verify url contains {string} key in the response")
    public void verifyUrlContainsKeyInTheResponse(String actName) {
        String name=Helpers.getJsonPath(response,"objectDescribe.urls");
        assertTrue(name.contains(actName));
    }




    @Then("verify url contains {string} key in the response")
    public void verifyUrlContainsKeyInTheResponse(String actName) {
        String name=Helpers.getJsonPath(response,"objectDescribe.urls");
        System.out.println(name);
        assertTrue(name.contains(actName));
    }
}







