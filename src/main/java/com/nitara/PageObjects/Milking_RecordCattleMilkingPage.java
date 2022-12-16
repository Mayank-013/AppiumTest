package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Milking_RecordCattleMilkingPage extends BasePage{

	@AndroidFindBy(id = "search_farm_param") 
	private MobileElement searchCattle;

	@AndroidFindBy(id = "search_btn") 
	private MobileElement search_btn;

	@AndroidFindBy(id = "tvMorningKg") 
	private MobileElement morningYield;

	@AndroidFindBy(id = "afteNoonKg") 
	private MobileElement afternoonYield;

	@AndroidFindBy(id = "tvEveningKg") 
	private MobileElement eveningYield;

	@AndroidFindBy(id = "tvDate") 
	private MobileElement date;

	@AndroidFindBy(id = "btnSave") 
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "back_button") 
	private MobileElement back_btn;
	
	
	@AndroidFindBy(id = "skip_btn") 
	private MobileElement skip_btn;
	
	public  void click_skipBtn()  
	{
		clickSkipBtn(skip_btn);

	}
	
	public void enter_Date(String dte) {
		date.clear();
		sendKeys(date,dte);
	}

	public void searchcattle(String tagNumber) {
		click(searchCattle);
		sendKeys(searchCattle, tagNumber);
		hideKeyboard();
	}

	public void enterYield(String mrng ) {//, String noon, String evng
		sendKeys(morningYield, mrng);
		//		sendKeys(afternoonYield,noon);
		//		sendKeys(eveningYield, evng);
	}

	public void saveCattleMilkingDetails() {
		click(save_btn);
	}


	public void addCattleMilking(String tag,String yield) {
		
		// Add Cattle Milking Data for the tag 
		searchcattle(tag);
		enterYield(yield);
		saveCattleMilkingDetails();
	}

}
