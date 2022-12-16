package com.nitara.APIFunctions;

import org.json.JSONObject;

import com.nitara.utils.ExcelUtils;
import com.nitara.utils.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetFarmId extends PropertyManager{
	
	public String getFarmId(String url , String token) throws Exception {

		String abstractname = "/AM/UserFarm";
		RestAssured.baseURI = url;
			
		RequestSpecification request = RestAssured.given();

		Response response= request.
				header("Content-Type", "application/json").
				header("Authorization","Bearer " + token).
				get(abstractname);

		System.out.println(response.asString());
	
		String jsonString = response.asString();
		String farmId = JsonPath.from(jsonString).get("farmId");
		
		return farmId;



	}


}
