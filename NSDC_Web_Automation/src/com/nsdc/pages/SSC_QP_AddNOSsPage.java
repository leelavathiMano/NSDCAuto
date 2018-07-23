package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_QP_AddNOSsPage 
{
	WebDriver driver;
	@FindBy(xpath="//div[@class='card nav-link active show']")
	private WebElement searchAndLinkNOS_Tab;
	@FindBy(xpath="//input[@placeholder='Search by NOS Code']")
	private WebElement NOScodeSearchBox;
	@FindBy(xpath="//button[contains(text(),'Search')]")
	private WebElement searchButton;
	@FindBy(xpath="//td[@data-field='Actions']")
	private WebElement actionButton;
	@FindBy(xpath="//li[@data-target='#m_modal_compulsory_nos']")
	private WebElement linkAsCompulsoryNOSsButton;
	@FindBy(xpath="//div[h5[contains(text(),'While adding this NOS to the QP')]]/button[@class='close']")
	private WebElement linkAsCompulsoryNOSsPopupCancelButton;
	@FindBy(xpath="//div[div/h5[contains(text(),'While adding this')]]/div/button[contains(text(),'Link NOS')]")
	private WebElement linkAsCompulsoryNOSs_linkNOSButton;
	@FindBy(xpath="//div[div/h5[contains(text(),'While adding this')]]/div/button[contains(text(),'Cancel')]")
	private WebElement linkAsCompulsoryNOSs_cancelButton;
	
	
	@FindBy(xpath="//a[@data-target='#m_modal_elective_nos']")
	private WebElement linkToElectivesButton;
	
	@FindBy(xpath="(//div[h5[contains(text(),'Add New Elective')]]/button[@class='close'])[1]")
	private WebElement linkToElectivesPopupCancelButton;
	@FindBy(xpath="(//input[@id='name'])[1]")
	private WebElement enterNameOfTheElectiveTextBox;
	@FindBy(xpath="(//textarea[@id='message-text'])[1]")
	private WebElement enterBriefDescriptionOfTheElectiveTextBox;
	@FindBy(xpath="(//div[div/h5[contains(text(),'Add New Elective')]]/div/button[contains(text(),'Link NOS')])[1]")
	private WebElement linkToElectives_linkNOSButton;
	@FindBy(xpath="(//div[div/h5[contains(text(),'Add New Elective')]]/div/button[contains(text(),'Cancel')])[1]")
	private WebElement linkToElectives_cancelButton;
	
	
	
	@FindBy(xpath="//a[@data-target='#m_modal_optional_nos']")
	private WebElement linkToOptionsButton;
	
	@FindBy(xpath="(//div[h5[contains(text(),'Add New Option')]]/button[@class='close'])[1]")
	private WebElement linkToOptionsPopupCancelButton;
	@FindBy(xpath="(//input[@id='name'])[2]")
	private WebElement enterNameOfTheOptionTextBox;
	@FindBy(xpath="(//textarea[@id='message-text'])[2]")
	private WebElement enterBriefDescriptionOfTheOptionTextBox;
	@FindBy(xpath="(//div[div/h5[contains(text(),'Add New Option')]]/div/button[contains(text(),'Link NOS')])[2]")
	private WebElement linkToOptions_linkNOSButton;
	@FindBy(xpath="(//div[div/h5[contains(text(),'Add New Option')]]/div/button[contains(text(),'Cancel')])[2]")
	private WebElement linkToOptions_cancelButton;
	
	
	/////////////////////////
	@FindBy(xpath="(//div[@class='card nav-link'])[1]")
	private WebElement compulsoryNOSsTab;
	@FindBy(xpath="(//div[@class='card nav-link'])[2]")
	private WebElement addedElectivesTab;
	@FindBy(xpath="(//div[@class='card nav-link'])[3]")
	private WebElement addedOptionsTab;
	
	public SSC_QP_AddNOSsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnSearchAndLinkNOS()
	{
		searchAndLinkNOS_Tab.click();
	}
	
	public void enterNOScodeInSearchBox(String search)
	{
		NOScodeSearchBox.clear();
		NOScodeSearchBox.sendKeys(search);
	}
	
	public void clickOnSearch()
	{
		searchButton.click();
	}
	
	public void clickOnAction()
	{
		actionButton.click();
	}
	
	public void clickOnLinkAsCompulsoryNOSs()
	{
		linkAsCompulsoryNOSsButton.click();
	}
	
	public void clickOnCancelForLinkAsCompulsoryNOSsPopup()
	{
		linkAsCompulsoryNOSsPopupCancelButton.click();
	}
	
	public void clickOnLinkNos_linkAsCompulsoryNOSs()
	{
		linkAsCompulsoryNOSs_linkNOSButton.click();
	}
	
	public void clickOnCancel_linkAsCompulsoryNOSs()
	{
		linkAsCompulsoryNOSs_cancelButton.click();
	}
	
	public void clickOnLinkToElectives()
	{
		linkToElectivesButton.click();
	}
	
	public void enterNameOfTheElective(String elective)
	{
		enterNameOfTheElectiveTextBox.clear();
		enterNameOfTheElectiveTextBox.sendKeys(elective);
	}
	
	public void enterBriefDescriptionOfTheElective(String electiveDescription)
	{
		enterBriefDescriptionOfTheElectiveTextBox.clear();
		enterBriefDescriptionOfTheElectiveTextBox.sendKeys(electiveDescription);
	}
	
	public void clickOnLinkNOS_LinkToElectives()
	{
		linkToElectives_linkNOSButton.click();
	}
	
	public void clickOnCancel_LinkToElectives()
	{
		linkToElectives_cancelButton.click();
	}
	
	public void clickOnLinkToOptions()
	{
		linkToOptionsButton.click();
	}
	
	public void clickOnCancelForlinkToOptionsPopup()
	{
		linkToOptionsPopupCancelButton.click();
	}
	
	public void enterNameOfTheOption(String option)
	{
		enterNameOfTheOptionTextBox.clear();
		enterNameOfTheOptionTextBox.sendKeys(option);
	}
	
	public void enterBriefDescriptionOfTheOption(String optionDescription)
	{
		enterBriefDescriptionOfTheOptionTextBox.clear();
		enterBriefDescriptionOfTheOptionTextBox.sendKeys(optionDescription);
	}
	
	public void clickOnLinkNOS_linkToOptions()
	{
		linkToOptions_linkNOSButton.click();
	}
	
	public void clickOnCancel_linkToOptions()
	{
		linkToOptions_cancelButton.click();
	}
	
	//////////////
	
	public void clickOnCompulsoryNOSs()
	{
		compulsoryNOSsTab.click();
	}
	
	public void clickOnAddedElectives()
	{
		addedElectivesTab.click();
	}
	
	public void clickOnAddedOptions()
	{
		addedOptionsTab.click();
	}
}
