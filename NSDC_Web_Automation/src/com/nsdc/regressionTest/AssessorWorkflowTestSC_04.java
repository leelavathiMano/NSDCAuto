package com.nsdc.regressionTest;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.AssessmentAgencyDashboardPage;
import com.nsdc.pages.AssessmentAgencyViewBatchesPage;
import com.nsdc.pages.AssessorApplicantDashboardPage;
import com.nsdc.pages.AssessorApplicantSearchAndApplyForAvailableBatchesPage;
import com.nsdc.pages.AssessorApplicantViewBatchesPage;
import com.nsdc.pages.AssessorDashboardPage;
import com.nsdc.pages.AssessorMyProfilePage;
import com.nsdc.pages.AssessorRegistrationPage;
import com.nsdc.pages.AssessorViewBatchesPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LocationBasedTC_DashboardPage;
import com.nsdc.pages.LocationBasedTC_ViewBatchesPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.SSCAllBatchesPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_LocationBasedTC_TrainingBatchCreationPage;
import com.nsdc.pages.SSC_LocationBasedTraningCentreCreationPage;
import com.nsdc.pages.TrainerDashboardPage;
import com.nsdc.pages.TrainerViewBatchesPage;
import com.nsdc.testConfig.DatabaseConnection;
import com.nsdc.testConfig.TestConfiguration;

