package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SPPMU_All_TP_ProjectimplementingAgencypage {
	WebDriver driver;
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
	private WebElement ActionButton;
	@FindBy(xpath="(//a[contains(text(),'View Details')])[1]")
	private WebElement ViewDetailsIcon;
	@FindBy(xpath="(//a[contains(text(),'View Generated Termsheet')])[1]")
	private WebElement ViewGeneratedTermSheet;
	//
	public SPPMU_All_TP_ProjectimplementingAgencypage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//
	public void ClickOnAction() throws InterruptedException
	
	{
		Thread.sleep(3000);
		ActionButton.click();
	}
	public void ClickOnViewDetails()
	{
		ViewDetailsIcon.click();
	}
	public void ClickOnViewGeneratedTermSheet() throws InterruptedException
	{
		Thread.sleep(3000);
		ViewGeneratedTermSheet.click();
	}

}
