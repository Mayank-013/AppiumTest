package com.nitara.APIFunctions;

import java.io.File;
import java.util.Properties;

import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import com.nitara.Helper.GenerateRandomData;
import com.nitara.utils.ExcelUtils;
import com.nitara.utils.PropertyManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterBullCattle extends PropertyManager{
	
	public String registerBullCattle(String url,String token,String scenario) throws Exception {
		
		Properties prop = new PropertyManager().getProps();
		
		RestAssured.baseURI = url;
		String abstractname = prop.getProperty("RegisterBull"); //
		String filepath = prop.getProperty("API_Testdata");

		RequestSpecification request = RestAssured.given();

		//Update tag numbers in excel
		ExcelUtils exceldata = new ExcelUtils();
		GenerateRandomData var = new GenerateRandomData();
		String TagNo = var.generateRandomNumber(8);
		exceldata.writeStringData("GeneralData","TagNumber",TagNo, filepath);
		String CoopNo = var.generateRandomNumber(12);
		exceldata.writeStringData("GeneralData","CooperativeTagNumber",CoopNo, filepath); 
		
		String farmId = new GetFarmId().getFarmId(url,token);
		System.out.println(farmId);
		exceldata.writeStringData("GeneralData","farmId",farmId, filepath); 

		JSONObject dataObject = exceldata.readCase("RegisterBull",scenario,filepath);

		request.header("Authorization","Bearer " + token);
		for (String key: dataObject.keySet()){
			if((dataObject.get(key) instanceof String)) {

				if((dataObject.getString(key)).matches("([^\\s]+(\\.(?i)(jpe?g|png))$)")) {
					request.multiPart(key, new File(dataObject.getString(key)));
				}
				else {
					request.formParam(key, dataObject.get(key));
				}
			}
			else {
				request.formParam(key, dataObject.get(key));
			}
		}

		request.log().all();
		Response res = request.post(abstractname).then().extract().response();

		System.out.println("\n\"" + abstractname + "\"\n");
		//Print response
		res.prettyPeek();

		SoftAssert softAssert= new SoftAssert();
		//Validate status code
		softAssert.assertEquals( res.getStatusCode(),200);

		//Validate success message
		String jsonString = res.asString();
	//	String  message = JsonPath.from(jsonString).get("message");
	//	softAssert.assertEquals(message, "Cattle Registered successfully." );
		
		return TagNo;

	}

}
