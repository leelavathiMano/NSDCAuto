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
import com.nsdc.pages.TC_CandidateRegistrationPage;
import com.nsdc.pages.TC_MyCandidatesPage;
import com.nsdc.testConfig.TestConfiguration;

public class TC_Candidates_TestData extends TestConfiguration
{
	@DataProvider 
	public Object[][] individualCandidateRegistrationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TC_CandidateTestData-Workflow.xls", "Individual_Registration");
	}
	@Test(dataProvider="individualCandidateRegistrationData")
	public void tcCandidatesRegistrationTC_01(String serialNum, String candidateID, String tcID, String tcPassword, String namePrefix, String fullName, String profilePicture, String mobileNumber, String emailID, String gender, String dob, String guardianRelation, String guardianName, String maritalStatus, String placeOfBirth, String cast, String religion, String isDisabled, String disablity, String disabilityProofDoc, String address, String village, String state, String district, String subDistrict, String pincode, String parlimentaryConstituency, String identificationType, String identificationIDnumber, String identificationProof, String isCommunicationAddressSameAsPermanentAddress, String cAddress, String cVillage, String cState, String cDistrict, String cSubDistrict, String cPincode, String cParlimentaryConstituency, String education1, String specialisation1, String yearOfPassing1, String education1Proof, String education2, String specialisation2, String othersEducationName, String yearOfPassing2, String education2Proof, String education3, String specialisation3, String yearOfPassing3, String education3Proof , String hearAboutUs, String sector1, String subSector1, String jobRole1, String jobRoleCode1, String sector2, String subSector2, String jobRole2, String jobRoleCode2, String sector3, String subSector3, String jobRole3, String birthState, String birthDistrict, String locationSPOC, String accountNumber, String ifsc, String bankName, String bankAddress, String boardingAndLodging) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		TC_CandidateRegistrationPage tcCrp=new TC_CandidateRegistrationPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		tcCrp.clickMyCandidates();
		Thread.sleep(4000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		TC_MyCandidatesPage tcMp=new TC_MyCandidatesPage(driver);
		tcMp.clickRegisterCandidate();
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcMp.clickToChooseIndividualCandidateRegistration();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Thread.sleep(4000);
		tcMp.clickRegister();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Personal Details Page
		tcCrp.selectNamePrefix(namePrefix);
		tcCrp.enterFullName(fullName);
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.clickToBrowseProfilePicture();
		Thread.sleep(2000);
		UploadFile.upload(profilePicture);
		Thread.sleep(4000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.clickToUploadProfilePicture();
		Thread.sleep(4000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.enterMobileNumber(mobileNumber);
		tcCrp.enterEmailID(emailID);
		tcCrp.clickToChooseGender(gender);
		tcCrp.clickToSelectDOB();
		String selectedDateOfBirth=driver.findElement(By.id("dob")).getAttribute("value");
	    ReadWriteData.setExcelData("./TestData/Workflow/TC_CandidateTestData-Workflow.xls", "Individual_Registration", Integer.parseInt(serialNum), 10, selectedDateOfBirth);
	    tcCrp.selectRelationWithGuardian(guardianRelation);
		tcCrp.enterGuardianName(guardianName);
		tcCrp.selectMaritalStatus(maritalStatus);
		tcCrp.selectBirthState(birthState);
		tcCrp.selectBirthDistrict(birthDistrict);
		tcCrp.selectCast(cast);
		tcCrp.selectReligion(religion);	
		if(isDisabled.equalsIgnoreCase("yes"))
		{
			tcCrp.clickDisabilityYes();
			Thread.sleep(2000);
			tcCrp.selectDisablity(disablity);
			Thread.sleep(2000);
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tcCrp.clickToBrowsedisabilityProofDoc();
			Thread.sleep(2000);
			UploadFile.upload(disabilityProofDoc);
			Thread.sleep(4000);
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tcCrp.clickToUploadDisabilityProofDoc();
		}
		else if(isDisabled.equalsIgnoreCase("no"))
		{
			tcCrp.clickDisabilityNo();
		}
		Thread.sleep(4000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.enterAddress(address);
		tcCrp.selectState(state);
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.selectDistrict(district);	
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.enterPincode(pincode);
//		tcCrp.enterLocationSPOC(locationSPOC);
		tcCrp.clickSaveAndContinue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
//		tcCrp.clickSaveAndContinue();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Contact Details Page
		String candidateIDUrl=driver.getCurrentUrl();
		String parts[]=candidateIDUrl.split("/");
		String registeredCandidateID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CandidateTestData-Workflow.xls", "Individual_Registration", Integer.parseInt(serialNum), 1, registeredCandidateID);
		tcCrp.selectIdentificationType(identificationType);
		tcCrp.enterIdentificationIDNumber(identificationIDnumber);
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.clickToBrowseIdentificationProofDoc();
		Thread.sleep(2000);
		UploadFile.upload(identificationProof);
		Thread.sleep(4000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.clickToUploadIdentificationProofDoc();
		Thread.sleep(4000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='alternateIdNumber']")).getAttribute("value").trim(), identificationIDnumber);
		tcCrp.clickSameAsPermanetAddress();
		tcCrp.enterAccountHolderName(fullName);	
		tcCrp.enterAccountNumber(accountNumber);
		tcCrp.enterIFSC(ifsc);
//		tpCrp.enterBankName(bankName);
//		tpCrp.enterBankAddress(bankAddress);
		tcCrp.selectBoardingAndLodging(boardingAndLodging);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.clickSaveAndContinue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Education
		tcCrp.selectEducation(education1);
		tcCrp.selectYearOfPassing(yearOfPassing1);
		tcCrp.clickToBrowseEducationProofDoc();
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		UploadFile.upload(education1Proof);
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.clickToUploadEducationProof();
		Thread.sleep(4000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Candidate Experience
		tcCrp.selectCandidateExperienceSector(sector1);
		tcCrp.selectCandidateExperienceJobRole(jobRole1, jobRoleCode1);
		Thread.sleep(5000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.clickSaveAndContinue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Course Preferences Page
		tcCrp.clickSaveAndContinue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.clickIAgree();
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tcCrp.clickToAgreeAndSubmit();
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(4000);
		plp.clickOnLogout();	
	}
}