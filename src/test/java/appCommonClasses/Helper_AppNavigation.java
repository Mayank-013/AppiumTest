package appCommonClasses;



public class Helper_AppNavigation extends PageInitialiser{
	
	public void goTo_SelectionofShedTypePage() throws Throwable
	{
		
		createshed.waitForPageLoad();
		createshed.Clickhousingbtn();		
		createshed.ClickAddShedbtn();
		
		/*createshed.entershedname(shedname);
		
		createshed.clicknextbtn();		*/
	
	}
	
	public void goTo_addHealthActivityScreen(String Tag, String activity) throws Exception {

		/** Select Health Management in farmer Homepage */
		farmerHomePage.click_HealthManagementButton();

		/** Search Cattle */
		String searchTag = Tag.substring(0, 4);
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(Tag);

		/** Health Activities listed - Select activity */
		healthActivityListPage.select_activity(activity);
	}
	
	public void goTo_addBCSScreen(String Tag, String activity) throws Exception {

		/** Select BCS in farmer Homepage */
		farmerHomePage.click_BCSButton();

		/** Search Cattle */
		//String Tag = "Milch";
		String searchTag = Tag.substring(0, 4);
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(Tag);
	}
	
	public void goTo_addWeightScreen(String Tag, String activity) throws Exception {

		/** Select BCS in farmer Homepage */
		farmerHomePage.click_WeightButton();

		/** Search Cattle */
		//String Tag = "Milch";
		String searchTag = Tag.substring(0, 4);
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(Tag);
	}



	public void goTo_BreedingActivityListfromFarmerHomepage(String Tag) throws Exception {

		/** Select Breeding Management in farmer Homepage */
		farmerHomePage.click_BreedRecordingButton();

		/** Search Cattle */
		String searchTag = Tag.substring(0, 4);
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(Tag);
	}



	public void goTo_BreedingActivityListfromCattleProfile(String Tag) throws Exception {

		goTo_CattleProfileSelectActivity(Tag, "Breeding");

		breedingTimelinePage.click_AddActivity();

	}


	public void goTo_addBreedingActivityScreenfromCattleProfile(String Tag, String activity) throws Exception {

		goTo_BreedingActivityListfromCattleProfile(Tag);
		/** Breeding Activities listed - Select activity */
		breedingActivityListPage.select_Activity(activity);
	}

	public void goTo_addBreedingActivityScreenfromFarmerHomePage(String Tag, String activity) throws Exception {

		/** Select Breeding Management in farmer Homepage - Search Cattle with Tag */
		goTo_BreedingActivityListfromFarmerHomepage(Tag);

		/** Breeding Activities listed - Select activity **/
		breedingActivityListPage.select_Activity(activity);
	}


	public void goTo_ViewHealthActivityScreen(String tag,String activity) {

		/** This function
		 * Go to cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Search Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option
		 * 
		 */
		goTo_CattleProfileSelectActivity(tag,"Health");

		/** Health Activities listed - Select activity */
		healthActivityListPage.select_activity(activity);


	}
	
	
	public void goTo_addCattleMilkingScreenfromCattleProfile(String Tag, String activity) throws Exception {

		/** This function
		 * Go to cattle Profile page and selects the particular health related activity
		 * Farmer Homepage -> Search Cattle Page -> Search with Tag No. 
		 * -> Select Cattle -> Select Health option
		 * 
		 */
		breedingActivityListPage.waitForPageLoad();
		goTo_CattleProfileSelectActivity(Tag,activity);
		
		
	}

	public void goTo_CattleProfileSelectActivity(String tag,String activity)  {

		/** This function
		 * Go to cattle Profile page
		 * Farmer Homepage -> Seach Cattle Page -> Search with Tag No. 
		 * -> Select Cattle
		 * 
		 */
		goTo_CattleProfile(tag);


		/** Select the option in the cattle profile screen */
		cattleProfilePage.select_Activity(activity);
	}


	public void selectCattle(String Tag) {
		String searchTag = Tag.substring(0, 4);
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(Tag);
	}
	
	public void goTo_CattleProfile(String Tag) {

		/** Select Cattle Profile in Farmer Homepage */
		farmerHomePage.click_SearchCattleBtn();

		/** Search Cattle */
		//String Tag = "Milch";
		String searchTag = Tag.substring(0,4);
		searchCattlePage.searchCattle(searchTag);
		searchCattlePage.findElement(Tag);

	}
	
	
	
	
}
