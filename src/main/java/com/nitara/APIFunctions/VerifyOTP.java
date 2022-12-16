package com.nitara.APIFunctions;

import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nitara.utils.DataProviderUtils;
import com.nitara.utils.PropertyManager;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyOTP extends PropertyManager{
	
	public void verifyOTP(String otp, String phone, String url) {

		String abstractname = props.getProperty("VerifyOTP");
		RestAssured.baseURI = url;

		RequestSpecification request = RestAssured.given();

		//Create 
		JSONObject requestParams = new JSONObject();
		requestParams.put("CountryCode", "+91");
		requestParams.put("Phone", phone);
		requestParams.put("otp", otp); // Cast	
		System.out.println(requestParams);
		request.body(requestParams.toString());
		request.header("Content-Type", "application/json");
		Response response = request.post(abstractname);

		System.out.println("Response body: " + response.body().prettyPeek().asString());
		
		System.out.println("\n\"" + abstractname + "\"\n");
		//Print response
		response.prettyPeek();

		
		Assert.assertEquals(response.getStatusCode(),200);

		//Validate success message
		String jsonString = response.asString();
		String  message = JsonPath.from(jsonString).get("message");
	//	Assert.assertEquals("OTP is verified.", message);

	}
	
	
	

}
