package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class AddInsemination extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Insemination_ValidData(Map<String,String> data) throws Throwable {
		
		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		RegisterMilkingCattle reg = new RegisterMilkingCattle();
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


		/** Select Insemination accordingly from the list of activities and add insemination details */
		farmerHomePage.click_HomeButton();
		if(data.get("type").equalsIgnoreCase("Artificial")) {
			new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"ArtificialInsemination"); 
			addAIPage.assert_CattleTag(Tag); 
			addAIPage.enter_BullId(data.get("bullID"));
			addAIPage.enter_InseminationDate(generateRandomData.getPastDate(21));
			addAIPage.press_SaveButton();
		}
		else { 
			new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"NaturalInsemination");
			addNIPage.assert_CattleTag(Tag); 
			addNIPage.enter_BullId(data.get("bullID"));
			addNIPage.enter_Remarks(data.get("remarks"));
			addNIPage.enter_InseminationDate(generateRandomData.getPastDate(21)); //data.get("inseminationDate")
			addNIPage.press_SaveButton();
		}
				
		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.captureScreenshots("AddInsemination");
		breedingSuccessPage.cattletag_Assert(Tag);

	}
}