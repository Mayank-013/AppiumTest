package com.nitara.PageObjects;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nitara.Helper.GenerateRandomData;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Weight_ViewPage extends BasePage{
	
	@AndroidFindBy(id = "addWeightData") 
	private MobileElement addWeight;
	
	@AndroidFindBy(id = "date") 
	private MobileElement weightDate;
	
	@AndroidFindBy(id = "weight") 
	private MobileElement weight;
	
	@AndroidFindBy(id = "girthmenthod") 
	private MobileElement method;
	
	@AndroidFindBy(id = "viewMoreTV") 
	private MobileElement viewMore;
	
	@AndroidFindBy(id = "girth") 
	private MobileElement girthValue;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*length.*\"))")  
	private MobileElement lengthValue;
	
	@AndroidFindBy(id = "more_option") 
	private MobileElement options;
	
	@AndroidFindBy(id = "menu1") 
	private MobileElement editoption;
	
	@AndroidFindBy(id = "menu2") 
	private MobileElement deleteoption;
	
	@AndroidFindBy(id = "yesBtn") 
	private MobileElement yesBtn;
	
	@AndroidFindBy(id = "noBtn") 
	private MobileElement noBtn;
	
	@AndroidFindBy(id = "textView1") 
	private MobileElement deleteSuccessMsg;
	
	@AndroidFindBy(id = "skip_btn") 
	private MobileElement skip_btn;
	
	public void assert_deleteSuccessMsg(String date) {
		Assert.assertEquals(deleteSuccessMsg.getText(),"Weight data recorded on "+date+" has been deleted");
	}

	public void click_deleteYesOption() {
		click(yesBtn);	
	}
	
	public void click_editOption() {
		click(editoption);	
	}
	
	public void click_deleteOption() {
		click(deleteoption);	
	}
	
	public void click_skipBtn() {
		click(skip_btn);	
	}
		
	public void click_addWeight() {
		waitForPageLoad();
		click(addWeight);
	}
	
	public void click_moreOptions() {
		click(options);	
	}
	
	public void assert_weightDate(String date) {
		Assert.assertEquals(weightDate.getText(),date);
	}
	
	
	public void assert_weight(String weightData) {
		float wt = Float.parseFloat(weightData);
		String expected = String.format("%.2f", wt);
		Assert.assertEquals(weight.getText(),expected+" KG");
	}
	
	public void assert_method(String methodType) {
		if(methodType.equalsIgnoreCase("Direct"))
		Assert.assertEquals(method.getText(),"Direct Method");
		else
			Assert.assertEquals(method.getText(),"Girth Method");	
	}
	
	public void assert_girthAndLengthData(String girth, String length) {
		float value = Float.parseFloat(girth);
		String expected = String.format("%.1f", value);
		Assert.assertEquals(girthValue.getText(),expected+" in (inches)");
		value = Float.parseFloat(length);
		expected = String.format("%.1f", value);
		//Assert.assertEquals(lengthValue.getText(),expected+" in (inches)");
		
	}
	
	public void assert_girthMethodDetails(Map<String,String> data, String weightData){
		assert_weightDate(new GenerateRandomData().getPastDate(0));
		assert_weight(weightData);
		Assert.assertEquals(method.getText(),"Girth Method");
		click(viewMore);
		assert_girthAndLengthData(data.get("girth"), data.get("length"));	
	}
	
	public void assert_directMethodDetails(Map<String,String> data, String weightData){
		assert_weightDate(new GenerateRandomData().getPastDate(0));
		assert_weight(weightData);
		Assert.assertEquals(method.getText(),"Direct Weight");	
	}
	
	

	
}
