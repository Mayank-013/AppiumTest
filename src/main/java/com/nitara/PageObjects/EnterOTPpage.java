package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterOTPpage extends BasePage{

	@AndroidFindBy(id = "textView4") 
	private MobileElement verificationCode_txt;
	
	@AndroidFindBy(id = "instruction_and_phone") 
	private MobileElement message;
	
	@AndroidFindBy(id = "resent_sms_btn") 
	private MobileElement resent_sms_btn;
	
	@AndroidFindBy(id = "send_otp_call_btn") 
	private MobileElement send_otp_call_btn;

	
	@AndroidFindBy(id = "continue_button") 
	private MobileElement continue_btn;
	
	@AndroidFindBy(id = "otp_txt1") 
	private MobileElement otp_txt1;

	@AndroidFindBy(id = "otp_txt2") 
	private MobileElement otp_txt2;

	@AndroidFindBy(id = "otp_txt3") 
	private MobileElement otp_txt3;

	@AndroidFindBy(id = "otp_txt4") 
	private MobileElement otp_txt4;
	
	public void enter_otp(String otp) {

		waitForPageLoad();
		MobileElement[] arr = {otp_txt1, otp_txt2,otp_txt3,otp_txt4};
		int j =0;
		for (MobileElement i : arr) {
			char c = otp.charAt(j++);
			int digit = c - '0';
			sendKeys(i,digit);	
		}
	}
	
	public void click_ContinueBtn() {
		click(continue_btn);

	}

}
