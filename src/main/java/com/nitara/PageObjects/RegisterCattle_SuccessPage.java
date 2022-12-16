package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterCattle_SuccessPage extends BasePage{

	
	
	@AndroidFindBy(id = "cattleTag") 
	private MobileElement cattleTag;
	

	
	@AndroidFindBy(id = "textView34") 
	private MobileElement succes_msg;
	
	@AndroidFindBy(id = "home") 
	private MobileElement home_btn;
	
	
	public void assertCattleTag(String tag) {
		waitVisibility(cattleTag);
		Assert.assertEquals(cattleTag.getText(),tag);
	}
	
	public void assertSuccessMsg(String msg) {
		waitVisibility(succes_msg);
		Assert.assertEquals(succes_msg.getText(),msg);
	} 
	
	public void goBackToHomePage() {
		// TODO Auto-generated method stub
		click(home_btn);		
		
	}

}
