package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public void tpCandidatesRegistrationTC_01(String serialNum, String candidateID, String trainingPartnerID, String trainingPartnerPassword, String namePrefix, String fullName, String profilePicture, String countryCode, String mobileNumber, String emailID, String gender, String dob, String maritalStatus, String placeOfBirth, String birthState, String birthDistrict, String cast, String religion, String isDisabled, String disablity, String disabilityProofDoc, String motherName, String fatherName, String guardianName, String aadhaarOrAlterternateId, String aadhaarNumber, String alternateIdType, String alternateID, String alternateIdFile, String address, String village, String state, String district, String subDistrict, String pincode, String parlimentaryConstituency, String isCommunicationAddressSameAsPermanentAddress, String cAddress, String cVillage, String cState, String cDistrict, String cSubDistrict, String cPincode, String cParlimentaryConstituency, String education1, String specialisation1, String yearOfPassing1, String education1Proof, String education2, String specialisation2, String othersEducationName, String yearOfPassing2, String education2Proof, String preTrainingStatus, String experienceInMonths, String hearAboutUs, String sector1, String subSector1, String jobRole1, String jobRoleCode1, String sector2, String subSector2, String jobRole2, String jobRoleCode2, String locationSPOC, String accountNumber, String ifsc, String bankName, String bankAddress, String boardingAndLodging) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(trainingPartnerID, trainingPartnerPassword);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		TrainingPartnerDashboardPage tDp=new TrainingPartnerDashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		tDp.clickOnRegisterCandidate();
		tDp.clickOnRegisterCandidate();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Thread.sleep(4000);
		TrainingPartner_MyCandidatesPage tpMp=new TrainingPartner_MyCandidatesPage(driver);
		tpMp.clickToChooseIndividualCandidateRegistration();
		tpMp.clickRegister();
		Thread.sleep(5000);
		//Personal Details Page
		TrainingPartner_CandidateRegistrationPage tpCrp=new TrainingPartner_CandidateRegistrationPage(driver);
		tpCrp.selectNamePrefix(namePrefix);
		tpCrp.enterFullName(fullName);
//		tpCrp.clickToBrowseProfilePicture();
//		UploadFile.upload(profilePicture);
//		Thread.sleep(2000);
//		tpCrp.clickToUploadProfilePicture();
//		Thread.sleep(6000);
		tpCrp.selectCountryCode(countryCode);
		tpCrp.enterMobileNumber(mobileNumber);
		tpCrp.enterEmailID(emailID);
		tpCrp.clickToChooseGender(gender);
		tpCrp.clickToSelectDOB();
		String selectedDateOfBirth=driver.findElement(By.xpath("//input[@placeholder='Select Date of Birth']")).getAttribute("value");
	    ReadWriteData.setExcelData("./TestData/Workflow/TP_CandidateTestData-Workflow.xls", "Individual_Registration", Integer.parseInt(serialNum), 11, selectedDateOfBirth);
	  	tpCrp.selectMaritalStatus(maritalStatus);
		tpCrp.enterPlaceOfBirth(placeOfBirth);
		tpCrp.selectBirthState(birthState);
		Thread.sleep(2000);
		tpCrp.selectBirthDistrict(birthDistrict);
		Thread.sleep(2000);
		tpCrp.selectCast(cast);
		tpCrp.selectReligion(religion);	
		if(isDisabled.equalsIgnoreCase("yes"))
		{
			tpCrp.clickDisabilityYes();
			Thread.sleep(2000);
			tpCrp.selectDisablity(disablity);
			Thread.sleep(2000);
			tpCrp.clickToBrowsedisabilityProofDoc();
			Thread.sleep(2000);
			UploadFile.upload(disabilityProofDoc);
			Thread.sleep(2000);
			tpCrp.clickToUploadDisabilityProofDoc();
			Thread.sleep(5000);
		}
		else if(isDisabled.equalsIgnoreCase("no"))
		{
			tpCrp.clickDisabilityNo();
			Thread.sleep(1000);
		}
		tpCrp.enterMotherName(motherName);
		tpCrp.enterFatherName(fatherName);
		tpCrp.enterNameOFGuardian(guardianName);
		if(aadhaarOrAlterternateId.equalsIgnoreCase("aadhaar"))
		{
			tpCrp.clickToChooseAadhaar();
			tpCrp.enterAadhaarNumber(aadhaarNumber);
			tpCrp.clickToVerifyAadhaar();
			Thread.sleep(2000);
		}
		else
		{
			tpCrp.clickToChooseAlternateId();
			tpCrp.selectAlternateIdtype(alternateIdType);
			tpCrp.enterAlternateID(alternateID);
			Thread.sleep(1000);
			tpCrp.clickToBrowseAlternateIdFile();
			Thread.sleep(1000);
			UploadFile.upload(alternateIdFile);
			Thread.sleep(1000);
			tpCrp.clickToUploadAlternateIdFile();
			Thread.sleep(4000);
		}
		tpCrp.enterAddress(address);
		tpCrp.selectState(state);
		Thread.sleep(2000);
		tpCrp.selectDistrict(district);	
		Thread.sleep(2000);
		tpCrp.selectSubDistrict(subDistrict);
		Thread.sleep(2000);
		tpCrp.enterPincode(pincode);
		tpCrp.selectParlimentaryConstituency(parlimentaryConstituency);
