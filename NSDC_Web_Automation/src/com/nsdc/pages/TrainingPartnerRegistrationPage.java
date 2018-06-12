package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TrainingPartnerRegistrationPage
{
    WebDriver driver;
    
    @FindBy(xpath="//input[@name='organization-name']")
    private WebElement nameOfOrganizationTextBox;
    @FindBy(xpath="(//select[@id='exampleSelect1'])[1]")
    private WebElement typeOfTheOrganizationDropDownList;
    @FindBy(xpath="(//select[@id='exampleSelect1'])[2]")
    private WebElement yearOfEstablishmentDropDownList;
    @FindBy(id="customFile")
    private WebElement browseFileButton;
    @FindBy(xpath="//button[contains(text(),'Upload')]")
    private WebElement uploadFileButton;
    @FindBy(xpath="//input[@name='landline-number']")
    private WebElement landlineNumberTextBox;
    @FindBy(xpath="//input[@name='website']")
    private WebElement websiteTextBox;
    @FindBy(xpath="//input[@name='CEO-name']")
    private WebElement nameOfCeoTextBox;
    @FindBy(xpath="//input[@ng-reflect-name='emailOfHead']")
    private WebElement emailOfCeoTextBox;
    @FindBy(xpath="//input[@ng-reflect-name='mobileOfHead']")
    private WebElement mobileNumberOfCeoTextBox;
    @FindBy(xpath="//label[@class='m-checkbox m-checkbox--default']")
    private WebElement authorizedSignatoryCheckBox;
    @FindBy(xpath="(//button[@class='btn btn-next'])[2]")
    private WebElement saveButton1;
    @FindBy(xpath="(//button[@class='btn btn-outline-info'])")
    private WebElement saveAsDraftButton1;
    @FindBy(xpath="//textarea[@id='m_autosize_1']")
    private WebElement addressOfTheOrganizationTextBox;
    @FindBy(xpath="//input[@ng-reflect-name='landmark']")
    private WebElement nearByLandmarkTextBox;
    @FindBy(xpath="//input[@name='pincode']")
    private WebElement pinCodeTextBox;
    @FindBy(xpath="//select[@name='state']")
    private WebElement stateDropDownList;
    @FindBy(xpath="//select[@name='dist']")
    private WebElement districtDropDownList;
    @FindBy(xpath="//select[@name='tehsil']")
    private WebElement tehsilDropDownList;
    @FindBy(xpath="//input[@id='search_places']")
    private WebElement geoLocationTextBoxTextBox;
    @FindBy(xpath="//select[@ng-reflect-name='parliamentaryConstituency']")
    private WebElement parliamentaryConstituencyDropdownList;
    @FindBy(xpath="//select[@ng-reflect-name='addressProof']")
    private WebElement addressProofDropDownList;
    @FindBy(xpath="(//button[@class='btn btn-next'])[3]")
    private WebElement saveButton2;
    @FindBy(xpath="//label[@class='m-checkbox m-checkbox--default']")
    private WebElement iAgreeCheckBox;
    @FindBy(xpath="//button[text()='Save & Continue']")
    private WebElement saveAndContinueButton;
    @FindBy(xpath="//button[(text()='Logout')]")
    private WebElement logOutButton;
    @FindBy(xpath="//button[(text()='Download Submitted Form')]")
    private WebElement downloadButton;
    
    
    public TrainingPartnerRegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterNameOfOrganizationTextBox(String name_Of_Organization)
    {
        nameOfOrganizationTextBox.clear();
        nameOfOrganizationTextBox.sendKeys(name_Of_Organization);
    }
    public void selectTypeOfTheOrganization(String type_Of_The_Organization)
    {
        SelectDropDownList.selectDropDownListByVisibleText(typeOfTheOrganizationDropDownList, type_Of_The_Organization);
    }
    
    public void selectYearOfEstablishment(String year_Of_Establishment)
    {
        SelectDropDownList.selectDropDownListByVisibleText(yearOfEstablishmentDropDownList, year_Of_Establishment);
    }
    
    public void clickBrowseFile()
    {
        browseFileButton.click();
    }
    
    public void clickUploadFile()
    {
        uploadFileButton.click();
    }
    
    public void enterLandline(String landLine)
    {
        landlineNumberTextBox.clear();
        landlineNumberTextBox.sendKeys(landLine);
    }
    public void enterWebsite(String website)
    {
        websiteTextBox.clear();
        websiteTextBox.sendKeys(website);
    }
    
    public void enterNameOfCeo(String name_Of_Ceo)
    {
        nameOfCeoTextBox.clear();
        nameOfCeoTextBox.sendKeys(name_Of_Ceo);
    }
    
    public void enterEmailOfCeo(String email_Of_Ceo)
    {
        emailOfCeoTextBox.clear();
        emailOfCeoTextBox.sendKeys(email_Of_Ceo);
    }
    
    public void enterMobileNumberOfCeo(String mobile_Number_Of_Ceo)
    {
        mobileNumberOfCeoTextBox.clear();
        mobileNumberOfCeoTextBox.sendKeys(mobile_Number_Of_Ceo);
    }
    
    public void clickAuthorizedSignatoryCheckBox()
    {
        authorizedSignatoryCheckBox.click();
    }
    
    public void clickSaveButton1()
    {
        saveButton1.click();
    }
    
    public void clickSaveAsDraftButton1()
    {
        saveAsDraftButton1.click();
    }
    
    public void enterAddressOfOrganizationTextBox(String addresss_Of_Organization)
    {
        addressOfTheOrganizationTextBox.clear();
        addressOfTheOrganizationTextBox.sendKeys(addresss_Of_Organization);
    }
    
    public void enterNearByLandmark(String near_By_Landmark)
    {
        nearByLandmarkTextBox.clear();
        nearByLandmarkTextBox.sendKeys(near_By_Landmark);
    }
    
    public void enterPinCode(String pin_Code)
    {
        pinCodeTextBox.clear();
        pinCodeTextBox.sendKeys(pin_Code);
    }
    
    public void selectState(String state)
    {
        SelectDropDownList.selectDropDownListByVisibleText(stateDropDownList, state);
    }
    
    public void selectDistrict(String district)
    {
        SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
    }
    
    public void selectTehsil(String tehsil)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tehsilDropDownList, tehsil);
    }
    
    public void enterGeoLocation(String geo_Location) throws Exception
    {
        geoLocationTextBoxTextBox.clear();
        geoLocationTextBoxTextBox.sendKeys(geo_Location);
        Thread.sleep(2000);
        geoLocationTextBoxTextBox.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    }
    
    public void selectParliamentaryConstituency(String parliamentary_constituency) throws Exception
    {
        SelectDropDownList.selectDropDownListByVisibleText(parliamentaryConstituencyDropdownList, parliamentary_constituency);
    }
    
    public void selectAddressProof(String address_proof)
    {
        SelectDropDownList.selectDropDownListByVisibleText(addressProofDropDownList, address_proof);
    }
    
    public void clickSaveButton2()
    {
        saveButton2.click();
    }
    
    public void clickIAgreeCheckBox()
    {
        iAgreeCheckBox.click();
    }
    
    public void clickSaveAndContinueButton()
    {
        saveAndContinueButton.click();
    }
    
    public void clickLogOutButton()
    {
        logOutButton.click();
    }
    
    public void clickDownloadButton()
    {
        downloadButton.click();
    }
    
}

