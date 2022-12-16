package com.nitara.HousingManagement;

import org.testng.annotations.Test;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class Movecattle extends GenericBase

{	
	@Test
	public void Movecattle() throws Throwable
	
	{
				
		/** Register cattle */
	//	String Tag =  new HelperFunctions().RegisterCattle_MilkingCattle();	
		
		
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
		
		/** Select cattle to move */
		shedViewPage.ClickCheckbox();
		
		
		/** Move Cattle to other group  */
		createshed.clickmovecattle();		
		
		
		/** Click save button to move cattle */
		shedViewPage.ClickSavebtn();
		
		/** Assert success message in Move cattle success screen */
		movecattlesuccesspage.Movecattle_Assert();
		
		movecattlesuccesspage.captureScreenshots("Move cattle success" );
		
		/** Click Go to shed button */
		movecattlesuccesspage.Clickgotoshed();
		
		
	}
	
	
}