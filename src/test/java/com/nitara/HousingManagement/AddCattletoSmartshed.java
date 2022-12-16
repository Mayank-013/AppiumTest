package com.nitara.HousingManagement;


import org.testng.annotations.Test;

import com.nitara.Helper.GenerateRandomData;

import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;
import appCommonClasses.HelperFunctions;

public class AddCattletoSmartshed extends GenericBase 


 {
	@Test
	public void SmartShed_AddCattle() throws Throwable
	
	
	{			
				
//		/** Register cattle */
//		String Tag = "7864334"; //new HelperFunctions().RegisterCattle_MilkingCattle();	
		
		
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
		
		
		
		
		}
	}

