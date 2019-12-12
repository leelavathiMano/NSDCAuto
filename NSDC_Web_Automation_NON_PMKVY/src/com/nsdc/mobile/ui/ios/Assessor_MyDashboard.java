package com.nsdc.mobile.ui.ios;

import org.openqa.selenium.By;

public interface Assessor_MyDashboard
{
	By pendingRequestsSection=By.xpath("//android.widget.ToggleButton[contains(@text,'PENDING REQUESTS')]");
	By acceptedRequestsSection=By.xpath("//android.widget.ToggleButton[contains(@text,'ACCEPTED')]");
}