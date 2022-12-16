package com.nitara.APIFunctions;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nitara.utils.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateFarmLocation extends PropertyManager {

	@Test
	public void updateFarmLocation(String url) throws Exception {

		//String url = "https://test.nitara.co.in";
		String abstractname = props.getProperty("UpdateFarmLocation");
		RestAssured.baseURI =url;

		RequestSpecification request = RestAssured.given();


		// Login with farmer credentials
		String usertoken = new LoginAPI().API_FarmerLogin(url);


		String farmId = new GetFarmId().getFarmId(url,usertoken);

		//Create 
		JSONObject requestParams = new JSONObject();
		requestParams.put("farmId",farmId); 
		requestParams.put("longitude", 77.7243733);
		requestParams.put("latitude",12.9795901);


		Response response= request.body(requestParams.toString()).
				header("Content-Type", "application/json").
				header("Authorization","Bearer " + usertoken).
				post(abstractname);

		//Print response
		response.prettyPeek();

		//Validate status code
		Assert.assertEquals(response.getStatusCode(),200);

		//Validate success message
		String jsonString = response.asString();
		//		String  message = JsonPath.from(jsonString).get("message");
		//	Assert.assertEquals(message,"Location updated successfully.");

	}


//	public void updateFarmLocation(String url, double latitude, double longitude) throws Exception {
//
//		String abstractname = props.getProperty("UpdateFarmLocation");
//		RestAssured.baseURI =url;
//
//		RequestSpecification request = RestAssured.given();
//
//
//		// Login with farmer credentials
//		String usertoken = new LoginAPI().API_FarmerLogin(url);
//
//
//		String farmId = new GetFarmId().getFarmId(url,usertoken);
//
//		//Create 
//		JSONObject requestParams = new JSONObject();
//		requestParams.put("farmId",farmId); 
//		requestParams.put("latitude", latitude ); //8.088306
//		requestParams.put("longitude",longitude);//77.538452
//
//		Response response= request.body(requestParams.toString()).
//				header("Content-Type", "application/json").
//				header("Authorization","Bearer " + usertoken).
//				post(abstractname);
//
//		//Print response
//		response.prettyPeek();
//
//		//Validate status code
//		Assert.assertEquals(response.getStatusCode(),200);
//
//		//Validate success message
//		String jsonString = response.asString();
//		//		String  message = JsonPath.from(jsonString).get("message");
//		//	Assert.assertEquals(message,"Location updated successfully.");
//
//	}

}
