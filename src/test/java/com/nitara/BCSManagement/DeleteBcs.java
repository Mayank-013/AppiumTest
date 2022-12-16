package com.nitara.BCSManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.PageObjects.BasePage;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class DeleteBcs extends GenericBase

{

	@Test
	public void deleteBcs() throws Throwable

	{	

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag =new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


		/**Login **/
		new Login().Login_ValidData();

		/** Go to cattle Profile page -> Select BCS */
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag, "BCS");	


		/** Clic Addbcs from viewbcs page */
		addbcsPage.ClickAddBcs_btn();
	//	breedingActivityListPage.click_skipBtn();


		/** Fill bcs Form */
		String date = generateRandomData.getPastDate(25);
		addbcsPage.addbcs(date);

		/** Select Time Period from dropdown */
		viewbcspage.select_Timeperiod();

		/** click threedots icon*/
		viewbcspage.clickthreedotsicon();

		/**  delete bcs */
		viewbcspage.clickdelete_btn();
		viewbcspage. clickyesbtn();
		viewbcspage.captureScreenshots("Delete BCS");

	}	

}
