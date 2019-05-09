package com.nsdc.mobile.ui.object;

import org.openqa.selenium.WebElement;

import com.nsdc.mobile.ui.aos.Assessor_BatchProfile_Info;

import io.appium.java_client.AppiumDriver;

public class Assessor_BatchProfile_InfoScreen
{
	AppiumDriver appDriver;
	String instanceName;
	
	public Assessor_BatchProfile_InfoScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public WebElement getStartAssessmentButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Assessor_BatchProfile_Info.startAssessmentButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Assessor_BatchProfile_Info.startAssessmentButton);
		}
	}
}