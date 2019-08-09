package com.nsdc.mobile.ui.ios;

import org.openqa.selenium.By;

public interface Login 
{
	By usernameTextbox = By.xpath("//android.view.View[@text='Userame / Unique ID']/..");
	By passwordTextbox = By.xpath("//android.view.View[@text='Password']/..");
	By loginButton = By.xpath("//android.widget.Button[contains(@text,'LOG IN')]");
}
