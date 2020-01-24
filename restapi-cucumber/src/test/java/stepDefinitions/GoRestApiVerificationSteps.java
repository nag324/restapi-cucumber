package stepDefinitions;


import DataBuilders.UserData;
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

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GoRestApiVerificationSteps {

    static RequestSpecification res;
    static Response response;
    UserData data = new UserData() ;
    static String firstName;
    static String token = "_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k";


    @Given("Create User Payload for {string} with {string} {string} {string} {string}")
    public void create_User_Payload_for_with(String url, String first_name, String last_name, String gender, String status) throws IOException {
        //request1.given().spec(ApiExtensions.requestSpecification(url))
        res=given().spec(ApiExtensions.requestSpecification(url))
                   .header(new Header("Authorization", "Bearer " + token))
                   .body(data.createUserPayload(first_name,last_name,gender,status));
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String path, String method) {

        Resources apiPath = Resources.valueOf(path);
        //String temp = res.get(firstName).toString();
       // System.out.println(temp);
        if(method.equalsIgnoreCase("POST"))
            response =res.when().post(apiPath.getResource());
           else if(method.equalsIgnoreCase("GET"))
          //  firstName=response.getBody().jsonPath().get("result.first_name").toString();
             response =res.when().get(apiPath.getResource());


    }


    @Then("{string} in response body is {string}")
    public void in_response_body_is(String code, String value) {
        //System.out.println(response);
        String statusCode=Helpers.getJsonPath(response,code);
        assertEquals(statusCode,value);
    }

    @Then("verify user created maps to {string} using {string}")
    public void verify_user_created_maps_to_using(String name, String path) throws IOException {
        firstName=Helpers.getJsonPath(response,name);
        System.out.println(firstName);
        Resources apiPath = Resources.valueOf(path);
        //user_calls_with_http_request(path,"GET");
        response =res.queryParam("first_name",firstName).when().get(apiPath.getResource());
        String actualName=Helpers.getJsonPath(response,name).toString();
        System.out.println(actualName);
        assertEquals(actualName.substring(1,actualName.length()-1),firstName);




    }




}
