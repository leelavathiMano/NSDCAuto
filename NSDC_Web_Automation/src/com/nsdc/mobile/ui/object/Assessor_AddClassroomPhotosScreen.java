package com.nsdc.mobile.ui.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nsdc.mobile.ui.aos.Assessor_Login;

import io.appium.java_client.AppiumDriver;

public class Assessor_AddClassroomPhotosScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_AddClassroomPhotosScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();				
	}
	public void clickFirstCameraImage()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
	}
	public void clickAllowToAccessDevicePhotos()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'ALLOW')]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'ALLOW')]")).click();
		}
	}
	public void clickToSwitchCameraToSelfieMode()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("com.mediatek.camera:id/rlk_camera_switcher")).click();
		}
		else
		{
			appDriver.findElement(By.id("com.mediatek.camera:id/rlk_camera_switcher")).click();
		}
	}
	public void clickToTakePictureFromCamera()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("com.mediatek.camera:id/shutter_button")).click();
		}
		else
		{
			appDriver.findElement(By.id("com.mediatek.camera:id/shutter_button")).click();
		}
	}
	public void clickDoneButtonToUploadJustclickedPic()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.id("com.mediatek.camera:id/done_button")).click();
		}
		else
		{
			appDriver.findElement(By.id("com.mediatek.camera:id/done_button")).click();
		}
	}
	public void clickSecondCameraImage()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[2]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[2]")).click();
		}
	}
	public void clickThirdCameraImage()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
	}
	public void clickFourthCameraImage()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
	}
	public void clickFifthCameraImage()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
	}
	public void clickSixthCameraImage()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("(//android.widget.Image[@text='default'])[1]")).click();
		}
	}
	public void clickStopAssessemnt()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'STOP ASSESSMENT')]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'STOP ASSESSMENT')]")).click();
		}
	}
	public void clickLaterForMarksUpload()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'LATER')]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'LATER')]")).click();
		}
	}
	public void clickToUploadMarksNow()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'UPLOAD MARKS')]")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'UPLOAD MARKS')]")).click();
		}
	}
}