package com.nsdc.regressionTest;

import org.openqa.selenium.By;
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
	public void tcCandidatesRegistrationTC_01(String serialNum, String candidateID, String tcID, String tcPassword, String namePrefix, String fullName, String profilePicture, String countryCode, String mobileNumber, String emailID, String gender, String dob, String maritalStatus, String placeOfBirth, String birthState, String birthDistrict, String cast, String religion, String isDisabled, String disablity, String disabilityProofDoc, String motherName, String fatherName, String guardianName, String aadhaarOrAlterternateId, String aadhaarNumber, String alternateIdType, String alternateID, String alternateIdFile, String address, String village, String state, String district, String subDistrict, String pincode, String parlimentaryConstituency, String isCommunicationAddressSameAsPermanentAddress, String cAddress, String cVillage, String cState, String cDistrict, String cSubDistrict, String cPincode, String cParlimentaryConstituency, String education1, String specialisation1, String yearOfPassing1, String education1Proof, String education2, String specialisation2, String othersEducationName, String yearOfPassing2, String education2Proof, String preTrainingStatus, String experienceInMonths, String hearAboutUs, String sector1, String subSector1, String jobRole1, String jobRoleCode1, String sector2, String subSector2, String jobRole2, String jobRoleCode2, String locationSPOC, String accountNumber, String ifsc, String bankName, String bankAddress, String boardingAndLodging) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		TC_CandidateRegistrationPage tcCrp=new TC_CandidateRegistrationPage(driver);
		tcCrp.clickMyCandidates();
		Thread.sleep(1000);
		TC_MyCandidatesPage tcMp=new TC_MyCandidatesPage(driver);
		tcMp.clickRegisterCandidate();
		Thread.sleep(1000);
		tcMp.clickToChooseIndividualCandidateRegistration();
		Thread.sleep(1000);
		tcMp.clickRegister();
		//Personal Details Page
		Thread.sleep(1000);
		tcCrp.selectNamePrefix(namePrefix);
		tcCrp.enterFullName(fullName);
		Thread.sleep(1000);
//		tcCrp.clickToBrowseProfilePicture();
//		Thread.sleep(1000);
//		UploadFile.upload(profilePicture);
//		Thread.sleep(1000);
//		tcCrp.clickToUploadProfilePicture();
//		Thread.sleep(5000);
		tcCrp.selectCountryCode(countryCode);
		tcCrp.enterMobileNumber(mobileNumber);
		tcCrp.enterEmailID(emailID);
		tcCrp.clickToChooseGender(gender);
		tcCrp.clickToSelectDOB();
		String selectedDateOfBirth=driver.findElement(By.xpath("//input[@placeholder='Select Date of Birth']")).getAttribute("value");
	    ReadWriteData.setExcelData("./TestData/Workflow/TC_CandidateTestData-Workflow.xls", "Individual_Registration", Integer.parseInt(serialNum), 11, selectedDateOfBirth);
	    tcCrp.selectMaritalStatus(maritalStatus);
		tcCrp.enterPlaceOfBirth(placeOfBirth);
		tcCrp.selectBirthState(birthState);
		Thread.sleep(2000);
		tcCrp.selectBirthDistrict(birthDistrict);
		Thread.sleep(2000);
		tcCrp.selectCast(cast);
		tcCrp.selectReligion(religion);	
		if(isDisabled.equalsIgnoreCase("yes"))
		{
			tcCrp.clickDisabilityYes();
			Thread.sleep(2000);
			tcCrp.selectDisablity(disablity);
			Thread.sleep(2000);
			tcCrp.clickToBrowsedisabilityProofDoc();
			Thread.sleep(2000);
			UploadFile.upload(disabilityProofDoc);
			Thread.sleep(2000);
			tcCrp.clickToUploadDisabilityProofDoc();
			Thread.sleep(5000);
		}
		else if(isDisabled.equalsIgnoreCase("no"))
		{
			tcCrp.clickDisabilityNo();
			Thread.sleep(1000);
		}
		tcCrp.enterMotherName(motherName);
		tcCrp.enterFatherName(fatherName);
		tcCrp.enterNameOFGuardian(guardianName);
		if(aadhaarOrAlterternateId.equalsIgnoreCase("aadhaar"))
		{
			tcCrp.clickToChooseAadhaar();
			tcCrp.enterAadhaarNumber(aadhaarNumber);
			tcCrp.clickToVerifyAadhaar();
			Thread.sleep(2000);
		}
		else
		{
			tcCrp.clickToChooseAlternateId();
			tcCrp.selectAlternateIdtype(alternateIdType);
			tcCrp.enterAlternateID(alternateID);
			Thread.sleep(1000);
			tcCrp.clickToBrowseAlternateIdFile();
			Thread.sleep(1000);
			UploadFile.upload(alternateIdFile);
			Thread.sleep(1000);
			tcCrp.clickToUploadAlternateIdFile();
			Thread.sleep(4000);
		}
		tcCrp.enterAddress(address);
		tcCrp.selectState(state);
		Thread.sleep(2000);
		tcCrp.selectDistrict(district);	
		Thread.sleep(2000);
		tcCrp.selectSubDistrict(subDistrict);
		Thread.sleep(2000);
		tcCrp.enterPincode(pincode);
		tcCrp.selectParlimentaryConstituency(parlimentaryConstituency);
//		tpCrp.enterLocationSPOC(locationSPOC);
		tcCrp.clickSaveAndContinue();
		Thread.sleep(5000);
		//Contact Details Page
		String candidateIDUrl=driver.getCurrentUrl();
		String parts[]=candidateIDUrl.split("/");
		String registeredCandidateID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CandidateTestData-Workflow.xls", "Individual_Registration", Integer.parseInt(serialNum), 1, registeredCandidateID);
		tcCrp.clickSameAsPermanetAddress();
		tcCrp.enterAccountHolderName(fullName);	
		tcCrp.enterAccountNumber(accountNumber);
		tcCrp.enterIFSC(ifsc);
		tcCrp.clickToGetAutopopulatedBankDetails();
		Thread.sleep(4000);
//		tcCrp.enterBankName(bankName);
//		tcCrp.enterBankAddress(bankAddress);
//		tpCrp.selectBoardingAndLodging(boardingAndLodging);
//		Thread.sleep(3000);
		tcCrp.clickSaveAndContinue();
		Thread.sleep(5000);
		//Education
		tcCrp.selectEducation(education1);
//		tcCrp.selectYearOfPassing(yearOfPassing1);
//		tcCrp.clickToBrowseEducationProofDoc();
//		UploadFile.upload(education1Proof);
//		tcCrp.clickToUploadEducationProof();
		//Candidate Experience
		tcCrp.selectPreTrainingStatus(preTrainingStatus);
		if(preTrainingStatus.equalsIgnoreCase("experienced"))
		{
			tcCrp.selectCandidateExperienceSector(sector1);
			tcCrp.selectCandidateExperienceJobRole(jobRole1, jobRoleCode1);
			tcCrp.selectExperienceMonths(experienceInMonths);
		}
		tcCrp.clickSaveAndContinue();
		Thread.sleep(5000);
		//hearaboutus and Course Preferences Page
		tcCrp.selectSector(sector1);
		tcCrp.selectSubSector(subSector1);
		tcCrp.selectJobRole(jobRole1,jobRoleCode1);
		Thread.sleep(2000);
		tcCrp.clickSaveAndContinue();
		Thread.sleep(5000);
		tcCrp.clickIAgree();
		Thread.sleep(1000);
		tcCrp.clickToAgreeAndSubmit();
		Thread.sleep(6000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();	
	}
}