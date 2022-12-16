package com.nitara.HousingManagement;

import org.testng.annotations.Test;

import appCommonClasses.GenericBase;
import appCommonClasses.HelperFunctions;

public class DeleteSmartshed extends GenericBase 
{
	@Test
	public void Delete_Smartshed() throws Throwable
	
	{	
		/**  Go to Housing  and creasmartshed */
		String  shedname = new HelperFunctions().CreateSmartshed();	
		
		/** search the created shed*/ 
		shedViewPage.Searchshed(shedname);
		
		
		/**Click on three dots icon */		
		createshed.clickthreedotsicon();
		
		/** Click Delete shed */ 
		createshed.clickDeleteshed();
		
		/** Click delete button */
		createshed.clickyesbtn();
		
	//	createshed.clickmovecattleoutofgrp();
		
		createshed.captureScreenshots("Deletesmartshed");
	/*	createshed.clickthreedotsicon();
		createshed.clickDeletegroup();
	//	ShedViewPage.Clickgobacktoshed();
		
		createshed.clickyesbtn();*/
		
		
		

}
	
}