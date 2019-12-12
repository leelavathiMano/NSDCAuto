package com.nsdc.mobile.ui.ios;

import org.openqa.selenium.By;

public interface TC_CAAF_Facilities_UploadImages
{
	By uploadFileButtons = By.xpath("//android.widget.Image[contains(@text,'photo2')]");
	By submitButton = By.xpath("//android.widget.Button[contains(@text,'SUBMIT')]");
	By okButton = By.xpath("//android.widget.Button[contains(@text,'OK')]");
}
