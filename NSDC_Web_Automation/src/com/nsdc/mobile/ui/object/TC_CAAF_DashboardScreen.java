package com.nsdc.mobile.ui.object;

import org.openqa.selenium.WebElement;

import com.nsdc.mobile.ui.aos.TC_CAAF_Dashboard;

import io.appium.java_client.AppiumDriver;

public class TC_CAAF_DashboardScreen
{
		AppiumDriver appDriver;
		String instanceName;
		
		public TC_CAAF_DashboardScreen(AppiumDriver appDriver)
		{
			this.appDriver = appDriver;
			instanceName = appDriver.getClass().getName();
		}
		
		public WebElement getEnableGPSButton()
		{
			if(instanceName.contains("Android"))
			{
				return appDriver.findElement(TC_CAAF_Dashboard.enableGPSButton);
			}
			else
			{
				return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Dashboard.enableGPSButton);
			}
		}
		public WebElement getGeneralDeatilsButton()
		{
			if(instanceName.contains("Android"))
			{
				return appDriver.findElement(TC_CAAF_Dashboard.generalDeatilsButton);
			}
			else
			{
				return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Dashboard.generalDeatilsButton);
			}
		}
		public WebElement getTrainersButton()
		{
			if(instanceName.contains("Android"))
			{
				return appDriver.findElement(TC_CAAF_Dashboard.trainersButton);
			}
			else
			{
				return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Dashboard.trainersButton);
			}
		}
		public WebElement getClassroomButton()
		{
			if(instanceName.contains("Android"))
			{
				return appDriver.findElement(TC_CAAF_Dashboard.classroomButton);
			}
			else
			{
				return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Dashboard.classroomButton);
			}
		}
		public WebElement getLaboratoryDetailsButton()
		{
			if(instanceName.contains("Android"))
			{
				return appDriver.findElement(TC_CAAF_Dashboard.laboratoryDetailsButton);
			}
			else
			{
				return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Dashboard.laboratoryDetailsButton);
			}
		}
		public WebElement getCentreAreaButton()
		{
			if(instanceName.contains("Android"))
			{
				return appDriver.findElement(TC_CAAF_Dashboard.centreAreaButton);
			}
			else
			{
				return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Dashboard.centreAreaButton);
			}
		}
		public WebElement getResidentialFacilitiesButton()
		{
			if(instanceName.contains("Android"))
			{
				return appDriver.findElement(TC_CAAF_Dashboard.residentialFacilitiesButton);
			}
			else
			{
				return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Dashboard.residentialFacilitiesButton);
			}
		}
		public WebElement getFacilitiesButton()
		{
			if(instanceName.contains("Android"))
			{
				return appDriver.findElement(TC_CAAF_Dashboard.facilitiesButton);
			}
			else
			{
				return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Dashboard.facilitiesButton);
			}
		}
		public WebElement getEquipmentsButton()
		{
			if(instanceName.contains("Android"))
			{
				return appDriver.findElement(TC_CAAF_Dashboard.equipmentsButton);
			}
			else
			{
				return appDriver.findElement(com.nsdc.mobile.ui.ios.TC_CAAF_Dashboard.equipmentsButton);
			}
		}
}
