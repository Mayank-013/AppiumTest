package com.nitara.BCSManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.HousingManagement.Createsmartshed;
import com.nitara.utils.DataProviderUtils;


import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class AddBCS  extends GenericBase 
{
	@Test
	public void AddBcs() throws Exception
	
	{	
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		
		/** Wait for farmer page to load */	
		farmerHomePage.waitForPageLoad();	
		
		/** Click Body condition score button in Homepage*/
		farmerHomePage.click_BCSButton();
		
		/** Search cattle from cattlelist */		
		helper_AppNavigation.selectCattle(Tag);
		addbcsPage.clickskip_btn();
		
		/** Move bcs Slider */
		addbcsPage.ClickBcs_slider();
		
		/** Pass date to datepicker */
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(25));
		
		/** Save Bcs Data */
		addbcsPage.press_SaveButton();		
	
		/** capture screenshot */
		addbcsPage.captureScreenshots("Add BCS");
	

	}	
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpdateBcs_AddBcsBeforeFirstCalvingDate(Map<String, String> data) throws Exception

	{

		/** Register cattle */

		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		
		/** Wait for farmer page to load */
		farmerHomePage.waitForPageLoad();

		/** Click Body condition score button in Homepage */
		farmerHomePage.click_BCSButton();

		/** Search cattle from cattlelist */
		helper_AppNavigation.selectCattle(Tag);

		addbcsPage.waitForPageLoad();

		/** Move bcs Slider */
		addbcsPage.ClickBcs_slider();

		/** Pass date to datepicker */
		addbcsPage.enter_bcsDate(data.get("date"));

		/** Save Bcs Data */
		addbcsPage.press_SaveButton();
		addbcsPage.assertWarning(data.get("warningMessage")+" "+generateRandomData.getPastDate(25));
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpdateBcs_AddBcsWithin15DaysOfPreviousBCSDate(Map<String, String> data) throws Exception

	{

		/** Register cattle */

		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		/** Wait for farmer page to load */
		farmerHomePage.waitForPageLoad();

		/** Click Body condition score button in Homepage */
		farmerHomePage.click_BCSButton();

		/** Search cattle from cattlelist */
		helper_AppNavigation.selectCattle(Tag);

		addbcsPage.waitForPageLoad();

		/** Move bcs Slider */
		addbcsPage.ClickBcs_slider();

		/** Pass date to datepicker */
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(25));

		/** Save Bcs Data */
		addbcsPage.press_SaveButton();
		addbcsPage.homeButton();
		farmerHomePage.click_BCSButton();
		helper_AppNavigation.selectCattle(Tag);
		addbcsPage.waitForPageLoad();
		addbcsPage.ClickBcs_slider();
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(24));
		addbcsPage.press_SaveButton();
		addbcsPage.assertWarning(data.get("warningMessage")+" "+generateRandomData.getPastDate(25));
	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void UpdateBcs_AddBcsBackdatedBCSEntry(Map<String, String> data) throws Exception

	{

		/** Register cattle */

		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		/** Wait for farmer page to load */
		farmerHomePage.waitForPageLoad();

		/** Click Body condition score button in Homepage */
		farmerHomePage.click_BCSButton();

		/** Search cattle from cattlelist */
		helper_AppNavigation.selectCattle(Tag);

		addbcsPage.waitForPageLoad();

		/** Move bcs Slider */
		addbcsPage.ClickBcs_slider();

		/** Pass date to datepicker */
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(25));

		/** Save Bcs Data */
		addbcsPage.press_SaveButton();
		addbcsPage.homeButton();
		farmerHomePage.click_BCSButton();
		helper_AppNavigation.selectCattle(Tag);
		addbcsPage.waitForPageLoad();
		addbcsPage.ClickBcs_slider();
		addbcsPage.enter_bcsDate(generateRandomData.getPastDate(30));
		addbcsPage.press_SaveButton();
		addbcsPage.assertWarning(data.get("warningMessage")+" "+generateRandomData.getPastDate(25));
	}
		
		
}
