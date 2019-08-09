package com.nsdc.mobile.ui.aos;

import org.openqa.selenium.By;

public interface TC_CAAF_Dashboard
{
	By enableGPSButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	By generalDeatilsButton = By.xpath("//android.widget.Image[@text='laboratory']");
	By trainersButton = By.xpath("(//android.widget.Image[@text='trainer'])[1]");
	By classroomButton = By.xpath("(//android.widget.Image[@text='class_room'])[1]");
	By laboratoryDetailsButton = By.xpath("(//android.widget.Image[@text='trainer'])[2]");
	By centreAreaButton = By.xpath("(//android.widget.Image[@text='resedential'])[1]");
	By residentialFacilitiesButton = By.xpath("(//android.widget.Image[@text='resedential'])[2]");
	By facilitiesButton = By.xpath("(//android.widget.Image[@text='resedential'])[3]");
	By equipmentsButton = By.xpath("(//android.widget.Image[@text='class_room'])[2]");
}
