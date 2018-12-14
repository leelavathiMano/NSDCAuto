package com.nsdc.generic;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;

import com.nsdc.mobile.ui.object.CameraFunctionalityScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class MobileHandlers
{
	@SuppressWarnings("rawtypes")
	public static void rotateLandscape(AppiumDriver appDriver)
	{
		String orientation_type = appDriver.getOrientation().toString();
		if(orientation_type.contains("Protrait"))
		{
			appDriver.rotate(ScreenOrientation.LANDSCAPE);
		}
	}
	@SuppressWarnings("rawtypes")
	public static void rotatePotrait(AppiumDriver appDriver)
	{
		String orientation_type = appDriver.getOrientation().toString();
		if(orientation_type.contains("Landscape"))
		{
			appDriver.rotate(ScreenOrientation.PORTRAIT);
		}
	}
	@SuppressWarnings("rawtypes")
	public static void scrollScreen(AppiumDriver appDriver) throws Exception 
	{
		Thread.sleep(2000);
		Dimension winsize = appDriver.manage().window().getSize();
		
		int startx = (winsize.width * 0)/100;
		int endx = (winsize.width * 35)/100;
		int starty = (winsize.width * 0)/100;
		int endy = (winsize.width * 25)/100;
		
		TouchAction act = new TouchAction(appDriver);
		act.press(new PointOption().withCoordinates(startx, starty)).waitAction(waitOptions(Duration.ofSeconds(2))).moveTo(point(endx, endy)).release().perform();
	}
	@SuppressWarnings("rawtypes")
	public static void clickPicture(AppiumDriver appDriver)
	{
		CameraFunctionalityScreen cam = new CameraFunctionalityScreen(appDriver);
		cam.getFrontCamButtom().click();
		cam.getClickPictureButton().click();
		cam.getConfirmPictureButton().click();		
	}
	@SuppressWarnings("rawtypes")
	public static void recordVideo(AppiumDriver appDriver) throws Exception
	{
		CameraFunctionalityScreen cam = new CameraFunctionalityScreen(appDriver);
		cam.getFrontCamButtom().click();
		cam.getClickPictureButton().click();
		Thread.sleep(3000);
		cam.getClickPictureButton().click();
		cam.getConfirmPictureButton().click();
	}
	
}
