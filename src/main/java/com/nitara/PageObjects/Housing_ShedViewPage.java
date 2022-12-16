package com.nitara.PageObjects;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nitara.Helper.GenerateRandomData;
import com.nitara.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Housing_ShedViewPage extends BasePage 

{ 
	
	@AndroidFindBy(id = "shed") 
	private MobileElement nameofshed;
		
	
	@AndroidFindBy(id = "mainArea") 
	private MobileElement group;
	
	@AndroidFindBy(id = "addCattleToGroup") 
	private MobileElement Addcattletogroupbtn;
	
	@AndroidFindBy(id = "checkbox") 
	private MobileElement checkbox;
	
	@AndroidFindBy(id = "chkSelectAll") 
	private MobileElement selectallcheckbox;
	
	
	@AndroidFindBy(id = "continueBtn") 
	private MobileElement addtogroupbtn;	

	
	@AndroidFindBy(id = "moveRight") 
	private MobileElement moverightarrow;
	
	@AndroidFindBy(id = "moveRight") 
	private MobileElement moveleftarrow;
	
	@AndroidFindBy(id = "arrow_btn") 
	private MobileElement downarrow;
	
	@AndroidFindBy(id = "screenshot") 
	private MobileElement page;
	
	@AndroidFindBy(id = "btnSave") 
	private MobileElement Savebtn;	
	
	@AndroidFindBy(id = "goToShed") 
	private MobileElement gotoshedbtn;
	
	@AndroidFindBy(id = "backBtnTxt") 
	private MobileElement gobackbtn;
	
	@AndroidFindBy(id = "backButtonText") 
	private MobileElement gobacktoshedview;
	
	@AndroidFindBy(id = "search_cattle_in_group") 
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement warning_msg;
	
	@AndroidFindBy(id = "allCattleAssignedTxt")
	private MobileElement display_msg;
	
	@AndroidFindBy(id = "chkSelectAll")
	private MobileElement chkSelectAll;
	
	@AndroidFindBy(id = "more_option")
	private MobileElement more_option;
	
	@AndroidFindBy(id = "menu2")
	private MobileElement deletegrpbtn;
	
	@AndroidFindBy(id = "textView1")
	private MobileElement deletegrp_warningmsg;
	
	@AndroidFindBy(id = "yesBtn")
	private MobileElement yesBtn;
	
	@AndroidFindBy(id = "group_name_txt")
	private MobileElement group_name_txt;
	
	@AndroidFindBy(id = "addIcon")
	private MobileElement addGrp;
	
	@AndroidFindBy(id = "my_group_name_et")
	private MobileElement my_group_name_et;
	
	@AndroidFindBy(id = "add_groups_btn")
	private MobileElement add_groups_btn;
	
	@AndroidFindBy(id = "txtMoveOut")
	private MobileElement deletegrpwithCattle_warningmsg;
	
	@AndroidFindBy(id = "move_cattle_btn")
	private MobileElement move_cattle_btn;
	
	@AndroidFindBy(id = "shed_no")
	private MobileElement shed_no;
	
	@AndroidFindBy(id = "cattle_no")
	private MobileElement cattle_no;
	
	@AndroidFindBy(id = "groups_no")
	private MobileElement groups_no;
	
	@AndroidFindBy(id = "txtValues")
	private MobileElement cattlecountInGrp;
	
	@AndroidFindBy(id = "android:id/text1")
	private MobileElement selectAShed;
	
	@AndroidFindBy(id = "moveCattleBtn")
	private MobileElement move_cattle_btn2;
	
	@AndroidFindBy(id = "deleteBtn")
	private MobileElement deleteBtn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"Open and Milking"+ "\"))") 
	private MobileElement open_milking_group;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"Early Milking"+ "\"))") 
	private MobileElement early_milking_group;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"ADD GROUP"+ "\"))") 
	private MobileElement AddGrpToSmartShedBtn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"WARNING"+ "\"))") 
	private MobileElement warning_for_movingcattle;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"WARNING RESOLVED"+ "\"))") 
	private MobileElement warning_resolved;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().text(\"" +"Late Milking"+ "\"))") 
	private MobileElement late_milking_group;
	
	public void movecattle(String shedname) throws InterruptedException {
		click(move_cattle_btn2);
		click(selectAShed);
		driver.findElementByAndroidUIAutomator("new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
				+ "new UiSelector().text(\"" +shedname+ "\"))").click();
		click(Savebtn);
	}

	
	public void deleteAllExceptLastShed() throws InterruptedException {
		//this function deletes all sheds except last one
		
		/** logic: check if there is more than one shed
		 *  if no then its the last shed so do nothing here
		 *  if yes then we have to delete it
		 *  so check if the shed has cattle
		 *  if no then delete shed directly
		 *  if yes then move the cattle out
		 *  if we r moving to smart shed then there might be conflict so warning may popup. In that case touch on the sceen and click sav btn.
		**/
		
		while(! shed_no.getText().equals("1/1 ")) {
			
			String number_of_cattle;
			
			while(! cattle_no.getText().equals("0")) {
				number_of_cattle=cattlecountInGrp.getText();
				ClickGroup();
				clickonMoreOptions();
				clickonDeleteGrpBtn();
				
				if(! number_of_cattle.equals("0")) {
					click(move_cattle_btn);
					click(Savebtn);
					
					List<WebElement> warning_bar=  (List<WebElement>) driver.findElementsByAndroidUIAutomator("new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("+ "new UiSelector().text(\"" +"WARNING"+ "\"))");
					if(warning_bar.size()>0) {
						TouchAction touchAction = new TouchAction(driver);
				        touchAction.tap(PointOption.point(200, 600)).perform();
				        click(Savebtn);
					}
					
					click(gotoshedbtn);
				}
				else {
					click(yesBtn);
				}
			}
			clickonMoreOptions();
			clickonDeleteGrpBtn(); //delete shed btn has same id as delete grp btn
			clickonyesBtn();
		}
	}
	
	public void deleteLastShed(String warning, String success) throws InterruptedException {
		
		//this function deletes last shed	
		
		String number_of_grps,number_of_cattle;
		String shed=nameofshed.getText();	
		String grp;
		while(! cattle_no.getText().equals("0")) {
			number_of_grps=groups_no.getText();
			number_of_cattle=cattlecountInGrp.getText();
			ClickGroup();
			grp = group_name_txt.getText();
			clickonMoreOptions();
			clickonDeleteGrpBtn();
			if(! number_of_cattle.equals("0")) {
				click(move_cattle_btn);
				if(! number_of_grps.equals("1")) {
					click(Savebtn);
					click(gotoshedbtn);
				}
				else {
					Assert.assertEquals(warning_msg.getText(),success.replace("grp_No", grp));
					Thread.sleep(10000);
					click(gobacktoshedview);
				}
				
			}
			else {
				click(yesBtn);
			}
		}
		ClickGroup();
		grp = group_name_txt.getText();
		clickonMoreOptions();
		clickonDeleteGrpBtn(); 
		assert_deleteGrpWarningMsg(warning,shed,grp);
		clickonyesBtn();
	}
	
	
	public void clickonMoreOptions() {
		click(more_option);
	}
	
	public void clickonDeleteGrpBtn() {
		click(deletegrpbtn);
	}
	
	public void assert_deleteGrpWarningMsg(String msg, String Shedname, String Groupname) {
		msg = msg.replace("shed_No", Shedname);
		msg = msg.replace("grp_No", Groupname);
		Assert.assertEquals(deletegrp_warningmsg.getText(),msg);
	}
	
	public void assert_deleteGrpSuccessMsg(String msg, String Shedname, String Groupname) {
		msg = msg.replace("shed_No", Shedname);
		msg = msg.replace("grp_No", Groupname);
		Assert.assertEquals(warning_msg.getText(),msg);
	}
	
	public void assert_deleteGrpWithCattleWarningMsg(String msg) {
		Assert.assertEquals(deletegrpwithCattle_warningmsg.getText(),msg);
		Assert.assertTrue(move_cattle_btn.isDisplayed());
		
	}
	
	public void clickonyesBtn() {
		click(yesBtn);
	}
	
	public void clickonAddGrpBtn() {
		click(addGrp);
	}
	
	public void EnterGrpName() {
		GenerateRandomData helper = new GenerateRandomData();
		String grpname = helper.generateRandomNumber(7);
		sendKeys(my_group_name_et,grpname);
	}
	
	public void clickonCreateGrp() {
		click(add_groups_btn);
	}
	
	public String getGroupName() {
		return group_name_txt.getText();
	}
	
	public void searchCattle(String tag) {
		sendKeys(search_cattle,tag);
	}
	
	public void Searchshed(String shedname)
	{
		WebElement arrow = moverightarrow;
		for(;;)
		{
				String actshedname =nameofshed.getText();
			
				if(actshedname.equals(shedname))
				{	
					System.out.println("matched");
					break;
					
				}
				else {
					try {
						arrow.click();
					}
					catch(Exception e) {
						arrow = moveleftarrow;
						arrow.click();
					}
				}
				
				
		}
	}
	
	public void Assertshed(String shedname) {
		Assert.assertEquals(nameofshed.getText(), shedname);
	}
	
	
	public void Clickgobackbtn() throws InterruptedException
	{
		
		waitVisibility(gobackbtn);
		click(gobackbtn);

	}
	
	public void ClickSelectallcheckbox() throws InterruptedException
	{
		
		waitVisibility(selectallcheckbox);
		click(selectallcheckbox);

	}
		
	public void Clickgobacktoshed() throws InterruptedException
	{
		
		waitVisibility(gobacktoshedview);
		click(gobacktoshedview);

	}
	
	
	
	
	public void Clickgotoshedbtn() throws InterruptedException
	{
		//Thread.sleep(5000);
		waitVisibility(gotoshedbtn);
		click(gotoshedbtn);

	}
	
	
	public void ClickGroup() throws InterruptedException
	{
		Thread.sleep(5000);
		//waitVisibility(group);
		click(group);

	}
	
	public void ClickAddCattleToGroupBtn() throws InterruptedException
	{
		waitVisibility(Addcattletogroupbtn);
		click(Addcattletogroupbtn);
		
	}
	
	public void ClickCheckbox() throws InterruptedException
	{
		waitVisibility(checkbox);
			click(checkbox);

	}
	public void ClickSavebtn() throws InterruptedException
	{	
		
		waitVisibility(Savebtn);
			click(Savebtn);
			//tap();
			waitVisibility(Savebtn);
			click(Savebtn);

	}
	
	public void ClickAddToGroup() throws InterruptedException
	{
		waitVisibility(addtogroupbtn);
	
		click(addtogroupbtn);
		
	}
	public void ClickAddToGroupBtn() throws InterruptedException
	{
		waitVisibility(addtogroupbtn);
	
		click(addtogroupbtn);
		
		//tap();
		
		if(addtogroupbtn.isDisplayed())
		{
		
		waitVisibility(addtogroupbtn);
		click(addtogroupbtn);
		
		}
		
		
	//	Doubleclick(addtogroupbtn);
	//	click(page);			
			
		
	}
	
	public void assertWarningMsg(String msg) {
		waitVisibility(warning_msg);
		Assert.assertEquals(warning_msg.getText(),msg);
	}
	
	public void AssertCattleAdditionToGroup(String tag) {
		WebElement cattle_tag= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
				".scrollIntoView(new UiSelector().text(\""+tag+"\"))");
		Assert.assertEquals(cattle_tag.getText(), tag);
	}
	
	public void assertMsg(String msg) {
		waitVisibility(display_msg);
		Assert.assertEquals(display_msg.getText(),msg);
	}
	
	public void clickSelectAll() {
		click(chkSelectAll);
	}


	public void clickOpenandMilkingGroup() {
		click(open_milking_group);
	}


	public void clickonAddGrpToSmartShedBtn() {
		click(AddGrpToSmartShedBtn);
	}


	public void clickEarlyMilkingGroup() {
		click(early_milking_group);
	}


	public void Movecattle_Warning() {

		Assert.assertTrue(warning_for_movingcattle.isDisplayed());
	}


	public void resolveWarning() {
		// TODO Auto-generated method stub
		
		//tap by coordinates
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(200, 600)).perform();
        
        click(deleteBtn);
        
        Assert.assertTrue(warning_resolved.isDisplayed());
        
	}


	public void clickOnMoveCattleBtn() {
		click(move_cattle_btn2);
	}


	public void ClickLateMilkingGroup() {
		click(late_milking_group);
	}
		

}
