package com.nsdc.regressionTest;

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
import com.nsdc.pages.AssessorApplicantDashboardPage;
import com.nsdc.pages.AssessorApplicantSearchAndApplyForAvailableBatchesPage;
import com.nsdc.pages.AssessorMyProfilePage;
import com.nsdc.pages.AssessorRegistrationPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.testConfig.TestConfiguration;

public class AssessorWorkflowTestSC_04 extends TestConfiguration
{
	String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	@DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorRegistration");
    }
    
    @Test(dataProvider="registrationData")
    public void assessorRegistrationTC_01(String serialNum,String createdAssessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
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
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in Personal Information Section, Its Blocking further Applicant Registration Process!!!");
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
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in Contact & Address Details Section, Its Blocking further Applicant Registration Process!!!");
    	Thread.sleep(8000);
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
        assessor.deleteThirdIndustrialExperienceDetails();
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
        assessor.deleteThirdTrainingExperienceDetails();
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
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in Education & Work Details Section, Its Blocking further Applicant Registration Process!!!");
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
       // Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[1]")).getText().trim(), preferredJobRole1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[2]")).getText().trim(), preferredSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[4]")).getText().trim(), preferredState1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[5]")).getText().trim(), preferredDistrict1);
      //  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[6]")).getText().trim(), preferredSubDistrict1);
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
     //   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[1]")).getText().trim(), preferredJobRole2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[2]")).getText().trim(), preferredSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[3]")).getText().trim(), preferredSubSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[4]")).getText().trim(), preferredState2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[5]")).getText().trim(), preferredDistrict2);
      //  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[6]")).getText().trim(), preferredSubDistrict2);
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
      //  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[1]")).getText().trim(), preferredJobRole3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[2]")).getText().trim(), preferredSector3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[3]")).getText().trim(), preferredSubSector3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[4]")).getText().trim(), preferredState3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[5]")).getText().trim(), preferredDistrict3);
      //  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[6]")).getText().trim(), preferredSubDistrict3);
        //deleting 3rd preference
        Thread.sleep(2000);
        assessor.clickToDeleteThirdPreference();
        Thread.sleep(4000);
        Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]")).size()==0,"OMG!!! deleted third preference still present OR Something is wrong! ");
        assessor.clickOnSaveAndContinue();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in My Preferences & My Associations Section, Its Blocking further Applicant Registration Process!!!");
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
      
    @Test(dataProvider="registrationData", dependsOnMethods="assessorRegistrationTC_01")
    public void assessorMyProfileVerificationTC_02(String serialNum,String createdAssessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
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
    	//Verifying Registered Details
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Name of the Applicant')]]/span[2]")).getText().trim(), name);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Date Of Birth')]]/span[2]")).getText().trim(), dob.replaceAll("/", "-"));
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Gender')]]/span[2]")).getText().trim(), gender);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Languages Known')]]/span[2]")).getText().replaceAll(" ", "").replaceAll(",", ""), language.replaceAll(",", ""));
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Religion')]]/span[2]")).getText().trim(), religion);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Category')]]/span[2]")).getText().trim(), category);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Mobile Number')]]/span[2]")).getText().trim(), mobile);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Email')]]/span[2]")).getText().trim(), email);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Applicant Address')]]/span[2]")).getText().trim(), address);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Landmark')]]/span[2]")).getText().trim(), landmark);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Pincode')]]/span[2]")).getText().trim(), pincode);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'State')]]/span[2]")).getText().trim(), state);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'District')]]/span[2]")).getText().trim(), city);
      	Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Mandal')]]/span[2]")).getText().trim(), mandal);
      	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[1]")).getText().contains(education1));
        Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[3]")).getText().trim(), edu_details1);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[4]")).getText().contains(edu_document1));
        Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[5]")).getText().contains(education2));
        Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[7]")).getText().trim(), edu_details2);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[8]")).getText().contains(edu_document2));
      	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[1]")).getText().contains(industrial_sector1));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[3]")).getText().trim(), industrialExperienceDetails1);
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[4]")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[6]")).getText().contains(industrial_sector2));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[8]")).getText().trim(), industrialExperienceDetails2);
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[9]")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[1]")).getText().contains(training_sector1));
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[3]")).getText().contains(trainingExperienceDetails1));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[4]")).getText().trim(), trainingExperienceYears1+" years "+trainingExperienceMonths1+" months");
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[6]")).getText().contains(training_sector2));
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[8]")).getText().contains(trainingExperienceDetails2));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[9]")).getText().trim(), trainingExperienceYears2+" years "+trainingExperienceMonths2+" months");
  /*    Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[1]")).getText().trim(), preferredJobRole1+", "+preferredJobRoleCode1);
      	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[2]")).getText().trim(), preferredSector1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[4]")).getText().trim(), preferredDistrict1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[5]")).getText().trim(), preferredSubDistrict1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[1]")).getText().trim(), preferredJobRole2+", "+preferredJobRoleCode2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[2]")).getText().trim(), preferredSector2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[3]")).getText().trim(), preferredSubSector2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[4]")).getText().trim(), preferredDistrict2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[5]")).getText().trim(), preferredSubDistrict2);
   */  	Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[h5[contains(text(),'Applicant Type')]]]]/div[4]")).getText().trim(), userType);
    	//Edit Profile
       	aMpP.clickEditProfile();
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
    	aMpP.clickOK();
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
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+education1+"']")).getText().trim(), education1);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+education1+"']]/td[4]")).getText().trim(), "Yes");
    	//Education Record 2
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+education2+"']")).getText().trim(), education2);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+education2+"']]/td[4]")).getText().trim(), "Yes");
    	//Adding Education Record
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
       	//Adding 3rd industrial record
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
    	//Adding 3rd Training Experience Details Record
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
    	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Apparel')]])[2]/td[4]")).getText().trim(), "11 months");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Apparel')]])[2]/td[5]")).getText().trim(), "Yes");
    	aMpP.clickCurriculumVitaeBrowse();
    	Thread.sleep(2000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(4000);
    	aMpP.clickCurriculumVitaeUpload();
    	Thread.sleep(8000);
    	aMpP.clickSaveChanges2();
    	Thread.sleep(4000);
    	aMpP.clickOK();
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
    
    @Test(dataProvider="registrationData", dependsOnMethods="assessorRegistrationTC_01")
    public void addMyPreferences_03(String serialNum,String createdAssessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
    {
 	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   LoginPage lp=new LoginPage(driver);
 	   lp.clickLogin();
 	   Thread.sleep(2000);
 	   EnterLoginPage elp=new EnterLoginPage(driver);
 	   elp.performlogin(createdAssessorID, "Qwerty@123");
 	   Thread.sleep(10000);
 	   AssessorApplicantDashboardPage aDp=new AssessorApplicantDashboardPage(driver);
 	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
 	   aDp.clickToGetApplicantDashboard();
 	   JavascriptExecutor js=(JavascriptExecutor)driver;
 	   js.executeScript("window.scrollBy(0,200)", "");
 	   Thread.sleep(4000);
 	   aDp.clickSearchAndApplyforAvailableBatches();
 	   Thread.sleep(4000);
 	   AssessorApplicantSearchAndApplyForAvailableBatchesPage aSp=new AssessorApplicantSearchAndApplyForAvailableBatchesPage(driver);
 	   aSp.selectState(state);
 	   Thread.sleep(2000);
 	   aSp.selectDistrict(city);
 	   Thread.sleep(2000);
 	   aSp.selectSubDistrict(mandal);
 	   Thread.sleep(2000);
 	   aSp.selectSector(preferredSector3);
 	   Thread.sleep(2000);
 	   aSp.selectSubSector(preferredSubSector3);
 	   Thread.sleep(2000);
 	   aSp.selectjobRole(preferredJobRole3);
 	   Thread.sleep(6000);
 	   //Add My Search Preferences
 	   aSp.clickAddJobRoleAndLocationToMyPreference();
 	   Thread.sleep(4000);
 	   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Preference Added Successfully");
 	   aSp.clickOK();
 	   Thread.sleep(2000);
 	   js.executeScript("window.scrollBy(0,-200)", "");
 	   Thread.sleep(2000);
 	   aSp.clickMyPreferences();
 	   Thread.sleep(4000);
 	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]")).size()==1);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[1]")).getText().trim(), preferredJobRole3);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[2]")).getText().trim(), preferredSector3);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[3]")).getText().trim(), preferredSubSector3);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[4]")).getText().trim(), state);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[5]")).getText().trim(), city);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[6]")).getText().trim(), mandal);
 	   PostLoginPage plp=new PostLoginPage(driver);
 	   plp.clickOnProfileLogo();
 	   Thread.sleep(2000);
 	   plp.clickOnLogout();
 	   Thread.sleep(2000);
    }
}