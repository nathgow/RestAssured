package com.RestAssignments;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIForeignRAFramework {

    // Write code here that turns the phrase above into concrete actions
		//Create a reference for Response interface
	    Response response;
	    String responseBody;
	    RequestSpecification httpRequest;
	    JsonPath jsonPathEvaluator;
	    String base;
	
	@Given("^API for foreign exchange <http://ratesapi\\.io/documentation/>$")
	public void api_for_foreign_exchange_http_ratesapi_io_documentation() throws Throwable {
	  
	// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a reference variable created above.
	  // response = RestAssured.get("http://api.ratesapi.io/api/");   
	    RestAssured.baseURI = "https://api.ratesapi.io/api";
	    httpRequest = RestAssured.given();
	    
	}

	@When("^posted with correct Information$")
	public void posted_with_correct_Information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// response = httpRequest.request(Method.GET, "/latest?base=USD&symbols=GBP");   
		 response = httpRequest.get("/latest?base=USD&symbols=GBP");
		 jsonPathEvaluator = response.jsonPath();
		 base = jsonPathEvaluator.get("base");
	}

	@Then("^validate positive response code received$")
	public void validate_positive_response_code_received() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Latest base: " + base);
		responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		String statusline=response.getStatusLine();
		String contentTyp=response.getContentType();
		System.out.println(statusline);
		System.out.println(statuscode);
		System.out.println(contentTyp);
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals(statuscode /* actual value */, 200/* Expected Value */,"Unsuccessful");
	}
}
