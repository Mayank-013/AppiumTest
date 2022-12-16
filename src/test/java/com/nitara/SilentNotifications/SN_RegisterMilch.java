package com.nitara.SilentNotifications;

import org.testng.annotations.Test;
import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterBullCattle;
import com.nitara.APIFunctions.RegisterHeiferCattle;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import appCommonClasses.GenericBase;

public class SN_RegisterMilch extends GenericBase 
{
	@Test
	public void registerMilch() throws Exception

	{		
		/**Login **/
		new Login().Login_ValidData();

		/** Register cattle through API*/
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		/** Search Cattle */
		farmerHomePage.click_SearchCattleBtn();
		String searchTag = Tag.substring(0,4);
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(Tag);

	}
}
