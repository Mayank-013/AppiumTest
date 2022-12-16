package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CattleProfilePage extends BasePage{

	@AndroidFindBy(id = "healthBtn") 
	private MobileElement health_btn;
	
	@AndroidFindBy(id ="breedingBtn")
	private MobileElement breeding_btn;
	
	@AndroidFindBy(id ="bcsBtn")
	private MobileElement bcs_btn;
	
	@AndroidFindBy(id ="editBtn")
	private MobileElement edit_btn;
	
	@AndroidFindBy(id ="back_text")
	private MobileElement back_text;
	
	@AndroidFindBy(id ="deleteBtn")
	private MobileElement delete_btn;
	
	
	public void assert_CattleProfile() throws Exception {
		Assert.assertEquals(back_text.getText(),"GO BACK TO CATTLE LIST");
	}
	
	public void select_Health() throws Exception {
		waitForPageLoad();
		waitForVisibility(health_btn);
		health_btn.click();
	}
	
	public void select_Bcs() throws Exception {
		waitForVisibility(bcs_btn);
		bcs_btn.click();
	}
	
	public void select_edit() throws Exception {
		waitForVisibility(edit_btn);
		edit_btn.click();
	}
	
	public void select_remove() throws Exception {
		waitForVisibility(delete_btn);
		delete_btn.click();
	}
	
	public void select_Breeding() {
		waitVisibility(breeding_btn);
		click(breeding_btn);
	}
	
	public void select_Activity(String activity) {
	
		MobileElement ele = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().resourceIdMatches(\".*"+activity.toLowerCase()+"Btn.*\"))"));
		click(ele);
		
	}
 
	
}
