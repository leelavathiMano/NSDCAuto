package com.nsdc.mobile.ui.object;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Assessor_AcceptedRequestsScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_AcceptedRequestsScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public WebElement getAcceptedBatchID(String batchID)
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]"));
		}
		else
		{
			return appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]"));
		}
	}
	public void clickTogoBack()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[@text='arrow back']")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.widget.Button[@text='arrow back']")).click();
		}
	}
	public void scrollToBatch(AppiumDriver appDriver, String batchID)
	{
		TouchAction act = new TouchAction(appDriver);
		int batchX=appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]")).getLocation().getX();
		int batchY=appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]")).getLocation().getY();
		act.press(new PointOption().withCoordinates(batchX, batchY)).waitAction(waitOptions(Duration.ofSeconds(5))).moveTo(point(60,318)).release().perform();
	}
}