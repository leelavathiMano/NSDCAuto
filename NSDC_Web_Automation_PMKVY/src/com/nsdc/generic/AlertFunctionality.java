package com.nsdc.generic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertFunctionality
{
    
    public static void acceptAlert(WebDriver driver)
    {
        Alert alt = driver.switchTo().alert();
        alt.accept();
    }
    public static void dismissAlert(WebDriver driver)
    {
        Alert alt = driver.switchTo().alert();
        alt.dismiss();
    }
    public static void enterTextAlert(WebDriver driver, String data)
    {
        Alert alt = driver.switchTo().alert();
        alt.sendKeys(data);
    }
    public static String getAlertText(WebDriver driver)
    {
        Alert alt = driver.switchTo().alert();
        String altText = alt.getText();
        return altText;
    }
    
    
}

