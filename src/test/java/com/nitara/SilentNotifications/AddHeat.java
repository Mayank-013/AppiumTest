package com.nitara.SilentNotifications;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.AddHeatAPI;
import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;

public class AddHeat extends GenericBase{
	
	@Test
	public void addHeat() throws Exception {	

		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle through API*/
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");
		
		new Helper_AppNavigation().goTo_BreedingActivityListfromCattleProfile(Tag);
		
		String heatDate = generateRandomData.getPastDate(20);
		new AddHeatAPI().addHeatData(Tag,heatDate,usertoken,url);
		
		/** Check details of added Heat in View Heat Page */ 
		breedingTimelinePage.waitForProgressBar();
		breedingTimelinePage.check_breedingStatus("Open");
		breedingTimelinePage.checkDateLeft("heatDate");
	}

}
