package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CattleProfile_EditPage extends BasePage{

	@AndroidFindBy(id = "earTagNumber_et") 
	private MobileElement earTagNumber;
	
	@AndroidFindBy(id = "newCoorperativetagNumberEdtTxt") 
	private MobileElement cooperativetagNumber;

	@AndroidFindBy(id = "add_new_cooperative_btn") 
	private MobileElement add_newcooperativetag_btn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*updateCattleProfileBtn.*\"))")
	private MobileElement update_btn;
	
	public void enter_earTagNumber(String earTag) {
		earTagNumber.clear();
		sendKeys(earTagNumber,earTag);
	}
	
	public void enter_cooperativetagNumber(String earTag) {
		sendKeys(cooperativetagNumber,earTag);
		add_newcooperativetag_btn.click();
	}

	public void click_updateBtn() {
		waitForVisibility(update_btn);
		click(update_btn);
	}
	
}
