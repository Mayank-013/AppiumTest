package com.nitara.PageObjects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Milking_RecordFarmMilkingPage extends BasePage{
	
	@AndroidFindBy(id = "yieldValue")
	private MobileElement yield_et;
	
	@AndroidFindBy(id = "dateValue") 
	private MobileElement date_et;
	
	@AndroidFindBy(id = "fatValue") 
	private MobileElement fat_et;
	
	@AndroidFindBy(id = "priceValue") 
	private MobileElement price_et;
	
	@AndroidFindBy(id = "snfValue") 
	private MobileElement snf_et;
	
	@AndroidFindBy(id = "text1") 
	private MobileElement session_dropdown;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveDataBtn.*\"))") 
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "img_Back") 
	private MobileElement back_btn;
	
	
	public void enter_yield(String yield) {
		sendKeys(yield_et, yield);
	}
	
	public void enter_snf(String snf) {
		sendKeys(snf_et, snf);
	}
	
	public void enter_fat(String fat) {
		sendKeys(fat_et, fat);
	}
	public void enter_price(String price) {
		sendKeys(price_et, price);
	}
	
	public void select_session(String session) {
		click(session_dropdown);
		List<MobileElement> sessionList = (List<MobileElement>) driver.findElementsById("android:id/text1");
		for(int i=0;i<sessionList.size();i++ ) {
			System.out.println(sessionList.get(i).getText());
			if(sessionList.get(i).getText().equalsIgnoreCase(session)) {
				System.out.println(sessionList.get(i).getText());
				sessionList.get(i).click();
				break;
			}
		}
	}
		
		public void enter_FarmMilkingDate(String date) {
			 date_et.clear();
			sendKeys(date_et,date);
		}
		
		public void saveFarmMilkingDetails() {
			click(save_btn);
		}
		
		public void goto_FarmerHomePage() {
			click(back_btn);
		}

	

}
