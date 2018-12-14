package com.nsdc.mobile.ui.object;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.nsdc.mobile.ui.aos.TC_CAAF_Facilities_UploadImages;

import io.appium.java_client.AppiumDriver;

public class TC_CAAF_Facilities_UploadImagesScreen
{
	AppiumDriver appDriver;
	String instanceName;
	
	public TC_CAAF_Facilities_UploadImagesScreen(AppiumDriver appDriver)
	{
		this.appDriver = appDriver;
		instanceName = appDriver.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public List<WebElement> getUploadFileButtons()
	{
		if(instanceName.contains("Android"))
		{
			return (List<WebElement>) appDriver.findElements(TC_CAAF_Facilities_UploadImages.uploadFileButtons);
		}
		else
		{
			return (List<WebElement>) appDriver.findElements(com.nsdc.mobile.ui.ios.TC_CAAF_Facilities_UploadImages.uploadFileButtons);
		}
	}
	public WebElement getSubmitButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(TC_CAAF_Facilities_UploadImages.submitButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Facilities_UploadImages.submitButton);
		}
	}
	public WebElement getOkButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(TC_CAAF_Facilities_UploadImages.okButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Facilities_UploadImages.okButton);
		}
	}
}
