package stepDefinitions;


import DataBuilders.UserData;
import cucumber.api.PendingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Result;
import resources.Resources;
import utils.ApiExtensions;
import utils.Helpers;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoRestApiVerificationSteps {

    static RequestSpecification res;
    static Response response;
    UserData data = new UserData() ;
    static String firstName;
    static String token = "_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k";



    @Given("Create User Payload for {string} with {string} {string} {string} {string}")
    public void create_User_Payload_for_with(String url, String first_name, String last_name, String gender, String status) throws IOException {
        /*res=given().spec(ApiExtensions.requestSpecification(url))
                   .header(new Header("Authorization", "Bearer " + token))
                   .body(data.createUserPayload(first_name,last_name,gender,status));*/

       res =  ApiExtensions.RunApiWithHeaderToken(url,token)
               .body(data.createUserPayload(first_name,last_name,gender,status));
    }



    @When("^user perform \"([^\"]*)\" http request on \"([^\"]*)\"$")
    public void user_perform_something_http_request_on_something(String method, String path) throws Throwable {
        Resources apiPath = Resources.valueOf(path);

      if(method.equalsIgnoreCase("POST"))
            response =res.when().post(apiPath.getResource());
        else if(method.equalsIgnoreCase("GET"))
            response =res.when().get(apiPath.getResource());

      //ApiExtensions.ExecuteApiWithPathParams(method,actPath);

    }


    @Then("{string} in response body is {string}")
    public void in_response_body_is(String code, String value) {
        String statusCode=Helpers.getJsonPath(response,code);
        assertEquals(statusCode,value);
    }



    @Given("I perform {string} http request on {string}")
    public void i_perform_http_request_on(String method, String path) {
        Resources apiPath = Resources.valueOf(path);
        firstName=Helpers.getJsonPath(response,"result.first_name");
        if(method.equalsIgnoreCase("POST"))
            response =res.when().post(apiPath.getResource());
        else if(method.equalsIgnoreCase("GET"))
            response =res.when().queryParam("first_name",firstName).get(apiPath.getResource());
      }

    @Then("firstname in the user created above should match to {string}")
    public void firstname_in_the_user_created_above_should_match_to(String keyName) {

        firstName=Helpers.getJsonPath(response,keyName);
        String actualName=Helpers.getJsonPath(response,keyName).toString();
        System.out.println(actualName);
        assertEquals(actualName,firstName);
    }

    @Given("^I perform \"([^\"]*)\" http request on \"([^\"]*)\" with the below details$")
    public void i_perform_something_http_request_on_something_with_the_below_details(String method, String path, DataTable table) throws Throwable {
        Resources apiPath = Resources.valueOf(path);
        var id = Helpers.getJsonPath(response,"result.id");
        var data = table.row(1).get(0);

        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("last_name", data);
        response =res.body(reqBody)
                     .when().put(apiPath.getResource()+id.substring(1,id.length()-1));
    }

    @Then("user status should have latest details")
    public void user_status_should_have_latest_details() {

       var actualVal = Helpers.getJsonPath(response,"result.last_name").toString();
       assertTrue(actualVal.contains("Test"));
    }



    @Given("^I perform \"([^\"]*)\" request on user with \"([^\"]*)\"$")
    public void i_perform_something_request_on_user_with_something(String method, String path) throws Throwable {
        Resources apiPath = Resources.valueOf(path);
        var id = Helpers.getJsonPath(response,"result.id");
        response =res.when().delete(apiPath.getResource()+id);
    }




}
