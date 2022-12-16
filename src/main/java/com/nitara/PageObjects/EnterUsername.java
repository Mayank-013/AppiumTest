package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterUsername extends BasePage{

	@AndroidFindBy(id = "enterFirstNameEt") 
	private MobileElement firstName_Et;
	
	@AndroidFindBy(id = "middleNameEt") 
	private MobileElement middleName_Et;
	
	@AndroidFindBy(id = "lastNameEt") 
	private MobileElement lastName_Et;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*createNewAccount.*\"))") 
	private MobileElement createNewAccount;
	
	public void enter_firstName(String fname) {
		sendKeys(firstName_Et, fname);
	}
	
	public void enter_middleName(String sname) {
		sendKeys(middleName_Et, sname);
	}
	
	public void enter_lastName(String lname) {
		sendKeys(lastName_Et, lname);
	}
	
	public void click_createNewAccount() {
		click(createNewAccount);
	}
	
	

}
