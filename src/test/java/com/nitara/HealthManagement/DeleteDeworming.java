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

public class DeleteDeworming extends GenericBase{

	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Deworming_DeleteData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


		/**Login **/
		new Login().Login_ValidData();
		
		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Deworming
		 * 
		 *  */
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Deworming");

		/** Add deworming data from view deworming data page */
		viewDewormingPage.click_addDeworming();
		
		/** Fill the deworming form 
		 * 
		 * Parameter - data from dataProvider, date */
		String date = generateRandomData.getPastDate(40);
		addDewormingPage.addDeworming(data,date);

	
		/** Delete the added deworming */
		
		viewVaccinationPage.captureScreenshots("DeleteVaccination");
		viewDewormingPage.click_deleteDeworming();
		viewDewormingPage.assert_deleteAlertMsg(date);
		viewDewormingPage.click_yes();
		viewDewormingPage.captureScreenshots("DeleteDeworming");
		viewDewormingPage.assert_deleteMsg(date);
	
	}

}
