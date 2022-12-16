package com.nitara.BCSManagement;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;


public class ViewBcs extends GenericBase 


{
	@Test
	public void ViewBcs() throws Throwable
	
	{	
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		
		/** Go to cattle Profile page -> Select BCS */
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag, "BCS");		
		
		
		/** Clic Addbcs from viewbcs page */
		addbcsPage.ClickAddBcs_btn();
		
		/** Fill bcs Form */
		String date = generateRandomData.getPastDate(2);
		addbcsPage.addbcs(date);
		
//		/** Select Time Period from dropdown */
//		viewbcspage.select_Timeperiod();
		
		/** Assert bcs score*/
	//	viewbcspage.assert_Bcsscore();
		
		/** View the added details */
		viewbcspage.captureScreenshots("View BCS");
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
