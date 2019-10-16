package com.nsdc.testConfig;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.nsdc.generic.ReadWriteData;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class CreateAppiumDriver
{
	public static AppiumDriver getDriverInstance() 
	{
		AppiumDriver appDriver = null;
		String platform = ReadWriteData.getData("./TestData/Configurations.xls", "AppConfig", 1, 0);
		String deviceName = ReadWriteData.getData("./TestData/Configurations.xls", "AppConfig", 1, 1);
		String platformVersion = ReadWriteData.getData("./TestData/Configurations.xls", "AppConfig", 1, 2);
		DesiredCapabilities cap = new DesiredCapabilities();
		if(platform.equalsIgnoreCase("aos"))
		{
			cap.setCapability("platform", "Android");
			cap.setCapability("appPackage", "com.transneuron.nsdl");
			cap.setCapability("appActivity", "com.transneuron.nsdl.MainActivity");
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("platformVersion", platformVersion);			
			
			try		
			{
				appDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			}
			catch (Exception e)
			{	
				e.printStackTrace();
			}
		}
		else if(platform.equalsIgnoreCase("ios"))
		{
			cap.setCapability("platform", "ios");
			cap.setCapability("PlatformVersion", "12.1.0");
			cap.setCapability("deviceUDID", "");
			cap.setCapability("bundleID", "");
			try
			{
				appDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.err.println("-------------Invalid Platform--------------------");
		}
		
		appDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return appDriver;
	}
	
}
