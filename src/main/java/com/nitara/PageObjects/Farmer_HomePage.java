package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Farmer_HomePage extends BasePage {
	
	@AndroidFindBy(id = "registerCattleBtn") 
	private MobileElement register_cattle_btn;
	
	@AndroidFindBy(id = "home") 
	private MobileElement home_btn;
	
	
	@AndroidFindBy(id = "progress_circle_inner") 
	private MobileElement progress_bar;
	
	@AndroidFindBy(id = "breedRecordingBtn") 
	private MobileElement breedRecording_btn;
	
	@AndroidFindBy(id = "health_btn") 
	private MobileElement health_mgmnt_btn;
	
	@AndroidFindBy(id = "search")
	private MobileElement search_btn;
	
	@AndroidFindBy(id ="cattle_count")
	private MobileElement cattle_count;
	
	@AndroidFindBy(id = "proceedToSetFarmLocationBtn")
	private MobileElement setFarmLocation_Btn;

	@AndroidFindBy(uiAutomator =  "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*weightBtn.*\"))")
	private MobileElement weight_btn;
	
	public void click_WeightButton()
	{	waitUntilElemtTobeClickable(4000,register_cattle_btn);
		click(weight_btn);	
	}

	@AndroidFindBy(uiAutomator =  "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*bcsBtn.*\"))")
	private MobileElement bcs_btn;
	
	@AndroidFindBy(id = "skip_btn") 
	private MobileElement skip_btn;

	@AndroidFindBy(id = "diseasePredictorBtn") 
	private MobileElement diseasePredictor_Btn;
	

	@AndroidFindBy(id ="settings")
	private MobileElement settings;
	
	@AndroidFindBy(id = "milk_recording_btn") 
	private MobileElement milk_recording_btn;

	
	public  void clickskip_btn()  
	{
		try
		{		
			click(skip_btn);
		}
		catch(Exception e)
		{
			System.out.println("Not Displayed");
		}
		
		
	}	

	public void click_RegisterCattleButton()
	{	
		click(register_cattle_btn);	
		
	}
	
	
	public void click_DiseasePredictorButton()
	{	waitUntilElemtTobeClickable(4000,diseasePredictor_Btn);
		click(diseasePredictor_Btn);	
	}
	
	public void click_BreedRecordingButton()
	{	waitForVisibility( breedRecording_btn);
		click( breedRecording_btn);	
	}
	public void click_HomeButton()
	{	waitForVisibility( home_btn);
		click(home_btn);	
	}
	public void click_HealthManagementButton()
	{	waitForVisibility(health_mgmnt_btn);
		click(health_mgmnt_btn);	
	}

	public void click_SearchCattleBtn() {
		waitForVisibility(search_btn);
		click(search_btn);
	}
	
	public void click_BCSButton() {
		waitForVisibility(bcs_btn);
		click(bcs_btn);
	}
	
	public void assert_farmerHomePage() {
		waitForVisibility(cattle_count);
		}
	
	public void assert_farmerHomePageAfterSignUp() {
	Assert.assertEquals(true, setFarmLocation_Btn.isDisplayed());
	}
	
	public void click_SettingsButton()
	{	waitForVisibility(settings);
		click(settings);	
	}
	
	public void click_MilkRecordingButton()
	{
		click(milk_recording_btn);	
	}
	
	
	

}
