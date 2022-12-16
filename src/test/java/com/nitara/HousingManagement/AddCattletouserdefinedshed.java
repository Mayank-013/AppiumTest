package com.nitara.HousingManagement;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class AddCattletouserdefinedshed extends GenericBase 
{
	@Test
	public void AddCattletouserdefinedshed() throws Throwable
	{		
	
//		/** Register cattle */
//		String Tag =  new HelperFunctions().RegisterCattle_MilkingCattle();
		
	
		/**  Go to Housing  and creatuserdefinedshed */
		String  shedname = new HelperFunctions().CreateUserdefinedshed();	
		
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
		
		}
	}