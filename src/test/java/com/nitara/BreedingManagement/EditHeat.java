package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class EditHeat extends GenericBase{
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Heat_EditData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingOrDryCattle");


		/**Login **/
		new Login().Login_ValidData();
		
		/** FarmerHomePage -> Select Breeding */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"heat");	
		
		/** Fill the heat form */ 
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();
		addHeatPage.waitForProgressBar();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		farmerHomePage.click_HomeButton();
		
		/** Go to Breeding Timeline **/
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag, "Breeding");
		
		
		/** Check details of added Heat in View Heat Page */ 
		breedingSuccessPage.captureScreenshots("ViewHeat");
		breedingTimelinePage.check_breedingStatus("Open");
		breedingTimelinePage.checkDateLeft(data.get("heatDate"));
		//breedingTimelinePage.check_HeatType(data.get("heatType"));

		/** Click on Edit button */
		breedingTimelinePage.press_editBtnLeft();

		/** Edit the added heat period */
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.press_SaveButton();	
		addHeatPage.waitForProgressBar();
		
		breedingSuccessPage.captureScreenshots("EditHeat");

}
}