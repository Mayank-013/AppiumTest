package com.nitara.PageObjects;


import java.util.Map;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Weight_AddWeightPage extends BasePage{
	
	@AndroidFindBy(id = "girthValEt") 
	private MobileElement girth_Et;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*weightBtn.*\"))")  
	private MobileElement weight_btn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*saveBtn.*\"))") 
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "directWeightRdBtn") 
	private MobileElement directWeight_RdBtn;
	
	@AndroidFindBy(id = "cattleByGirthRdBtn") 
	private MobileElement girth_RdBtn;
	
	@AndroidFindBy(id = "lengthValEt") 
	private MobileElement length_Et;
	
	@AndroidFindBy(id = "calculatedWeight") 
	private MobileElement calculatedWeight;

	@AndroidFindBy(id = "weightDate") 
	private MobileElement weightDate;
	

	@AndroidFindBy(id = "weightValue") 
	private MobileElement weight_Et;
	
	@AndroidFindBy(id = "back_button") 
	private MobileElement back_button;
	
	@AndroidFindBy(id = "skip_btn") 
	private MobileElement skip_btn;
	
	public  void click_skipBtn()  
	{
		clickSkipBtn(skip_btn);

	}
	
	public void goBackToCattleList() {
		click(back_button);	
	}
	
	public void select_girthMethod() {
		click(girth_RdBtn);	
	}
	
	public void select_directWeightMethod() {
		waitForPageLoad();
		waitForPageLoad();
		click(directWeight_RdBtn);	
	}
	
	public void enter_girth(String girth) {
		sendKeys(girth_Et,  girth);	
	}
	
	public void enter_length(String length) {
		sendKeys(length_Et, length);	
	}
	
	public void enter_weight(String weight) {
		sendKeys(weight_Et, weight);	
	}
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*home.*\"))") 
	private MobileElement home ;
	
	public void homeButton() {
		waitForVisibility(home);
		click(home);
	}
	
	public String assert_calculatedWeight(String gir, String leng) {

		float girth = Float.parseFloat(gir);
		float length = Float.parseFloat(leng);
		String actualWeight = calculatedWeight.getText().substring(0, calculatedWeight.getText().lastIndexOf(" "));	
		float expectedWeight = (girth* girth * length)/660;
		String exp = String.format("%.2f", expectedWeight);
		Assert.assertEquals(actualWeight,exp);
		return exp;
	}
	
	public void click_saveBtn() {
		click(save_btn);	
	}
	
	public void enter_weightDate(String date) {
		weightDate.clear();
		sendKeys(weightDate, date);	
	}
	
	public String fillAddWeightForm(Map<String,String> data) {
		String expWeight = "";
		waitForPageLoad();
		/** Fill Weight Form */
		if(data.get("calculateBy").equalsIgnoreCase("girth")) {
			enter_girth(data.get("girth"));
			enter_length(data.get("length"));
			expWeight = assert_calculatedWeight(data.get("girth"),data.get("length"));
			enter_weightDate(data.get("Date"));
			click_saveBtn();
		}
		else {
			select_directWeightMethod();
			enter_weight(data.get("weight"));
			expWeight = data.get("weight");
			enter_weightDate(data.get("Date"));
			click_saveBtn();
		}
		return expWeight;
	}
	
}

