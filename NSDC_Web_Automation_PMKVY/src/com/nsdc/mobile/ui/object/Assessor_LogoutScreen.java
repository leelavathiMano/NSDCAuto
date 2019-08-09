package com.nsdc.mobile.ui.object;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Assessor_LogoutScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_LogoutScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public void performAssessorLogout()
	{
		if(instanceName.contains("Android"))
		{
			Dimension winsize = appDriver.manage().window().getSize();
			TouchAction act = new TouchAction(appDriver);
			act.press(new PointOption().withCoordinates(90, 1249)).waitAction(waitOptions(Duration.ofSeconds(5))).moveTo(point(1039, 1256)).release().perform();
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'logout')]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'logout')]")).click();
		}
	}
	public void clickOkButton()
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