package com.nitara.DiseasePredictor;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import appCommonClasses.GenericBase;

public class ReportDisease extends GenericBase

{		@Test

	public void reportDisease() throws Throwable

{	
	
	/** Register cattle */
	String url = prop.getProperty("APIbaseUrl");
	String usertoken = new LoginAPI().API_FarmerLogin(url);
	String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


	/**Login **/
	new Login().Login_ValidData();

	/** Click Disease predictor  button in Homepage*/
	farmerHomePage.click_DiseasePredictorButton();

	/** Search cattle from cattlelist */		
	helper_AppNavigation.selectCattle(Tag);

	/** Skip  turotial if Displayed*/
	//diseasepredictorpage.click_skipBtn();

	/** Add Sysmptoms **/
	diseasepredictorpage.AddSymptoms();

	/** capture screenshots */
	diseasepredictorpage.captureScreenshots("Report Disease");

	/** Go Back to Farmer Homepage */ 
	diseasepredictorpage.GoBackToHomepage();

}

}