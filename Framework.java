package com.Assignments;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Framework {
 

	@Test
	public void user() {
		
		//Create a reference for Response interface
	    Response response;
	    
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a reference variable created above.
	    response = RestAssured.get("http://ratesapi.io/documentation/");
	    
	    //print the message body of the response received from the server
	    String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	    
	}
}
