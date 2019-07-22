package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.CAMPS_CandidateRegistrationPage;
import com.nsdc.pages.CAMPS_DashboardPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.pages.TrainingPartner_CandidateRegistrationPage;
import com.nsdc.pages.TrainingPartner_MyCandidatesPage;
import com.nsdc.testConfig.TestConfiguration;

public class CAMPS_CandidatesRegistration extends TestConfiguration
{
	@Test
	public void tpRegisteringCandidates() throws Exception
	{
		String total_Candidates=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Configurable-Fields", 1, 1);
		int totalCandidates=Integer.parseInt(total_Candidates);
		for(int i=1;i<=totalCandidates;i++)
		{
			String trainingPartnerID=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 2);
			String trainingPartnerPassword=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 3);
			String sector1=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 6);
			String subSector1=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 7);
			String jobRole1=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 8);
			String jobRoleCode1=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 9);
			String namePrefix=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 4);
			String fullName=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 5);
			String profilePicture=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 6);
			String countryCode=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 7);
			String mobileNumber=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 8);
			String emailID=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 9);
			String gender=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 10);
			String maritalStatus=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 12);
			String birthState=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 14);
			String birthDistrict=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 15);
			String cast=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 16);
			String religion=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 17);
			String isDisabled=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 18);
			String disablity=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 19);
			String disabilityProofDoc=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 20);
			String motherName=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 21);
			String fatherName=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 22);
			String guardianName=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 23);
			String aadhaarOrAlterternateId=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 24);
			String aadhaarNumber=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 25);
			String alternateIdType=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 26);
			String alternateID=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 27);
			String alternateIdFile=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 28);
			String address=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 29);
			String state=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 31);
			String district=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 32);
			String subDistrict=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 33);
			String pincode=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 34);
			String parlimentaryConstituency=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 35);
			String accountNumber=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 65);
			String ifsc=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 66);
			String education1=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 44);
			String yearOfPassing1=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 46);
			String education1Proof=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 47);
			String preTrainingStatus=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 53);
			String experienceInMonths=ReadWriteData.getData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 54);
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			CAMPS_DashboardPage cDp=new CAMPS_DashboardPage(driver);
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
				js.executeScript("window.scrollBy(0,500)", "");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(1000);
				cDp.clickOnRegisterCandidate();
			}
			if(i!=1)
			{
				driver.navigate().refresh();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				cDp.clickOnRegisterCandidate_InViewMyCandidate();
			}
			Thread.sleep(4000);
			CAMPS_CandidateRegistrationPage cRp=new CAMPS_CandidateRegistrationPage(driver);
			if(i!=1)
			{
				cRp.clickToChooseIndividualCandidateRegistration();
				Thread.sleep(1000);
				cRp.clickRegister();
				Thread.sleep(3000);
			}
			//Personal Details Page
			cRp.selectNamePrefix(namePrefix);
			cRp.enterFullName(fullName);
			Thread.sleep(2000);
			cRp.clickToBrowseProfilePicture();
			Thread.sleep(2000);
			UploadFile.upload(profilePicture);
			Thread.sleep(2000);
			cRp.clickToUploadProfilePicture();
			Thread.sleep(4000);
			cRp.selectCountryCode(countryCode);
			cRp.enterMobileNumber(mobileNumber);
			cRp.enterEmailID(emailID);
			cRp.clickToChooseGender(gender);
			cRp.clickToSelectDOB();
			String selectedDateOfBirth=driver.findElement(By.xpath("//input[@placeholder='Select Date of Birth']")).getAttribute("value");
		    ReadWriteData.setExcelData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 11, selectedDateOfBirth);
