package com.nitara.PageObjects;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_AddVaccinationPage extends BasePage{

	@AndroidFindBy(id = "amountValue") 
	private MobileElement amount;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveBtn.*\"))")
	private MobileElement save_button;

	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*dateValue.*\"))")
	private MobileElement vaccinationDate;
	

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*vaccineDosageValue.*\"))") 
	private MobileElement dosage;
	


	public void enter_vaccinationDate(String date) {
		vaccinationDate.clear();
		sendKeys(vaccinationDate,date);
	}



	public void deselect_Vaccination() {
		List<MobileElement> deselect = (List<MobileElement>) driver.findElementsById("checkbox");
		for(int i=0;i<deselect.size()-1 ;i++ ) {
			System.out.println("No Click");
			if(deselect.get(i).getAttribute("checked").equals("true")) {
				System.out.println("Click");
				deselect.get(i).click();	
			}

		}


	}


	public void select_vaccination(String vaccine) {
		String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/";

		for(int i=1;i<6;i++) {
			WebElement vaccines = driver.findElement(By.xpath(xpath+"android.widget.FrameLayout["+i+"]/android.widget.TextView"));
			if(vaccines.getText().equalsIgnoreCase(vaccine)) {
				driver.findElement(By.xpath(xpath+"android.widget.FrameLayout["+i+"]/android.widget.CheckBox")).click();
				break;

			}
		}
	}
	public void enter_Amount(String value) {
		waitForVisibility(amount);
		sendKeys(amount, value);
	}

	public void enter_dosage(String value) {
		waitForVisibility(dosage);
		sendKeys(dosage, value);
	}


	public void click_Save() {
		waitForVisibility(save_button);
		click(save_button);
	}
	
	public void addVaccination(Map data,String date) { 
		
		/** Fill Vaccination Form */
		select_vaccination((String) data.get("vaccine"));
		enter_dosage((String) data.get("dosage"));
		enter_Amount((String) data.get("amount"));
		enter_vaccinationDate(date);
		click_Save();
		waitForPageLoad();
		
		Health_SuccessPage msg = new Health_SuccessPage();
		msg.assertSuccessMsg("Vaccination");
		msg.goToView();
	}

}
