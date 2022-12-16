package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_ViewVaccinationPage extends BasePage{

	@AndroidFindBy(id = "addVaccinationData") 
	private MobileElement Add_Vaccination;
	
	@AndroidFindBy(id = "viewMore") 
	private MobileElement viewMore;
	
	@AndroidFindBy(id = "vaccineName") 
	private MobileElement vaccineName;
	
	@AndroidFindBy(id =  "dateValue") 
	private MobileElement vaccineDate;
	
	@AndroidFindBy(id = "editVaccination") 
	private MobileElement editVaccination;
	
	@AndroidFindBy(id = "deleteVaccination") 
	private MobileElement deleteVaccination;
	
	@AndroidFindBy(id = "android:id/message") 
	private MobileElement alertmessage;
	
	@AndroidFindBy(id = "snackbar_text") 
	private MobileElement snackbar_text;

	@AndroidFindBy(id = "dossageValue") 
	private MobileElement dosage;
	
	@AndroidFindBy(id = "android:id/button1") 
	private MobileElement yes_button;

	public void assert_Dosage(String dosagev) {
		Assert.assertEquals(dosage,dosagev+".0 ml");
	}
	
	public void click_yes() {
		waitVisibility(yes_button);
		yes_button.click();
	}

	public void click_editVaccination() {
		waitVisibility(editVaccination);
		editVaccination.click();
	}
	
	public void click_deleteVaccination() {
		waitVisibility(deleteVaccination);
		deleteVaccination.click();
	}
	
	public void assert_vaccineDate(String date) 
	{
		Assert.assertEquals(vaccineDate.getText(),date);
	}
	
	public void assert_deleteAlertMsg(String vaccine,String date) {
		Assert.assertEquals(alertmessage.getText(),"Are you sure you want to delete the "+vaccine+" vaccination activity recorded on "+date+" for this Cattle?");
	}
	
	public void assert_deleteMsg(String vaccine,String date) {
		Assert.assertEquals(snackbar_text.getText()," "+vaccine+" vaccination activity recorded on "+date+" has been deleted for this Cattle");
	}
	
	
	public void select_viewMore() {
		waitVisibility(viewMore);
		viewMore.click();
	}
	
	public void click_addVaccination() {
		waitVisibility(Add_Vaccination);
		Add_Vaccination.click();
	}
	
	public void assert_Vaccine(String name) {
		Assert.assertEquals(vaccineName.getText(),name);
	}
	
	


}
