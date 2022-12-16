package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_AddPDPage extends BasePage{

	@AndroidFindBy(id = "pregnancy_test_date") 
	private MobileElement pdDate;
	
	@AndroidFindBy(id = "is_cattle_pregnant") 
	private MobileElement is_cattle_pregnant;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "cattleTagName") 
	private MobileElement cattleTag;
	

	public void assert_CattleTag(String tag) {
		Assert.assertEquals(cattleTag.getText(), tag);
	}
	
	public void select_isCattlePregnant(String status) {
		if(status.equalsIgnoreCase("false")) {
			is_cattle_pregnant.click();
		}
	}
	
	public void enter_PDdate(String date) {
		pdDate.clear();
		sendKeys(pdDate,date);
	}
	

	public void press_SaveButton() {
		click(save_btn);	
	}


}
