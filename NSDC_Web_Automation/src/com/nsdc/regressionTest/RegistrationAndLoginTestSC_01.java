package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.testConfig.DatabaseConnection;
import com.nsdc.testConfig.TestConfiguration;

public class RegistrationAndLoginTestSC_01 extends TestConfiguration
{
    
    @DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/UserRegistration-Workflow.xls", "RegisterSC01TC01");
    }
    
    @Test(dataProvider="registrationData")
    public void userRegistrationTC_01(String userType, String spocName, String email, String mobile, String emailOTP, String mobileOTP, String oldPassword, String newPassword, String confirmPassword) throws Exception
    {
        //DatabaseConnection.deleteTrainingPartner(email);
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(2000);
        lp.clickRegister();
		Thread.sleep(3000);
        RegistrationPage rp = new RegistrationPage(driver);
        rp.selectDropdownList(userType);
     	Thread.sleep(3000);
  		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
        if(userType.equalsIgnoreCase("Training Provider"))
        {
         	Thread.sleep(3000);
      		bsp.clickOnClose_Second();
        }
        rp.enterSPOCName(spocName);
        rp.enterEmail(email);
        rp.enterMobile(mobile);
        rp.clickIagree();
        Thread.sleep(2000);
        rp.clickRegister();
        Thread.sleep(2000);
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(mobileOTP);
        Thread.sleep(2000);
        rp.clickVerify();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-Center sucess-msg']")).getText(), "We have sent the Username and Password to the registered email address. Please login with those credentials.");
        
        String username = driver.findElement(By.xpath("//span[@class='text-bold']")).getText();
        rp.clickGoToLogin();
        Thread.sleep(3000);
		//BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, "ekaushal");
        Thread.sleep(2000);
        rp.enterOldPassword(oldPassword);
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        rp.clickResetResubmit();
        Thread.sleep(2000);
        rp.clickConfirmationOkMessage();
        Thread.sleep(3000);
		//BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
        
        elp.performlogin(username, confirmPassword);
        Thread.sleep(4000);
        //Assert.assertEquals(driver.findElement(By.xpath("//span[@class='m-topbar__welcome user-name']")).getText(), username);
      
        if(userType.equals("Training Partner") || userType.equals("Candidate"))
        {
            Assert.assertEquals(driver.findElement(By.xpath("//span[@class='m-topbar__welcome user-name']")).getText(), username);
        }
        else if(userType.equals("Trainer") || userType.equals("Assessor"))
        {
            Assert.assertEquals(driver.findElement(By.xpath("//span[@class='m-topbar__welcome user-name']")).getText(), username);
        }
        
    }
    
    @DataProvider
    public Object[][] loginFailure()
    {
        return ReadMultipleDataFromExcel.getLoginCredentials("./TestData/Workflow/UserRegistration-Workflow.xls", "LoginFailureSC01TC02");
    }
    
    @Test(dataProvider="loginFailure")
    public void verifyLoginFailureTC_02(String username, String password) throws Exception
    {
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        lp.clickLogin();
        Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, password);
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "Invalid UserName or Password");
    }
    
 /*   @Test
    public void LoginFailWithoutEnteringCredentialsTC_03() throws Exception
    {
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        lp.clickLogin();
        EnterLoginPage elp = new EnterLoginPage(driver);
        Thread.sleep(3000);
        elp.clickLoginToSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "Username or Password should not be empty");
    }*/
}

