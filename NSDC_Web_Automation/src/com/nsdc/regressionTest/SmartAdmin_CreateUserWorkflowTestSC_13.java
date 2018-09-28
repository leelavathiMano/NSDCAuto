package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SmartAdmin_AllSDMSUserPage;
import com.nsdc.pages.SmartAdmin_CreateUserPage;
import com.nsdc.pages.SmartAdmin_DashboardPage;
import com.nsdc.testConfig.TestConfiguration;

public class SmartAdmin_CreateUserWorkflowTestSC_13 extends TestConfiguration
{
	@DataProvider
	public Object[][] createNewUser_Data()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartAdmin_CreateUser-Workflow.xls", "SmartAdmin_CreateUserSC13TC01");
	}
	
	@Test(dataProvider="createNewUser_Data")
	public void creatNewUserTC_01(String username, String password, String userType, String fullName, String email, String mobileNumber) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(username, password);
		SmartAdmin_DashboardPage sad = new SmartAdmin_DashboardPage(driver);
		Thread.sleep(5000);
		sad.clickOnCreateUser();
		SmartAdmin_CreateUserPage user = new SmartAdmin_CreateUserPage(driver);
		Thread.sleep(3000);
		user.selectUserType(userType);
		user.enterFullName(fullName);
		user.enterEmailAddress(email);
		user.enterMobileNumber(mobileNumber);
		Thread.sleep(3000);
		user.clickOnSubmit();
		Thread.sleep(3000);
		user.clickOnYes();
		Thread.sleep(3000);
		sad.clickOnAllSDMSUser();
		SmartAdmin_AllSDMSUserPage sdmsUser = new SmartAdmin_AllSDMSUserPage(driver);
		Thread.sleep(3000);
		sdmsUser.enterSearchByKeyword(fullName);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Active']")).getText(), "Active");
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(5000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	@DataProvider
	public Object[][] editUser_Data()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartAdmin_CreateUser-Workflow.xls", "SmartAdmin_CreateUserSC13TC02");
	}
	
	@Test(dataProvider="editUser_Data", dependsOnMethods="creatNewUserTC_01")
	public void editUserTC_02(String userName, String passWord, String name, String newName) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(userName, passWord);
		SmartAdmin_DashboardPage sadp = new SmartAdmin_DashboardPage(driver);
		Thread.sleep(5000);
		sadp.clickOnAllSDMSUser();
		SmartAdmin_AllSDMSUserPage suser = new SmartAdmin_AllSDMSUserPage(driver);
		Thread.sleep(3000);
		suser.enterSearchByKeyword(name);
		Thread.sleep(3000);
		suser.clickOnEdit();
		Thread.sleep(3000);
		suser.enterFullName_UserDetails(newName);
		Thread.sleep(5000);
		suser.clickOnSubmit();
		Thread.sleep(3000);
		suser.clickOnYes();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'User Updated successfully')]")).getText(), "User Updated successfully");
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(5000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
	}
	
	@DataProvider
	public Object[][] removeUser()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartAdmin_CreateUser-Workflow.xls", "SmartAdmin_CreateUserSC13TC03");
	}
	
	@Test(dataProvider="removeUser", dependsOnMethods="editUserTC_02")
	public void removeUserTC_03(String sdUserName, String sdPassword, String firstName) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(sdUserName, sdPassword);
		SmartAdmin_DashboardPage sdp = new SmartAdmin_DashboardPage(driver);
		Thread.sleep(5000);
		sdp.clickOnAllSDMSUser();
		SmartAdmin_AllSDMSUserPage sasp = new SmartAdmin_AllSDMSUserPage(driver);
		Thread.sleep(5000);
		sasp.enterSearchByKeyword(firstName);
		Thread.sleep(8000);
		sasp.clickOnRemove();
		Thread.sleep(3000);
		sasp.clickOnYes();
		Thread.sleep(3000);
		sasp.clickOnOK();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='inactive']")).getText(), "inactive");
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(5000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}

}
