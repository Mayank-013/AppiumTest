package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_AddFollowUpPage extends BasePage{
	
	@AndroidFindBy(id ="switchToggle") 
	private MobileElement isCured_toggle;
	
	@AndroidFindBy(id ="addMedicineBtn") 
	private MobileElement addMedicine_btn;
	
	@AndroidFindBy(id = "medicine") 
	private MobileElement medicineName;
	
	@AndroidFindBy(id = "dosage") 
	private MobileElement medicineDosage;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*antibioticsToggle.*\"))")  
	private MobileElement antibiotics_toggle;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*followUpToggle.*\"))")
	private MobileElement followUp_toggle;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*follow_up_after.*\"))")
	private MobileElement follow_up_after;
	

	@AndroidFindBy(id = "com.nitara.farmer:id/remarksEditTxt") 
	private MobileElement remarks_EditTxt;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*dateValue.*\"))")
	private MobileElement dateValue;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"saveBtn"+ "\"))")  
	private MobileElement saveBtn;
	
	
	
	public void select_isCuredToggle(String toggle) {
		String checked = isCured_toggle.getAttribute("checked");
		if(checked.equals("false") && toggle.equals("true")) {
			isCured_toggle.click(); 
		}
	}
	
	public void addMedicines(String medicine,String dosage) {
		waitVisibility(addMedicine_btn);
		addMedicine_btn.click();
		sendKeys(medicineName, medicine);
		sendKeys(medicineDosage, dosage);
	}
	
	public void select_antibioticsToggle(String toggle) {
		String checked = antibiotics_toggle.getAttribute("checked");
		if(checked.equals("false") && toggle.equals("true")) {
			antibiotics_toggle.click(); 
		}
	}
	
	
	public void select_followUpToggle(String toggle, String days) {
		String checked = followUp_toggle.getAttribute("checked");
		if(checked.equals("false") && toggle.equals("true")) {
			followUp_toggle.click(); 
			sendKeys(follow_up_after, days);
		}
	}
	
	public void addRemarks(String remarks) {
		sendKeys(remarks_EditTxt, remarks);
	}
	
	public void enter_date(String date) {
		dateValue.clear();
		sendKeys(dateValue,date);
	}
	
	public void click_save() {
		waitVisibility(saveBtn);
		click(saveBtn);

	}
}
