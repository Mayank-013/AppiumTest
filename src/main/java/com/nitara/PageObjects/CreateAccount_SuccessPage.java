package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateAccount_SuccessPage extends BasePage{

	@AndroidFindBy(id = "snackbar_text") 
	private MobileElement snackbar_text;
	
	@AndroidFindBy(id ="textView34")
	private MobileElement successPageMsg;
	
	@AndroidFindBy(id ="getStartedBtn")
	private MobileElement getStartedBtn;
	
	public void click_getStartedBtn() {
		click(getStartedBtn);
	}
	
	public void assert_snackBarText() {
		Assert.assertEquals(snackbar_text.getText(),"User Added Successfully.");
	}
	
	
	public void assert_successPageMsg() {
		Assert.assertEquals(successPageMsg.getText(),"Your farm has been created successfully");
	}
	
	
	


}
