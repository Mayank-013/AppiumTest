package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Zomato extends BasePage{

	@AndroidFindBy(id = "fw_mobile_edit_text") 
	private MobileElement Number;
	
	@AndroidFindBy(id = "send_otp_button") 
	private MobileElement send_otp;
	
	@AndroidFindBy(id = "resendButton") 
	private MobileElement resendButton;
	
	@AndroidFindBy(id = "left_icon") 
	private MobileElement backButton;
	
	
	
	public void enter_Number(String number) {
		sendKeys(Number, number);
		
	}
	
	public void click_sendOTP() {
		click(send_otp);
	}
	
	public void click_backButton() {
		click(backButton);
	}
	
	public void click_resendOTP() {
		click(resendButton);
	}
	

}
