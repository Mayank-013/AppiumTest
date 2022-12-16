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

public class EditInsemination extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Insemination_EditData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingOrDryCattle");

		/**Login **/
		new Login().Login_ValidData();

		/** FarmerHomePage -> Select Breeding */
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"Insemination");	

		/** Select type of insemination and fill form */
		if(data.get("type").equalsIgnoreCase("Artificial")) {
			breedingActivityListPage.select_ArtificialInsemination(); 
			addAIPage.enter_BullId(data.get("bullID"));
			addAIPage.select_semenBrand(data.get("semenBrand"));
			addAIPage.enter_InseminationDate(data.get("inseminationDate"));
			addAIPage.press_SaveButton();
			addAIPage.waitForProgressBar();
		}
		else {
			breedingActivityListPage.select_NaturalInsemination(); 
			addNIPage.enter_BullId("BullId");
			addNIPage.enter_Remarks(data.get("remarks"));
			addNIPage.enter_InseminationDate(data.get("inseminationDate")); //
			addNIPage.press_SaveButton();
			addAIPage.waitForProgressBar();
		}

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		farmerHomePage.click_HomeButton();

		/** Go to Breeding Timeline **/
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag, "Breeding");

		/** Check details of added Insemination in Breeding Timeline  */
		breedingTimelinePage.verify_Insemination(data.get("type"),data.get("inseminationDate"));
		
		/** Click on Edit button */
		breedingTimelinePage.press_editBtnLeft();
		addNIPage.press_SaveButton();
		addAIPage.waitForProgressBar();
		breedingSuccessPage.captureScreenshots("EditInsemination");


	}
}
