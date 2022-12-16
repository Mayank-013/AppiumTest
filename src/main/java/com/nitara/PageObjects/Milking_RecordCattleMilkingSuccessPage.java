package com.nitara.PageObjects;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Milking_RecordCattleMilkingSuccessPage extends BasePage{
	
	@AndroidFindBy(id = "eveningMessage") 
	private MobileElement eveningYield;
	
	@AndroidFindBy(id ="afterNoonMessage") 
	private MobileElement noonYield;
	
	@AndroidFindBy(id = "any_msg") 
	private MobileElement totalYield;
	
	@AndroidFindBy(id = "morningMessage") 
	private MobileElement morningYield;//
	
	@AndroidFindBy(id = "record_another_milking") 
	private MobileElement recordAnotherMilking;
	
	public void assertCattleYield(String mrng) {
		assertEquals(morningYield.getText(), "MORNING - "+mrng);
//		assertEquals(noonYield.getText(), "AFTERNOON - "+noon+" KG");
//		assertEquals(eveningYield.getText(), "AFTERNOON - "+evng+" KG");
		assertEquals(totalYield.getText(), "TOTAL YIELD : "+mrng);
		
	}
	
	public void goBackToAddMilkingDataPage(){
		click(recordAnotherMilking);
	}
	
}
