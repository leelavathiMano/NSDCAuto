package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.Screenshot;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_TemporaryTraningCentrePage;
import com.nsdc.testConfig.TestConfiguration;

public class SSC_TemporarytrainingCentreCreationSC_09 extends TestConfiguration
{
	
	@DataProvider
	public Object[][] tTcCreationSC01TC01Data()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSCTemporaryTrainingCentreCreationData.xls","TemporaryTrainingCentreCreationSC01TC01");
	}
	
	@Test(dataProvider="tTcCreationSC01TC01Data")
	public void createTemporaryTraningCentreSC09TC01(String sscUsername,String sscPassword,String trainingCentreName, String addressLine, String landmark, String pincode, String villageTownCity, String state, String district, String subDistrict, String trainingCentreCapacity, String contactPersonName, String contactPersonEmail, String contactPersonMobileNumber, String singlePointOfContactPersonName, String singlePointOfContactPersonEmail, String singlePointOfContactPersonMobileNumber,String trainingCentreAvailability,String sector1,String subSector1,String jobRole1,String sector2 ,String subSector2,String jobRole2a,String jobRole2b,String sector3,String subSector3,String jobRole3a,String jobRole3b,String jobRole3c) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		Thread.sleep(12000);
		sscDbP.clickCreateTemporaryTrainingCentre();
		Thread.sleep(4000);
		SSC_TemporaryTraningCentrePage sscTtCP=new SSC_TemporaryTraningCentrePage(driver);
		sscTtCP.enterTrainingCentreNameTextBox(trainingCentreName);
		Thread.sleep(2000);
		sscTtCP.enterAdressLine(addressLine);
		Thread.sleep(2000);
		sscTtCP.enterLandmark(landmark);
		Thread.sleep(2000);
		sscTtCP.enterPincode(pincode);
		Thread.sleep(2000);
		sscTtCP.enterVillageTownCity(villageTownCity);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Country')]]]/div[2]")).getText(), "India");
		sscTtCP.selectState(state);
		Thread.sleep(2000);
		sscTtCP.selectDistrict(district);
		Thread.sleep(4000);
		sscTtCP.selectSubDistrict(subDistrict);
		Thread.sleep(2000);
		sscTtCP.enterTrainingCentreCapacity(trainingCentreCapacity);
		Thread.sleep(2000);
		sscTtCP.enterContactPersonName(contactPersonName);
		Thread.sleep(2000);
		sscTtCP.enterContactPersonEmail(contactPersonEmail);
		Thread.sleep(2000);
		sscTtCP.enterContactPersonMobileNumber(contactPersonMobileNumber);
		Thread.sleep(2000);
		sscTtCP.enterSinglePointOfContactPersonName(singlePointOfContactPersonName);
		Thread.sleep(2000);
		sscTtCP.enterSinglePointOfContactPersonEmail(singlePointOfContactPersonEmail);
		Thread.sleep(2000);
		sscTtCP.enterSinglePointOfContactPersonMobileNumber(singlePointOfContactPersonMobileNumber);
		Thread.sleep(2000);
		//availability of training centre
		if(trainingCentreAvailability.equals("Only For This Sector Skill Council"))
		{
			sscTtCP.clickOnlyForThisSectorSkillCouncil();
			Thread.sleep(6000);
			//adding 3 SubSector&Job Roles
			for(int i=0;i<3;i++)
			{
				sscTtCP.clickAddSubsectorAndJobRoleButton();
				Thread.sleep(4000);
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='form-group m-form__group row']/div[3]")).getText(),sector1);
				Thread.sleep(4000);
				if(i==0)
				{
					sscTtCP.selectSubSector(subSector1);
					Thread.sleep(6000);
					sscTtCP.selectJobRole(jobRole1);
					sscTtCP.clickAddButton();
					Thread.sleep(4000);
					Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='isOpenForAllSSC'])[1]")).isEnabled(), false);
				}
				else if(i==1)
				{
					sscTtCP.selectSubSector(subSector2);
					Thread.sleep(6000);
					sscTtCP.selectJobRole(jobRole2a);
					sscTtCP.selectJobRole(jobRole2b);
					sscTtCP.clickAddButton();
					Thread.sleep(4000);
				}
				else if(i==2)
				{
					sscTtCP.selectSubSector(subSector3);
					Thread.sleep(6000);
					sscTtCP.selectJobRole(jobRole3a);
					sscTtCP.selectJobRole(jobRole3b);
					sscTtCP.selectJobRole(jobRole3c);
					sscTtCP.clickAddButton();
					Thread.sleep(4000);
				}
			}
		}
		
		else if(trainingCentreAvailability.equals("Open For All Sector Skill Council"))
		{
			sscTtCP.clickOpenForAllSectorSkillCouncil();
			Thread.sleep(6000);
			//adding 3 SubSector&Job Roles
			for(int i=0;i<3;i++)
			{
				sscTtCP.clickAddSubsectorAndJobRoleButton();
				Thread.sleep(4000);
				
				if(i==0)
				{
					sscTtCP.selectSector(sector1);
					Thread.sleep(4000);
					sscTtCP.selectSubSector(subSector1);
					Thread.sleep(6000);
					sscTtCP.selectJobRole(jobRole1);
					sscTtCP.clickAddButton();
					Thread.sleep(4000);
					Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='isOpenForAllSSC'])[1]")).isEnabled(), false);
				}
				else if(i==1)
				{
					sscTtCP.selectSector(sector2);
					Thread.sleep(4000);
					sscTtCP.selectSubSector(subSector2);
					Thread.sleep(6000);
					sscTtCP.selectJobRole(jobRole2a);
					sscTtCP.selectJobRole(jobRole2b);
					sscTtCP.clickAddButton();
					Thread.sleep(4000);
					Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='isOpenForAllSSC'])[1]")).isEnabled(), false);
				}
				else if(i==2)
				{
					sscTtCP.selectSector(sector3);
					Thread.sleep(4000);
					sscTtCP.selectSubSector(subSector3);
					Thread.sleep(6000);
					sscTtCP.selectJobRole(jobRole3a);
					sscTtCP.selectJobRole(jobRole3b);
					sscTtCP.selectJobRole(jobRole3c);
					sscTtCP.clickAddButton();
					Thread.sleep(4000);
					Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='isOpenForAllSSC'])[1]")).isEnabled(), false);
				}
			}
		}
		
		sscTtCP.clickConfirmation();
		Thread.sleep(2000);
		//sscTtCP.clickCreate();
		Thread.sleep(2000);
		Screenshot.takeScreenshot(driver, "justCreatedTrainingCenterIDsuccessfullPopup");
		sscTtCP.clickOk();
		Thread.sleep(2000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
				
	}
}
	