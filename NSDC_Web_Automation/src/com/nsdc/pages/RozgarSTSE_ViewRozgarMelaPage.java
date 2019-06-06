package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozgarSTSE_ViewRozgarMelaPage
{
	WebDriver driver;
    @FindBy(xpath="//button[contains(text(),'Participating Employers')]")
    private WebElement participatingEmployersButton;
    @FindBy(xpath="//button[contains(text(),'Link an Employer')]")
    private WebElement linkAnEmployerButton;
    @FindBy(xpath="//input[@placeholder='Search']")
    private WebElement searchByEmployerIDTextField;
    @FindBy(xpath="//button[contains(text(),'Search')]")
    private WebElement searchButton;
       
    public RozgarSTSE_ViewRozgarMelaPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickToGoToParticipatingEmployersSection()
    {
    	participatingEmployersButton.click();
    }
    public void clickLinkEmployer()
    {
    	linkAnEmployerButton.click();
    }
    public void enterEmployerIDToSearch(String employerID)
    {
    	searchByEmployerIDTextField.clear();
    	searchByEmployerIDTextField.sendKeys(employerID);
    }
    public void clickSearch()
    {
    	searchButton.click();
    }
}