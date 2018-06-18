package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.AssessorRegistrationPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.testConfig.TestConfiguration;

public class AssessorWorkflowTestSC_4 extends TestConfiguration
{
    @DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/assessor-Workflow.xls", "AssessorRegistrationSC04TC01");
    }
    
    @Test(dataProvider="registrationData")
    public void assessorRegistrationTC_01(String userType, String name, String email, String mobile, String emailOTP, String mobileOTP, String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String jobRole_sector1, String jobRole_subSector1, String jobRole1, String jobRole_sector2, String jobRole_subSector2, String jobRole2, String preferred_state1, String preferred_city1, String preferred_district1, String preferred_state2, String preferred_city2, String preferred_district2, String preferred_state3, String preferred_city3, String preferred_district3) throws Exception
    {
        //DatabaseConnection.deleteassessor(email);
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        lp.clickRegister();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.selectDropdownList(userType);
        rp.enterSPOCName(name);
        rp.enterEmail(email);
        rp.enterMobile(mobile);
        rp.clickRegister();
        Thread.sleep(2000);
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(mobileOTP);
        Thread.sleep(2000);
        rp.clickVerify();
        Thread.sleep(2000);
        
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
        Thread.sleep(4000);
        
        AssessorRegistrationPage assessor = new AssessorRegistrationPage(driver);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).getAttribute("value"), name);
        assessor.selectGender(gender);
        assessor.selectDateOfBirth(dob);
        
        if(language.equals("Kannada,English,Hindi"))
        {
            assessor.selectAllLanguages();
        }
        else
        {
            assessor.selectAnyKnownLanguage(language);
        }
        
        assessor.selectReligion(religion);
        assessor.selectCategory(category);
        
        if(disability.equals("Not Applicable"))
        {
            assessor.selectDisability(disability);
        }
        else
        {
            assessor.selectDisability(disability);
            assessor.clickOnBrowseForUploadDisabilityDocument();
            Thread.sleep(2000);
            UploadFile.upload(disabilityFile);
            Thread.sleep(2000);
            assessor.clickOnUploadButtonForUploadDisabilityDocument();
            Thread.sleep(4000);
        }
        
        String aadharPan = aadhaarOrPAN.toLowerCase();
        
        if(aadharPan.equals("aadhaar"))
        {
            assessor.clickOnAadharNumberRadioButton();
            assessor.enterAadharNumber(idNumber);
            assessor.clickOnValidateAadharNumber();
        }
        else if(aadharPan.equals("pan"))
        {
            assessor.clickOnPanNumberRadioButton();
            assessor.enterPanNumber(idNumber);
            assessor.clickOnBrowseFileButtonForUploadPanDocument();
            Thread.sleep(2000);
            UploadFile.upload(uploadPanDocument);
            Thread.sleep(2000);
            assessor.clickOnUploadButtonToUploadPan();
            Thread.sleep(4000);
        }
        
        assessor.clickOnBrowseFileButtonToUploadPhoto();
        Thread.sleep(2000);
        UploadFile.upload(photoFile);
        Thread.sleep(2000);
        assessor.clickOnUploadButtonToUploadPhoto();
        Thread.sleep(4000);
        
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
        
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='phone']")).getAttribute("value"), mobile);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='email']")).getAttribute("value"), email);
        assessor.enterApplicantAddress(address);
        assessor.enterNearbyLandmark(landmark);
        assessor.enterPincode(pincode);
        assessor.selectStateOrUnionTerritory(state);
        assessor.selectDistrictOrCity(city);
        assessor.selectTehsilOrMandal(mandal);
        assessor.selectParliamentaryConstituency(parliamentaryConstituency);
        Thread.sleep(2000);
        assessor.clickOnSaveAndContinue();
        
        if(education1.equals("Not Applicable"))
        {
            assessor.selectEducationAttained(education1);
        }
        else
        {
            assessor.selectEducationAttained(education1);
            assessor.enterDetailsOfEducation(edu_details1);
            assessor.clickOnBrowseForUploadEducationProofDocument();
            Thread.sleep(2000);
            UploadFile.upload(edu_document2);
            Thread.sleep(2000);
            assessor.clickOnUploadForUploadEducationProofDocument();
            Thread.sleep(4000);
            assessor.clickOnAddEducationDetailsButton();
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education1+"')]")).getText(), education1);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details1+"')]")).getText(), edu_details1);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[1]")).getText(), "yes");
        }
        if(education2.equals("Not Applicable"))
        {
            assessor.selectEducationAttained(education2);
        }
        else
        {
            assessor.selectEducationAttained(education2);
            assessor.enterDetailsOfEducation(edu_details2);
            assessor.clickOnBrowseForUploadEducationProofDocument();
            Thread.sleep(2000);
            UploadFile.upload(edu_document2);
            Thread.sleep(2000);
            assessor.clickOnUploadForUploadEducationProofDocument();
            Thread.sleep(4000);
            assessor.clickOnAddEducationDetailsButton();
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education2+"')]")).getText(), education2);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details2+"')]")).getText(), edu_details2);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[2]")).getText(), "yes");
        }
        if(education2.equals("Not Applicable"))
        {
            assessor.selectEducationAttained(education2);
        }
        else
        {
            assessor.selectEducationAttained(education3);
            assessor.enterDetailsOfEducation(edu_details3);
            Thread.sleep(2000);
            assessor.clickOnAddEducationDetailsButton();
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education3+"')]")).getText(), education3);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details3+"')]")).getText(), edu_details3);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'no')])[1]")).getText(), "no");
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
        Thread.sleep(2000);
        assessor.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        assessor.clickOnAddIndustrialExperienceDetails();
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
        Thread.sleep(2000);
        assessor.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        assessor.clickOnAddIndustrialExperienceDetails();
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
        Thread.sleep(2000);
        assessor.clickOnUploadForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        assessor.clickOnAddIndustrialExperienceDetails();
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrial_sector3+"')]")).getText(), industrial_sector3);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+industrialExperienceDetails3+"')]")).getText(), industrialExperienceDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText(), "Yes");
        if(education1.equals("Not Applicable") || education2.equals("Not Applicable") || education3.equals("Not Applicable"))
        {
            assessor.deleteThirdIndustrialExperienceDetailsWithoutEducationDetail();
        }
        else
        {
            assessor.deleteThirdIndustrialExperienceDetails();
        }
        
        assessor.selectRelevantSectorForTrainingExperience(training_sector1);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears1);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths1);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails1);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(trainingDocument1);
        Thread.sleep(2000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        assessor.clickOnAddTrainingExperienceDetails();
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector1+"')]")).getText(), training_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails1+"')]")).getText(), trainingExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[3]")).getText(), "Yes");
        
        assessor.selectRelevantSectorForTrainingExperience(training_sector1);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears1);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths1);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails1);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(trainingDocument1);
        Thread.sleep(2000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        assessor.clickOnAddTrainingExperienceDetails();
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector1+"')]")).getText(), training_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails1+"')]")).getText(), trainingExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[4]")).getText(), "Yes");
        
        assessor.selectRelevantSectorForTrainingExperience(training_sector1);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears1);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths1);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails1);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(trainingDocument1);
        Thread.sleep(2000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        assessor.clickOnAddTrainingExperienceDetails();
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+training_sector1+"')]")).getText(), training_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingExperienceDetails1+"')]")).getText(), trainingExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Yes')])[5]")).getText(), "Yes");
        if(education1.equals("Not Applicable") || education2.equals("Not Applicable") || education3.equals("Not Applicable"))
        {
            assessor.deleteThirdTrainingExperienceWithoutEducationDetails();
        }
        else
        {
            assessor.deleteThirdTrainingExperienceDetails();
        }
        
        assessor.clickOnBrowseForCurriculumVitaeOrResume();
        Thread.sleep(2000);
        UploadFile.upload(resume);
        Thread.sleep(2000);
        assessor.clickOnUploadForCurriculumVitaeOrResume();
        Thread.sleep(4000);
        assessor.clickOnSaveAndContinue();
        
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
        assessor.selectSubSectorForJobRole(jobRole_subSector2);
        assessor.select_JobRole(jobRole2);
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
        
        Thread.sleep(2000);
        assessor.clickIAgreeCheckbox();
        Thread.sleep(2000);
        assessor.clickSubmitButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Thank You']")).getText(), "Thank You");
        assessor.clickLogOutButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//li[text()='Login']")).getText(), "Login");
    }
    
}

