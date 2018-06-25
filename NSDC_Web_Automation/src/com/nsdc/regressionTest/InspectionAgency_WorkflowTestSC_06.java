package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.InspectionAgency_CreateUserPage;
import com.nsdc.pages.InspectionAgency_DashboardPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.testConfig.DatabaseConnection;
import com.nsdc.testConfig.TestConfiguration;

public class InspectionAgency_WorkflowTestSC_06  extends TestConfiguration
{
    @DataProvider
    public Object[][] createNewUser_Data()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/InspectionAgency-Workflow.xls", "CreateNewUserSC06TC01");
    }
    
    @Test(dataProvider="createNewUser_Data")
    public void createNewUserTC_01(String IA_username, String IA_password, String type, String name, String email, String mobileNo, String aadhar, String id, String upload_addressProof) throws Exception
    {
    	DatabaseConnection.deleteUsersCreatedByIA(email);
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        EnterLoginPage elp = new EnterLoginPage(driver);
        lp.clickLogin();
        elp.performlogin(IA_username, IA_password);
        Thread.sleep(4000);
        
        InspectionAgency_DashboardPage dashboard = new InspectionAgency_DashboardPage(driver);
        dashboard.clickOnCreateANewUser();
        Thread.sleep(2000);
        InspectionAgency_CreateUserPage user = new InspectionAgency_CreateUserPage(driver);
        user.selectTheUserType(type);
        user.enterFullName(name);
        user.enterEmailAddress(email);
        user.enterMobileNumber(mobileNo);
        user.enterAadhaarNumber(aadhar);
        user.enterEmployeeId(id);
        user.clickOnBrowseForAddressProof();
        Thread.sleep(2000);
        UploadFile.upload(upload_addressProof);
        Thread.sleep(2000);
        user.clickOnUploadForAddressProof();
        Thread.sleep(2000);
        user.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Created Id is')]")).isDisplayed());
        user.clickOnOk();
    }
    
}

