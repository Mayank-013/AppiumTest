package com.nitara.HousingManagement;

import org.testng.annotations.Test;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class DelteSmartgroup extends GenericBase 
{
	@Test
	public void Deletegroup() throws Throwable
	
	{
		
		/**  Go to Housing  and creasmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();	
		
		/** search the created shed*/ 
		shedViewPage.Searchshed(shedname);
		
		/** Select Group */
		shedViewPage.ClickGroup();
		
		
	//	CreateShed.Clickgroup();
		/** Click three dots option */
		createshed.clickthreedotsicon();
		
		/** Click delete from the option*/
		createshed.clickDeletegroup();
		
		/** Click yes button to delete the group*/
		createshed.clickyesbtn();
		
		/*createshed.clickmovecattleoutofgrp();
		createshed.clickthreedotsicon();
		createshed.clickDeletegroup();
		//ShedViewPage.Clickgobackbtn();*/


	}	
}