package com.nitara.APIFunctions;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.nitara.utils.PropertyManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCattleId extends PropertyManager{
	
	public String getCattleId(String url,String token,String farmId,String tag) throws Exception {

		RestAssured.baseURI = url;
	
		String abstractname = "/CM/SearchMilkingCattle";
	
		RequestSpecification request = RestAssured.given();

		//Create 
		JSONObject requestParams = new JSONObject();
		requestParams.put("farmId",farmId); // Cast
		requestParams.put("searchString", tag);

		Response response = request.body(requestParams.toString())
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + token)
				.post(abstractname);

		//Print response
		response.prettyPeek();

		String jsonString = response.asString();
		JSONObject res = new JSONObject(jsonString);
		JSONArray data = res.getJSONArray("data");
		JSONObject cattle = data.getJSONObject(0);
		String cattleId = cattle.getString("cattleId");
		
		return cattleId;
	}


}
