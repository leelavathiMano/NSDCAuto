package com.nsdc.mobile.ui.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class Assessor_AcceptedRequestsScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_AcceptedRequestsScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public WebElement getAcceptedBatchID(String batchID)
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]"));
		}
		else
		{
			return appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]"));
		}
	}
	public void clickTogoBack()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[@text='arrow back']")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.widget.Button[@text='arrow back']")).click();
		}
	}
}