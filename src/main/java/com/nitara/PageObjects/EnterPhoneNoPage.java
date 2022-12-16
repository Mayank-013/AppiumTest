package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterPhoneNoPage extends BasePage{
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*editTextPhone.*\"))")
	private MobileElement phone_et;
	
	@AndroidFindBy(id = "continue_button") 
	private MobileElement continue_btn;
	
	public void enter_PhoneNo(String phone) {
		sendKeys(phone_et, phone);
	}
	
	public void click_continue() {
		click(continue_btn);
	}
	
	

}
