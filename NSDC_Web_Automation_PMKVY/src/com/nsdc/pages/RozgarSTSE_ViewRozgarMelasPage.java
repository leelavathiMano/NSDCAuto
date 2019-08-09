package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozgarSTSE_ViewRozgarMelasPage
{
	WebDriver driver;
    @FindBy(id="Search")
    private WebElement searchForRozgarMelaTextField;
    @FindBy(xpath="//button[contains(text(),'Apply Filters')]")
    private WebElement applySearchFilterButton;
    @FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
    private WebElement actionMenu;
    @FindBy(xpath="//a[span[contains(text(),'View Mela Details')]]")
    private WebElement viewMelaDetailsActionOption;
       
    public RozgarSTSE_ViewRozgarMelasPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterRozgarMelaIDTosearch(String rozgarMelaID)
    {
    	searchForRozgarMelaTextField.clear();
    	searchForRozgarMelaTextField.sendKeys(rozgarMelaID);
    }
    public void clickTogetSearchresult()
    {
    	applySearchFilterButton.click();
    }
    public void clickToGetActionMenu()
    {
    	actionMenu.click();
    }
    public void clickToChooseViewMelaDetailsOption()
    {
    	viewMelaDetailsActionOption.click();
    }
}