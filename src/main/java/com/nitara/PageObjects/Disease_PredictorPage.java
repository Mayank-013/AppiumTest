package com.nitara.PageObjects;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Disease_PredictorPage extends BasePage{
	
	@AndroidFindBy(id = "select_cattle_tv") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id = "skip_btn") 
	private MobileElement skip_btn;
	
	@AndroidFindBy(id = "ivHead") 
	private MobileElement head_btn;
	
	
	@AndroidFindBy(id = "skinBtn") 
	private MobileElement skin_btn;
	
	@AndroidFindBy(id = "breedingBtn") 
	private MobileElement breeding_btn;
	
	@AndroidFindBy(xpath = "//div[text='Ears']") 
	private MobileElement Ear_btn;
	
	@AndroidFindBy(xpath = "//div[text='Nose and Mouth']") 
	private MobileElement Noseandmouth_btn;
	
	@AndroidFindBy(xpath = "//div[text='Eyes']") 
	private MobileElement eye_btn;
	
	@AndroidFindBy(xpath = "//div[text='Horns']") 
	private MobileElement horns_btn;
	
	@AndroidFindBy(id = "addSymptomsBtn") 
	private MobileElement addsymptoms_btn;
	
	@AndroidFindBy(id = "close_btn") 
	private MobileElement closepop_btn;	

	
	@AndroidFindBy(id = "checkBox") 
	private MobileElement checkbox;
	
	@AndroidFindBy(id = "next_btn") 
	private MobileElement next_btn;
	
	
	@AndroidFindBy(id = "StoppedEatingToggleButton") 
	private MobileElement eating_btn;
	

	@AndroidFindBy(id = "feverToggleButton") 
	private MobileElement fever_btn;
	
	@AndroidFindBy(id = "review_btn") 
	private MobileElement review_btn;
	
	@AndroidFindBy(id = "review_btn") 
	private MobileElement GoBackToSymptomList_btn;
	
	@AndroidFindBy(id = "backLL") 
	private MobileElement GoBackToSymptomList2_btn;
	
	
	@AndroidFindBy(id = "analyseBtn") 
	private MobileElement analyse_btn;
	
	@AndroidFindBy(id = "close_btn") 
	private MobileElement arrowdisease_btn;
	
	@AndroidFindBy(id = "reportBtn") 
	private MobileElement report_btn;
	
	@AndroidFindBy(id = "yesBtn") 
	private MobileElement yesbtn;
	
	
	@AndroidFindBy(id = "back_button_title") 
	private MobileElement GoBacktoDiseasePrediction;
	
	@AndroidFindBy(id = "textView51") 
	private MobileElement GoBacktoHomepage;
	
	@AndroidFindBy(id = "back_button") 
	private MobileElement back_button;
		
	public void clickyesbtn()
	{
		click(yesbtn);
	}
	
	public void GoBackToHomepage() throws Throwable
	{	
		click(GoBacktoDiseasePrediction);
		waitVisibility(GoBacktoDiseasePrediction);	
		click(GoBacktoDiseasePrediction);
		waitVisibility(GoBacktoDiseasePrediction);	
		click(GoBacktoDiseasePrediction);
		waitVisibility(GoBackToSymptomList2_btn);	
		click(GoBackToSymptomList2_btn);
		waitVisibility(GoBacktoDiseasePrediction);	
		click(GoBacktoDiseasePrediction);		
		waitVisibility(GoBacktoHomepage);	
		click(GoBacktoHomepage);
		
	}
	
	
	public void Clickhead_btn() 
	{
		waitVisibility(head_btn);	
		click(head_btn);	
	}
	
	public void Clickskin_btn() 
	{
		waitVisibility(skin_btn);	
		click(skin_btn);	
	}
	public void ClickEar_btn() 
	{
		waitVisibility(Ear_btn);	
		click(Ear_btn);
		Clickcheckbox();
		click(addsymptoms_btn);
		
		}
	public void ClickNoseandmouth_btn() 
	{
		waitVisibility(Noseandmouth_btn);	
		click(Noseandmouth_btn);
		Clickcheckbox();
		click(addsymptoms_btn);
		
		
	}
	
	public void AddSymptoms()
	{	
		
	//	Clickhead_btn();
	//	waitVisibility(Ear_btn);
		waitVisibility(skin_btn);
		click(skin_btn);
		Clickcheckbox();
		click(addsymptoms_btn);
		
	//	click(Ear_btn);
	//	Clickcheckbox();
		waitVisibility(breeding_btn);
	//	click(breeding_btn);
	//	Clickcheckbox();
	//	click(addsymptoms_btn);
	/*	waitVisibility(Noseandmouth_btn);	
		click(Noseandmouth_btn);
		Clickcheckbox();
		click(addsymptoms_btn);
		waitVisibility(eye_btn);	
		click(eye_btn);	
		Clickcheckbox();
		click(addsymptoms_btn);
		waitVisibility(horns_btn);	
		click(horns_btn);
		Clickcheckbox();
		click(addsymptoms_btn);*/
		Clicknext_btn() ;
		Clicktoggle_btn();
		ReportDisease();
		
	}
	public void ReportDisease() 
	{
		waitVisibility(review_btn);	
		click(review_btn);	
		waitVisibility(analyse_btn);	
		click(analyse_btn);	
		waitVisibility(arrowdisease_btn);	
		click(arrowdisease_btn);	
		waitVisibility(report_btn);	
		click(report_btn);
		waitVisibility(yesbtn);	
		click(yesbtn);
		
	}
	
	
	public void Clickeye_btn() 
	{
		waitVisibility(eye_btn);	
		click(eye_btn);	
		Clickcheckbox();
		click(addsymptoms_btn);
	
	}
	public void Clickhorns_btn() 
	{
		waitVisibility(horns_btn);	
		click(horns_btn);
		Clickcheckbox();
		click(addsymptoms_btn);
		Clickreview_btn();
		
		
	}
	public void Clickcheckbox() 
	{
		waitVisibility(checkbox);	
		//click(checkbox);
		
			//String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.ImageButton";
			
			@SuppressWarnings("unchecked")
			List<AndroidElement> l= (List<AndroidElement>) driver.findElements(By.id("checkBox"));
			for(int i=0;i<=2;i++)
			{
				
				l.get(i).click();
				
			}
			
		}
	
	public void Clickaddsymptoms_btn() 
	{
		waitVisibility(addsymptoms_btn);	
		click(addsymptoms_btn);	
	}
	public void Clickclosepopup_btn() 
	{
		waitVisibility(closepop_btn);	
		click(closepop_btn);	
	}
	public void Clicknext_btn() 
	{
		waitVisibility(next_btn);	
		click(next_btn);	
	}
	public void Clicktoggle_btn() 
	{
		waitVisibility(eating_btn);	
		click(eating_btn);	
		click(fever_btn);
	}
	public void Clickreview_btn() 
	{
		waitVisibility(review_btn);	
		click(review_btn);	
	}
	
	
	public  void click_skipBtn()  
	{
		clickSkipBtn(skip_btn);

	}
	
	public void goBackToCattleList() {
		click(back_button);	
	}




}
