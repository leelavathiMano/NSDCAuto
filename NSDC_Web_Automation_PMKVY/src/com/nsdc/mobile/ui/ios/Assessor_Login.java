package com.nsdc.mobile.ui.ios;

import org.openqa.selenium.By;

public interface Assessor_Login
{
	By usernameTextbox = By.id("lbl-0");
	By passwordTextbox = By.id("lbl-1");
	By loginButton = By.xpath("//android.widget.Button[contains(@text,'LOG IN')]");
}
