package com.nsdc.regressionTest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void trainerRegistrationTC_01(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
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
        WebDriverWait wait=new WebDriverWait(driver, 60);
       	wait.until(ExpectedConditions.elementToBeClickable(By.id("dob")));
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
        if(language.equals("English,Hindi,Kannada"))
        {
        	trainer.selectAllLanguages();
        }
        else if(language.equals("Hindi,Kannada"))
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
           	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
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
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        }
        Thread.sleep(2000);
        trainer.clickOnBrowseFileButtonToUploadPhoto();
        Thread.sleep(4000);
        UploadFile.upload(photoFile);
        Thread.sleep(5000);
        trainer.clickOnUploadButtonToUploadPhoto();
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
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
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in Personal Information Section, Its Blocking further Applicant Registration Process!!!");
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
    	if(!city.isEmpty())
        {
    		 trainer.selectDistrictOrCity(city);
             Thread.sleep(2000);
        }
        if(!mandal.isEmpty())
        {
        	 trainer.selectTehsilOrMandal(mandal);
             Thread.sleep(2000);
        }
        if(!parliamentaryConstituency.isEmpty())
        {
        	trainer.selectParliamentaryConstituency(parliamentaryConstituency);
         	Thread.sleep(2000);
        }
        trainer.clickOnSaveAndContinue();
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in Contact & Address Details Section, Its Blocking further Applicant Registration Process!!!");
    	Thread.sleep(8000);
    	trainer.selectEducationAttained(education1);
        Thread.sleep(2000);
        trainer.enterDetailsOfEducation(edu_details1);
        Thread.sleep(2000);
        trainer.clickOnBrowseForUploadEducationProofDocument();
        Thread.sleep(2000);
        UploadFile.upload(edu_document1);
        Thread.sleep(4000);
        trainer.clickOnUploadForUploadEducationProofDocument();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
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
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
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
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        trainer.clickOnAddEducationDetailsButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education3+"')]")).getText(), education3);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details3+"')]")).getText(), edu_details3);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'yes')])[3]")).getText(), "yes");
        trainer.deleteThirdEducationDetails();
        Thread.sleep(2000);
        trainer.selectRelevantSectorForIndustrialExperience(industrial_sector1);
        trainer.selectYearsForIndustrialExperience(industrial_years1);
        trainer.selectMonthsForIndustrialExperience(industrial_months1);
        trainer.enterDetailsOfIndustrialExperience(industrialExperienceDetails1);
        Thread.sleep(2000);
        trainer.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails1);
        Thread.sleep(2000);
        trainer.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(industrialDocument1);
        Thread.sleep(6000);
        trainer.clickOnUploadForIndustrialExperienceProofDocument();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        trainer.clickOnAddIndustrialExperienceDetails();
    	Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[2]")).getText(), industrial_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[3]")).getText(), industrialExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[4]")).getText(), industriesDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[5]")).getText(), industrial_years1+" years "+industrial_months1+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[6]")).getText(), "Yes");
        trainer.selectRelevantSectorForIndustrialExperience(industrial_sector2);
        trainer.selectYearsForIndustrialExperience(industrial_years2);
        trainer.selectMonthsForIndustrialExperience(industrial_months2);
        trainer.enterDetailsOfIndustrialExperience(industrialExperienceDetails2);
        Thread.sleep(2000);
        trainer.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails2);
        Thread.sleep(2000);
        trainer.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(industrialDocument2);
        Thread.sleep(4000);
        trainer.clickOnUploadForIndustrialExperienceProofDocument();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        trainer.clickOnAddIndustrialExperienceDetails();
    	Thread.sleep(5000);
    	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[2]")).getText(), industrial_sector2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[3]")).getText(), industrialExperienceDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[4]")).getText(), industriesDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[5]")).getText(), industrial_years2+" years "+industrial_months2+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[6]")).getText(), "Yes");
        trainer.selectRelevantSectorForIndustrialExperience(industrial_sector3);
        trainer.selectYearsForIndustrialExperience(industrial_years3);
        trainer.selectMonthsForIndustrialExperience(industrial_months3);
        trainer.enterDetailsOfIndustrialExperience(industrialExperienceDetails3);
        Thread.sleep(2000);
        trainer.enterDetailsOfIndustriesForIndustrialExperienceTextBox(industriesDetails3);
        Thread.sleep(2000);
        trainer.clickOnBrowseForIndustrialExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(industrialDocument3);
        Thread.sleep(5000);
        trainer.clickOnUploadForIndustrialExperienceProofDocument();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        trainer.clickOnAddIndustrialExperienceDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[2]")).getText(), industrial_sector3);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[3]")).getText(), industrialExperienceDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[4]")).getText(), industriesDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[5]")).getText(), industrial_years3+" years "+industrial_months3+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[6]")).getText(), "Yes");
        Thread.sleep(2000);
        trainer.deleteThirdIndustrialExperienceDetails();
        Assert.assertTrue(driver.findElements(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]")).size()==0,"OMG!!! Deleted Third Industrial Experience details record present ");
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
       	trainer.selectyearsForTrainingExperience(trainingExperienceYears1);
       	trainer.selectMonthsForTrainingExperience(trainingExperienceMonths1);
       	trainer.enterTrainingExperienceDetails(trainingExperienceDetails1);
        Thread.sleep(2000);
       	trainer.clickOnBrowseForTrainingExperienceProofDocument();
       	Thread.sleep(4000);
       	UploadFile.upload(trainingDocument1);
       	Thread.sleep(5000);
       	trainer.clickOnUploadForTrainingExperienceProofDocument();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        trainer.clickOnAddTrainingExperienceDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]//td[2]")).getText(), training_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]//td[3]")).getText(), trainingExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]//td[4]")).getText(), trainingExperienceYears1+" years "+trainingExperienceMonths1+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]//td[5]")).getText(), "Yes");
        trainer.selectRelevantSectorForTrainingExperience(training_sector2);
       	trainer.selectyearsForTrainingExperience(trainingExperienceYears2);
       	trainer.selectMonthsForTrainingExperience(trainingExperienceMonths2);
       	trainer.enterTrainingExperienceDetails(trainingExperienceDetails2);
        Thread.sleep(2000);
       	trainer.clickOnBrowseForTrainingExperienceProofDocument();
        Thread.sleep(4000);
        UploadFile.upload(trainingDocument2);
        Thread.sleep(5000);
        trainer.clickOnUploadForTrainingExperienceProofDocument();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        trainer.clickOnAddTrainingExperienceDetails();
     	Thread.sleep(2000);
     	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector2+"')]])[2]//td[2]")).getText(), training_sector2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector2+"')]])[2]//td[3]")).getText(), trainingExperienceDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector2+"')]])[2]//td[4]")).getText(), trainingExperienceYears2+" years "+trainingExperienceMonths2+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector2+"')]])[2]//td[5]")).getText(), "Yes");
       	trainer.selectRelevantSectorForTrainingExperience(training_sector3);
        trainer.selectyearsForTrainingExperience(trainingExperienceYears3);
       	trainer.selectMonthsForTrainingExperience(trainingExperienceMonths3);
       	trainer.enterTrainingExperienceDetails(trainingExperienceDetails3);
        Thread.sleep(2000);
       	trainer.clickOnBrowseForTrainingExperienceProofDocument();
       	Thread.sleep(4000);
       	UploadFile.upload(trainingDocument3);
       	Thread.sleep(5000);
       	trainer.clickOnUploadForTrainingExperienceProofDocument();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
       	trainer.clickOnAddTrainingExperienceDetails();
     	Thread.sleep(2000);
     	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector3+"')]])[1]//td[2]")).getText(), training_sector3);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector3+"')]])[1]//td[3]")).getText(), trainingExperienceDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector3+"')]])[1]//td[4]")).getText(), trainingExperienceYears3+" years "+trainingExperienceMonths3+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector3+"')]])[1]//td[5]")).getText(), "Yes");
       	trainer.deleteThirdTrainingExperienceDetails();
        Assert.assertTrue(driver.findElements(By.xpath("(//tr[td[contains(text(),'"+training_sector3+"')]])[1]")).size()==0,"OMG!!! Deleted Third Training Experience details record present ");
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
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        trainer.clickOnSaveAndContinue();
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in Education & Work Details Section, Its Blocking further Applicant Registration Process!!!");
        //Preference 1
        trainer.selectPreferredSector(preferredSector1);
        Thread.sleep(4000);
        trainer.selectPreferredSubSector(preferredSubSector1);
        Thread.sleep(4000);
        trainer.selectPreferredJobRole(preferredJobRole1);
        Thread.sleep(4000);
        trainer.selectPreferredState(preferredState1);
        Thread.sleep(4000);
        if(!preferredDistrict1.equalsIgnoreCase("N/A"))
        {
        	trainer.selectPreferredDistrict(preferredDistrict1);
            Thread.sleep(4000);
        }
        if(!preferredSubDistrict1.equalsIgnoreCase("N/A"))
        {
        	trainer.selectPreferredSubDistrict(preferredSubDistrict1);
            Thread.sleep(4000);
        }
        trainer.clickAddPreferences();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[1]")).getText().trim(), preferredJobRole1+" ("+preferredJobRoleCode1+")");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[2]")).getText().trim(), preferredSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[4]")).getText().trim(), preferredState1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[5]")).getText().trim(), preferredDistrict1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[6]")).getText().trim(), preferredSubDistrict1);
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
        if(!preferredDistrict2.equalsIgnoreCase("N/A"))
        {
        	trainer.selectPreferredDistrict(preferredDistrict2);
            Thread.sleep(4000);
        }
        if(!preferredSubDistrict2.equalsIgnoreCase("N/A"))
        {
        	trainer.selectPreferredSubDistrict(preferredSubDistrict2);
            Thread.sleep(4000);
        }
        trainer.clickAddPreferences();
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[1]")).getText().trim(), preferredJobRole2+" ("+preferredJobRoleCode2+")");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[2]")).getText().trim(), preferredSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[3]")).getText().trim(), preferredSubSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[4]")).getText().trim(), preferredState2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[5]")).getText().trim(), preferredDistrict2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[6]")).getText().trim(), preferredSubDistrict2);
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
        if(!preferredDistrict3.equalsIgnoreCase("N/A"))
        {
        	trainer.selectPreferredDistrict(preferredDistrict3);
            Thread.sleep(4000);
        }
        if(!preferredSubDistrict3.equalsIgnoreCase("N/A"))
        {
        	trainer.selectPreferredSubDistrict(preferredSubDistrict3);
            Thread.sleep(4000);
        }
        trainer.clickAddPreferences();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[1]")).getText().trim(), preferredJobRole3+" ("+preferredJobRoleCode3+")");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[2]")).getText().trim(), preferredSector3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[3]")).getText().trim(), preferredSubSector3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[4]")).getText().trim(), preferredState3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[5]")).getText().trim(), preferredDistrict3);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState3+"')]]/td[6]")).getText().trim(), preferredSubDistrict3);
        //deleting 3rd preference
        Thread.sleep(4000);
        trainer.clickToDeleteThirdPreference();
        Thread.sleep(4000);
