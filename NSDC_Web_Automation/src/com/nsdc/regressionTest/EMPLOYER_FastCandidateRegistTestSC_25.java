package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EMPLOYER_CandidateRegistartionPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.testConfig.TestConfiguration;

public class EMPLOYER_FastCandidateRegistTestSC_25 extends TestConfiguration
{
	@Test
	public void employerRegisteringCandidatesTC01() throws Exception
	{
		String total_Candidates=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Configurable-Fields", 1, 1);
		int totalCandidates=Integer.parseInt(total_Candidates);
		for(int i=1;i<=totalCandidates;i++)
		{
			String trainingPartnerID=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 2);
			String trainingPartnerPassword=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 3);
			String mobileNumber=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 4);
			String emailID=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 5);
			String sector1=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 6);
			String subSector1=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 7);
			String jobRole1=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 8);
			String jobRoleCode1=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 9);
			String namePrefix=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 4);
			String fullName=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 5);
			String profilePicture=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 6);
			String countryCode=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 7);
			String gender=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 10);
			String maritalStatus=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 12);
			String birthState=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 14);
			String birthDistrict=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 15);
			String cast=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 16);
			String religion=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 17);
			String isDisabled=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 18);
			String disablity=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 19);
			String disabilityProofDoc=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 20);
			String motherName=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 21);
			String fatherName=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 22);
			String guardianName=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 23);
			String aadhaarOrAlterternateId=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 24);
			String aadhaarNumber=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 25);
			String alternateIdType=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 26);
			String alternateID=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 27);
			String alternateIdFile=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 28);
			String address=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 29);
			String state=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 31);
			String district=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 32);
			String subDistrict=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 33);
			String pincode=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 34);
			String parlimentaryConstituency=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 35);
			String accountNumber=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 65);
			String ifsc=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 66);
			String education1=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 44);
			String yearOfPassing1=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 46);
			String education1Proof=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 47);
			String preTrainingStatus=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 53);
			String experienceInMonths=ReadWriteData.getData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 54);
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			EMPLOYER_CandidateRegistartionPage eDp=new EMPLOYER_CandidateRegistartionPage(driver);
			if(i==1)
			{
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				Thread.sleep(2000);
				BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
		        bvp.clickToClose();
		        Thread.sleep(2000);
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(trainingPartnerID, trainingPartnerPassword);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(1000);
				eDp.clickOnRegisterCandidate();
			}
			if(i!=1)
			{
				driver.navigate().refresh();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				eDp.clickOnRegisterCandidate_InViewMyCandidate();
			}
			Thread.sleep(4000);
			if(i!=1)
			{
				eDp.clickToChooseIndividualCandidateRegistration();
				Thread.sleep(1000);
				eDp.clickRegister();
				Thread.sleep(3000);
			}
			//Personal Details Page
			eDp.selectNamePrefix(namePrefix);
			eDp.enterFullName(fullName);
			Thread.sleep(2000);
			eDp.clickToBrowseProfilePicture();
			Thread.sleep(2000);
			UploadFile.upload(profilePicture);
			Thread.sleep(2000);
			eDp.clickToUploadProfilePicture();
			Thread.sleep(4000);
			eDp.selectCountryCode(countryCode);
			eDp.enterMobileNumber(mobileNumber);
			eDp.enterEmailID(emailID);
			eDp.clickToChooseGender(gender);
			eDp.clickToSelectDOB();
			String selectedDateOfBirth=driver.findElement(By.xpath("//input[@placeholder='Select Date of Birth']")).getAttribute("value");
		    ReadWriteData.setExcelData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 11, selectedDateOfBirth);
