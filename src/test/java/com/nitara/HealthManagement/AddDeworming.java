package com.nitara.HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;


public class AddDeworming extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Deworming_AddData(Map<String,String> data) throws Throwable {

		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		
		/** In this function -
		 * Reach the add health activity page for the cattle 
		 * Farmer HomePage -> Health Management -> Search Cattle with Tag No 
		 * -> Select health activity from the list
		 * 
		 * @param activity type - Vaccination /Deworming /Treatment
		 */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Deworming");
		
		/** Fill Deworming Form */
		addDewormingPage.select_dewormer(data.get("dewormer"));
		addDewormingPage.enter_Amount(data.get("amount"));
		addDewormingPage.enter_dewormerDate(generateRandomData.getPastDate(15));
		addDewormingPage.click_Save();
		
		/** Assert record success message for the activity 
		 * @Param activity type - Vaccination /Deworming /Treatment 
		*/	
		healthRecordSuccessPage.captureScreenshots("AddDeworming");
		healthRecordSuccessPage.assertSuccessMsg("Deworming");
		
	}	

}
