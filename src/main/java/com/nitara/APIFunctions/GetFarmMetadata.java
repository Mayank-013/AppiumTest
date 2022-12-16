package com.nitara.APIFunctions;

import org.json.JSONObject;
import org.testng.Assert;

import com.nitara.utils.PropertyManager;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetFarmMetadata extends PropertyManager{
	
	public String getFarmMetadata(String token,String farmId) throws Exception 
	{
		
		String abstractname = "v2/fm/farmmetadata";
		RestAssured.baseURI = props.getProperty("API_baseUrl");
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("farmId", farmId);

		RequestSpecification request = RestAssured.given();


		Response response = request.body(requestParams.toString())
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + token)
				.post(abstractname);

		//Validate status code
		Assert.assertEquals( response.getStatusCode(),200);

		String jsonString = response.asString();
		String  message = JsonPath.from(jsonString).get("message");
	//	Assert.assertEquals( message,"Farm Meta Data.");

		return (jsonString);

	}

}
