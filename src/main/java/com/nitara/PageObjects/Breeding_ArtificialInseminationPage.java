package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_ArtificialInseminationPage extends BasePage{
		
		@AndroidFindBy(id = "bullId") 
		private MobileElement bullId;
		
		@AndroidFindBy(id = "insemination_date") 
		private MobileElement insemination_date;
		
		@AndroidFindBy(id = "semenBrand") 
		private MobileElement semenBrand;
		
		@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
				+ "new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")  
		private MobileElement save_btn;
		
		@AndroidFindBy(id = "cattleTagName") 
		private MobileElement cattleTag;
		

		public void assert_CattleTag(String tag) {
			Assert.assertEquals(cattleTag.getText(), tag);
		}
		

		public void enter_BullId(String id) {
			sendKeys(bullId, id);	
		}
		
		public void enter_InseminationDate(String date) {
			insemination_date.clear();
			sendKeys(insemination_date,date);
		}
		
		public void select_semenBrand(String semen) {
			click(semenBrand);
			select_dropdown(semen);
		}
		
		public void press_SaveButton() {
			click(save_btn);	
		}
		

		
		
		
		

	

}
