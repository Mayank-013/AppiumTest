package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BCS_AddBCSPage extends  BasePage {
		
		@AndroidFindBy(id = "addBcsBtn") 
		private MobileElement AddBcs_btn;
		
		@AndroidFindBy(id = "bcs_slider") 
		private MobileElement Bcs_slider;
		
		
		@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
				+ "new UiSelector().resourceIdMatches(\".*bcsDate.*\"))")  
		private MobileElement Bcs_Date;
		
		@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
				+ "new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")  
		private MobileElement save_btn;
		
		
		@AndroidFindBy(id = "record_another_bcs_entry") 
		private MobileElement gobacktoviewbcs;	
		
		
		@AndroidFindBy(id = "plusBtn") 
		private MobileElement plus_btn;
		
		@AndroidFindBy(id = "minusBtn") 
		private MobileElement minus_btn;
		
		@AndroidFindBy(id = "bcs_value_txt") 
		private MobileElement bcsscore;	
		
		@AndroidFindBy(id = "back_button") 
		private MobileElement back_button;
		
		@AndroidFindBy(id = "skip_btn") 
		private MobileElement skip_btn;
		
		@AndroidFindBy(id = "snackbar_text")
		private MobileElement warning_msg;
		
		@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
		        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*home.*\"))") 
		private MobileElement home ;
		
		
		public  void click_skipBtn()  
		{
			clickSkipBtn(skip_btn);

		}
		
		public void goBackToCattleList() {
			click(back_button);	
		}
		
		
		public  void clickskip_btn()  
		{
			clickSkipBtn(skip_btn);
			
			
		}	
		
		public void ClickAddBcs_btn() 
		{
			waitVisibility(AddBcs_btn);	
			click(AddBcs_btn);	
		}
		
		public void Clickgobacktoviewbcs() 
		{
			waitVisibility(gobacktoviewbcs);	
			click(gobacktoviewbcs);	
		}
		
		public void ClickBcs_slider() 
		{
			waitVisibility(plus_btn);	
			click(plus_btn);	
		}
		
		public void enter_bcsDate(String Date) {
			Bcs_Date.clear();
		//	LocalDate todaysDate = LocalDate.now();
			Bcs_Date.sendKeys(Date);

		
		}
		public void press_SaveButton() {
			click(save_btn);
		}
		
		public void Assert_Bcsscore(String score) 
		{
			Assert.assertEquals(bcsscore.getText(),score);
			System.out.println(bcsscore.getText());
		}
		
		public void addbcs(String date) throws Throwable {
			/** Fill BCS  Form */
			 ClickBcs_slider();
			 enter_bcsDate(date);
			 press_SaveButton();
			 waitForProgressBar();
			 Clickgobacktoviewbcs();
			 
		}
		
		public void homeButton() {
			waitForVisibility(home);
			click(home);
		}
		public void assertWarning(String message) {
			waitVisibility(warning_msg);
			Assert.assertEquals(warning_msg.getText(),message);		
		}

}
