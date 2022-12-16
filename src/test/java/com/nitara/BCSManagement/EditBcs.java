package com.nitara.BCSManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.PageObjects.BCS_ViewBCSPage;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class EditBcs extends GenericBase 


{
	@Test
	public void editBcs() throws Throwable
	{

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


		/**Login **/
		new Login().Login_ValidData();

		/** Farmer Homepage -> Select BCS */
		new Helper_AppNavigation().goTo_addBCSScreen(Tag, "BCS");	

		/** Fill bcs Form- Save*/
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(25));
		addbcsPage.press_SaveButton();		
		addbcsPage.waitForProgressBar();
		
		/** capture screenshot */
		addbcsPage.captureScreenshots("Add BCS");
		addbcsPage.homeButton();

		/** Go to view BCS Data screen */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag, "BCS");	
		
		/** Select Time Period from dropdown */
		viewbcspage.select_Timeperiod();
		
		/** Click three dots in view bcs page */
		viewbcspage.clickthreedotsicon();

		/** click edit button*/
		viewbcspage.clickeditbcs_btn();

		/**Fill bcs form */
		addbcsPage.ClickBcs_slider();		
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(25));		
		addbcsPage.press_SaveButton();
		addbcsPage.waitForProgressBar();

		/** Capture the success page */
		viewbcspage.waitForPageLoad();
		viewbcspage.captureScreenshots("View BCS");

		/** click go back to bcs */
		addbcsPage.Clickgobacktoviewbcs();

		/** Select Time Period from dropdown */
		viewbcspage.select_Timeperiod();

		/** capture screenshot */
		viewbcspage.captureScreenshots("Update BCS");








	}
}