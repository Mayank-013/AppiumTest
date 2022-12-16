package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_NaturalInseminationPage extends BasePage{
	
	@AndroidFindBy(id = "bullId") 
	private MobileElement bullId;
	
	@AndroidFindBy(id = "insemination_date") 
	private MobileElement insemination_date;
	
	@AndroidFindBy(id = "remarksEt") 
	private MobileElement remarks;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")  
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "ccattleTagName") 
	private MobileElement cattleTag;
	

	public void assert_CattleTag(String tag) {
		Assert.assertEquals(cattleTag.getText(), tag);
	}
	
	
	public void enter_Remarks(String remark) {
		sendKeys(remarks, remark);
	}
	
	public void enter_BullId(String id) {
		sendKeys(bullId, id);	
	}
	public void enter_InseminationDate(String date) {
		insemination_date.clear();
		sendKeys(insemination_date,date);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}


}