//		tpCrp.enterLocationSPOC(locationSPOC);
		tpCrp.clickSaveAndContinue();
		Thread.sleep(5000);
		//Contact Details Page
		String candidateIDUrl=driver.getCurrentUrl();
		String parts[]=candidateIDUrl.split("/");
		String registeredCandidateID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/TP_CandidateTestData-Workflow.xls", "Individual_Registration", Integer.parseInt(serialNum), 1, registeredCandidateID);
		tpCrp.clickSameAsPermanetAddress();
		tpCrp.enterAccountHolderName(fullName);	
		tpCrp.enterAccountNumber(accountNumber);
		tpCrp.enterIFSC(ifsc);
		tpCrp.clickToGetAutopopulatedBankDetails();
		Thread.sleep(2000);
//		tpCrp.enterBankName(bankName);
//		tpCrp.enterBankAddress(bankAddress);
//		tpCrp.selectBoardingAndLodging(boardingAndLodging);
		tpCrp.clickSaveAndContinue();
		Thread.sleep(5000);
		//Education
		tpCrp.selectEducation(education1);
//		tpCrp.selectYearOfPassing(yearOfPassing1);
//		tpCrp.clickToBrowseEducationProofDoc();
//		UploadFile.upload(education1Proof);
//		tpCrp.clickToUploadEducationProof();
		//Candidate Experience
		tpCrp.selectPreTrainingStatus(preTrainingStatus);
		if(preTrainingStatus.equalsIgnoreCase("experienced"))
		{
			tpCrp.selectCandidateExperienceSector(sector1);
			tpCrp.selectCandidateExperienceJobRole(jobRole1, jobRoleCode1);
			tpCrp.selectExperienceMonths(experienceInMonths);
		}
		tpCrp.clickSaveAndContinue();
		Thread.sleep(5000);
		//hearaboutus and Course Preferences Page
		tpCrp.selectSector(sector1);
		tpCrp.selectSubSector(subSector1);
		tpCrp.selectJobRole(jobRole1, jobRoleCode1);
		Thread.sleep(2000);
		tpCrp.clickSaveAndContinue();
		Thread.sleep(5000);
		tpCrp.clickIAgree();
		Thread.sleep(1000);
		tpCrp.clickToAgreeAndSubmit();
		Thread.sleep(5000);
		tpCrp.clickOK();
		Thread.sleep(5000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();	
	}
}