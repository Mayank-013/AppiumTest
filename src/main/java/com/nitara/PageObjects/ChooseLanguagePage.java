package com.nitara.PageObjects;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChooseLanguagePage extends BasePage{
	
	
	@AndroidFindBy(id = "skip_btn") 
	private MobileElement skip_btn;
	
	public void select_Language(String language) {
//		String[] lang = {"ENGLISH","GUJARATI","MARATHI","HINDI"};
//		List<MobileElement> langOptions = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
//		for(int i=0;i<langOptions.size();i++) {
//			if(language.toUpperCase().contentEquals(lang[i])) {
//				langOptions.get(i).click();
//				break;} }
		
		MobileElement ele = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView"));
		ele.click();
	
	}
		
		public void click_skipBtn() {
			click(skip_btn);	
		}
				
				
		
	

}
