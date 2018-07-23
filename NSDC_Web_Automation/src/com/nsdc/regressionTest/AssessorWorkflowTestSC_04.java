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
        rp.enterMobile(mobile);
        rp.clickIagree();
        rp.clickRegister();
        Thread.sleep(2000);
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(mobileOTP);
        Thread.sleep(2000);
        rp.clickVerify();
        Thread.sleep(2000);
        String createdAssessor=driver.findElement(By.xpath("//div[@class='m-login__signin']/h3/span")).getText();
        ReadWriteData.setExcelData("./TestData/Workflow/assessor-Workflow.xls", "AssessorRegistrationSC04TC01", Integer.parseInt(serialNum), 1, createdAssessor);
        
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
            Thread.sleep(2000);
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
    		Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m--font-info'])[1]")).getText(),":"+finalIndustrialYears+" Years Total Industrial Experience");
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
        int totalTrainingMonths=((Integer.parseInt(trainingExperienceYears1)+Integer.parseInt(trainingExperienceYears2))*12)+Integer.parseInt(trainingExperienceMonths1)+Integer.parseInt(trainingExperienceMonths2);
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
    
}

