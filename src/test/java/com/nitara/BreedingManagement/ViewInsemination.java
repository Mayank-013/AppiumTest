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

public class ViewInsemination extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Insemination_ViewData(Map<String,String> data) throws Throwable {

		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		
		/** Go to cattle Profile page -> Select Breeding */
		new Helper_AppNavigation().goTo_BreedingActivityListfromCattleProfile(Tag);

		/** Select type of insemination and fill form */
		if(data.get("type").equalsIgnoreCase("Artificial")) {
			breedingActivityListPage.waitForPageLoad();
			breedingActivityListPage.select_ArtificialInsemination(); 
			addAIPage.assert_CattleTag(Tag); 
			addAIPage.enter_BullId(data.get("bullID"));
			addAIPage.enter_InseminationDate(data.get("inseminationDate"));
			addAIPage.press_SaveButton();
		}
		else {
			breedingActivityListPage.waitForPageLoad();
			breedingActivityListPage.select_NaturalInsemination(); 
			addNIPage.assert_CattleTag(Tag); 
			addNIPage.enter_BullId(data.get("bullID"));
			addNIPage.enter_Remarks(data.get("remarks"));
			addNIPage.enter_InseminationDate(data.get("inseminationDate")); //
			addNIPage.press_SaveButton();
		}

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		breedingSuccessPage.click_BackToBreedingTimeline();

		/** Check details of added Insemination in Breeding Timeline  */
		breedingTimelinePage.captureScreenshots("ViewInsemination");
		breedingTimelinePage.verify_Insemination(data.get("type"),data.get("inseminationDate"));


	}
}