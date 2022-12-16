package appCommonClasses;

import org.testng.annotations.Test;

public class ZomatoOTP extends GenericBase {
	
	@Test(invocationCount = 1000)
	public void initiateOTP() throws Exception {
		
		zomatoPage.enter_Number(generateRandomData.generateRandomNumber(10)); 
		zomatoPage.click_sendOTP();
		zomatoPage.click_backButton();
	}

}
