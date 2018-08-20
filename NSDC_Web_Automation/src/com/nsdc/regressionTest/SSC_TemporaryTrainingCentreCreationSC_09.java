package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.Screenshot;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_TemporaryTraningCentrePage;
import com.nsdc.testConfig.TestConfiguration;

public class SSC_TemporaryTrainingCentreCreationSC_09 extends TestConfiguration
{
	
	@DataProvider
	public Object[][] sscTemporaryTrainingCentreCreationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01");
	}
	
	@Test(dataProvider="sscTemporaryTrainingCentreCreationData")
	public void createTemporaryTraningCentreSC09TC01(String serialNo,String sscUsername, String sscPassword, String tempTcId, String trainingCentreName, String addressLine, String landmark, String pincode, String villageTownCity, String state, String district, String subDistrict, String trainingCentreCapacity, String contactPersonName, String contactPersonEmail, String contactPersonMobileNumber, String singlePointOfContactPersonName, String singlePointOfContactPersonEmail, String singlePointOfContactPersonMobileNumber,String expectedSector,String subSector1,String jobRole1,String subSector2,String jobRole2a,String jobRole2b,String subSector3,String jobRole3a,String jobRole3b,String jobRole3c) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(12000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl(), configuredURL+"/ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
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
		//adding 3 SubSectors & Job Roles
		for(int i=0;i<3;i++)
		{
			sscTtCP.clickAddSubsectorAndJobRoleButton();
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='form-group m-form__group row']/div[3]")).getText(),expectedSector);
			Thread.sleep(4000);
			if(i==0)
			{
				//Assert.assertTrue(sscTtCP.selectSubSector(subSector1),"this subsector not present");
				sscTtCP.selectSubSector(subSector1);
				Thread.sleep(6000);
				sscTtCP.selectJobRole(jobRole1);
				sscTtCP.clickAddButton();
				Thread.sleep(4000);
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
		sscTtCP.clickConfirmation();
		Thread.sleep(2000);
		sscTtCP.clickCreate();
		Thread.sleep(4000);
		//This assertion is based on the difference in url while creating temporary training centre and after successfull creation of temporary training centre
		Assert.assertEquals(driver.getCurrentUrl(), configuredURL+"/ssc", "TRAINING CENTRE NOT CREATED : Usually becoz of duplicate SPOC Email and Mobile Number, Please check the SSC_Temporary Training Centre Creation Test Data file");
		Screenshot.takeScreenshot(driver, "justCreatedTrainingCenterIDsuccessfullPopup");
		String createdTCID=driver.findElement(By.id("swal2-title")).getText();
		//getting created TC_ID and Writing into Excel
		String[] parts=createdTCID.split(" ");
		String trainingCentreID=parts[parts.length-1];
		int sNum=Integer.parseInt(serialNo);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01",sNum,3, trainingCentreID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls","LocationBasedTC-BatchRejectionSC10TC03",1,11, trainingCentreID);
		Thread.sleep(6000);
		sscTtCP.clickOk();
		Thread.sleep(6000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		lp.clickLogin();
		Thread.sleep(2000);
		elp.performlogin(trainingCentreID, "ekaushal");
		Thread.sleep(2000);
		RegistrationPage rp = new RegistrationPage(driver);
		//plz do not change passwords, as this will affect other test cases
		rp.enterOldPassword("ekaushal");
		rp.enterNewPassword("Qwerty@123"); 
		rp.enterConfirmPassword("Qwerty@123");
		rp.clickResetResubmit();
		Thread.sleep(2000);
		rp.clickConfirmationOkMessage();
		Thread.sleep(2000);
		elp.performlogin(trainingCentreID,"Qwerty@123");
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
			
	}
}
	