//		  	tpCrp.selectMaritalStatus(maritalStatus);
//			tpCrp.enterPlaceOfBirth(placeOfBirth);
		    eDp.selectBirthState(birthState);
			Thread.sleep(2000);
			eDp.selectBirthDistrict(birthDistrict);
			Thread.sleep(2000);
			eDp.selectCast(cast);
			eDp.selectReligion(religion);	
			if(isDisabled.equalsIgnoreCase("yes"))
			{
				eDp.clickDisabilityYes();
				Thread.sleep(2000);
				eDp.selectDisablity(disablity);
				Thread.sleep(2000);
				eDp.clickToBrowsedisabilityProofDoc();
				Thread.sleep(2000);
				UploadFile.upload(disabilityProofDoc);
				Thread.sleep(2000);
				eDp.clickToUploadDisabilityProofDoc();
				Thread.sleep(5000);
			}
			else if(isDisabled.equalsIgnoreCase("no"))
			{
				eDp.clickDisabilityNo();
				Thread.sleep(1000);
			}
			eDp.enterMotherName(motherName);
			eDp.enterFatherName(fatherName);
			eDp.enterNameOFGuardian(guardianName);
			if(aadhaarOrAlterternateId.equalsIgnoreCase("aadhaar"))
			{
				eDp.clickToChooseAadhaar();
				eDp.enterAadhaarNumber(aadhaarNumber);
//				tpCrp.clickToVerifyAadhaar();
				eDp.clickDummyVerify();
				Thread.sleep(2000);
			}
			else
			{
				eDp.clickToChooseAlternateId();
				eDp.selectAlternateIdtype(alternateIdType);
				eDp.enterAlternateID(alternateID);
				Thread.sleep(3000);
				eDp.clickToBrowseAlternateIdFile(isDisabled);
				Thread.sleep(1000);
				UploadFile.upload(alternateIdFile);
				Thread.sleep(1000);
				eDp.clickToUploadAlternateIdFile(isDisabled);
				Thread.sleep(4000);
			}
			eDp.enterAddress(address);
			eDp.selectState(state);
			Thread.sleep(2000);
			eDp.selectDistrict(district);	
			Thread.sleep(2000);
//			eDp.selectSubDistrict(subDistrict);
//			Thread.sleep(2000);
			eDp.enterPincode(pincode);
//			eDp.selectParlimentaryConstituency(parlimentaryConstituency);
//			eDp.enterLocationSPOC(locationSPOC);
			eDp.clickSaveAndContinue();
			Thread.sleep(5000);
			//Contact Details Page
			String candidateIDUrl=driver.getCurrentUrl();
			String parts[]=candidateIDUrl.split("/");
			String registeredCandidateID=parts[parts.length-1];
			ReadWriteData.setExcelData("./TestData/Workflow/EMPLOYER_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 1, registeredCandidateID);
			eDp.clickSameAsPermanetAddress();
			Thread.sleep(2000);
			eDp.enterAccountHolderName(fullName);	
			eDp.enterAccountNumber(accountNumber);
			Thread.sleep(2000);
			eDp.enterIFSC(ifsc);
			Thread.sleep(2000);
			eDp.clickToGetAutopopulatedBankDetails();
			Thread.sleep(2000);
//			eDp.enterBankName(bankName);
//			eDp.enterBankAddress(bankAddress);
//			eDp.selectBoardingAndLodging(boardingAndLodging);
			eDp.clickSaveAndContinue();
			Thread.sleep(5000);
			//Education
			eDp.selectEducation(education1);
			Thread.sleep(2000);
			eDp.selectYearOfPassing(yearOfPassing1);
			Thread.sleep(2000);
			eDp.clickToBrowseEducationProofDoc();
			Thread.sleep(2000);
			UploadFile.upload(education1Proof);
			Thread.sleep(2000);
			eDp.clickToUploadEducationProof();
			Thread.sleep(5000);
			//Candidate Experience
			eDp.selectPreTrainingStatus(preTrainingStatus);
			Thread.sleep(2000);
			if(preTrainingStatus.equalsIgnoreCase("experienced"))
			{
				eDp.selectCandidateExperienceSector(sector1);
				eDp.selectCandidateExperienceJobRole(jobRole1, jobRoleCode1);
				eDp.selectExperienceMonths(experienceInMonths);
			}
			eDp.clickSaveAndContinue();
			Thread.sleep(5000);
			//hearaboutus and Course Preferences Page
//			eDp.selectSector(sector1);
//			eDp.selectSubSector(subSector1);
//			eDp.selectJobRole(jobRole1, jobRoleCode1);
//			Thread.sleep(2000);
			eDp.clickSaveAndContinue();
			Thread.sleep(5000);
			eDp.clickIAgree();
			Thread.sleep(1000);
			eDp.clickToAgreeAndSubmit();
			Thread.sleep(5000);
			eDp.clickOK();
			Thread.sleep(5000);
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
}