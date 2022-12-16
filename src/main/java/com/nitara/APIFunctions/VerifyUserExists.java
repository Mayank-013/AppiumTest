package com.nitara.APIFunctions;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nitara.utils.PropertyManager;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyUserExists extends PropertyManager{


	
	public Boolean verifyUserExists(String url, String phone) throws Exception {

		String abstractname = props.getProperty("VerifyIfUserExists");
		RestAssured.baseURI = url;

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("countryCode", "+91"); 
		requestParams.put("phone", phone);
		requestParams.put("preferredLanguage", "EN");
		requestParams.put("deviceName", "OnePlus"); 
		requestParams.put("deviceType", "Mobile");		

		Response response= request.body(requestParams.toString()).
				header("Content-Type", "application/json").
				post(abstractname);

		//Print response
		response.prettyPeek();

		//Validate status code
	int status = response.getStatusCode();

		//Validate success message
		if(status == 200) {
			return false;
		}
		
		return true;
		
	}


}
