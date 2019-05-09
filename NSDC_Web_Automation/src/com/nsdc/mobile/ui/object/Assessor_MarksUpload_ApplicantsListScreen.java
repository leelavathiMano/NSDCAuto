package com.nsdc.mobile.ui.object;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

public class Assessor_MarksUpload_ApplicantsListScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_MarksUpload_ApplicantsListScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public void clickApplicantToStartMarksUploading(String applicantID)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.view.View[android.view.View[android.view.View[contains(@text,'"+applicantID+"')]]]//android.widget.Image[@text='add circle']")).click();
		}
		else
		{
			appDriver.findElement(By.xpath("//android.view.View[android.view.View[android.view.View[contains(@text,'"+applicantID+"')]]]//android.widget.Image[@text='add circle']")).click();
		}
	}
}