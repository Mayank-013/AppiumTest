package com.nitara.CattleManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.AccountManagement.Login;
import com.nitara.utils.DataProviderUtils;
import appCommonClasses.GenericBase;



public class RegisterHeifer extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Heifer(Map<String,String> data) throws Exception {

		/**Login **/
		new Login().Login_ValidData();
		
		String tagNumber =generateRandomData.generateRandomNumber(7);
		String cooptagNumber =generateRandomData.generateRandomNumber(12);

		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();
	

		/** Inseminated Heifer Register form */
		cattleTypePage.click_skipBtn();
		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));

		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));
			}
			else{
				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

	
		registerCattleInseminatedHeiferPage.press_SaveButton();

		/** Assert success Page */
		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");

	}
	
	
//	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void RegisterHeifer_PALess(Map<String, String> data) throws Exception {
//
//		String tagNumber = generateRandomData.generateRandomNumber(7);
//		String cooptagNumber = data.get("cooptagNumber");
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//		
//
//		/** Inseminated Heifer Register form */
//		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
//		 
//		registerCattleInseminatedHeiferPage.assert_CattleType();
//		 
//		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
//		 
//		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
//		 
//		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
//		 
//		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
//		 
//		 
//		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
//		 
//		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
//		 
//
//		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
//					data.get("crossedWith"));
//		}
//
//		// Check cattle Pregnant - Artificial or Natural Insemination
//		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
//						data.get("semenBrand"), data.get("bullId"));
//			} else {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
//						data.get("bullId"));
//			}
//		}
//
//
//		registerCattleInseminatedHeiferPage.press_SaveButton();
//		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
//
//	}
//
//	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void RegisterHeifer_PAGreat(Map<String, String> data) throws Exception {
//
//		String tagNumber = generateRandomData.generateRandomNumber(7);
//		String cooptagNumber = data.get("cooptagNumber");
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//	
//
//		/** Inseminated Heifer Register form */
//		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
//		 
//		registerCattleInseminatedHeiferPage.assert_CattleType();
//		
//		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
//		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
//		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
//		 
//		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
//		 
//		 
//		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
//		 
//		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
//		 
//
//		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
//					data.get("crossedWith"));
//		}
//
//		// Check cattle Pregnant - Artificial or Natural Insemination
//		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
//						data.get("semenBrand"), data.get("bullId"));
//			} else {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
//						data.get("bullId"));
//			}
//		}
//
//
//		registerCattleInseminatedHeiferPage.press_SaveButton();
//		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
//
//	}
//
//	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void RegisterHeifer_TagSpecialCharacter(Map<String, String> data) throws Exception {
//
//		String tagNumber = data.get("tagNumber");
//		String cooptagNumber = generateRandomData.generateRandomNumber(12);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForPageLoad();
//		farmerHomePage.click_RegisterCattleButton();
//
//		/** Inseminated Heifer Register form */
//		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
//		 
//		registerCattleInseminatedHeiferPage.assert_CattleType();
//
//		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
//		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
//		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
//		 
//		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
//		 
//		 
//		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
//		 
//		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
//		 
//
//		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
//					data.get("crossedWith"));
//		}
//
//		// Check cattle Pregnant - Artificial or Natural Insemination
//		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
//						data.get("semenBrand"), data.get("bullId"));
//			} else {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
//						data.get("bullId"));
//			}
//		}
//
//
//		registerCattleInseminatedHeiferPage.press_SaveButton();
//		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
//
//	}
//
//	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void RegisterHeifer_CheckSameTag(Map<String, String> data) throws Exception {
//
//		String tagNumber = data.get("tagNumber");
//		String cooptagNumber = generateRandomData.generateRandomNumber(12);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForPageLoad();
//
//		farmerHomePage.click_RegisterCattleButton();
//
//		/** Inseminated Heifer Register form */
//		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
//		 
//		registerCattleInseminatedHeiferPage.assert_CattleType();
//
//		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
//		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
//		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
//		 
//		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
//		 
//		 
//		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
//		 
//		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
//		 
//
//		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
//					data.get("crossedWith"));
//		}
//
//		// Check cattle Pregnant - Artificial or Natural Insemination
//		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
//						data.get("semenBrand"), data.get("bullId"));
//			} else {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
//						data.get("bullId"));
//			}
//		}
//
//		registerCattleInseminatedHeiferPage.press_SaveButton();
//		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
//	}
//
//	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void RegisterHeifer_CoopNonNumeric(Map<String, String> data) throws Exception {
//
//		String tagNumber = generateRandomData.generateRandomNumber(7);
//		String cooptagNumber = data.get("cooptagNumber");
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForPageLoad();
//		farmerHomePage.click_RegisterCattleButton();
//
//
//		/** Inseminated Heifer Register form */
//		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
//		 
//		registerCattleInseminatedHeiferPage.assert_CattleType();
//		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
//		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
//		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
//		 
//		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
//		 
//		 
//		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
//		 
//		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
//		 
//
//		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
//					data.get("crossedWith"));
//		}
//
//		// Check cattle Pregnant - Artificial or Natural Insemination
//		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
//						data.get("semenBrand"), data.get("bullId"));
//			} else {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
//						data.get("bullId"));
//			}
//		}
//        registerCattleInseminatedHeiferPage.press_SaveButton();
//		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
//	}
//
//	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void RegisterHeifer_TagMandate(Map<String, String> data) throws Exception {
//
//		String tagNumber = "";
//		String cooptagNumber = generateRandomData.generateRandomNumber(12);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//
//		/** Inseminated Heifer Register form */
//		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
//		 
//		registerCattleInseminatedHeiferPage.assert_CattleType();
//
//		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
//		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
//		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
//		 
//		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
//		 
//		 
//		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
//		 
//		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
//		 
//
//		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
//					data.get("crossedWith"));
//		}
//
//		// Check cattle Pregnant - Artificial or Natural Insemination
//		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
//						data.get("semenBrand"), data.get("bullId"));
//			} else {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
//						data.get("bullId"));
//			}
//		}
//
//		registerCattleInseminatedHeiferPage.press_SaveButton();
//		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
//	}
//
//	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void RegisterHeifer_BirthYear(Map<String, String> data) throws Exception {
//
//		String tagNumber = generateRandomData.generateRandomNumber(7);
//		String cooptagNumber = generateRandomData.generateRandomNumber(12);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//
//		/** Inseminated Heifer Register form */
//		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
//		 
//		registerCattleInseminatedHeiferPage.assert_CattleType();
//
//		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
//		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
//		 
//		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
//		 
//		 
//		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
//		 
//		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
//		 
//
//		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
//					data.get("crossedWith"));
//		}
//
//		// Check cattle Pregnant - Artificial or Natural Insemination
//		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
//						data.get("semenBrand"), data.get("bullId"));
//			} else {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
//						data.get("bullId"));
//			}
//		}
//
//		registerCattleInseminatedHeiferPage.press_SaveButton();
//		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
//	}
//
////	/*@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
////	public void RegisterHeifer_InseminationDate(Map<String, String> data) throws Exception {
////
////		String tagNumber = generateRandomData.generateRandomNumber(7);
////		String cooptagNumber = generateRandomData.generateRandomNumber(12);
////
////		/** Farmer Home page - Select Register Cattle */
////		farmerHomePage.waitForPageLoad();
////		farmerHomePage.click_RegisterCattleButton();
////
////
////		/** Inseminated Heifer Register form */
////		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
////		 
////		registerCattleInseminatedHeiferPage.assert_CattleType();
////
////		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
////		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
////		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
////		 
////		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
////		 
////		 
////		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
////		 
////		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
////		 
////
////		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
////			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
////					data.get("crossedWith"));
////		}
////
////		// Check cattle Pregnant - Artificial or Natural Insemination
////		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
////			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
////				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
////				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
////						data.get("semenBrand"), data.get("bullId"));
////			} else {
////				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
////				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
////						data.get("bullId"));
////			}
////		}
////
////		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
////		// Insemination
////		else if (data.get("isCattleInseminated").equalsIgnoreCase("true")) {
////			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
////				registerCattleInseminatedHeiferPage.isCattleInseminated();
////				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
////						data.get("semenBrand"), data.get("bullId"));
////			}
////
////			else {
////				registerCattleInseminatedHeiferPage.isCattleInseminated();
////				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
////						data.get("bullId"));
////			}
////		}
////		registerCattleInseminatedHeiferPage.press_SaveButton();
////
//////		registerCattleInseminatedHeiferPage.assertWarning(data.get("warningMessage"));
////
////	}
//
//	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void RegisterHeifer_VerifyBreedingActivity(Map<String, String> data) throws Exception {
//
//		String tagNumber = generateRandomData.generateRandomNumber(7);
//		String cooptagNumber = generateRandomData.generateRandomNumber(12);
//
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//		
//
//		/** Inseminated Heifer Register form */
//		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
//		 
//		registerCattleInseminatedHeiferPage.assert_CattleType();
//
//		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
//		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
//		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
//		 
//		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
//		 
//		 
//		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
//		 
//		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
//
//
//		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),
//					data.get("crossedWith"));
//		}
//
//		// Check cattle Pregnant - Artificial or Natural Insemination
//		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
//						data.get("semenBrand"), data.get("bullId"));
//			} else {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
//						data.get("bullId"));
//			}
//		}
//
//		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
//		// Insemination
//		else if (data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),
//						data.get("semenBrand"), data.get("bullId"));
//			}
//
//			else {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),
//						data.get("bullId"));
//			}
//		}
//		registerCattleInseminatedHeiferPage.press_SaveButton();
//		/** Assert success Page */
//		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
//		registerCattleSuccessPage.assertCattleTag(tagNumber);
//		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
//		helper_AppNavigation.goTo_CattleProfileSelectActivity(tagNumber,"BREEDING");
//		farmerHomePage.waitForPageLoad();
//		breedingTimelinePage.assert_HeatEntry();
//
//	}
//
//	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
//	public void RegisterHeifer_HeatEntry(Map<String, String> data) throws Exception {
//
//		String tagNumber = generateRandomData.generateRandomNumber(7);
//		String cooptagNumber = generateRandomData.generateRandomNumber(12);
//		String dateOfBirth=data.get("yearOfBirth");
//		
//		/** Farmer Home page - Select Register Cattle */
//		farmerHomePage.waitForProgressBar();
//		farmerHomePage.click_RegisterCattleButton();
//
//		/** Inseminated Heifer Register form */
//		cattleTypePage.select_cattleType("INSEMINATED HEIFER");
//		registerCattleInseminatedHeiferPage.assert_CattleType();
//
//		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
//		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
//		registerCattleInseminatedHeiferPage.select_YOB(dateOfBirth);
//		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
//		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
//		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));
//
//		if (data.get("isCrossBreed").equalsIgnoreCase("true")) {
//			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"),data.get("crossedWith"));
//		}
//
//		// Check cattle Pregnant - Artificial or Natural Insemination
//		if (data.get("isCattlePregnant").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand"), data.get("bullId"));
//			} else {
//				registerCattleInseminatedHeiferPage.isCattlePregnant(data.get("pregnantSince"));
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
//
//		// Check cattle is not pregnant and is only inseminated - Artificial or Natural
//		// Insemination
//		else if (data.get("isCattleInseminated").equalsIgnoreCase("true")) {
//			if (data.get("inseminationType").equalsIgnoreCase("artificial")) {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand"), data.get("bullId"));
//			}
//
//			else {
//				registerCattleInseminatedHeiferPage.isCattleInseminated();
//				registerCattleInseminatedHeiferPage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
//			}
//		}
//		registerCattleInseminatedHeiferPage.press_SaveButton();
//		/** Assert success Page */
//		registerCattleSuccessPage.captureScreenshots("RegisterHeifer");
//		registerCattleSuccessPage.assertCattleTag(tagNumber);
//		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
//		helper_AppNavigation.goTo_CattleProfileSelectActivity(tagNumber,"BREEDING");
//		farmerHomePage.waitForPageLoad();
//		breedingTimelinePage.assert_HeatEntry();
//	}
}