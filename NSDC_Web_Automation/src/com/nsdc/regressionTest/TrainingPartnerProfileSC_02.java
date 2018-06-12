package com.nsdc.regressionTest;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.TrainingPartnerRegistrationPage;
import com.nsdc.testConfig.DatabaseConnection;
import com.nsdc.testConfig.TestConfiguration;

public class TrainingPartnerProfileSC_02 extends TestConfiguration
{
    @DataProvider
    public Object[][] tpProfileData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/TestData-Regression.xls", "TPProfileSC02TC01");
    }
    
    @Test(dataProvider="tpProfileData")
    public void governmentTpRegistrationTC_01(String userType, String spocName, String email, String mobile, String emailOTP, String mobileOTP, String name_Of_Organization, String type_Of_The_Organization, String year_Of_Establishment, String uploadFilePath, String landLine, String website, String name_Of_Ceo, String email_Of_Ceo, String mobile_Number_Of_Ceo, String addresss_Of_Organization, String near_By_Landmark, String pin_Code, String state, String district, String tehsil, String geo_Location, String parliamentary_constituency, String address_proof, String uploadFile) throws Exception
    {
        DatabaseConnection.deleteTrainingPartner(email);
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        lp.clickRegister();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.selectDropdownList(userType);
        rp.enterSPOCName(spocName);
        rp.enterEmail(email);
        rp.enterMobile(mobile);
        rp.clickRegister();
        Thread.sleep(2000);
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(mobileOTP);
        Thread.sleep(2000);
        rp.clickVerify();
        Thread.sleep(2000);
        String username = driver.findElement(By.xpath("//span[@class='text-bold']")).getText();
        rp.clickGoToLogin();
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, "ekaushal");
        Thread.sleep(4000);
        TrainingPartnerRegistrationPage tprp = new TrainingPartnerRegistrationPage(driver);
        tprp.enterNameOfOrganizationTextBox(name_Of_Organization);
        tprp.selectTypeOfTheOrganization(type_Of_The_Organization);
        tprp.selectYearOfEstablishment(year_Of_Establishment);
        tprp.clickBrowseFile();
        Thread.sleep(2000);
        UploadFile.upload(uploadFilePath);
        Thread.sleep(2000);
        tprp.clickUploadFile();
        Thread.sleep(3000);
        tprp.enterLandline(landLine);
        tprp.enterWebsite(website);
        tprp.enterNameOfCeo(name_Of_Ceo);
        tprp.enterEmailOfCeo(email_Of_Ceo);
        tprp.enterMobileNumberOfCeo(mobile_Number_Of_Ceo);
        tprp.clickAuthorizedSignatoryCheckBox();
        tprp.clickSaveButton1();
        
        tprp.enterAddressOfOrganizationTextBox(addresss_Of_Organization);
        tprp.enterNearByLandmark(near_By_Landmark);
        tprp.enterPinCode(pin_Code);
        tprp.selectState(state);
        tprp.selectDistrict(district);
        tprp.selectTehsil(tehsil);
        tprp.enterGeoLocation(geo_Location);
        tprp.selectParliamentaryConstituency(parliamentary_constituency);
        tprp.selectAddressProof(address_proof);
        tprp.clickBrowseFile();
        Thread.sleep(2000);
        UploadFile.upload(uploadFile);
        Thread.sleep(2000);
        tprp.clickUploadFile();
        Thread.sleep(3000);
        tprp.clickSaveButton2();
        
        Thread.sleep(2000);
        tprp.clickIAgreeCheckBox();
        Thread.sleep(2000);
        tprp.clickSaveAndContinueButton();
        Thread.sleep(2000);
        
        tprp.clickDownloadButton();
        Thread.sleep(2000);
        tprp.clickLogOutButton();
        Thread.sleep(2000);
        
        Assert.assertEquals(driver.findElement(By.xpath("//li[text()='Login']")).getText(), "Login");
    }
}

