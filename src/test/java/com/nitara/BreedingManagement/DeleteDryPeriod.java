package com.nitara.BreedingManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class DeleteDryPeriod extends GenericBase{

	@Test
	public void Dry_DeleteData() throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingOrDryCattle");


		/**Login **/
		new Login().Login_ValidData();

		/** Go to cattle Profile page -> Select Breeding */
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"dryPeriod");

		/** Fill Dry Period form */
		addDryPeriodPage.enter_Drydate(generateRandomData.getPastDate(20));
		addDryPeriodPage.press_SaveButton();
		addDryPeriodPage.waitForProgressBar();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		breedingSuccessPage.click_BackToBreedingTimeline();

		/** Delete the added dry period */
		breedingTimelinePage.press_deleteBtnRight();
		breedingTimelinePage.press_YesBtn();

		/** Assert Delete message */
		breedingTimelinePage.captureScreenshots("DeleteDryPeriod");
		breedingTimelinePage.assertDeleteMsg("Dry period",generateRandomData.getPastDate(20));
	}
}
