package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.NSDCAdmin_DashboardPage;
import com.nsdc.pages.NSDC_CreateUserPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.testConfig.TestConfiguration;

public class NSDC_CreateUserWorkflowTestSC_12 extends TestConfiguration
{
	@DataProvider
	public Object[][] createNewUser_Data()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/NSDC_CreateUser-Workflow.xls", "NSDCCreateUserSC12TC01");
	}
	
	@Test(dataProvider="createNewUser_Data")
	public void createNewUserTC_01(String username, String password, String businessUser, String fullname, String email, String mobileNumber) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(username, password);
		NSDCAdmin_DashboardPage ndp = new NSDCAdmin_DashboardPage(driver);
		Thread.sleep(5000);
		ndp.clickOnCreateSDMSUser();
		NSDC_CreateUserPage user = new NSDC_CreateUserPage(driver);
		Thread.sleep(3000);
		user.selectBusinessUser(businessUser);
		user.enterFullName(fullname);
		user.enterEmailAddress(email);
		user.enterMobileNumber(mobileNumber);
		Thread.sleep(3000);
		user.clickOnSubmit();
		
		if(businessUser.equals("Business Owner"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Business Owner created successfully')]")).getText(), "Business Owner created successfully");
		}
		
		else if(businessUser.equals("Inspection Agency Admin"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Inspection Agency Admin created successfully']")).getText(), "Inspection Agency Admin created successfully");
		}
		
		else if(businessUser.equals("Standards Team"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Standards Team created successfully']")).getText(), "Standards Team created successfully");
		}
		
		else if(businessUser.equals("Holding Agency"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Holding Agency created successfully']")).getText(), "Holding Agency created successfully");
		}
		
		else if(businessUser.equals("SSC Admin"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='SSC Admin created successfully']")).getText(), "SSC Admin created successfully");
		}
		
		else if(businessUser.equals(""))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='SCPWD created successfully']")).getText(), "SCPWD created successfully");
		}
		
		Thread.sleep(3000);
		user.clickOnOK();
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	

}
