package com.nitara.PageObjects;

import java.util.List;

import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Milking_ViewCattleMilkingPage extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/addCattleMilkingData") 
	private MobileElement addCattleMilking_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/averageYieldTv") 
	private MobileElement averageYield;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/milk_producedVal") 
	private MobileElement milkProduced;
	
	@AndroidFindBy(id ="com.nitara.farmer:id/milkRecordedVal") 
	private MobileElement milkRecordedDays;
	

	public void click_AddCattleMilkingData() {
		click(addCattleMilking_btn);
	}
	
	public void validate_milkProduced(String previousMilkProduced, String yield){
	Assert.assertEquals(milkProduced.getText(),String.format("%.2f",Float.parseFloat(previousMilkProduced)+Float.parseFloat(yield)));	
	}
	
	public void validate_averageYield() {
		
		float expectedAverageYield = Integer.parseInt(milkProduced.getText())/Integer.parseInt(milkRecordedDays.getText());
		Assert.assertEquals(averageYield.getText(),String.format("%.2f",expectedAverageYield));
	}
	
	public void assert_cattleMilkingData() {
		List<MobileElement> data = (List<MobileElement>) driver.findElementsById("com.nitara.farmer:id/litre_oneFirst");
		for(int i=0;i<data.size()-1 ;i++ ) {
			if(data.get(i).getAttribute("checked").equals("true")) {
				data.get(i).click();	
			}

		}

	}
	

}
