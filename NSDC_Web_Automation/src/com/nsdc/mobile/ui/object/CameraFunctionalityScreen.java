package com.nsdc.mobile.ui.object;

import org.openqa.selenium.WebElement;

import com.nsdc.mobile.ui.aos.CameraFunctionality;

import io.appium.java_client.AppiumDriver;

public class CameraFunctionalityScreen
{
	AppiumDriver appDriver;
	String instanceName;
	
	public CameraFunctionalityScreen(AppiumDriver appDriver)
	{
		this.appDriver = appDriver;
		instanceName = appDriver.getClass().getName();
	}
	
	public WebElement getFrontCamButtom()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(CameraFunctionality.frontCamButtom);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.CameraFunctionality.frontCamButtom);
		}
	}
	public WebElement getClickPictureButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(CameraFunctionality.clickPictureButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.CameraFunctionality.clickPictureButton);
		}
	}
	public WebElement getConfirmPictureButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(CameraFunctionality.confirmPictureButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.CameraFunctionality.confirmPictureButton);
		}
	}
}
