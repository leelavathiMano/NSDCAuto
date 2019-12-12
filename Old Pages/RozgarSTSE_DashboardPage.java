package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozgarSTSE_DashboardPage
{
	WebDriver driver;
    @FindBy(xpath="//p[text()='View Rozgar Melas']")
    private WebElement viewRozgarMelasCardText;
       
    public RozgarSTSE_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickViewRozgarMelas()
    {
    	viewRozgarMelasCardText.click();
    }
}