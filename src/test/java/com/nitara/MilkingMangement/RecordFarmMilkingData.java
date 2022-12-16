package com.nitara.MilkingMangement;

import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateRandomData;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class RecordFarmMilkingData extends GenericBase{

	@Test 
	public void Milking_RecordCattleMilking() throws Throwable {

		/**Login **/
		new Login().Login_ValidData();

		// Choose Milking Preference
		new HelperFunctions().setMilkingPreferences("Farm Milking");

		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_MilkRecordingButton();



		farmMilkingPage.enter_FarmMilkingDate(generateRandomData.getPastDate(1));
		farmMilkingPage.enter_yield("22");
		farmMilkingPage.enter_fat("5");
		farmMilkingPage.enter_price("560");
		//farmMilkingPage.select_session("Morning");
		farmMilkingPage.saveFarmMilkingDetails();

		//farmMilkingSuccessPage.assertSession("Morning");
		farmMilkingSuccessPage.assertSessionYield("22");
	}

}
