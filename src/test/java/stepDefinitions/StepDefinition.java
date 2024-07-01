package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.GoogleAddApi;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {
	
	ResponseSpecification responsespec;
	RequestSpecification res;
	Response response;
	TestDataBuild data=new TestDataBuild();
	static String place_id;
	
	
	@Given("Add place payload with {int} {string} {string} {string} {string} {string}")
	public void add_place_payload_with(Integer accuracy, String name, String phone_number, String address, String website, String language) throws IOException
	{
	    		res=given()
				.spec(requestSpecification())
				.body(data.addPlacePayLoad(accuracy,name,phone_number,address,website,language));			    
	}

	@When("user calls {string} using {string} Http Request")
	public void user_calls_using_post_http_request(String resources,String method) {
	    
		APIResources resourceApi= APIResources.valueOf(resources);
		
		responsespec=new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
				response=res.when().post(resourceApi.getResources());
		else if(method.equalsIgnoreCase("GET"))
				response=res.when().get(resourceApi.getResources());
	/*	else if(method.equalsIgnoreCase("DELETE"))
			response=res.when().delete(resourceApi.getResources());			
		else if(method.equalsIgnoreCase("PUT"))
			response=res.when().put(resourceApi.getResources());*/
 
				
	}

	@Then("The API call is Success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	   
		assertEquals(response.getStatusCode(),200);
		
	}

	@Then("validate {string} response body is {string}")
	public void validate_response_body_is(String keyValue, String expectedValue) {
	   
	    assertEquals(getJsonPath(response,keyValue),expectedValue);
	   
	}
	@Then("{string} response body is {string}")
	public void response_body_is(String keyVal, String expval) {
		 
		   assertEquals(getJsonPath(response,keyVal),expval);
	}

	
	@Then("verify place id created to map {string} using {string}")
	public void verify_place_id_created_to_map_using(String expectedName, String resources) throws IOException {
		
		place_id=getJsonPath(response,"place_id");
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_using_post_http_request(resources,"GET");
		String actualname=getJsonPath(response,"name");
		assertEquals(actualname,expectedName);
		
		}

	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
		res=given().spec(requestSpecification()).body(data.deletePlacePayLoad(place_id));	
		}







}
