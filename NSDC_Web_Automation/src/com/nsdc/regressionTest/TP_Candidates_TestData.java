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
		Thread.sleep(10000);
		TrainingPartnerDashboardPage tDp=new TrainingPartnerDashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		tDp.clickMyCandidates();
		Thread.sleep(4000);
		TrainingPartner_MyCandidatesPage tpMp=new TrainingPartner_MyCandidatesPage(driver);
		tpMp.clickRegisterCandidate();
		Thread.sleep(2000);
		tpMp.clickToChooseIndividualCandidateRegistration();
		Thread.sleep(2000);
		tpMp.clickRegister();
		Thread.sleep(4000);	
		//Personal Details Page
		TrainingPartner_CandidateRegistrationPage tpCrp=new TrainingPartner_CandidateRegistrationPage(driver);
		tpCrp.selectNamePrefix(namePrefix);
		Thread.sleep(2000);
		tpCrp.enterFullName(fullName);
		Thread.sleep(2000);
		tpCrp.clickToBrowseProfilePicture();
		Thread.sleep(4000);
		UploadFile.upload(profilePicture);
		Thread.sleep(4000);
		tpCrp.clickToUploadProfilePicture();
		Thread.sleep(8000);	
		tpCrp.enterMobileNumber(mobileNumber);
		Thread.sleep(2000);
		tpCrp.enterEmailID(emailID);
		Thread.sleep(2000);
		tpCrp.clickToChooseGender(gender);
		Thread.sleep(4000);
		tpCrp.clickToSelectDOB();
		Thread.sleep(4000);
		String selectedDateOfBirth=driver.findElement(By.id("dob")).getAttribute("value");
	    ReadWriteData.setExcelData("./TestData/Workflow/TP_CandidateTestData-Workflow.xls", "Individual_Registration", Integer.parseInt(serialNum), 10, selectedDateOfBirth);
	    tpCrp.selectRelationWithGuardian(guardianRelation);
		Thread.sleep(2000);
		tpCrp.enterGuardianName(guardianName);
		Thread.sleep(2000);
		tpCrp.selectMaritalStatus(maritalStatus);
		Thread.sleep(2000);
		tpCrp.selectBirthState(birthState);
		Thread.sleep(2000);
		tpCrp.selectBirthDistrict(birthDistrict);
//		tpCrp.enterPlaceOfBirth(placeOfBirth);
//		Thread.sleep(2000);
		tpCrp.selectCast(cast);
		Thread.sleep(4000);
		tpCrp.selectReligion(religion);	
		Thread.sleep(4000);
		if(isDisabled.equalsIgnoreCase("yes"))
		{
			tpCrp.clickDisabilityYes();
			Thread.sleep(2000);
			tpCrp.selectDisablity(disablity);
			Thread.sleep(2000);
			tpCrp.clickToBrowsedisabilityProofDoc();
			Thread.sleep(4000);
			UploadFile.upload(disabilityProofDoc);
			Thread.sleep(4000);
			tpCrp.clickToUploadDisabilityProofDoc();
			Thread.sleep(4000);
		}
		else if(isDisabled.equalsIgnoreCase("no"))
		{
			tpCrp.clickDisabilityNo();
		}
		Thread.sleep(2000);
		tpCrp.enterAddress(address);
		Thread.sleep(2000);
		tpCrp.selectState(state);
		Thread.sleep(2000);
		tpCrp.selectDistrict(district);	
		Thread.sleep(2000);
		tpCrp.enterPincode(pincode);
		Thread.sleep(2000);
		tpCrp.enterLocationSPOC(locationSPOC);
		tpCrp.clickSaveAndContinue();
		WebDriverWait wait=new WebDriverWait(driver,30);
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
		Thread.sleep(4000);
		tpCrp.enterIdentificationIDNumber(identificationIDnumber);
		Thread.sleep(6000);
		tpCrp.clickToBrowseIdentificationProofDoc();
		Thread.sleep(4000);
		UploadFile.upload(identificationProof);
		Thread.sleep(4000);
		tpCrp.clickToUploadIdentificationProofDoc();
		Thread.sleep(8000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='alternateIdNumber']")).getAttribute("value").trim(), identificationIDnumber);
		tpCrp.clickSameAsPermanetAddress();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
//		tpCrp.enterSpecialisation(specialisation1);
//		Thread.sleep(2000);
		tpCrp.selectYearOfPassing(yearOfPassing1);
		Thread.sleep(2000);
		tpCrp.clickToBrowseEducationProofDoc();
		Thread.sleep(4000);
		UploadFile.upload(education1Proof);
		Thread.sleep(4000);
		tpCrp.clickToUploadEducationProof();
		Thread.sleep(8000);
		//Candidate Experience
		tpCrp.selectCandidateExperienceSector(sector1);
		Thread.sleep(2000);
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