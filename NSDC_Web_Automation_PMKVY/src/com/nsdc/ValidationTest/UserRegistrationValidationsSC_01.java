package com.nsdc.ValidationTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_PMKVY_Pages.RegistrationPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;

import com.nsdc.testConfig.DatabaseConnection;
import com.nsdc.testConfig.TestConfiguration;

public class UserRegistrationValidationsSC_01 extends TestConfiguration
{
    @DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Validations/UserRegistration-Validations.xls", "RegisterValidationsSC01TC01");
    }
    
    @Test(dataProvider="registrationData")
    public void userRegistrationValidationsTC_01(String userType, String spocName, String email, String mobile, String reEnterSPOC, String reEnterEmail, String reEnterMobile, String emailOTP, String mobileOTP, String reEnterEmailOTP, String reEnterMobileOTP, String oldPassword, String newPassword, String confirmPassword, String reEnterOldPassword, String reEnterNewPassword, String reEnterConfirmPassword) throws Exception
    {
        //DatabaseConnection.deleteTrainingPartner(email);
        Thread.sleep(2000);
        LaunchPage lp = new LaunchPage(driver);
        lp.clickRegister();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.selectDropdownList(userType);
        rp.enterSPOCName(spocName);
        rp.enterEmail(email);
        rp.enterMobile(mobile);
        rp.enterSPOCName(reEnterSPOC);
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Please Enter Valid Data for name']")).getText(), "Please Enter Valid Data for name");
        rp.clickRegister();
        rp.enterSPOCName(spocName);
        rp.enterEmail(reEnterEmail);
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Invalid email address']")).getText(), "Invalid email address");
        rp.clickRegister();
        rp.enterEmail(email);
        rp.enterMobile(reEnterMobile);
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Please Enter Valid Data for mobile']")).getText(), "Please Enter Valid Data for mobile");
        rp.clickRegister();
        rp.enterMobile(mobile);
        Thread.sleep(2000);
        rp.clickRegister();
        
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(mobileOTP);
        rp.enterEmailOTP(reEnterEmailOTP);
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Please Enter Valid Data for Email OTP']")).getText(), "Please Enter Valid Data for Email OTP");
        Thread.sleep(2000);
        rp.clickVerify();
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(reEnterMobileOTP);
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Please Enter Valid Data for Mobile OTP']")).getText(), "Please Enter Valid Data for Mobile OTP");
        rp.clickVerify();
        rp.enterMobileOTP(mobileOTP);
        Thread.sleep(2000);
        rp.clickVerify();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-Center sucess-msg']")).getText(), "We have sent the Username and Password to the registered email address please login with those credentials.");
        
        String username = driver.findElement(By.xpath("//span[@class='text-bold']")).getText();
        rp.clickGoToLogin();
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, "ekaushal");
        Thread.sleep(2000);
        rp.enterOldPassword(oldPassword);
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        rp.enterNewPassword(reEnterNewPassword);
        rp.enterConfirmPassword(reEnterConfirmPassword);
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='errormsg fontSize'])[1]")).getText(), "Invalid password. Password must contain one upparcase, one lowercase, one number and one Special character.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='red']")).getText(), "Passwords do not match");
        rp.clickResetResubmit();
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        rp.enterOldPassword(reEnterOldPassword);
        rp.clickResetResubmit();
        Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "Password Doesn't match with existing password");
        rp.enterOldPassword(oldPassword);
        Thread.sleep(2000);
        rp.clickResetResubmit();
        Thread.sleep(2000);
        rp.clickConfirmationOkMessage();
        
        elp.performlogin(username, confirmPassword);
        Thread.sleep(4000);
        
        if(userType.equals("Training Partner") || userType.equals("Candidate"))
        {
            Assert.assertEquals(driver.findElement(By.xpath("//span[@class='m-topbar__welcome']")).getText(), username);
        }
        else if(userType.equals("Trainer") || userType.equals("Assessor"))
        {
            Assert.assertEquals(driver.findElement(By.xpath("//span[@class='m-topbar__username']")).getText(), username);
        }
    }
}


