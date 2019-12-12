package com.nsdc.mobile.ui.aos;

import org.openqa.selenium.By;

public interface Candidate_SyncData 
{
	By enableGPSButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	By syncDownMasterDataButton = By.xpath("//android.widget.Button[@text='Sync Down Master Data']");
	By registerButton = By.xpath("//android.widget.Button[@text='Register']");
	By viewRegisteredDataButton = By.xpath("//android.widget.Button[@text='View Registered Data']");
	By okButton = By.xpath("//android.widget.Button[@text='OK']");
	By wifiButton = By.xpath("//android.widget.Switch[@content-desc=\"Wi-Fi,Wi-Fi signal full.,TNT_ACT3G\"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView");

}
