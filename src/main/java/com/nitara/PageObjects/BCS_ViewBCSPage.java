package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BCS_ViewBCSPage  extends BasePage  {
	
	
	@AndroidFindBy(id = "time_period_cl") 
	private MobileElement time_period;
	
	@AndroidFindBy(id = "no") 
	private MobileElement bcs_score;
	
	@AndroidFindBy(id = "date") 
	private MobileElement bcs_date;
	
	@AndroidFindBy(id = "bcs_slider") 
	private MobileElement Bcs_slider;
	
	@AndroidFindBy(id = "bcs_value_txt") 
	private MobileElement bcsscore;
	
	@AndroidFindBy(id = "more_option") 
	private MobileElement threedotsicon;
	
	@AndroidFindBy(id = "menu1") 
	private MobileElement editbcs_btn;
	
	@AndroidFindBy(id = "menu2") 
	private MobileElement deletebcs_btn;
	
	
	@AndroidFindBy(id = "yesBtn") 
	private MobileElement yesbtn;
	
	@AndroidFindBy(id = "noBtn") 
	private MobileElement nobtn;
	
	public String score;
	
	public void clickthreedotsicon() throws InterruptedException
	{
		//Thread.sleep(7000);
		waitVisibility(threedotsicon);				
		click(threedotsicon);		

	}

	public void clickeditbcs_btn()
	{
		click(editbcs_btn);
	}
	public void clickdelete_btn()
	{
		click(deletebcs_btn);
	}
	
	public void ClickBcs_slider() 
	{
		waitVisibility(Bcs_slider);	
		click(Bcs_slider);
		 score = getText(bcsscore);
	}

	public void clicknobtn()
	{
		click(nobtn);
	}
	
	public void clickyesbtn()
	{
		click(yesbtn);
	}
	
	public void assert_Bcsscore() 
	{	
		String sucscore = bcs_score.getText();
		
		Assert.assertEquals(sucscore,score);
		
		System.out.println(score);
		

	}

	public void select_Timeperiod() {
		waitForPageLoad();
		click(time_period);
		select_dropdown("Last 1 Year");
	}
}
