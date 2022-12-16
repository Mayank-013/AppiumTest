package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Settings_MilkingPrefUpdateSuccessPage extends BasePage{
	
	@AndroidFindBy(id = "preferenceType") 
	private MobileElement preferenceType;
	
	@AndroidFindBy(id = "home") 
	private MobileElement home_btn;
	
	@AndroidFindBy(id = "btnSettings") 
	private MobileElement goBackToSettings_btn;
	
	
	
	
	public void assert_PreferenceType(String type) {
		Assert.assertEquals(preferenceType.getText().toLowerCase(),type.toLowerCase());
		}

	public void goto_FarmerHomePage() {
		click( home_btn);
	}
}
