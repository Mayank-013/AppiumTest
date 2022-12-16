package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CattleProfile_RemovePage extends BasePage{

	@AndroidFindBy(id = "remarksEditTxt") 
	private MobileElement remarks;
	
	@AndroidFindBy(id = "amountValue") 
	private MobileElement amountValue;
	
	@AndroidFindBy(id = "removeCattleBtn") 
	private MobileElement remove;
	
	@AndroidFindBy(id = "yesBtn") 
	private MobileElement yes_Btn;
	
	@AndroidFindBy(id = "deletedtext") 
	private MobileElement deleteText;

	
	@AndroidFindBy(id = "back_text") 
	private MobileElement back;
	
	public void assert_deleteMsg(String tag) throws Exception {
		Thread.sleep(5000);
		Assert.assertEquals(deleteText.getText(),"Cattle has been deleted");
	}
	
	public void enter_remarks(String remarksTxt) {
		waitVisibility(remarks);
		sendKeys(remarks,remarksTxt);
	}
	
	public void enter_amount(String amount) {
		waitVisibility(amountValue);
		sendKeys(amountValue,amount);
	}
	
	public void click_remove() {
		waitVisibility(remove);
		click(remove);
	}
	
	public void click_back() {
		waitVisibility(back);
		click(back);
	}
	
	public void click_yes() {
		waitVisibility(yes_Btn);
		click(yes_Btn);
	}
	

}
