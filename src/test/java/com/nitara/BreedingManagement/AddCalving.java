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

public class AddCalving extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Calving_AddData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = reg.registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		/**Login **/
		new Login().Login_ValidData();
		
		/** Add PD for the cattle for the given date */
		farmerHomePage.waitForPageLoad();
		new HelperFunctions().PD_ForGivenDate(Tag,generateRandomData.getPastDate(151-21));

		/** Go to Calving screen */
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_BreedingActivityListfromFarmerHomepage(Tag);
		breedingActivityListPage.select_Activity("Calving");
		
		/** Fill calving form */
		if(data.get("calfResult").equalsIgnoreCase("Single")) {
			addCalvingPage.select_CalfResultSingle(data.get("calfResult"),data.get("calfGender1"));
		}
		else {
			addCalvingPage.select_CalfResultTwins(data.get("calfResult"),data.get("calfGender1"),data.get("calfGender2"));
		}
		addCalvingPage.enter_CalvingDate(generateRandomData.getPastDate(2));
		addCalvingPage.press_SaveButton();
		addCalvingPage.waitForProgressBar();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.captureScreenshots("AddCalving");
		breedingSuccessPage.cattletag_Assert(Tag);

		
	}
//	
//	@Test(groups= {"Regression"},dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void Calving_within150DaysAfterInseminationDate(Map<String, String> data) throws Throwable {
//
//		/** Register cattle */
//		String url = prop.getProperty("APIbaseUrl");
//		RegisterMilkingCattle reg = new RegisterMilkingCattle();
//		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
//		/** Add insemination for the cattle for the given date */
//		farmerHomePage.waitForPageLoad();
//		new HelperFunctions().Insemination_ForGivenDate(Tag, generateRandomData.getPastDate(151));
//
//		/** Add PD for the cattle for the given date */
//		farmerHomePage.waitForPageLoad();
//		new HelperFunctions().PD_ForGivenDate(Tag, generateRandomData.getPastDate(151 - 21));
//
//		/** Go to Calving screen */
//		farmerHomePage.waitForPageLoad();
//		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag, "Calving");
//
//		/** Fill calving form */
//		if (data.get("calfResult").equalsIgnoreCase("Single")) {
//			addCalvingPage.select_CalfResultSingle(data.get("calfResult"), data.get("calfGender1"));
//		} else {
//			addCalvingPage.select_CalfResultTwins(data.get("calfResult"), data.get("calfGender1"),
//					data.get("calfGender2"));
//		}
//		addCalvingPage.enter_CalvingDate(generateRandomData.getPastDate(15));
//		addCalvingPage.press_SaveButton();
//		addCalvingPage.assertWarning(data.get("warningMessage"));
//
//	}
//
//	@Test(groups= {"Regression"},dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void Calving_NoPDActivity(Map<String, String> data) throws Throwable {
//
//		/** Register cattle */
//		String url = prop.getProperty("APIbaseUrl");
//		RegisterMilkingCattle reg = new RegisterMilkingCattle();
//		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
//		/** Add insemination for the cattle for the given date */
//		farmerHomePage.waitForPageLoad();
//		new HelperFunctions().Insemination_ForGivenDate(Tag, generateRandomData.getPastDate(151));
//
//		/** Go to Calving screen */
//		farmerHomePage.waitForPageLoad();
//		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag, "Calving");
//		addCalvingPage.enter_CalvingDate(generateRandomData.getPastDate(0));
//		addCalvingPage.press_SaveButton();
//		addCalvingPage.assertAlert(data.get("warningMessage"));
//
//	}
//	
//	@Test(groups= {"Regression"},dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void Calving_NoInsemination(Map<String, String> data) throws Throwable {
//
//		/** Register cattle */
//		String url = prop.getProperty("APIbaseUrl");
//		RegisterMilkingCattle reg = new RegisterMilkingCattle();
//		String Tag = reg.registerMilkingOrDryCattle(url,"RegisterMilkingOrDryCattle");
//	
//		/** Go to Calving screen */
//		farmerHomePage.waitForPageLoad();
//		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag, "Calving");
//		addCalvingPage.assertWarning(data.get("warningMessage"));
//
//	}

}
