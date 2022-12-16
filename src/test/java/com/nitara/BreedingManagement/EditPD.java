package com.nitara.BreedingManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;

public class EditPD extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void PD_EditData(Map<String,String> data) throws Throwable {

		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");


		
		/**Login **/
		new Login().Login_ValidData();
		
		/** FarmerHomePage -> Select Breeding */
		farmerHomePage.waitForPageLoad();
		new Helper_AppNavigation().goTo_addBreedingActivityScreenfromFarmerHomePage(Tag,"PD");	

		
		/** Fill PD Form */
		addPDPage.enter_PDdate(generateRandomData.getPastDate(40-21));
		addPDPage.select_isCattlePregnant(data.get("isCattlePregnant"));
		addPDPage.assert_CattleTag(Tag);
		addPDPage.press_SaveButton();
		addPDPage.waitForProgressBar();

		/** Assert cattletag in breeding successfully recorded page */
		breedingSuccessPage.cattletag_Assert(Tag);
		farmerHomePage.click_HomeButton();

		/** Go to Breeding Timeline **/
		new Helper_AppNavigation().goTo_CattleProfileSelectActivity(Tag, "Breeding");
		
		
		/** Edit the added PD details */
		breedingSuccessPage.captureScreenshots("EditPD");
		breedingTimelinePage.press_editBtnRight();
		addPDPage.press_SaveButton();
		addPDPage.waitForProgressBar();

	
		breedingSuccessPage.cattletag_Assert(Tag);
		breedingSuccessPage.captureScreenshots("EditPD");
		
	
	}
}
