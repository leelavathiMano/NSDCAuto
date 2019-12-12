package com.nsdc.mobile.ui.object;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

public class Assessor_List_Of_JobRoleScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_List_Of_JobRoleScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public void choosePlatformJobRole(String platformJobRole)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.view.View[android.view.View[android.view.View[contains(@text,'"+platformJobRole+"')]]]//android.widget.Image[@text='add circle']")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.view.View[android.view.View[android.view.View[contains(@text,'"+platformJobRole+"')]]]//android.widget.Image[@text='add circle']")).click();
		}
	}
	public void chooseDomainJobRole(String domainJobRole)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.view.View[android.view.View[android.view.View[contains(@text,'"+domainJobRole+"')]]]//android.widget.Image[@text='add circle']")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.view.View[android.view.View[android.view.View[contains(@text,'"+domainJobRole+"')]]]//android.widget.Image[@text='add circle']")).click();
		}
	}
}