//      Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+preferredJobRole3+"')]")).size()==0,"OMG!!! deleted third preference still present OR Something is wrong! ");
        trainer.clickOnSaveAndContinue();
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast toast-error']")).size()==0,"OMG!!! Toast Error Message Present in My Preferences & My Associations Section, Its Blocking further Applicant Registration Process!!!");
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
    public void trainerMyProfileVerificationTC_02(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
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
     	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[1]")).getText().trim(), preferredJobRole1+", "+preferredJobRoleCode1);
      	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[2]")).getText().trim(), preferredSector1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[4]")).getText().trim(), preferredState1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[5]")).getText().trim(), preferredDistrict1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[6]")).getText().trim(), preferredSubDistrict1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[1]")).getText().trim(), preferredJobRole2+", "+preferredJobRoleCode2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[2]")).getText().trim(), preferredSector2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[3]")).getText().trim(), preferredSubSector2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[4]")).getText().trim(), preferredState2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[5]")).getText().trim(), preferredDistrict2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[6]")).getText().trim(), preferredSubDistrict2);
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
    	Select selectedReligion=new Select(driver.findElement(By.xpath("//select[@formcontrolname='religion']")));
      	Assert.assertEquals(selectedReligion.getFirstSelectedOption().getText().trim(), religion);
       	Assert.assertEquals(tMpP.getCategory(), category);
       	Select selectedDisability=new Select(driver.findElement(By.xpath("//select[@formcontrolname='type']")));
       	Assert.assertEquals(selectedDisability.getFirstSelectedOption().getText().trim(), disability);
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
       	tMpP.clickToBrowsePhotoFile();
    	Thread.sleep(2000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(4000);
    	tMpP.clickToUploadPhotoFile();
    	WebDriverWait wait=new WebDriverWait(driver, 60);
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
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
       	Thread.sleep(2000);
       	tMpP.clickSaveChanges1();
       	Thread.sleep(4000);
       	tMpP.clickOK();
       	Thread.sleep(4000);
       	//Trainer Contact and Address verification
       	JavascriptExecutor js=(JavascriptExecutor)driver;
       	js.executeScript("window.scrollBy(0,-1500)","");
       	Thread.sleep(2000);
       	tMpP.clickContactAndAddress();
       	Thread.sleep(4000);
    	Assert.assertFalse(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant:')]]/div/input")).isEnabled(),"OMG!!! Edit Profile - Mobile Number field should not be editable!");
       	Assert.assertEquals(tMpP.getMobileNumOfApplicant(), mobile);
    	Assert.assertFalse(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant:')]]/div/input")).isEnabled(),"OMG!!! Edit Profile - Email field should not be editable!");
       	Assert.assertEquals(tMpP.getEmailOfApplicant(), email);
       	Assert.assertEquals(tMpP.getAddressOfApplicant(), address);
       	Assert.assertEquals(tMpP.getNearByLandMark(), landmark);
       	Assert.assertEquals(tMpP.getPincode(), pincode);
       	Select selectedState=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='state'])[1]")));
       	Assert.assertEquals(selectedState.getFirstSelectedOption().getText().trim(), state);
       	Select selectedDistrict=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='district'])[1]")));
       	Assert.assertEquals(selectedDistrict.getFirstSelectedOption().getText().trim(), city);
       	Select selectedSubDistrict=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='mandal'])[1]")));
       	Assert.assertEquals(selectedSubDistrict.getFirstSelectedOption().getText().trim(), mandal);
       	Select selectedParlimentaryConstituency=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='parliamentConstituency'])[1]")));
       	Assert.assertEquals(selectedParlimentaryConstituency.getFirstSelectedOption().getText().trim(), parliamentaryConstituency);
     	tMpP.clickSaveChanges2();
       	Thread.sleep(4000);
       	tMpP.clickOK();
       	Thread.sleep(4000);
       	js.executeScript("window.scrollBy(0,-1500)","");
       	Thread.sleep(2000);
       	//Education & Work verification
       	Thread.sleep(2000);
       	tMpP.clickEducationAndWork();
       	Thread.sleep(2000);
       	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+education1+"']")).getText().trim(), education1);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+education1+"']]/td[4]")).getText().trim(), "Yes");
    	//Education Record 2
    	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+education2+"']")).getText().trim(), education2);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+education2+"']]/td[4]")).getText().trim(), "Yes");
    	//Adding Education Record
