package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MoveCattle_Successpage extends BasePage



{

@AndroidFindBy(id = "textView34")
private MobileElement housingsuccess;


@AndroidFindBy(id = "goToShed")
private MobileElement gotoshed;


public void Movecattle_Assert() {
Assert.assertEquals(housingsuccess.getText(), "Housing has been changed successfully for");
}

public void Clickgotoshed() throws InterruptedException
{
waitVisibility(gotoshed);
click(gotoshed);



}
}