//		  	tpCrp.selectMaritalStatus(maritalStatus);
//			tpCrp.enterPlaceOfBirth(placeOfBirth);
			cRp.selectBirthState(birthState);
			Thread.sleep(2000);
			cRp.selectBirthDistrict(birthDistrict);
			Thread.sleep(2000);
			cRp.selectCast(cast);
			cRp.selectReligion(religion);	
			if(isDisabled.equalsIgnoreCase("yes"))
			{
				cRp.clickDisabilityYes();
				Thread.sleep(2000);
				cRp.selectDisablity(disablity);
				Thread.sleep(2000);
				cRp.clickToBrowsedisabilityProofDoc();
				Thread.sleep(2000);
				UploadFile.upload(disabilityProofDoc);
				Thread.sleep(2000);
				cRp.clickToUploadDisabilityProofDoc();
				Thread.sleep(5000);
			}
			else if(isDisabled.equalsIgnoreCase("no"))
			{
				cRp.clickDisabilityNo();
				Thread.sleep(1000);
			}
			cRp.enterMotherName(motherName);
			cRp.enterFatherName(fatherName);
			cRp.enterNameOFGuardian(guardianName);
			if(aadhaarOrAlterternateId.equalsIgnoreCase("aadhaar"))
			{
				cRp.clickToChooseAadhaar();
				cRp.enterAadhaarNumber(aadhaarNumber);
//				tpCrp.clickToVerifyAadhaar();
				cRp.clickDummyVerify();
				Thread.sleep(2000);
			}
			else
			{
				cRp.clickToChooseAlternateId();
				cRp.selectAlternateIdtype(alternateIdType);
				cRp.enterAlternateID(alternateID);
				Thread.sleep(3000);
				cRp.clickToBrowseAlternateIdFile(isDisabled);
				Thread.sleep(1000);
				UploadFile.upload(alternateIdFile);
				Thread.sleep(1000);
				cRp.clickToUploadAlternateIdFile(isDisabled);
				Thread.sleep(4000);
			}
			cRp.enterAddress(address);
			cRp.selectState(state);
			Thread.sleep(2000);
			cRp.selectDistrict(district);	
			Thread.sleep(2000);
//			tpCrp.selectSubDistrict(subDistrict);
//			Thread.sleep(2000);
			cRp.enterPincode(pincode);
//			tpCrp.selectParlimentaryConstituency(parlimentaryConstituency);
//			tpCrp.enterLocationSPOC(locationSPOC);
			cRp.clickSaveAndContinue();
			Thread.sleep(5000);
			//Contact Details Page
			String candidateIDUrl=driver.getCurrentUrl();
			String parts[]=candidateIDUrl.split("/");
			String registeredCandidateID=parts[parts.length-1];
			ReadWriteData.setExcelData("./TestData/Workflow/CAMPS_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 1, registeredCandidateID);
			cRp.clickSameAsPermanetAddress();
			Thread.sleep(2000);
			cRp.enterAccountHolderName(fullName);	
			cRp.enterAccountNumber(accountNumber);
			Thread.sleep(2000);
			cRp.enterIFSC(ifsc);
			Thread.sleep(2000);
			cRp.clickToGetAutopopulatedBankDetails();
			Thread.sleep(2000);
//			tpCrp.enterBankName(bankName);
//			tpCrp.enterBankAddress(bankAddress);
//			tpCrp.selectBoardingAndLodging(boardingAndLodging);
			cRp.clickSaveAndContinue();
			Thread.sleep(5000);
			//Education
			cRp.selectEducation(education1);
			Thread.sleep(2000);
			cRp.selectYearOfPassing(yearOfPassing1);
			Thread.sleep(2000);
			cRp.clickToBrowseEducationProofDoc();
			Thread.sleep(2000);
			UploadFile.upload(education1Proof);
			Thread.sleep(2000);
			cRp.clickToUploadEducationProof();
			Thread.sleep(5000);
			//Candidate Experience
			cRp.selectPreTrainingStatus(preTrainingStatus);
			Thread.sleep(2000);
			if(preTrainingStatus.equalsIgnoreCase("experienced"))
			{
				cRp.selectCandidateExperienceSector(sector1);
				cRp.selectCandidateExperienceJobRole(jobRole1, jobRoleCode1);
				cRp.selectExperienceMonths(experienceInMonths);
			}
			cRp.clickSaveAndContinue();
			Thread.sleep(5000);
			//hearaboutus and Course Preferences Page
//			tpCrp.selectSector(sector1);
//			tpCrp.selectSubSector(subSector1);
//			tpCrp.selectJobRole(jobRole1, jobRoleCode1);
//			Thread.sleep(2000);
			cRp.clickSaveAndContinue();
			Thread.sleep(5000);
			cRp.clickIAgree();
			Thread.sleep(1000);
			cRp.clickToAgreeAndSubmit();
			Thread.sleep(5000);
			cRp.clickOK();
			Thread.sleep(5000);
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
}