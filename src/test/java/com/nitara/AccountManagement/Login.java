package com.nitara.AccountManagement;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.nitara.utils.ExcelUtils;
import com.nitara.utils.PropertyManager;

import appCommonClasses.GenericBase;

public class Login extends GenericBase{
	@Test
	public void Login_ValidData() throws Exception {
		
		/** Select Language */
		//chooseLanguagePage.waitForProgressBar();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		JSONObject data = new ExcelUtils().readRowField("GeneralData", "NewUser",prop.getProperty("API_Testdata"));
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(data.getString("NewUser"));
		enterPhoneNoPage.click_continue();
		
		
		/** Enter PIN */
		enterPinPage.enter_pin("123456");
		enterPinPage.click_loginBtn();
		
		/** Navigated to Farmer Home page - assert if user on farmer homepage */
		farmerHomePage.assert_farmerHomePage();
	}

}