//    	tMpP.clickToAddEducationDetails();
    	Thread.sleep(2000);
    	tMpP.selectEducationAttained(education3);
    	Thread.sleep(2000);
    	Assert.assertFalse(driver.findElements(By.xpath("//label[contains(text(),'Details of Education:')]")).size()==0, "OMG!!! Education Details Fields should be displayed in case of Other Education Attained Type!! ");
    	tMpP.enterDetailsOfEducation(edu_details3);
    	Thread.sleep(2000);
    	tMpP.clickToBrowseForEducationProofDocument();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(5000);
    	tMpP.clickToUploadSelectedEducationProofDoc();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
    	tMpP.clickToSubmitEducationDetails();
    	Thread.sleep(2000);
    	Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+education3+"')]")).size()!=0,"OMG!!! No show of Added Educational Record for Profile of "+createdTrainerID+" !!! ");
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+education3+"')]")).getText().trim(), education3);
    	Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+edu_details3+"')]")).getText().trim(), edu_details3);
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+education3+"']]/td[4]")).getText().trim(), "Yes");
    	//Industrial Records
     	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[2]")).getText(), industrial_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[3]")).getText(), industrialExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[4]")).getText(), industriesDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[5]")).getText(), industrial_years1+" Year "+industrial_months1+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector1+"')]])[1]//td[6]")).getText(), "Yes");
      	//industrial record 2
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[2]")).getText(), industrial_sector2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[3]")).getText(), industrialExperienceDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[4]")).getText(), industriesDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[5]")).getText(), industrial_years2+" Year "+industrial_months2+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector2+"')]])[1]//td[6]")).getText(), "Yes");
       	//Adding 3rd industrial record
