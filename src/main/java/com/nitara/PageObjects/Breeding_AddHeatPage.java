package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_AddHeatPage  extends BasePage{
	
	@AndroidFindBy(id = "naturalBtn") 
	private MobileElement natural_btn;
	
	@AndroidFindBy(id = "artificialBtn") 
	private MobileElement artificial_btn;
	
	@AndroidFindBy(id = "heatTime") 
	private MobileElement heatTime;
	
	@AndroidFindBy(id = "toggle_mode") 
	private MobileElement timePicker;
	
	@AndroidFindBy(id = "input_hour") 
	private MobileElement input_hour;
	
	@AndroidFindBy(id = "input_minute") 
	private MobileElement input_minute;
	
	@AndroidFindBy(id = "am_pm_spinner") 
	private MobileElement am_pm;
	
	@AndroidFindBy(id = "button1") 
	private MobileElement ok_btn;
	
	@AndroidFindBy(id = "heat_date") 
	private MobileElement heat_date;
	
	@AndroidFindBy(id = "back_button_text") 
	private MobileElement back_button_text;

	
	@AndroidFindBy(uiAutomator =  "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "cattleTagName") 
	private MobileElement cattleTag;
	

	public void assert_CattleTag(String tag) {
		Assert.assertEquals(cattleTag.getText(), tag);
	}

	public void select_HeatType(String type) {
		
		if(type.equalsIgnoreCase("artificial")) {
			natural_btn.click();
		}
		
		else {
			artificial_btn.click();
		}
	}
	
	
	public void enter_HeatDate(String date) {
		heat_date.clear();
		sendKeys(heat_date,date);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	
	public void goBackToBreedingActivityListPage() {
		click(back_button_text);	
	}
	

}
