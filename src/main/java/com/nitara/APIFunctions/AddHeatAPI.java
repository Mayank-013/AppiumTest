package com.nitara.APIFunctions;

import org.json.JSONObject;
import org.testng.Assert;

import com.nitara.utils.ExcelUtils;
import com.nitara.utils.PropertyManager;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeatAPI extends PropertyManager{
	
	public void addHeatData(String cattleId,String date, String token,String url) throws Exception {

		String abstractname = props.getProperty("AddHeat"); //
		RestAssured.baseURI = url;

		RequestSpecification request = RestAssured.given();

		//Read from excel to JSONObject
		JSONObject requestParams = new JSONObject();
		requestParams.put("CattleId", cattleId);
		requestParams.put("heatType","InseminationType_Artificial");
		requestParams.put("heatDateTime", date);

		Response response = request.body(requestParams.toString())
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + token)
				.post(abstractname);

		System.out.println("\n\"" + abstractname + "\"\n");
		//Print response
		response.prettyPeek();

		//Validate status code
		Assert.assertEquals(response.getStatusCode(),200);

		//Validate success message
		String jsonString = response.asString();
		String  message = JsonPath.from(jsonString).get("message");
		Assert.assertEquals(message,"Heat data added Successfully."); 

	}

}
