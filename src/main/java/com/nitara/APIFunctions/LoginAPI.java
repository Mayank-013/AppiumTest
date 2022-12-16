package com.nitara.APIFunctions;

import java.util.Properties;

import org.json.JSONObject;
import org.testng.Assert;

import com.nitara.utils.ExcelUtils;
import com.nitara.utils.PropertyManager;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPI{
	
	public String API_SPLogin() throws Exception {

		RestAssured.baseURI = "https://hotfix.nitara.co.in";
		Properties prop = new PropertyManager().getProps();

		// Read SP credentials from Excel
		String username = prop.getProperty("SPusername");
		String password = prop.getProperty("SPpassword");

		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("countryCode", "+91"); // Cast
		requestParams.put("phone",username); // 
		requestParams.put("Pin",password); //
		requestParams.put("deviceName", "DELL_PC"); 		 
		requestParams.put("deviceType",  "LAPTOP");
		requestParams.put("key",  "com.nitara.farmer");
		System.out.println(requestParams);

		request.body(requestParams.toString())
		.header("Content-Type", "application/json");

		Response response = request.post("/v3/AM/UserLogin");

		String jsonString = response.asString();
		System.out.println(jsonString);
		String  message = JsonPath.from(jsonString).get("message");
		//Validate success message
		Assert.assertEquals(message,"Logged in successfully.");

		String token = JsonPath.from(jsonString).get("token");
		return (token);
	}
	
	
	public String API_FarmerLogin(String url) throws Exception {
	
		RestAssured.baseURI = url;
		Properties prop = new PropertyManager().getProps();
	
		JSONObject username = new ExcelUtils().readRowField("GeneralData", "NewUser",prop.getProperty("API_Testdata"));
		JSONObject password = new ExcelUtils().readRowField("GeneralData", "NewUserPassword",prop.getProperty("API_Testdata"));
		

	
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("countryCode", "+91"); // Cast
		requestParams.put("Phone",username.get("NewUser"));  
		requestParams.put("Pin",password.get("NewUserPassword")); 
		requestParams.put("deviceName", "DELL_PC"); 		 
		requestParams.put("deviceType",  "LAPTOP");
		requestParams.put("key",  "com.nitara.farmer");
		requestParams.put("PreferredLanguage","EN");
		System.out.println(requestParams);
	
		request.body(requestParams.toString())
		.header("Content-Type", "application/json");
	
		Response response = request.post("/AM/v1/UserKeyLoginWithPinWithPreferredLanguage");
	
		String jsonString = response.asString();
		System.out.println(jsonString);
		String  message = JsonPath.from(jsonString).get("message");
		//Validate success message
		//Assert.assertEquals(message,"Logged in successfully.");
	
		String token = JsonPath.from(jsonString).get("token");
		return (token);
	}

}
