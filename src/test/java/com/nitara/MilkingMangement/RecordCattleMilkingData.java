package com.nitara.MilkingMangement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class RecordCattleMilkingData extends GenericBase{

	@Test 
	public void Milking_RecordCattleMilking() throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag =new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


		/**Login **/
		new Login().Login_ValidData();

		// Choose Milking Preference
		new HelperFunctions().setMilkingPreferences("Cattle Milking");

		// Select Milk Recording Button on Farmer HomePage
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_MilkRecordingButton();



		// Add Cattle Milking Data for the registered cattle

		cattleMilkingPage.searchcattle(Tag);
		//	cattleMilkingPage.enter_Date(new GenerateRandomData().getPastDate(10));
		cattleMilkingPage.enterYield("14.00");
		cattleMilkingPage.saveCattleMilkingDetails();

		//Assert Cattle Milking Success Page
		//

	}

}
