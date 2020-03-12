package com.nsdc.androidMobile;

import java.net.MalformedURLException;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SDMSTCCI_CenterAreas  {
	  AndroidDriver<AndroidElement> driver;
	
	public SDMSTCCI_CenterAreas(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void RunCenterAreas() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
//      FileWriter fr=new FileWriter("./src/PageSource.txt");
//      BufferedWriter br=new BufferedWriter(fr);c
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='Centre Areas']").click();
		driver.findElementByXPath("//*[@text='Reception']").click();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_1']").click();//camera
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
		
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_2']").click();//camera
SDMSTCCI_ClassRoom cr=new SDMSTCCI_ClassRoom(driver);
		
		cr.CameraClick();
		
//		driver.findElementByXPath("//*[@text='YES']").click();
//		driver.findElementByXPath("//*[@text='arrow back']").click();
		driver.findElementByXPath("//*[@text='SUBMIT']").click();
	String str=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
	Assert.assertEquals(str, "Successfully Uploaded.");
	
		driver.findElementByXPath("//*[@text='OK']").click();
		
		
		driver.findElementByXPath("//*[@text='Placement & Entrepreneurship Cell']").click();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_1']").click();//camera
		
		cr.CameraClick();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_2']").click();//camera
		cr.CameraClick();
		
		driver.findElementByXPath("//*[@text='SUBMIT']").click();
	String str1=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
	Assert.assertEquals(str1, "Successfully Uploaded.");
	
		driver.findElementByXPath("//*[@text='OK']").click();
		
		driver.findElementByXPath("//*[@text='Male Washroom']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_1']").click();//camera
		cr.CameraClick();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_2']").click();//camera
		cr.CameraClick();
		
		driver.findElementByXPath("//*[@text='SUBMIT']").click();
	String str2=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
	Assert.assertEquals(str2, "Successfully Uploaded.");
	
		driver.findElementByXPath("//*[@text='OK']").click();
		
		driver.findElementByXPath("//*[@text='Female Washroom']").click();
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_1']").click();//camera
		cr.CameraClick();
		
		driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='Resource_2']").click();//camera
		cr.CameraClick();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@text='SUBMIT']").click();
	String str3=driver.findElementByXPath("//*[@text='Successfully Uploaded.']").getText();
	Assert.assertEquals(str3, "Successfully Uploaded.");
	
		driver.findElementByXPath("//*[@text='OK']").click();
		
		driver.findElementByXPath("//*[@text='arrow back']").click();
		
		
		
	
	}

}
