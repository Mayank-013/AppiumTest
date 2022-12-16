package com.nitara.HousingManagement;

import org.testng.annotations.Test;




import appCommonClasses.GenericBase;
import appCommonClasses.Helper_AppNavigation;


public class Createsmartshed extends GenericBase 
{
	@Test
	public void Create_smartshed() throws Throwable
	{
		String name= createshed.Generateshedname();
		
		/** Go to Selection of Shedtype page */
		new Helper_AppNavigation().goTo_SelectionofShedTypePage();			

		/** Creation of SmartShed */	
		
		/** Enter shed name */
		createshed.entershedname(name);
		
		/** Click next  button */
		createshed.clicknextbtn();	
		
		/** Click smart shed */
		createshed.clicksmartshedbtn();
		
		/** Select smartgroups */
		createshed.Clickcheckbox();	
		
		/** Click create smartshed button */
		createshed.clickcreatesmartshedbtn();
		
		/** capture screenshot */
		createshed.captureScreenshots("Creation of smartshed");
		
		/** search for the created shed*/ 
		shedViewPage.Searchshed(name);
		
		
		/** Assert the created shed */
		shedViewPage.Assertshed(name);
		
		
	}
}