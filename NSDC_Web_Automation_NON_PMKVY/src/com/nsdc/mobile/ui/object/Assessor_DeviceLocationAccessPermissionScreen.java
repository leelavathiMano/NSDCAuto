package com.nsdc.mobile.ui.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.nsdc.mobile.ui.aos.Assessor_DeviceLocationAccessPermission;
import io.appium.java_client.AppiumDriver;

public class Assessor_DeviceLocationAccessPermissionScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_DeviceLocationAccessPermissionScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public WebElement getAllowToAccessDeviceLocationButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Assessor_DeviceLocationAccessPermission.allowToAccessButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Assessor_DeviceLocationAccessPermission.allowToAccessButton);
		}
	}
	public void clickOkForDeviceLocationAccessSuccess()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'OK')]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'OK')]")).click();
		}
	}
}