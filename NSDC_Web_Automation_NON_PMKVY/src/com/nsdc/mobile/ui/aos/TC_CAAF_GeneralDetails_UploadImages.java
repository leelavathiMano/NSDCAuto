package com.nsdc.mobile.ui.aos;

import org.openqa.selenium.By;

public interface TC_CAAF_GeneralDetails_UploadImages
{
	By upLoadFileButtons = By.className("android.widget.Image");
	By deviceStorageAccessButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	By submitButton = By.xpath("//android.widget.Button[contains(@text,'SUBMIT')]");
	By okButton = By.xpath("//android.widget.Button[contains(@text,'OK')]");
}
