package com.nitara.PageObjects;


import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchCattle_CattleListPage extends BasePage{
	
	@AndroidFindBy(id = "search_farm_param") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "search_btn") 
	private MobileElement search_btn;
	
	
	@AndroidFindBy(id = "filter_msg") 
	private MobileElement msg;
	
	@AndroidFindBy(id = "back_button") 
	private MobileElement back_button;

	@AndroidFindBy(id = "filter_btn") 
	private MobileElement filter_btn;
	
	@AndroidFindBy(id = "checkBoxMilch") 
	private MobileElement checkBoxMilch;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*applyFilterBtn.*\"))")  
	private MobileElement applyFilterBtn;

	
	public void searchCattle(String Tag) {
		sendKeys(search_cattle,Tag);
		//sendKeys(search_cattle,Keys.ENTER);
	}
	
	public void goBackToHomePage() {
		click(back_button);	
	}

	public void assert_msg() {
		Assert.assertEquals(msg.getText(),"0 CATTLE LISTED FOR FARM");
	}
	
	public void press_SearchBtn() throws Exception {
		click(search_btn);
		waitForPageLoad();
	}
	
	public void click_FilterBtn() throws Exception {
		click(filter_btn);
	}
	
	public void select_checkBoxMilch() throws Exception {
		click(checkBoxMilch);
	}
	
	public void click_ApplyFilterBtn() throws Exception {
		click(applyFilterBtn);
	}

}
