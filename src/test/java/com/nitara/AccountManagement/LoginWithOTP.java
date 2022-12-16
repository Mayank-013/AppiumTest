package com.nitara.AccountManagement;

import org.testng.annotations.Test;

import com.nitara.utils.PropertyManager;

import appCommonClasses.GenericBase;

public class LoginWithOTP extends GenericBase{


	@Test
	public void LoginwithOTP_ValidData() throws Exception {
		
		/** Select Language */
		//chooseLanguagePage.waitForProgressBar();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial
		
		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo("7760677616");
		enterPhoneNoPage.click_continue();
		
		/** Enter PIN */
		enterPinPage.click_loginWithOtpBtn();
		
		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();
		
		/** Navigated to Farmer Home page - assert if user on farmer homepage */
		//farmerHomePage.assert_farmerHomePage();
		
	}

}
