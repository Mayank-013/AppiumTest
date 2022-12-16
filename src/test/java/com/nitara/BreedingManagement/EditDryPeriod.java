package com.nitara.BreedingManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;

public class EditDryPeriod extends GenericBase{

	@Test
	public void Dry_EditData() throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		/**Login **/
		new Login().Login_ValidData();
		
		/** FarmerHomePage -> Select Breeding */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"dryPeriod");

		/** Fill Dry Period form */
		addDryPeriodPage.enter_Drydate(generateRandomData.getPastDate(20));
		addDryPeriodPage.press_SaveButton();
		addDryPeriodPage.waitForProgressBar();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		farmerHomePage.click_HomeButton();

		/** Go to Breeding Timeline **/
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag, "Breeding");
		
		/** Edit the added dry period */
		breedingTimelinePage.press_editBtnRight();
		addDryPeriodPage.press_SaveButton();
		addDryPeriodPage.waitForProgressBar();
			
		/** Assert cattletag in breeding successfully recorded page */
		breedingTimelinePage.captureScreenshots("EditDryPeriod");
		breedingSuccessPage.cattletag_Assert(Tag);
		
	}
}
