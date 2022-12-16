package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Settings_MilkingPreferencePage extends BasePage{
	
	@AndroidFindBy(id = "farmMilkingTv") 
	private MobileElement farmMilking;
	
	@AndroidFindBy(id = "cattleMilkingTv") 
	private MobileElement cattleMilking;
	
	@AndroidFindBy(id = "saveDataBtn") 
	private MobileElement save_btn;
	
	
	public void select_Preference(String pref)
	{	
		if(pref.equalsIgnoreCase("CATTLE MILKING"))
		click(cattleMilking);	
		else
			click(farmMilking);	
	}
	

	
	public void click_SaveBtn()
	{	
		click(save_btn);	
	}

}
