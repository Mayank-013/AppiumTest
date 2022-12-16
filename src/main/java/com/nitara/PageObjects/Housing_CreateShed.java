package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;

import org.testng.Assert;

import com.nitara.Helper.GenerateRandomData;
import io.appium.java_client.android.AndroidElement;

public class Housing_CreateShed extends BasePage {
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnHousing.*\"))") 
	private MobileElement housing;
	
	@AndroidFindBy(id = "btnSave") 
	private MobileElement Savebtn;	
	
	@AndroidFindBy(id ="mainArea")
	private MobileElement clickaddedgroup;
	
	public void Clickgroup() throws InterruptedException
	{
		waitVisibility(clickaddedgroup);
		click(clickaddedgroup);

	}	
	
	@AndroidFindBy(id = "isChecked") 
	private MobileElement groupcheckbox;
	
	@AndroidFindBy(id = "icnAdd") 
	private MobileElement AddShed;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"HOUSING"+ "\"))")  
	private MobileElement housingbtn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"Enter here"+ "\"))")  
	private MobileElement group_name;

	@AndroidFindBy(id = "shedName") 
	private MobileElement entershedname;
	
	//WebElement e = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.TextView")); 
	
	@AndroidFindBy(id = "next_btn") 
	private MobileElement nextbtn;
	
	
	@AndroidFindBy(id = "createSmartShedBtn") 
	private MobileElement clicksmartshed;	
	
	
	@AndroidFindBy(id = "create_my_group") 
	private MobileElement clickuserdefined;
	
	@AndroidFindBy(id = "my_group_name_et") 
	private MobileElement enteruserdefinedgroupname;
	
	@AndroidFindBy(id = "add_more_group_btn") 
	private MobileElement Addmoregroups;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"CREATE MY GROUPS"+ "\"))") 
	private MobileElement createmygroups;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"CREATE SMART SHED"+ "\"))")  
	private MobileElement createsmartshedbtn;
	
	@AndroidFindBy(id = "menu2") 
	private MobileElement deleteshed;
	
	@AndroidFindBy(id = "yesBtn") 
	private MobileElement yesbtn;
	
	@AndroidFindBy(id = "noBtn") 
	private MobileElement nobtn;
	
	@AndroidFindBy(id = "more_option") 
	private MobileElement threedotsicon;	
	
	
	@AndroidFindBy(id = "menu2") 
	private MobileElement Deletegroup;
	
	@AndroidFindBy(id = "menu2") 
	private MobileElement Deleteshed;
	
	@AndroidFindBy(id = "moveCattleBtn") 
	private MobileElement movecattle;	
	

	@AndroidFindBy(id = "move_cattle_btn") 
	private MobileElement movecattleoutofgroup;
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement warning_msg;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"Late Milking"+ "\"))") 
	private MobileElement late_milking_group;
	
	public void ClickLateMilkingGroup() throws InterruptedException{
		click(late_milking_group);
	}
	
	public void Clickhousingbtn() throws InterruptedException
	{
		waitVisibility(housingbtn);
		click(housingbtn);
	}
	
	public void ClickSavebtn() throws InterruptedException
	{	
		
		waitVisibility(Savebtn);
			click(Savebtn);
			//tap();
			waitVisibility(Savebtn);
			click(Savebtn);

	}
	
	public void clickmovecattle() throws InterruptedException
	{
		waitVisibility(movecattle);				
		click(movecattle);		

	}
	
	public void clickmovecattleoutofgrp() throws InterruptedException
	{
		waitVisibility(movecattleoutofgroup);				
		click(movecattleoutofgroup);		

	}
	public void clickDeletegroup() throws InterruptedException
	{
		Thread.sleep(5000);
		waitVisibility(Deletegroup);				
		click(Deletegroup);		

	}
	public void clickDeleteshed() throws InterruptedException
	{
		Thread.sleep(5000);
		waitVisibility(Deleteshed);				
		click(Deleteshed);		

	}	
	
	
	public void clickthreedotsicon() throws InterruptedException
	{
		Thread.sleep(7000);
		//waitVisibility(threedotsicon);				
		click(threedotsicon);		

	}
		
	
	public void deleteshed() throws InterruptedException
	{
		waitVisibility(deleteshed);				
		click(deleteshed);
		
	}
	
	public void clickyesbtn() throws InterruptedException
	{
		waitVisibility(yesbtn);					
		click(yesbtn);	
		Thread.sleep(2000);
	}
	public void ClickAddShedbtn()
	{
		waitVisibility(AddShed);
		click(AddShed);

	}
	
	public void Clickcreatemygroups()
	{
		waitVisibility(createmygroups);
		click(createmygroups);

	}
	
	
	public void entershedname(String shedname)
	{	
				
		waitVisibility(entershedname);
		System.out.println("displayed");
		sendKeys(entershedname,shedname);
		

	}
	
	public String Generateshedname()
	{
		GenerateRandomData numb = new GenerateRandomData();

		 String shedname = numb.generateRandomNumber(7);
		 
		 System.out.println(shedname);
		 
		 return shedname;
	}
	
	public void   entershedname()
	{	
		GenerateRandomData numb = new GenerateRandomData();

		String shedname = numb.generateRandomNumber(7);		
		waitVisibility(entershedname);
		sendKeys(entershedname,shedname);
		

	}
	
	public void  mygroupname(String mygroupname)
	{	
			
		waitVisibility(enteruserdefinedgroupname);
		sendKeys(enteruserdefinedgroupname,mygroupname);
		
		
	}
	
	public void  enteruserdefinedname()
	{	
		GenerateRandomData numb = new GenerateRandomData();

		String mygroupname = numb.generateRandomNumber(7);	
		waitVisibility(enteruserdefinedgroupname);
		sendKeys(enteruserdefinedgroupname,mygroupname);
		
		
	}
	
	public String  entergroupname()
	{	
		GenerateRandomData numb = new GenerateRandomData();

		String mygroupname = numb.generateRandomNumber(7);	
		waitVisibility(enteruserdefinedgroupname);
		sendKeys(enteruserdefinedgroupname,mygroupname);
		
		return mygroupname;
		
		
	}
	
	public void enterNextgroupname(String mygroupname)
	{	
		waitVisibility(group_name);
		sendKeys(group_name,mygroupname);		
		
	}
	
	
	
	public void clicknextbtn()
	{
		waitVisibility(nextbtn);
		click(nextbtn);

	}
	
	public void click_addmoregrpsbtn()
	{
		waitVisibility(Addmoregroups);
		click(Addmoregroups);

	}
	
	public void clickuserdefinedbtn()
	{
		waitVisibility(clickuserdefined);
		click(clickuserdefined);

	}
	
	public void clicksmartshedbtn()
	{
		waitVisibility(clicksmartshed);
		click(clicksmartshed);
		
		
	}
	
	public void clickcreatesmartshedbtn()
	{
		click(createsmartshedbtn);		
		
	}
	
	@SuppressWarnings("unchecked")
	public void Clickcheckbox()
	{
		String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.ImageButton";
		
//		@SuppressWarnings("unchecked")
//		List<AndroidElement> l= (List<AndroidElement>) driver.findElements(By.id("com.nitara.farmer:id/isChecked"));
//		System.out.println(l.size());
//		for(int i=0;i<=3;i++)
//		{
//			
//			l.get(i).click();			
//			
//			
//		}
		
	}

	public void assertWarningMsg(String msg) {
		waitVisibility(warning_msg);
		Assert.assertEquals(warning_msg.getText(),msg);
	}
	
	
}