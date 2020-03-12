package com.nsdc.androidMobile;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SDMSTCCI_Trainer  extends Android {
	AndroidDriver<AndroidElement> driver;
	
	public SDMSTCCI_Trainer(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void RunTrainer() throws MalformedURLException, InterruptedException {
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='Trainers']").click();
		driver.findElementByXPath("//*[@text='arrow forward']").click();
		
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Aadhaar Card']").click();//camera
		driver.findElementByXPath("//*[@text='Capture Image']").click();//allow
		if (driver.findElementByXPath("//*[@text='ALLOW']").isDisplayed())
		{
			driver.findElementByXPath("//*[@text='ALLOW']").click();
		}
			
			
		driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.transsion.camera:id/shutter_button']").click();//shutter button
		driver.findElementById("com.transsion.camera:id/done_button").click();
		
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='SSC certificate']").click();//camera
		SDMSTCCI_ClassRoom cr=new SDMSTCCI_ClassRoom(driver);
		cr.CameraClick();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Minimum qualification certificate\"))"));   
		
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Highest Qualification certificate']").click();//camera
		cr.CameraClick();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='NEISBUD/ Other agency certificate of enterpreneurship']").click();//camera
		cr.CameraClick();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Minimum qualification certificate']").click();//camera
		cr.CameraClick();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Experience certificate\"))"));
		
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Experience certificate']").click();//camera
		cr.CameraClick();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@text='SUBMIT']").click();
	String str=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
	Assert.assertEquals(str, "Successfully Uploaded.");
	
		driver.findElementByXPath("//*[@text='OK']").click();
		
		driver.findElementByXPath("//*[@text='arrow back']").click();
	
	
	}
}
