package appCommonClasses;


import com.nitara.utils.ExcelUtils;
import java.util.HashMap;
import java.util.Map;
import com.nitara.Helper.GenerateRandomData;


public class HelperFunctions extends PageInitialiser{



	public String RegisterCattle_MilkingCattle() {

		PageInitialiser.initializeAllPages();
		GenerateRandomData numb = new GenerateRandomData();

		String tagNumber = numb.generateRandomNumber(7);
		String cooptagNumber = numb.generateRandomNumber(12);

		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));


		ExcelUtils testdata = new ExcelUtils();
		Map<String, String> data  = new HashMap<String, String>();
		try {
			data = testdata.getTestData(sheet,nameofCurrMethod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//Farmer Home page - Select Register Cattle
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();

		registerMilkingCattlePage.select_cattleType("MILKING AND DRY CATTLE");
		registerMilkingCattlePage.assert_CattleType();
		registerMilkingCattlePage.enter_TagNumber(tagNumber);
		registerMilkingCattlePage.enter_CoopTagNumber(cooptagNumber);
		//		registerMilkingCattlePage.select_cattleType(data.get("cattleType"));
		//		registerMilkingCattlePage.select_cattleBreed(data.get("breed"));
		//
		//		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
		//			registerMilkingCattlePage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}

		registerMilkingCattlePage.select_Lactation(data.get("currentLactation"));
		registerMilkingCattlePage.enter_Calvingdate(data.get("lastCalvingDate"));
		//		registerMilkingCattlePage.enter_CalfCount(data.get("calfCount"));
		//		registerMilkingCattlePage.enter_Calf1Gender(data.get("calf1Gender"));

		//		if(data.get("calfCount").equalsIgnoreCase("twins")) {
		//			registerMilkingCattlePage.enter_Calf2Gender(data.get("calf2Gender"));
		//		}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerMilkingCattlePage.isCattlePregnant(data.get("pregnantSince"));
				registerMilkingCattlePage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));
			}
			else{
				registerMilkingCattlePage.isCattlePregnant(data.get("pregnantSince"));
				registerMilkingCattlePage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural Insemination
		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				registerMilkingCattlePage.isCattleInseminated();
				registerMilkingCattlePage.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}

			else{
				registerMilkingCattlePage.isCattleInseminated();
				registerMilkingCattlePage.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		if(data.get("isCattleDry").equalsIgnoreCase("true")) {
			registerMilkingCattlePage.cattleIsDry();
			registerMilkingCattlePage.enter_DryPeriodDate(data.get("dryPeriodDate"));
		}

		registerMilkingCattlePage.press_SaveButton();


		//Cattle Registration Success page
		/** Assert success Page */
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
		registerCattleSuccessPage.goBackToHomePage();

		return tagNumber;	
	}


	public String RegisterCattle_HeiferCattle() throws  Exception {

		PageInitialiser.initializeAllPages();
		GenerateRandomData numb = new GenerateRandomData();

		String tagNumber = numb.generateRandomNumber(7);
		String cooptagNumber = numb.generateRandomNumber(12);

		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));


		ExcelUtils testdata = new ExcelUtils();
		Map<String,String> data = testdata.getTestData(sheet,nameofCurrMethod);


		/** Farmer Home page - Select Register Cattle */
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_RegisterCattleButton();

		/** Inseminated Heifer Register form */
		farmerHomePage.waitForPageLoad();
		registerCattleInseminatedHeiferPage.findElement("INSEMINATED HEIFER");
		registerCattleInseminatedHeiferPage.assert_CattleType();
		registerCattleInseminatedHeiferPage.enter_TagNumber(tagNumber);
		registerCattleInseminatedHeiferPage.enter_CoopTagNumber(cooptagNumber);
		registerCattleInseminatedHeiferPage.select_YOB(data.get("yearOfBirth"));
		registerCattleInseminatedHeiferPage.select_month(data.get("monthOfBirth"));
		registerCattleInseminatedHeiferPage.select_cattleType(data.get("cattleType"));
		registerCattleInseminatedHeiferPage.select_cattleBreed(data.get("breed"));

		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
			registerCattleInseminatedHeiferPage.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}

		registerMilkingCattlePage.press_SaveButton();


		//Cattle Registration Success page
		/** Assert success Page */
		registerCattleSuccessPage.assertCattleTag(tagNumber);
		registerCattleSuccessPage.assertSuccessMsg("Registration has been saved successfully for");
		registerCattleSuccessPage.goBackToHomePage();

		return tagNumber;	
	}


	public void Insemination_ForGivenDate(String Tag, String date) throws Exception {

		PageInitialiser.initializeAllPages();

		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));

		ExcelUtils testdata = new ExcelUtils();
		Map<String,String> data = testdata.getTestData(sheet,nameofCurrMethod);


		helper_AppNavigation.goTo_BreedingActivityListfromFarmerHomepage(Tag);

		/** Select Insemination accordingly from the list of activities and add insemination details */
		if(data.get("type").equalsIgnoreCase("Artificial")) {
			breedingActivityListPage.waitForPageLoad();
			breedingActivityListPage.select_ArtificialInsemination(); 
			addAIPage.assert_CattleTag(Tag); 
			addAIPage.enter_BullId(data.get("bullID"));
			addAIPage.enter_InseminationDate(date);
			addAIPage.press_SaveButton();
		}
		else {
			breedingActivityListPage.waitForPageLoad();
			breedingActivityListPage.select_NaturalInsemination(); 
			addNIPage.assert_CattleTag(Tag); 
			addNIPage.enter_BullId(data.get("bullID"));
			addNIPage.enter_Remarks(data.get("remarks"));
			addNIPage.enter_InseminationDate(date);
			addNIPage.press_SaveButton();
		}


		//Assert cattletag in breeding successfully recorded page
		breedingSuccessPage.cattletag_Assert(Tag);
		breedingSuccessPage.homeButton();


	}


	public void setMilkingPreferences(String preference) {
		farmerHomePage.waitForPageLoad();
		farmerHomePage.click_SettingsButton();
		settingsPage.select_MilkingPreference();
		milkingPrefPage.select_Preference(preference);
		milkingPrefPage.click_SaveBtn();
		milkingPrefSuccessPage.assert_PreferenceType(preference);
		milkingPrefSuccessPage.goto_FarmerHomePage();
	}



	public void PD_ForGivenDate(String Tag, String date) throws Exception {

		String nameofCurrMethod = new Throwable()
				.getStackTrace()[0]
						.getMethodName();

		String sheet = nameofCurrMethod.substring(0,nameofCurrMethod.lastIndexOf("_"));

		ExcelUtils testdata = new ExcelUtils();
		Map<String,String> data = testdata.getTestData(sheet,nameofCurrMethod);

		helper_AppNavigation.goTo_BreedingActivityListfromFarmerHomepage(Tag);

		// Select PD accordingly from the list of activities 
		breedingActivityListPage.waitForPageLoad();
		breedingActivityListPage.select_pd();

		/** Fill PD Form */
		addPDPage.enter_PDdate(date);
		addPDPage.select_isCattlePregnant(data.get("isCattlePregnant"));
		addPDPage.assert_CattleTag(Tag);
		addPDPage.press_SaveButton();
		addPDPage.waitForProgressBar();


		//Assert cattletag in breeding successfully recorded page
		breedingSuccessPage.cattletag_Assert(Tag);
		breedingSuccessPage.homeButton();
	}
	
	public String   CreateSmartshed() throws Throwable
	{	
			//create smart shed with late milking group
		
			helper_AppNavigation.goTo_SelectionofShedTypePage();
		
			GenerateRandomData numb = new GenerateRandomData();

			String  name = numb.generateRandomNumber(7);
		 	/** Enter Smartshedname and Create shed */		
			System.out.println(name);
			
			createshed.entershedname(name);
			createshed.clicknextbtn();					
			createshed.clicksmartshedbtn();
			createshed.ClickLateMilkingGroup();			
			createshed.clickcreatesmartshedbtn();
			
			/** search for the created shed*/ 
			shedViewPage.Searchshed(name);
			
			/** Assert the created shed */
			shedViewPage.Assertshed(name);
			
			return name;
	}
	
	public String   CreateSmartshedfromShedViewPage() throws Throwable
	{	
			//create smart shed with late milking group
		
			createshed.ClickAddShedbtn();
		
			GenerateRandomData numb = new GenerateRandomData();

			String  name = numb.generateRandomNumber(7);
		 	/** Enter Smart shed name and Create shed */		
			System.out.println(name);
			
			createshed.entershedname(name);
			createshed.clicknextbtn();					
			createshed.clicksmartshedbtn();
			createshed.ClickLateMilkingGroup();			
			createshed.clickcreatesmartshedbtn();
			
			/** search for the created shed*/ 
			shedViewPage.Searchshed(name);
			
			/** Assert the created shed */
			shedViewPage.Assertshed(name);
			
			return name;
	}
	
	public String CreateUserdefinedshed() throws Throwable
	{	
			helper_AppNavigation.goTo_SelectionofShedTypePage();
			
			String name= createshed.Generateshedname();
				
			/** Creation of User Defined shed */
			
			/** Enter shedname */
			createshed.entershedname(name);
			
			/** Click next btn*/
			createshed.clicknextbtn();	
			
			/** Click Userdefinedshedbtn */		
			createshed.clickuserdefinedbtn();	
			
			/** Enter group name */
			createshed.enteruserdefinedname();	
			
			/** Click on Creategroups to create userdefined shed*/
			createshed.Clickcreatemygroups();
			
			/** search for the created shed*/ 
			shedViewPage.Searchshed(name);
			
			/** Assert the created shed */
			shedViewPage.Assertshed(name);
			
			return name;
	}
	
	public String   CreateUserdefinedshedfromShedViewPage() throws Throwable
	{	
			createshed.ClickAddShedbtn();
			
			String name= createshed.Generateshedname();
				
			/** Creation of User Defined shed */
			
			/** Enter shedname */
			createshed.entershedname(name);
			
			/** Click next btn*/
			createshed.clicknextbtn();	
			
			/** Click Userdefinedshedbtn */		
			createshed.clickuserdefinedbtn();	
			
			/** Enter group name */
			createshed.enteruserdefinedname();	
			
			/** Click on Creategroups to create userdefined shed*/
			createshed.Clickcreatemygroups();
			
			/** search for the created shed*/ 
			shedViewPage.Searchshed(name);
			
			/** Assert the created shed */
			shedViewPage.Assertshed(name);
			
			return name;
	}
	
	public void OnlyCreateUserdefinedshed() throws Throwable
	{	
		//this function only creates the shed and doesn't assert the creation
		
			helper_AppNavigation.goTo_SelectionofShedTypePage();
			
			String name= createshed.Generateshedname();
				
			/** Creation of User Defined shed */
			
			/** Enter shedname */
			createshed.entershedname(name);
			
			/** Click next btn*/
			createshed.clicknextbtn();	
			
			/** Click Userdefinedshedbtn */		
			createshed.clickuserdefinedbtn();	
			
			/** Enter group name */
			createshed.enteruserdefinedname();	
			
			/** Click on Creategroups to create userdefined shed*/
			createshed.Clickcreatemygroups();
	}




}