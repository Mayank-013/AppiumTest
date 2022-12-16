package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterCattle_CalfPage extends BasePage{
	
	@AndroidFindBy(id = "select_cattle_tv") 
	private MobileElement select_cattle;


	@AndroidFindBy(id = "phone_number") 
	private MobileElement phone_number;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*earTagNumberOrName.*\"))") 
	private MobileElement TagNumber;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*cooperative_tag_number_et.*\"))")  
	private MobileElement CoopTagNumber;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*year_of_birth_spinner.*\"))") 
	private MobileElement year_of_birth;
	
	
	@AndroidFindBy(id = "month_of_birth_spinner") 
	private MobileElement month;
	
	@AndroidFindBy(id = "crossed_with_list_spinner") 
	private MobileElement crossed_with;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*cattle_type_spinner.*\"))") 
	private MobileElement cattle_type;
	
	@AndroidFindBy(id = "cattle_type_lbl") 
	private MobileElement cattle_type_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*breed_list_spinner.*\"))") 
	private MobileElement breed_list;
	
	@AndroidFindBy(id = "crossbreed_lbl") 
	private MobileElement crossbreed_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*crossbreed_toogle.*\"))") 
	private MobileElement crossbreed_toogle;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*save_btn.*\"))")  
	private MobileElement save_btn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*weight.*\"))") 
	private MobileElement weight;
	
	
	
	public void assert_CattleType() {
		waitVisibility(select_cattle);
		Assert.assertEquals(select_cattle.getText(), "CALF");
	}
	
	public void assert_Phone_Number(String phone) {
		waitVisibility(phone_number);
		Assert.assertEquals(phone_number.getText(), phone);
	}
	
	public void enter_TagNumber(String tag) {
		waitVisibility(TagNumber);
		sendKeys(TagNumber,tag);
	}
	
	public void enter_CoopTagNumber(String tag) {
		waitVisibility(CoopTagNumber);
		sendKeys(CoopTagNumber,tag);
	}
	

	public void select_YOB(String year) {
		click(year_of_birth);
		select_dropdown(year);

	}
	
	public void select_month(String mnth) {
		click(month);
		select_dropdown(mnth);

	}
	
	public void select_cattleType(String type) {
		click(cattle_type);
		select_dropdown(type);
	}
	
	public void select_cattleBreed(String breed) {
		scrollfindElement("BREED");
		click(breed_list);
		select_dropdown(breed);
	}
	
	public void select_crossbreedToggle(String toggle,String crossbreed) {
		//scrollfindElement("CROSSBREED");
		String checked = crossbreed_toogle.getAttribute("checked");
		if(checked.equals("false") && toggle.equals("true")) {
			crossbreed_toogle.click(); 
			click(crossed_with);
			select_dropdown(crossbreed);
		}
	
	}
	
	public void enter_weight(String kg) {
		sendKeys(weight,kg);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}

}
