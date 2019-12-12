package com.nsdc.mobile.ui.object;

import org.openqa.selenium.WebElement;
import com.nsdc.mobile.ui.aos.Assessor_ChooseYourUserGroup;
import io.appium.java_client.AppiumDriver;

public class Assessor_ChooseYourUserGroupScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_ChooseYourUserGroupScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public WebElement getAssessorButton()
	{
		if(instanceName.contains("Android"))
		{
			return appDriver.findElement(Assessor_ChooseYourUserGroup.assessorButton);
		}
		else
		{
			return appDriver.findElement(com.nsdc.mobile.ui.ios.Assessor_ChooseYourUserGroup.assessorButton);
		}
	}
}