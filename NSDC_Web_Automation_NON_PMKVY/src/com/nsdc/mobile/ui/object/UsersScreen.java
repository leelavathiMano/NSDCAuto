package com.nsdc.mobile.ui.object;

import org.openqa.selenium.WebElement;

import com.nsdc.mobile.ui.aos.Users;

import io.appium.java_client.AppiumDriver;

public class UsersScreen 
{
	AppiumDriver appDriver;
	String instanceName;
	
	public UsersScreen(AppiumDriver appDriver)
	{
		this.appDriver = appDriver;
		instanceName = appDriver.getClass().getName();
	}
	public WebElement getTrainingCentreButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Users.trainingCentreButton);
		}
		else 
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Users.trainingCentreButton);
		}
	}
	public WebElement getCentreInspectorButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Users.CentreInspectorButton);
		}
		else 
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Users.CentreInspectorButton);
		}
	}
}
