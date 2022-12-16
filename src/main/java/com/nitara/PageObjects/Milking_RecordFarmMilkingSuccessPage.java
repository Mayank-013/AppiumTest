package com.nitara.PageObjects;

import static org.testng.Assert.assertEquals;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Milking_RecordFarmMilkingSuccessPage extends BasePage{
	
	@AndroidFindBy(id = "any_msg") 
	private MobileElement sessionYield;
	
	@AndroidFindBy(id = "session_msg") 
	private MobileElement session;
	
	public void assertSessionYield(String yield) {
		assertEquals(sessionYield.getText(), "SESSION YIELD IS "+yield+" KG");}
	
	public void assertSession(String sess) {
		assertEquals(session.getText(), "SESSION - "+sess.toUpperCase());}

}
