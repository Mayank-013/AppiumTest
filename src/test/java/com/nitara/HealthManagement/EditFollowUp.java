package com.nitara.HealthManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.AddFollowUpAPI;
import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.Helper.GenerateRandomData;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class EditFollowUp extends GenericBase{

	@Test
	public void FollowUp_ViewData() throws Exception {

		
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


		/** In this function -
		 * Add Treatment to the cattle through API
		 * Add Follow Up to that treatment through API
		 */
		new AddFollowUpAPI().addFollowUpDetails(url, Tag);
		
		/**Login **/
		new Login().Login_ValidData();


		helper_AppNavigation.goTo_ViewHealthActivityScreen(Tag,"Treatment");
		/** View Treatment screen - Assert details*/
		viewTreatmentPage.waitForPageLoad();	
		viewTreatmentPage.select_viewMore();	
		viewTreatmentPage.click_moreOptions();
		viewTreatmentPage.click_editOption();
		editFollowUpPage.enter_FollowUpDate(new GenerateRandomData().getPastDate(-1));
		editFollowUpPage.click_updateBtn();

		healthRecordSuccessPage.captureScreenshots("EditFollowUp");
		healthRecordSuccessPage.assertSuccessMsg("Follow up");

	}

}
