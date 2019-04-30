package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.pages.TrainingPartner_CandidateRegistrationPage;
import com.nsdc.pages.TrainingPartner_MyCandidatesPage;
import com.nsdc.testConfig.TestConfiguration;

public class TP_Candidates_TestData extends TestConfiguration
{
	@DataProvider
	public Object[][] individualCandidateRegistrationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_CandidateTestData-Workflow.xls", "Individual_Registration");
	}
	@Test(dataProvider="individualCandidateRegistrationData")
	public void tpCandidatesRegistrationTC_01(String serialNum, String candidateID, String trainingPartnerID, String trainingPartnerPassword, String namePrefix, String fullName, String profilePicture, String mobileNumber, String emailID, String gender, String dob, String guardianRelation, String guardianName, String maritalStatus, String placeOfBirth, String cast, String religion, String isDisabled, String disablity, String disabilityProofDoc, String address, String village, String state, String district, String subDistrict, String pincode, String parlimentaryConstituency, String identificationType, String identificationIDnumber, String identificationProof, String isCommunicationAddressSameAsPermanentAddress, String cAddress, String cVillage, String cState, String cDistrict, String cSubDistrict, String cPincode, String cParlimentaryConstituency, String education1, String specialisation1, String yearOfPassing1, String education1Proof, String education2, String specialisation2, String othersEducationName, String yearOfPassing2, String education2Proof, String education3, String specialisation3, String yearOfPassing3, String education3Proof , String hearAboutUs, String sector1, String subSector1, String jobRole1, String jobRoleCode1, String sector2, String subSector2, String jobRole2, String jobRoleCode2, String sector3, String subSector3, String jobRole3, String birthState, String birthDistrict, String locationSPOC, String accountNumber, String ifsc, String bankName, String bankAddress, String boardingAndLodging) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(trainingPartnerID, trainingPartnerPassword);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		TrainingPartnerDashboardPage tDp=new TrainingPartnerDashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		tDp.clickMyCandidates();
		TrainingPartner_MyCandidatesPage tpMp=new TrainingPartner_MyCandidatesPage(driver);
		tpMp.clickRegisterCandidate();
		tpMp.clickToChooseIndividualCandidateRegistration();
		tpMp.clickRegister();
		//Personal Details Page
		TrainingPartner_CandidateRegistrationPage tpCrp=new TrainingPartner_CandidateRegistrationPage(driver);
		tpCrp.selectNamePrefix(namePrefix);
		tpCrp.enterFullName(fullName);
		tpCrp.clickToBrowseProfilePicture();
		UploadFile.upload(profilePicture);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.clickToUploadProfilePicture();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.enterMobileNumber(mobileNumber);
		tpCrp.enterEmailID(emailID);
		tpCrp.clickToChooseGender(gender);
		tpCrp.clickToSelectDOB();
		String selectedDateOfBirth=driver.findElement(By.id("dob")).getAttribute("value");
	    ReadWriteData.setExcelData("./TestData/Workflow/TP_CandidateTestData-Workflow.xls", "Individual_Registration", Integer.parseInt(serialNum), 10, selectedDateOfBirth);
	    tpCrp.selectRelationWithGuardian(guardianRelation);
		tpCrp.enterGuardianName(guardianName);
		tpCrp.selectMaritalStatus(maritalStatus);
		tpCrp.selectBirthState(birthState);
		tpCrp.selectBirthDistrict(birthDistrict);
		tpCrp.selectCast(cast);
		tpCrp.selectReligion(religion);	
		if(isDisabled.equalsIgnoreCase("yes"))
		{
			tpCrp.clickDisabilityYes();
			tpCrp.selectDisablity(disablity);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tpCrp.clickToBrowsedisabilityProofDoc();
			UploadFile.upload(disabilityProofDoc);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tpCrp.clickToUploadDisabilityProofDoc();
		}
		else if(isDisabled.equalsIgnoreCase("no"))
		{
			tpCrp.clickDisabilityNo();
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.enterAddress(address);
		tpCrp.selectState(state);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.selectDistrict(district);	
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.enterPincode(pincode);
		tpCrp.enterLocationSPOC(locationSPOC);
		tpCrp.clickSaveAndContinue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.clickSaveAndContinue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Contact Details Page
		String candidateIDUrl=driver.getCurrentUrl();
		String parts[]=candidateIDUrl.split("/");
		String registeredCandidateID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/TP_CandidateTestData-Workflow.xls", "Individual_Registration", Integer.parseInt(serialNum), 1, registeredCandidateID);
		Assert.assertTrue(driver.getCurrentUrl().contains("contact-details"),"OMG!!! navigation to Contact Details page is unsuccessfull OR something is wrong! ");
		tpCrp.selectIdentificationType(identificationType);
		tpCrp.enterIdentificationIDNumber(identificationIDnumber);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.clickToBrowseIdentificationProofDoc();
		UploadFile.upload(identificationProof);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.clickToUploadIdentificationProofDoc();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='alternateIdNumber']")).getAttribute("value").trim(), identificationIDnumber);
		tpCrp.clickSameAsPermanetAddress();
		tpCrp.enterAccountHolderName(fullName);	
		tpCrp.enterAccountNumber(accountNumber);
		tpCrp.enterIFSC(ifsc);
//		tpCrp.enterBankName(bankName);
//		tpCrp.enterBankAddress(bankAddress);
		tpCrp.selectBoardingAndLodging(boardingAndLodging);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.clickSaveAndContinue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Education
		tpCrp.selectEducation(education1);
		tpCrp.selectYearOfPassing(yearOfPassing1);
		tpCrp.clickToBrowseEducationProofDoc();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		UploadFile.upload(education1Proof);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.clickToUploadEducationProof();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Candidate Experience
		tpCrp.selectCandidateExperienceSector(sector1);
		tpCrp.selectCandidateExperienceJobRole(jobRole1, jobRoleCode1);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.clickSaveAndContinue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Course Preferences Page
		tpCrp.clickSaveAndContinue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.clickIAgree();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tpCrp.clickToAgreeAndSubmit();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(4000);
		plp.clickOnLogout();	
	}
}