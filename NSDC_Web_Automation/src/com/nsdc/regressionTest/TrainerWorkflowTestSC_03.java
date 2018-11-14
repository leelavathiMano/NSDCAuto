package com.nsdc.regressionTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.nsdc.pages.SSCAllBatchesPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage;
import com.nsdc.pages.SSC_ViewBatchDetailsPage;
import com.nsdc.pages.TrainerApplicantDashboardPage;
import com.nsdc.pages.TrainerApplicantSearchAndApplyForAvailableBatchesPage;
import com.nsdc.pages.TrainerApplicantViewBatchesPage;
import com.nsdc.pages.TrainerDashboardPage;
import com.nsdc.pages.TrainerMyProfilePage;
import com.nsdc.pages.TrainerRegistrationPage;
import com.nsdc.pages.TrainerViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class TrainerWorkflowTestSC_03 extends TestConfiguration
{
	String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	String sscID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 26);
	String sscPassword=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 27);
	String batchType=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 9);
	String batchFees=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 10);
	String domainJobRole=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 7);
	String domainJobRoleCode=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 8);
	String platformJobRole=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 11);
	String platformJobRoleCode=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 12);
	String tcID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 13);
	String tcPassword=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 15);
	String tcName=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 14);
	String tcTPName=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 16);
	String tcSPOCMobile=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 17);
	String tcSPOCEmail=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 18);
	String tcAddress=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 19);
	String tcLandmark=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 20);
	String tcPinCode=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 21);
	String tcMandal=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 22);
	String tcDistrict=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 23);
	String tcState=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 24);
	String tcParlimentaryConstituency=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 25);
	String domainMasterTrainerID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 28);
	String domainMasterTrainerName=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 29);
	String platformMasterTrainerID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 31);
	String platformMasterTrainerName=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 32);
	String domainAssessmentAgencyID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 34);
	String domainAssessmentAgencyName=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 35);
	String platformAssessmentAgencyID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 37);
	String platformAssessmentAgencyName=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "Configurable-Fields", 1, 38); 
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	Date date = new Date();
	@DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerRegistration");
    }
    @Test(dataProvider="registrationData")
    public void trainerRegistrationTC_01(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
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
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in Personal Information Section, Its Blocking further Applicant Registration Process!!!");
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
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in Contact & Address Details Section, Its Blocking further Applicant Registration Process!!!");
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
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in Education & Work Details Section, Its Blocking further Applicant Registration Process!!!");
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
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in My Preferences & My Associations Section, Its Blocking further Applicant Registration Process!!!");
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
     
    @Test(dataProvider="registrationData", dependsOnMethods="trainerRegistrationTC_01")
    public void trainerMyProfileVerificationTC_02(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
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
      	if(!education1.equals("Uneducated") && !education2.equals("Uneducated") && !education3.equals("Uneducated"))
      	{
      		Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[1]")).getText().contains(edu_details1));
           	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[3]")).getText().trim(), education1);
           	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[4]")).getText().contains(edu_document1));
           	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[5]")).getText().contains(edu_details2));
           	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[7]")).getText().trim(), education2);
           	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[8]")).getText().contains(edu_document2));
      	}
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
      	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[2]")).getText().trim(), preferredSector1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[4]")).getText().trim(), preferredDistrict1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[5]")).getText().trim(), preferredSubDistrict1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[2]")).getText().trim(), preferredSector2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[3]")).getText().trim(), preferredSubSector2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[4]")).getText().trim(), preferredDistrict2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[5]")).getText().trim(), preferredSubDistrict2);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[h5[contains(text(),'Applicant Type')]]]]/div[4]")).getText().trim(), userType);
      	//Edit Profile
       	tMpP.clickEditProfile();
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
    public void trainerTrainingBatchesForTrainerApplicantsTC_03(String serialNo,String createdBatchIDs, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime) throws Exception
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
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.name("sector")).getAttribute("value").trim(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(2000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(2000);
		sscTbcP.selectBatchCategory(batchCategory);
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(2000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(4000);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(2000);
		sscTbcP.clickTocloseDomainTrainingStartDateCalender();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		String domainTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),15,domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),16,domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),17,domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),18,domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(4000);
		sscTbcP.selectPlatformTrainingStartDate();
		Thread.sleep(2000);
		sscTbcP.clickToclosePlatformTrainingStartDateCalender();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		String platformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),19,platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),20,platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),21,platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),22,platformAssessmentEndDate);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(2000);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast-message']")).size()==0,"OMG!!! Toast error Message present, Unable to create Batch! May be some data not entered OR Something went wrong! ");
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),1,createdBatchID);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		Thread.sleep(4000);
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		sVbP.selectStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterTrainingCentreIDToSearch(tcID);
		Thread.sleep(2000);
		sVbP.clickToGetSearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChooseResultedTrainingCentreToAssign(tcID);
		Thread.sleep(2000);
		sVbP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//Assigning Master Trainer for domain QP
		sVbP.clickDomainMasterTrainerAction(domainJobRole);
		Thread.sleep(2000);
		sVbP.selectDomainAssignMasterTrainerOption();
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterDomainMasterTrainerIDToSearch(dmasterTrainerID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainMasterSearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChooseDomainMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//Assigning Platform QP Master Trainer
		sVbP.clickPlatformMasterTrainerAction(platformJobRole);
		Thread.sleep(2000);
		sVbP.selectPlatformAssignMasterTrainerOption();
		Thread.sleep(2000);
		sVbP.selectPlatformMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectPlatformMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterPlatformMasterTrainerIDToSearch(pmasterTrainerID);
		Thread.sleep(2000);
		sVbP.clickToGetPlatformMasterSearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChoosePlatformMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//Assigning Domain QP Assessment Agency
		sVbP.clickDomainAssessmentAgencyAction(domainJobRole);
		Thread.sleep(2000);
		sVbP.selectDomainAssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sVbP.selectDomainAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDomainAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//Assigning Platform QP Assessment Agency
		sVbP.clickPlatformAssessmentAgencyAction(platformJobRole);
		Thread.sleep(2000);
		sVbP.selectPlatformAssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sVbP.selectPlatformAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectPlatformAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterPlatformAssessmentAgencyIDToSearch(passessmentAgencyID);
		Thread.sleep(2000);
		sVbP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChoosePlatformAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		sVbP.clickToSubmitBatch();
		Thread.sleep(4000);
		sVbP.clickOkForBatchSubmission();
		Thread.sleep(4000);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches",Integer.parseInt(serialNo),2,formatter.format(date));
		PostLoginPage plp=new PostLoginPage(driver);
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
    }
    
    @Test(dataProvider="trainerTrainingBatchesData",dependsOnMethods="trainerTrainingBatchesForTrainerApplicantsTC_03")
    public void batchApprovalTC_04(String serialNo,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime) throws Exception
    {
    	//Assigned TC Login to Accept Batch
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		Thread.sleep(8000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectAcceptBatchOption(batchID);
		Thread.sleep(2000);
		lTcVbP.enterRemarksForAcceptingBatch(tcBatchAcceptanceRemarks);
		Thread.sleep(2000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(4000);
		lTcVbP.clickOk();
		Thread.sleep(2000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//Assigned Master Trainer Login To Accept the Batch
		for(int i=1;i<3;i++)
		{
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			lp.clickLogin();
			if(i==1)
			{
				elp.performlogin(dmasterTrainerID, dmasterTrainerPassword);
			}
			else
			{
				elp.performlogin(pmasterTrainerID, pmasterTrainerPassword);
			}
			Thread.sleep(10000);
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
			tVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(2000);
			tVp.clickToSelectAcceptBatchOption(batchID);
			Thread.sleep(4000);
			if(i==1)
			{
				tVp.enterRemarksForAcceptingBatch(dmtBatchAcceptanceRemarks);
			}
			else
			{
				tVp.enterRemarksForAcceptingBatch(pmtBatchAcceptanceRemarks);
			}
			Thread.sleep(4000);	
			tVp.clickToSubmit();
			Thread.sleep(2000);	
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 43, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 44, timeFormat.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 49, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 50, timeFormat.format(date));
			}
			tVp.clickOk();
			Thread.sleep(2000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(6000);
		}
		//Assigned Assessment Agency Login to Accept and assigning master assessors for a batch
		for(int i=1;i<3;i++)
		{
			lp.clickLogin();
			if(i==1)
			{
				elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
			}
			else
			{
				elp.performlogin(passessmentAgencyID, passessmentAgencyPassword);
			}
			Thread.sleep(8000);
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
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToSelectAcceptBatchOption();
			Thread.sleep(2000);
			if(i==1)
			{
				aVp.enterRemarksForAcceptingBatch(daaBatchAcceptanceRemarks);
			}
			else
			{
				aVp.enterRemarksForAcceptingBatch(paaBatchAcceptanceRemarks);
			}
			Thread.sleep(2000);		
			aVp.clickToSubmitBatchAcceptance();
			Thread.sleep(2000);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 55, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 56, timeFormat.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 61, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 62, timeFormat.format(date));
			}
			aVp.clickOk();
			Thread.sleep(2000);
			//assigning assessors
			aVp.clickToViewAcceptedBatches();
			Thread.sleep(4000);
			aVp.enterBatchIdToSearch(batchID);
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToSelectAssignAssessorsOption();
			Thread.sleep(4000);
			if(i==1)
			{
				aVp.selectMasterAssessorForDomain1(dmasterAssessorName+"("+dmasterAssessorID+")");
				Thread.sleep(2000);
			}
			else
			{
				aVp.selectMasterAssessorForPlatform(pmasterAssessorName+"("+pmasterAssessorID+")");
				Thread.sleep(2000);
			}
			aVp.clickToSubmitMasterAssessors();
			Thread.sleep(4000);
			aVp.clickOk();
			Thread.sleep(4000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(6000);
		}
		//Master Assessor Login to Accept Batches
		for(int i=1; i<3;i++)
		{
			lp.clickLogin();
			if(i==1)
			{
				elp.performlogin(dmasterAssessorID, dmasterAssessorPassword);
			}
			else
			{
				elp.performlogin(pmasterAssessorID, pmasterAssessorPassword);
			}
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
			maVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(2000);
			maVp.clickToSelectAcceptBatchOption(batchID);
			Thread.sleep(4000);
			if(i==1)
			{
				maVp.enterRemarksForAcceptingBatch(dmaRemarks);
			}
			else
			{
				maVp.enterRemarksForAcceptingBatch(pmaRemarks);
			}
			maVp.clickToSaveAndSubmitBatchAccceptance();
			Thread.sleep(4000);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 67, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 68, timeFormat.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 73, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", Integer.parseInt(serialNo), 74, timeFormat.format(date));
			}
			maVp.clickOk();
			Thread.sleep(4000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(6000);
		}
    }
    
    @Test(dataProvider="registrationData",dependsOnMethods="batchApprovalTC_04")
 	public void trainerSearchAndApplyForAvailableBatchTC_05(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
 	{
 	   LoginPage lp=new LoginPage(driver);
 	   EnterLoginPage elp=new EnterLoginPage(driver);
 	   String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 1);
	   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 9);
	   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 10);
	   String domainTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 15);
	   String domainTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 16);
	   String domainAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 17);
	   String domainAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 18);
	   String platformTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 19);
	   String platformTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 20);
	   String platformAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 21);
	   String platformAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 22);
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   lp.clickLogin();
	   Thread.sleep(2000);
 	   elp.performlogin(createdTrainerID, "Qwerty@123");
 	   TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
 	   Thread.sleep(8000);
	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
 	   tDp.clickToGetApplicantDashboard();
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)", "");
 	   Thread.sleep(2000);
 	   tDp.clickSearchAndApplyforAvailableBatches();
	   Thread.sleep(4000);
	   TrainerApplicantSearchAndApplyForAvailableBatchesPage tSp=new TrainerApplicantSearchAndApplyForAvailableBatchesPage(driver);
 /*	   if(serialNum.equals("1"))
 	   {
 		   tSp.selectState(state);
 		   Thread.sleep(2000);
 		   tSp.selectDistrict(city);
 		   Thread.sleep(2000);
 		   tSp.selectSubDistrict(mandal);
 		   Thread.sleep(2000);
 		   tSp.selectSector(preferredSector1);
 		   Thread.sleep(2000);
 		   tSp.selectSubSector(preferredSubSector1);
 		   Thread.sleep(2000);
 		   tSp.selectjobRole(domainJobRole);
 		   Thread.sleep(6000);
 		   //Add My Search Preferences
 		   tSp.clickAddJobRoleAndLocationToMyPreference();
 		   Thread.sleep(4000);
 		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Preference Added Successfully !!");
 		   tSp.clickOK();
 		   Thread.sleep(2000);
 		   js.executeScript("window.scrollBy(0,-200)", "");
 		   Thread.sleep(2000);
 		   tSp.clickMyPreferences();
 		   Thread.sleep(4000);
 		   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+preferredSector1+"')]]")).size()==1);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector1+"')]]/td[1]")).getText().trim(), domainJobRole);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector1+"')]]/td[2]")).getText().trim(), preferredSector1);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector1+"')]]/td[4]")).getText().trim(), state);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector1+"')]]/td[5]")).getText().trim(), city);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector1+"')]]/td[6]")).getText().trim(), mandal);
 		   tSp.clickAction();
 		   tSp.selectSearchAgainstPreference();
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
 		   tSp.clickToGetBatchActionMenu(batchID);
 		   Thread.sleep(2000);
 		   tSp.selectViewBatchDetails(batchID);
 		   Thread.sleep(4000);
 		   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerapplicantview-batch-detailsBATCH%20CREATED"+batchID);
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
 		   tSp.clickGoBack();
 		   Thread.sleep(4000);
 		   tSp.clickToGetBatchActionMenu(batchID);
 		   Thread.sleep(2000);
 		   tSp.selectApplyToBatch(batchID);
 		   Thread.sleep(2000);
 		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
 		   tSp.clickOK();
 		   Thread.sleep(2000);
 	   }
 	   else if(serialNum.equals("2"))
 	   {
 		   tSp.selectState(state);
 		   Thread.sleep(2000);
 		   tSp.selectDistrict(city);
 		   Thread.sleep(2000);
 		   tSp.selectSubDistrict(mandal);
 		   Thread.sleep(2000);
 		   tSp.selectSector(preferredSector1);
 		   Thread.sleep(2000);
 		   tSp.selectSubSector(preferredSubSector1);
 		   Thread.sleep(2000);
 		   tSp.selectjobRole(domainJobRole);
 		   Thread.sleep(6000);
 		   tSp.selectBatchType(batchType);
 		   Thread.sleep(2000);
 		   tSp.enterBatchStartDate(batchStartDate);
 		   Thread.sleep(6000);
 		   tSp.clickToCloseBatchStartDateCalender();
 		   Thread.sleep(2000);
 		   tSp.enterBatchEndDate(batchEndDate);
 		   Thread.sleep(6000);
 		   tSp.clickToCloseBatchEndDateCalender();
 		   Thread.sleep(2000);
 		   tSp.enterSearchKeyword(tcName);
 		   Thread.sleep(2000);
 		   tSp.clickSearch();
 		   Thread.sleep(2000);
 		   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! No show of Batch - "+batchID+" searching by entering all fields! ");
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
 		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(domainJobRole));
 		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(platformJobRole));
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), state);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), city);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchStartDate+" - "+batchEndDate);	
 		   Thread.sleep(4000);
 		   tSp.clickToGetBatchActionMenu(batchID);
 		   Thread.sleep(2000);
 		   tSp.selectApplyToBatch(batchID);
 		   Thread.sleep(2000);
 		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
 		   tSp.clickOK();
 		}	   
 		else
 		{
*/ 			tSp.selectState(state);
 			Thread.sleep(2000);
 			tSp.selectSector(preferredSector1);
 			Thread.sleep(4000);
 			tSp.clickSearch();
 			Thread.sleep(4000);
 			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"), "+platformJobRole+" ("+platformJobRoleCode+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), city);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));	
			tSp.clickToGetBatchActionMenu(batchID);
 			Thread.sleep(2000);
 			tSp.selectApplyToBatch(batchID);
 			Thread.sleep(4000);
 			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
 			tSp.clickOK();
 		 // }
 			Thread.sleep(4000);
 			js.executeScript("window.scrollBy(0,-1000)", "");
 			tSp.clickViewMyBatches();
 			Thread.sleep(4000);
 			Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG! No show of applied batch - "+batchID+" in View Batches <-> My Batches Section!!! ");
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), state+"/"+city);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+", "+platformJobRole);  
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), "Applied");
 			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
 			Date date=new Date();
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), formatter.format(date));
 			//Accepted Batch - View Details Data Verification
 			tSp.clickToGetAcceptedBatchActionMenu(batchID);
 			Thread.sleep(2000);
 			tSp.selectAcceptedBatchViewDetails(batchID);
 			Thread.sleep(4000);
 			Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
 			Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
 			Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
 			Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim().replaceAll("/", "-"), batchStartDate+" to "+batchEndDate);
 			Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), preferredSector1);
 			Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), preferredSubSector1);
 			//Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[1]")).getText().trim(), batchFees);
 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of Training Center')]]]/div[1]")).getText().trim(), tcName);
 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Training Partner')]]]/div[2]")).getText().trim(), tcTPName);
 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mobile Number')]]]/div[1]")).getText().trim(), tcSPOCMobile);
 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Email ID')]]]/div[2]")).getText().trim(), tcSPOCEmail);
 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Center Address')]]]/div[1]")).getText().trim(), tcAddress);
 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Nearby Landmark')]]]/div[2]")).getText().trim(), tcLandmark);
 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Pincode')]]]/div[1]")).getText().trim(), tcPinCode);
 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'District')]]]/div[2]")).getText().trim(), tcDistrict);
 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'State')]]]/div[1]")).getText().trim(), tcState);
 			//Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Parliamentary')]]]/div[2]")).getText().trim(), tcParlimentaryConstituency);
 			//Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mandal')]]]/div[1]")).getText().trim(), tcMandal);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[1]")).getText().trim(), domainJobRoleCode);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[2]")).getText().trim(), domainJobRole);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[4]")).getText().trim(), domainMasterTrainerName+" ("+domainMasterTrainerID+")");
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[6]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[1]")).getText().trim(), platformJobRoleCode);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[2]")).getText().trim(), platformJobRole);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[4]")).getText().trim(), platformMasterTrainerName+" ("+platformMasterTrainerID+")");
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[5]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
 			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[6]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
 			PostLoginPage plp=new PostLoginPage(driver);
 			plp.clickOnProfileLogo();
 			Thread.sleep(2000);
 			plp.clickOnLogout();
 			Thread.sleep(2000);
 	}
	//Trainer Applicants Approval Process From Location Based TC and SSC
    @Test(dataProvider="registrationData", dependsOnMethods="trainerSearchAndApplyForAvailableBatchTC_05")
    public void tcApprovingTrainerApplicantsTC_06(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
    {
 	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   LoginPage lp=new LoginPage(driver);
 	   lp.clickLogin();
 	   EnterLoginPage elp=new EnterLoginPage(driver);
 	   String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 1);
	   String batchSize=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 24);
	   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 9);
	   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 10);
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
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchID);
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
 	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+createdTrainerID+"']]")).size()==1,"OMG!!! No show of Trainer Applicant - "+createdTrainerID+" who has applied for the Batch - "+batchID+" OR Something went wrong! ");
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[2]")).getText().trim(), createdTrainerID);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[3]")).getText().trim(), name);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[4]")).getText().trim(), email);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[5]")).getText().trim(), mobile);
 	   tcVp.clickToGetApplicantActionMenu(createdTrainerID);
 	   Thread.sleep(4000);
 	   tcVp.selectViewDetailsOfApplicantOption(createdTrainerID);
 	   Thread.sleep(4000);
 	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-applicant-details"+batchID+createdTrainerID+"Trainer","OMG!!! navigation to View Applicant Details Page is unsuccessful OR Something went wrong! ");
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
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
 	   //tcVp.clickGoBack(); 
 	   driver.navigate().back();
 	   Thread.sleep(4000);
 	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID+"applied","OMG!!! View Applicant Details - GoBack navigation to Applied Applicants Page Section is unsuccessfull OR Something went wrong! ");
 	   if(serialNum.equals("1"))
 	   {
 		   tcVp.clickToSelectApplicantToBeEnrolled(createdTrainerID);
 		   Thread.sleep(2000);
 		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]//input[@name='Checkbox']")).isSelected(),"OMG!!! checkbox not selected for trainer applicant - "+createdTrainerID);
 		   tcVp.clickToEnrollAllSelectedApplicants();
 		   Thread.sleep(4000);
 	   }
 	   else
 	   {
 		   tcVp.clickToGetApplicantActionMenu(createdTrainerID);
 		   Thread.sleep(4000);
 		   tcVp.selectEnrollApplicantOption(createdTrainerID);
 		   Thread.sleep(4000);
 		   Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved successfully"),"OMG!!! Applicant Enroll Successfull Popup Text not displayed OR Something went wrong! ");
 		   tcVp.clickOk();
 		   Thread.sleep(4000);
 	   }
 	   tcVp.clickToGoToAppliedApplicantsSection();
 	   Thread.sleep(2000);
 	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdTrainerID+"')]]")).size()==0,"OMG!!! Enrolled Trainer Applicant - "+createdTrainerID+" Still present in Applied Applicants Section!!! OR Something went wrong! ");
 	   tcVp.clickToGoToEnrolledApplicantsSection();
 	   Thread.sleep(4000);
 	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdTrainerID+"')]]")).size()==1,"OMG!!! No show of Enrolled Trainer Applicant - "+createdTrainerID+" in Enrolled Applicants Section!!! OR Something went wrong! ");
 	   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+createdTrainerID+"']")).getText().trim(), createdTrainerID);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[contains(text(),'"+name+"')]")).getText().trim(), name);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[contains(text(),'"+email+"')]")).getText().trim(), email);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[contains(text(),'"+mobile+"')]")).getText().trim(), mobile);
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
 		   tcVp.clickToGetApplicantActionMenu(createdTrainerID);
 		   Thread.sleep(4000);
 		   tcVp.selectViewDetailsOfApplicantOption(createdTrainerID);
 		   Thread.sleep(4000);
 		   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-applicant-details"+batchID+createdTrainerID+"Trainer","OMG!!! navigation to View Applicant Details Page is unsuccessful OR Something went wrong! ");
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
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
 		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
 	   }
 	   PostLoginPage plp=new PostLoginPage(driver);
 	   plp.clickOnProfileLogo();
 	   Thread.sleep(2000);
 	   plp.clickOnLogout();
 	   Thread.sleep(2000);
    }
    
    //Applicant Adding Fees Payment Details After TC Approval
    @Test(dataProvider="registrationData", dependsOnMethods="tcApprovingTrainerApplicantsTC_06")
    public void batchFeesPaymentByApplicantsTC_07(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
    {
       String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
 	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   LoginPage lp=new LoginPage(driver);
 	   lp.clickLogin();
 	   Thread.sleep(2000);
 	   EnterLoginPage elp=new EnterLoginPage(driver);
 	   elp.performlogin(createdTrainerID, "Qwerty@123");
 	   Thread.sleep(10000);
 	   TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
 	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
 	   tDp.clickToGetApplicantDashboard();
 	   JavascriptExecutor js=(JavascriptExecutor)driver;
 	   js.executeScript("window.scrollBy(0,200)", "");
 	   Thread.sleep(4000);
 	   tDp.clickViewBatches();
 	   Thread.sleep(4000);
 	   String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 1);
 	   String batchCreatedDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 2);
 	   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 9);
 	   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 10);
 	   String domainTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 15);
 	   String domainTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 16);
 	   String domainAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 17);
 	   String domainAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 18);
 	   String platformTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 19);
 	   String platformTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 20);
 	   String platformAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 21);
 	   String platformAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 22);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), state+"/"+city);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), domainJobRole+", "+platformJobRole);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), "Enrolled");
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchCreatedDate);
 	   TrainerApplicantViewBatchesPage tVp=new TrainerApplicantViewBatchesPage(driver);
 	   tVp.clickToGetEnrolledBatchActionMenu(batchID);
 	   Thread.sleep(2000);
 	   tVp.selectAddPaymentDetailsForEnrolledBatchOption(batchID);
 	   Thread.sleep(4000);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Applicant ID')]]])[1]/div[1]")).getText().trim(), createdTrainerID);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Applicant Name')]]])[1]/div[2]")).getText().trim(), name);
 	   tVp.selectPaymentMode(paymentMode);
 	   Thread.sleep(2000);
 	   if(!paymentMode.equalsIgnoreCase("cash"))
 	   {
 		   tVp.selectBankName(bankName);
 	   }
 	   Thread.sleep(2000);
 	   tVp.enterPaymentReferenceNumber(paymentReferenceNumber);
 	   Thread.sleep(2000);
 	   tVp.selectDateOfPayment();
 	   String dateOfPayment=driver.findElement(By.xpath("//input[@formcontrolname='dateOfPayment']")).getAttribute("value");
 	   ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerRegistration", Integer.parseInt(serialNum), 94, dateOfPayment);
 	   Assert.assertFalse(driver.findElement(By.xpath("//input[@formcontrolname='amount']")).isEnabled(),"OMG!!! Fees TextField should be disabled OR Something went wrong!");
 	   Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='amount']")).getAttribute("value").trim(), batchFees);
 	   tVp.enterPaymentRemarks(paymentRemarks);
 	   Thread.sleep(2000);
 	   tVp.clickToSubmitPaymentDetails();
 	   Thread.sleep(2000);
 	   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Payment Details Added Successfully !!");
 	   Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Payment details has been added to the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
 	   tVp.clickOK();
 	   Thread.sleep(2000);
 	   tVp.clickToGetEnrolledBatchActionMenu(batchID);
 	   Thread.sleep(2000);
 	   tVp.selectViewDetailsForEnrolledBatchOption(batchID);
 	   Thread.sleep(4000);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim().replaceAll("/", "-"), batchStartDate+" to "+batchEndDate);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), preferredSector1);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), preferredSubSector1);
 	   //Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[1]")).getText().trim(), batchFees);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of Training Center')]]]/div[1]")).getText().trim(), tcName);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Training Partner')]]]/div[2]")).getText().trim(), tcTPName);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mobile Number')]]]/div[1]")).getText().trim(), tcSPOCMobile);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Email ID')]]]/div[2]")).getText().trim(), tcSPOCEmail);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Center Address')]]]/div[1]")).getText().trim(), tcAddress);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Nearby Landmark')]]]/div[2]")).getText().trim(), tcLandmark);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Pincode')]]]/div[1]")).getText().trim(), tcPinCode);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'District')]]]/div[2]")).getText().trim(), tcDistrict);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'State')]]]/div[1]")).getText().trim(), tcState);
 	   //Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Parliamentary')]]]/div[2]")).getText().trim(), tcParlimentaryConstituency);
 	   //Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mandal')]]]/div[1]")).getText().trim(), tcMandal);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[1]")).getText().trim(), domainJobRoleCode);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[2]")).getText().trim(), domainJobRole);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[4]")).getText().trim(), domainMasterTrainerName+" ("+domainMasterTrainerID+")");
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[6]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[1]")).getText().trim(), platformJobRoleCode);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[2]")).getText().trim(), platformJobRole);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[4]")).getText().trim(), platformMasterTrainerName+" ("+platformMasterTrainerID+")");
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[5]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[6]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mode of Payment')]]]/div[1]")).getText().trim(), paymentMode);
 	   if(!paymentMode.equalsIgnoreCase("cash"))
 	   {
 		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of Bank')]]]/div[2]")).getText().trim(), bankName);
 	   }
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Date of Payment')]]]/div[1]")).getText().trim(), formatter.format(date));
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Reference No')]]]/div[2]")).getText().trim(), paymentReferenceNumber);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Amount')]]]/div[1]")).getText().trim(), batchFees);
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Any Remarks')]]]/div[2]")).getText().trim(), paymentRemarks);
 	   PostLoginPage plp=new PostLoginPage(driver);
 	   plp.clickOnProfileLogo();
 	   Thread.sleep(2000);
 	   plp.clickOnLogout();
 	   Thread.sleep(2000);
    }
    
    @Test(dataProvider="registrationData", dependsOnMethods="batchFeesPaymentByApplicantsTC_07")
    public void sscApprovingTrainerApplicantsTC_08(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
    {
   	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
   	 	LoginPage lp=new LoginPage(driver);
   	 	lp.clickLogin();
   	 	EnterLoginPage elp=new EnterLoginPage(driver);
   	 	elp.performlogin(sscID, sscPassword);
   	 	Thread.sleep(10000);
   	 	SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
   	 	JavascriptExecutor js=(JavascriptExecutor)driver;
   	 	js.executeScript("window.scrollBy(0,200)", "");
   	 	Thread.sleep(4000);
   	 	sDp.clickAllBatches();
   	 	Thread.sleep(4000);
   	 	SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
   	 	sAp.clickToViewAllPublishedBatches();
   	 	Thread.sleep(6000);
   	 	String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 1, 1);
   	 	sAp.clickToGetBatchActionMenu(batchID);
   	 	Thread.sleep(2000);
   	 	sAp.selectApproveApplicantsOption(batchID);
   	 	Thread.sleep(4000);
   	 	SSC_ViewBatchDetailsPage sVp=new SSC_ViewBatchDetailsPage(driver);
   	 	sVp.clickToGoToEnrolledApplicantsSection();
   	 	Thread.sleep(2000);
   	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+createdTrainerID+"']]")).size()==1,"OMG!!! No show of TC Approved Trainer Applicant - "+createdTrainerID+" in Enrolled Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[2]")).getText().trim(), createdTrainerID);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[3]")).getText().trim(), name);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[4]")).getText().trim(), email);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[5]")).getText().trim(), mobile);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[6]")).getText().trim(), "Paid");
   	 	sVp.clickToGetApplicantActionMenu(createdTrainerID);
   	 	Thread.sleep(2000);
   	 	sVp.selectViewDetailsOfApplicantOption(createdTrainerID);
   	 	Thread.sleep(2000);
   	 	Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscapplicant-details"+batchID+createdTrainerID+"Trainer","OMG!!! navigation to View Applicant Details Page is unsuccessful OR Something went wrong! ");
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
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
   	 	//Verifying Fees Payment Details
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Received");
   	 	sVp.clickToViewPaymentDetails();
	 	Thread.sleep(4000);
	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID')]]]/div[2]")).getText().trim(), batchID);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mode of Payment')]]]/div[2]")).getText().trim(), paymentMode);
   	 	if(!paymentMode.equalsIgnoreCase("cash"))
   	 	{
   	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of the Bank')]]]/div[2]")).getText().trim(), bankName);
   	 	}
   	 	//Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Date of Payment')]]]/div[2]")).getText().trim(), paymentDate);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Reference No')]]]/div[2]")).getText().trim(), paymentReferenceNumber);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Amount')]]]/div[2]")).getText().trim(), batchFees);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Any Remarks')]]]/div[2]")).getText().trim(), paymentRemarks);
   	 	sVp.clickOk();
   	 	Thread.sleep(4000);
   	 	js.executeScript("window.scrollBy(0,-1000)", "");
   	 	Thread.sleep(4000);
   	 	//sVp.clickGoBack(); 
   	 	driver.navigate().back();
   	 	Thread.sleep(4000);
   	 	sVp.clickToGoToEnrolledApplicantsSection();
   	 	Thread.sleep(4000);
   	 	if(serialNum.equals("1"))
   	 	{
   	 		sVp.clickToSelectApplicantToBeApproved(createdTrainerID);
   	 		Thread.sleep(2000);
   	 		sVp.clickToApproveAllSelectedApplicants();
   	 		Thread.sleep(4000);
   	 		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdTrainerID+"')]]")).size()==0,"OMG!!! SSSC Approved Applicant - "+createdTrainerID+" should not be displayed in Enrolled Applicnats Section OR Something went wrong!");
   	 	}
   	 	else
   	 	{
   	 		sVp.clickToGetApplicantActionMenu(createdTrainerID);
   	 		Thread.sleep(2000);
   	 		sVp.selectApproveOfApplicantOption(createdTrainerID);
   	 		Thread.sleep(4000);
   	 		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applicant Approved!!\nApplicant successfully approved");
   	 		sVp.clickOk();
   	 		Thread.sleep(4000);
   	 		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdTrainerID+"')]]")).size()==0,"OMG!!! SSSC Approved Applicant - "+createdTrainerID+" should not be displayed in Enrolled Applicnats Section OR Something went wrong!");
   	 	}
   	 	js.executeScript("window.scrollBy(0,-1000)", "");
   	 	Thread.sleep(4000);
   	 	sVp.clickToGoToApprovedApplicantsSection();
   	 	Thread.sleep(4000);
   	 	//Verifying SSC Approved Applicants
   	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+createdTrainerID+"']]")).size()==1,"OMG!!! No show of SSC Approved Assessor Applicant - "+createdTrainerID+" in Approved Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[2]")).getText().trim(), createdTrainerID);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[3]")).getText().trim(), name);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[4]")).getText().trim(), email);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[5]")).getText().trim(), mobile);
   	 	if(serialNum.equals("5"))
	 	{
   	 		sVp.clickToApproveBatch();
   	 		Thread.sleep(4000);
   	 		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Batch Approved!!\nBatch approved successfully");
   	 		sVp.clickOk();
   	 		Thread.sleep(4000);
   	 		sAp.clickToViewAllPublishedBatches();
   	 		Thread.sleep(4000);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(),"Approved");
   	 		sAp.clickToGetBatchActionMenu(batchID);
   	 		Thread.sleep(2000);
   	 		sAp.selectViewDetailsOption(batchID);
   	 		Thread.sleep(4000);
   	 		sVp.clickToGoToApprovedApplicantsSection();
   	 		Thread.sleep(4000);
   	 		sVp.clickToSubmitBatch();
   	 		Thread.sleep(2000);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(), "Batch is already approved");
	 	}
   	 	else
   	 	{
   	 	sVp.clickToGetApplicantActionMenu(createdTrainerID);
   	 	Thread.sleep(2000);
   	 	sVp.selectViewDetailsOfApplicantOption(createdTrainerID);
   	 	Thread.sleep(2000);
   	 	Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscapplicant-details"+batchID+createdTrainerID+"Trainer","OMG!!! navigation to View Applicant Details Page is unsuccessful OR Something went wrong! ");
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
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
   	 	//Verifying Fees Payment Details
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Received");
   	 	sVp.clickToViewPaymentDetails();
	 	Thread.sleep(4000);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID')]]]/div[2]")).getText().trim(), batchID);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mode of Payment')]]]/div[2]")).getText().trim(), paymentMode);
   	 	if(!paymentMode.equalsIgnoreCase("cash"))
   	 	{
   	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of the Bank')]]]/div[2]")).getText().trim(), bankName);
   	 	}
   	 	//Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Date of Payment')]]]/div[2]")).getText().trim(), paymentDate);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Reference No')]]]/div[2]")).getText().trim(), paymentReferenceNumber);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Amount')]]]/div[2]")).getText().trim(), batchFees);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Any Remarks')]]]/div[2]")).getText().trim(), paymentRemarks);
   	 	sVp.clickOk();
   	 	Thread.sleep(4000);
   	 	js.executeScript("window.scrollBy(0,-1000)", "");
   	 	Thread.sleep(4000);
   	 	}
   	 	PostLoginPage plp=new PostLoginPage(driver);
   	 	plp.clickOnProfileLogo();
   	 	Thread.sleep(2000);
   	 	plp.clickOnLogout();
   	 	Thread.sleep(2000);
    } 	
    //Applicants Rejection Test Cases
    @Test(dataProvider="registrationData", dependsOnMethods="batchApprovalTC_04")
    public void tcRejectingTrainerApplicantsTC_09(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("1"))
	   	{
	   	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 2, 1);
 	   		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   		LoginPage lp=new LoginPage(driver);
 	   		lp.clickLogin();
 	   		EnterLoginPage elp=new EnterLoginPage(driver);
 	   		//Applicant Applying for batch
			elp.performlogin(createdTrainerID, "Qwerty@123");
			Thread.sleep(8000);
			TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
			tDp.clickToGetApplicantDashboard();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(4000);
			tDp.clickSearchAndApplyforAvailableBatches();
			Thread.sleep(4000);
			TrainerApplicantSearchAndApplyForAvailableBatchesPage tSp=new TrainerApplicantSearchAndApplyForAvailableBatchesPage(driver);
			tSp.selectState(state);
			Thread.sleep(2000);
			tSp.selectSector(preferredSector1);
			Thread.sleep(4000);
			tSp.clickSearch();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			tSp.clickToGetBatchActionMenu(batchID);
			Thread.sleep(4000);
			tSp.selectApplyToBatch(batchID);
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
			tSp.clickOK();  
			Thread.sleep(4000);
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(6000);
 	   		//TC Rejecting Applicant
			lp.clickLogin();
			Thread.sleep(2000);
 	   		elp.performlogin(tcID, tcPassword);
 	   		Thread.sleep(8000);
 	   		LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
 	   		js.executeScript("window.scrollBy(0,200)","");
 	   		Thread.sleep(4000);
 	   		tcDp.clickToViewBatches();
 	   		Thread.sleep(2000);
 	   		LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
 	   		tcVp.clickToViewAllAcceptedBatches();
 	   		Thread.sleep(4000);
 	   		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
 	   		tcVp.clikToGetBatchActionMenu(batchID);
 	   		Thread.sleep(4000);
 	   		tcVp.clickToSelectEnrollApplicantsOption(batchID);
 	   		Thread.sleep(4000);
 	   		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID+"applied","OMG!!! navigation to Enroll Applicants Page is unsuccessful OR Something went wrong! ");   
 	   		tcVp.clickToGetApplicantActionMenu(createdTrainerID);
 	   		Thread.sleep(4000);
 	   		tcVp.selectRejectApplicantOption(createdTrainerID);
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
 	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdTrainerID+"')]]")).size()==0,"OMG!!! Rejected Trainer Applicant - "+createdTrainerID+" Still present in Applied Applicants Section!!! OR Something went wrong! ");
 	   		tcVp.clickToGoToEnrolledApplicantsSection();
 	   		Thread.sleep(4000);
 	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdTrainerID+"')]]")).size()==0,"OMG!!! Rejected Trainer Applicant - "+createdTrainerID+" Present in Enrolled Applicants Section!!! OR Something went wrong! ");
 	   		plp.clickOnProfileLogo();
 	   		Thread.sleep(2000);
 	   		plp.clickOnLogout();
 	   		Thread.sleep(6000);
 	   	}
    }
    
    @Test(dataProvider="registrationData", dependsOnMethods="tcRejectingTrainerApplicantsTC_09")
    public void sscRejectingTrainerApplicantsTC_10(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("2"))
	   	{
	   	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerTrainingBatches", 2, 1);
 	   		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   		LoginPage lp=new LoginPage(driver);
 	   		lp.clickLogin();
 	   		EnterLoginPage elp=new EnterLoginPage(driver);
 	   		//Applicant Applying for batch
			elp.performlogin(createdTrainerID, "Qwerty@123");
			Thread.sleep(8000);
			TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
			tDp.clickToGetApplicantDashboard();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(4000);
			tDp.clickSearchAndApplyforAvailableBatches();
			Thread.sleep(4000);
			TrainerApplicantSearchAndApplyForAvailableBatchesPage tSp=new TrainerApplicantSearchAndApplyForAvailableBatchesPage(driver);
			tSp.selectState(state);
			Thread.sleep(2000);
			tSp.selectSector(preferredSector1);
			Thread.sleep(4000);
			tSp.clickSearch();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			tSp.clickToGetBatchActionMenu(batchID);
			Thread.sleep(4000);
			tSp.selectApplyToBatch(batchID);
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
			tSp.clickOK();  
			Thread.sleep(4000);
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(6000);
 	   		//TC Approving Applicant and Submitting Batch For SSC
			lp.clickLogin();
			Thread.sleep(2000);
 	   		elp.performlogin(tcID, tcPassword);
 	   		Thread.sleep(8000);
 	   		LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
 	   		js.executeScript("window.scrollBy(0,200)","");
 	   		Thread.sleep(4000);
 	   		tcDp.clickToViewBatches();
 	   		Thread.sleep(2000);
 	   		LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
 	   		tcVp.clickToViewAllAcceptedBatches();
 	   		Thread.sleep(4000);
 	   		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
 	   		tcVp.clikToGetBatchActionMenu(batchID);
 	   		Thread.sleep(4000);
 	   		tcVp.clickToSelectEnrollApplicantsOption(batchID);
 	   		Thread.sleep(4000);
 	   		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID+"applied","OMG!!! navigation to Enroll Applicants Page is unsuccessful OR Something went wrong! ");   
 	   		tcVp.clickToGetApplicantActionMenu(createdTrainerID);
 	   		Thread.sleep(4000);
 	   		tcVp.selectEnrollApplicantOption(createdTrainerID);
 	   		Thread.sleep(4000);
 	   		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved successfully"),"OMG!!! Applicant Enroll Successfull Popup Text not displayed OR Something went wrong! ");
 	   		tcVp.clickOk();
 	   		Thread.sleep(4000);
 	   		tcVp.clickToGoToEnrolledApplicantsSection();
 	   		Thread.sleep(4000);
 	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdTrainerID+"')]]")).size()==1,"OMG!!! No show of Enrolled Trainer Applicant - "+createdTrainerID+" in Enrolled Applicants Section!!! OR Something went wrong! ");
 	   		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+createdTrainerID+"']")).getText().trim(), createdTrainerID);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[contains(text(),'"+name+"')]")).getText().trim(), name);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[contains(text(),'"+email+"')]")).getText().trim(), email);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[contains(text(),'"+mobile+"')]")).getText().trim(), mobile);
 	   		//Sending Batch To SSC For Approval
 	 	    tcVp.clickToSendBatchForApproval();
 	 	    Thread.sleep(4000);
 	 	    Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Submitted for Approval");
	 	    tcVp.clickOk();
 	 		Thread.sleep(4000);
 	   		plp.clickOnProfileLogo();
 	   		Thread.sleep(2000);
 	   		plp.clickOnLogout();
 	   		Thread.sleep(6000);
 	   		//SSC Rejecting Enrolled Applicant
 	   		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   		lp.clickLogin();
 	   		elp.performlogin(sscID, sscPassword);
 	   		Thread.sleep(10000);
 	   		SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
 	   		js.executeScript("window.scrollBy(0,200)", "");
 	   		Thread.sleep(4000);
 	   		sDp.clickAllBatches();
 	   		Thread.sleep(4000);
 	   		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
 	   		sAp.clickToViewAllPublishedBatches();
 	   		Thread.sleep(6000);
 	   		sAp.clickToGetBatchActionMenu(batchID);
 	   		Thread.sleep(2000);
 	   		sAp.selectApproveApplicantsOption(batchID);
 	   		Thread.sleep(4000);
 	   		SSC_ViewBatchDetailsPage sVp=new SSC_ViewBatchDetailsPage(driver);
 	   		sVp.clickTogoToBatchDetailsSection();
 	   		Thread.sleep(2000);
 	   		sVp.clickToGoToEnrolledApplicantsSection();
 	   		Thread.sleep(2000);
 	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+createdTrainerID+"']]")).size()==1,"OMG!!! No show of TC Approved Trainer Applicant - "+createdTrainerID+" in Enrolled Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[2]")).getText().trim(), createdTrainerID);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[3]")).getText().trim(), name);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[4]")).getText().trim(), email);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[5]")).getText().trim(), mobile);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdTrainerID+"']]/td[6]")).getText().trim(), "Unpaid");
 	   		sVp.clickToGetApplicantActionMenu(createdTrainerID);
 	   		Thread.sleep(2000);
 	   		sVp.selectViewDetailsOfApplicantOption(createdTrainerID);
 	   		Thread.sleep(2000);
 	   		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscapplicant-details"+batchID+createdTrainerID+"Trainer","OMG!!! navigation to View Applicant Details Page is unsuccessful OR Something went wrong! ");
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
 	   		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
 	   		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
 	   		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
 	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
 	   		//Verifying UnPaid Fees Details
 	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Not Received");
 	   		//sVp.clickGoBack(); 
 	   		driver.navigate().back();
 	   		Thread.sleep(4000);
 	   		sVp.clickToGoToEnrolledApplicantsSection();
 	   		Thread.sleep(4000);
 	   		sVp.clickToGetApplicantActionMenu(createdTrainerID);
   	 		Thread.sleep(2000);
   	 		sVp.selectRejectApplicantOption(createdTrainerID);
   	 		Thread.sleep(4000);
   	 		sVp.selectReasonForRejectingApplicant();
   	 		Thread.sleep(4000);
   	 		sVp.enterRemarksForRejectingApplicant();
   	 		Thread.sleep(4000);
   	 		sVp.clickToRejectApplicant();
   	 		Thread.sleep(4000);
   	 		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().trim().contains("Applicant Rejected"));
   	 		sVp.clickOk();
   	 		Thread.sleep(4000);
   	 		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+createdTrainerID+"')]]")).size()==0,"OMG!!! SSC Rejected Applicant - "+createdTrainerID+" should not be displayed in Enrolled Applicants Section OR Something went wrong!");
   	 	 	js.executeScript("window.scrollBy(0,-1000)", "");
   	 	 	Thread.sleep(4000);
   	 	 	sVp.clickToGoToApprovedApplicantsSection();
   	 	 	Thread.sleep(4000);
   	 	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+createdTrainerID+"']]")).size()==0,"OMG!!! SSC Rejected Applicant - "+createdTrainerID+" Present in Approved Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
   	 	 	plp.clickOnProfileLogo();
   	 	 	Thread.sleep(2000);
   	 	 	plp.clickOnLogout();
   	 	 	Thread.sleep(6000);
	   	}
    }
}