package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreatePasswordPage extends BasePage {
	
	@AndroidFindBy(id = "createPinEt") 
	private MobileElement createPin;
	
	@AndroidFindBy(id = "reEnterPinEt") 
	private MobileElement reEnterPin;
	
	@AndroidFindBy(id = "savePin") 
	private MobileElement savePin;
	
	

	public void enter_createPin(int pin) {
		sendKeys(createPin, pin);
	}
	
	public void enter_reEnterPin(int pin) {
		sendKeys(reEnterPin, pin);
	}
	
	public void click_savePin() {
		click(savePin);
	}

	@AndroidFindBy(id = "snackbar_text")
	private MobileElement error_msg;
	
	public void assertWarningMsg(String msg) {
		waitVisibility(error_msg);
		Assert.assertEquals(error_msg.getText(),msg);
	} 

}
