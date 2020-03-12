package com.nsdc.androidMobile;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FeeBased extends Android {

	public static void MobileMainMethod(String Module, String UserName, String Password) throws InterruptedException, MalformedURLException{
		// TODO Auto-generated method stub
	       AndroidDriver<AndroidElement> driver = capabilities(Module);
//	        FileWriter fr=new FileWriter("./src/PageSource.txt");
//	        BufferedWriter br=new BufferedWriter(fr);

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
	      
//	      driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
//	      
//	      driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
//	      

//	      
//	      driver.findElementById("android:id/checkbox").click();
//	      
//	      driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();//this is the  one to identify the dynamic elemens
//	      driver.findElementById("android:id/edit").sendKeys("subha");
//	      driver.findElementsByClassName("android.widget.Button").get(1).click();//this is the  one to identify the dynamic elemens
//	    
	         driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys(UserName);
	        driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys(Password);
	        
	    driver.findElementByXPath("//android.widget.Button[@text='LOGIN']").click();
	    
//	    driver.findElementByXPath("//android.widget.EditText[@text='Old Password']").sendKeys();
//	    driver.findElementByXPath("//android.widget.EditText[@text='New Password']").sendKeys();
//	    driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys();
//	    
//	    driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys(UserName);
//        driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("ekaushal");
//	    
//        driver.findElementByXPath("//android.widget.Button[@text='LOGIN']").click();
	    driver.findElementByXPath("//*[@text='ALLOW ALL THE TIME']").click();//Gps allow button
//	    driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
//	    driver.findElementById("android:id/button1").click();
//  	for loop need
	
	driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='img_0']").click();//camera
	driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();//allow
	driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.mediatek.camera:id/shutter_button']").click();//shutter button
	driver.findElementById("com.mediatek.camera:id/done_button").click();

	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WASH ROOM (WOMEN)\"));");
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"WASH ROOM (WOMEN)\"))"));     
	
	driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='img_1']").click();//camera
	driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.mediatek.camera:id/shutter_button']").click();//shutter button
	driver.findElementById("com.mediatek.camera:id/done_button").click();
	//lab
	driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='img_2']").click();
	driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.mediatek.camera:id/shutter_button']").click();//shutter button
	driver.findElementById("com.mediatek.camera:id/done_button").click();
	driver.findElementByXPath("//*[@class='android.widget.Image' and @resource-id='img_3']").click();//camera
	driver.findElementByXPath("//*[@class='android.widget.ImageView' and @resource-id='com.mediatek.camera:id/shutter_button']").click();//shutter button
	driver.findElementById("com.mediatek.camera:id/done_button").click();

	
//MobileElement elementToClick = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"WASH ROOM (WOMEN)\"));");

//	driver.findElementByXPath("//*[@text='SAVE PHOTOS']").click();
//	driver.findElementByXPath("//*[@text='YES']").click();
//	driver.findElementByXPath("//*[@text='OK']").click();

	    }

	}


