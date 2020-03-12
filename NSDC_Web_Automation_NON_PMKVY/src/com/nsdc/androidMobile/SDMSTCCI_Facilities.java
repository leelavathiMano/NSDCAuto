package com.nsdc.androidMobile;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SDMSTCCI_Facilities extends Android {
	 AndroidDriver<AndroidElement> driver;
	
	public SDMSTCCI_Facilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void RunFacilities() throws MalformedURLException, InterruptedException {
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='Facilities']").click();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='First Aid Kit']").click();//camera
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='Capture Image']").click();//allow
		if (driver.findElementByXPath("//*[@text='ALLOW']").isDisplayed())
		{
			driver.findElementByXPath("//*[@text='ALLOW']").click();
		}
			
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.transsion.camera:id/shutter_button']").click();//shutter button
		Thread.sleep(1000);
		driver.findElementById("com.transsion.camera:id/done_button").click();
		
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Fire Fighting Equipment']").click();//camera
		SDMSTCCI_ClassRoom cr=new SDMSTCCI_ClassRoom(driver);
		cr.CameraClick();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Safe Drinking water (Eg. Water purifier)']").click();//camera
		cr.CameraClick();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Differently/specially abled washroom\"))"));
		
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Daily Inspection Card/checklist in Washroom']").click();//camera
		cr.CameraClick();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Differently/specially abled washroom']").click();//camera
		cr.CameraClick();
		driver.findElementById("com.transsion.camera:id/done_button").click();
		driver.findElementByXPath("//*[@text='SUBMIT']").click();
		String str=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
		Assert.assertEquals(str, "Successfully Uploaded.");
		
			driver.findElementByXPath("//*[@text='OK']").click();
			
			driver.findElementByXPath("//*[@text='arrow back']").click();
		
		
		
		
	}

}
