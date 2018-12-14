package com.nsdc.mobile.ui.object;

import org.openqa.selenium.WebElement;

import com.nsdc.mobile.ui.aos.Login;

import io.appium.java_client.AppiumDriver;

public class LoginScreen 
{
	AppiumDriver appDriver;
	String instanceName;
	
	public LoginScreen(AppiumDriver appDriver)
	{
		this.appDriver = appDriver;
		instanceName = appDriver.getClass().getName();
	}
	public WebElement getEmailTextbox()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Login.usernameTextbox);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Login.usernameTextbox);
		}
	}
	public WebElement getPasswordTextbox()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Login.passwordTextbox);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Login.passwordTextbox);
		}
	}
	public WebElement getLoginButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Login.loginButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Login.loginButton);
		}
	}
}
