package com.nsdc.mobile.ui.object;

import org.openqa.selenium.WebElement;
import com.nsdc.mobile.ui.aos.Assessor_Login;
import io.appium.java_client.AppiumDriver;

public class Assessor_LoginScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_LoginScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();				
	}
	public WebElement getEmailTextbox()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Assessor_Login.usernameTextbox);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Assessor_Login.usernameTextbox);
		}
	}
	public WebElement getPasswordTextbox()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Assessor_Login.passwordTextbox);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Assessor_Login.passwordTextbox);
		}
	}
	public WebElement getLoginButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Assessor_Login.loginButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Assessor_Login.loginButton);
		}
	}
}