//    	tMpP.clickToAddIndustrialExperienceDetails();
    	Thread.sleep(2000);
    	tMpP.selectIndustrialSector(industrial_sector3);
    	Thread.sleep(2000);
    	tMpP.selectIndustrialYears(industrial_years3);
    	Thread.sleep(2000);
    	tMpP.selectIndustrialMonths(industrial_months3);
    	Thread.sleep(2000);
    	tMpP.enterDetailsOfIndustrialExperience(industrialExperienceDetails3);
    	Thread.sleep(2000);
    	tMpP.clickToBrowseForIndustrilExperienceProofDocument();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(5000);
    	tMpP.clickToUploadSelectedIndustrialExperienceProofDoc();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
    	tMpP.clickToSubmitIndustrialExperienceDetails();
    	Thread.sleep(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[2]")).getText(), industrial_sector3);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[3]")).getText(), industrialExperienceDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[4]")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[5]")).getText(), industrial_years3+" Year "+industrial_months3+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+industrial_sector3+"')]])[1]//td[6]")).getText(), "Yes");
    	//Training Records
       	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]//td[2]")).getText(), training_sector1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]//td[3]")).getText(), trainingExperienceDetails1);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]//td[4]")).getText(), trainingExperienceYears1+" Year "+trainingExperienceMonths1+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector1+"')]])[2]//td[5]")).getText(), "Yes");
    	//training record 2
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector2+"')]])[2]//td[2]")).getText(), training_sector2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector2+"')]])[2]//td[3]")).getText(), trainingExperienceDetails2);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector2+"')]])[2]//td[4]")).getText(), trainingExperienceYears2+" Year "+trainingExperienceMonths2+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector2+"')]])[2]//td[5]")).getText(), "Yes");
    	//Adding 3rd Training Experience Details Record 
