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
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.TrainerApplicantDashboardPage;
import com.nsdc.pages.TrainerApplicantSearchAndApplyForAvailableBatchesPage;
import com.nsdc.pages.TrainerMyProfilePage;
import com.nsdc.pages.TrainerRegistrationPage;
import com.nsdc.testConfig.DatabaseConnection;
import com.nsdc.testConfig.TestConfiguration;

public class TrainerWorkflowTestSC_03 extends TestConfiguration
{
    @DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerRegistrationSC03TC01");
    }
     
    @Test(dataProvider="registrationData")
    public void trainerRegistrationTC_01(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP, String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String jobRole_sector1, String jobRole_subSector1, String jobRole1, String jobRole_sector2, String jobRole_subSector2, String jobRole2, String preferred_state1, String preferred_city1, String preferred_district1, String preferred_state2, String preferred_city2, String preferred_district2, String preferred_state3, String preferred_city3, String preferred_district3) throws Exception
    {
        //DatabaseConnection.deleteTrainer(email);
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        lp.clickRegister();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.selectDropdownList(userType);
        rp.enterSPOCName(name);
        rp.enterEmail(email);
        ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "VerificationSC03TC02", Integer.parseInt(serialNum), 13, email);
        rp.enterMobile(mobile);
        ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "VerificationSC03TC02", Integer.parseInt(serialNum), 12, mobile);
        rp.clickIagree();
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
			rp.enterMobileOTP(mobileOTP);
        	Thread.sleep(2000);
        	rp.clickVerify();
		}
        Thread.sleep(2000);
        String createdTrainer=driver.findElement(By.xpath("//div[@class='m-login__signin']/h3/span")).getText();
        ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerRegistrationSC03TC01", Integer.parseInt(serialNum), 1, createdTrainer);
        ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "VerificationSC03TC02", Integer.parseInt(serialNum), 0, createdTrainer);
        ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerApplyForBatchTestSC03TC03", Integer.parseInt(serialNum), 0, createdTrainer);
        
        String username = driver.findElement(By.xpath("//span[@class='text-bold']")).getText();
			
        rp.clickGoToLogin();
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, "ekaushal");
        Thread.sleep(2000);
        rp.enterOldPassword(oldPassword);
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "VerificationSC03TC02", Integer.parseInt(serialNum), 1, confirmPassword);
        ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerApplyForBatchTestSC03TC03", Integer.parseInt(serialNum), 1, confirmPassword);
        rp.clickResetResubmit();
        Thread.sleep(2000);
        rp.clickConfirmationOkMessage();
        elp.performlogin(username, confirmPassword);
        Thread.sleep(4000);
        TrainerRegistrationPage trainer = new TrainerRegistrationPage(driver);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).getAttribute("value"), name);
        trainer.selectGender(gender);
        trainer.selectDateOfBirth(dob);
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
        trainer.selectReligion(religion);
        trainer.selectCategory(category);
        if(disability.equals("None"))
        {
        	trainer.selectDisability(disability);
        }
        else
        {
        	trainer.selectDisability(disability);
        	trainer.clickOnBrowseForUploadDisabilityDocument();
        	Thread.sleep(2000);
        	UploadFile.upload(disabilityFile);
           	Thread.sleep(2000);
           	trainer.clickOnUploadButtonForUploadDisabilityDocument();
           	Thread.sleep(4000);
         }
         String aadharPan = aadhaarOrPAN.toLowerCase();
         if(aadharPan.equals("aadhaar"))
         {
            trainer.clickOnAadharNumberRadioButton();
            trainer.enterAadharNumber(idNumber);
            trainer.clickOnValidateAadharNumber();
            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='aadhaarIdentity']/div/span")).getText(), "Verified");
         }
         else if(aadharPan.equals("pan"))
         {
            trainer.clickOnPanNumberRadioButton();
            Thread.sleep(2000);
            trainer.enterPanNumber(idNumber);
            trainer.clickOnBrowseFileButtonForUploadPanDocument();
            Thread.sleep(2000);
            UploadFile.upload(uploadPanDocument);
            Thread.sleep(2000);
            trainer.clickOnUploadButtonToUploadPan();
            Thread.sleep(4000);
         }
         Thread.sleep(2000);
         trainer.clickOnBrowseFileButtonToUploadPhoto();
         Thread.sleep(2000);
         UploadFile.upload(photoFile);
         Thread.sleep(2000);
         trainer.clickOnUploadButtonToUploadPhoto();
         Thread.sleep(4000);
         if(applicant_Category.equals("Trainer,Master Trainer"))
         {
           	trainer.selectAllApplicantCategory();
         }
         else if(applicant_Category.equals("Trainer") || applicant_Category.equals("Master Trainer"))
         {
           	trainer.selectAnyApplicantCategory(applicant_Category);
         }
         Thread.sleep(2000);
         trainer.clickOnSaveAndContinue();
         Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='phone']")).getAttribute("value"), mobile);
         Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='email']")).getAttribute("value"), email);
         trainer.enterApplicantAddress(address);
         trainer.enterNearbyLandmark(landmark);
         trainer.enterPincode(pincode);
         trainer.selectStateOrUnionTerritory(state);
         trainer.selectDistrictOrCity(city);
         trainer.selectTehsilOrMandal(mandal);
         trainer.selectParliamentaryConstituency(parliamentaryConstituency);
         Thread.sleep(2000);
         trainer.clickOnSaveAndContinue();
         if(education1.equals("Uneducated"))
         {
           	trainer.selectEducationAttained(education1);
           	//checking visibility status of education details form
           	Assert.assertTrue(driver.findElement(By.xpath("//div[@formgroupname='educationAndWorkDetails']/div[@class='m-separator m-separator--dashed m-separator--lg']")).isDisplayed(), "Education Details Fields are not hidden as separator is not present");
         }
         else
         {
           	trainer.selectEducationAttained(education1);
           	trainer.enterDetailsOfEducation(edu_details1);
           	trainer.clickOnBrowseForUploadEducationProofDocument();
           	Thread.sleep(2000);
           	UploadFile.upload(edu_document1);
           	Thread.sleep(2000);
           	trainer.clickOnUploadForUploadEducationProofDocument();
           	Thread.sleep(4000);
           	trainer.clickOnAddEducationDetailsButton();
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education1+"')]")).getText(), education1);
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details1+"')]")).getText(), edu_details1);
           	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[1]")).getText(), "yes");
         }
         if(education2.equals("Uneducated"))
         {
           	trainer.selectEducationAttained(education2);
           	//checking visibility status of education details form
           	Assert.assertTrue(driver.findElement(By.xpath("//div[@formgroupname='educationAndWorkDetails']/div[@class='m-separator m-separator--dashed m-separator--lg']")).isDisplayed(), "Education Details Fields are not hidden as separator is not present");
         }
         else
         {
           	trainer.selectEducationAttained(education2);
           	trainer.enterDetailsOfEducation(edu_details2);
           	trainer.clickOnBrowseForUploadEducationProofDocument();
           	Thread.sleep(2000);
           	UploadFile.upload(edu_document2);
           	Thread.sleep(2000);
           	trainer.clickOnUploadForUploadEducationProofDocument();
           	Thread.sleep(4000);
           	trainer.clickOnAddEducationDetailsButton();
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education2+"')]")).getText(), education2);
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details2+"')]")).getText(), edu_details2);
           	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[2]")).getText(), "yes");
         }
         if(education3.equals("Uneducated"))
         {
           	trainer.selectEducationAttained(education3);
          	//checking visibility status of education details form
           	Assert.assertTrue(driver.findElement(By.xpath("//div[@formgroupname='educationAndWorkDetails']/div[@class='m-separator m-separator--dashed m-separator--lg']")).isDisplayed(), "Education Details Fields are not hidden as separator is not present");
         }
         else
         {
           	trainer.selectEducationAttained(education3);
           	trainer.enterDetailsOfEducation(edu_details3);
           	trainer.clickOnBrowseForUploadEducationProofDocument();
           	Thread.sleep(2000);
           	UploadFile.upload(edu_document3);
           	Thread.sleep(2000);
           	trainer.clickOnUploadForUploadEducationProofDocument();
           	Thread.sleep(4000);
           	trainer.clickOnAddEducationDetailsButton();
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education3+"')]")).getText(), education3);
           	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details3+"')]")).getText(), edu_details3);
           	Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[1]")).getText(), "yes");
           	trainer.deleteThirdEducationDetails();
         }
         trainer.selectRelevantSectorForIndustrialExperience(industrial_sector1);
         trainer.selectYearsForIndustrialExperience(industrial_years1);
         trainer.selectMonthsForIndustrialExperience(industrial_months1);
         trainer.enterDetailsOfIndustrialExperience(industrialExperienceDetails1);
         trainer.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails1);
         trainer.clickOnBrowseForIndustrialExperienceProofDocument();
         Thread.sleep(2000);
         UploadFile.upload(industrialDocument1);
         Thread.sleep(2000);
         trainer.clickOnUploadForIndustrialExperienceProofDocument();
         Thread.sleep(4000);
         trainer.clickOnAddIndustrialExperienceDetails();
         Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector1+"')]")).getText(), industrial_sector1);
         Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails1+"')]")).getText(), industrialExperienceDetails1);
         Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[1]")).getText(), "Yes");
         trainer.selectRelevantSectorForIndustrialExperience(industrial_sector2);
         trainer.selectYearsForIndustrialExperience(industrial_years2);
         trainer.selectMonthsForIndustrialExperience(industrial_months2);
         trainer.enterDetailsOfIndustrialExperience(industrialExperienceDetails2);
         trainer.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails2);
         trainer.clickOnBrowseForIndustrialExperienceProofDocument();
         Thread.sleep(2000);
         UploadFile.upload(industrialDocument2);
         Thread.sleep(2000);
         trainer.clickOnUploadForIndustrialExperienceProofDocument();
         Thread.sleep(4000);
         trainer.clickOnAddIndustrialExperienceDetails();
         Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector2+"')]")).getText(), industrial_sector2);
         Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails2+"')]")).getText(), industrialExperienceDetails2);
         Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[2]")).getText(), "Yes");
         trainer.selectRelevantSectorForIndustrialExperience(industrial_sector3);
         trainer.selectYearsForIndustrialExperience(industrial_years3);
         trainer.selectMonthsForIndustrialExperience(industrial_months3);
         trainer.enterDetailsOfIndustrialExperience(industrialExperienceDetails3);
         trainer.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails3);
         trainer.clickOnBrowseForIndustrialExperienceProofDocument();
         Thread.sleep(2000);
         UploadFile.upload(industrialDocument3);
         Thread.sleep(2000);
         trainer.clickOnUploadForIndustrialExperienceProofDocument();
         Thread.sleep(4000);
         trainer.clickOnAddIndustrialExperienceDetails();
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
      /* int totalIndustrialMonths=((Integer.parseInt(industrial_years1)+Integer.parseInt(industrial_years2))*12)+Integer.parseInt(industrial_months1)+Integer.parseInt(industrial_months2);
      	 int finalIndustrialMonths=totalIndustrialMonths%12;
    	 int finalIndustrialYears=(totalIndustrialMonths-finalIndustrialMonths)/12;
    	 if(finalIndustrialMonths==0)
    	 {
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[1]")).getText(),":"+finalIndustrialYears+" Years Total Industrial Experience");
    	 }
    	 else
    	 {
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[1]")).getText(),":"+finalIndustrialYears+" Years "+finalIndustrialMonths+" months Total Industrial Experience");
    	 }
       */trainer.selectRelevantSectorForTrainingExperience(training_sector1);
       	 trainer.selectyearsForTrainingExperience(trainingExperienceYears1);
       	 trainer.selectMonthsForTrainingExperience(trainingExperienceMonths1);
       	 trainer.enterTrainingExperienceDetails(trainingExperienceDetails1);
       	 trainer.clickOnBrowseForTrainingExperienceProofDocument();
       	 Thread.sleep(2000);
       	 UploadFile.upload(trainingDocument1);
       	 Thread.sleep(2000);
       	 trainer.clickOnUploadForTrainingExperienceProofDocument();
       	 Thread.sleep(4000);
         trainer.clickOnAddTrainingExperienceDetails();
       	 Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector1+"')]")).getText(), training_sector1);
       	 Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails1+"')]")).getText(), trainingExperienceDetails1);
       	 Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText(), "Yes");
       	 trainer.selectRelevantSectorForTrainingExperience(training_sector2);
       	 trainer.selectyearsForTrainingExperience(trainingExperienceYears2);
       	 trainer.selectMonthsForTrainingExperience(trainingExperienceMonths2);
       	 trainer.enterTrainingExperienceDetails(trainingExperienceDetails2);
       	 trainer.clickOnBrowseForTrainingExperienceProofDocument();
       	 Thread.sleep(2000);
       	 UploadFile.upload(trainingDocument2);
       	 Thread.sleep(2000);
       	 trainer.clickOnUploadForTrainingExperienceProofDocument();
       	 Thread.sleep(4000);
       	 trainer.clickOnAddTrainingExperienceDetails();
       	 Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector2+"')]")).getText(), training_sector2);
       	 Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails2+"')]")).getText(), trainingExperienceDetails2);
       	 Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[4]")).getText(), "Yes");
       	 trainer.selectRelevantSectorForTrainingExperience(training_sector3);
         trainer.selectyearsForTrainingExperience(trainingExperienceYears3);
       	 trainer.selectMonthsForTrainingExperience(trainingExperienceMonths3);
       	 trainer.enterTrainingExperienceDetails(trainingExperienceDetails3);
       	 trainer.clickOnBrowseForTrainingExperienceProofDocument();
       	 Thread.sleep(2000);
       	 UploadFile.upload(trainingDocument3);
       	 Thread.sleep(2000);
       	 trainer.clickOnUploadForTrainingExperienceProofDocument();
       	 Thread.sleep(4000);
       	 trainer.clickOnAddTrainingExperienceDetails();
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
   /*    int totalTrainingMonths=((Integer.parseInt(trainingExperienceYears1)+Integer.parseInt(trainingExperienceYears2))*12)+Integer.parseInt(trainingExperienceMonths1)+Integer.parseInt(trainingExperienceMonths2);
      	 int finalTrainingMonths=totalTrainingMonths%12;
    	 int finalTrainingYears=(totalTrainingMonths-finalTrainingMonths)/12;
    	 if(finalTrainingMonths==0)
    	 {
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[2]")).getText(),":"+finalTrainingYears+" Years Total Industrial Experience");
    	 }
    	 else
    	 {
    		//Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[2]")).getText(),":"+finalTrainingYears+" Years "+finalTrainingMonths+" months Total Industrial Experience");
    	 }
    */	trainer.clickOnBrowseForCurriculumVitaeOrResume();
        Thread.sleep(2000);
        UploadFile.upload(resume);
        Thread.sleep(2000);
        trainer.clickOnUploadForCurriculumVitaeOrResume();
        Thread.sleep(4000);
        trainer.clickOnSaveAndContinue();
        trainer.clickOn_PreferredJobRole();
        Thread.sleep(2000);
        trainer.selectSectorForJobRole(jobRole_sector1);
        trainer.selectSubSectorForJobRole(jobRole_subSector1);
        trainer.select_JobRole(jobRole1);
        trainer.clickOnAddForPreferredJobRole();
        Thread.sleep(2000);
        trainer.clickOnDeletePreferredJobRole();
        Thread.sleep(2000);
        trainer.clickOn_PreferredJobRole();
        Thread.sleep(2000);
        trainer.selectSectorForJobRole(jobRole_sector2);
        trainer.selectSubSectorForJobRole(jobRole_subSector2);
        trainer.select_JobRole(jobRole2);
        trainer.clickOnAddForPreferredJobRole();
        Thread.sleep(2000);
        trainer.clickOn_AddPreferredLocation();
        Thread.sleep(2000);
        trainer.selectPreferredStateOrUnionTerritory(preferred_state1);
        trainer.selectPreferredDistrictOrCity(preferred_city1);
        trainer.selectPreferredSubDistrictOrTehsil(preferred_district1);
        trainer.clickOnAddForPreferredLocation();
        Thread.sleep(2000);
        trainer.clickOn_AddPreferredLocation();
        Thread.sleep(2000);
        trainer.selectPreferredStateOrUnionTerritory(preferred_state2);
        trainer.selectPreferredDistrictOrCity(preferred_city2);
        trainer.selectPreferredSubDistrictOrTehsil(preferred_district2);
        trainer.clickOnAddForPreferredLocation();
        Thread.sleep(2000);
        trainer.clickOn_AddPreferredLocation();
        Thread.sleep(2000);
        trainer.selectPreferredStateOrUnionTerritory(preferred_state3);
        trainer.selectPreferredDistrictOrCity(preferred_city3);
        trainer.selectPreferredSubDistrictOrTehsil(preferred_district3);
        trainer.clickOnAddForPreferredLocation();
        Thread.sleep(2000);
        trainer.clickOnDeleteThirdPreferredLocation();
        trainer.clickOnSaveAndContinue();
        Thread.sleep(2000);
        trainer.clickIAgreeCheckbox();
        Thread.sleep(2000);
        trainer.clickSubmitButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Thank You']")).getText(), "Thank You");
        trainer.clickLogOutButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//li[text()='Login']")).getText(), "Login");
        Thread.sleep(2000);
	}
    
    //Verifying and Updating Trainer Registration Data 
       
     @DataProvider
     public Object[][] trainerMyProfileVerificationData()
     {
       	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Trainer-Workflow.xls", "VerificationSC03TC02");
     }
     @Test(dataProvider="trainerMyProfileVerificationData",dependsOnMethods="trainerRegistrationTC_01")
     public void trainerMyProfileVerificationTC_02(String trainerUserName, String trainerPassword, String expectedNameOfApplicant, String expectedGender, String expectedDateOfBirth, String expectedLanguages, String expectedReligion, String expectedCategory, String expectedDisability, String expectedAadharNumVerificationStatus, String fileName, String expectedApplicantCategory, String expectedMobileNum, String expectedEmail, String expectedAddress,String expectedNearbyLandmark, String expectedPincode, String expectedState, String expectedDistrict, String expectedTehsil, String expectedParlimentaryConstituency, String expectedEducationAttainedType1, String expectedDetailsOfEducation1, String expectedEducationProofOfDocPresence1,String expectedEducationAttainedType2, String expectedDetailsOfEducation2, String expectedEducationProofOfDocPresence2,String expectedEducationAttainedType3, String expectedDetailsOfEducation3, String expectedEducationProofOfDocPresence3, String expectedIndustrialRelevantSector1, String expectedIndustrialExperienceDetails1, String expectedTotalYearsOfIndusrialExperience1,String expectedTotalMonthsOfIndustrialExperience1, String expectedIndustrialProofDocPresence1,String expectedIndustrialRelevantSector2, String expectedIndustrialExperienceDetails2, String expectedTotalYearsOfIndusrialExperience2,String expectedTotalMonthsOfIndustrialExperience2, String expectedIndustrialProofDocPresence2,String expectedIndustrialRelevantSector3, String expectedIndustrialExperienceDetails3, String expectedTotalYearsOfIndusrialExperience3,String expectedTotalMonthsOfIndustrialExperience3, String expectedIndustrialProofDocPresence3, String expectedTrainingRelevantSector1, String expectedTrainingExperienceDetails1, String expectedTotalYearsOfTrainingExperience1,String expectedTotalMonthsOfTrainingExperience1, String expectedTrainingDocPresence1,String expectedTrainingRelevantSector2, String expectedTrainingExperienceDetails2, String expectedTotalYearsOfTrainingExperience2,String expectedTotalMonthsOfTrainingExperience2, String expectedTrainingDocPresence2,String expectedTrainingRelevantSector3, String expectedTrainingExperienceDetails3, String expectedTotalYearsOfTrainingExperience3,String expectedTotalMonthsOfTrainingExperience3, String expectedTrainingDocPresence3,String currriculumVitaeFile) throws Exception
     {
       	LoginPage lp=new LoginPage(driver);
       	lp.clickLogin();
       	EnterLoginPage elp=new EnterLoginPage(driver);
       	elp.performlogin(trainerUserName, trainerPassword);
       	Thread.sleep(2000);
       	TrainerMyProfilePage tMpP=new TrainerMyProfilePage(driver);
       	tMpP.clickProfile();
       	Thread.sleep(2000);
       	Assert.assertEquals(tMpP.getNameOfTheApplicant(),expectedNameOfApplicant);
       	Assert.assertEquals(tMpP.getGenderOfApplicant(), expectedGender);
       	Assert.assertEquals(tMpP.getDateOfBirth(), expectedDateOfBirth);
       	Select select1=new Select(driver.findElement(By.xpath("//div[label[contains(text(),'Languages Known:')]]/div/select")));
    	List<WebElement> selectedLanguages=select1.getAllSelectedOptions();
    	if(selectedLanguages.size()==1)
    	{
    		String selectedLanguage1=selectedLanguages.get(0).getText();
    		Assert.assertEquals(selectedLanguage1, expectedLanguages);
    	}
    	else if(selectedLanguages.size()==2)
    	{
    		String selectedLanguage1=selectedLanguages.get(0).getText();
        	String selectedLanguage2=selectedLanguages.get(1).getText();
        	Assert.assertEquals((selectedLanguage1+","+selectedLanguage2), expectedLanguages);
    	}
    	else if(selectedLanguages.size()==3)
    	{
    		String selectedLanguage1=selectedLanguages.get(0).getText();
        	String selectedLanguage2=selectedLanguages.get(1).getText();
        	String selectedLanguage3=selectedLanguages.get(2).getText();
        	Assert.assertEquals((selectedLanguage1+","+selectedLanguage2+","+selectedLanguage3), expectedLanguages);
    	}
      	Assert.assertEquals(tMpP.getReligion(), expectedReligion);
       	Assert.assertEquals(tMpP.getCategory(), expectedCategory);
       	Assert.assertEquals(tMpP.getDisability(), expectedDisability);
       	//Assert.assertEquals(tMpP.getAadharNumVerificationStatus(), expectedAadharNumVerificationStatus);
       	Thread.sleep(2000);
       	tMpP.clickBrowseFile();
       	Thread.sleep(2000);
       	UploadFile.upload(fileName);
       	Thread.sleep(2000);
       	tMpP.clickUploadfile();
       	Thread.sleep(4000);
       	Select select2=new Select(driver.findElement(By.xpath("//div[label[contains(text(),'Select Applicant Category:')]]/div/select")));
       	List<WebElement> selectedApplicantCategories=select2.getAllSelectedOptions();
       	if(selectedApplicantCategories.size()==1)
       	{
       		Assert.assertEquals(selectedApplicantCategories.get(0).getText(), expectedApplicantCategory);
       	}
       	else if(selectedApplicantCategories.size()==2)
       	{
       		Assert.assertEquals(selectedApplicantCategories.get(0).getText()+","+selectedApplicantCategories.get(1).getText(), expectedApplicantCategory);
       	}
       	
       	tMpP.clickSaveChanges1();
       	//Assessor Contact and Address verification
       	JavascriptExecutor js=(JavascriptExecutor)driver;
       	js.executeScript("window.scrollBy(0,-1000)","");
       	Thread.sleep(2000);
       	tMpP.clickContactAndAddress();
       	Thread.sleep(4000);
       	Assert.assertEquals(tMpP.getMobileNumOfApplicant(), expectedMobileNum);
       	Assert.assertEquals(tMpP.getEmailOfApplicant(), expectedEmail);
       	Assert.assertEquals(tMpP.getAddressOfApplicant(), expectedAddress);
       	Assert.assertEquals(tMpP.getNearByLandMark(), expectedNearbyLandmark);
       	Assert.assertEquals(tMpP.getPincode(), expectedPincode);
       	Assert.assertEquals(tMpP.getState(), expectedState);
       	Assert.assertEquals(tMpP.getDistrict(), expectedDistrict);
       	Assert.assertEquals(tMpP.getTehsil(), expectedTehsil);
       	Assert.assertEquals(tMpP.getParlimentaryConstituency(), expectedParlimentaryConstituency);
       	//Education & Work verification
       	Thread.sleep(2000);
       	tMpP.clickEducationAndWork();
       	Thread.sleep(2000);
        if(expectedEducationAttainedType1.equals("Uneducated") && expectedEducationAttainedType2.equals("Uneducated"))
        {
           Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table table-striped'])[1]/tbody")).getText(), "No record found");
        }
        else
        {
        	Assert.assertEquals(tMpP.getEducationAttainedType1(), expectedEducationAttainedType1);
           	Assert.assertEquals(tMpP.getDetailsOfEducation1(), expectedDetailsOfEducation1);
           	Assert.assertEquals(tMpP.getEducationProofDocument1Presence(), expectedEducationProofOfDocPresence1);
           	//Education Record 2
           	Assert.assertEquals(tMpP.getEducationAttainedType2(), expectedEducationAttainedType2);
           	Assert.assertEquals(tMpP.getDetailsOfEducation2(), expectedDetailsOfEducation2);
           	Assert.assertEquals(tMpP.getEducationProofDocument2Presence(), expectedEducationProofOfDocPresence2);
        }
      	//Industrial Records
        int totalIndustrialMonths=((Integer.parseInt(expectedTotalYearsOfIndusrialExperience1)+Integer.parseInt(expectedTotalYearsOfIndusrialExperience2))*12)+Integer.parseInt(expectedTotalMonthsOfIndustrialExperience1)+Integer.parseInt(expectedTotalMonthsOfIndustrialExperience2);
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
       	Assert.assertEquals(tMpP.getIndustrialRelaventSector1(), expectedIndustrialRelevantSector1);
       	Assert.assertEquals(tMpP.getIndustrialExperienceDetails1(), expectedIndustrialExperienceDetails1);
       	Assert.assertEquals(tMpP.getTotalIndustrialExperience1(), expectedTotalYearsOfIndusrialExperience1+" "+"Year"+" "+expectedTotalMonthsOfIndustrialExperience1+" "+"months");
       	Assert.assertEquals(tMpP.getIndustrialExperienceProofDoc1Presence(), expectedIndustrialProofDocPresence1);
       	//industrial record 2
       	Assert.assertEquals(tMpP.getIndustrialRelaventSector2(), expectedIndustrialRelevantSector2);
       	Assert.assertEquals(tMpP.getIndustrialExperienceDetails2(), expectedIndustrialExperienceDetails2);
       	Assert.assertEquals(tMpP.getTotalIndustrialExperience2(), expectedTotalYearsOfIndusrialExperience2+" "+"Year"+" "+expectedTotalMonthsOfIndustrialExperience2+" "+"months");
       	Assert.assertEquals(tMpP.getIndustrialExperienceProofDoc2Presence(), expectedIndustrialProofDocPresence2);
       	//Training Records
       	int totalTrainingMonths=((Integer.parseInt(expectedTotalYearsOfTrainingExperience1)+Integer.parseInt(expectedTotalYearsOfTrainingExperience2))*12)+Integer.parseInt(expectedTotalMonthsOfTrainingExperience1)+Integer.parseInt(expectedTotalMonthsOfTrainingExperience2);
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
       	Assert.assertEquals(tMpP.getTrainingRelaventSector1(), expectedTrainingRelevantSector1);
       	Assert.assertEquals(tMpP.getTrainingExperienceDetails1(), expectedTrainingExperienceDetails1);
       	Assert.assertEquals(tMpP.getTotalTrainingExperience1(), expectedTotalYearsOfTrainingExperience1+" "+"Year"+" "+expectedTotalMonthsOfTrainingExperience1+" "+"months");
       	Assert.assertEquals(tMpP.getTrainingProofDoc1Presence(), expectedTrainingDocPresence1);
       	//training record 2
       	Assert.assertEquals(tMpP.getTrainingRelaventSector2(), expectedTrainingRelevantSector2);
       	Assert.assertEquals(tMpP.getTrainingExperienceDetails2(), expectedTrainingExperienceDetails2);
       	Assert.assertEquals(tMpP.getTotalTrainingExperience2(), expectedTotalYearsOfTrainingExperience2+" "+"Year"+" "+expectedTotalMonthsOfTrainingExperience2+" "+"months");
       	Assert.assertEquals(tMpP.getTrainingProofDoc2Presence(), expectedTrainingDocPresence2);
       	Thread.sleep(2000);
       	tMpP.clickCurriculumVitaeBrowse();
       	Thread.sleep(2000);
       	UploadFile.upload(currriculumVitaeFile);
       	Thread.sleep(2000);
       	tMpP.clickCurriculumVitaeUpload();
       	Thread.sleep(4000);
       	tMpP.clickSaveChanges2();
       	Thread.sleep(2000);
       	js.executeScript("window.scrollBy(0,-1000)","");
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
    @DataProvider
    public Object[][]trainerSearchAndApplyForAvailableBatchData()
    {
    	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Trainer-Workflow.xls", "TrainerApplyForBatchTestSC03TC03");
    }
    @Test(dataProvider="trainerSearchAndApplyForAvailableBatchData",dependsOnMethods="trainerMyProfileVerificationTC_02")
 	public void trainerSearchAndApplyForAvailableBatchTC_03(String trainerUsername, String trainerPassword, String searchByEnteringMandatoryFieldsOrAll,String state, String district, String subDistrict, String sector, String subSector, String jobrole, String batchType, String batchStatus,String actionDropdownMenuOption) throws Exception
 	{
 		LoginPage lp=new LoginPage(driver);
 		lp.clickLogin();
 		Thread.sleep(2000);
 		EnterLoginPage elp=new EnterLoginPage(driver);
 		elp.performlogin(trainerUsername, trainerPassword);
 		TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
 		Thread.sleep(10000);
 		Assert.assertFalse(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase(""),"please provide search option : mandatory or all fields in respected excel sheet");
 		tDp.clickSearchAndApplyforAvailableBatches();
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
 			tSp.selectBatchType(batchType);
 			Thread.sleep(2000);
 			tSp.selectBatchStatus(batchStatus);
 			Thread.sleep(6000);
 			tSp.enterBatchStartDate();
 			//enteredBatchStartDate=driver.findElement(By.id("totApplicantStartDate")).getAttribute("value").replaceAll("/","-");
 			Thread.sleep(6000);
 			tSp.clickToCloseBatchStartDateCalender();
 			//enteredBatchEndDate=driver.findElement(By.id("totApplicantEndDate")).getAttribute("value").replaceAll("/","-");
 			Thread.sleep(2000);
 			tSp.enterBatchEndDate();
 			Thread.sleep(6000);
 			tSp.clickToCloseBatchEndDateCalender();
 			Thread.sleep(2000);
 		}
 		Thread.sleep(6000);
 		tSp.clickSearch();
 		Thread.sleep(2000);
 		Assert.assertEquals(driver.getCurrentUrl(),"http://13.232.121.96/trainer/applicant/apply-for-batch/search-results");
 		Assert.assertTrue(driver.findElements(By.tagName("tr")).size()>1,"Sorry! There are no resulted batch records for your search!!! ");
 		for(int i=1;i<=6;i++)
 		{
 			String batchID=ReadWriteData.getData("./TestData/Workflow/Trainer-Workflow.xls","TrainerBatchesForTestSC03TC03", i, 0);
 			tSp.enterSearchKeyword(batchID);
 			Thread.sleep(2000);
 			if(driver.findElements(By.tagName("tr")).size()<2)
 			{
 			Assert.assertTrue(driver.findElements(By.tagName("tr")).size()<2);
 			}
 			else
 			{
 				tSp.clickAction();
 				Thread.sleep(2000);
 				if(actionDropdownMenuOption.equals("View Details"))
 				{
 					tSp.selectViewDetails();
 					Thread.sleep(4000);
 					String trainingCentreSPOCName=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 16);
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='trainingcenternme']")).getAttribute("value"),trainingCentreSPOCName );
 					String trainingCentreSPOCNMobileNum=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 18);
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='mobilespoc']")).getAttribute("value"), trainingCentreSPOCNMobileNum);
 					String trainingCentreSPOCEmail=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 17);
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='emilspoc']")).getAttribute("value"), trainingCentreSPOCEmail);
 					String trainingCentreAddress=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 5);
 					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='centreaddress']")).getAttribute("value"), trainingCentreAddress);
 					String trainingCentreLandmark=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 6);
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='landmark']")).getAttribute("value"), trainingCentreLandmark);
 					String trainingCentrePincode=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 7); 
 					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='pincode']")).getAttribute("value"), trainingCentrePincode);
 					
 					if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields"))
 					{
 						Assert.assertEquals(driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value"), state);
 						Assert.assertEquals(driver.findElement(By.xpath("//input[@name='district']")).getAttribute("value"), district);
 						Assert.assertEquals(driver.findElement(By.xpath("//input[@name='tehsil']")).getAttribute("value"), subDistrict);
 						Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'SED')]")).getText().trim(), jobrole);
 						Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Apparel')]")).getText().trim(), sector);
 					}
 					else if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("mandatory"))
 					{
 						Assert.assertEquals(driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value"), state);
 						Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Apparel')]")).getText().trim(), sector);
 					}
 					tSp.clickApplyForBatch();
 					Thread.sleep(2000);
 					List<WebElement> ele = driver.findElements(By.xpath("//div[@id='toast-container']/div/div"));
 					if(ele.size()!=0)
 					{
 						Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("This Candidate already applied for this Batch or he/she is a MasterTrainer"), "new batch");
 						driver.navigate().back();
 						Thread.sleep(4000);
 					}
 					else
 					{
 						Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().trim().endsWith(batchID), "Trainer searched and applied batch mismatch");
 						tSp.clickOK();
 						Thread.sleep(2000);
 						driver.navigate().back();
 						Thread.sleep(2000);
 					}
 				}
 				else if(actionDropdownMenuOption.equals("Apply to the batch"))
 				{
 					tSp.selectApplyToBatch();
 					Thread.sleep(2000);
 					List<WebElement> ele = driver.findElements(By.xpath("//div[@id='toast-container']/div/div"));
 					if(ele.size()!=0)
 					{
 						Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("This Candidate already applied for this Batch or he/she is a MasterTrainer"), "new batch");
 						Thread.sleep(4000);
 					}
 					else
 					{
 						Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().trim().endsWith(batchID), "Trainer searched and applied batch mismatch");
 						Thread.sleep(2000);
 						tSp.clickOK();
 						Thread.sleep(2000);
 					}
 				}
 			}
 			
 			}
 			
 		PostLoginPage plp=new PostLoginPage(driver);
 		plp.clickOnProfileLogo();
 		Thread.sleep(2000);
 		plp.clickOnLogout();
 		Thread.sleep(2000);
 	}
        
}

