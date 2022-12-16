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

public class DeleteVaccination extends GenericBase{

	@Test (dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Vaccination_DeleteData(Map<String,String> data) throws Throwable {
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		
		/**Login **/
		new Login().Login_ValidData();
		
		/** This function
		 * Go to Cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option -> Health Activities listed - Select Vaccination
		 * 
		 *  */
		new Helper_AppNavigation().goTo_ViewHealthActivityScreen(Tag,"Vaccination");

		/** Add deworming data from view deworming data page */
		viewVaccinationPage.click_addVaccination();
		
		
		/** Fill Vaccination form */
		String date = generateRandomData.getPastDate(40);
		addVaccinationPage.addVaccination(data,date);
		
		/** Delete the added vaccination */
		viewVaccinationPage.captureScreenshots("DeleteVaccination");
		viewVaccinationPage.click_deleteVaccination();
		viewVaccinationPage.assert_deleteAlertMsg(data.get("vaccine"),date);
		viewVaccinationPage.click_yes();
		viewVaccinationPage.assert_deleteMsg(data.get("vaccine"),date);
	}
}



