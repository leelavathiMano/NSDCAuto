package com.nsdc.regressionTest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage;
import com.nsdc.pages.TrainerDashboardPage;
import com.nsdc.pages.TrainerViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class AssessorWorkflowTestSC_04 extends TestConfiguration
{
	String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	Date date = new Date();
	@DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorRegistration");
    }
    
    @Test(dataProvider="registrationData")
    public void assessorRegistrationTC_01(String serialNum,String createdAssessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
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
        ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorRegistration", Integer.parseInt(serialNum), 1, createdAssessor);
        String username = driver.findElement(By.xpath("//span[@class='text-bold']")).getText();
        rp.clickGoToLogin();
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, "ekaushal");
        Thread.sleep(2000);
        rp.enterOldPassword(oldPassword);
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        rp.clickResetResubmit();
        Thread.sleep(2000);
        rp.clickConfirmationOkMessage();
        elp.performlogin(username, confirmPassword);
        Thread.sleep(8000);
        AssessorRegistrationPage assessor = new AssessorRegistrationPage(driver);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).getAttribute("value"), name);
        assessor.selectGender(gender);
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,150)", "");
        assessor.selectDateOfBirth();
        Thread.sleep(4000);
        String selectedDateOfBirth=driver.findElement(By.id("dob")).getAttribute("value");
        ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorRegistration", Integer.parseInt(serialNum), 12, selectedDateOfBirth);
         
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
            Thread.sleep(4000);
            UploadFile.upload(disabilityFile);
            Thread.sleep(4000);
            assessor.clickOnUploadButtonForUploadDisabilityDocument();
            Thread.sleep(8000);
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
            Thread.sleep(8000);
        }
        Thread.sleep(2000);
        assessor.clickOnBrowseFileButtonToUploadPhoto();
        Thread.sleep(4000);
        UploadFile.upload(photoFile);
        Thread.sleep(4000);
        assessor.clickOnUploadButtonToUploadPhoto();
        Thread.sleep(8000);
        
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
        Thread.sleep(8000);        
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
        Thread.sleep(8000);
        if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
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
            Thread.sleep(8000);
            assessor.clickOnAddEducationDetailsButton();
            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education1+"')]")).getText(), education1);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details1+"')]")).getText(), edu_details1);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[1]")).getText(), "yes");
            Thread.sleep(4000);
            assessor.selectEducationAttained(education2);
            Thread.sleep(2000);
            assessor.enterDetailsOfEducation(edu_details2);
            Thread.sleep(2000);
            assessor.clickOnBrowseForUploadEducationProofDocument();
            Thread.sleep(2000);
            UploadFile.upload(edu_document2);
            Thread.sleep(4000);
            assessor.clickOnUploadForUploadEducationProofDocument();
            Thread.sleep(8000);
            assessor.clickOnAddEducationDetailsButton();
            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education2+"')]")).getText(), education2);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details2+"')]")).getText(), edu_details2);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[2]")).getText(), "yes");
            Thread.sleep(4000);
            assessor.selectEducationAttained(education3);
            assessor.enterDetailsOfEducation(edu_details3);
            assessor.clickOnBrowseForUploadEducationProofDocument();
           	Thread.sleep(4000);
           	UploadFile.upload(edu_document3);
           	Thread.sleep(4000);
           	assessor.clickOnUploadForUploadEducationProofDocument();
           	Thread.sleep(8000);
            assessor.clickOnAddEducationDetailsButton();
            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education3+"')]")).getText(), education3);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details3+"')]")).getText(), edu_details3);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[3]")).getText(), "yes");
            assessor.deleteThirdEducationDetails();
        }
        Thread.sleep(4000);
        assessor.selectRelevantSectorForIndustrialExperience(industrial_sector1);
        Thread.sleep(2000);
        assessor.selectYearsForIndustrialExperience(industrial_years1);
        Thread.sleep(2000);
        assessor.selectMonthsForIndustrialExperience(industrial_months1);
        Thread.sleep(2000);
        assessor.enterDetailsOfIndustrialExperience(industrialExperienceDetails1);
        Thread.sleep(2000);
        assessor.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails1);
        Thread.sleep(2000);
        assessor.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(industrialDocument1);
        Thread.sleep(4000);
        assessor.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(8000);
        assessor.clickOnAddIndustrialExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector1+"')]")).getText(), industrial_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails1+"')]")).getText(), industrialExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[1]")).getText(), "Yes");
        assessor.selectRelevantSectorForIndustrialExperience(industrial_sector2);
        Thread.sleep(2000);
        assessor.selectYearsForIndustrialExperience(industrial_years2);
        Thread.sleep(2000);
        assessor.selectMonthsForIndustrialExperience(industrial_months2);
        Thread.sleep(2000);
        assessor.enterDetailsOfIndustrialExperience(industrialExperienceDetails2);
        Thread.sleep(2000);
        assessor.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails2);
        Thread.sleep(2000);
        assessor.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(industrialDocument2);
        Thread.sleep(4000);
        assessor.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(8000);
        assessor.clickOnAddIndustrialExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector2+"')]")).getText(), industrial_sector2);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails2+"')]")).getText(), industrialExperienceDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[2]")).getText(), "Yes");
        assessor.selectRelevantSectorForIndustrialExperience(industrial_sector3);
        Thread.sleep(2000);
        assessor.selectYearsForIndustrialExperience(industrial_years3);
        Thread.sleep(2000);
        assessor.selectMonthsForIndustrialExperience(industrial_months3);
        Thread.sleep(2000);
        assessor.enterDetailsOfIndustrialExperience(industrialExperienceDetails3);
        Thread.sleep(2000);
        assessor.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails3);
        Thread.sleep(2000);
        assessor.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(industrialDocument3);
        Thread.sleep(4000);
        assessor.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(8000);
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
    	Thread.sleep(2000);
   	   	assessor.selectRelevantSectorForTrainingExperience(training_sector1);
   	   	Thread.sleep(2000);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears1);
        Thread.sleep(2000);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths1);
        Thread.sleep(2000);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails1);
        Thread.sleep(2000);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(trainingDocument1);
        Thread.sleep(4000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(8000);
        assessor.clickOnAddTrainingExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector1+"')]")).getText(), training_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails1+"')]")).getText(), trainingExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText(), "Yes");
        assessor.selectRelevantSectorForTrainingExperience(training_sector2);
        Thread.sleep(2000);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears2);
        Thread.sleep(2000);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths2);
        Thread.sleep(2000);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails2);
        Thread.sleep(2000);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(trainingDocument2);
        Thread.sleep(4000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(8000);
        assessor.clickOnAddTrainingExperienceDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector2+"')]")).getText(), training_sector2);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails2+"')]")).getText(), trainingExperienceDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[4]")).getText(), "Yes");
        assessor.selectRelevantSectorForTrainingExperience(training_sector3);
        Thread.sleep(2000);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears3);
        Thread.sleep(2000);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths3);
        Thread.sleep(2000);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails3);
        Thread.sleep(2000);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(trainingDocument3);
        Thread.sleep(4000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(8000);
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
    	Thread.sleep(2000);
    	assessor.clickOnBrowseForCurriculumVitaeOrResume();
        Thread.sleep(4000);
        UploadFile.upload(resume);
        Thread.sleep(4000);
        assessor.clickOnUploadForCurriculumVitaeOrResume();
        Thread.sleep(8000);
        assessor.clickOnSaveAndContinue();
        Thread.sleep(6000);
        //preference 1
        assessor.selectPreferredSector(preferredSector1);
        Thread.sleep(4000);
        assessor.selectPreferredSubSector(preferredSubSector1);
        Thread.sleep(4000);
        assessor.selectPreferredJobRole(preferredJobRole1);
        Thread.sleep(4000);
        assessor.selectPreferredState(preferredState1);
        Thread.sleep(4000);
        assessor.selectPreferredDistrict(preferredDistrict1);
        Thread.sleep(4000);
        assessor.selectPreferredSubDistrict(preferredSubDistrict1);
        Thread.sleep(4000);
        assessor.clickAddPreferences();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[1]")).getText().trim(), preferredJobRole1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[2]")).getText().trim(), preferredSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[4]")).getText().trim(), preferredState1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[5]")).getText().trim(), preferredDistrict1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[6]")).getText().trim(), preferredSubDistrict1);
        //preference 2
        Thread.sleep(4000);
        assessor.selectPreferredSector(preferredSector2);
        Thread.sleep(4000);
        assessor.selectPreferredSubSector(preferredSubSector2);
        Thread.sleep(4000);
        assessor.selectPreferredJobRole(preferredJobRole2);
        Thread.sleep(4000);
        assessor.selectPreferredState(preferredState2);
        Thread.sleep(4000);
        assessor.selectPreferredDistrict(preferredDistrict2);
        Thread.sleep(4000);
        assessor.selectPreferredSubDistrict(preferredSubDistrict2);
        Thread.sleep(4000);
        assessor.clickAddPreferences();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[1]")).getText().trim(), preferredJobRole2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[2]")).getText().trim(), preferredSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[3]")).getText().trim(), preferredSubSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[4]")).getText().trim(), preferredState2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[5]")).getText().trim(), preferredDistrict2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[6]")).getText().trim(), preferredSubDistrict2);
        //preference 3
        Thread.sleep(4000);
        assessor.selectPreferredSector(preferredSector3);
        Thread.sleep(4000);
        assessor.selectPreferredSubSector(preferredSubSector3);
        Thread.sleep(4000);
        assessor.selectPreferredJobRole(preferredJobRole3);
        Thread.sleep(4000);
        assessor.selectPreferredState(preferredState3);
        Thread.sleep(4000);
        assessor.selectPreferredDistrict(preferredDistrict3);
        Thread.sleep(4000);
        assessor.selectPreferredSubDistrict(preferredSubDistrict3);
        Thread.sleep(4000);
        assessor.clickAddPreferences();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[1]")).getText().trim(), preferredJobRole3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[2]")).getText().trim(), preferredSector3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[3]")).getText().trim(), preferredSubSector3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[4]")).getText().trim(), preferredState3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[5]")).getText().trim(), preferredDistrict3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[6]")).getText().trim(), preferredSubDistrict3);
        //deleting 3rd preference
        Thread.sleep(2000);
        assessor.clickToDeleteThirdPreference();
        Thread.sleep(4000);
        Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]")).size()==0,"OMG!!! deleted third preference still present OR Something is wrong! ");
        assessor.clickOnSaveAndContinue();
        Thread.sleep(6000);
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
    public void assessorMyProfileVerificationTC_02(String serialNum,String createdAssessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
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
    	Thread.sleep(8000);
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
    	    Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+education1+"']]/td[4]")).getText().trim(), "Yes");
    	    //Education Record 2
    	    Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+education2+"']")).getText().trim(), education2);
    	    Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
    	    Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+education2+"']]/td[4]")).getText().trim(), "Yes");
    	 }
    	//Checking UnEducated Option
        aMpP.clickToAddEducationDetails();
    	Thread.sleep(2000);
    	aMpP.selectEducationAttained("Uneducated");
    	Thread.sleep(2000);
    	Assert.assertTrue(driver.findElements(By.xpath("//label[contains(text(),'Details of Education:')]")).size()==0, "OMG!!! Education Details Fields should be hidden in case of UnEducated!! ");
    	//Adding Education Record(1st education record in case of uneducated candidate while registering and Deletion
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
    	Thread.sleep(8000);
    	aMpP.clickToSubmitEducationDetails();
    	Thread.sleep(2000);
    	Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'Others')]")).size()!=0,"OMG!!! No show of Added Educational Record for Profile of "+createdAssessorID+" !!! ");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Others')]")).getText().trim(), "Others");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Others Education Selected')]")).getText().trim(), "Others Education Selected");
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='Others']]/td[4]")).getText().trim(), "Yes");
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
    	{
    		aMpP.clickToDeleteAddedFirstEducationDetailsRecord();
    	}
    	else
    	{
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
       	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industriesDetails1+"')])[1]")).getText().trim(), industriesDetails1);
       	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[text()='"+industrial_sector1+"']]/td[5])[1]")).getText().trim(), industrial_years1+" "+"Year"+" "+industrial_months1+" "+"months");
       	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[text()='"+industrial_sector1+"']]/td[6])[1]")).getText().trim(), "Yes");
       	//industrial record 2
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector2+"')]")).getText().trim(), industrial_sector2);
    	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrialExperienceDetails2+"')])[2]")).getText().trim(), industrialExperienceDetails2);
       	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industriesDetails2+"')])[2]")).getText().trim(), industriesDetails2);
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+industrial_sector2+"']]/td[5]")).getText().trim(), industrial_years2+" "+"Year"+" "+industrial_months2+" "+"months");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+industrial_sector2+"']]/td[6]")).getText().trim(), "Yes");
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
    	Thread.sleep(8000);
    	aMpP.clickToSubmitIndustrialExperienceDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Apparel')]")).getText().trim(), "Apparel");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Industrial Experience in Apparel Sector')]")).getText().trim(), "Industrial Experience in Apparel Sector");
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='Apparel']]/td[5]")).getText().trim(), "11 months");
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='Apparel']]/td[6]")).getText().trim(), "Yes");
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
       	{
    		aMpP.clickToDeleteAddedThirdIndustrialExperienceDetailsRecordInCaseOfUneducated();
       	}
    	else
    	{
    		aMpP.clickToDeleteThirdIndustrialExperienceDetailsRecord();
    	}
    	Thread.sleep(4000);
    	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'Apparel')]]")).size()==0,"OMG!!! Deleted 3rd Industrial Experience Details Record present itseems!!! Or Something wrong!!! ");
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
    	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]/td[4]")).getText().trim(), trainingExperienceYears1+" "+"Year"+" "+trainingExperienceMonths1+" "+"months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]/td[5]")).getText().trim(), "Yes");
       	//training record 2
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector2+"')]")).getText().trim(), training_sector2);
    	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+trainingExperienceDetails2+"')])[1]")).getText().trim(), trainingExperienceDetails2);
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+training_sector2+"')]]/td[4]")).getText().trim(), trainingExperienceYears2+" "+"Year"+" "+trainingExperienceMonths2+" "+"months");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+training_sector2+"')]]/td[5]")).getText().trim(), "Yes");
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
    	Thread.sleep(8000);
    	aMpP.clickToSubmitTrainingExperienceDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Apparel')]")).getText().trim(), "Apparel");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Training Experience in Apparel Sector')]")).getText().trim(), "Training Experience in Apparel Sector");
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Apparel')]]/td[4]")).getText().trim(), "11 months");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Apparel')]]/td[5]")).getText().trim(), "Yes");
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
       	{
    		aMpP.clickToDeleteAddedThirdTrainingExperienceDetailsRecordInCaseOfUneducated();
        }
    	else
    	{
    		aMpP.clickToDeleteThirdTrainingExperienceDetailsRecord();
    	}
    	Thread.sleep(4000);
    	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'Apparel')]]")).size()==0,"OMG!!! Deleted 3rd Training Experience Details Record present itseems!!! Or Something wrong!!! ");
    	aMpP.clickCurriculumVitaeBrowse();
    	Thread.sleep(2000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(4000);
    	aMpP.clickCurriculumVitaeUpload();
    	Thread.sleep(8000);
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
    public Object[][] assessorTrainingBatchesData()
    {
    	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches");
    }
    @Test(dataProvider="assessorTrainingBatchesData",dependsOnMethods="assessorMyProfileVerificationTC_02")
    public void assessorTrainingBatchesForAssessorApplicantsTC_03(String serialNo, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole,  String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String trainingCentreName, String trainingCentreID, String trainingCentrePassword, String tcBatchAcceptanceRemarks, String masterTrainerID, String masterTrainerName,  String masterTrainerPassword, String mtBatchAcceptanceRemarks, String mtAcceptedDate, String mtAcceptedTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String aaAcceptedDate, String aaAcceptedTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword,  String maBatchAcceptanceRemarks, String maAcceptedDate, String maAcceptedTime, String state, String district, String subDistrict) throws Exception
    {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickCreateBatch();
		Thread.sleep(6000);
		Assert.assertEquals(driver.findElement(By.name("sector")).getAttribute("value").trim(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(4000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(4000);
		sscTbcP.selectBatchCategory(batchCategory);
		Thread.sleep(4000);
		sscTbcP.selectTrainingStartDateForBatch();
		Thread.sleep(2000);
		sscTbcP.clickToCloseTrainingStartDateCalender();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.id("startDates")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),9,trainingStartDate);
		String trainingEndDate=driver.findElement(By.id("endDates")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),10,trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole);
		Thread.sleep(4000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(4000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickTocloseDomainTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		String domainTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),15,domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),16,domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),17,domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),18,domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+platformJobRoleCode+"')]")).isDisplayed(),"OMG!!! PlatformJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sscTbcP.selectPlatformTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickToclosePlatformTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		String platformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),19,platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),20,platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),21,platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),22,platformAssessmentEndDate);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.clickToGetInDetailBatchFees();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Fee Applicable for Program')]]]/td[2]")).getText().trim(), expectedBatchFees);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Technical QP(0) X Rate(800)')]]]/td[2]")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Non-Technical QP(0) X Rate(600)')]]]/td[2]")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Total Fee of the Program')]]]/td[2]")).getText().trim(), expectedBatchFees);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(2000);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(4000);
		if(driver.findElements(By.xpath("//div[@class='toast-message']")).size()!=0)
		{
			Assert.assertFalse(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().contains("Please fill all fields"),"OMG!!! Unable to create Batch! May be some data not entered OR Something went wrong! ");
		}
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),1,createdBatchID);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssccreate-new-batchbatch-assignment"+createdBatchID,"OMG!!! No show of Batch Assignment Page OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[span[contains(text(),'Sector')]]]/div[3])[1]")).getText().trim(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Sub Sector')]]]/div[3]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Type')]]]/div[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),1,createdBatchID);
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		Thread.sleep(4000);
		sscTbcP.selectStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterTrainingCentreIDToSearch(trainingCentreID);
		Thread.sleep(6000);
		sscTbcP.clickToGetSearchFilterResult();
		Thread.sleep(6000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).size()==1,"OMG!!! No show of Searched training Centre - "+trainingCentreID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).getText().trim(), trainingCentreID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		sscTbcP.clickToChooseResultedTrainingCentreToAssign(trainingCentreID);
		Thread.sleep(4000);
		sscTbcP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Training Centre Assigned\n"+createdBatchID+"\nis successfully assigned to   "+trainingCentreName+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).getText().trim(), trainingCentreID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//td/span[contains(text(),'Assigned')]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for domain and platform QP
		sscTbcP.clickDomainMasterTrainerAction();
		Thread.sleep(4000);
		sscTbcP.clickDomainAssignMasterTrainerOption();
		Thread.sleep(4000);
		sscTbcP.selectDomainMasterTrainerStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDomainMasterTrainerDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterDomainMasterTrainerIDToSearch(masterTrainerID);
		Thread.sleep(4000);
		sscTbcP.clickToGetDomainMasterSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+masterTrainerID+"')]")).getText().trim(), masterTrainerID);
		sscTbcP.clickToChooseDomainMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Master Trainer Assigned Successfully\n"+createdBatchID+"\nis successfully assigned to   "+masterTrainerID+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+masterTrainerID+"')]")).getText().trim(), masterTrainerName+" ( "+masterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'Assigned')]")).getText().trim(), "Assigned");
		sscTbcP.clickPlatformMasterTrainerAction();
		Thread.sleep(4000);
		sscTbcP.clickPlatformAssignMasterTrainerOption();
		Thread.sleep(4000);
		sscTbcP.selectPlatformMasterTrainerStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectPlatformMasterTrainerDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterPlatformMasterTrainerIDToSearch(masterTrainerID);
		Thread.sleep(4000);
		sscTbcP.clickToGetPlatformMasterSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+masterTrainerID+"')]")).getText().trim(), masterTrainerID);
		sscTbcP.clickToChoosePlatformMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+masterTrainerID+"')])[2]")).getText().trim(), masterTrainerName+" ( "+masterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		//Assigning Assessment Agency
		sscTbcP.clickDomainAssessmentAgencyAction();
		Thread.sleep(4000);
		sscTbcP.clickDomainAssignAssessmentAgencyOption();
		Thread.sleep(4000);
		sscTbcP.selectDomainAssessmentAgencyStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDomainAssessmentAgencyDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterDomainAssessmentAgencyIDToSearch(assessmentAgencyID);
		Thread.sleep(4000);
		sscTbcP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentAgencyID+"')]")).getText().trim(), assessmentAgencyID);
		sscTbcP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+assessmentAgencyID+"')])[1]")).getText().trim(), assessmentAgencyName+" ( "+assessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[3]")).getText().trim(), "Assigned");
		//Assigning Platform QP Assessment Agency
		sscTbcP.clickPlatformAssessmentAgencyAction();
		Thread.sleep(4000);
		sscTbcP.clickPlatformAssignAssessmentAgencyOption();
		Thread.sleep(4000);
		sscTbcP.selectPlatformAssessmentAgencyStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectPlatformAssessmentAgencyDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterPlatformAssessmentAgencyIDToSearch(assessmentAgencyID);
		Thread.sleep(4000);
		sscTbcP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentAgencyID+"')]")).getText().trim(), assessmentAgencyID);
		sscTbcP.clickToChoosePlatformAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+assessmentAgencyID+"')])[2]")).getText().trim(), assessmentAgencyName+" ( "+assessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[4]")).getText().trim(), "Assigned");
		//checking presence of created batches of status After Submit Pending For Publish
		Thread.sleep(4000);
		sscTbcP.clickToSubmitBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']/p/b")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		sscTbcP.clickViewAllBatchesAfterBatchSubmission();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-new","OMG!!! navigation to All New Batches After Batch Submission is unsuccessful! OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
		sscTbcP.clickBatchAction(createdBatchID);
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[9]/span/div/div/a/span")).getText().trim(), "View Details");
		sscTbcP.clickViewDetailsOption(createdBatchID);
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-newbatch-datails"+createdBatchID,"OMG!!! navigation to view batch details page is unsuccessful OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch ID')]]/td[3]")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Name')]]/td[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Name of Training Centre')]]/td[3]")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'District')]]/td[3]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'State')]]/td[3]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Status of Training Centre')]]/span")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[5]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[4]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[4]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[5]")).getText().trim(), "Pending");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),2,formatter.format(date));
		PostLoginPage plp=new PostLoginPage(driver);
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
    }
    
    @Test(dataProvider="assessorTrainingBatchesData",dependsOnMethods="assessorTrainingBatchesForAssessorApplicantsTC_03")
    public void batchApprovalTC_04(String serialNo, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole,  String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String trainingCentreName, String trainingCentreID, String trainingCentrePassword, String tcBatchAcceptanceRemarks, String masterTrainerID, String masterTrainerName,  String masterTrainerPassword, String mtBatchAcceptanceRemarks, String mtAcceptedDate, String mtAcceptedTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String aaAcceptedDate, String aaAcceptedTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword,  String maBatchAcceptanceRemarks, String maAcceptedDate, String maAcceptedTime, String state, String district, String subDistrict) throws Exception
    {
    	//Assigned TC Login to Accept Batch
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
    	lp.clickLogin();
    	EnterLoginPage elp= new EnterLoginPage(driver);
		elp.performlogin(trainingCentreID, trainingCentrePassword);
		Thread.sleep(6000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[text()='"+batchSize+"']")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[contains(text(),'"+batchStartDate+"')]")).getText(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText(), "Pending for Publish");
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectAcceptBatchOption(batchID);
		Thread.sleep(4000);
		lTcVbP.enterRemarksForAcceptingBatch(tcBatchAcceptanceRemarks);
		Thread.sleep(4000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");	
		lTcVbP.clickOk();
		Thread.sleep(2000);
		PostLoginPage plp =new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		//Assigned Master Trainer Login To Accept the Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(masterTrainerID, masterTrainerPassword);
		Thread.sleep(2000);
		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
		tDp.clickToGetTrainerDashboard();
		Thread.sleep(2000);
		tDp.clickAllBatches();
		Thread.sleep(4000);
		TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
		tVp.clicktoGoPendingBatchesSection();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), trainingCentreName+" ("+trainingCentreID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state );
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate+" "+pTrainingStartDate+" to "+pTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
		tVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(4000);
		tVp.clickToSelectAcceptBatchOption(batchID);
		Thread.sleep(4000);
		tVp.enterRemarksForAcceptingBatch(mtBatchAcceptanceRemarks);
		Thread.sleep(4000);	
		tVp.clickToSubmit();
		Thread.sleep(2000);	
		
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),33,formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo),34, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");
		tVp.clickOk();
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		//Assigned Assessment Agency Login to Accept and assigning master assessors for a batch
		lp.clickLogin();
		elp.performlogin(assessmentAgencyID, assessmentAgencyPassword);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagency","Login Unsuccessful!!! ");
		AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
		Thread.sleep(4000);
		aDp.clickBatchAssessmentRequests();
		Thread.sleep(2000);
		AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
		aVp.clickToViewPendingBatchRequests();
		Thread.sleep(2000);
		aVp.enterBatchIdToSearch(batchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of batch - "+batchID+" in "+assessmentAgencyID+" Pending Requests section!!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName+" , "+state+"/"+district);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+dAssessmentStartDate+"')])[1]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+pAssessmentStartDate+"')])[2]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("//td[span[contains(text(),'Pending for Acceptance')]]")).getText().trim(), "Pending for Acceptance");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+batchCreatedDate+"')]")).getText().trim(), batchCreatedDate);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToSelectAcceptBatchOption();
		Thread.sleep(2000);
		aVp.enterRemarksForAcceptingBatch(aaBatchAcceptanceRemarks);
		Thread.sleep(2000);		
		aVp.clickToSubmitBatchAcceptance();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(),"You have successfully accepted "+batchID);
		aVp.clickOk();
		Thread.sleep(4000);
		//verifying accepted batches & assigning assessors
		js.executeScript("window.scrollBy(0,-200)", "");
		Thread.sleep(2000);
		aVp.clickToViewAcceptedBatches();
		Thread.sleep(4000);
		aVp.enterBatchIdToSearch(batchID);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section!!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName+" , "+state+"/"+district);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+dAssessmentStartDate+"')])[1]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+pAssessmentStartDate+"')])[2]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Accepted')]")).getText().trim(), "Accepted");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+batchCreatedDate+"')]")).getText().trim(), batchCreatedDate);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+formatter.format(date)+"')]")).getText().trim(), formatter.format(date));
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToSelectAssignAssessorsOption();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch ID')]]]]/div[2]/span")).getText().trim(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch Name')]]]]/div[4]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[1]/span")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[2]/span")).getText().trim(), "State : "+state+", District : "+district);
		Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'"+domainJobRole+"')])[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+dAssessmentStartDate+"')])[1]")).getText().trim(), dAssessmentStartDate+" To "+dAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//span[text()='"+platformJobRole+"'])[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+pAssessmentStartDate+"')])[1]")).getText().trim(), pAssessmentStartDate+" To "+pAssessmentEndDate);
		aVp.selectMasterAssessorForDomain(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(4000);
		aVp.selectMasterAssessorForPlatform(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(4000);
		aVp.clickToSubmitMasterAssessors();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "You have successfully assigned Assessor for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") - "+batchID);
		aVp.clickOk();
		Thread.sleep(4000);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo), 39, formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo), 40, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), "Accepted");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), formatter.format(date));
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		//Master Assessor Login to Accept Batches
		lp.clickLogin();
		elp.performlogin(masterAssessorID, masterAssessorPassword);
		Thread.sleep(8000);
		AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
		maDp.clickToGetAssessorDashboard();
		Thread.sleep(4000);
		maDp.clickBatchAssessmentRequests();
		Thread.sleep(4000);
		AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), trainingCentreName+", "+state+","+district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), dAssessmentStartDate+dAssessmentEndDate+"\n"+pAssessmentStartDate+pAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), formatter.format(date));
		maVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(4000);
		maVp.clickToSelectAcceptBatchOption(batchID);
		Thread.sleep(4000);
		maVp.enterRemarksForAcceptingBatch(maBatchAcceptanceRemarks);
		Thread.sleep(4000);
		maVp.clickToSaveAndSubmitBatchAccceptance();
		Thread.sleep(4000);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo), 45, formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches",Integer.parseInt(serialNo), 46, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");
		maVp.clickOk();
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
   }
       
   @Test(dataProvider="assessorTrainingBatchesData",dependsOnMethods="batchApprovalTC_04")
   public void assessorSearchAndApplyForAvailableBatchTC_05(String serialNo, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole,  String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String trainingCentreName, String trainingCentreID, String trainingCentrePassword, String tcBatchAcceptanceRemarks, String masterTrainerID, String masterTrainerName,  String masterTrainerPassword, String mtBatchAcceptanceRemarks, String mtAcceptedDate, String mtAcceptedTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String aaAcceptedDate, String aaAcceptedTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword,  String maBatchAcceptanceRemarks, String maAcceptedDate, String maAcceptedTime, String state, String district, String subDistrict) throws Exception
   {
	   String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	   LoginPage lp=new LoginPage(driver);
	   EnterLoginPage elp=new EnterLoginPage(driver);
	   for(int i=1;i<6;i++)
	   {
		   String assessorID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorRegistration", i, 1);
		   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		   lp.clickLogin();
		   Thread.sleep(2000);
		   elp.performlogin(assessorID, "Qwerty@123");
		   AssessorApplicantDashboardPage aDp=new AssessorApplicantDashboardPage(driver);
		   Thread.sleep(6000);
		   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
		   aDp.clickToGetApplicantDashboard();
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,200)", "");
		   Thread.sleep(2000);
		   aDp.clickSearchAndApplyforAvailableBatches();
		   Thread.sleep(4000);
		   AssessorApplicantSearchAndApplyForAvailableBatchesPage aSp=new AssessorApplicantSearchAndApplyForAvailableBatchesPage(driver);
		/*   if(i==1)
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
			   aSp.selectjobRole(domainJobRole);
			   Thread.sleep(6000);
			   //Add My Search Preferences
			   aSp.clickAddJobRoleAndLocationToMyPreference();
			   Thread.sleep(4000);
			   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Preference Added Successfully !!");
			   aSp.clickOK();
			   Thread.sleep(2000);
			   js.executeScript("window.scrollBy(0,-200)", "");
			   Thread.sleep(2000);
			   aSp.clickMyPreferences();
			   Thread.sleep(4000);
			   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+sector+"')]]")).size()==1);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+sector+"')]]/td[1]")).getText().trim(), domainJobRole);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+sector+"')]]/td[2]")).getText().trim(), sector);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+sector+"')]]/td[3]")).getText().trim(), subSector);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+sector+"')]]/td[4]")).getText().trim(), state);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+sector+"')]]/td[5]")).getText().trim(), district);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+sector+"')]]/td[6]")).getText().trim(), subDistrict);
			   aSp.clickAction();
			   aSp.selectSearchAgainstPreference();
			   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! Search Against My Preference is not resulting batch - "+batchID);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
			   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(domainJobRole));
			   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(platformJobRole));
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), state);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), district);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchStartDate+" - "+batchEndDate);
			   //have to select batch action
			   Thread.sleep(2000);
			   aSp.clickToGetBatchActionMenu(batchID);
			   Thread.sleep(2000);
			   aSp.selectViewBatchDetails(batchID);
			   Thread.sleep(4000);
			   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicantview-batch-detailsBATCH%20CREATED"+batchID);
			   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
			   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
			   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
			   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), sector);
			   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), subSector);
			   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[1]")).getText().trim(), batchFees);
			   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Name of Training Center')]]])/div[1]")).getText().trim(), trainingCentreName);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), pTrainingStartDate+" to "+pTrainingEndDate);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
			   Thread.sleep(4000);
			   aSp.clickGoBack();
			   Thread.sleep(4000);
			   aSp.clickToGetBatchActionMenu(batchID);
			   Thread.sleep(2000);
			   aSp.selectApplyToBatch(batchID);
			   Thread.sleep(2000);
			   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
			   aSp.clickOK();
			   Thread.sleep(2000);
		   }
		   else if(i==2)
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
			   aSp.selectjobRole(domainJobRole);
			   Thread.sleep(6000);
			   aSp.selectBatchType(batchType);
			   Thread.sleep(2000);
			   aSp.enterBatchStartDate(batchStartDate);
			   Thread.sleep(6000);
			   aSp.clickToCloseBatchStartDateCalender();
			   Thread.sleep(2000);
			   aSp.enterBatchEndDate(batchEndDate);
			   Thread.sleep(6000);
			   aSp.clickToCloseBatchEndDateCalender();
			   Thread.sleep(2000);
			   aSp.enterSearchKeyword(trainingCentreName);
			   Thread.sleep(2000);
			   aSp.clickSearch();
			   Thread.sleep(2000);
			   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! No show of Batch - "+batchID+" searching by entering all fields! ");
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
			   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(domainJobRole));
			   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(platformJobRole));
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), state);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), district);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchStartDate+" - "+batchEndDate);	
			   Thread.sleep(4000);
			   aSp.clickToGetBatchActionMenu(batchID);
			   Thread.sleep(2000);
			   aSp.selectApplyToBatch(batchID);
			   Thread.sleep(2000);
			   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
			   aSp.clickOK();
		   }	   
		   else
		   {
			*/ aSp.selectState(state);
			   Thread.sleep(2000);
			   aSp.selectSector(expectedSector);
			   Thread.sleep(4000);
			   aSp.clickSearch();
			   Thread.sleep(4000);
			   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
			   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(domainJobRole));
			   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(platformJobRole));
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), state);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), district);
			   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));	
			   Thread.sleep(4000);
			   aSp.clickToGetBatchActionMenu(batchID);
			   Thread.sleep(2000);
			   aSp.selectApplyToBatch(batchID);
			   Thread.sleep(2000);
			   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
			   aSp.clickOK();
		 //  }
		   Thread.sleep(4000);
		   js.executeScript("window.scrollBy(0,-500)", "");
		   aSp.clickViewMyBatches();
		   Thread.sleep(2000);
		   Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG! No show of applied batch - "+batchID+" in View Batches <-> My Batches Section!!! ");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), state+"/"+district);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+", "+platformJobRole);  
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), "Applied");
		   SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		   Date date=new Date();
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), formatter.format(date));
		  //Accepted Batch - View Details Data Verification
		   aSp.clickToGetAcceptedBatchActionMenu(batchID);
		   Thread.sleep(2000);
		   aSp.selectAcceptedBatchViewDetails(batchID);
		   Thread.sleep(2000);
		   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicantview-batch-detailsBATCH%20CREATED"+batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), expectedSector);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), subSector);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[1]")).getText().trim(), expectedBatchFees);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Name of Training Center')]]])/div[1]")).getText().trim(), trainingCentreName);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), pTrainingStartDate+" to "+pTrainingEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
		   PostLoginPage plp=new PostLoginPage(driver);
		   plp.clickOnProfileLogo();
		   Thread.sleep(2000);
		   plp.clickOnLogout();
		   Thread.sleep(2000);
	   }
   }
   
   //Assessor Applicants Approval Process From Location Based TC and SSC
   @Test(dataProvider="registrationData", dependsOnMethods="assessorSearchAndApplyForAvailableBatchTC_05")
   public void tcApprovingAssessorApplicantsTC_06(String serialNum,String createdAssessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
   {
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   LoginPage lp=new LoginPage(driver);
	   lp.clickLogin();
	   EnterLoginPage elp=new EnterLoginPage(driver);
	   String tcID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields",1,14);
	   String tcPassword=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields",1,15);
	   String batchID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", 1, 1);
	   String batchType=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 9);
	   String batchSize=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", 1, 24);
	   String domainJobRole=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 7);
	   String domainJobRoleCode=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 8);
	   String platformJobRole=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 11);
	   String platformJobRoleCode=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "Configurable-Fields", 1, 12);
	   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", 1, 9);
	   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorTrainingBatches", 1, 10);
	   elp.performlogin(tcID, tcPassword);
	   Thread.sleep(2000);
	   LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)","");
	   Thread.sleep(4000);
	   tcDp.clickToViewBatches();
	   Thread.sleep(2000);
	   LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
	   tcVp.clickToViewAllAcceptedBatches();
	   Thread.sleep(4000);
	   Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
	   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchID+"']")).getText().trim(), batchID);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");   
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), batchSize);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Published");
	   tcVp.clikToGetBatchActionMenu(batchID);
	   Thread.sleep(4000);
	   tcVp.clickToSelectEnrollApplicantsOption(batchID);
	   Thread.sleep(4000);
	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID+"applied","OMG!!! navigation to Enroll Applicants Page is unsuccessful OR Something went wrong! ");   
	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+createdAssessorID+"']]")).size()==1,"OMG!!! No show of Assessor Applicant - "+createdAssessorID+" who has applied for the Batch - "+batchID+" OR Something went wrong! ");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]/td[2]")).getText().trim(), createdAssessorID);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]/td[3]")).getText().trim(), name);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]/td[4]")).getText().trim(), email);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]/td[5]")).getText().trim(), mobile);
	   tcVp.clickToGetApplicantActionMenu(createdAssessorID);
	   Thread.sleep(4000);
	   tcVp.selectViewDetailsOfApplicantOption(createdAssessorID);
	   Thread.sleep(4000);
	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-applicant-details"+batchID+createdAssessorID+"Assessor","OMG!!! navigation to View Applicant Details Page is unsuccessful OR Something went wrong! ");
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
	   if(!education1.equalsIgnoreCase("uneducated"))
	   {
		   Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
		   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
		   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
		   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
	   }
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[4]/label")).getText().trim(), industrial_sector2+" :");
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[5]/label")).getText().trim(), industrialExperienceDetails2);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[6]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
	   Assert.assertEquals(driver.findElement(By.xpath("//form[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
	   js.executeScript("window.scrollBy(0,-500)","");
	   Thread.sleep(2000);
	   tcVp.clickGoBack(); 
	   Thread.sleep(4000);
	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID+"applied","OMG!!! View Applicant Details - GoBack navigation to Applied Applicants Page Section is unsuccessfull OR Something went wrong! ");
	   if(serialNum.equals("1"))
	   {
		   tcVp.clickToSelectApplicantToBeEnrolled(createdAssessorID);
		   Thread.sleep(2000);
		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]//input[@name='Checkbox']")).isSelected(),"OMG!!! checkbox not selected for assessor applicant - "+createdAssessorID);
		   tcVp.clickToEnrollAllSelectedApplicants();
		   Thread.sleep(4000);
	   }
	   else
	   {
		   tcVp.clickToGetApplicantActionMenu(createdAssessorID);
		   Thread.sleep(4000);
		   tcVp.selectEnrollApplicantOption(createdAssessorID);
		   Thread.sleep(4000);
		   Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved successfully"),"OMG!!! Applicant Enroll Successfull Popup Text not displayed OR Something went wrong! ");
		   tcVp.clickOk();
		   Thread.sleep(4000);
	   }
	   tcVp.clickToGoToAppliedApplicantsSection();
	   Thread.sleep(2000);
	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdAssessorID+"')]]")).size()==0,"OMG!!! Enrolled Assessor Applicant - "+createdAssessorID+" Still present in Applied Applicants Section!!! OR Something went wrong! ");
	   tcVp.clickToGoToEnrolledApplicantsSection();
	   Thread.sleep(4000);
	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdAssessorID+"')]]")).size()==1,"OMG!!! No show of Enrolled Assessor Applicant - "+createdAssessorID+" in Enrolled Applicants Section!!! OR Something went wrong! ");
	   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+createdAssessorID+"']")).getText().trim(), createdAssessorID);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]/td[contains(text(),'"+name+"')]")).getText().trim(), name);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]/td[contains(text(),'"+email+"')]")).getText().trim(), email);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]/td[contains(text(),'"+mobile+"')]")).getText().trim(), mobile);
	   //Sending Batch To SSC For Approval
	   if(serialNum.equals("5"))
	   {
		   tcVp.clickToSendBatchForApproval();
		   Thread.sleep(4000);
		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Submitted for Approval");
		   Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been submitted for approval to SSC");
		   tcVp.clickOk();
		   Thread.sleep(4000);
		   tcVp.clickToViewAllAcceptedBatches();
		   Thread.sleep(4000);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Submitted for Approval");
	   }
	   else
	   {
		   tcVp.clickToGetApplicantActionMenu(createdAssessorID);
		   Thread.sleep(4000);
		   tcVp.selectViewDetailsOfApplicantOption(createdAssessorID);
		   Thread.sleep(4000);
		   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-applicant-details"+batchID+createdAssessorID+"Assessor","OMG!!! navigation to View Applicant Details Page is unsuccessful OR Something went wrong! ");
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
		   if(!education1.equalsIgnoreCase("uneducated"))
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
			   Assert.assertEquals(driver.findElement(By.xpath("//label[cotains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
			   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
			   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
		   }
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[4]/label")).getText().trim(), industrial_sector2+" :");
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[5]/label")).getText().trim(), industrialExperienceDetails2);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[6]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
		   Assert.assertEquals(driver.findElement(By.xpath("//form[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
	   }
	   PostLoginPage plp=new PostLoginPage(driver);
	   plp.clickOnProfileLogo();
	   Thread.sleep(2000);
	   plp.clickOnLogout();
	   Thread.sleep(2000);
   }
   
   //Applicants Rejection Test Cases
   @DataProvider
   public Object[][] applicantsRejectionBatchData()
   {
   		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData");
   }
   @Test(dataProvider="applicantsRejectionBatchData",dependsOnMethods="assessorMyProfileVerificationTC_02")
   public void tcRejectingAssessorApplicantsTC_07(String serialNo, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole,  String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String trainingCentreName, String trainingCentreID, String trainingCentrePassword, String tcBatchAcceptanceRemarks, String masterTrainerID, String masterTrainerName,  String masterTrainerPassword, String mtBatchAcceptanceRemarks, String mtAcceptedDate, String mtAcceptedTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String aaAcceptedDate, String aaAcceptedTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword,  String maBatchAcceptanceRemarks, String maAcceptedDate, String maAcceptedTime, String state, String district, String subDistrict) throws Exception
   {
	   	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   	LoginPage lp=new LoginPage(driver);
	   	lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickCreateBatch();
		Thread.sleep(6000);
		Assert.assertEquals(driver.findElement(By.name("sector")).getAttribute("value").trim(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(4000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(4000);
		sscTbcP.selectBatchCategory(batchCategory);
		Thread.sleep(4000);
		sscTbcP.selectTrainingStartDateForBatch();
		Thread.sleep(2000);
		sscTbcP.clickToCloseTrainingStartDateCalender();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.id("startDates")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),9,trainingStartDate);
		String trainingEndDate=driver.findElement(By.id("endDates")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),10,trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole);
		Thread.sleep(4000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(4000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickTocloseDomainTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		String domainTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),15,domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),16,domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),17,domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),18,domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+platformJobRoleCode+"')]")).isDisplayed(),"OMG!!! PlatformJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sscTbcP.selectPlatformTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickToclosePlatformTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		String platformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),19,platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),20,platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),21,platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),22,platformAssessmentEndDate);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.clickToGetInDetailBatchFees();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Fee Applicable for Program')]]]/td[2]")).getText().trim(), expectedBatchFees);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Technical QP(0) X Rate(800)')]]]/td[2]")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Non-Technical QP(0) X Rate(600)')]]]/td[2]")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Total Fee of the Program')]]]/td[2]")).getText().trim(), expectedBatchFees);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(2000);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(4000);
		if(driver.findElements(By.xpath("//div[@class='toast-message']")).size()!=0)
		{
			Assert.assertFalse(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().contains("Please fill all fields"),"OMG!!! Unable to create Batch! May be some data not entered OR Something went wrong! ");
		}
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),1,createdBatchID);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssccreate-new-batchbatch-assignment"+createdBatchID,"OMG!!! No show of Batch Assignment Page OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[span[contains(text(),'Sector')]]]/div[3])[1]")).getText().trim(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Sub Sector')]]]/div[3]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Type')]]]/div[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),1,createdBatchID);
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		Thread.sleep(4000);
		sscTbcP.selectStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterTrainingCentreIDToSearch(trainingCentreID);
		Thread.sleep(6000);
		sscTbcP.clickToGetSearchFilterResult();
		Thread.sleep(6000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).size()==1,"OMG!!! No show of Searched training Centre - "+trainingCentreID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).getText().trim(), trainingCentreID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		sscTbcP.clickToChooseResultedTrainingCentreToAssign(trainingCentreID);
		Thread.sleep(4000);
		sscTbcP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Training Centre Assigned\n"+createdBatchID+"\nis successfully assigned to   "+trainingCentreName+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).getText().trim(), trainingCentreID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//td/span[contains(text(),'Assigned')]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for domain and platform QP
		sscTbcP.clickDomainMasterTrainerAction();
		Thread.sleep(4000);
		sscTbcP.clickDomainAssignMasterTrainerOption();
		Thread.sleep(4000);
		sscTbcP.selectDomainMasterTrainerStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDomainMasterTrainerDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterDomainMasterTrainerIDToSearch(masterTrainerID);
		Thread.sleep(4000);
		sscTbcP.clickToGetDomainMasterSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+masterTrainerID+"')]")).getText().trim(), masterTrainerID);
		sscTbcP.clickToChooseDomainMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Master Trainer Assigned Successfully\n"+createdBatchID+"\nis successfully assigned to   "+masterTrainerID+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+masterTrainerID+"')]")).getText().trim(), masterTrainerName+" ( "+masterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'Assigned')]")).getText().trim(), "Assigned");
		sscTbcP.clickPlatformMasterTrainerAction();
		Thread.sleep(4000);
		sscTbcP.clickPlatformAssignMasterTrainerOption();
		Thread.sleep(4000);
		sscTbcP.selectPlatformMasterTrainerStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectPlatformMasterTrainerDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterPlatformMasterTrainerIDToSearch(masterTrainerID);
		Thread.sleep(4000);
		sscTbcP.clickToGetPlatformMasterSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+masterTrainerID+"')]")).getText().trim(), masterTrainerID);
		sscTbcP.clickToChoosePlatformMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+masterTrainerID+"')])[2]")).getText().trim(), masterTrainerName+" ( "+masterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		//Assigning Assessment Agency
		sscTbcP.clickDomainAssessmentAgencyAction();
		Thread.sleep(4000);
		sscTbcP.clickDomainAssignAssessmentAgencyOption();
		Thread.sleep(4000);
		sscTbcP.selectDomainAssessmentAgencyStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDomainAssessmentAgencyDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterDomainAssessmentAgencyIDToSearch(assessmentAgencyID);
		Thread.sleep(4000);
		sscTbcP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentAgencyID+"')]")).getText().trim(), assessmentAgencyID);
		sscTbcP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+assessmentAgencyID+"')])[1]")).getText().trim(), assessmentAgencyName+" ( "+assessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[3]")).getText().trim(), "Assigned");
		//Assigning Platform QP Assessment Agency
		sscTbcP.clickPlatformAssessmentAgencyAction();
		Thread.sleep(4000);
		sscTbcP.clickPlatformAssignAssessmentAgencyOption();
		Thread.sleep(4000);
		sscTbcP.selectPlatformAssessmentAgencyStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectPlatformAssessmentAgencyDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterPlatformAssessmentAgencyIDToSearch(assessmentAgencyID);
		Thread.sleep(4000);
		sscTbcP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentAgencyID+"')]")).getText().trim(), assessmentAgencyID);
		sscTbcP.clickToChoosePlatformAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+assessmentAgencyID+"')])[2]")).getText().trim(), assessmentAgencyName+" ( "+assessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[4]")).getText().trim(), "Assigned");
		Thread.sleep(4000);
		sscTbcP.clickToSubmitBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']/p/b")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),2,formatter.format(date));
		sscTbcP.clickOkForBatchSubmission();
		Thread.sleep(4000);
		PostLoginPage plp=new PostLoginPage(driver);
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//Assigned TC Login to Accept Batch
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
    	lp.clickLogin();
		elp.performlogin(trainingCentreID, trainingCentrePassword);
		Thread.sleep(6000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(createdBatchID);
		Thread.sleep(2000);
		lTcVbP.selectAcceptBatchOption(createdBatchID);
		Thread.sleep(4000);
		lTcVbP.enterRemarksForAcceptingBatch(tcBatchAcceptanceRemarks);
		Thread.sleep(4000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");	
		lTcVbP.clickOk();
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//Assigned Master Trainer Login To Accept the Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(masterTrainerID, masterTrainerPassword);
		Thread.sleep(2000);
		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
		tDp.clickToGetTrainerDashboard();
		Thread.sleep(2000);
		tDp.clickAllBatches();
		Thread.sleep(4000);
		TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
		tVp.clicktoGoPendingBatchesSection();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		tVp.clickToGetActionMenuOptions(createdBatchID);
		Thread.sleep(4000);
		tVp.clickToSelectAcceptBatchOption(createdBatchID);
		Thread.sleep(4000);
		tVp.enterRemarksForAcceptingBatch(mtBatchAcceptanceRemarks);
		Thread.sleep(4000);	
		tVp.clickToSubmit();
		Thread.sleep(2000);	
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),33,formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo),34, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");
		tVp.clickOk();
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//Assigned Assessment Agency Login to Accept and assigning master assessors for a batch
		lp.clickLogin();
		elp.performlogin(assessmentAgencyID, assessmentAgencyPassword);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagency","Login Unsuccessful!!! ");
		AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
		Thread.sleep(4000);
		aDp.clickBatchAssessmentRequests();
		Thread.sleep(2000);
		AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
		aVp.clickToViewPendingBatchRequests();
		Thread.sleep(2000);
		aVp.enterBatchIdToSearch(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! No show of batch - "+createdBatchID+" in "+assessmentAgencyID+" Pending Requests section!!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToSelectAcceptBatchOption();
		Thread.sleep(2000);
		aVp.enterRemarksForAcceptingBatch(aaBatchAcceptanceRemarks);
		Thread.sleep(2000);		
		aVp.clickToSubmitBatchAcceptance();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(),"You have successfully accepted "+createdBatchID);
		aVp.clickOk();
		Thread.sleep(4000);
		//verifying accepted batches & assigning assessors
		js.executeScript("window.scrollBy(0,-200)", "");
		Thread.sleep(2000);
		aVp.clickToViewAcceptedBatches();
		Thread.sleep(4000);
		aVp.enterBatchIdToSearch(createdBatchID);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! The Batch - "+createdBatchID+" is not found in Accepted Section!!! ");
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToSelectAssignAssessorsOption();
		Thread.sleep(4000);
		aVp.selectMasterAssessorForDomain(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(4000);
		aVp.selectMasterAssessorForPlatform(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(4000);
		aVp.clickToSubmitMasterAssessors();
		Thread.sleep(4000);
		aVp.clickOk();
		Thread.sleep(4000);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo), 39, formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo), 40, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//Master Assessor Login to Accept Batches
		lp.clickLogin();
		elp.performlogin(masterAssessorID, masterAssessorPassword);
		Thread.sleep(8000);
		AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
		maDp.clickToGetAssessorDashboard();
		Thread.sleep(4000);
		maDp.clickBatchAssessmentRequests();
		Thread.sleep(4000);
		AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		maVp.clickToGetActionMenuOptions(createdBatchID);
		Thread.sleep(4000);
		maVp.clickToSelectAcceptBatchOption(createdBatchID);
		Thread.sleep(4000);
		maVp.enterRemarksForAcceptingBatch(maBatchAcceptanceRemarks);
		Thread.sleep(4000);
		maVp.clickToSaveAndSubmitBatchAccceptance();
		Thread.sleep(4000);
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo), 45, formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ApplicantsRejectionBatchData",Integer.parseInt(serialNo), 46, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");
		maVp.clickOk();
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//Assessor Applicants Applying for Created Batch
		String assessorID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorRegistration", 1, 1);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		Thread.sleep(2000);
		elp.performlogin(assessorID, "Qwerty@123");
		AssessorApplicantDashboardPage aaDp=new AssessorApplicantDashboardPage(driver);
		Thread.sleep(6000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
		aaDp.clickToGetApplicantDashboard();
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		aaDp.clickSearchAndApplyforAvailableBatches();
		Thread.sleep(4000);
		AssessorApplicantSearchAndApplyForAvailableBatchesPage aSp=new AssessorApplicantSearchAndApplyForAvailableBatchesPage(driver);
		aSp.selectState(state);
		Thread.sleep(2000);
		aSp.selectSector(expectedSector);
		Thread.sleep(4000);
		aSp.clickSearch();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]")).size()==1,"OMG!!! no show of batch - "+createdBatchID+" searching by entering Only Mandatory fields! ");
		aSp.clickToGetBatchActionMenu(createdBatchID);
		Thread.sleep(2000);
		aSp.selectApplyToBatch(createdBatchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
		aSp.clickOK();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,-500)", "");
		aSp.clickViewMyBatches();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+createdBatchID+"']]")).size()==0,"OMG! No show of applied batch - "+createdBatchID+" in View Batches <-> My Batches Section!!! ");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//TC Rejecting Assessor Applicants
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(trainingCentreID, trainingCentrePassword);
		Thread.sleep(2000);
		LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(4000);
		tcDp.clickToViewBatches();
		Thread.sleep(2000);
		LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
		tcVp.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+createdBatchID+"']]")).size()==0, "OMG!!! Batch ID - "+createdBatchID+"  Not Found!!! in Accepted Section of "+trainingCentreID+" !!!");
		tcVp.clikToGetBatchActionMenu(createdBatchID);
		Thread.sleep(4000);
		tcVp.clickToSelectEnrollApplicantsOption(createdBatchID);
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+createdBatchID+"applied","OMG!!! navigation to Enroll Applicants Page is unsuccessful OR Something went wrong! ");   
		tcVp.clickToGetApplicantActionMenu(assessorID);
		Thread.sleep(4000);
		tcVp.selectRejectApplicantOption(assessorID);
		Thread.sleep(4000);
		tcVp.selectReasonForRejectingApplicant();
		Thread.sleep(4000);
		tcVp.enterRemarksForRejectingApplicant();
		Thread.sleep(4000);
		tcVp.clickToRejectApplicant();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applicant Rejected!!");
		tcVp.clickOk();
		Thread.sleep(2000);
		tcVp.clickToGoToAppliedApplicantsSection();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==0,"OMG!!! Rejected Assessor Applicant - "+assessorID+" Still present in Applied Applicants Section!!! OR Something went wrong! ");
		tcVp.clickToGoToEnrolledApplicantsSection();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==0,"OMG!!! Rejected Assessor Applicant - "+assessorID+" Present in Enrolled Applicants Section!!! OR Something went wrong! ");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//Verifying Applicant Rejection Status
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		Thread.sleep(2000);
		elp.performlogin(assessorID, "Qwerty@123");
		Thread.sleep(6000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
		aaDp.clickToGetApplicantDashboard();
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		aaDp.clickViewBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[1]")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[3]")).getText().trim(), state+"/"+district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[4]")).getText().trim(), domainJobRole+", "+platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[5]")).getText().trim(), "Rejected");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[6]")).getText().trim(), formatter.format(date));
		AssessorApplicantViewBatchesPage aaVp= new AssessorApplicantViewBatchesPage(driver);
		aaVp.clickToGetRejectedBatchActionMenu(createdBatchID);
		Thread.sleep(2000);
		aaVp.selectViewCommentsForRejection(createdBatchID);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Comments by Training Centre')]")).getText().contains(formatter.format(date)));
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Other')]")).getText().trim(), "Other");
		aaVp.clickToCloseTC_CommentsView();
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
   }
}