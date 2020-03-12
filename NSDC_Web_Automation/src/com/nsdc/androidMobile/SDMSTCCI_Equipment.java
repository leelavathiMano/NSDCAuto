package com.nsdc.androidMobile;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SDMSTCCI_Equipment  {
	 AndroidDriver<AndroidElement> driver;
	
	public SDMSTCCI_Equipment(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void RunEquipment() throws MalformedURLException, InterruptedException {
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='Equipments']").click();
		driver.findElementByXPath("//*[@text='arrow forward']").click();	
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"ADD PHOTOS\"))"));
		
		driver.findElementByXPath("//*[@text='arrow forward']").click();
		
	}
}
