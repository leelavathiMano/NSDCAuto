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
import com.nsdc.testConfig.DatabaseConnection;
import com.nsdc.testConfig.TestConfiguration;

public class AssessorWorkflowTestSC_04 extends TestConfiguration
{
	@DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls", "AssessorRegistrationSC04TC01");
    }
    
    @Test(dataProvider="registrationData")
    public void assessorRegistrationTC_01(String serialNum,String createdAssessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String jobRole_sector1, String jobRole_subSector1, String jobRole1, String jobRole_sector2, String jobRole_subSector2, String jobRole2, String preferred_state1, String preferred_city1, String preferred_district1, String preferred_state2, String preferred_city2, String preferred_district2, String preferred_state3, String preferred_city3, String preferred_district3) throws Exception
    {
        //DatabaseConnection.deleteAssessor(email);
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        lp.clickRegister();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.selectDropdownList(userType);
        rp.enterSPOCName(name);
        rp.enterEmail(email);
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "ProfileVerificationSC04TC02", Integer.parseInt(serialNum), 13, email);
        rp.enterMobile(mobile);
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "ProfileVerificationSC04TC02", Integer.parseInt(serialNum), 12, mobile);
        rp.clickIagree();
        rp.clickRegister();
        Thread.sleep(2000);
        List<WebElement> ele = driver.findElements(By.xpath("//div[@id='toast-container']/div/div"));
		if(ele.size()!=0)
		{
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().trim().startsWith("Duplicate"),"new trainer credentials only");
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
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "AssessorRegistrationSC04TC01", Integer.parseInt(serialNum), 1, createdAssessor);
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "ProfileVerificationSC04TC02", Integer.parseInt(serialNum), 0, createdAssessor);
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "AssessorApplyForBatchTestSC04TC03", Integer.parseInt(serialNum), 0, createdAssessor);
        String username = driver.findElement(By.xpath("//span[@class='text-bold']")).getText();
        rp.clickGoToLogin();
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, "ekaushal");
        Thread.sleep(2000);
        rp.enterOldPassword(oldPassword);
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "ProfileVerificationSC04TC02", Integer.parseInt(serialNum), 1, confirmPassword);        
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "AssessorApplyForBatchTestSC04TC03", Integer.parseInt(serialNum), 1, confirmPassword);        
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
        else if(language.equals("Kannada,Hindi"))
        {
        	assessor.selectTwoKnownLanguages();
        }
        else
        {
            assessor.selectAnyKnownLanguage(language);
        }
        
        assessor.selectReligion(religion);
        assessor.selectCategory(category);
        
        if(disability.equals("None"))
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
            Thread.sleep(2000);
            Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='aadhaarIdentity']/div/span")).getText(), "Verified");
        }
        else if(aadharPan.equals("pan"))
        {
            assessor.clickOnPanNumberRadioButton();
            assessor.enterPanNumber(idNumber);
            assessor.clickOnBrowseFileButtonForUploadPanDocument();
            Thread.sleep(3000);
            UploadFile.upload(uploadPanDocument);
            Thread.sleep(4000);
            assessor.clickOnUploadButtonToUploadPan();
            Thread.sleep(4000);
        }
        Thread.sleep(2000);
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
        
        if(education1.equals("Uneducated"))
        {
            assessor.selectEducationAttained(education1);
        }
        else
        {
            assessor.selectEducationAttained(education1);
            assessor.enterDetailsOfEducation(edu_details1);
            assessor.clickOnBrowseForUploadEducationProofDocument();
            Thread.sleep(2000);
            UploadFile.upload(edu_document1);
            Thread.sleep(2000);
            assessor.clickOnUploadForUploadEducationProofDocument();
            Thread.sleep(4000);
            assessor.clickOnAddEducationDetailsButton();
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education1+"')]")).getText(), education1);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details1+"')]")).getText(), edu_details1);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[1]")).getText(), "yes");
        }
        if(education2.equals("Uneducated"))
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
        if(education3.equals("Uneducated"))
        {
            assessor.selectEducationAttained(education3);
        }
        else
        {
            assessor.selectEducationAttained(education3);
            assessor.enterDetailsOfEducation(edu_details3);
            assessor.clickOnBrowseForUploadEducationProofDocument();
           	Thread.sleep(2000);
           	UploadFile.upload(edu_document3);
           	Thread.sleep(2000);
           	assessor.clickOnUploadForUploadEducationProofDocument();
           	Thread.sleep(4000);
            assessor.clickOnAddEducationDetailsButton();
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education3+"')]")).getText(), education3);
            Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details3+"')]")).getText(), edu_details3);
            Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[1]")).getText(), "yes");
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
        if(education1.equals("Uneducated") || education2.equals("Uneducated") || education3.equals("Uneducated"))
        {
            assessor.deleteThirdIndustrialExperienceDetailsWithoutEducationDetail();
        }
        else
        {
            assessor.deleteThirdIndustrialExperienceDetails();
        }
   /*     int totalIndustrialMonths=((Integer.parseInt(industrial_years1)+Integer.parseInt(industrial_years2))*12)+Integer.parseInt(industrial_months1)+Integer.parseInt(industrial_months2);
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
   	*/
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
        assessor.selectRelevantSectorForTrainingExperience(training_sector2);
        assessor.selectyearsForTrainingExperience(trainingExperienceYears2);
        assessor.selectMonthsForTrainingExperience(trainingExperienceMonths2);
        assessor.enterTrainingExperienceDetails(trainingExperienceDetails2);
        assessor.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(trainingDocument2);
        Thread.sleep(2000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        assessor.clickOnAddTrainingExperienceDetails();
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
        Thread.sleep(2000);
        assessor.clickOnUploadForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        assessor.clickOnAddTrainingExperienceDetails();
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
  /*      int totalTrainingMonths=((Integer.parseInt(trainingExperienceYears1)+Integer.parseInt(trainingExperienceYears2))*12)+Integer.parseInt(trainingExperienceMonths1)+Integer.parseInt(trainingExperienceMonths2);
      	int finalTrainingMonths=totalTrainingMonths%12;
    	int finalTrainingYears=(totalTrainingMonths-finalTrainingMonths)/12;
    	if(finalTrainingMonths==0)
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[2]")).getText(),":"+finalTrainingYears+" Years Total Industrial Experience");
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[2]")).getText(),":"+finalTrainingYears+" Years "+finalTrainingMonths+" months Total Industrial Experience");
    	}
    */
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
       
    @DataProvider
    public Object[][] assessorMyProfileVerificationData()
    {
    	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls", "ProfileVerificationSC04TC02");
    }
    @Test(dataProvider="assessorMyProfileVerificationData",dependsOnMethods="assessorRegistrationTC_01")
    public void assessorMyProfileVerificationTC_02(String assessorUserName, String assessorPassword, String expectedNameOfApplicant, String expectedGender, String expectedDateOfBirth, String expectedLanguages, String expectedReligion, String expectedCategory, String expectedDisability, String expectedAadharNumVerificationStatus, String fileName, String expectedApplicantCategory, String expectedMobileNum, String expectedEmail, String expectedAddress,String expectedNearbyLandmark, String expectedPincode, String expectedState, String expectedDistrict, String expectedTehsil, String expectedParlimentaryConstituency, String expectedEducationAttainedType1, String expectedDetailsOfEducation1, String expectedEducationProofOfDocPresence1,String expectedEducationAttainedType2, String expectedDetailsOfEducation2, String expectedEducationProofOfDocPresence2,String expectedEducationAttainedType3, String expectedDetailsOfEducation3, String expectedEducationProofOfDocPresence3, String expectedIndustrialRelevantSector1, String expectedIndustrialExperienceDetails1, String expectedTotalYearsOfIndusrialExperience1,String expectedTotalMonthsOfIndustrialExperience1, String expectedIndustrialProofDocPresence1,String expectedIndustrialRelevantSector2, String expectedIndustrialExperienceDetails2, String expectedTotalYearsOfIndusrialExperience2,String expectedTotalMonthsOfIndustrialExperience2, String expectedIndustrialProofDocPresence2,String expectedIndustrialRelevantSector3, String expectedIndustrialExperienceDetails3, String expectedTotalYearsOfIndusrialExperience3,String expectedTotalMonthsOfIndustrialExperience3, String expectedIndustrialProofDocPresence3, String expectedTrainingRelevantSector1, String expectedTrainingExperienceDetails1, String expectedTotalYearsOfTrainingExperience1,String expectedTotalMonthsOfTrainingExperience1, String expectedTrainingDocPresence1,String expectedTrainingRelevantSector2, String expectedTrainingExperienceDetails2, String expectedTotalYearsOfTrainingExperience2,String expectedTotalMonthsOfTrainingExperience2, String expectedTrainingDocPresence2,String expectedTrainingRelevantSector3, String expectedTrainingExperienceDetails3, String expectedTotalYearsOfTrainingExperience3,String expectedTotalMonthsOfTrainingExperience3, String expectedTrainingDocPresence3,String currriculumVitaeFile) throws Exception
    {
    	LoginPage lp=new LoginPage(driver);
    	lp.clickLogin();
    	EnterLoginPage elp=new EnterLoginPage(driver);
    	elp.performlogin(assessorUserName, assessorPassword);
    	Thread.sleep(2000);
    	AssessorMyProfilePage aMpP=new AssessorMyProfilePage(driver);
    	aMpP.clickProfile();
    	Thread.sleep(2000);
    	Assert.assertEquals(aMpP.getNameOfTheApplicant(),expectedNameOfApplicant);
    	Assert.assertEquals(aMpP.getGenderOfApplicant(), expectedGender);
    	Assert.assertEquals(aMpP.getDateOfBirth(), expectedDateOfBirth);
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
		Assert.assertEquals(aMpP.getReligion(), expectedReligion);
    	Assert.assertEquals(aMpP.getCategory(), expectedCategory);
    	Assert.assertEquals(aMpP.getDisability(), expectedDisability);
    	//Assert.assertEquals(aMpP.getAadharNumVerificationStatus(), expectedAadharNumVerificationStatus);
    	Thread.sleep(2000);
    	aMpP.clickBrowseFile();
    	Thread.sleep(2000);
    	UploadFile.upload(fileName);
    	Thread.sleep(2000);
    	aMpP.clickUploadfile();
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
    	
    	aMpP.clickSaveChanges1();
    	//Assessor Contact and Address verification
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,-1000)","");
    	Thread.sleep(2000);
    	aMpP.clickContactAndAddress();
    	Thread.sleep(4000);
    	Assert.assertEquals(aMpP.getMobileNumOfApplicant(), expectedMobileNum);
    	Assert.assertEquals(aMpP.getEmailOfApplicant(), expectedEmail);
    	Assert.assertEquals(aMpP.getAddressOfApplicant(), expectedAddress);
    	Assert.assertEquals(aMpP.getNearByLandMark(), expectedNearbyLandmark);
    	Assert.assertEquals(aMpP.getPincode(), expectedPincode);
    	Assert.assertEquals(aMpP.getState(), expectedState);
    	Assert.assertEquals(aMpP.getDistrict(), expectedDistrict);
    	Assert.assertEquals(aMpP.getTehsil(), expectedTehsil);
    	Assert.assertEquals(aMpP.getParlimentaryConstituency(), expectedParlimentaryConstituency);
    	//Education & Work verification
    	Thread.sleep(2000);
    	aMpP.clickEducationAndWork();
    	Thread.sleep(2000);
    	 if(expectedEducationAttainedType1.equals("Uneducated") && expectedEducationAttainedType2.equals("Uneducated"))
         {
            Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table table-striped'])[1]/tbody")).getText(), "No records found");
         }
    	 else
    	 {
    		Assert.assertEquals(aMpP.getEducationAttainedType1(), expectedEducationAttainedType1);
    	    Assert.assertEquals(aMpP.getDetailsOfEducation1(), expectedDetailsOfEducation1);
    	    Assert.assertEquals(aMpP.getEducationProofDocument1Presence(), expectedEducationProofOfDocPresence1);
    	    //Education Record 2
    	    Assert.assertEquals(aMpP.getEducationAttainedType2(), expectedEducationAttainedType2);
    	    Assert.assertEquals(aMpP.getDetailsOfEducation2(), expectedDetailsOfEducation2);
    	    Assert.assertEquals(aMpP.getEducationProofDocument2Presence(), expectedEducationProofOfDocPresence2);
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
     	Assert.assertEquals(aMpP.getIndustrialRelaventSector1(), expectedIndustrialRelevantSector1);
       	Assert.assertEquals(aMpP.getIndustrialExperienceDetails1(), expectedIndustrialExperienceDetails1);
    	Assert.assertEquals(aMpP.getTotalIndustrialExperience1(), expectedTotalYearsOfIndusrialExperience1+" "+"Year"+" "+expectedTotalMonthsOfIndustrialExperience1+" "+"months");
    	Assert.assertEquals(aMpP.getIndustrialExperienceProofDoc1Presence(), expectedIndustrialProofDocPresence1);
    	//industrial record 2
    	Assert.assertEquals(aMpP.getIndustrialRelaventSector2(), expectedIndustrialRelevantSector2);
       	Assert.assertEquals(aMpP.getIndustrialExperienceDetails2(), expectedIndustrialExperienceDetails2);
    	Assert.assertEquals(aMpP.getTotalIndustrialExperience2(), expectedTotalYearsOfIndusrialExperience2+" "+"Year"+" "+expectedTotalMonthsOfIndustrialExperience2+" "+"months");
    	Assert.assertEquals(aMpP.getIndustrialExperienceProofDoc2Presence(), expectedIndustrialProofDocPresence2);
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
     	
    	Assert.assertEquals(aMpP.getTrainingRelaventSector1(), expectedTrainingRelevantSector1);
    	Assert.assertEquals(aMpP.getTrainingExperienceDetails1(), expectedTrainingExperienceDetails1);
    	Assert.assertEquals(aMpP.getTotalTrainingExperience1(), expectedTotalYearsOfTrainingExperience1+" "+"Year"+" "+expectedTotalMonthsOfTrainingExperience1+" "+"months");
    	Assert.assertEquals(aMpP.getTrainingProofDoc1Presence(), expectedTrainingDocPresence1);
    	//training record 2
    	Assert.assertEquals(aMpP.getTrainingRelaventSector2(), expectedTrainingRelevantSector2);
    	Assert.assertEquals(aMpP.getTrainingExperienceDetails2(), expectedTrainingExperienceDetails2);
    	Assert.assertEquals(aMpP.getTotalTrainingExperience2(), expectedTotalYearsOfTrainingExperience2+" "+"Year"+" "+expectedTotalMonthsOfTrainingExperience2+" "+"months");
    	Assert.assertEquals(aMpP.getTrainingProofDoc2Presence(), expectedTrainingDocPresence2);
    	Thread.sleep(2000);
    	aMpP.clickCurriculumVitaeBrowse();
    	Thread.sleep(2000);
    	UploadFile.upload(currriculumVitaeFile);
    	Thread.sleep(2000);
    	aMpP.clickCurriculumVitaeUpload();
    	Thread.sleep(4000);
    	aMpP.clickSaveChanges2();
    	Thread.sleep(2000);
    	js.executeScript("window.scrollBy(0,-1000)","");
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
    @DataProvider
	public Object[][] assessorSearchAndApplyForAvailableBatchData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Assessor-Workflow.xls","AssessorApplyForBatchTestSC04TC03");
	}
	
	@Test(dataProvider="assessorSearchAndApplyForAvailableBatchData",dependsOnMethods="assessorMyProfileVerificationTC_02")
	public void assessorSearchAndApplyForAvailableBatchTC_03(String assessorUsername, String assessorPassword, String searchByEnteringMandatoryFieldsOrAll,String state, String district, String subDistrict, String sector, String subSector, String jobrole, String batchType, String batchStatus,String actionDropdownMenuOption) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(assessorUsername, assessorPassword);
		AssessorApplicantDashboardPage aDp=new AssessorApplicantDashboardPage(driver);
		Thread.sleep(10000);
		aDp.clickToGetApplicantDashboard();
		Assert.assertFalse(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase(""),"please provide search option : mandatory or all fields in respected excel sheet");
		aDp.clickSearchAndApplyforAvailableBatches();
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
			aSp.selectBatchType(batchType);
			Thread.sleep(2000);
			aSp.selectBatchStatus(batchStatus);
			Thread.sleep(6000);
			aSp.enterBatchStartDate();
			//enteredBatchStartDate=driver.findElement(By.id("totApplicantStartDate")).getAttribute("value").replaceAll("/","-");
			Thread.sleep(6000);
			aSp.clickToCloseBatchStartDateCalender();
			//enteredBatchEndDate=driver.findElement(By.id("totApplicantEndDate")).getAttribute("value").replaceAll("/","-");
			Thread.sleep(2000);
			aSp.enterBatchEndDate();
			Thread.sleep(6000);
			aSp.clickToCloseBatchEndDateCalender();
			Thread.sleep(2000);
		}
		Thread.sleep(6000);
		aSp.clickSearch();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://13.232.121.96/assessor/applicant/apply-for-batch/search-results");
		Assert.assertTrue(driver.findElements(By.tagName("tr")).size()>1,"Sorry! There are no resulted batch records for your search!!! ");
		for(int i=1;i<=6;i++)
		{
			String batchID=ReadWriteData.getData("./TestData/Workflow/Assessor-Workflow.xls","AssessorBatchesForTestSC04TC03",i, 0);
			aSp.enterSearchKeyword(batchID);
			Thread.sleep(2000);
			if(driver.findElements(By.tagName("tr")).size()<2)
			{
				Assert.assertTrue(driver.findElements(By.tagName("tr")).size()<2);
			}
			else
			{
				aSp.clickAction();
				Thread.sleep(2000);
				if(actionDropdownMenuOption.equals("View Details"))
				{
					aSp.selectViewDetails();
					Thread.sleep(4000);
					String trainingCentreSPOCName=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 16);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='spocfirstname']")).getAttribute("value"),trainingCentreSPOCName );
					String trainingCentreSPOCNMobileNum=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 18);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='spocmobile']")).getAttribute("value"), trainingCentreSPOCNMobileNum);
					String trainingCentreSPOCEmail=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 17);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='spocemail']")).getAttribute("value"), trainingCentreSPOCEmail);
					String trainingCentreAddress=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 5);
					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='addessline1']")).getAttribute("value"), trainingCentreAddress);
					String trainingCentreLandmark=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 6);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='landmark']")).getAttribute("value"), trainingCentreLandmark);
					String trainingCentrePincode=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls","SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 7); 
					Assert.assertEquals(driver.findElement(By.xpath("//input[@name='pincode']")).getAttribute("value"), trainingCentrePincode);
					
					if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("all fields"))
					{
						Assert.assertEquals(driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value"), state);
						Assert.assertEquals(driver.findElement(By.xpath("//input[@name='district']")).getAttribute("value"), district);
						Assert.assertEquals(driver.findElement(By.xpath("//input[@name='subDistrict']")).getAttribute("value"), subDistrict);
						Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'SED')]")).getText().trim(), jobrole);
						Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Apparel')]")).getText().trim(), sector);
					}
					else if(searchByEnteringMandatoryFieldsOrAll.equalsIgnoreCase("mandatory"))
					{
						Assert.assertEquals(driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value"), state);
						Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Apparel')]")).getText().trim(), sector);
					}
					aSp.clickApplyForBatch();
					Thread.sleep(2000);
					List<WebElement> ele = driver.findElements(By.xpath("//div[@id='toast-container']/div/div"));
					if(ele.size()!=0)
					{
						Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("This Candidate already applied for this Batch or he/she is a MasterAssessor"), "new batch");
						driver.navigate().back();
						Thread.sleep(4000);
					}
					else
					{
						Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().trim().endsWith(batchID), "Assessor Successfully Applied to the respected Batch ID");
						aSp.clickOK();
						Thread.sleep(2000);
						driver.navigate().back();
						Thread.sleep(2000);
					}
				}
				else if(actionDropdownMenuOption.equals("Apply to the batch"))
				{
					aSp.selectApplyToBatch();
					Thread.sleep(2000);
					List<WebElement> ele = driver.findElements(By.xpath("//div[@id='toast-container']/div/div"));
					if(ele.size()!=0)
					{
						Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("This Candidate already applied for this Batch or he/she is a MasterAssessor"), "new batch");
						Thread.sleep(4000);
					}
					else
					{
						Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().trim().endsWith(batchID), "searched and applied batch mismatch");
						Thread.sleep(2000);
						aSp.clickOK();
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

