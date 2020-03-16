package com.nsdc.androidMobile;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SDMSTCCI_Hybrid {
	AndroidDriver<AndroidElement> driver;
	public SDMSTCCI_Hybrid(AndroidDriver<AndroidElement> driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver , this);
	}
	
public void RunHybridDetails() throws InterruptedException
{
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Hybrid Details\"))"));
	 Thread.sleep(3000);
	driver.findElementByXPath("//*[@text='Hybrid Details']").click();
	driver.findElementByXPath("//*[@text='HYBRID_1 arrow forward']").click();
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
	 SDMSTCCI_ClassRoom camera= new SDMSTCCI_ClassRoom(driver);
	 driver.findElementByXPath("//*[@text='photo2']").click();
	 camera.CameraClick();
	 Thread.sleep(2000);
	 driver.findElementByXPath("//*[@text='SUBMIT']").click();
		String str=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
		Assert.assertEquals(str, "Successfully Uploaded.");
		driver.findElementByXPath("//*[@text='OK']").click();
		 Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='arrow back']").click();
		
	
}
}
