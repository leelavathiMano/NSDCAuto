package com.nsdc.mobile.ui.aos;

import org.openqa.selenium.By;

public interface Assessor_DeviceLocationAccessPermission
{
	By allowToAccessButton=By.xpath("//android.widget.Button[contains(@text,'ALLOW')]");
	By denyToAccessButton=By.xpath("//android.widget.Button[contains(@text,'DENY')]");
}