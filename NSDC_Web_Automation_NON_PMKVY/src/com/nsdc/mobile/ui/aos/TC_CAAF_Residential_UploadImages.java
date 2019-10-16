package com.nsdc.mobile.ui.aos;

import org.openqa.selenium.By;

public interface TC_CAAF_Residential_UploadImages
{
	By addButton = By.xpath("//android.widget.Button[contains(@text,'close add')]");
	By facilityDecriptionTextbox = By.className("android.widget.EditText");
	By uploadFileButtons = By.xpath("//android.widget.Image[contains(@text,'photo2')]");
	By uploadVideoButton = By.xpath("//android.widget.Image[contains(@text,'videosmall')]");
	By submitButton = By.xpath("//android.widget.Button[contains(@text,'SUBMIT')]");
	By okButton = By.xpath("//android.widget.Button[contains(@text,'OK')]");
}
