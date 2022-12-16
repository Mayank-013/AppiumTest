package com.nitara.CattleManagement;

import java.util.Map;
import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;

public class RegisterMilkingorDryCattle extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_MilkingorDryCattle(Map<String,String> data) throws Exception {

		/**Login **/
		new Login().Login_ValidData();
		
		String tagNumber =generateRandomData.generateRandomNumber(7);
		String cooptagNumber =generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
		//cattleTypePage.click_skipBtn();
		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		registerMilkingCattlePage.enter_TagNumber(tagNumber);
		registerMilkingCattlePage.enter_CoopTagNumber(cooptagNumber);
		registerMilkingCattlePage.enter_Calvingdate(data.get("lastCalvingDate"));

		if(data.get("isCattleDry").equalsIgnoreCase("true")) {
			registerMilkingCattlePage.cattleIsDry();
			registerMilkingCattlePage.enter_DryPeriodDate(data.get("dryPeriodDate"));
		}

		registerMilkingCattlePage.press_SaveButton();
		
		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterMilch");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
	
	}
	
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_TagnumberAcceptsSpecialChars(Map<String,String> data) throws Exception{		
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number with special chars and save */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(data.get("tagNumber"));		
//		registerMilkingCattlePage.press_SaveButton();	
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_DuplicateTagnumberAllowed(Map<String,String> data) throws Exception{	
//		
//		String calving_date = generateRandomData.getPastDate(0);
//		
//		/** Register cattle */
//		String Tag = helperFunctions.RegisterCattle_MilkingCattle();		
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter previously registered Tag number and calving date and save */
//		farmerHomePage.waitForProgressBar();
//		registerMilkingCattlePage.enter_TagNumber(Tag);		
//		registerMilkingCattlePage.enter_Calvingdate(calving_date);
//		registerMilkingCattlePage.press_SaveButton();		
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	
//	@Test(groups="Regression1",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_CoopTagnumberAcceptsNonnumericChars(Map<String,String> data) throws Exception{
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number, Non-numeric Coop Tag Number and save  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(data.get("tagNumber"));	
//		registerMilkingCattlePage.enter_CoopTagNumber(data.get("coopTagNumber"));
//		registerMilkingCattlePage.press_SaveButton();		
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_CoopTagnumberAcceptsLessDigits(Map<String,String> data) throws Exception{
//
//		String cooptagNumber =generateRandomData.generateRandomNumber(11);
//		
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number, 11 digit Coop Tag Number and save  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(data.get("tagNumber"));	
//		registerMilkingCattlePage.enter_CoopTagNumber(cooptagNumber);
//		registerMilkingCattlePage.press_SaveButton();		
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_CoopTagnumberAcceptsMoreDigits(Map<String,String> data) throws Exception{
//
//		String cooptagNumber =generateRandomData.generateRandomNumber(13);
//		
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number, 11 digit Coop Tag Number and save  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(data.get("tagNumber"));	
//		registerMilkingCattlePage.enter_CoopTagNumber(cooptagNumber);
//		registerMilkingCattlePage.press_SaveButton();		
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	
//	
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_TagnumberMandate(Map<String,String> data) throws Exception{
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Save without entering any field  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.press_SaveButton();	
//		//registerMilkingCattlePage.press_SuggestionPopup();
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_CalvingDateMandate(Map<String,String> data) throws Exception{
//		
//		String tagNumber =generateRandomData.generateRandomNumber(7);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number and save  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
//		registerMilkingCattlePage.press_SaveButton();	
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_InseminationDateMandate(Map<String,String> data) throws Exception{
//		
//		String tagNumber =generateRandomData.generateRandomNumber(7);
//		String calving_date = generateRandomData.getPastDate(0);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number, calving date and click on isInseminated toggle and save  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
//		registerMilkingCattlePage.enter_Calvingdate(calving_date);
//		registerMilkingCattlePage.isCattleInseminated();
//		registerMilkingCattlePage.press_SaveButton();		
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_DryPeriodDateMandate(Map<String,String> data) throws Exception{
//		
//		String tagNumber =generateRandomData.generateRandomNumber(7);
//		String calving_date = generateRandomData.getPastDate(0);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number, calving date and click on isDry toggle and save  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
//		registerMilkingCattlePage.enter_Calvingdate(calving_date);
//		registerMilkingCattlePage.cattleIsDry();
//		registerMilkingCattlePage.press_SaveButton();		
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_CalvingAndInseminationDateGap(Map<String,String> data) throws Exception{
//		
//		String tagNumber =generateRandomData.generateRandomNumber(7);
//		String insemination_date = generateRandomData.getPastDate(0);
//		String calving_date = generateRandomData.getPastDate(14);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number, calving date and insemination date and save  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
//		registerMilkingCattlePage.enter_Calvingdate(calving_date);
//		registerMilkingCattlePage.isCattleInseminated();
//		registerMilkingCattlePage.enter_InseminationDate(insemination_date);
//		registerMilkingCattlePage.press_SaveButton();		
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	
//	@Test(groups="Regression",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
//	public void RegisterMilkingorDryCattle_DryPeriodDateCannotBeBeforeCalvingDate(Map<String,String> data) throws Exception{
//		
//		String tagNumber =generateRandomData.generateRandomNumber(7);
//		String calving_date = generateRandomData.getPastDate(0);
//		String dry_period_date = generateRandomData.getPastDate(1);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number, calving date and dry period date and save  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
//		registerMilkingCattlePage.enter_Calvingdate(calving_date);
//		registerMilkingCattlePage.cattleIsDry();
//		registerMilkingCattlePage.enter_DryPeriodDate(dry_period_date);
//		registerMilkingCattlePage.press_SaveButton();		
//		registerMilkingCattlePage.assert_ErrorMsg(data.get("warningMessage"));
//		
//	}
//	
//	@Test(groups="Regression")
//	public void RegisterMilkingorDryCattle_DefaultHeatEntryAdded() throws Exception{
//		
//		String tagNumber =generateRandomData.generateRandomNumber(7);
//		String calving_date = generateRandomData.getPastDate(30);
//		String insemination_date = generateRandomData.getPastDate(0);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		/** Select Cattle Type page - Select Milking and Dry Cattle */
//		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
//		registerMilkingCattlePage.assert_CattleType();
//		
//		/** Milking and Dry Cattle page - Enter Tag number, calving date and insemination date and save  */
//		farmerHomePage.waitForPageLoad();
//		registerMilkingCattlePage.enter_TagNumber(tagNumber);	
//		registerMilkingCattlePage.enter_Calvingdate(calving_date);
//		registerMilkingCattlePage.isCattleInseminated();
//		registerMilkingCattlePage.enter_InseminationDate(insemination_date);
//		registerMilkingCattlePage.press_SaveButton();
//		
//		/** Go to cattle profile and check if the heat entry is recorded on the breeding timeline */
//		helper_AppNavigation.goTo_CattleProfileSelectActivity(tagNumber,"BREEDING");
//		farmerHomePage.waitForPageLoad();
//		breedingTimelinePage.assert_HeatEntry();
//		
//	}

}