public class AssessorWorkflowTestSC_04 extends TestConfiguration
{
	String locationBasedTCName=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation",1,3);
	String locationBasedTCState=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation",1,8);
	String locationBasedTCDistrict=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation",1,9);
	String locationBasedTCSubDistrict=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation",1,10);
	String locationBasedTCSPOCName=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation", 1, 15);
	String locationBasedTCSPOCNMobileNum=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 6);
	String locationBasedTCSPOCEmail=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 5);
	String locationBasedTCAddress=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation", 1, 4);
	String locationBasedTCLandmark=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation", 1, 5);
	String locationBasedTCPincode=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation", 1, 6); 
	String locationBasedTCHeadName=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation", 1, 12); 
	String locationBasedTCHeadPhone=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation", 1, 14); 
	String locationBasedTCHeadEmail=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation", 1, 13); 
	@DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorRegistration");
    }
    
    @Test(dataProvider="registrationData")
    public void assessorRegistrationTC_01(String serialNum,String createdAssessorID,String userType, String name,String tcApproveOrRejectThisAssessorForAssessorTrainingBatch,String tcReasonForRejectingThisAssessorApplicant, String sscApproveOrRejectThisAssessorForAssessorTrainingBatch, String sscReasonForRejectingThisAssessorApplicant, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String jobRole_sector1, String jobRole_subSector1, String jobRole1, String jobRole_sector2, String jobRole_subSector2, String jobRole2, String preferred_state1, String preferred_city1, String preferred_district1, String preferred_state2, String preferred_city2, String preferred_district2, String preferred_state3, String preferred_city3, String preferred_district3) throws Exception
    {
        //DatabaseConnection.deleteAssessor(email);
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
        LoginPage lp = new LoginPage(driver);
        lp.clickRegister();
        Thread.sleep(5000);
        RegistrationPage rp = new RegistrationPage(driver);
        rp.selectDropdownList(userType);
        Thread.sleep(2000);
        rp.enterSPOCName(name);
        Thread.sleep(2000);
        rp.enterEmail(email);
        Thread.sleep(2000);
        rp.enterMobile(mobile);
        Thread.sleep(2000);
        rp.clickIagree();
        Thread.sleep(2000);
        rp.clickRegister();
        Thread.sleep(2000);
        List<WebElement> ele = driver.findElements(By.xpath("//div[@id='toast-container']/div/div"));
		if(ele.size()!=0)
		{
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().trim().startsWith("Duplicate"),"new assessor credentials only");
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElement(By.xpath("//button[contains(text(),'Register')]")).isDisplayed(), "Assessor Registration:Duplicate Email OR Mobile Number!!! ");
		}
		else
		{
			Thread.sleep(2000);
			rp.enterEmailOTP(emailOTP);
			rp.enterMobileOTP(mobileOTP);
        	Thread.sleep(2000);
        	rp.clickVerify();
		}
        Thread.sleep(2000);
        String createdAssessor=driver.findElement(By.xpath("//div[@class='m-login__signin']/h3/span")).getText();
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "AssessorRegistration", Integer.parseInt(serialNum), 1, createdAssessor);
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "SearchAndApplyForBatches", Integer.parseInt(serialNum), 0, createdAssessor);
        String username = driver.findElement(By.xpath("//span[@class='text-bold']")).getText();
        rp.clickGoToLogin();
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, "ekaushal");
        Thread.sleep(2000);
        rp.enterOldPassword(oldPassword);
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "SearchAndApplyForBatches", Integer.parseInt(serialNum), 1, confirmPassword);        
        rp.clickResetResubmit();
        Thread.sleep(2000);
        rp.clickConfirmationOkMessage();
        elp.performlogin(username, confirmPassword);
        Thread.sleep(6000);
         AssessorRegistrationPage assessor = new AssessorRegistrationPage(driver);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).getAttribute("value"), name);
        assessor.selectGender(gender);
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,150)", "");
        assessor.selectDateOfBirth();
        Thread.sleep(4000);
        String selectedDateOfBirth=driver.findElement(By.id("dob")).getAttribute("value");
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "AssessorRegistration", Integer.parseInt(serialNum), 16, selectedDateOfBirth);
         
        if(language.equals("Kannada,English,Hindi"))
        {
            assessor.selectAllLanguages();
        }
        else if(language.equals("Kannada,Hindi"))
        {
        	assessor.selectTwoKnownLanguages();
        }
        else
        {
            assessor.selectAnyKnownLanguage(language);
        }
        Thread.sleep(4000);
        assessor.selectReligion(religion);
        Thread.sleep(2000);
        assessor.selectCategory(category);
        Thread.sleep(2000);
          
        if(disability.equals("None"))
        {
            assessor.selectDisability(disability);
            Thread.sleep(2000);
        }
        else
        {
            assessor.selectDisability(disability);
            Thread.sleep(2000);
            assessor.clickOnBrowseForUploadDisabilityDocument();
            Thread.sleep(2000);
            UploadFile.upload(disabilityFile);
            Thread.sleep(4000);
            assessor.clickOnUploadButtonForUploadDisabilityDocument();
            Thread.sleep(5000);
        }
        
        String aadharPan = aadhaarOrPAN.toLowerCase();
        
        if(aadharPan.equals("aadhaar"))
        {
            assessor.clickOnAadharNumberRadioButton();
            assessor.enterAadharNumber(idNumber);
            Thread.sleep(2000);
            assessor.clickOnValidateAadharNumber();
            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='aadhaarIdentity']/div/span")).getText(), "Verified");
        }
        else if(aadharPan.equals("pan"))
        {
            assessor.clickOnPanNumberRadioButton();
            assessor.enterPanNumber(idNumber);
            Thread.sleep(2000);
            assessor.clickOnBrowseFileButtonForUploadPanDocument();
            Thread.sleep(2000);
            UploadFile.upload(uploadPanDocument);
            Thread.sleep(4000);
            assessor.clickOnUploadButtonToUploadPan();
            Thread.sleep(5000);
        }
        Thread.sleep(2000);
        assessor.clickOnBrowseFileButtonToUploadPhoto();
        Thread.sleep(2000);
        UploadFile.upload(photoFile);
        Thread.sleep(4000);
        assessor.clickOnUploadButtonToUploadPhoto();
        Thread.sleep(5000);
        
        if(applicant_Category.equals("Assessor,Master Assessor"))
        {
            assessor.selectAllApplicantCategory();
        }
        else if(applicant_Category.equals("Assessor") || applicant_Category.equals("Master Assessor"))
        {
            assessor.selectAnyApplicantCategory(applicant_Category);
        }
        Thread.sleep(2000);
        assessor.clickOnSaveAndContinue();
        Thread.sleep(5000);        
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='phone']")).getAttribute("value"), mobile);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='email']")).getAttribute("value"), email);
        assessor.enterApplicantAddress(address);
        Thread.sleep(5000);
        assessor.enterNearbyLandmark(landmark);
        Thread.sleep(2000);
        assessor.enterPincode(pincode);
        Thread.sleep(2000);
        assessor.selectStateOrUnionTerritory(state);
        Thread.sleep(2000);
        assessor.selectDistrictOrCity(city);
        Thread.sleep(2000);
        assessor.selectTehsilOrMandal(mandal);
        Thread.sleep(2000);
        assessor.selectParliamentaryConstituency(parliamentaryConstituency);
        Thread.sleep(2000);
        assessor.clickOnSaveAndContinue();
        Thread.sleep(5000);
        if(education1.equals("Uneducated"))
        {
            assessor.selectEducationAttained(education1);
            Assert.assertTrue(driver.findElements(By.xpath("//label[contains(text(),'Details of Education')]")).size()==0,"OMG!!! Education Details Fields should be hidden in case of Un-Educated Applicant!!! ");
        }
        else
        {
            assessor.selectEducationAttained(education1);
            Thread.sleep(2000);
            assessor.enterDetailsOfEducation(edu_details1);
            Thread.sleep(2000);
            assessor.clickOnBrowseForUploadEducationProofDocument();
            Thread.sleep(2000);
            UploadFile.upload(edu_document1);
            Thread.sleep(4000);
            assessor.clickOnUploadForUploadEducationProofDocument();
            Thread.sleep(5000);
            assessor.clickOnAddEducationDetailsButton();
            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education1+"')]")).getText(), education1);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details1+"')]")).getText(), edu_details1);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[1]")).getText(), "yes");
        }
        if(education2.equals("Uneducated"))
        {
            assessor.selectEducationAttained(education2);
            Assert.assertTrue(driver.findElements(By.xpath("//label[contains(text(),'Details of Education')]")).size()==0,"OMG!!! Education Details Fields should be hidden in case of Un-Educated Applicant!!! ");
        }
        else
        {
            assessor.selectEducationAttained(education2);
            Thread.sleep(2000);
            assessor.enterDetailsOfEducation(edu_details2);
            Thread.sleep(2000);
            assessor.clickOnBrowseForUploadEducationProofDocument();
            Thread.sleep(2000);
            UploadFile.upload(edu_document2);
            Thread.sleep(4000);
            assessor.clickOnUploadForUploadEducationProofDocument();
            Thread.sleep(5000);
            assessor.clickOnAddEducationDetailsButton();
            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education2+"')]")).getText(), education2);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details2+"')]")).getText(), edu_details2);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[2]")).getText(), "yes");
        }
        if(education3.equals("Uneducated"))
        {
            assessor.selectEducationAttained(education3);
            Assert.assertTrue(driver.findElements(By.xpath("//label[contains(text(),'Details of Education')]")).size()==0,"OMG!!! Education Details Fields should be hidden in case of Un-Educated Applicant!!! ");
        }
        else
        {
            assessor.selectEducationAttained(education3);
            assessor.enterDetailsOfEducation(edu_details3);
            assessor.clickOnBrowseForUploadEducationProofDocument();
           	Thread.sleep(2000);
           	UploadFile.upload(edu_document3);
           	Thread.sleep(4000);
           	assessor.clickOnUploadForUploadEducationProofDocument();
           	Thread.sleep(5000);
            assessor.clickOnAddEducationDetailsButton();
            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education3+"')]")).getText(), education3);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details3+"')]")).getText(), edu_details3);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[3]")).getText(), "yes");
            assessor.deleteThirdEducationDetails();
        }
        assessor.selectRelevantSectorForIndustrialExperience(industrial_sector1);
        assessor.selectYearsForIndustrialExperience(industrial_years1);
        assessor.selectMonthsForIndustrialExperience(industrial_months1);
        assessor.enterDetailsOfIndustrialExperience(industrialExperienceDetails1);
        assessor.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails1);
        assessor.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(industrialDocument1);
        Thread.sleep(4000);
        assessor.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(5000);
        assessor.clickOnAddIndustrialExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector1+"')]")).getText(), industrial_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails1+"')]")).getText(), industrialExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[1]")).getText(), "Yes");
        assessor.selectRelevantSectorForIndustrialExperience(industrial_sector2);
        assessor.selectYearsForIndustrialExperience(industrial_years2);
        assessor.selectMonthsForIndustrialExperience(industrial_months2);
        assessor.enterDetailsOfIndustrialExperience(industrialExperienceDetails2);
        assessor.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails2);
        assessor.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(industrialDocument2);
        Thread.sleep(4000);
        assessor.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(5000);
        assessor.clickOnAddIndustrialExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector2+"')]")).getText(), industrial_sector2);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails2+"')]")).getText(), industrialExperienceDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[2]")).getText(), "Yes");
        assessor.selectRelevantSectorForIndustrialExperience(industrial_sector3);
        assessor.selectYearsForIndustrialExperience(industrial_years3);
        assessor.selectMonthsForIndustrialExperience(industrial_months3);
        assessor.enterDetailsOfIndustrialExperience(industrialExperienceDetails3);
        assessor.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails3);
        assessor.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(industrialDocument3);
        Thread.sleep(4000);
        assessor.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(5000);
        assessor.clickOnAddIndustrialExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector3+"')]")).getText(), industrial_sector3);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails3+"')]")).getText(), industrialExperienceDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText(), "Yes");
        if(education1.equals("Uneducated") || education2.equals("Uneducated") || education3.equals("Uneducated"))
        {
            assessor.deleteThirdIndustrialExperienceDetailsWithoutEducationDetail();
        }
        else
        {
            assessor.deleteThirdIndustrialExperienceDetails();
        }
        int totalIndustrialMonths=((Integer.parseInt(industrial_years1)+Integer.parseInt(industrial_years2))*12)+Integer.parseInt(industrial_months1)+Integer.parseInt(industrial_months2);
      	int finalIndustrialMonths=totalIndustrialMonths%12;
    	int finalIndustrialYears=(totalIndustrialMonths-finalIndustrialMonths)/12;
    	if(finalIndustrialMonths==0)
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[1]")).getText(),":"+finalIndustrialYears+" Years 0 months Total Industrial Experience");
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[1]")).getText(),":"+finalIndustrialYears+" Years "+finalIndustrialMonths+" months Total Industrial Experience");
   		}
   	   	assessor.selectRelevantSectorForTrainingExperience(training_sector1);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears1);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths1);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails1);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(trainingDocument1);
        Thread.sleep(4000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(5000);
        assessor.clickOnAddTrainingExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector1+"')]")).getText(), training_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails1+"')]")).getText(), trainingExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText(), "Yes");
        assessor.selectRelevantSectorForTrainingExperience(training_sector2);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears2);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths2);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails2);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(trainingDocument2);
        Thread.sleep(4000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(5000);
        assessor.clickOnAddTrainingExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector2+"')]")).getText(), training_sector2);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails2+"')]")).getText(), trainingExperienceDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[4]")).getText(), "Yes");
        assessor.selectRelevantSectorForTrainingExperience(training_sector3);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears3);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths3);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails3);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(trainingDocument3);
        Thread.sleep(4000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(5000);
        assessor.clickOnAddTrainingExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector3+"')]")).getText(), training_sector3);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails3+"')]")).getText(), trainingExperienceDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[5]")).getText(), "Yes");
        if(education1.equals("Uneducated") || education2.equals("Uneducated") || education3.equals("Uneducated"))
        {
            assessor.deleteThirdTrainingExperienceWithoutEducationDetails();
        }
        else
        {
            assessor.deleteThirdTrainingExperienceDetails();
        }
        int totalTrainingMonths=((Integer.parseInt(trainingExperienceYears1)+Integer.parseInt(trainingExperienceYears2))*12)+Integer.parseInt(trainingExperienceMonths1)+Integer.parseInt(trainingExperienceMonths2);
      	int finalTrainingMonths=totalTrainingMonths%12;
    	int finalTrainingYears=(totalTrainingMonths-finalTrainingMonths)/12;
    	if(finalTrainingMonths==0)
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[2]")).getText(),":"+finalTrainingYears+" Years 0 months Total Training Experience");
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[2]")).getText(),":"+finalTrainingYears+" Years "+finalTrainingMonths+" months Total Training Experience");
    	}
    	assessor.clickOnBrowseForCurriculumVitaeOrResume();
        Thread.sleep(2000);
        UploadFile.upload(resume);
        Thread.sleep(4000);
        assessor.clickOnUploadForCurriculumVitaeOrResume();
        Thread.sleep(5000);
        assessor.clickOnSaveAndContinue();
        Thread.sleep(5000);
        assessor.clickOn_PreferredJobRole();
        Thread.sleep(2000);
        assessor.selectSectorForJobRole(jobRole_sector1);
        assessor.selectSubSectorForJobRole(jobRole_subSector1);
        assessor.select_JobRole(jobRole1);
        assessor.clickOnAddForPreferredJobRole();
        Thread.sleep(2000);
        assessor.clickOnDeletePreferredJobRole();
        Thread.sleep(2000);
        assessor.clickOn_PreferredJobRole();
        Thread.sleep(2000);
        assessor.selectSectorForJobRole(jobRole_sector2);
        ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "SearchAndApplyForBatches",Integer.parseInt(serialNum),6,jobRole_sector2);
        assessor.selectSubSectorForJobRole(jobRole_subSector2);
        ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "SearchAndApplyForBatches",Integer.parseInt(serialNum),7,jobRole_subSector2);
        assessor.select_JobRole(jobRole2);
        ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "SearchAndApplyForBatches",Integer.parseInt(serialNum),8,jobRole2);
        Thread.sleep(2000);
        assessor.clickOnAddForPreferredJobRole();
        Thread.sleep(2000);
        assessor.clickOn_AddPreferredLocation();
        Thread.sleep(2000);
        assessor.selectPreferredStateOrUnionTerritory(preferred_state1);
        assessor.selectPreferredDistrictOrCity(preferred_city1);
        assessor.selectPreferredSubDistrictOrTehsil(preferred_district1);
        assessor.clickOnAddForPreferredLocation();
        Thread.sleep(2000);
        assessor.clickOn_AddPreferredLocation();
        Thread.sleep(2000);
        assessor.selectPreferredStateOrUnionTerritory(preferred_state2);
        assessor.selectPreferredDistrictOrCity(preferred_city2);
        assessor.selectPreferredSubDistrictOrTehsil(preferred_district2);
        assessor.clickOnAddForPreferredLocation();
        Thread.sleep(2000);
        assessor.clickOn_AddPreferredLocation();
        Thread.sleep(2000);
        assessor.selectPreferredStateOrUnionTerritory(preferred_state3);
        assessor.selectPreferredDistrictOrCity(preferred_city3);
        assessor.selectPreferredSubDistrictOrTehsil(preferred_district3);
        assessor.clickOnAddForPreferredLocation();
        Thread.sleep(2000);
        assessor.clickOnDeleteThirdPreferredLocation();
        assessor.clickOnSaveAndContinue();
        Thread.sleep(5000);
        assessor.clickIAgreeCheckbox();
        Thread.sleep(2000);
        assessor.clickSubmitButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Thank You']")).getText(), "Thank You");
        assessor.clickLogOutButton();
        Thread.sleep(2000);
        String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", ""),"Logout Unsuccessful");
      }
       
    @Test(dataProvider="registrationData",dependsOnMethods="assessorRegistrationTC_01")
    public void assessorMyProfileVerificationTC_02(String serialNum,String createdAssessorID,String userType, String name,String tcApproveOrRejectThisAssessorForAssessorTrainingBatch,String tcReasonForRejectingThisAssessorApplicant, String sscApproveOrRejectThisAssessorForAssessorTrainingBatch, String sscReasonForRejectingThisAssessorApplicant, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String jobRole_sector1, String jobRole_subSector1, String jobRole1, String jobRole_sector2, String jobRole_subSector2, String jobRole2, String preferred_state1, String preferred_city1, String preferred_district1, String preferred_state2, String preferred_city2, String preferred_district2, String preferred_state3, String preferred_city3, String preferred_district3) throws Exception
    {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
    	LoginPage lp=new LoginPage(driver);
    	lp.clickLogin();
    	EnterLoginPage elp=new EnterLoginPage(driver);
    	elp.performlogin(createdAssessorID, confirmPassword);
    	Thread.sleep(2000);
    	AssessorMyProfilePage aMpP=new AssessorMyProfilePage(driver);
    	aMpP.clickProfile();
    	Thread.sleep(2000);
    	Assert.assertEquals(aMpP.getNameOfTheApplicant(),name);
    	Assert.assertEquals(aMpP.getGenderOfApplicant(), gender);
    	Assert.assertEquals(aMpP.getDateOfBirth(), dob);
    	Select select1=new Select(driver.findElement(By.xpath("//div[label[contains(text(),'Languages Known:')]]/div/select")));
		List<WebElement> selectedLanguages=select1.getAllSelectedOptions();
		if(selectedLanguages.size()==1)
		{
			String selectedLanguage1=selectedLanguages.get(0).getText();
			Assert.assertEquals(selectedLanguage1, language);
		}
		else if(selectedLanguages.size()==2)
		{
			String selectedLanguage1=selectedLanguages.get(0).getText();
	    	String selectedLanguage2=selectedLanguages.get(1).getText();
	    	Assert.assertEquals((selectedLanguage1+","+selectedLanguage2), language);
		}
		else if(selectedLanguages.size()==3)
		{
			String selectedLanguage1=selectedLanguages.get(0).getText();
	    	String selectedLanguage2=selectedLanguages.get(1).getText();
	    	String selectedLanguage3=selectedLanguages.get(2).getText();
	    	Assert.assertEquals((selectedLanguage1+","+selectedLanguage2+","+selectedLanguage3), language);
		}
		Assert.assertEquals(aMpP.getReligion(), religion);
    	Assert.assertEquals(aMpP.getCategory(), category);
    	Assert.assertEquals(aMpP.getDisability(), disability);
    	String aadharPan = aadhaarOrPAN.toLowerCase();
        if(aadharPan.equals("aadhaar"))
        {
        	Assert.assertEquals(aMpP.getAadharNumVerificationStatus(), "Verified");
        }
        else if(aadharPan.equals("pan"))
        {
        	Assert.assertEquals(aMpP.getPanNumVerificationStatus(), "Verified");
        }
    	Thread.sleep(2000);
    	aMpP.clickBrowseFile();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(4000);
    	aMpP.clickUploadfile();
    	Thread.sleep(4000);
    	Select select2=new Select(driver.findElement(By.xpath("//div[label[contains(text(),'Select Applicant Category:')]]/div/select")));
    	List<WebElement> selectedApplicantCategories=select2.getAllSelectedOptions();
    	if(selectedApplicantCategories.size()==1)
    	{
    		Assert.assertEquals(selectedApplicantCategories.get(0).getText(), applicant_Category);
    	}
    	else if(selectedApplicantCategories.size()==2)
    	{
    		Assert.assertEquals(selectedApplicantCategories.get(0).getText()+","+selectedApplicantCategories.get(1).getText(), applicant_Category);
    	}
    	aMpP.clickSaveChanges1();
    	Thread.sleep(4000);
    	//Assessor Contact and Address verification
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,-1000)","");
    	Thread.sleep(2000);
    	aMpP.clickContactAndAddress();
    	Thread.sleep(4000);
    	Assert.assertEquals(aMpP.getMobileNumOfApplicant(), mobile);
    	Assert.assertEquals(aMpP.getEmailOfApplicant(), email);
    	Assert.assertEquals(aMpP.getAddressOfApplicant(), address);
    	Assert.assertEquals(aMpP.getNearByLandMark(), landmark);
    	Assert.assertEquals(aMpP.getPincode(), pincode);
    	Assert.assertEquals(aMpP.getState(), state);
    	Assert.assertEquals(aMpP.getDistrict(), city);
    	Assert.assertEquals(aMpP.getTehsil(), mandal);
    	Assert.assertEquals(aMpP.getParlimentaryConstituency(), parliamentaryConstituency);
    	//Education & Work verification
    	Thread.sleep(2000);
    	aMpP.clickEducationAndWork();
    	Thread.sleep(2000);
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
        {
    		Assert.assertTrue(driver.findElement(By.xpath("(//table[@class='table table-striped'])[1]/tbody")).getText().equalsIgnoreCase("No records found"));
        }
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+education1+"']")).getText().trim(), education1);
    		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
    	    Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[1]")).getText().trim(), "Yes");
    	    //Education Record 2
    	    Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+education2+"']")).getText().trim(), education2);
    	    Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
    	    Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[2]")).getText().trim(), "Yes");
    	 }
    	//Checking UnEducated Option
        aMpP.clickToAddEducationDetails();
    	Thread.sleep(2000);
    	aMpP.selectEducationAttained("Uneducated");
    	Thread.sleep(2000);
    	Assert.assertTrue(driver.findElements(By.xpath("//label[contains(text(),'Details of Education:')]")).size()==0, "OMG!!! Education Details Fields should be hidden in case of UnEducated!! ");
    	aMpP.clickToSubmitEducationDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table table-striped'])[1]/tbody")).getText(), "No record found");
    	//Adding 3rd Education Record(1st education record in case of uneducated candidate while registering and Deletion
    	aMpP.selectEducationAttained("Others");
    	Thread.sleep(2000);
    	Assert.assertFalse(driver.findElements(By.xpath("//label[contains(text(),'Details of Education:')]")).size()==0, "OMG!!! Education Details Fields should be displayed in case of Other Education Attained Type!! ");
    	aMpP.enterDetailsOfEducation("Others Education Selected");
    	Thread.sleep(2000);
    	aMpP.clickToBrowseForEducationProofDocument();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(5000);
    	aMpP.clickToUploadSelectedEducationProofDoc();
    	Thread.sleep(5000);
    	aMpP.clickToSubmitEducationDetails();
    	Thread.sleep(2000);
    	Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'Others')]")).size()!=0,"OMG!!! No show of Added Educational Record for Profile of "+createdAssessorID+" !!! ");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Others')]")).getText().trim(), "Others");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Others Education Selected')]")).getText().trim(), "Others Education Selected");
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[1]")).getText().trim(), "Yes");
    		aMpP.clickToDeleteAddedFirstEducationDetailsRecord();
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText().trim(), "Yes");
    		aMpP.clickToDeleteThirdEducationDetailsRecord();
    	}
    	Thread.sleep(4000);
    	Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'Others')]")).size()==0,"OMG!!! Deleted Education Details Record present itseems!!! Or Something wrong!!! ");
    	//Industrial Records
    	int totalIndustrialMonths=((Integer.parseInt(industrial_years1)+Integer.parseInt(industrial_years2))*12)+Integer.parseInt(industrial_months1)+Integer.parseInt(industrial_months2);
       	int finalIndustrialMonths=totalIndustrialMonths%12;
     	int finalIndustrialYears=(totalIndustrialMonths-finalIndustrialMonths)/12;
     	if(finalIndustrialMonths==0)
     	{
     		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[1]")).getText(),finalIndustrialYears+" years Total Training Experience");
     	}
     	else
     	{
     		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[1]")).getText(),finalIndustrialYears+" years "+finalIndustrialMonths+" months Total Training Experience");	
     	}
     	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrial_sector1+"')])[1]")).getText().trim(), industrial_sector1);
       	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrialExperienceDetails1+"')])[1]")).getText().trim(), industrialExperienceDetails1);
       	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
       	{
       		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[3]/td[4]")).getText().trim(), industrial_years1+" "+"Year"+" "+industrial_months1+" "+"months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[1]")).getText().trim(), "Yes");
       	}
       	else
       	{
       		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[5]/td[4]")).getText().trim(), industrial_years1+" "+"Year"+" "+industrial_months1+" "+"months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText().trim(), "Yes");
       	}
    	//industrial record 2
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector2+"')]")).getText().trim(), industrial_sector2);
    	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrialExperienceDetails2+"')])[2]")).getText().trim(), industrialExperienceDetails2);
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
       	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[4]/td[4]")).getText().trim(), industrial_years2+" "+"Year"+" "+industrial_months2+" "+"months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[2]")).getText().trim(), "Yes");
       	}
       	else
       	{
       		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[6]/td[4]")).getText().trim(), industrial_years2+" "+"Year"+" "+industrial_months2+" "+"months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[4]")).getText().trim(), "Yes");
        }
    	//Adding 3rd industrial record and deleting
    	aMpP.clickToAddIndustrialExperienceDetails();
    	Thread.sleep(2000);
    	aMpP.selectIndustrialSector();
    	Thread.sleep(2000);
    	aMpP.selectIndustrialYears();
    	Thread.sleep(2000);
    	aMpP.selectIndustrialMonths();
    	Thread.sleep(2000);
    	aMpP.enterDetailsOfIndustrialExperience();
    	Thread.sleep(2000);
    	aMpP.clickToBrowseForIndustrilExperienceProofDocument();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(5000);
    	aMpP.clickToUploadSelectedIndustrialExperienceProofDoc();
    	Thread.sleep(5000);
    	aMpP.clickToSubmitIndustrialExperienceDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Apparel')]")).getText().trim(), "Apparel");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Industrial Experience in Apparel Sector')]")).getText().trim(), "Industrial Experience in Apparel Sector");
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
       	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[5]/td[4]")).getText().trim(), "11 months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText().trim(), "Yes");
        	aMpP.clickToDeleteAddedThirdIndustrialExperienceDetailsRecordInCaseOfUneducated();
       	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[7]/td[4]")).getText().trim(), "11 months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[5]")).getText().trim(), "Yes");
        	aMpP.clickToDeleteThirdIndustrialExperienceDetailsRecord();
    	}
    	
    	Thread.sleep(4000);
    	Assert.assertTrue(driver.findElements(By.xpath("//td[text()='3']")).size()==0,"OMG!!! Deleted 3rd Industrial Experience Details Record present itseems!!! Or Something wrong!!! ");
    	//Training Records
    	int totalTrainingMonths=((Integer.parseInt(trainingExperienceYears1)+Integer.parseInt(trainingExperienceYears2))*12)+Integer.parseInt(trainingExperienceMonths1)+Integer.parseInt(trainingExperienceMonths2);
       	int finalTrainingMonths=totalTrainingMonths%12;
     	int finalTrainingYears=(totalTrainingMonths-finalTrainingMonths)/12;
     	if(finalTrainingMonths==0)
     	{
     		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[2]")).getText(),finalTrainingYears+" Years Total Training Experience");
     	}
     	else
     	{
     		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[2]")).getText(),finalTrainingYears+" Years "+finalTrainingMonths+" months Total Training Experience");
     	}
     	
    	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+training_sector1+"')])[2]")).getText().trim(), training_sector1);
    	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+trainingExperienceDetails1+"')])[1]")).getText().trim(), trainingExperienceDetails1);
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
       	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[6]/td[4]")).getText().trim(), trainingExperienceYears1+" "+"Year"+" "+trainingExperienceMonths1+" "+"months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText().trim(), "Yes");
       	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[8]/td[4]")).getText().trim(), trainingExperienceYears1+" "+"Year"+" "+trainingExperienceMonths1+" "+"months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[5]")).getText().trim(), "Yes");
    	}
    	//training record 2
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector2+"')]")).getText().trim(), training_sector2);
    	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+trainingExperienceDetails2+"')])[1]")).getText().trim(), trainingExperienceDetails2);
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
       	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[7]/td[4]")).getText().trim(), trainingExperienceYears2+" "+"Year"+" "+trainingExperienceMonths2+" "+"months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[4]")).getText().trim(), "Yes");
       	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[9]/td[4]")).getText().trim(), trainingExperienceYears2+" "+"Year"+" "+trainingExperienceMonths2+" "+"months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[6]")).getText().trim(), "Yes");
    	}
    	Thread.sleep(2000);
    	//3rd Training Experience Details Record Adding and Deleting
    	aMpP.clickToAddTrainingExperienceDetails();
    	Thread.sleep(2000);
    	aMpP.selectTrainingSector();
    	Thread.sleep(2000);
    	aMpP.selectTrainingYears();
    	Thread.sleep(2000);
    	aMpP.selectTrainingMonths();
    	Thread.sleep(2000);
    	aMpP.enterDetailsOfTrainingExperience();
    	Thread.sleep(2000);
    	aMpP.clickToBrowseForTrainingExperienceProofDocument();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(5000);
    	aMpP.clickToUploadSelectedTrainingExperienceProofDoc();
    	Thread.sleep(5000);
    	aMpP.clickToSubmitTrainingExperienceDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Apparel')]")).getText().trim(), "Apparel");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Training Experience in Apparel Sector')]")).getText().trim(), "Training Experience in Apparel Sector");
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
       	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[8]/td[4]")).getText().trim(), "11 months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[5]")).getText().trim(), "Yes");
        	aMpP.clickToDeleteAddedThirdTrainingExperienceDetailsRecordInCaseOfUneducated();
        }
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//tr)[10]/td[4]")).getText().trim(), "11 months");
        	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[7]")).getText().trim(), "Yes");
        	aMpP.clickToDeleteThirdTrainingExperienceDetailsRecord();
    	}
    	Thread.sleep(4000);
    	Assert.assertTrue(driver.findElements(By.xpath("//td[text()='3']")).size()==0,"OMG!!! Deleted 3rd Training Experience Details Record present itseems!!! Or Something wrong!!! ");
    	aMpP.clickCurriculumVitaeBrowse();
    	Thread.sleep(2000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(4000);
    	aMpP.clickCurriculumVitaeUpload();
    	Thread.sleep(4000);
    	aMpP.clickSaveChanges2();
    	Thread.sleep(4000);
    	js.executeScript("window.scrollBy(0,-1500)","");
    	Thread.sleep(2000);
    	aMpP.clickMyAssociations();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='m-datatable__body']/span")).getText(), "No Associations with any Assessment Agency is found");
    	PostLoginPage plp=new PostLoginPage(driver);
    	plp.clickOnProfileLogo();
    	Thread.sleep(2000);
    	plp.clickOnLogout();
    	Thread.sleep(2000);
    }
    @DataProvider()
    public Object[][] locationBasedTrainingCentreForAssessorBatchesData()
    {
    	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation");
    }
    @Test(dataProvider="locationBasedTrainingCentreForAssessorBatchesData",dependsOnMethods="assessorMyProfileVerificationTC_02")
    public void createLocationBasedTrainingCentreForAssessorTrainingBatchesTC_03(String sscUsername, String sscPassword, String createdLocationBasedTrainingCentreID, String trainingCentreName, String addressLine, String landmark, String pincode, String villageTownCity, String state, String district, String subDistrict, String trainingCentreCapacity, String contactPersonName, String contactPersonEmail, String contactPersonMobileNumber, String singlePointOfContactPersonName, String singlePointOfContactPersonEmail, String singlePointOfContactPersonMobileNumber, String expectedSector, String subSector, String jobRole) throws Exception
    {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(12000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickCreateTemporaryTrainingCentre();
		Thread.sleep(4000);
		SSC_LocationBasedTraningCentreCreationPage sscTtCP=new SSC_LocationBasedTraningCentreCreationPage(driver);
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
		sscTtCP.clickAddSubsectorAndJobRoleButton();
		Thread.sleep(4000);
		sscTtCP.selectSubSector(subSector);
		Thread.sleep(6000);
		sscTtCP.selectJobRole(jobRole);
		sscTtCP.clickAddButton();
		Thread.sleep(4000);
		sscTtCP.clickConfirmation();
		Thread.sleep(2000);
		sscTtCP.clickCreate();
		Thread.sleep(4000);
		String createdTCID=driver.findElement(By.id("swal2-title")).getText();
		//getting created TC_ID and Writing into Excel
		String[] parts=createdTCID.split(" ");
		String trainingCentreID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation",1,2, trainingCentreID);
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
    
    @DataProvider()
    public Object[][] assessorTrainingBatchesData()
    {
    	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches");
    }
    @Test(dataProvider="assessorTrainingBatchesData",dependsOnMethods="createLocationBasedTrainingCentreForAssessorTrainingBatchesTC_03")
    public void assessorTrainingBatchesForAssessorApplicantsTC_04(String serialNo, String createdAssessorBatchID, String assessorBatchStartDate, String assessorBatchEndDate, String assessorBatchAssessmentStartDate, String assessorBatchAssessmentEndDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String masterTrainerName, String masterTrainerID, String masterTrainerPassword, String assessmentAgency, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword) throws Exception
    {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
    	LoginPage lp=new LoginPage(driver);
    	lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		sscDbP.clickCreateBatch();
		Thread.sleep(2000);
		SSC_LocationBasedTC_TrainingBatchCreationPage sscTbcP=new SSC_LocationBasedTC_TrainingBatchCreationPage(driver);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+expectedSector+"')]")).getText(), expectedSector);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(2000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(2000);
		sscTbcP.selectJobRole(jobRole);
		Thread.sleep(3000);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			sscTbcP.selectTrainingStartDateForNewBatch();
			sscTbcP.clickToCloseTrainingStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectTrainingEndDateForNewBatch();
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmentStartDateForNewBatch();
			sscTbcP.clickToCloseAssessmentStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmenEndDateForNewBatch();
			sscTbcP.clickToCloseAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			sscTbcP.selectTrainingStartDateForExistingBatch();
			sscTbcP.clickToCloseTrainingStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectTrainingEndDateForExistingBatch();
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmentStartDateForExistingBatch();
			sscTbcP.clickToCloseAssessmentStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmenEndDateForExistingBatch();
			sscTbcP.clickToCloseAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		
		String expectedTrainingStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[1]")).getAttribute("value");
		String expectedTrainingStartDateHipen=expectedTrainingStartDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),2,expectedTrainingStartDateHipen);
		String expectedTrainingEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String trainingEndDateHipen=expectedTrainingEndDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),3,trainingEndDateHipen);
		String expectedAssessmentStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[2]")).getAttribute("value").replaceAll("/", "-");		
		String assessmentStartDateHipen=expectedAssessmentStartDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),4,assessmentStartDateHipen);
		String expectedAssessmentEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[2]")).getAttribute("value");
		String expectedAssessmentEndDateHipen=expectedAssessmentEndDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),5,expectedAssessmentEndDateHipen);
		
		sscTbcP.clickToCreateBatch();
		Thread.sleep(2000);
		String bacthCreationsuccessfulPopupText=driver.findElement(By.xpath("//div[@class='swal2-content']")).getText();
		String[]parts=bacthCreationsuccessfulPopupText.split(" ");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),1,createdBatchID);
		sscTbcP.clickOk();
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		sscTbcP.selectState(locationBasedTCState);
		Thread.sleep(2000);
		sscTbcP.selectDistrict(locationBasedTCDistrict);
		Thread.sleep(2000);
		sscTbcP.selectSubDistrict(locationBasedTCSubDistrict);
		Thread.sleep(4000);
		sscTbcP.clickToSearchAndAssignTrainingCentre();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2, "Sorry! There are no Training Centres found for your search!!! ");
		String locationBasedTCID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation",1,2);
		sscTbcP.enterToSearchForTrainingCentreID(locationBasedTCID);
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+locationBasedTCID+"']")).size()==0, "Sorry! The Training Centre - "+locationBasedTCID+" You Are Searching is Not Found For This "+sscUsername+" In This Server!!! ");
		sscTbcP.clickActionMenu();
		sscTbcP.clickAssignBatch();
		Thread.sleep(4000);
		sscTbcP.clickToAssignTrainingCentre();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		lp.clickLogin();
		Thread.sleep(2000);
		elp.performlogin(locationBasedTCID, "Qwerty@123");
		Thread.sleep(4000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(4000);
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG! Batch - "+createdBatchID+" not found in Newly Assigned Section of "+locationBasedTCID+" !!! ");		
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clickToSelectAcceptOrRejectBatchOption();
		Thread.sleep(2000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(2000);
		lTcVbP.clickToSaveAndSubmit();
		Thread.sleep(2000);
		lTcVbP.clickOk();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-200)","");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
			
		lp.clickLogin();
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches");
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewPublishedBatches();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,150)", "");
		sBp.enterSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Not Found in Published Section of "+sscUsername+" !!! ");
		sBp.clickToViewActionMenuOptions();
		Thread.sleep(2000);
		sBp.clicktoSelectViewBatchDetailsOption();
		Thread.sleep(4000);
		sBp.selectMasterTrainerForSEDJobrole(masterTrainerName);
		Thread.sleep(2000);
		sBp.clickToAssignMasterTrainer();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+masterTrainerID+".");
		sBp.clickOk();
		Thread.sleep(2000);
		sBp.selectAssessmentAgencyForSEDJobRole(assessmentAgency);
		Thread.sleep(2000);
		sBp.clickToAssignAssessmentAgency();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+assessmentAgency+".");
		sBp.clickOk();
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		//Assigned Master Trainer Login To Accept the Batch
		lp.clickLogin();
		elp.performlogin(masterTrainerID, masterTrainerPassword);
		Thread.sleep(2000);
		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
		tDp.clickToGetTrainerDashboard();
		Thread.sleep(2000);
		tDp.clickViewBatches();
		Thread.sleep(2000);
		TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
		tVp.clicktoGoToNewlyAssignedBatchesSection();
		Thread.sleep(2000);
		tVp.enterBatchStartDateToSearch(expectedTrainingStartDateHipen);
		Thread.sleep(2000);
		tVp.clickToCloseBatchStartDateCalender();
		Thread.sleep(2000);
		tVp.enterBatchEndDateToSearch(expectedAssessmentEndDateHipen);
		Thread.sleep(2000);
		tVp.clickToCloseBatchEndDateCalender();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! No show of matching Batch - "+createdBatchID+" for Batch Dates: "+expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen+" in Newly-Assigned Section of "+masterTrainerID+" !!! ");
		tVp.enterTrainingCentreNameToSearch(locationBasedTCName);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! No show of matching Batc - "+createdBatchID+" for this training centre - "+locationBasedTCName+" in Newly-Assigned Section of "+masterTrainerID+" !!! ");
		tVp.clickToViewFilterByBatchTypeListOptions();
		Thread.sleep(2000);
		ArrayList<WebElement>batchTypesFilter=(ArrayList<WebElement>)driver.findElements(By.xpath("(//ul[@class='lazyContainer'])[1]/span/li/label[2]"));
		for(int i=0;i<batchTypesFilter.size();i++)
		{
			while(batchTypesFilter.get(i).getText().equalsIgnoreCase(batchType))
			{
				batchTypesFilter.get(i).click();
				Thread.sleep(2000);
				tVp.clickToCloseFilterByBatchTypeList();
				Thread.sleep(2000);
				Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! Batch - "+createdBatchID+" of Type - "+batchType+" is not found in Newly-Assigned Section of "+masterTrainerID+" !!!");
			}
		}
		ArrayList<WebElement>resultedBatchIDs=(ArrayList<WebElement>)driver.findElements(By.xpath("//tr/td[contains(text(),'"+createdBatchID+"')]"));
		Assert.assertTrue(resultedBatchIDs.size()!=0,"OMG!!! The Batch - "+createdBatchID+" is not found in NewLy-Assigned Section of "+masterTrainerID+" !!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+createdBatchID+"']")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[4]")).getText().trim(), locationBasedTCName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[6]")).getText().trim(), locationBasedTCState );
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[7]")).getText().trim(), locationBasedTCDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[8]")).getText().trim(), expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[9]/span")).getText().trim(), "New");
		tVp.clickToGetActionMenuOptions(createdBatchID);
		Thread.sleep(2000);
		tVp.clickToChooseAcceptOrRejectBatchOption();
		Thread.sleep(2000);
		tVp.clickToAcceptBatch();
		Thread.sleep(2000);
		tVp.clickToSaveAndSubmit();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "Sorry!! Accepted Successfully Message Popup Not Displayed");
		tVp.clickOk();
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		//Assigned Assessment Agency Login to Accept and assigning master assessors for a batch
		lp.clickLogin();
		elp.performlogin(assessmentAgency, assessmentAgencyPassword);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagency","Login Unsuccessful!!! ");
		AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
		Thread.sleep(4000);
		aDp.clickToViewBatches();
		Thread.sleep(2000);
		AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
		aVp.clickToViewNewlyAssignedBatches();
		Thread.sleep(2000);
		aVp.enterBatchIdToSearch(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! No show of batch - "+createdBatchID+" in "+assessmentAgency+" Newly Assigned section!!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+createdBatchID+"']")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedTrainingStartDateHipen+"')]")).getText().trim(), expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen );
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/span")).getText().trim(), "BATCH CREATED");
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(2000);
		aVp.clickToChooseAcceptOrRejectBatchOption();
		Thread.sleep(2000);
		aVp.clickToAcceptBatch();
		Thread.sleep(4000);
		aVp.clickToSaveAndSubmit();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "Sorry!! Accepted Successfully Message Popup Not Displayed");
		aVp.clickOk();
		Thread.sleep(2000);	
		//verifying accepted batches & assigning assessors
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
		aVp.clickToViewAcceptedBatches();
		Thread.sleep(4000);
		aVp.enterBatchIdToSearch(createdBatchID);
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! The Batch - "+createdBatchID+" is not found in Accepted Section!!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+createdBatchID+"']")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedTrainingStartDateHipen+"')]")).getText().trim(), expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen );
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToChooseAssignAssessorsActionMenuOption();
		Thread.sleep(2000);
		ArrayList<WebElement>assessorsListed=(ArrayList<WebElement>)driver.findElements(By.xpath("//select[@formcontrolname='assessor']/option"));
		Assert.assertTrue(assessorsListed.size()>1,"OMG!!!! there are no master assessors available for: "+assessmentAgency+ "<-> "+createdBatchID+" batch!!! ");
		aVp.selectAssessorsToBeAssignedForBatches(masterAssessorID);
		Thread.sleep(2000);
		aVp.clickToSaveAndSubmit();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "OMG!! Master Assessor Assigned Successfully Message Popup Not Displayed");
		aVp.clickOk();
		Thread.sleep(2000);		
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//Assigned Master Assessor Login and Approving batches
		lp.clickLogin();
		elp.performlogin(masterAssessorID, masterAssessorPassword);
		Thread.sleep(2000);
		AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
		maDp.clickToGetTrainerDashboard();
		Thread.sleep(2000);
		maDp.clickViewBatches();
		Thread.sleep(2000);
		AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
		maVp.clicktoGoToNewlyAssignedBatchesSection();
		Thread.sleep(2000);
		maVp.enterBatchStartDateToSearch(expectedTrainingStartDateHipen);
		Thread.sleep(2000);
		maVp.clickToCloseBatchStartDateCalender();
		Thread.sleep(2000);
		maVp.enterBatchEndDateToSearch(expectedAssessmentEndDateHipen);
		Thread.sleep(2000);
		maVp.clickToCloseBatchEndDateCalender();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! No show of matching Batch - "+createdBatchID+" for Batch Dates: "+expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen+" in Newly-Assigned Section of "+masterAssessorID+" !!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+createdBatchID+"']")).getText().trim(), createdBatchID);
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]")));		                         
		maVp.clickToGetActionMenuOptions(createdBatchID);
		Thread.sleep(4000);
		maVp.clickToChooseAcceptOrRejectBatchOption(createdBatchID);
		Thread.sleep(2000);
		maVp.clickToAcceptBatch();
		Thread.sleep(2000);
		maVp.clickToSaveAndSubmit();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "Sorry!! Accepted Successfully Message Popup Not Displayed");
		maVp.clickOk();
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
    }
    
   @DataProvider
   public Object[][] assessorSearchAndApplyForAvailableBatchData()
   {
	   return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls","SearchAndApplyForBatches");
   }
   @Test(dataProvider="assessorSearchAndApplyForAvailableBatchData",dependsOnMethods="assessorTrainingBatchesForAssessorApplicantsTC_04")
   public void assessorSearchAndApplyForAvailableBatchTC_05(String assessorUsername, String assessorPassword, String searchByEnteringMandatoryFieldsOrAll,String state, String district, String subDistrict, String sector, String subSector, String jobrole, String batchTypeForSearch, String batchStatus,String actionDropdownMenuOption) throws Exception
   {
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   LoginPage lp=new LoginPage(driver);
	   lp.clickLogin();
	   Thread.sleep(2000);
	   EnterLoginPage elp=new EnterLoginPage(driver);
	   elp.performlogin(assessorUsername, assessorPassword);
	   String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	   AssessorApplicantDashboardPage aDp=new AssessorApplicantDashboardPage(driver);
	   Thread.sleep(2000);
	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
	   aDp.clickToGetApplicantDashboard();
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)", "");
	   Thread.sleep(2000);
	   Assert.assertFalse(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase(""),"please provide search option : mandatory or all fields in respected excel sheet");
	   aDp.clickSearchAndApplyforAvailableBatches();
	   Thread.sleep(2000);
	   AssessorApplicantSearchAndApplyForAvailableBatchesPage aSp=new AssessorApplicantSearchAndApplyForAvailableBatchesPage(driver);
	   if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("mandatory"))
	   {
		   aSp.selectState(state);
		   Thread.sleep(2000);
		   aSp.selectSector(sector);
		   Thread.sleep(2000);
	   }
	   else if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields"))
	   {
		   aSp.selectState(state);
		   Thread.sleep(2000);
		   aSp.selectDistrict(district);
		   Thread.sleep(2000);
		   aSp.selectSubDistrict(subDistrict);
		   Thread.sleep(2000);
		   aSp.selectSector(sector);
		   Thread.sleep(2000);
		   aSp.selectSubSector(subSector);
		   Thread.sleep(2000);
		   aSp.selectjobRole(jobrole);
		   Thread.sleep(6000);
		   aSp.selectBatchType(batchTypeForSearch);
		   Thread.sleep(2000);
		   aSp.selectBatchStatus(batchStatus);
		   Thread.sleep(6000);
		   aSp.enterBatchStartDate();
		   Thread.sleep(6000);
		   aSp.clickToCloseBatchStartDateCalender();
		   Thread.sleep(2000);
		   aSp.enterBatchEndDate();
		   Thread.sleep(6000);
		   aSp.clickToCloseBatchEndDateCalender();
		   Thread.sleep(2000);
	   }
	   Thread.sleep(6000);
	   aSp.clickSearch();
	   Thread.sleep(2000);
	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""),configuredURL.replaceAll("/", "")+"assessorapplicantapply-for-batchsearch-results");
	   Assert.assertTrue(driver.findElements(By.tagName("tr")).size()>1,"Sorry! There are no resulted batch records for your search!!! ");
	   for(int i=1;i<4;i++)
	   {
		   String batchID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 1);
		   String batchType=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 10);
		   aSp.enterSearchKeyword(batchID);
		   Thread.sleep(2000);
		   if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields") && !batchType.equalsIgnoreCase(batchTypeForSearch))
		   {
			   Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!! There should be no result in case of Assessor applicant searched batch type - "+batchTypeForSearch+" and created batch type - "+batchType+" mismatch!!! ");
		   }
		   else
		   {
			   Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"Sorry!! Batch - "+batchID+" Not Found!!! ");
			   aSp.clickAction();
			   Thread.sleep(2000);
			   if(actionDropdownMenuOption.equals("View Details"))
			   {
				   aSp.selectViewDetails();
				   Thread.sleep(4000);
				   
				   Assert.assertEquals(driver.findElement(By.xpath("//input[@name='spocfirstname']")).getAttribute("value"),locationBasedTCSPOCName );
				   Assert.assertEquals(driver.findElement(By.xpath("//input[@name='spocmobile']")).getAttribute("value"), locationBasedTCSPOCNMobileNum);
				   Assert.assertEquals(driver.findElement(By.xpath("//input[@name='spocemail']")).getAttribute("value"), locationBasedTCSPOCEmail);
				   Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='addessline1']")).getAttribute("value"), locationBasedTCAddress);
				   Assert.assertEquals(driver.findElement(By.xpath("//input[@name='landmark']")).getAttribute("value"), locationBasedTCLandmark);
				   Assert.assertEquals(driver.findElement(By.xpath("//input[@name='pincode']")).getAttribute("value"), locationBasedTCPincode);
				   Assert.assertEquals(driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value"), state);
				   Assert.assertEquals(driver.findElement(By.xpath("//input[@name='district']")).getAttribute("value"), district);
				   Assert.assertEquals(driver.findElement(By.xpath("//input[@name='subDistrict']")).getAttribute("value"), subDistrict);
				   Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+jobrole+"')]")).getText().trim(), jobrole);
				   Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+sector+"')]")).getText().trim(), sector);
				   Thread.sleep(2000);
				   aSp.clickApplyForBatch();
				   Thread.sleep(2000);
				   Assert.assertFalse(driver.findElements(By.xpath("//div[@id='toast-container']/div/div")).size()!=0,"This Candidate already applied for this Batch or he/she is a MasterAssessor");
				   Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().trim().endsWith(batchID), "Assessor searched and applied batch mismatch");
				   aSp.clickOK();
				   Thread.sleep(2000);
				   driver.navigate().back();
				   Thread.sleep(2000);
			   }
			   else if(actionDropdownMenuOption.equals("Apply to the batch"))
			   {
				   Thread.sleep(2000);
				   aSp.selectApplyToBatch();
				   Thread.sleep(2000);
				   Assert.assertFalse(driver.findElements(By.xpath("//div[@id='toast-container']/div/div")).size()!=0,"This Candidate already applied for this Batch or he/she is a MasterAssessor");
				   Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().trim().endsWith(batchID), "searched and applied batch mismatch");
				   aSp.clickOK();
				   Thread.sleep(2000);
			   }
		   }	
	   }
	   js.executeScript("window.scrollBy(0,-500)", "");
	   Thread.sleep(2000);
	   aSp.clickToGoToApplicantDashboard();
	   Thread.sleep(2000);
	   AssessorApplicantDashboardPage aBp=new AssessorApplicantDashboardPage(driver);
	   aBp.clickViewBatches();
	   Thread.sleep(2000);
	   AssessorApplicantViewBatchesPage aVbP=new AssessorApplicantViewBatchesPage(driver);
	   aVbP.clickToGoToAppliedBatchesSection();
	   Thread.sleep(2000);
	   for(int i=1;i<4;i++)
	   {
		   //verifying applied section
	   	   String batchID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 1);
	   	   String batchType=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 10);
	   	   aVbP.enterToSearchForBatch(batchID);
		   Thread.sleep(2000);
		   if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields") && !batchType.equalsIgnoreCase(batchTypeForSearch))
		   {
			   Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!! There should be no result in case of Assessor applicant searched batch type - "+batchTypeForSearch+" and created batch type - "+batchType+" mismatch!!! ");
		   }
		   else
		   {
			   Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG! No show of applied batch - "+batchID+" in Applied Section!!! ");
			   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchID+"']")).getText().trim(), batchID);
			   Assert.assertTrue(driver.findElement(By.xpath("(//tr)[2]/td[8]/span")).getText().trim().equalsIgnoreCase("Applied"));
		   }
	   }
	   PostLoginPage plp=new PostLoginPage(driver);
	   plp.clickOnProfileLogo();
	   Thread.sleep(2000);
	   plp.clickOnLogout();
	   Thread.sleep(2000);
   }
   //Assessor Applicants Approval Process From Location Based TC and SSC
   @Test(dataProvider="registrationData", dependsOnMethods="assessorSearchAndApplyForAvailableBatchTC_05")
   public void locationBasedTrainingCentreApprovingAndRejectingAssessorApplicantsTC_06(String serialNum,String createdAssessorID,String userType, String name,String tcApproveOrRejectThisAssessorForAssessorTrainingBatch,String tcReasonForRejectingThisAssessorApplicant, String sscApproveOrRejectThisAssessorForAssessorTrainingBatch, String sscReasonForRejectingThisAssessorApplicant, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String jobRole_sector1, String jobRole_subSector1, String jobRole1, String jobRole_sector2, String jobRole_subSector2, String jobRole2, String preferred_state1, String preferred_city1, String preferred_district1, String preferred_state2, String preferred_city2, String preferred_district2, String preferred_state3, String preferred_city3, String preferred_district3) throws Exception
   {
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   LoginPage lp=new LoginPage(driver);
	   lp.clickLogin();
	   EnterLoginPage elp=new EnterLoginPage(driver);
	   String locationBasedTCID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation",1,2);
	   elp.performlogin(locationBasedTCID, "Qwerty@123");
	   Thread.sleep(2000);
	   LocationBasedTC_DashboardPage lBTcP=new LocationBasedTC_DashboardPage(driver);
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)","");
	   Thread.sleep(2000);
	   LocationBasedTC_ViewBatchesPage lBTcVp=new LocationBasedTC_ViewBatchesPage(driver);
	   for(int i=1;i<4;i++)
	   {	
		   String batchID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 1);
		   String batchType=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 10);
		   String batchSize=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 13);
		   String jobRole=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 11);
		   String sector=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 8);
		   String batchFees=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 12);
		   String assignedMasterTrainer=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 9);
		   String assignedMasterAssessor=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 15);
		   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 2);
		   String assessmentEndDate=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 5);
		   lBTcP.clickToViewLocationBasedTrainingBatches();
		   Thread.sleep(2000);
		   lBTcVp.clickToViewAllAcceptedBatches();
		   Thread.sleep(2000);
		   js.executeScript("window.scrollBy(0,200)","");
		   Thread.sleep(2000);
		   lBTcVp.enterToSearchForBatchID(batchID);
		   Thread.sleep(4000);
		   Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+locationBasedTCID+" !!!");
		   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchID+"']")).getText().trim(), batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchType+"']")).getText().trim(), batchType);
		   //Verifying Applied Candidates Count
		   Assert.assertEquals(driver.findElement(By.xpath("//th[4]")).getText().trim(), "Candidates Applied");
		   String searchByEnteringMandatoryFieldsOrAll=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "SearchAndApplyForBatches",Integer.parseInt(serialNum),2);
		   String batchTypeForSearch=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "SearchAndApplyForBatches",Integer.parseInt(serialNum),9);
		   //When first candidate applied batch type is matching with created batch type 
		   if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields") && batchType.equalsIgnoreCase(batchTypeForSearch) && Integer.parseInt(serialNum)==1)
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("//td[4]")).getText().trim(), "8");
		   }
		   //When first candidate applied batch type is not matching with created batch type 
		   else if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields") && !batchType.equalsIgnoreCase(batchTypeForSearch) && Integer.parseInt(serialNum)==1 )
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("//td[4]")).getText().trim(), "7"); 
		   }
		   //After Rejecting First Candidate by Location Based TC
		   else if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("mandatory") && Integer.parseInt(serialNum)!=1)
		   {
			   String candidatesAppliedCount=driver.findElement(By.xpath("//td[4]")).getText().trim();
			   Assert.assertEquals(Integer.parseInt(candidatesAppliedCount), 8-(Integer.parseInt(serialNum)-1));
		   }
		   Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate+" to "+assessmentEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//th[7]")).getText().trim(), "Status");
		   Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().trim(), "new");
		   lBTcVp.clikToViewActionMenu();
		   Thread.sleep(2000);
		   lBTcVp.clikToViewActionMenu();
		   Thread.sleep(2000);
		   lBTcVp.clickToSelectViewBatchDetailsOption();
		   Thread.sleep(2000);
		   String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Batch ID')]")).getText().trim(), "Batch ID - "+batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("//b[text()='"+jobRole+"']")).getText().trim(), jobRole);
		   Assert.assertEquals(driver.findElement(By.xpath("//b[text()='"+sector+"']")).getText().trim(), sector);
		   Assert.assertEquals(driver.findElement(By.xpath("//b[text()='"+assignedMasterTrainer+"']")).getText().trim(), assignedMasterTrainer);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Assigned Master Assessor:')]]/div/span/b")).getText().trim(), assignedMasterAssessor);
		   Assert.assertEquals(driver.findElement(By.xpath("//b[text()='"+batchFees+"']")).getText().trim(), batchFees);
		   Assert.assertEquals(driver.findElement(By.xpath("//b[text()='"+batchSize+"']")).getText().trim(), batchSize);
		   Assert.assertEquals(driver.findElement(By.xpath("//b[text()='"+batchType+"']")).getText().trim(), batchType);
		   Thread.sleep(2000);
		   lBTcVp.clickToGoToAppliedCandidatesSection();
		   Thread.sleep(2000);
		   js.executeScript("window.scrollBy(0,200)","");
		   Thread.sleep(2000);
		   //Personal Information of assessor applicant
		   lBTcVp.enterToSearchForBatchApplicants(email);
		   Thread.sleep(2000);
		   if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields") && !batchType.equalsIgnoreCase(batchTypeForSearch))
		   {
			   Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! There should be no result as this batch applicant - "+createdAssessorID+" of email - "+email+" is not applied to the batch - "+batchID+" as applied batchType - "+batchTypeForSearch+" and created batch type - "+batchType+" differs!!! ");
		   }
		   else
		   {
			   Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! No show of batch applicant - "+createdAssessorID+" of email - "+email+" who has applied for the batch - "+batchID+" !!! "); 
		  	   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+name+"']")).getText().trim(), name);
			   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+email+"']")).getText().trim(), email);
			   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+mobile+"']")).getText().trim(), mobile);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[2]/td[5]")).getText().trim(), "No","Batch Applicant verified status should be - No, as TC yet to verify this batch applicant!!! ");
			   lBTcVp.clickToVerifyAndApproveBatchApplicant();
			   Thread.sleep(4000);
			   lBTcVp.clickToViewPersonalInformationOfBatchApplicant();
			   Thread.sleep(2000);
			   lBTcVp.verifyingPersonalInformationOfBatchApplicant(name, gender, dob, language, religion, category, disability);
			   lBTcVp.clickToViewConatctAndAddressOfBatchApplicant();
			   Thread.sleep(2000);
			   lBTcVp.verifyingConatctAndAddressOfBatchApplicant(mobile, email, address, landmark, pincode, state, city, mandal, parliamentaryConstituency);
			   lBTcVp.clickToViewEducationAndWorkOfBatchApplicant();
			   Thread.sleep(2000);
			   lBTcVp.verifyingEducationAndWorkOfBatchApplicant(education1, edu_details1, education2, edu_details2, education3, industrial_sector1, industrialExperienceDetails1, industrial_years1, industrial_months1, industrial_sector2, industrialExperienceDetails2, industrial_years2, industrial_months2, training_sector1, trainingExperienceDetails1, trainingExperienceYears1, trainingExperienceMonths1, training_sector2, trainingExperienceDetails2, trainingExperienceYears2, trainingExperienceMonths2);
			   if(tcApproveOrRejectThisAssessorForAssessorTrainingBatch.equalsIgnoreCase("approve"))
			   {
				   lBTcVp.clickToApproveBatchApplicant();
				   Thread.sleep(2000);
				   Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved"), "OMG!!! there is no popup message regarding batch applicant approved successfully!! " );
				   lBTcVp.clickOk();
				   Thread.sleep(2000);
				   lBTcVp.clickToGoToEnrolledCandidatesSection();
				   Thread.sleep(2000);
				   lBTcVp.enterToSearchForBatchApplicants(email);
				   Thread.sleep(2000);
				   Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0, "OMG!! No show of Approved Assessor Applicant - "+createdAssessorID+" of email - "+email+" !!! ");
				   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+name+"']")).getText().trim(), name);
				   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+email+"']")).getText().trim(), email);
				   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+mobile+"']")).getText().trim(), mobile);
				   Assert.assertEquals(driver.findElement(By.xpath("//tr[2]/td[5]")).getText().trim(), "Awaiting SSC Approval");
				   lBTcVp.clickToViewDetailsOfEnrolledBatchApplicant();
				   Thread.sleep(2000);
				   lBTcVp.verifyingPersonalInformationOfBatchApplicant(name, gender, dob, language, religion, category, disability);
				   lBTcVp.clickToViewConatctAndAddressOfBatchApplicant();
				   Thread.sleep(2000);
				   lBTcVp.verifyingConatctAndAddressOfBatchApplicant(mobile, email, address, landmark, pincode, state, city, mandal, parliamentaryConstituency);
				   lBTcVp.clickToViewEducationAndWorkOfBatchApplicant();
				   Thread.sleep(2000);
				   lBTcVp.verifyingEducationAndWorkOfBatchApplicant(education1, edu_details1, education2, edu_details2, education3, industrial_sector1, industrialExperienceDetails1, industrial_years1, industrial_months1, industrial_sector2, industrialExperienceDetails2, industrial_years2, industrial_months2, training_sector1, trainingExperienceDetails1, trainingExperienceYears1, trainingExperienceMonths1, training_sector2, trainingExperienceDetails2, trainingExperienceYears2, trainingExperienceMonths2);
				   lBTcVp.clickToCloseBatchApplicantVerificationPage();
				   Thread.sleep(2000);
			   }
			   else if(tcApproveOrRejectThisAssessorForAssessorTrainingBatch.equalsIgnoreCase("reject"))
			   {
				   lBTcVp.clickToRejectBatchApplicant();
				   Thread.sleep(2000);
				   lBTcVp.enterReasonForRejectingBatchApplicant(tcReasonForRejectingThisAssessorApplicant);
				   lBTcVp.clickToRejectBatchApplicantFinal();
				   Thread.sleep(2000);
				   Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("successfully"), "OMG!!! Batch applicant not rejected as success popup message not displayed!!! " );
				   lBTcVp.clickOk();
				   Thread.sleep(2000);
				   lBTcVp.enterToSearchForBatchApplicants(email);
				   Thread.sleep(2000);
				   Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! Still rejected trainer batch applicant - "+createdAssessorID+" of email - "+email+" record present in applied candidates section!!! ");
				   lBTcVp.clickToGoToEnrolledCandidatesSection();
				   Thread.sleep(2000);
				   lBTcVp.enterToSearchForBatchApplicants(email);
				   Thread.sleep(2000);	
				   Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! Still rejected trainer batch applicant - "+createdAssessorID+" of email - "+email+" record present in enrolled candidates section!!! ");
			   }
		   }
		   js.executeScript("window.scrollBy(0,-200)","");
		   Thread.sleep(2000);
		   lBTcVp.clickToGoToDashboard();
		   Thread.sleep(2000);
	   }
	   PostLoginPage plp=new PostLoginPage(driver);
	   plp.clickOnProfileLogo();
	   Thread.sleep(2000);
	   plp.clickOnLogout();
	   Thread.sleep(2000);
   }
   
   @Test(dataProvider="registrationData",dependsOnMethods="locationBasedTrainingCentreApprovingAndRejectingAssessorApplicantsTC_06")
   public void sscApprovingAndRejectingAssessorApplicantsTC_07(String serialNum,String createdAssessorID,String userType, String name,String tcApproveOrRejectThisAssessorForAssessorTrainingBatch,String tcReasonForRejectingThisAssessorApplicant, String sscApproveOrRejectThisAssessorForAssessorTrainingBatch, String sscReasonForRejectingThisAssessorApplicant, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String jobRole_sector1, String jobRole_subSector1, String jobRole1, String jobRole_sector2, String jobRole_subSector2, String jobRole2, String preferred_state1, String preferred_city1, String preferred_district1, String preferred_state2, String preferred_city2, String preferred_district2, String preferred_state3, String preferred_city3, String preferred_district3) throws Exception
   {
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   LoginPage lp=new LoginPage(driver);
	   lp.clickLogin();
	   EnterLoginPage elp=new EnterLoginPage(driver);
	   String sscUserName=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 7);
	   String sscPassword=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 8);
	   elp.performlogin(sscUserName, sscPassword);
	   Thread.sleep(2000);
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)","");
	   Thread.sleep(2000);
	   SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
	   SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
	   for(int i=1;i<4;i++)
	   {	
		   String locationBasedTCID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "LocationBasedTC-Creation",1,2);
		   String batchID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 1);
		   String batchType=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 10);
		   String batchSize=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 13);
		   String jobRole=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 11);
		   String sector=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 8);
		   String subSector=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 9);
		   String batchFees=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 12);
		   String assignedMasterTrainer=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 9);
		   String assignedAssessmentAgency=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 12);
		   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 2);
		   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 3);
		   String assessmentStartDate=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 4);
		   String assessmentEndDate=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", i, 5);
		   sDp.clickAllBatches();
		   Thread.sleep(2000);
		   sAp.clickToViewPublishedBatches();
		   Thread.sleep(2000);
		   js.executeScript("window.scrollBy(0,200)","");
		   Thread.sleep(2000);
		   sAp.enterSearchForBatchID(batchID);
		   Thread.sleep(2000);
		   sAp.clickToSearch();
		   Thread.sleep(2000);
		   Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Published Section of "+sscUserName+" !!! ");
		   Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		   Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentEndDate+"')]")).getText().trim(), assessmentEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+locationBasedTCName+"')]")).getText().trim(), locationBasedTCName);
		   //Enrolled/Applied Candidates(TC approved candidates) Count
		   Assert.assertEquals(driver.findElement(By.xpath("//th[7]")).getText().trim(), "Enrolled Candidates/Applied Candidates");
		   //this if condition need to be removed after bug fix, as tc rejected candidate should not be considered for ssc applied candidates
		   int serialNumber=Integer.parseInt(serialNum);
		   if(batchType.equalsIgnoreCase("Training of Assessor-New") && serialNumber<4)
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), "0/8");
		   }
		   else if(!batchType.equalsIgnoreCase("Training of Assessor-New") && serialNumber<4)
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), "0/7");
		   }
		   else if(batchType.equalsIgnoreCase("Training of Assessor-New") && serialNumber>3)
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), Integer.parseInt(serialNum)-3+"/8");
		   }
		   else if(!batchType.equalsIgnoreCase("Training of Assessor-New") && serialNumber>3)
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), Integer.parseInt(serialNum)-3+"/7");
		   }
		   sAp.clickToViewActionMenuOptions();
		   Thread.sleep(2000);
		   sAp.clicktoSelectViewBatchDetailsOption();
		   Thread.sleep(2000);
		   //Verifying General Batch Details
		   String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""),configuredURL.replaceAll("/", "")+"sscall-batchesbatch"+batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"/"+batchStartDate+" to "+assessmentEndDate+"("+batchID+")')]")).getText().trim(),batchType+"/"+batchStartDate+" to "+assessmentEndDate+"("+batchID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+batchType+"')])[2]")).getText().trim(), batchType);
		   Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+sector+"')])[1]")).getText().trim(), sector);
		   Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+subSector+"')]")).getText().trim(), subSector);
		   Assert.assertEquals(driver.findElement(By.xpath("//td[span[contains(text(),'"+jobRole+"')]]")).getText().trim(), jobRole);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[2]")).getText().trim(), batchSize);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Fee:')]]/td[2]")).getText().trim(), batchFees);
		   //To check SSC - applied/enrolled candidates before approving or rejecting from ssc end, hv to get count of tc approved candidates count
		   if(batchType.equalsIgnoreCase("Training of Assessor-New"))//this if condition need to be removed after bug fix
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Enrolled Candidates/Applied Candidates:')]]/td[2]")).getText().trim(), "8");
		   }
		   else
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Enrolled Candidates/Applied Candidates:')]]/td[2]")).getText().trim(), "7");
			   
		   }
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Training Dates:')]]/td[2]")).getText().replaceAll(" ", ""), batchStartDate+"-"+batchEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Assessment Dates:')]]/td[2]")).getText().replaceAll(" ", ""), assessmentStartDate+"-"+assessmentEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Duration:')]]/td[2]")).getText().replaceAll(" ", ""), batchStartDate+"-"+assessmentEndDate);
		   //Verifying Assigned Location Based TC details
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Training Partner Name:')]]/td[2]")).getText().trim(), "Retail_TP");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Training Centre Name:')]]/td[2]")).getText().trim(), locationBasedTCID);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Address:')]]/td[2]")).getText().trim(), locationBasedTCAddress);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'City:')]]/td[2]")).getText().trim(), locationBasedTCDistrict);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'State:')]]/td[2]")).getText().trim(), locationBasedTCState);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Head of Training Centre')]]/td[2]")).getText().trim(), locationBasedTCHeadName);
		   Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Phone')]]/td[2])[1]")).getText().trim(), locationBasedTCHeadPhone);
		   Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Email')]]/td[2])[1]")).getText().trim(), locationBasedTCHeadEmail);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Single Point of Contact Person:')]]/td[2]")).getText().trim(), locationBasedTCSPOCName);
		   Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Phone')]]/td[2])[2]")).getText().trim(), locationBasedTCSPOCNMobileNum);
		   Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Email')]]/td[2])[2]")).getText().trim(), locationBasedTCSPOCEmail);
		   Select selectedMasterTrainer=new Select(driver.findElement(By.xpath("(//select)[1]")));
		   Select selectedMasterAssessmentAgency=new Select(driver.findElement(By.xpath("(//select)[2]")));
		   Assert.assertEquals(selectedMasterTrainer.getFirstSelectedOption().getText(), assignedMasterTrainer);
		   Assert.assertEquals(selectedMasterAssessmentAgency.getFirstSelectedOption().getText(), assignedAssessmentAgency);
		   Thread.sleep(2000);
		   sAp.clickToGoToAppliedCandidatesSection();
		   Thread.sleep(4000);
		   sAp.enterToSearchForBatchApplicants(email);
		   Thread.sleep(2000);
		   if(tcApproveOrRejectThisAssessorForAssessorTrainingBatch.equalsIgnoreCase("reject"))
		   {
			   Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0, "OMG!! Location Based TC Rejected Assessor Applicant" +createdAssessorID+"-"+email+" listed in SSC Applied Candidates Section!!! ");
		   }
		   else if(tcApproveOrRejectThisAssessorForAssessorTrainingBatch.equalsIgnoreCase("approve"))
		   {
			   Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0, "OMG!! No Show Of Location Based TC Accepted Assessor Applicant" +createdAssessorID+"-"+email+" in SSC Applied Candidates Section!!! ");
			   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+name+"']")).getText().trim(), name);
			   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+email+"']")).getText().trim(), email);
			   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+mobile+"']")).getText().trim(), mobile);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[2]/td[5]")).getText().trim(), "Yes","OMG!! This assessor applicant is already verified by Location Based TC, so veriied status should be - Yes!!! ");
			   Thread.sleep(2000);
			   sAp.clickToVerifyAndApproveBatchApplicant();
			   Thread.sleep(4000);
			   sAp.clickToViewPersonalInformationOfBatchApplicant();
			   Thread.sleep(2000);
			   sAp.verifyingPersonalInformationOfBatchApplicant(name, gender, dob, language, religion, category, disability);
			   sAp.clickToViewConatctAndAddressOfBatchApplicant();
			   Thread.sleep(2000);
			   sAp.verifyingConatctAndAddressOfBatchApplicant(mobile, email, address, landmark, pincode, state, city, mandal, parliamentaryConstituency);
			   sAp.clickToViewEducationAndWorkOfBatchApplicant();
			   Thread.sleep(2000);
			   sAp.verifyingEducationAndWorkOfBatchApplicant(education1, edu_details1, education2, edu_details2, education3, industrial_sector1, industrialExperienceDetails1, industrial_years1, industrial_months1, industrial_sector2, industrialExperienceDetails2, industrial_years2, industrial_months2, training_sector1, trainingExperienceDetails1, trainingExperienceYears1, trainingExperienceMonths1, training_sector2, trainingExperienceDetails2, trainingExperienceYears2, trainingExperienceMonths2);
			   if(sscApproveOrRejectThisAssessorForAssessorTrainingBatch.equalsIgnoreCase("approve"))
			   {
				   sAp.clickToApproveBatchApplicant();
				   Thread.sleep(2000);
				   Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved"), "OMG!!! Batch applicant not approved as success popup message not displayed!!! " );
				   sAp.clickOk();
				   Thread.sleep(4000);
				   sAp.enterToSearchForBatchApplicants(email);
				   Thread.sleep(2000);
				   Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!! SSC Approved Candidate - "+email+" Still Present in Applied Candidates section!!! ");
				   sAp.clickToGoToEnrolledCandidatesSection();
				   Thread.sleep(4000);
				   sAp.enterToSearchForBatchApplicants(email);
				   Thread.sleep(2000);
				   Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0, "OMG!! No show of Approved Batch Applicant - "+email);
				   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+name+"']")).getText().trim(), name);
				   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+email+"']")).getText().trim(), email);
				   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+mobile+"']")).getText().trim(), mobile);
				   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+email+"')]]/td[5]")).getText().trim(), "Yes");
				   sAp.clickToViewDetailsOfEnrolledBatchApplicant();
				   Thread.sleep(4000);
				   sAp.clickToViewPersonalInformationOfBatchApplicant();
				   Thread.sleep(2000);
				   sAp.verifyingPersonalInformationOfBatchApplicant(name, gender, dob, language, religion, category, disability);
				   sAp.clickToViewConatctAndAddressOfBatchApplicant();
				   Thread.sleep(2000);
				   sAp.verifyingConatctAndAddressOfBatchApplicant(mobile, email, address, landmark, pincode, state, city, mandal, parliamentaryConstituency);
				   sAp.clickToViewEducationAndWorkOfBatchApplicant();
				   Thread.sleep(2000);
				   sAp.verifyingEducationAndWorkOfBatchApplicant(education1, edu_details1, education2, edu_details2, education3, industrial_sector1, industrialExperienceDetails1, industrial_years1, industrial_months1, industrial_sector2, industrialExperienceDetails2, industrial_years2, industrial_months2, training_sector1, trainingExperienceDetails1, trainingExperienceYears1, trainingExperienceMonths1, training_sector2, trainingExperienceDetails2, trainingExperienceYears2, trainingExperienceMonths2);
				   sAp.clickToCloseBatchApplicantVerificationPage();
				   Thread.sleep(2000);
			   }
			   else if(sscApproveOrRejectThisAssessorForAssessorTrainingBatch.equalsIgnoreCase("reject"))
			   {
				   sAp.clickToRejectBatchApplicant();
				   Thread.sleep(2000);
				   sAp.enterReasonForRejectingBatchApplicant(sscReasonForRejectingThisAssessorApplicant);
				   sAp.clickToRejectBatchApplicantFinal();
				   Thread.sleep(2000);
				   Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("successfully"), "OMG!!! Batch Applicant not rejected as success popup message not displayed!!! " );
				   sAp.clickOk();
				   Thread.sleep(4000);
				   sAp.enterToSearchForBatchApplicants(email);
				   Thread.sleep(2000);
				   Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! SSC rejected batch applicant - "+createdAssessorID+" of email - "+email+" record present in applied candidates section!!! ");
				   sAp.clickToGoToEnrolledCandidatesSection();
				   Thread.sleep(4000);
				   sAp.enterToSearchForBatchApplicants(email);
				   Thread.sleep(2000);
				   Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! SSC rejected batch applicant - "+createdAssessorID+" of email - "+email+" record present in enrolled candidates section!!! ");
			   }
		   }
		   js.executeScript("window.scrollBy(0,-200)","");
		   Thread.sleep(2000);
		   sAp.clickToGoTotoTtoAtoMTtoMADashboard();
		   Thread.sleep(2000);
	   }
	   PostLoginPage plp=new PostLoginPage(driver);
	   plp.clickOnProfileLogo();
	   Thread.sleep(2000);
	   plp.clickOnLogout();
	   Thread.sleep(2000);			
   }
} 
