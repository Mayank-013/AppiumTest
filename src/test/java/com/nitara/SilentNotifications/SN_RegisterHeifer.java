package com.nitara.SilentNotifications;

import org.testng.annotations.Test;
import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterBullCattle;
import com.nitara.APIFunctions.RegisterHeiferCattle;
import com.nitara.AccountManagement.Login;
import appCommonClasses.GenericBase;

public class SN_RegisterHeifer extends GenericBase 
{
	@Test
	public void registerHeifer() throws Exception

	{		

		/**Login **/
		new Login().Login_ValidData();

		/** Register cattle through API*/
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterHeiferCattle().registerHeiferCattle(url,usertoken,"RegisterHeiferCattle");

		/** Search Cattle */
		farmerHomePage.click_SearchCattleBtn();
		String searchTag = Tag.substring(0,4);
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(Tag);

	}
}
