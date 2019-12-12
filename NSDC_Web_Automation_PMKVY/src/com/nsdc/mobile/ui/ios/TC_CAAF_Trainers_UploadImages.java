package com.nsdc.mobile.ui.ios;

import org.openqa.selenium.By;

public interface TC_CAAF_Trainers_UploadImages
{
	By trainerButtons = By.xpath("//android.view.View[contains(@text,'TR')]");
	By profilePicButton = By.xpath("//android.widget.Image[contains(@text,'favicon')]");
	By uploadFileButtons = By.xpath("//android.widget.Image[contains(@text,'photo2')]");
	By highestQualificationButton = By.xpath("//android.view.View[contains(@text,'Highest Qualification certificate')]");
	By submitButton = By.xpath("//android.widget.Button[contains(@text,'SUBMIT')]");
	By okButton = By.xpath("//android.widget.Button[contains(@text,'OK')]");
}
