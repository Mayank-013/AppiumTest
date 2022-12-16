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

public class ViewCalving extends GenericBase{


	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Calving_ViewData(Map<String,String> data) throws Throwable {

		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


		/**Login **/
		new Login().Login_ValidData(); 
		
		/** Go to cattle Profile page -> Select Breeding - Calving */
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromCattleProfile(Tag,"Calving");


		/** Fill calving form */
		if(data.get("calfResult").equalsIgnoreCase("Single")) {
			addCalvingPage.select_CalfResultSingle(data.get("calfResult"),data.get("calfGender1"));
		}
		else {
			addCalvingPage.select_CalfResultTwins(data.get("calfResult"),data.get("calfGender1"),data.get("calfGender2"));
		}
		addCalvingPage.enter_CalvingDate(generateRandomData.getPastDate(2));
		addCalvingPage.press_SaveButton();
		addCalvingPage.press_proceed();

		breedingSuccessPage.click_BackToBreedingTimeline();
	}
}
