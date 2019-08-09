package com.nsdc.mobile.ui.object;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;

public class Assessor_AttendanceScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_AttendanceScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public void clickToGivePresenceForPlatformApplicnat1()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-19-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-19-0")).click();
		}
	}
	public void clickToGivePresenceForPlatformApplicnat2()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-20-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-20-0")).click();
		}
	}
	public void clickToGivePresenceForPlatformApplicnat3()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-21-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-21-0")).click();
		}
	}
	public void clickToGivePresenceForPlatformApplicnat4()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-22-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-22-0")).click();
		}
	}
	public void clickToGivePresenceForPlatformApplicnat5()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-23-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-23-0")).click();
		}
	}
	//Domain Applicants
	public void clickToGivePresenceForDomainApplicnat1()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-27-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-27-0")).click();
		}
	}
	public void clickToGivePresenceForDomainApplicnat2()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-28-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-28-0")).click();
		}
	}
	public void clickToGivePresenceForDomainApplicnat3()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-29-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-29-0")).click();
		}
	}
	public void clickToGivePresenceForDomainApplicnat4()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-30-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-30-0")).click();
		}
	}
	public void clickToGivePresenceForDomainApplicnat5()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("toggle-31-0")).click();
		}
		else
		{
			appDriver.findElement(By.id("toggle-31-0")).click();
		}
	}
}