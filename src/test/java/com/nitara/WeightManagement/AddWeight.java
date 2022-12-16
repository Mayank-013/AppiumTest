package com.nitara.WeightManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class AddWeight extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Weight_AddData(Map<String,String> data) throws Exception {

		/**Login **/
		new Login().Login_ValidData();
		
		/** Register cattle */
		String url = prop.getProperty("APIbaseUrl");
		String usertoken = new LoginAPI().API_FarmerLogin(url);
		String Tag = new RegisterMilkingCattle().registerMilkingOrDryCattle(url,usertoken,"RegisterMilkingCattle_Inseminated");

		
		/** Farmer Home page - Select Weight Button */
		farmerHomePage.waitForProgressBar();
		farmerHomePage.click_WeightButton();
		
		helper_AppNavigation.selectCattle(Tag);
		
		/** Fill Weight Form */
		if(data.get("calculateBy").equalsIgnoreCase("girth")) {
			addWeightPage.waitForPageLoad();
			addWeightPage.enter_girth(data.get("girth"));
			addWeightPage.enter_length(data.get("length"));
			addWeightPage.assert_calculatedWeight(data.get("girth"),data.get("length"));
			addWeightPage.enter_weightDate(data.get("dateOfWeight"));
			addWeightPage.click_saveBtn();
		}
		else {
			addWeightPage.select_directWeightMethod();
			addWeightPage.enter_weight(data.get("weight"));
			addWeightPage.enter_weightDate(data.get("dateOfWeight"));
			addWeightPage.click_saveBtn();
		}
		
		weightSuccessPage.captureScreenshots("AddWeight");
		weightSuccessPage.assert_successMsg();
		weightSuccessPage.assert_method(data.get("calculateBy").toUpperCase());
		
		}	

}
