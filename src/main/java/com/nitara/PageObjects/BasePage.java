package com.nitara.PageObjects;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nitara.utils.DriverManager;
import com.nitara.utils.TestUtils;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BasePage {

	public  AndroidDriver<?> driver;
	TestUtils utils = new TestUtils();

	public BasePage() 
	{
		this.driver = (AndroidDriver<?>) new DriverManager().getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	public void setLocation() {
		driver.setLocation(new Location(8.088306,77.7243733, 10));
	}
	
	public void waitForProgressBar(){	
		try {
			List<WebElement> progress_bar=  (List<WebElement>) driver.findElements(By.id("request_in_progress_bar"));
			if(progress_bar.size()>0) {
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.invisibilityOf(progress_bar.get(0)));
			}
						
		} catch (NoSuchElementException e){

		}
		
	}
	
	public void captureScreenshots(String functionality) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("Screenshots/"+functionality+"_Screenshot.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void waitUntilElemtTobeClickable(long timeOut, MobileElement element) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clear(MobileElement e) {
		waitForVisibility(e);
		e.clear();
	}

	public void click(MobileElement e) {
		WebDriverWait w = new WebDriverWait(driver, 1000);
		//w.until((ExpectedCondition<Boolean>) driver ->e.isEnabled());
		e.click();
	}

	public void click(MobileElement e, String msg) {
		waitForVisibility(e);
		// utils.log().info(msg);
		e.click();
	}

	public void Verifyelementexists(MobileElement e , String element) {
		
		
		if(e.getText().equals(element))
		{
			System.out.println(element + " is  displayed");
		}
		
		else
		{
			System.out.println(element + " is not displayed");
		}
		
		System.out.println(e.getText());
		
	}
	public void sendKeys(MobileElement e, int txt) {
		waitForVisibility(e);
		// utils.log().info(msg);
		e.sendKeys(String.valueOf(txt));
	}

	public void sendKeys(MobileElement e, String txt) {
		e.sendKeys(txt);
	}
	
	public void sendKeys(MobileElement e, Keys enter)
	{
		e.sendKeys(Keys.ENTER);
	}
	
	

	public String getAttribute(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	public String getText(MobileElement e) {
		String txt;
		txt = getAttribute(e, "text");
		return txt;
	}


	public void closeApp() {
		((InteractsWithApps) driver).closeApp();
	}

	public void launchApp() {
		((InteractsWithApps) driver).launchApp();
	}


	public boolean find(final MobileElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					if (element.isDisplayed()) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception e) {
			return false;
		}
	}

	public boolean find(final By element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					if (driver.findElement(element).isDisplayed()) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception e) {
			return false;
		}
	}


	public String captureToast() {
		WebDriverWait waitForToast = new WebDriverWait(driver,25);
		waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		String toastMessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
		return toastMessage;
	}

	public void select_dropdown(String value) {
		//driver.findElement(By.xpath("//*[@text='" +value+ "']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+value+"']")).click();
	}


	public void findElement(String text)
	{
				
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")").click();
		
	}

	
	public void scrollfindElement(String myText) {
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\""+myText+"\"))").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
				".scrollIntoView(new UiSelector().textContains(\""+myText+"\"))");
	}
	public void scrollTofindElement(String id) {
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).resourceId(\""+myText+"\"))").click();
		MobileElement el = (MobileElement) driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().resourceIdMatches(\"" +id+ "\"));");
		el.click();
	}

	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	public void implicitWait() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void waitForPageLoad(MobileElement locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
		wait.until(ExpectedConditions.invisibilityOf(locator));
	}
	
	public void waitForPageLoad(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void waitVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void clickSkipBtn(MobileElement ele) {
		
		
		try{
			if(ele.isDisplayed()){
				click(ele);
			     }
		}
			catch (NoSuchElementException e)
			{
			}
		
	}
	
	



}


