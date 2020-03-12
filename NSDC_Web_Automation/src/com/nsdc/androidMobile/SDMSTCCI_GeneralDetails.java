package com.nsdc.androidMobile;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SDMSTCCI_GeneralDetails  extends Android {
	AndroidDriver<AndroidElement> driver;
	
	public SDMSTCCI_GeneralDetails(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void RunGeneralDetails() throws MalformedURLException, InterruptedException {
		
		driver.findElementByXPath("//*[@text='General Details']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='Training Centre 1']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='Capture Image']").click();
		Thread.sleep(2000);
		if (driver.findElementByXPath("//*[@text='ALLOW']").isDisplayed())
		{
			driver.findElementByXPath("//*[@text='ALLOW']").click();
		}
		driver.findElementByXPath(
				"//*[@class='android.widget.ImageView' and @resource-id='com.transsion.camera:id/shutter_button']")
				.click();// shutter button
		Thread.sleep(1000);
		driver.findElementById("com.transsion.camera:id/done_button").click();
		
		// #############################

		driver.findElementByXPath("//*[@text='Training Centre 1']").click();
		Thread.sleep(2000);
		SDMSTCCI_ClassRoom cr=new SDMSTCCI_ClassRoom(driver);
		cr.CameraClick();
		// #############################

		driver.findElementByXPath("//*[@text='Training Centre 2']").click();
		cr.CameraClick();


		// #############################

		driver.findElementByXPath("//*[@text='Front view']").click();
		cr.CameraClick();


		// #############################

		driver.findElementByXPath("//*[@text='Back view']").click();
		cr.CameraClick();


		// #############################

		driver.findElementByXPath("//*[@text='Left view']").click();
		cr.CameraClick();

		// #############################

		driver.findElementByXPath("//*[@text='Right view']").click();
		cr.CameraClick();
		
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Approach Road 2\"))"));

		// #############################

		driver.findElementByXPath("//*[@text='Outside Area 1']").click();
		cr.CameraClick();
	
		// #############################

		driver.findElementByXPath("//*[@text='Outside Area 2']").click();
		cr.CameraClick();
		// #############################

		driver.findElementByXPath("//*[@text='Approach Road 1']").click();
		cr.CameraClick();
		// #############################

		driver.findElementByXPath("//*[@text='Approach Road 2']").click();
		cr.CameraClick();
		// #############################

		driver.findElementByXPath("//*[@text='AEBAS Device']").click();
		cr.CameraClick();
		// #############################

		driver.findElementByXPath("//*[@text='Power Backup']").click();
		cr.CameraClick();
		// #############################

		driver.findElementByXPath("//*[@text='Internet Bill']").click();
		cr.CameraClick();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@text='SUBMIT']").click();
	String str=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
	Assert.assertEquals(str, "Successfully Uploaded.");
	
		driver.findElementByXPath("//*[@text='OK']").click();

		
	}
	

}
