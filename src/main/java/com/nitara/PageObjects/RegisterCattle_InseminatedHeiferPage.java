package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterCattle_InseminatedHeiferPage extends BasePage{

	@AndroidFindBy(id = "select_cattle_tv") 
	private MobileElement select_cattle;


	@AndroidFindBy(id = "phone_number") 
	private MobileElement phone_number;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*earTagNumberOrName.*\"))")
	private MobileElement TagNumber;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*cooperative_tag_number_et.*\"))")
	private MobileElement CoopTagNumber;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*year_of_birth_spinner.*\"))") 
	private MobileElement year_of_birth;
	
	
	@AndroidFindBy(id = "month_of_birth_spinner") 
	private MobileElement month;
	
	@AndroidFindBy(id = "crossed_with_list_spinner") 
	private MobileElement crossed_with;
	
	@AndroidFindBy(id = "cattle_type_spinner") 
	private MobileElement cattle_type;
	
	@AndroidFindBy(id = "cattle_type_lbl") 
	private MobileElement cattle_type_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*breed_list_spinner.*\"))") 
	private MobileElement breed_list;
	
	@AndroidFindBy(id = "crossbreed_lbl") 
	private MobileElement crossbreed_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*crossbreed_toogle.*\"))") 
	private MobileElement crossbreed_toogle;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*is_pregnant.*\"))") 
	private MobileElement is_pregnant;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*insemination_type_spinner.*\"))") 
	private MobileElement insemination_type;

	
	
	@AndroidFindBy(id = "pregnant_since_spinner") 
	private MobileElement pregnant_since;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*inseminationDate.*\"))")  
	private MobileElement inserminationDate;
	
	@AndroidFindBy(id = "semen_brand_spinner") 
	private MobileElement semen_brand;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*save_btn.*\"))") 
	private MobileElement save_btn;

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*bull_id_et.*\"))") 
	private MobileElement bull_id;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*is_inseminated.*\"))") 
	private MobileElement is_Incerminated;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*insemination_date_lbl.*\"))") 
	private MobileElement insemination_date_lbl;
	
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement warning_msg;
	

	
	public void assert_CattleType() {
		waitVisibility(select_cattle);
		Assert.assertEquals(select_cattle.getText(), "INSEMINATED HEIFER");
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
	
	public void isCattlePregnant(String months) {
		String checked = is_pregnant.getAttribute("checked");
		if(checked.equals("false")) {
			is_pregnant.click();	
			pregnant_Since(months);
		}
	}
	
	public void isCattleInseminated() {
		String checked = is_Incerminated.getAttribute("checked");
		if(checked.equals("false")) {
			is_Incerminated.click();	
		}
	}
	
	public void artificialInsemination(String date,String semen,String BullId) throws InterruptedException {
		enter_InseminationDate(date);
		select_semenBrand(semen);
		enter_BullId(BullId);
		hideKeyboard();
	}
	
	
	public void naturalInsemination(String date,String BullId) {
		enter_InseminationDate(date);
		click(insemination_type);
		select_dropdown("Natural");
		enter_BullId(BullId);
		hideKeyboard();
	}
	
	

	public void pregnant_Since(String months) {
		click(pregnant_since);
		select_dropdown(months+" Month");
	}
	
	public void enter_InseminationDate(String Date) {
		sendKeys(inserminationDate,Date);
	}
	
	public void select_semenBrand(String semen) {
		click(semen_brand);
		select_dropdown(semen);
	}
	
	
	public void enter_BullId(String bullId) {
		sendKeys(bull_id,bullId);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	
	public void assertWarning(String message) {
		waitVisibility(warning_msg);
		Assert.assertEquals(warning_msg.getText(),message);		
	}

}
