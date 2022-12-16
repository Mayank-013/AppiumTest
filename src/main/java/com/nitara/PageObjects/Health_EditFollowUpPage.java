package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_EditFollowUpPage extends BasePage{
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")
	private MobileElement update_btn;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*dateValue.*\"))") 
	private MobileElement followUp_date;
	

	public void enter_FollowUpDate(String date) {
		followUp_date.clear();
		sendKeys(followUp_date,date);
	}
	
	public void click_updateBtn() {
		click(update_btn);
	}
}
