package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_ViewTreatmentPage extends BasePage{

	@AndroidFindBy(id = "addTreatmentData") 
	private MobileElement Add_Treatment;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*moreOptionFollowUp.*\"))") 
	private MobileElement moreOptionFollowUp;

	@AndroidFindBy(id = "treatmentName") 
	private MobileElement treatmentName;

	@AndroidFindBy(id = "viewMore") 
	private MobileElement viewMore;

	@AndroidFindBy(id = "medicinesValue") 
	private MobileElement treatmentMedicine;

	@AndroidFindBy(id = "mlValue") 
	private MobileElement ml;

	@AndroidFindBy(id = "treatmentDate") 
	private MobileElement treatmentDate;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"followUpDateValue"+ "\"))")  
	private MobileElement followUpDate;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"medicinesValues"+ "\"))")  
	private MobileElement followUpMedicine;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"mlValues"+ "\"))") 
	private MobileElement followUpDosage;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"diseaseStatusOnValue"+ "\"))")
	private MobileElement diseaseStatus;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"menu1"+ "\"))")  
	private MobileElement editOption;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"menu2"+ "\"))")  
	private MobileElement deleteOption;
	
	@AndroidFindBy(id = "android:id/button1") 
	private MobileElement yesBtn;
	
	
	@AndroidFindBy(id = "snackbar_text") 
	private MobileElement snackbar_text;
	
	
	public void assert_deleteMsg() {
		Assert.assertEquals(snackbar_text.getText(),"FollowUp for Treatment of "+treatmentName.getText()+" has been deleted for this Cattle.");
	}


	public void assert_TreatmentDate(String date) {
		Assert.assertEquals(treatmentDate.getText(),date);
	}
	
	public void assert_FollowUpDate(String date) {
		Assert.assertEquals(followUpDate.getText(),date);
	}
	
	public void click_moreOptions() {
		click(moreOptionFollowUp);
	}
	
	public void click_yesBtn() {
		click(yesBtn);
	}
	
	public void click_editOption() {
		click(editOption);
	}
	
	public void click_deleteOption() {
		click(deleteOption);
	}
	

	public void click_addTreatment() {
		click(Add_Treatment);
	}

	public void assert_Treatment(String name) {
		Assert.assertEquals(treatmentName.getText(),name);
	}

	public void assert_TreatmentDosage(String dosage) {
		Assert.assertEquals(ml.getText(),dosage+" ml");
	}
	
	public void assert_FollowUpDosage(String dosage) {
		Assert.assertEquals(followUpDosage.getText(),dosage+" ml");
	}
	
	public void assert_IsCured(String status) {
		if(status.equalsIgnoreCase("true"))
		Assert.assertEquals(diseaseStatus.getText(),"Cured");
		else
			Assert.assertEquals(diseaseStatus.getText(),"Not Cured");
	}

	public void select_viewMore() {
		click(viewMore);
	}

	public void assert_TreatmentMedicines(String medicine) {
		Assert.assertEquals(treatmentMedicine.getText(),medicine);
	}
	
	public void assert_FollowUpMedicines(String medicine) {
		Assert.assertEquals(followUpMedicine.getText(),medicine);
	}


}
