package com.nitara.APIFunctions;

import org.json.JSONObject;
import org.testng.Assert;

import com.nitara.utils.PropertyManager;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddTreatmentAPI extends PropertyManager{
	
	public String addTreatment(String url,String cattleId,String tdate, int followUpDays,String token) throws Exception {

		String abstractname = "/CM/AddTreatment";
		RestAssured.baseURI = url;


		RequestSpecification request = RestAssured.given();

		request.formParam("cattleId", cattleId);
		request.formParam("symptoms[0]", "Symptom_WateryEyes");
		request.formParam("disease","Disease_Brucellosis");
		request.formParam("isAntibioticGiven", false);
		request.formParam("isFollowupRequired", true);
		request.formParam("followupDays",followUpDays);
		request.formParam("dateOfVisit", tdate);
		request.formParam("amount", 250);

		request.header("Authorization","Bearer " + token);

		Response response = request.post(abstractname).then().extract().response();

		//Print response
		response.prettyPeek();

		//Validate status code
		Assert.assertEquals(200, response.getStatusCode());

		//Validate success message
		String jsonString = response.asString();
		String  message = JsonPath.from(jsonString).get("message");
		//Assert.assertEquals("Treatment Data Added Successfully.", message);
		String  id = JsonPath.from(jsonString).get("treatmentId");

		return id;

	}

}
