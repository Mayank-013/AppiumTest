package com.nitara.PageObjects;

import java.util.Map;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Health_TreatmentSymptomsPage extends BasePage{

	@AndroidFindBy(id = "search_symptom") 
	private MobileElement search_symptom;
	
	@AndroidFindBy(id = "search_btn") 
	private MobileElement search_btn;
	
	@AndroidFindBy(id = "checkBox") 
	private MobileElement select_symptom;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveSymptomsBtn.*\"))") 
	private MobileElement save_btn;
	
	public void click_save() {
		click(save_btn);
		
	}

	public void select_symptoms(String[] symptoms) {
		for(int i=0;i<symptoms.length-1 ;i++ ) {
			sendKeys(search_symptom, symptoms[i]);
			click(search_btn);
			click(select_symptom);
		}
	}
	
	
	public void addSymptoms(Map<String, String> data) {
		
		int count =  Integer.valueOf( data.get("symptomsCount"));
		String[] symptomsList = new String[count];
		for(int i=0;i<count;i++) {
			symptomsList[i]=  data.get("symptoms["+i+"]");
		}
		select_symptoms(symptomsList);
		click_save();
	}
	
	
	
	
	

}
