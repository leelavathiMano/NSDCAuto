package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Employer_RozgarMelaPage
{
	WebDriver driver;
    @FindBy(id="Search")
    private WebElement searchByRozgarMelaIDTextField;
    @FindBy(xpath="//button[contains(text(),'Apply Filters')]")
    private WebElement applyFiltersButton;
    @FindBy(css="i.la.la-ellipsis-h")
    private WebElement rozgarMelaActionMenu;
    @FindBy(xpath="//span[contains(text(),'Create Job Vacancy')]")
    private WebElement createJobVacancyOptionText;
    @FindBy(xpath="//button[contains(text(),'OK')]")
    private WebElement okButton;
       
    public Employer_RozgarMelaPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterRozgarMelaIdTosearch(String rozgarMelaID)
    {
    	searchByRozgarMelaIDTextField.clear();
    	searchByRozgarMelaIDTextField.sendKeys(rozgarMelaID);
    }
    public void clickToApplySearchFilters()
    {
    	applyFiltersButton.click();
    }
    public void clickToGetActionMenuOptions()
    {
    	rozgarMelaActionMenu.click();
    }
    public void chooseCreateJobVacancyOption()
    {
    	createJobVacancyOptionText.click();
    }
}