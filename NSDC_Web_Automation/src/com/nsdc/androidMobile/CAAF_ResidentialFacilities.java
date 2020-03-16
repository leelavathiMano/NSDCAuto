package com.nsdc.androidMobile;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CAAF_ResidentialFacilities {
	AndroidDriver<AndroidElement> driver;
	public CAAF_ResidentialFacilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void RunResidentialFacilities() throws InterruptedException
	{
		
		driver.findElementByXPath("//*[@text='ResidentialFacilities']").click();
		driver.findElementByXPath("//*[@text='arrow forward']").click();
		Thread.sleep(3000);
		 driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_1']").click();
			driver.findElementByXPath("//android.widget.Button[@text='Capture Image']").click();
			Thread.sleep(3000);
			if (driver.findElementByXPath("//*[@text='ALLOW']").isDisplayed())
			{
				driver.findElementByXPath("//*[@text='ALLOW']").click();
				
			}
			driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.transsion.camera:id/shutter_button']").click();
			driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.transsion.camera:id/done_button']").click();
			Thread.sleep(3000);
			 driver.findElementByXPath("//*[@text='photo2']").click();
			 SDMSTCCI_ClassRoom camera= new SDMSTCCI_ClassRoom(driver);
			 camera.CameraClick();
			 Thread.sleep(3000);
			 driver.findElementByXPath("//*[@text='photo2']").click();
			 camera.CameraClick();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"SUBMIT\"))"));
			 Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='SUBMIT']").click();
		String str=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
		Assert.assertEquals(str, "Successfully Uploaded.");
		driver.findElementByXPath("//*[@text='OK']").click();
//		//women
		driver.findElementByXPath("(//*[@text='arrow forward'])[2]").click();
		 driver.findElementByXPath("//*[@text='photo2']").click();
			driver.findElementByXPath("//android.widget.Button[@text='Capture Image']").click();
			Thread.sleep(3000);
			if (driver.findElementByXPath("//*[@text='ALLOW']").isDisplayed())
			{
				driver.findElementByXPath("//*[@text='ALLOW']").click();
				
			}
			driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.transsion.camera:id/shutter_button']").click();
			driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.transsion.camera:id/done_button']").click();
		 Thread.sleep(3000);
		 driver.findElementByXPath("//*[@text='photo2']").click();
		 camera.CameraClick();
		 Thread.sleep(2000);
		 driver.findElementByXPath("//*[@text='photo2']").click();
		 camera.CameraClick();
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"SUBMIT\"))"));
		 Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='SUBMIT']").click();
			String str1=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
			Assert.assertEquals(str1, "Successfully Uploaded.");
			driver.findElementByXPath("//*[@text='OK']").click();
			driver.findElementByXPath("//*[@text='arrow back']").click();
		 
		 
		 
		}
	
}
