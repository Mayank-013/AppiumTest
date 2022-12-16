package com.nitara.BreedingManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import io.restassured.RestAssured;
import appCommonClasses.HelperFunctions;

public class DeleteHeat extends GenericBase{

	

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Heat_DeleteData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingOrDryCattle");


		/**Login **/
		new Login().Login_ValidData();
		
		/** Go to cattle Profile page -> Select Breeding */
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"heat");
		
		/** Fill the heat form */ 
		addHeatPage.select_HeatType(data.get("heatType"));
		addHeatPage.enter_HeatDate(data.get("heatDate"));
		addHeatPage.press_SaveButton();
		addHeatPage.waitForProgressBar();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		breedingSuccessPage.click_BackToBreedingTimeline();

		/** Delete the added heat */
		breedingTimelinePage.press_DeleteBtnLeft();
		breedingTimelinePage.press_YesBtn();

		/** Assert Delete message */
		breedingTimelinePage.captureScreenshots("DeleteHeat");
		breedingTimelinePage.assertDeleteMsg("Heat",data.get("heatDate"));

	}
	

}
