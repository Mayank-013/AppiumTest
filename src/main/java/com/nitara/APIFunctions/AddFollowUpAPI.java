package com.nitara.APIFunctions;

import org.testng.annotations.Test;

import com.nitara.Helper.GenerateRandomData;
import com.nitara.utils.PropertyManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddFollowUpAPI extends PropertyManager{


	@Test
	public void addFollowUpDetails(String url,String Tag) throws Exception {
		
		
		String abstractname = "/CM/AddFollowUp";
		RestAssured.baseURI = url;

		LoginAPI user = new LoginAPI();
		String usertoken = user.API_FarmerLogin(url);

		String farmId = new GetFarmId().getFarmId(url,usertoken);

		String cattleId = new GetCattleId().getCattleId(url,usertoken, farmId,Tag);

		String tDate = new GenerateRandomData().getPastDateAPI(10);

		AddTreatmentAPI treatmnt = new AddTreatmentAPI();
		String TreatmentId = treatmnt.addTreatment(url,cattleId,tDate,10,usertoken);

		RequestSpecification request = RestAssured.given();
		request.formParam("cattleId",cattleId);
		request.formParam("IsCured",false);
		request.formParam("isAntibioticGiven",false);
		request.formParam("isFollowupRequired",false);
		request.formParam("dateOfVisit",new GenerateRandomData().getPastDateAPI(0));
		request.formParam("treatmentId",TreatmentId);

		request.header("Authorization","Bearer " + usertoken);

		Response response = request.post(abstractname).then().extract().response();

		//Print response
		response.prettyPeek();

		System.out.println(response.asString());
	}

}
