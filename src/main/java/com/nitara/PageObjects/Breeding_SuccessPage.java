package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_SuccessPage extends BasePage{
	
	@AndroidFindBy(id = "cattleTags") 
	private MobileElement cattleTags;
	
	@AndroidFindBy(id = "home") 
	private MobileElement home;
	
	@AndroidFindBy(id = "back_cattle_result")
	private MobileElement backto_viewBreeding;
	
	@AndroidFindBy(id = "back_cattle_result")
	private MobileElement backto_cattleList;

	@AndroidFindBy(id = "record_another_cattle") 
	private MobileElement record_another;
	
	public void click_BackToBreedingTimeline() {
		click(backto_viewBreeding);
	}
	
	public void click_BackToCattleList() {
		click(backto_cattleList);
	}
	
	public void recordAnotherActivity() throws Exception {
		record_another.click();
	}

	
	public void cattletag_Assert(String tagNumber) {
		Assert.assertEquals(cattleTags.getText(), tagNumber);
	}
	
	public void homeButton() {
		waitForVisibility(home);
		click(home);
	}
	

}
