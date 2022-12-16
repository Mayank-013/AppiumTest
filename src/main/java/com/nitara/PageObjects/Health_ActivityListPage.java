package com.nitara.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

@SuppressWarnings("unchecked")
public class Health_ActivityListPage extends BasePage{

	@AndroidFindBy(id = "phone_number") 
	private MobileElement phone_number;

	@AndroidFindBy(id = "svHealth") 
	private MobileElement health;


	public void assert_farmerPhone(String phone) {
		waitVisibility(phone_number);
		Assert.assertEquals(phone_number.getText(), "+91-"+phone);

	}

	public void select_activity(String activity) {
		List<MobileElement> actList = (List<MobileElement>) driver.findElementsById("title");//{ "Vaccination" , "Deworming" , "Treatment"};
		List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsById("container");
		for(int i=0;i<actList.size();i++) {
			if(activity.contentEquals(actList.get(i).getText())) {
				elementsOne.get(i).click();
				break;} }
	}

	public void select_deworming() {
		List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsById("com.nitara.farmer:id/container");
		elementsOne.get(1).click();
	}

	public void select_vaccination() {
		List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsById("com.nitara.farmer:id/container");
		elementsOne.get(0).click();
	}

	public void select_dewormer(String dewormer) {
		String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/";

		for(int i=1;i<6;i++) {
			WebElement dewormers = driver.findElement(By.xpath(xpath+"android.widget.FrameLayout["+i+"]/android.widget.TextView"));
			if(dewormers.getText().equalsIgnoreCase(dewormer)) {
				driver.findElement(By.xpath(xpath+"android.widget.FrameLayout["+i+"]/android.widget.CheckBox")).click();
				break;
			}
		}
	}
	

}
