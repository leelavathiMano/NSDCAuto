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
import com.nsdc.pages.AssessorDashboardPage;
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
import com.nsdc.pages.TrainerMyProfilePage;
import com.nsdc.pages.TrainerRegistrationPage;
import com.nsdc.pages.TrainerViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class TrainerWorkflowTestSC_03 extends TestConfiguration
{
	String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	@DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerRegistration");
    }
     
    @Test(dataProvider="registrationData")
    public void trainerRegistrationTC_01(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP, String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
    {
        //DatabaseConnection.deleteTrainer(email);
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
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().trim().startsWith("Duplicate"),"new trainer credentials only");
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElement(By.xpath("//button[contains(text(),'Register')]")).isDisplayed(), "Trainer Registration:Duplicate Email OR Mobile Number!!! ");
		}
		else
		{
			Thread.sleep(2000);
			rp.enterEmailOTP(emailOTP);
			Thread.sleep(2000);
			rp.enterMobileOTP(mobileOTP);
        	Thread.sleep(2000);
        	rp.clickVerify();
		}
        Thread.sleep(4000);
        String createdTrainer=driver.findElement(By.xpath("//div[@class='m-login__signin']/h3/span")).getText();
        ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerRegistration", Integer.parseInt(serialNum), 1, createdTrainer);
        String username = driver.findElement(By.xpath("//span[@class='text-bold']")).getText();
		rp.clickGoToLogin();
		Thread.sleep(2000);
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, "ekaushal");
        Thread.sleep(2000);
        rp.enterOldPassword(oldPassword);
        Thread.sleep(2000);
        rp.enterNewPassword(newPassword);
        Thread.sleep(2000);
        rp.enterConfirmPassword(confirmPassword);
        Thread.sleep(4000);
        rp.clickResetResubmit();
        Thread.sleep(6000);
        rp.clickConfirmationOkMessage();
        elp.performlogin(username, confirmPassword);
        Thread.sleep(10000);
        TrainerRegistrationPage trainer = new TrainerRegistrationPage(driver);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).getAttribute("value"), name);
        trainer.selectGender(gender);
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,150)", "");
        trainer.selectDateOfBirth();
        Thread.sleep(4000);
        String selectedDateOfBirth=driver.findElement(By.id("dob")).getAttribute("value");
        ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerRegistration", Integer.parseInt(serialNum), 12, selectedDateOfBirth);   
        if(language.equals("Kannada,English,Hindi"))
        {
        	trainer.selectAllLanguages();
        }
        else if(language.equals("Kannada,Hindi"))
        {
        	trainer.selectTwoKnownLanguages();
        }
        else
        {
        	trainer.selectAnyKnownLanguage(language);
        }
        Thread.sleep(2000);
        trainer.selectReligion(religion);
        Thread.sleep(2000);
        trainer.selectCategory(category);
        Thread.sleep(2000);
        if(disability.equals("None"))
        {
        	trainer.selectDisability(disability);
        }
        else
        {
        	trainer.selectDisability(disability);
        	Thread.sleep(2000);
        	trainer.clickOnBrowseForUploadDisabilityDocument();
        	Thread.sleep(4000);
        	UploadFile.upload(disabilityFile);
           	Thread.sleep(4000);
           	trainer.clickOnUploadButtonForUploadDisabilityDocument();
           	Thread.sleep(8000);
        }
        Thread.sleep(2000);
        String aadharPan = aadhaarOrPAN.toLowerCase();
        if(aadharPan.equals("aadhaar"))
        {
           trainer.clickOnAadharNumberRadioButton();
           trainer.enterAadharNumber(idNumber);
           Thread.sleep(2000);
           trainer.clickOnValidateAadharNumber();
           Thread.sleep(2000);
           Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='aadhaarIdentity']/div/span")).getText(), "Verified");
        }
        else if(aadharPan.equals("pan"))
        {
           trainer.clickOnPanNumberRadioButton();
           Thread.sleep(2000);
           trainer.enterPanNumber(idNumber);
       	   Thread.sleep(2000);
           trainer.clickOnBrowseFileButtonForUploadPanDocument();
           Thread.sleep(4000);
           UploadFile.upload(uploadPanDocument);
           Thread.sleep(4000);
           trainer.clickOnUploadButtonToUploadPan();
           Thread.sleep(8000);
        }
        Thread.sleep(2000);
        trainer.clickOnBrowseFileButtonToUploadPhoto();
        Thread.sleep(4000);
        UploadFile.upload(photoFile);
        Thread.sleep(5000);
        trainer.clickOnUploadButtonToUploadPhoto();
        Thread.sleep(8000);
        if(applicant_Category.equals("Trainer,Master Trainer"))
        {
          	trainer.selectAllApplicantCategory();
        }
        else if(applicant_Category.equals("Trainer") || applicant_Category.equals("Master Trainer"))
        {
          	trainer.selectAnyApplicantCategory(applicant_Category);
        }
        Thread.sleep(5000);
        trainer.clickOnSaveAndContinue();
    	Thread.sleep(8000);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='phone']")).getAttribute("value"), mobile);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='email']")).getAttribute("value"), email);
        trainer.enterApplicantAddress(address);
    	Thread.sleep(5000);
        trainer.enterNearbyLandmark(landmark);
    	Thread.sleep(2000);
        trainer.enterPincode(pincode);
    	Thread.sleep(2000);
        trainer.selectStateOrUnionTerritory(state);
    	Thread.sleep(4000);
        trainer.selectDistrictOrCity(city);
    	Thread.sleep(2000);
        trainer.selectTehsilOrMandal(mandal);
    	Thread.sleep(2000);
        trainer.selectParliamentaryConstituency(parliamentaryConstituency);
        Thread.sleep(2000);
        trainer.clickOnSaveAndContinue();
    	Thread.sleep(8000);
        if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
        {
          	trainer.selectEducationAttained(education1);
          	Assert.assertTrue(driver.findElements(By.xpath("//label[contains(text(),'Details of Education')]")).size()==0,"OMG!!! Education Details Fields should be hidden in case of Un-Educated Applicant!!! ");
        }
        else
        {
          	trainer.selectEducationAttained(education1);
        	Thread.sleep(2000);
          	trainer.enterDetailsOfEducation(edu_details1);
        	Thread.sleep(2000);
           	trainer.clickOnBrowseForUploadEducationProofDocument();
           	Thread.sleep(2000);
           	UploadFile.upload(edu_document1);
           	Thread.sleep(4000);
           	trainer.clickOnUploadForUploadEducationProofDocument();
           	Thread.sleep(8000);
           	trainer.clickOnAddEducationDetailsButton();
        	Thread.sleep(2000);
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education1+"')]")).getText(), education1);
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details1+"')]")).getText(), edu_details1);
           	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[1]")).getText(), "yes");
           	Thread.sleep(4000);
           	trainer.selectEducationAttained(education2);
        	Thread.sleep(2000);
           	trainer.enterDetailsOfEducation(edu_details2);
        	Thread.sleep(2000);
           	trainer.clickOnBrowseForUploadEducationProofDocument();
           	Thread.sleep(2000);
           	UploadFile.upload(edu_document2);
           	Thread.sleep(4000);
           	trainer.clickOnUploadForUploadEducationProofDocument();
           	Thread.sleep(8000);
           	trainer.clickOnAddEducationDetailsButton();
        	Thread.sleep(2000);
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education2+"')]")).getText(), education2);
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details2+"')]")).getText(), edu_details2);
           	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[2]")).getText(), "yes");
           	Thread.sleep(4000);
           	trainer.selectEducationAttained(education3);
        	Thread.sleep(2000);
           	trainer.enterDetailsOfEducation(edu_details3);
        	Thread.sleep(2000);
           	trainer.clickOnBrowseForUploadEducationProofDocument();
           	Thread.sleep(2000);
           	UploadFile.upload(edu_document3);
           	Thread.sleep(5000);
           	trainer.clickOnUploadForUploadEducationProofDocument();
           	Thread.sleep(8000);
           	trainer.clickOnAddEducationDetailsButton();
        	Thread.sleep(2000);
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education3+"')]")).getText(), education3);
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details3+"')]")).getText(), edu_details3);
           	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[3]")).getText(), "yes");
           	trainer.deleteThirdEducationDetails();
        	Thread.sleep(2000);
        }
        trainer.selectRelevantSectorForIndustrialExperience(industrial_sector1);
        Thread.sleep(2000);
        trainer.selectYearsForIndustrialExperience(industrial_years1);
        Thread.sleep(2000);
        trainer.selectMonthsForIndustrialExperience(industrial_months1);
        Thread.sleep(2000);
        trainer.enterDetailsOfIndustrialExperience(industrialExperienceDetails1);
        Thread.sleep(2000);
        trainer.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails1);
        Thread.sleep(2000);
        trainer.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(industrialDocument1);
        Thread.sleep(4000);
        trainer.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(8000);
        trainer.clickOnAddIndustrialExperienceDetails();
    	Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector1+"')]")).getText(), industrial_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails1+"')]")).getText(), industrialExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[1]")).getText(), "Yes");
        trainer.selectRelevantSectorForIndustrialExperience(industrial_sector2);
        Thread.sleep(2000);
        trainer.selectYearsForIndustrialExperience(industrial_years2);
        Thread.sleep(2000);
        trainer.selectMonthsForIndustrialExperience(industrial_months2);
        Thread.sleep(2000);
        trainer.enterDetailsOfIndustrialExperience(industrialExperienceDetails2);
        Thread.sleep(2000);
        trainer.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails2);
        Thread.sleep(2000);
        trainer.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(industrialDocument2);
        Thread.sleep(4000);
        trainer.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(8000);
        trainer.clickOnAddIndustrialExperienceDetails();
    	Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector2+"')]")).getText(), industrial_sector2);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails2+"')]")).getText(), industrialExperienceDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[2]")).getText(), "Yes");
        trainer.selectRelevantSectorForIndustrialExperience(industrial_sector3);
        Thread.sleep(2000);
        trainer.selectYearsForIndustrialExperience(industrial_years3);
        Thread.sleep(2000);
        trainer.selectMonthsForIndustrialExperience(industrial_months3);
        Thread.sleep(2000);
        trainer.enterDetailsOfIndustrialExperience(industrialExperienceDetails3);
        Thread.sleep(2000);
        trainer.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails3);
        Thread.sleep(2000);
        trainer.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(industrialDocument3);
        Thread.sleep(5000);
        trainer.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(10000);
        trainer.clickOnAddIndustrialExperienceDetails();
    	Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector3+"')]")).getText(), industrial_sector3);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails3+"')]")).getText(), industrialExperienceDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText(), "Yes");
        Thread.sleep(2000);
        //checking education attained for "uneducated" becoz in case of all "uneducated", xpath of industrial and training experience details "delete" buttons will vary so
        if(education1.equals("Uneducated") || education2.equals("Uneducated") || education3.equals("Uneducated"))
        {
          	trainer.deleteThirdIndustrialExperienceDetailsWithoutEducationDetail();
        }
        else
        {
          	trainer.deleteThirdIndustrialExperienceDetails();
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
    	trainer.selectRelevantSectorForTrainingExperience(training_sector1);
    	Thread.sleep(2000);
       	trainer.selectyearsForTrainingExperience(trainingExperienceYears1);
        Thread.sleep(2000);
       	trainer.selectMonthsForTrainingExperience(trainingExperienceMonths1);
        Thread.sleep(2000);
       	trainer.enterTrainingExperienceDetails(trainingExperienceDetails1);
        Thread.sleep(2000);
       	trainer.clickOnBrowseForTrainingExperienceProofDocument();
       	Thread.sleep(4000);
       	UploadFile.upload(trainingDocument1);
       	Thread.sleep(5000);
       	trainer.clickOnUploadForTrainingExperienceProofDocument();
       	Thread.sleep(8000);
        trainer.clickOnAddTrainingExperienceDetails();
    	Thread.sleep(2000);
       	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector1+"')]")).getText(), training_sector1);
       	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails1+"')]")).getText(), trainingExperienceDetails1);
       	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText(), "Yes");
       	trainer.selectRelevantSectorForTrainingExperience(training_sector2);
        Thread.sleep(2000);
       	trainer.selectyearsForTrainingExperience(trainingExperienceYears2);
        Thread.sleep(2000);
       	trainer.selectMonthsForTrainingExperience(trainingExperienceMonths2);
        Thread.sleep(2000);
       	trainer.enterTrainingExperienceDetails(trainingExperienceDetails2);
        Thread.sleep(2000);
       	trainer.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(trainingDocument2);
        Thread.sleep(5000);
        trainer.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(8000);
        trainer.clickOnAddTrainingExperienceDetails();
     	Thread.sleep(2000);
       	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector2+"')]")).getText(), training_sector2);
       	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails2+"')]")).getText(), trainingExperienceDetails2);
       	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[4]")).getText(), "Yes");
       	trainer.selectRelevantSectorForTrainingExperience(training_sector3);
        Thread.sleep(2000);
        trainer.selectyearsForTrainingExperience(trainingExperienceYears3);
        Thread.sleep(2000);
       	trainer.selectMonthsForTrainingExperience(trainingExperienceMonths3);
        Thread.sleep(2000);
       	trainer.enterTrainingExperienceDetails(trainingExperienceDetails3);
        Thread.sleep(2000);
       	trainer.clickOnBrowseForTrainingExperienceProofDocument();
       	Thread.sleep(4000);
       	UploadFile.upload(trainingDocument3);
       	Thread.sleep(5000);
       	trainer.clickOnUploadForTrainingExperienceProofDocument();
       	Thread.sleep(8000);
       	trainer.clickOnAddTrainingExperienceDetails();
     	Thread.sleep(2000);
       	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector3+"')]")).getText(), training_sector3);
       	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails3+"')]")).getText(), trainingExperienceDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[5]")).getText(), "Yes");
       	if(education1.equals("Uneducated") || education2.equals("Uneducated") || education3.equals("Uneducated"))
       	{
       		trainer.deleteThirdTrainingExperienceWithoutEducationDetails();
       	}
       	else
       	{
       		 trainer.deleteThirdTrainingExperienceDetails();
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
    	trainer.clickOnBrowseForCurriculumVitaeOrResume();
    	Thread.sleep(4000);
        UploadFile.upload(resume);
        Thread.sleep(5000);
        trainer.clickOnUploadForCurriculumVitaeOrResume();
        Thread.sleep(8000);
        trainer.clickOnSaveAndContinue();
        Thread.sleep(5000);
        //Preference 1
        trainer.selectPreferredSector(preferredSector1);
        Thread.sleep(4000);
        trainer.selectPreferredSubSector(preferredSubSector1);
        Thread.sleep(4000);
        trainer.selectPreferredJobRole(preferredJobRole1);
        Thread.sleep(4000);
        trainer.selectPreferredState(preferredState1);
        Thread.sleep(4000);
        trainer.selectPreferredDistrict(preferredDistrict1);
        Thread.sleep(4000);
        trainer.selectPreferredSubDistrict(preferredSubDistrict1);
        Thread.sleep(4000);
        trainer.clickAddPreferences();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[1]")).getText().trim(), preferredJobRole1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[2]")).getText().trim(), preferredSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[4]")).getText().trim(), preferredState1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[5]")).getText().trim(), preferredDistrict1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[6]")).getText().trim(), preferredSubDistrict1);
        //preference 2
        Thread.sleep(4000);
        trainer.selectPreferredSector(preferredSector2);
        Thread.sleep(4000);
        trainer.selectPreferredSubSector(preferredSubSector2);
        Thread.sleep(4000);
        trainer.selectPreferredJobRole(preferredJobRole2);
        Thread.sleep(4000);
        trainer.selectPreferredState(preferredState2);
        Thread.sleep(4000);
        trainer.selectPreferredDistrict(preferredDistrict2);
        Thread.sleep(4000);
        trainer.selectPreferredSubDistrict(preferredSubDistrict2);
        Thread.sleep(4000);
        trainer.clickAddPreferences();
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[1]")).getText().trim(), preferredJobRole2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[2]")).getText().trim(), preferredSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[3]")).getText().trim(), preferredSubSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[4]")).getText().trim(), preferredState2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[5]")).getText().trim(), preferredDistrict2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[6]")).getText().trim(), preferredSubDistrict2);
        //preference 3
        Thread.sleep(4000);
        trainer.selectPreferredSector(preferredSector3);
        Thread.sleep(4000);
        trainer.selectPreferredSubSector(preferredSubSector3);
        Thread.sleep(4000);
        trainer.selectPreferredJobRole(preferredJobRole3);
        Thread.sleep(4000);
        trainer.selectPreferredState(preferredState3);
        Thread.sleep(4000);
        trainer.selectPreferredDistrict(preferredDistrict3);
        Thread.sleep(4000);
        trainer.selectPreferredSubDistrict(preferredSubDistrict3);
        Thread.sleep(4000);
        trainer.clickAddPreferences();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[1]")).getText().trim(), preferredJobRole3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[2]")).getText().trim(), preferredSector3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[3]")).getText().trim(), preferredSubSector3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[4]")).getText().trim(), preferredState3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[5]")).getText().trim(), preferredDistrict3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole3+"')]]/td[6]")).getText().trim(), preferredSubDistrict3);
        //deleting 3rd preference
        Thread.sleep(4000);
        trainer.clickToDeleteThirdPreference();
        Thread.sleep(4000);
        Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+preferredJobRole3+"')]")).size()==0,"OMG!!! deleted third preference still present OR Something is wrong! ");
        trainer.clickOnSaveAndContinue();
        Thread.sleep(5000);
        trainer.clickIAgreeCheckbox();
        Thread.sleep(2000);
        trainer.clickSubmitButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Thank You']")).getText(), "Thank You");
        trainer.clickLogOutButton();
        Thread.sleep(2000);
        String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", ""),"Logout Unsuccessful");
    }
     
    @Test(dataProvider="registrationData",dependsOnMethods="trainerRegistrationTC_01")
    public void trainerMyProfileVerificationTC_02(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP, String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
    {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
    	LoginPage lp=new LoginPage(driver);
       	lp.clickLogin();
       	EnterLoginPage elp=new EnterLoginPage(driver);
       	elp.performlogin(createdTrainerID, confirmPassword);
       	Thread.sleep(2000);
       	TrainerMyProfilePage tMpP=new TrainerMyProfilePage(driver);
       	tMpP.clickProfile();
       	Thread.sleep(2000);
       	Assert.assertEquals(tMpP.getNameOfTheApplicant(),name);
       	Assert.assertEquals(tMpP.getGenderOfApplicant(), gender);
       	Assert.assertEquals(tMpP.getDateOfBirth(), dob);
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
      	Assert.assertEquals(tMpP.getReligion(), religion);
       	Assert.assertEquals(tMpP.getCategory(), category);
       	Assert.assertEquals(tMpP.getDisability(), disability);
       	String aadharPan = aadhaarOrPAN.toLowerCase();
        if(aadharPan.equals("aadhaar"))
        {
        	Assert.assertEquals(tMpP.getAadharNumVerificationStatus(), "Verified");
        }
        else if(aadharPan.equals("pan"))
        {
        	Assert.assertEquals(tMpP.getPanNumVerificationStatus(), "Verified");
        }
       	Thread.sleep(2000);
       	tMpP.clickBrowseFile();
    	Thread.sleep(2000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(4000);
    	tMpP.clickUploadfile();
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
       	tMpP.clickSaveChanges1();
       	Thread.sleep(4000);
       	//Trainer Contact and Address verification
       	JavascriptExecutor js=(JavascriptExecutor)driver;
       	js.executeScript("window.scrollBy(0,-1000)","");
       	Thread.sleep(2000);
       	tMpP.clickContactAndAddress();
       	Thread.sleep(4000);
       	Assert.assertEquals(tMpP.getMobileNumOfApplicant(), mobile);
       	Assert.assertEquals(tMpP.getEmailOfApplicant(), email);
       	Assert.assertEquals(tMpP.getAddressOfApplicant(), address);
       	Assert.assertEquals(tMpP.getNearByLandMark(), landmark);
       	Assert.assertEquals(tMpP.getPincode(), pincode);
       	Assert.assertEquals(tMpP.getState(), state);
       	Assert.assertEquals(tMpP.getDistrict(), city);
       	Assert.assertEquals(tMpP.getTehsil(), mandal);
       	Assert.assertEquals(tMpP.getParlimentaryConstituency(), parliamentaryConstituency);
       	//Education & Work verification
       	Thread.sleep(2000);
       	tMpP.clickEducationAndWork();
       	Thread.sleep(2000);
        if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
        {
           Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table table-striped'])[1]/tbody")).getText(), "No record found");
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
        tMpP.clickToAddEducationDetails();
    	Thread.sleep(2000);
    	tMpP.selectEducationAttained("Uneducated");
    	Thread.sleep(2000);
    	Assert.assertTrue(driver.findElements(By.xpath("//label[contains(text(),'Details of Education:')]")).size()==0, "OMG!!! Education Details Fields should be hidden in case of UnEducated!! ");
    	//Adding Education Record and Deletion
    	tMpP.selectEducationAttained("Others");
    	Thread.sleep(2000);
    	Assert.assertFalse(driver.findElements(By.xpath("//label[contains(text(),'Details of Education:')]")).size()==0, "OMG!!! Education Details Fields should be displayed in case of Other Education Attained Type!! ");
    	tMpP.enterDetailsOfEducation("Others Education Selected");
    	Thread.sleep(2000);
    	tMpP.clickToBrowseForEducationProofDocument();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(5000);
    	tMpP.clickToUploadSelectedEducationProofDoc();
    	Thread.sleep(8000);
    	tMpP.clickToSubmitEducationDetails();
    	Thread.sleep(2000);
    	Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'Others')]")).size()!=0,"OMG!!! No show of Added Educational Record for Profile of "+createdTrainerID+" !!! ");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Others')]")).getText().trim(), "Others");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Others Education Selected')]")).getText().trim(), "Others Education Selected");
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='Others']]/td[4]")).getText().trim(), "Yes");
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
    	{
    		tMpP.clickToDeleteAddedFirstEducationDetailsRecord();
    	}
    	else
    	{
    		tMpP.clickToDeleteThirdEducationDetailsRecord();
    	}
    	Thread.sleep(4000);
    	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'Others')]]")).size()==0,"OMG!!! Deleted Third Education Details Record present itseems!!! Or Something wrong!!! ");
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
    	tMpP.clickToAddIndustrialExperienceDetails();
    	Thread.sleep(2000);
    	tMpP.selectIndustrialSector();
    	Thread.sleep(2000);
    	tMpP.selectIndustrialYears();
    	Thread.sleep(2000);
    	tMpP.selectIndustrialMonths();
    	Thread.sleep(2000);
    	tMpP.enterDetailsOfIndustrialExperience();
    	Thread.sleep(2000);
    	tMpP.clickToBrowseForIndustrilExperienceProofDocument();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(5000);
    	tMpP.clickToUploadSelectedIndustrialExperienceProofDoc();
    	Thread.sleep(8000);
    	tMpP.clickToSubmitIndustrialExperienceDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Apparel')]")).getText().trim(), "Apparel");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Industrial Experience in Apparel Sector')]")).getText().trim(), "Industrial Experience in Apparel Sector");
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='Apparel']]/td[5]")).getText().trim(), "11 months");
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='Apparel']]/td[6]")).getText().trim(), "Yes");
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
    	{
    		
        	tMpP.clickToDeleteAddedThirdIndustrialExperienceDetailsRecordInCaseOfUneducated();
    	}
    	else
    	{
    		tMpP.clickToDeleteThirdIndustrialExperienceDetailsRecord();
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
    	//3rd Training Experience Details Record Adding and Deleting
    	tMpP.clickToAddTrainingExperienceDetails();
    	Thread.sleep(2000);
    	tMpP.selectTrainingSector();
    	Thread.sleep(2000);
    	tMpP.selectTrainingYears();
    	Thread.sleep(2000);
    	tMpP.selectTrainingMonths();
    	Thread.sleep(2000);
    	tMpP.enterDetailsOfTrainingExperience();
    	Thread.sleep(2000);
    	tMpP.clickToBrowseForTrainingExperienceProofDocument();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(5000);
    	tMpP.clickToUploadSelectedTrainingExperienceProofDoc();
    	Thread.sleep(8000);
    	tMpP.clickToSubmitTrainingExperienceDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Apparel')]")).getText().trim(), "Apparel");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Training Experience in Apparel Sector')]")).getText().trim(), "Training Experience in Apparel Sector");
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Apparel')]]/td[4]")).getText().trim(), "11 months");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Apparel')]]/td[5]")).getText().trim(), "Yes");
    	if(education1.equals("Uneducated") && education2.equals("Uneducated") && education3.equals("Uneducated"))
    	{
    		tMpP.clickToDeleteAddedThirdTrainingExperienceDetailsRecordInCaseOfUneducated();
    	}
    	else
    	{
    		tMpP.clickToDeleteThirdTrainingExperienceDetailsRecord();
    	}
    	Thread.sleep(2000);
    	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'Apparel')]]")).size()==0,"OMG!!! Deleted Third Training Experirnce Details Record present itseems!!! Or Something wrong!!! ");
    	Thread.sleep(2000);
       	tMpP.clickCurriculumVitaeBrowse();
    	Thread.sleep(2000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(4000);
    	tMpP.clickCurriculumVitaeUpload();
    	Thread.sleep(8000);
    	tMpP.clickSaveChanges2();
    	Thread.sleep(4000);
       	js.executeScript("window.scrollBy(0,-1500)","");
       	Thread.sleep(2000);
       	tMpP.clickMyAssociations();
       	Thread.sleep(2000);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='m-datatable__body']/span")).getText(), "No Associations with any Training Centre is found");
       	PostLoginPage plp=new PostLoginPage(driver);
       	plp.clickOnProfileLogo();
       	Thread.sleep(2000);
       	plp.clickOnLogout();
       	Thread.sleep(2000);
    }

    @DataProvider()
    public Object[][] trainerTrainingBatchesData()
    {
    	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches");
    }
    @Test(dataProvider="trainerTrainingBatchesData",dependsOnMethods="trainerMyProfileVerificationTC_02")
    public void trainerTrainingBatchesForTrainerApplicantsTC_04(String serialNo, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String platformJobRole,  String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String trainingCentreName, String trainingCentreID, String trainingCentrePassword, String tcBatchAcceptanceRemarks, String masterTrainerName, String masterTrainerID, String masterTrainerPassword, String mtBatchAcceptanceRemarks, String mtAcceptedDate, String mtAcceptedTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String aaAcceptedDate, String aaAcceptedTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword,  String maBatchAcceptanceRemarks, String maAcceptedDate, String maAcceptedTime, String state, String district) throws Exception
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
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.id("startDates")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),9,trainingStartDate);
		String trainingEndDate=driver.findElement(By.id("endDates")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),10,trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole);
		Thread.sleep(4000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(4000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'RET/Q0101')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickTocloseDomainTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW"))
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
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers"))
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
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),13,domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),14,domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),15,domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),16,domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(4000);
		//Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'RET/Q0101')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sscTbcP.selectPlatformTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickToclosePlatformTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW"))
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
		else if(batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers"))
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
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),17,platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),18,platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),19,platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),20,platformAssessmentEndDate);
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
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),1,createdBatchID);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssccreate-new-batchbatch-assignment"+createdBatchID,"OMG!!! No show of Batch Assignment Page OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[span[contains(text(),'Sector')]]]/div[3])[1]")).getText().trim(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Sub Sector')]]]/div[3]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Type')]]]/div[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),1,createdBatchID);
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
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+assessmentAgencyID+"')]")).getText().trim(), assessmentAgencyName+" ( "+assessmentAgencyID+" )");
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
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'assessmentAgencyID')])[2]")).getText().trim(), assessmentAgencyName+" ( "+assessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[4]")).getText().trim(), "Assigned");
		//checking presence of created batches after submit of status Pending For Publish
		Thread.sleep(4000);
		sscTbcP.clickToSubmitBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']/p/b")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+createdBatchID+")");
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
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Name')]]/td[3]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Name of Training Centre')]]/td[3]")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'District')]]/td[3]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'State')]]/td[3]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Status of Training Centre')]/span")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[5]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[4]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[4]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[5]")).getText().trim(), "Pending");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),2,formatter.format(date));
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
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[text()='"+batchSize+"']")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[contains(text(),'"+trainingStartDate+"')]")).getText(), trainingStartDate+" to "+trainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[7]")).getText(), "Pending for Publish");
		Thread.sleep(4000);
		lTcVbP.clikToViewActionMenu(createdBatchID);
		Thread.sleep(2000);
		lTcVbP.clickToSelectAcceptBatchOption(createdBatchID);
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
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[4]")).getText().trim(), trainingCentreName+" ("+trainingCentreID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[5]")).getText().trim(), state );
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[7]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate+", "+platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
		tVp.clickToGetActionMenuOptions(createdBatchID);
		Thread.sleep(4000);
		tVp.clickToSelectAcceptBatchOption(createdBatchID);
		Thread.sleep(4000);
		tVp.enterRemarksForAcceptingBatch(mtBatchAcceptanceRemarks);
		Thread.sleep(4000);	
		tVp.clickToSubmit();
		Thread.sleep(2000);	
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),31,formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),32, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
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
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName+" , "+state+"/"+district);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+domainAssessmentStartDate+"')])[1]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+platformAssessmentStartDate+"')])[2]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("//td[span[contains(text(),'Pending for Acceptance')]]")).getText().trim(), "Pending for Acceptance");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+formatter.format(date)+"')]")).getText().trim(), formatter.format(date));
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
		Thread.sleep(2000);
		aVp.enterBatchIdToSearch(createdBatchID);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!!! accepted batch should not be shown in pending section OR something is wrong! ");
		//verifying accepted batches & assigning assessors
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
		aVp.clickToViewAcceptedBatches();
		Thread.sleep(2000);
		aVp.enterBatchIdToSearch(createdBatchID);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! The Batch - "+createdBatchID+" is not found in Accepted Section!!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName+" , "+state+"/"+district);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+domainAssessmentStartDate+"')])[1]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+platformAssessmentStartDate+"')])[2]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("//td[span[contains(text(),'Pending for Acceptance')]]")).getText().trim(), "Pending for Acceptance");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+formatter.format(date)+"')]")).getText().trim(), formatter.format(date));
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToSelectAssignAssessorsOption();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch ID')]]]]/div[2]/span")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch Name')]]]]/div[4]/span")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[1]/span")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[2]/span")).getText().trim(), "State : "+state+", District : "+district);
		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+domainAssessmentStartDate+"')])[1]")).getText().trim(), domainAssessmentStartDate+" To "+domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+platformAssessmentStartDate+"')])[1]")).getText().trim(), platformAssessmentStartDate+" To "+platformAssessmentEndDate);
		aVp.selectMasterAssessorForDomain(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(4000);
		aVp.selectMasterAssessorForPlatform(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(4000);
		aVp.clickToSubmitMasterAssessors();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "You have successfully assigned Assessor for the "+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+") - "+createdBatchID);
		aVp.clickOk();
		Thread.sleep(4000);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo), 37, formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo), 38, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[7]")).getText().trim(), "Assigned Assessor");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), formatter.format(date));
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
		Thread.sleep(2000);
		maDp.clickBatchAssessmentRequests();
		Thread.sleep(4000);
		AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
		maVp.clicktoGoToPendingRequestsSection();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[4]")).getText().trim(), trainingCentreName+"/"+state+" /"+district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[5]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[6]")).getText().trim(), domainAssessmentStartDate+domainAssessmentEndDate+" "+platformAssessmentStartDate+platformAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[7]")).getText().trim(), formatter.format(date));
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]")));		                         
		maVp.clickToGetActionMenuOptions(createdBatchID);
		Thread.sleep(4000);
		maVp.clickToSelectAcceptBatchOption(createdBatchID);
		Thread.sleep(4000);
		maVp.enterRemarksForAcceptingBatch(maBatchAcceptanceRemarks);
		Thread.sleep(4000);
		maVp.clickToSaveAndSubmitBatchAccceptance();
		Thread.sleep(4000);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo), 43, formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo), 44, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim(),"Request Accepted Successfully");
		maVp.clickOk();
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
    }
 /*   
    @DataProvider
    public Object[][]trainerSearchAndApplyForAvailableBatchData()
    {
    	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Trainer-Workflow.xls", "SearchAndApplyForBatches");
    }
    @Test(dataProvider="trainerSearchAndApplyForAvailableBatchData",dependsOnMethods="trainerTrainingBatchesForTrainerApplicantsTC_04")
 	public void trainerSearchAndApplyForAvailableBatchTC_05(String trainerUsername, String trainerPassword, String searchByEnteringMandatoryFieldsOrAll,String state, String district, String subDistrict, String sector, String subSector, String jobrole, String batchTypeForSearch, String batchStatus,String actionDropdownMenuOption) throws Exception
 	{
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 		LoginPage lp=new LoginPage(driver);
 		lp.clickLogin();
 		Thread.sleep(2000);
 		EnterLoginPage elp=new EnterLoginPage(driver);
 		elp.performlogin(trainerUsername, trainerPassword);
 		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
 		TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
 		Thread.sleep(10000);
 		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerapplicant");
 		tDp.clickToGetApplicantDashboard();
 		JavascriptExecutor js=(JavascriptExecutor)driver;
 		js.executeScript("window.scrollBy(0,200)", "");
 		Thread.sleep(2000);
 		Assert.assertFalse(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase(""),"please provide search option : mandatory or all fields in respected excel sheet");
 		tDp.clickSearchAndApplyforAvailableBatches();
 		Thread.sleep(2000);
 		TrainerApplicantSearchAndApplyForAvailableBatchesPage tSp=new TrainerApplicantSearchAndApplyForAvailableBatchesPage(driver);
 		if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("mandatory"))
 		{
 			tSp.selectState(state);
 			Thread.sleep(2000);
 			tSp.selectSector(sector);
 			Thread.sleep(2000);
 		}
 		else if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields"))
 		{
 			tSp.selectState(state);
 			Thread.sleep(2000);
 			tSp.selectDistrict(district);
 			Thread.sleep(2000);
 			tSp.selectSubDistrict(subDistrict);
 			Thread.sleep(2000);
 			tSp.selectSector(sector);
 			Thread.sleep(2000);
 			tSp.selectSubSector(subSector);
 			Thread.sleep(2000);
 			tSp.selectjobRole(jobrole);
 			Thread.sleep(6000);
 			tSp.selectBatchType(batchTypeForSearch);
 			Thread.sleep(2000);
 			tSp.selectBatchStatus(batchStatus);
 			Thread.sleep(6000);
 			tSp.enterBatchStartDate();
 			Thread.sleep(6000);
 			tSp.clickToCloseBatchStartDateCalender();
 			Thread.sleep(2000);
 			tSp.enterBatchEndDate();
 			Thread.sleep(6000);
 			tSp.clickToCloseBatchEndDateCalender();
 			Thread.sleep(2000);
 		}
 		Thread.sleep(6000);
 		tSp.clickSearch();
 		Thread.sleep(2000);
 		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""),configuredURL.replaceAll("/", "")+"trainerapplicantapply-for-batchsearch-results");
 		Assert.assertTrue(driver.findElements(By.tagName("tr")).size()>1,"Sorry! There are no resulted batch records for your search!!! ");
 		for(int i=1;i<4;i++)
 		{
 			String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 1);
 			String batchType=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 10);
			tSp.enterSearchKeyword(batchID);
 			Thread.sleep(2000);
 			if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields") && !batchType.equalsIgnoreCase(batchTypeForSearch))
			{
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!! There should be no result in case of Trainer applicant searched batch type - "+batchTypeForSearch+" and created batch type - "+batchType+" mismatch!!! ");
			}
			else
			{
				Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"Sorry!! Batch - "+batchID+" Not Found!!! ");
 				tSp.clickAction();
 				Thread.sleep(2000);
 				if(actionDropdownMenuOption.equals("View Details"))
 				{
 					tSp.selectViewDetails();
 					Thread.sleep(4000);
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='trainingcenternme']")).getAttribute("value"),locationBasedTCSPOCName );
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='mobilespoc']")).getAttribute("value"), locationBasedTCSPOCMobileNum);
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='emilspoc']")).getAttribute("value"), locationBasedTCSPOCEmail);
 					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='centreaddress']")).getAttribute("value"), locationBasedTCAddress);
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='landmark']")).getAttribute("value"), locationBasedTCLandmark);
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='pincode']")).getAttribute("value"), locationBasedTCPincode);
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value"), state);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='district']")).getAttribute("value"), district);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='subDistrict']")).getAttribute("value"), subDistrict);
					Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+jobrole+"')]")).getText().trim(), jobrole);
					Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+sector+"')]")).getText().trim(), sector);
					Thread.sleep(2000);
					tSp.clickApplyForBatch();
 					Thread.sleep(2000);
 					Assert.assertFalse(driver.findElements(By.xpath("//div[@id='toast-container']/div/div")).size()!=0,"This Candidate already applied for this Batch or he/she is a MasterTrainer");
 					Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().trim().endsWith(batchID), "Trainer searched and applied batch mismatch");
 					tSp.clickOK();
 					Thread.sleep(2000);
 					driver.navigate().back();
 					Thread.sleep(4000);
 					
 				}
 				else if(actionDropdownMenuOption.equals("Apply to the batch"))
 				{
 					Thread.sleep(2000);
 					tSp.selectApplyToBatch();
 					Thread.sleep(2000);
 					Assert.assertFalse(driver.findElements(By.xpath("//div[@id='toast-container']/div/div")).size()!=0,"This Candidate already applied for this Batch or he/she is a MasterTrainer");
 					Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().trim().endsWith(batchID), "Trainer searched and applied batch mismatch");
 					tSp.clickOK();
 					Thread.sleep(2000);
 				}
			}
		}
 		//verifying applied section
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
		tSp.clickToGoToApplicantDashboard();
		Thread.sleep(2000);
		TrainerApplicantDashboardPage  tBp=new TrainerApplicantDashboardPage(driver);
		tBp.clickViewBatches();
		Thread.sleep(2000);
		TrainerApplicantViewBatchesPage tVbP=new TrainerApplicantViewBatchesPage(driver);
		tVbP.clickToGoToAppliedBatchesSection();
		Thread.sleep(2000);
		for(int i=1;i<4;i++)
 		{
 			String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 1);
 			String batchType=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 10);
 			tVbP.enterToSearchForBatch(batchID);
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
    //Trainer Applicants Approval Process From Location Based TC and SSC
    @Test(dataProvider="registrationData", dependsOnMethods="trainerSearchAndApplyForAvailableBatchTC_05")
	public void locationBasedTrainingCentreApprovingAndRejectingTrainerApplicantsTC_06(String serialNum,String createdTrainerID,String userType, String name, String tcApproveOrRejectThisTrainerForTrainerTrainingBatch,String tcReasonForRejectingThisTrainerApplicant, String sscApproveOrRejectThisTrainerForTrainerTrainingBatch, String sscReasonForRejectingThisTrainerApplicant, String email, String mobile, String emailOTP, String mobileOTP, String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		String locationBasedTCID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "LocationBasedTC-Creation",1,2);
		elp.performlogin(locationBasedTCID, "Qwerty@123");
		Thread.sleep(2000);
		LocationBasedTC_DashboardPage lBTcP=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(2000);
		LocationBasedTC_ViewBatchesPage lBTcVp=new LocationBasedTC_ViewBatchesPage(driver);
		for(int i=1;i<4;i++)
		{
			String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 1);
			String batchType=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 10);
			String batchSize=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 13);
			String jobRole=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 11);
			String sector=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 8);
			String batchFees=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 12);
			String assignedMasterTrainer=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 9);
			String assignedMasterAssessor=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 15);
			String batchStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 2);
			String assessmentEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 5);
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
			String searchByEnteringMandatoryFieldsOrAll=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "SearchAndApplyForBatches",Integer.parseInt(serialNum),2);
			String batchTypeForSearch=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "SearchAndApplyForBatches",Integer.parseInt(serialNum),9);
			//When first candidate applied batch type is matching with created batch type 
			if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields") && batchType.equalsIgnoreCase(batchTypeForSearch) && serialNum.equals("1") )
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
			//Personal Information of trainer applicant
			lBTcVp.enterToSearchForBatchApplicants(email);
			Thread.sleep(2000);
			
			if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields") && !batchType.equalsIgnoreCase(batchTypeForSearch))
			{
				Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! There should be no result as this batch applicant -"+createdTrainerID+" of email - "+email+" is not applied to the batch - "+batchID+" as applied batchType - "+batchTypeForSearch+" and created batch type - "+batchType+" differs!!! ");
			}
			else
			{
				Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! No show of batch applicant - "+createdTrainerID+" of email - "+email+" who has applied for the batch - "+batchID+" !!! "); 
				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+name+"']")).getText().trim(), name);
				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+email+"']")).getText().trim(), email);
				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+mobile+"']")).getText().trim(), mobile);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[2]/td[5]")).getText().trim(), "No","Batch applicant verified status should be - No, as TC yet to verify this batch applicant!!! ");
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
				
				if(tcApproveOrRejectThisTrainerForTrainerTrainingBatch.equalsIgnoreCase("approve"))
				{
					lBTcVp.clickToApproveBatchApplicant();
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved"), "OMG!!! Batch applicant not approved as success popup message not displayed!!! " );
					lBTcVp.clickOk();
					Thread.sleep(2000);
					lBTcVp.clickToGoToEnrolledCandidatesSection();
					Thread.sleep(2000);
					lBTcVp.enterToSearchForBatchApplicants(email);
					Thread.sleep(2000);
					Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0, "OMG!! No show of Approved Trainer Applicant - "+createdTrainerID+" of email - "+email);
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
				else if(tcApproveOrRejectThisTrainerForTrainerTrainingBatch.equalsIgnoreCase("reject"))
				{
					lBTcVp.clickToRejectBatchApplicant();
					Thread.sleep(2000);
					lBTcVp.enterReasonForRejectingBatchApplicant(tcReasonForRejectingThisTrainerApplicant);
					lBTcVp.clickToRejectBatchApplicantFinal();
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("successfully"), "OMG!!! Batch applicant not rejected as success popup message not displayed!!! " );
					lBTcVp.clickOk();
					Thread.sleep(2000);
					lBTcVp.enterToSearchForBatchApplicants(email);
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! Rejected Batch Applicant - "+createdTrainerID+" of email - "+email+" record present in applied candidates section!!! ");
					lBTcVp.clickToGoToEnrolledCandidatesSection();
					Thread.sleep(2000);
					lBTcVp.enterToSearchForBatchApplicants(email);
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! Rejected Batch Applicant - "+createdTrainerID+" of email - "+email+" record present in Enrolled candidates section!!! ");
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
    
	@Test(dataProvider="registrationData",dependsOnMethods="locationBasedTrainingCentreApprovingAndRejectingTrainerApplicantsTC_06")
	public void sscApprovingOrRejectingTrainerApplicantsTC_07(String serialNum,String createdTrainerID,String userType, String name, String tcApproveOrRejectThisTrainerForTrainerTrainingBatch,String tcReasonForRejectingThisTrainerApplicant, String sscApproveOrRejectThisTrainerForTrainerTrainingBatch, String sscReasonForRejectingThisTrainerApplicant, String email, String mobile, String emailOTP, String mobileOTP, String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		String sscUserName=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 7);
		String sscPassword=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 8);
		elp.performlogin(sscUserName, sscPassword);
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(2000);
		SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		
		for(int i=1;i<4;i++)
		{	
			String locationBasedTCID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "LocationBasedTC-Creation",1,2);
			String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 1);
			String batchType=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 10);
			String batchSize=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 13);
			String jobRole=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 11);
			String sector=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 8);
			String subSector=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 9);
			String batchFees=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 12);
			String assignedMasterTrainer=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 9);
			String assignedAssessmentAgency=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 12);
			String batchStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 2);
			String batchEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 3);
			String assessmentStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 4);
			String assessmentEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", i, 5);
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
			if(batchType.equalsIgnoreCase("Training of Trainer-New") && serialNumber<4)
			{
			   Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), "0/8");
			}
			else if(!batchType.equalsIgnoreCase("Training of Trainer-New") && serialNumber<4)
			{
			   Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), "0/7");
			}
			else if(batchType.equalsIgnoreCase("Training of Trainer-New") && serialNumber>3)
			{
			   Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), Integer.parseInt(serialNum)-3+"/8");
			}
			else if(!batchType.equalsIgnoreCase("Training of Trainer-New") && serialNumber>3)
			{
			   Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), Integer.parseInt(serialNum)-3+"/7");
			}
			sAp.clickToViewActionMenuOptions();
			Thread.sleep(2000);
			sAp.clicktoSelectViewBatchDetailsOption();
			Thread.sleep(2000);
			//Verifying General Batch Details
			String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batchesbatch"+batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"/"+batchStartDate+" to "+assessmentEndDate+"("+batchID+")')]")).getText().trim(),batchType+"/"+batchStartDate+" to "+assessmentEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+batchType+"')])[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+sector+"')])[1]")).getText().trim(), sector);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+subSector+"')]")).getText().trim(), subSector);
			Assert.assertEquals(driver.findElement(By.xpath("//td[span[contains(text(),'"+jobRole+"')]]")).getText().trim(), jobRole);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[2]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Fee:')]]/td[2]")).getText().trim(), batchFees);
			//To check SSC - applied/enrolled candidates before approving or rejecting from ssc end, hv to get count of tc approved candidates count
			if(batchType.equalsIgnoreCase("Training of Trainer-New"))//this if condition need to be removed after bug fix
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
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'State:')]]/td[2]")).getText().trim(), locationBasedTCState);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'City:')]]/td[2]")).getText().trim(), locationBasedTCDistrict);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Head of Training Centre')]]/td[2]")).getText().trim(), locationBasedTCHeadName);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Phone')]]/td[2])[1]")).getText().trim(), locationBasedTCHeadPhone);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Email')]]/td[2])[1]")).getText().trim(), locationBasedTCHeadEmail);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Single Point of Contact Person:')]]/td[2]")).getText().trim(), locationBasedTCSPOCName);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Phone')]]/td[2])[2]")).getText().trim(), locationBasedTCSPOCMobileNum);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Email')]]/td[2])[2]")).getText().trim(), locationBasedTCSPOCEmail);
			
			Select selectedMasterTrainer=new Select(driver.findElement(By.xpath("(//select)[1]")));
			Select selectedMasterAssessmentAgency=new Select(driver.findElement(By.xpath("(//select)[2]")));
			Assert.assertEquals(selectedMasterTrainer.getFirstSelectedOption().getText(), assignedMasterTrainer);
			Assert.assertEquals(selectedMasterAssessmentAgency.getFirstSelectedOption().getText(), assignedAssessmentAgency);
			Thread.sleep(2000);
			sAp.clickToGoToAppliedCandidatesSection();
			Thread.sleep(2000);
			sAp.enterToSearchForBatchApplicants(email);
			Thread.sleep(2000);
			if(tcApproveOrRejectThisTrainerForTrainerTrainingBatch.equalsIgnoreCase("reject"))
			{
				Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0, "OMG!! Location Based TC Rejected batch Applicant - " +createdTrainerID+" of email - "+email+" listed in SSC Applied Candidates Section!!! ");
			}
			else if(tcApproveOrRejectThisTrainerForTrainerTrainingBatch.equalsIgnoreCase("approve"))
			{
				Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0, "OMG!! No Show Of Location Based TC Accepted batch Applicant - " +createdTrainerID+" of email - "+email+" in SSC Applied Candidates Section!!! ");
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
				if(sscApproveOrRejectThisTrainerForTrainerTrainingBatch.equalsIgnoreCase("approve"))
				{
					sAp.clickToApproveBatchApplicant();
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved"), "batch applicant not approved" );
					sAp.clickOk();
					Thread.sleep(2000);
					sAp.enterToSearchForBatchApplicants(email);
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!! SSC Approved Candidate - "+createdTrainerID+" of email - "+email+" Still Present in Applied Candidates section!!! ");
					sAp.clickToGoToEnrolledCandidatesSection();
					Thread.sleep(2000);
					sAp.enterToSearchForBatchApplicants(email);
					Thread.sleep(2000);
					Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0, "OMG!! No show of Approved batch Applicant - "+createdTrainerID+" of email - "+email);
					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+name+"']")).getText().trim(), name);
					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+email+"']")).getText().trim(), email);
					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+mobile+"']")).getText().trim(), mobile);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+email+"')]]/td[5]")).getText().trim(), "Yes");
					sAp.clickToViewDetailsOfEnrolledBatchApplicant();
					Thread.sleep(2000);
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
				else if(sscApproveOrRejectThisTrainerForTrainerTrainingBatch.equalsIgnoreCase("reject"))
				{
					sAp.clickToRejectBatchApplicant();
					Thread.sleep(2000);
					sAp.enterReasonForRejectingBatchApplicant(sscReasonForRejectingThisTrainerApplicant);
					sAp.clickToRejectBatchApplicantFinal();
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("successfully"), "assessor applicant not rejected" );
					sAp.clickOk();
					Thread.sleep(2000);
					sAp.enterToSearchForBatchApplicants(email);
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! SSC rejected batch applicant - "+createdTrainerID+" of email - "+email+" record present in applied candidates section!!! ");
					sAp.clickToGoToEnrolledCandidatesSection();
					Thread.sleep(4000);
					sAp.enterToSearchForBatchApplicants(email);
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]")).size()==0,"OMG!!! SSC rejected batch applicant - "+createdTrainerID+" of email - "+email+" record present in enrolled candidates section!!! ");   
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
	} */
}




