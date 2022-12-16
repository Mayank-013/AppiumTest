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

public class EditDeworming extends GenericBase{

	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Deworming_EditData(Map<String,String> data) throws Throwable {

		

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


		/**Login **/
		new Login().Login_ValidData();
		
		/** In this function -
		 * Reach the add health activity page for the cattle 
		 * Farmer HomePage -> Health Management -> Search Cattle with Tag No 
		 * -> Select health activity from the list
		 * 
		 * @param activity type - Vaccination /Deworming /Treatment
		 */
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Deworming");

		/** Fill Deworming Form */
		addDewormingPage.select_dewormer(data.get("dewormer"));
		addDewormingPage.enter_Amount(data.get("amount"));
		String date = generateRandomData.getPastDate(15);
		addDewormingPage.enter_dewormerDate(date);
		addDewormingPage.click_Save();
		addDewormingPage.waitForPageLoad();
		
		/** Assert record success message for the activity 
		 * @Param activity type - Vaccination /Deworming /Treatment 
		*/	
		healthRecordSuccessPage.captureScreenshots("AddDeworming");
		healthRecordSuccessPage.assertSuccessMsg("Deworming");
		farmerHomePage.click_HomeButton();
		
		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Deworming
		 * 
		 *  */
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Deworming");


		/* Edit deworming */
		viewDewormingPage.click_editDeworming();
		addDewormingPage.deselect_Dewormer();
		addDewormingPage.select_dewormer("Piperazine");
		addDewormingPage.enter_dewormerDate(date);
		addDewormingPage.click_Save();
		addDewormingPage.waitForPageLoad();

		/* Assert success message */
		healthRecordSuccessPage.assertSuccessMsg("Deworming has been recorded successfully for");
		healthRecordSuccessPage.goToView();

		/* View Deworming Data screen assert */
		viewDewormingPage.captureScreenshots("EditDeworming");
		viewDewormingPage.waitForPageLoad();
		viewDewormingPage.assert_Dewormer("Piperazine");
		viewDewormingPage.select_viewMore();
		viewDewormingPage.assert_DewormerDate(date);

	}



}
