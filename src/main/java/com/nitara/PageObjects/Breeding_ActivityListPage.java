package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_ActivityListPage extends BasePage{
	
	@AndroidFindBy(id = "heatCardView") 
	private MobileElement heat;
	
	@AndroidFindBy(id = "artificial_insemination") 
	private MobileElement artificial_insemination;
	
	@AndroidFindBy(id = "skip_btn") 
	private MobileElement skip_btn;
	
	@AndroidFindBy(id = "backBtnText") 
	private MobileElement backBtnText;
	
	@AndroidFindBy(id = "natural_insemination") 
	private MobileElement natural_insemination;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*pdCardView.*\"))")  
	private MobileElement pd;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*calvingCardView.*\"))")  
	private MobileElement calving;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*dryCardView.*\"))")  
	private MobileElement dryPeriod;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\".*backBtnText.*\"))")  
	private MobileElement backToCattleList;
	
	
	public void select_pd() throws Exception {
		pd.click();
	}
	
	public void select_ArtificialInsemination() throws Exception{
		artificial_insemination.click();
	}
	
	
	public void select_NaturalInsemination() throws Exception {
		natural_insemination.click();
	}
	
	public void select_heat() throws Exception {
		click(heat);
	}
	
	

	public void select_Calving() throws Exception {
		click(calving);
	}
	
	

	public void select_DryPeriod() throws Exception {
		click(dryPeriod);
	}
	
	
	public void select_Activity(String activity) {
		
		waitForPageLoad();
		if(activity.equalsIgnoreCase("heat")) 
			click(heat);
		else if(activity.equalsIgnoreCase("artificialInsemination"))
			click(artificial_insemination);
		else if(activity.equalsIgnoreCase("naturalInsemination"))
			click(natural_insemination);
		else if(activity.equalsIgnoreCase("dryPeriod"))
			click(dryPeriod);
		else if(activity.equalsIgnoreCase("pd"))
			click(pd);
		else if(activity.equalsIgnoreCase("calving"))
			click(calving);
	}
	
	public void click_skipBtn() {
		click(skip_btn);	
	}
	
	public void goBackToCattleList() {
		click(backBtnText);	
	}
	

}
