package com.nsdc.mobile.ui.object;

import org.openqa.selenium.WebElement;

import com.nsdc.mobile.ui.aos.Candidate_SyncData;

import io.appium.java_client.AppiumDriver;

public class Candidate_SyncDataScreen 
{
	
	AppiumDriver appDriver;
	String instanceName;
	
	public Candidate_SyncDataScreen(AppiumDriver appDriver)
	{
		this.appDriver = appDriver;
		instanceName = appDriver.getClass().getName();
	}
	
	public WebElement getEnableGPSButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Candidate_SyncData.enableGPSButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Candidate_SyncData.enableGPSButton);
		}
	}
	
	public WebElement getSyncDownMasterDataButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Candidate_SyncData.syncDownMasterDataButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Candidate_SyncData.syncDownMasterDataButton);
		}
	}
	
	public WebElement getRegisterButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Candidate_SyncData.registerButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Candidate_SyncData.registerButton);
		}
	}
	
	public WebElement getViewRegisteredDataButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Candidate_SyncData.viewRegisteredDataButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Candidate_SyncData.viewRegisteredDataButton);
		}
	}
	
	public WebElement getOKButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Candidate_SyncData.okButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Candidate_SyncData.okButton);
		}
	}
	
	public WebElement getWifiButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Candidate_SyncData.wifiButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Candidate_SyncData.wifiButton);
		}
	}
	

}
