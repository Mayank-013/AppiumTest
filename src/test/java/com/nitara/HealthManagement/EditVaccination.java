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

public class EditVaccination extends GenericBase{

	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Vaccination_EditData(Map<String,String> data) throws Throwable {



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
		new Helper_AppNavigation().goTo_addHealthActivityScreen(Tag,"Vaccination");


		/** Fill Vaccination Form */
		addVaccinationPage.select_vaccination(data.get("vaccine"));
		addVaccinationPage.enter_dosage(data.get("dosage"));
		addVaccinationPage.enter_Amount(data.get("amount"));
		addVaccinationPage.enter_vaccinationDate(generateRandomData.getPastDate(25));
		addVaccinationPage.click_Save();
		addVaccinationPage.waitForPageLoad();


		/** Assert record success message for the activity 
		 * @Param activity type - Vaccination /Deworming /Treatment 
		 */	
		healthRecordSuccessPage.captureScreenshots("AddVaccination");
		healthRecordSuccessPage.assertSuccessMsg("Vaccination");
		
		farmerHomePage.click_HomeButton();
		
		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Vaccination
		 * 
		 *  */
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Vaccination");

		viewVaccinationPage.click_editVaccination();
		addVaccinationPage.enter_vaccinationDate(generateRandomData.getPastDate(25));
		addVaccinationPage.click_Save();
		addVaccinationPage.waitForPageLoad();


		/* View Vaccination Data screen assert - edited data */
		viewVaccinationPage.captureScreenshots("EditVaccination");
		//		viewVaccinationPage.select_viewMore();
		//		viewVaccinationPage.assert_vaccineDate(date);



	}
}
