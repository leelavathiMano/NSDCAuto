package com.nsdc.mobile.ui.ios;

import org.openqa.selenium.By;

public interface TC_CAAF_CentreArea_UploadImages
{
	By centreAreasFacilities = By.xpath("//android.widget.Image[contains(@text,'arrow forward')]");
	By uploadFileButtons = By.xpath("//android.widget.Image[contains(@text,'photo2')]");
	By uploadVideoButton = By.xpath("//android.widget.Image[contains(@text,'videosmall')]");
	By submitButton = By.xpath("//android.widget.Button[contains(@text,'SUBMIT')]");
	By okButton = By.xpath("//android.widget.Button[contains(@text,'OK')]");
}
