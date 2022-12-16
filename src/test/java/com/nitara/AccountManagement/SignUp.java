package com.nitara.AccountManagement;


import org.testng.annotations.Test;

import com.nitara.APIFunctions.LoginAPI;
import com.nitara.APIFunctions.RegisterMilkingCattle;
import com.nitara.APIFunctions.UpdateFarmLocation;
import com.nitara.utils.ExcelUtils;

import appCommonClasses.GenericBase;

public class SignUp extends GenericBase{

	@Test(priority = 1,groups = "Smoke")
	public void SignUp_ValidData() throws Exception {

		/** Select Language */
		//chooseLanguagePage.waitForProgressBar();
		chooseLanguagePage.select_Language("ENGLISH");
		chooseLanguagePage.click_skipBtn(); // Skip Tutorial


		String phone = generateRandomData.generateRandomNumber(10);

		/** Enter Phone Number **/
		enterPhoneNoPage.enter_PhoneNo(phone);
		enterPhoneNoPage.click_continue();

		/** Enter OTP */
		enterOTPpage.enter_otp("1111");
		enterOTPpage.click_ContinueBtn();

		/** Enter PIN */
		createPasswordPage.enter_createPin(123456);
		createPasswordPage.enter_reEnterPin(123456);
		createPasswordPage.click_savePin();

		/** Enter Username */
		String firstName = "fName"+generateRandomData.generateRandomNumber(2);
		String lastName = "test";
		enterUsername.enter_firstName(firstName);
		enterUsername.enter_lastName(lastName);
		enterUsername.click_createNewAccount();

		/** Assert Success Page */
		//createAccountSuccessPage.assert_snackBarText();
		createAccountSuccessPage.assert_successPageMsg();
		createAccountSuccessPage.click_getStartedBtn();

		/** Navigated to Farmer Home page - assert if set location option is shown */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.assert_farmerHomePageAfterSignUp();

		String filepath = prop.getProperty("API_Testdata");
		new ExcelUtils().writeStringData("GeneralData","NewUser", phone.toString(), filepath);


	}

	

	
	@Test(priority = 2,groups = "Smoke")
	public void setupAccount() throws Exception {

		String APIbaseUrl  = prop.getProperty("APIbaseUrl");
		/* Update Farm Location */
		//
		new UpdateFarmLocation().updateFarmLocation(APIbaseUrl);
		
		String usertoken = new LoginAPI().API_FarmerLogin(APIbaseUrl);

		/* Register Cattle in Farm */
		String tagNo = new RegisterMilkingCattle().registerMilkingOrDryCattle(APIbaseUrl,usertoken, "RegisterMilkingOrDryCattle");

		/**Login **/
		new Login().Login_ValidData();
		
		String searchTag = tagNo.substring(0, 4);
		
		/* Skip WalkThrough - Breeding*/
		farmerHomePage.waitForProgressBar();
		farmerHomePage.click_BreedRecordingButton();
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(tagNo);
		breedingActivityListPage.click_skipBtn();
		breedingActivityListPage.goBackToCattleList();
		searchCattlePage.goBackToHomePage();

		/* Skip WalkThrough - Disease Predictor*/
		//farmerHomePage.waitForProgressBar();
		farmerHomePage.click_DiseasePredictorButton();
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(tagNo);
		diseasepredictorpage.click_skipBtn();
		diseasepredictorpage.goBackToCattleList();
		searchCattlePage.goBackToHomePage();

		/* Skip WalkThrough - Weight*/
		//farmerHomePage.waitForProgressBar();
		farmerHomePage.click_WeightButton();
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(tagNo);
		addWeightPage.click_skipBtn();
		addWeightPage.goBackToCattleList();
		searchCattlePage.goBackToHomePage();
		
		/* Skip WalkThrough - BCS*/
		//farmerHomePage.waitForProgressBar();
		farmerHomePage.click_BCSButton();
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(tagNo);
		addbcsPage.click_skipBtn();
		addbcsPage.goBackToCattleList();
		searchCattlePage.goBackToHomePage();
		
		/* Skip WalkThrough -Milking*/
		//farmerHomePage.waitForProgressBar();
		farmerHomePage.click_MilkRecordingButton();
		cattleMilkingPage.click_skipBtn();
		milkingPrefPage.click_SaveBtn();
		milkingPrefPage.click_SaveBtn();
		farmMilkingPage.goto_FarmerHomePage();


	}

}
