package com.nsdc.componentTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.testConfig.TestConfiguration;

public class UserRegistrationValidationsSC_01 extends TestConfiguration
{
	@DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/TestData-Validations.xls", "RegisterValidationsSC01TC01");
    }
    
    @Test(dataProvider="registrationData")
    public void userRegistrationValidationsTC_01(String userType, String spocName, String email, String mobile, String reEnterSPOC, String reEnterEmail, String reEnterMobile, String emailOTP, String mobileOTP, String reEnterEmailOTP, String reEnterMobileOTP) throws Exception
    {
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
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
        rp.clickRegister();
        
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(mobileOTP);
        rp.enterEmailOTP(reEnterEmailOTP);
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Please Enter Valid Data for Email OTP']")).getText(), "Please Enter Valid Data for Email OTP");
        rp.clickVerify();
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(reEnterMobileOTP);
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Please Enter Valid Data for Mobile OTP']")).getText(), "Please Enter Valid Data for Mobile OTP");
        rp.clickVerify();
        rp.enterMobileOTP(mobileOTP);
        Thread.sleep(2000);
        rp.clickVerify();
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-Center sucess-msg']")).getText(), "We have sent the UserName and Password to the registered email address please login with those credentials.");
    }
}