//    	tMpP.clickToAddTrainingExperienceDetails();
    	Thread.sleep(2000);
    	tMpP.selectTrainingSector(training_sector3);
    	Thread.sleep(2000);
    	tMpP.selectTrainingYears(trainingExperienceYears3);
    	Thread.sleep(2000);
    	tMpP.selectTrainingMonths(trainingExperienceMonths3);
    	Thread.sleep(2000);
    	tMpP.enterDetailsOfTrainingExperience(trainingExperienceDetails3);
    	Thread.sleep(2000);
    	tMpP.clickToBrowseForTrainingExperienceProofDocument();
    	Thread.sleep(4000);
    	UploadFile.upload(photoFile);
    	Thread.sleep(5000);
    	tMpP.clickToUploadSelectedTrainingExperienceProofDoc();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
    	tMpP.clickToSubmitTrainingExperienceDetails();
    	Thread.sleep(4000);
    	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector3+"')]])[2]//td[2]")).getText(), training_sector3);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector3+"')]])[2]//td[3]")).getText(), trainingExperienceDetails3);
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector3+"')]])[2]//td[4]")).getText(), trainingExperienceYears3+" Year "+trainingExperienceMonths3+" months");
        Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+training_sector3+"')]])[2]//td[5]")).getText(), "Yes");
       	tMpP.clickCurriculumVitaeBrowse();
       	Thread.sleep(2000);
       	UploadFile.upload(photoFile);
       	Thread.sleep(4000);
       	tMpP.clickCurriculumVitaeUpload();
       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
       	tMpP.clickSaveChanges3();
    	Thread.sleep(4000);
    	tMpP.clickOK();
    	Thread.sleep(4000);
       	js.executeScript("window.scrollBy(0,-3000)","");
       	Thread.sleep(5000);
       	tMpP.clickTrainingRequests();
       	Thread.sleep(2000);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[1]")).getText().trim(), preferredJobRole1+" ("+preferredJobRoleCode1+")");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[2]")).getText().trim(), preferredSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[4]")).getText().trim(), preferredState1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[5]")).getText().trim(), preferredDistrict1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState1+"')]]/td[6]")).getText().trim(), preferredSubDistrict1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[1]")).getText().trim(), preferredJobRole2+" ("+preferredJobRoleCode2+")");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[2]")).getText().trim(), preferredSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[3]")).getText().trim(), preferredSubSector2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[4]")).getText().trim(), preferredState2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[5]")).getText().trim(), preferredDistrict2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredState2+"')]]/td[6]")).getText().trim(), preferredSubDistrict2);
       	tMpP.clickSaveChanges4();
       	Thread.sleep(4000);
       	tMpP.clickOK();
    	Thread.sleep(10000);
    	//Verifying updated data
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
      	//Education
      	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[1]")).getText().contains(education1));
        Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[3]")).getText().trim(), edu_details1);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[4]")).getText().contains(edu_document1));
        Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[5]")).getText().contains(education2));
        Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[7]")).getText().trim(), edu_details2);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[8]")).getText().contains(edu_document2));
        Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[9]")).getText().contains(education3));
        Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[11]")).getText().trim(), edu_details3);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Education Details')]]]]//span)[12]")).getText().contains(edu_document3));
        //Industrial Experience
      	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[1]")).getText().contains(industrial_sector1));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[3]")).getText().trim(), industrialExperienceDetails1);
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[4]")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[6]")).getText().contains(industrial_sector2));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[8]")).getText().trim(), industrialExperienceDetails2);
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[9]")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[11]")).getText().contains(industrial_sector3));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[13]")).getText().trim(), industrialExperienceDetails3);
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Industrial Experience Details')]]]]//span)[14]")).getText().trim(), industrial_years3+" years "+industrial_months3+" months");
       	//Training Experience
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[1]")).getText().contains(training_sector1));
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[3]")).getText().contains(trainingExperienceDetails1));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[4]")).getText().trim(), trainingExperienceYears1+" years "+trainingExperienceMonths1+" months");
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[6]")).getText().contains(training_sector2));
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[8]")).getText().contains(trainingExperienceDetails2));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[9]")).getText().trim(), trainingExperienceYears2+" years "+trainingExperienceMonths2+" months");
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[11]")).getText().contains(training_sector3));
       	Assert.assertTrue(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[13]")).getText().contains(trainingExperienceDetails3));
       	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h5[contains(text(),'Added Training Experience Details')]]]]//span)[14]")).getText().trim(), trainingExperienceYears3+" years "+trainingExperienceMonths3+" months");
       	//Training Requests/My Preferences
     	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[1]")).getText().trim(), preferredJobRole1+", "+preferredJobRoleCode1);
      	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[2]")).getText().trim(), preferredSector1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[3]")).getText().trim(), preferredSubSector1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[4]")).getText().trim(), preferredState1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[5]")).getText().trim(), preferredDistrict1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole1+"')]]/td[6]")).getText().trim(), preferredSubDistrict1);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[1]")).getText().trim(), preferredJobRole2+", "+preferredJobRoleCode2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[2]")).getText().trim(), preferredSector2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[3]")).getText().trim(), preferredSubSector2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[4]")).getText().trim(), preferredState2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[5]")).getText().trim(), preferredDistrict2);
       	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredJobRole2+"')]]/td[6]")).getText().trim(), preferredSubDistrict2);
       	Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[h5[contains(text(),'Applicant Type')]]]]/div[4]")).getText().trim(), userType);
       	PostLoginPage plp=new PostLoginPage(driver);
       	plp.clickOnProfileLogo();
       	Thread.sleep(2000);
       	plp.clickOnLogout();
       	Thread.sleep(2000);
    }
    
    @Test(dataProvider="registrationData", dependsOnMethods="trainerRegistrationTC_01")
 	public void addMyPreferencesTC_03(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
 	{
 	   LoginPage lp=new LoginPage(driver);
 	   EnterLoginPage elp=new EnterLoginPage(driver);
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
	   if(serialNum.equals("1"))
	   {
		   tSp.selectState(preferredState3);
		   Thread.sleep(2000);
		   if(!preferredDistrict3.equalsIgnoreCase("N/A"))
		   {
			   tSp.selectDistrict(preferredDistrict3);
		 	   Thread.sleep(2000);
		   }
		   if(!preferredSubDistrict3.equalsIgnoreCase("N/A"))
		   {
			   tSp.selectSubDistrict(preferredSubDistrict3);
		 	   Thread.sleep(2000);
		   }
	 	   tSp.selectSector(preferredSector3);
	 	   Thread.sleep(2000);
	 	   tSp.selectSubSector(preferredSubSector3);
	 	   Thread.sleep(2000);
	 	   tSp.selectjobRole(preferredJobRole3);
	 	   Thread.sleep(6000);
	 	   //Add My Search Preferences
	 	   tSp.clickAddJobRoleAndLocationToMyPreference();
	 	   Thread.sleep(4000);
	 	   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Training Request Submitted Successfully");
	 	   tSp.clickOK();
	 	   Thread.sleep(2000);
	 	   js.executeScript("window.scrollBy(0,-200)", "");
	 	   Thread.sleep(2000);
	 	   tSp.clickMyPreferences();
	 	   Thread.sleep(4000);
	 	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]")).size()==1);
	 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[1]")).getText().trim(), preferredJobRole3);
	 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[2]")).getText().trim(), preferredSector3);
	 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[3]")).getText().trim(), preferredSubSector3);
	 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[4]")).getText().trim(), preferredState3);
	 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[5]")).getText().trim(), preferredDistrict3);
	 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[6]")).getText().trim(), preferredSubDistrict3);
	   }
	   else
	   {
		  tSp.clickMyPreferences(); 
		  Thread.sleep(5000);
		  tSp.clickAddTrainingRequests();
		  Thread.sleep(5000);
		  tSp.selectAddTrainingRequestsSector(preferredSector3);
		  Thread.sleep(2000);
		  tSp.selectAddTrainingRequestsSubSector(preferredSubSector3);
		  Thread.sleep(2000);
		  tSp.selectAddTrainingRequestsJobRole(preferredJobRole3);
		  Thread.sleep(2000);
		  tSp.selectAddTrainingRequestsState(preferredState3);
		  Thread.sleep(2000);
		  if(!preferredDistrict3.equalsIgnoreCase("N/A"))
		  {
			  tSp.selectAddTrainingRequestsDistrict(preferredDistrict3);
			  Thread.sleep(2000);
		  }
		  if(!preferredSubDistrict3.equalsIgnoreCase("N/A"))
		  {
			  tSp.selectAddTrainingRequestsSubDistrict(preferredSubDistrict3);
			  Thread.sleep(2000);
		  }
		  tSp.clickToAddTrainingRequest();
		  Thread.sleep(5000);
		  Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Training Request Submitted Successfully");
		  tSp.clickOK();
		  Thread.sleep(2000);
		  tSp.clickMyPreferences();
		  Thread.sleep(2000);
		  Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]")).size()==1);
	 	  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[1]")).getText().trim(), preferredJobRole3);
	 	  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[2]")).getText().trim(), preferredSector3);
	 	  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[3]")).getText().trim(), preferredSubSector3);
	 	  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[4]")).getText().trim(), preferredState3);
	 	  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[5]")).getText().trim(), preferredDistrict3);
	 	  Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector3+"')]]/td[6]")).getText().trim(), preferredSubDistrict3);
	   }
	   PostLoginPage plp=new PostLoginPage(driver);
 	   plp.clickOnProfileLogo();
 	   Thread.sleep(2000);
 	   plp.clickOnLogout();
 	   Thread.sleep(2000);
 	}
    
    @Test(dataProvider="registrationData", dependsOnMethods="trainerRegistrationTC_01")
    public void removeTrainingRequestTC_04(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3) throws Exception
    {
    	LoginPage lp=new LoginPage(driver);
    	EnterLoginPage elp=new EnterLoginPage(driver);
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
 	   	tSp.clickMyPreferences(); 
 	   	Thread.sleep(5000);
 	   	tSp.clickToGetMyPreferenceActionMenu(preferredSector1);
 	   	tSp.selectRemovePreference(preferredSector1);
 	   	tSp.clickToFinallyRemoveTrainingRequest();
 	 	Thread.sleep(5000);
 	   	Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Preferences deleted successfully");
 	   	tSp.clickOK();
 	   	Thread.sleep(5000);
 	   	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+preferredSector1+"')]]")).size()==0,"OMG!!! Deleted Training Request of Sector "+preferredSector1+" Still Present");
 	   	PostLoginPage plp=new PostLoginPage(driver);
 	   	plp.clickOnProfileLogo();
 	   	Thread.sleep(2000);
 	   	plp.clickOnLogout();
 	   	Thread.sleep(2000);
    }
}