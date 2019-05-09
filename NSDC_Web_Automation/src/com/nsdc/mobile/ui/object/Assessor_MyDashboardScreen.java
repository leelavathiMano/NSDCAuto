package com.nsdc.mobile.ui.object;

import org.openqa.selenium.WebElement;

import com.nsdc.mobile.ui.aos.Assessor_MyDashboard;

import io.appium.java_client.AppiumDriver;

public class Assessor_MyDashboardScreen
{
	AppiumDriver appDriver;
	String instanceName;

	public Assessor_MyDashboardScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	
	public WebElement getPendingRequestsSection()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Assessor_MyDashboard.pendingRequestsSection);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Assessor_MyDashboard.pendingRequestsSection);
		}
	}
	public WebElement getAcceptedRequestsSection()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Assessor_MyDashboard.acceptedRequestsSection);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Assessor_MyDashboard.acceptedRequestsSection);
		}
	}
}