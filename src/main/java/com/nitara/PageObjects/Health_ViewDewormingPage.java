package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_ViewDewormingPage  extends BasePage{

	@AndroidFindBy(id = "addDewromingData") 
	private MobileElement Add_Deworming;
	
	@AndroidFindBy(id = "viewMore") 
	private MobileElement viewMore;
	
	@AndroidFindBy(id = "dewormerName") 
	private MobileElement dewormerName;
	
	@AndroidFindBy(id = "dewormerDate") 
	private MobileElement dewormerDate;
	
	@AndroidFindBy(id = "editDeworming") 
	private MobileElement editDeworming;
	
	@AndroidFindBy(id = "deleteDeworming") 
	private MobileElement deleteDeworming;
	
	@AndroidFindBy(id = "android:id/message") 
	private MobileElement alertmessage;
	
	@AndroidFindBy(id = "snackbar_text") 
	private MobileElement snackbar_text;

	@AndroidFindBy(id = "android:id/button1") 
	private MobileElement yes_button;
	

	public void click_yes() {
		click(yes_button);
	}

	public void click_editDeworming() {
		click(editDeworming);
	}
	
	public void click_deleteDeworming() {
		click(deleteDeworming);
	}
	
	public void assert_DewormerDate(String date) {
		Assert.assertEquals(dewormerDate.getText(),date);
	}
	
	public void assert_deleteAlertMsg(String date) {
		Assert.assertEquals(alertmessage.getText(),"Are you sure you want to delete Deworming activity data recorded on "+date+" for this Cattle?");
	}
	
	public void assert_deleteMsg(String date) {
		Assert.assertEquals(snackbar_text.getText(),"Deworming activity data recorded on "+date+" for this Cattle has been deleted.");
	}
	
	
	public void select_viewMore() {
		click(viewMore);
	}
	
	public void click_addDeworming() {
		click(Add_Deworming);
	}
	
	public void assert_Dewormer(String name) {
		Assert.assertEquals(dewormerName.getText(),name);
	}
	
	


}
