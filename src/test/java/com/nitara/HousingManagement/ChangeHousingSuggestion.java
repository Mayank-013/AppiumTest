package com.nitara.HousingManagement;

import org.testng.annotations.Test;

import com.nitara.PageObjects.ChangeHousing;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class ChangeHousingSuggestion extends GenericBase 
{
	@Test
	public void ChangeHousing() throws Throwable
	{
		
		
		/** Register cattle */
		//String Tag =  new HelperFunctions().RegisterCattle_MilkingCattle();	
		
		
		/**  Go to Housing  and creasmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();	
		
		/** search the created shed*/ 
		shedViewPage.Searchshed(shedname);
		
		/** Select Group */
		shedViewPage.ClickGroup();
		
		/** Select Add cattle to group */
		shedViewPage.ClickAddCattleToGroupBtn();
		
		/** Select Cattle */
		shedViewPage.ClickCheckbox();
		
		/** Select  Add to group */
		shedViewPage.ClickAddToGroupBtn();
		
		
		/** CLick go back button */ 
		shedViewPage.Clickgobacktoshed();
	
		/** Click home button */
		farmerHomePage.click_HomeButton();
		
		
		/** CLick farm analysis button */
		changehousing.ClickFarmanalysis();
		
		/** Click changehousing in farm analysis */
		changehousing.Clickhousingchange();
		
		/** move cattle to recommemnded shed*/
		changehousing.Clicmovecattle();
		
		/** Click save */
		changehousing.ClickSave();	
		
		/** Assert success message */
		changehousing.ChangeHousing_Assert();
		
		/** Click home button */
		farmerHomePage.click_HomeButton();
		
		
		
		
		
		
}

	
		
	
}