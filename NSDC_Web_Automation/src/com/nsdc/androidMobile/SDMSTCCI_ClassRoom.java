package com.nsdc.androidMobile;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SDMSTCCI_ClassRoom  {
	 AndroidDriver<AndroidElement> driver;
	
	public SDMSTCCI_ClassRoom(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void CameraClick()
	{
		driver.findElementByXPath("//*[@text='Capture Image']").click();//allow
		driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.transsion.camera:id/shutter_button']").click();//shutter button
		driver.findElementById("com.transsion.camera:id/done_button").click();
	}
	
	
	public void RunClassRoom() throws MalformedURLException, InterruptedException {
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='ClassRoom Details']").click();
		driver.findElementByXPath("//*[@text='arrow forward']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_1']").click();//camera
		driver.findElementByXPath("//*[@text='Capture Image']").click();//allow
		
		if (driver.findElementByXPath("//*[@text='ALLOW']").isDisplayed())
		{
			driver.findElementByXPath("//*[@text='ALLOW']").click();
		}
			
		driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.transsion.camera:id/shutter_button']").click();//shutter button
		driver.findElementById("com.transsion.camera:id/done_button").click();
		
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_2']").click();//camera
		SDMSTCCI_ClassRoom cr=new SDMSTCCI_ClassRoom(driver);
		cr.CameraClick();
		
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@text='SUBMIT']").click();
	String str=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
	Assert.assertEquals(str, "Successfully Uploaded.");
	
		driver.findElementByXPath("//*[@text='OK']").click();
		
		driver.findElementByXPath("//*[@text='arrow back']").click();//

// ********************************* Laboratory Details ************************************************
		
		}
	
}
