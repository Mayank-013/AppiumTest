package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChangeHousing  extends BasePage
{
	

	@AndroidFindBy(id = "textView34") 
	private MobileElement changehousingsuccess;
	
	String success ="Housing has been changed successfully for";
	
	@AndroidFindBy(id  = "farmAnalysisBtn") 
	private MobileElement FarmAnalysis;
	
	@AndroidFindBy(id  = "goToShed") 
	private MobileElement gotofarmanalysis;
	

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"changeHouseCount"+ "\"))")  
	private MobileElement housingchangebtn;
	
	
	@AndroidFindBy(id  = "cattle_move_switch") 
	private MobileElement movecattlebtn;
	
	@AndroidFindBy(id  = "save_btn") 
	private MobileElement savebtn;
	
	public void ClickFarmanalysis() throws InterruptedException
	{
		waitVisibility(FarmAnalysis);
		click(FarmAnalysis);

	}
	
	public void Clickhousingchange() throws InterruptedException
	{
		waitVisibility(housingchangebtn);
		click(housingchangebtn);

	}
	
	public void ClickSave() throws InterruptedException
	{
		waitVisibility(savebtn);
		click(savebtn);

	}
	
	public void ChangeHousing_Assert() 
	{
		Assert.assertEquals(changehousingsuccess.getText(), "Housing has been changed successfully for");
	}
	
	public void Clicmovecattle() throws InterruptedException
	{
		waitVisibility(movecattlebtn);
		
		for(;;)
		{
			
			if(movecattlebtn.isDisplayed())
			{
				click(movecattlebtn);
				break;
				
			}
			
		}
		

	}
	
	
	
	
	
}	
	