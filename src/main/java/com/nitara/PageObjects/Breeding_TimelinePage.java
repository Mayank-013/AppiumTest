package com.nitara.PageObjects;

import java.util.List;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Breeding_TimelinePage extends BasePage{

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnAddActivity.*\"))")
	private MobileElement addActivity_Btn;
	
	@AndroidFindBy(id = "heatCardView")
	private MobileElement heat_btn;
	
	@AndroidFindBy(id = "naturalBtn")
	private MobileElement natural_btn;
	
	@AndroidFindBy(id = "heat_date")
	private MobileElement heat_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveBtn.*\"))") 
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "l2value")
	private MobileElement breedingStatus;
	
	@AndroidFindBy(id ="tvDateLeft")
	private MobileElement checkDateLeft;
	
	@AndroidFindBy(id ="tvDateRight")
	private MobileElement checkDateRight;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[1]")
	private MobileElement heatTyData;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[2]")
	private MobileElement recordedData;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*tvTotalDaysLeft.*\"))") 
	private MobileElement totalDaysLeft;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnRemoveLeft.*\"))") 
	private MobileElement deleteBtnLeft ;
	
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement popup_Yes;
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement deleteMsg;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnEditLeft.*\"))") 
	private MobileElement editBtnLeft ;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnEditRight.*\"))") 
	private MobileElement editBtnRight ;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*btnRemoveRight.*\"))") 
	private MobileElement deleteBtnRight ;
	
	
	
	public void click_AddActivity() throws Exception {
		click(addActivity_Btn);
	}
	
	
    public void check_breedingStatus(String status) throws Exception {

    	waitVisibility(breedingStatus);
    	Assert.assertEquals(breedingStatus.getText(),status);
    }
    
    public void checkDateLeft(String cdate) throws Exception {
    	waitVisibility(checkDateLeft);
    	Assert.assertEquals(checkDateLeft.getText(),cdate);
    }
    
    public void checkDateRight(String cdate) throws Exception {
    	Thread.sleep(3000);
    	waitVisibility(checkDateRight);
    	Assert.assertEquals(checkDateRight.getText(),cdate);
    }
	
    public void check_HeatType(String type) {
		List<MobileElement> List = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		Assert.assertEquals(List.get(16).getText(), type);
	}
    
	   public void press_DeleteBtnLeft() throws Exception {
		   deleteBtnLeft.getText();
	    	click(deleteBtnLeft);
	    }
	   
	   public void press_deleteBtnRight() throws Exception {
		   deleteBtnRight.getText();
	    	click(deleteBtnRight);
	    }
	   
	   public void press_editBtnLeft() throws Exception {
		   editBtnLeft.getText();
		   click(editBtnLeft);
	    }
	   
	   public void press_editBtnRight() throws Exception {
		   editBtnRight.getText();
		   click(editBtnRight);
	    }
	   
	   public void press_YesBtn() throws Exception {
	    	waitVisibility(popup_Yes);
	    	click(popup_Yes);
	    }
	   public void assertDeleteMsg(String activity, String date) {
		   waitVisibility(deleteMsg);
		   Assert.assertEquals(deleteMsg.getText(),activity+" data recorded on "+date+" has been deleted");
	   }

	public void getId() {
		// TODO Auto-generated method stub
		addActivity_Btn.getText();
		List<MobileElement> List = (List<MobileElement>) driver.findElementsById("tvTitleRight");
		for(int i=0;i<List.size() ;i++ ) {
			System.out.println(List.get(i).getText());
		}
		
		System.out.println();System.out.println();System.out.println();
		List<MobileElement> List1 = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		for(int i=0;i<List1.size()-1 ;i++ ) {
			System.out.println(List1.get(i).getText());
		}
	}
	
	public void verify_Insemination(String type, String date) {
		List<MobileElement> List = (List<MobileElement>) driver.findElementsById("tvTitleLeft");
		Assert.assertEquals(List.get(0).getText(),"HEAT");
		Assert.assertEquals(List.get(1).getText(),"INSEMINATION");
		List<MobileElement> List1 = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		
	}
	
	
	public void verify_PD(String status, String date) {
		addActivity_Btn.getText();
		List<MobileElement> List = (List<MobileElement>) driver.findElementsById("tvTitleRight");
		Assert.assertEquals(List.get(0).getText(),"PD");
		List<MobileElement> List1 = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
//		if(status.equalsIgnoreCase("true")) {
//			Assert.assertEquals(List1.get(22).getText(),"Pregnant");
//		}
//		else {
//			Assert.assertEquals(List1.get(22).getText(),"Not Pregnant");
//		}
//		Assert.assertEquals(List1.get(21).getText(),"Physical");
//		Assert.assertEquals(List1.get(19).getText(),date);

		
	}
	
	public void assert_HeatEntry() {
		Assert.assertEquals(heat_btn.getText(),"HEAT");	
	}
    
 
}
