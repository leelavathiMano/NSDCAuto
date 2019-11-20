package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.TC_CandidateRegistrationPage;
import com.nsdc.pages.TC_MyCandidatesPage;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.pages.TrainingPartner_CandidateRegistrationPage;
import com.nsdc.pages.TrainingPartner_MyCandidatesPage;
import com.nsdc.testConfig.TestConfiguration;

public class TP_Fast_CandidatesRegistrationDataCreationTestSC_27 extends TestConfiguration
{
	@Test
	public void tpRegisteringCandidatesTC01() throws Exception
	{
		String total_Candidates=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Configurable-Fields", 1, 1);
		int totalCandidates=Integer.parseInt(total_Candidates);
		for(int i=1;i<=totalCandidates;i++)
		{
			String trainingPartnerID=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 2);
			String trainingPartnerPassword=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 3);
			String sector1=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 6);
			String subSector1=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 7);
			String jobRole1=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 8);
			String jobRoleCode1=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 9);
			String namePrefix=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 4);
			String fullName=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 5);
			String profilePicture=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 6);
			String countryCode=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 7);
			String mobileNumber=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 8);
			String emailID=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 9);
			String gender=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 10);
			String maritalStatus=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 12);
			String birthState=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 14);
			String birthDistrict=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 15);
			String cast=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 16);
			String religion=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 17);
			String isDisabled=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 18);
			String disablity=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 19);
			String disabilityProofDoc=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 20);
			String motherName=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 21);
			String fatherName=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 22);
			String guardianName=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 23);
			String aadhaarOrAlterternateId=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 24);
			String aadhaarNumber=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 25);
			String alternateIdType=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 26);
			String alternateID=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 27);
			String alternateIdFile=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 28);
			String address=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 29);
			String state=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 31);
			String district=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 32);
			String subDistrict=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 33);
			String pincode=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 34);
			String parlimentaryConstituency=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 35);
			String accountNumber=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 65);
			String ifsc=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 66);
			String bankName=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 67);
			String education1=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 44);
			String yearOfPassing1=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 46);
			String education1Proof=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 47);
			String preTrainingStatus=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 53);
			String experienceInMonths=ReadWriteData.getData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 54);
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			TrainingPartnerDashboardPage tDp=new TrainingPartnerDashboardPage(driver);
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
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(4000);
				tDp.clickOnRegisterCandidate();
				//tDp.clickOnRegisterCandidate();
			}
			if(i!=1)
				
			{
				Thread.sleep(2000);
				tDp.clickOnRegisterCandidate_InViewMyCandidate();
			}
			Thread.sleep(1000);
			TrainingPartner_MyCandidatesPage tpMp=new TrainingPartner_MyCandidatesPage(driver);
			tpMp.clickToChooseIndividualCandidateRegistration();
			tpMp.clickRegister();
			Thread.sleep(3000);
			//Personal Details Page
			TrainingPartner_CandidateRegistrationPage tpCrp=new TrainingPartner_CandidateRegistrationPage(driver);
			Thread.sleep(2000);
			tpCrp.selectNamePrefix(namePrefix);
			Thread.sleep(2000);
			tpCrp.enterFullName(fullName);
			Thread.sleep(1000);
			tpCrp.clickToBrowseProfilePicture();
			Thread.sleep(2000);
			UploadFile.upload(profilePicture);
			Thread.sleep(4000);
			tpCrp.clickToUploadProfilePicture();
			Thread.sleep(3000);
			tpCrp.selectCountryCode(countryCode);
			tpCrp.enterMobileNumber(mobileNumber);
			tpCrp.enterEmailID(emailID);
			tpCrp.clickToChooseGender(gender);
			tpCrp.clickToSelectDOB();
		//	String selectedDateOfBirth=driver.findElement(By.xpath("//input[@placeholder='Choose Date']")).getAttribute("value");
		//  ReadWriteData.setExcelData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 11, selectedDateOfBirth);
		  	tpCrp.selectMaritalStatus(maritalStatus);
//			tpCrp.enterPlaceOfBirth(placeOfBirth);
			tpCrp.selectBirthState(birthState);
			Thread.sleep(2000);
			tpCrp.selectBirthDistrict(birthDistrict);
			Thread.sleep(2000);
			tpCrp.selectCast(cast);
			tpCrp.selectReligion(religion);	
			if(isDisabled.equalsIgnoreCase("yes"))
			{
				tpCrp.clickDisabilityYes();
				Thread.sleep(1000);
				tpCrp.selectDisablity(disablity);
				Thread.sleep(1000);
				tpCrp.clickToBrowsedisabilityProofDoc();
				Thread.sleep(2000);
				UploadFile.upload(disabilityProofDoc);
				Thread.sleep(2000);
				tpCrp.clickToUploadDisabilityProofDoc();
				Thread.sleep(3000);
			}
//			else if(isDisabled.equalsIgnoreCase("no"))
//			{
//				tpCrp.clickDisabilityNo();
//				Thread.sleep(1000);
//			}
			tpCrp.enterMotherName(motherName);
			tpCrp.enterFatherName(fatherName);
			tpCrp.enterNameOFGuardian(guardianName);
			if(aadhaarOrAlterternateId.equalsIgnoreCase("aadhaar"))
			{
				tpCrp.clickToChooseAadhaar();
				tpCrp.enterAadhaarNumber(aadhaarNumber);
//				tpCrp.clickToVerifyAadhaar();
				tpCrp.clickDummyVerify();
//				Thread.sleep(2000);
			}
			else
			{
				tpCrp.clickToChooseAlternateId();
				tpCrp.selectAlternateIdtype(alternateIdType);
				tpCrp.enterAlternateID(alternateID);
				Thread.sleep(1000);
				tpCrp.clickToBrowseAlternateIdFile(isDisabled);
				Thread.sleep(1000);
				UploadFile.upload(alternateIdFile);
				Thread.sleep(1000);
				tpCrp.clickToUploadAlternateIdFile(isDisabled);
				Thread.sleep(3000);
			}
			Thread.sleep(3000);
			tpCrp.enterAddress(address);
			tpCrp.selectState(state);
			Thread.sleep(2000);
			tpCrp.selectDistrict(district);	
			Thread.sleep(3000);
//			tpCrp.selectSubDistrict(subDistrict);
//			Thread.sleep(2000);
			tpCrp.enterPincode(pincode);
			Thread.sleep(2000);
//			tpCrp.selectParlimentaryConstituency(parlimentaryConstituency);
//			tpCrp.enterLocationSPOC(locationSPOC);
			tpCrp.clickSaveAndContinue();
			Thread.sleep(10000);
			//Contact Details Page
			String candidateIDUrl=driver.getCurrentUrl();
			String parts[]=candidateIDUrl.split("/");
			String registeredCandidateID=parts[parts.length-1];
			ReadWriteData.setExcelData("./TestData/Workflow/TP_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 1, registeredCandidateID);
			tpCrp.clickSameAsPermanetAddress();
			Thread.sleep(1000);
			tpCrp.enterAccountHolderName(fullName);	
			tpCrp.enterAccountNumber(accountNumber);
			Thread.sleep(1000);
			tpCrp.enterIFSC(ifsc);
			///////////
			//tpCrp.ClickOnSearchBankName();
			
			Thread.sleep(1000);
			//tpCrp.clickToGetAutopopulatedBankDetails();
			//Thread.sleep(3000);
			tpCrp.ClickBankName();
			Thread.sleep(1000);
			tpCrp.enterSearchBankName(bankName);
			Thread.sleep(1000);
			tpCrp.ChooseBankName();
			Thread.sleep(1000);
//			tpCrp.ClickOKButton();
//			tpCrp.enterBankAddress(bankAddress);
//			tpCrp.selectBoardingAndLodging(boardingAndLodging);
			tpCrp.clickSaveAndContinue();
			Thread.sleep(7000);
			//Education
			tpCrp.selectEducation(education1);
			tpCrp.selectYearOfPassing(yearOfPassing1);
			Thread.sleep(1000);
			tpCrp.clickToBrowseEducationProofDoc();
			Thread.sleep(5000);
			UploadFile.upload(education1Proof);
			Thread.sleep(7000);
			tpCrp.clickToUploadEducationProof();
			Thread.sleep(10000);
			//Candidate Experience
			tpCrp.selectPreTrainingStatus(preTrainingStatus);
			Thread.sleep(1000);
			if(preTrainingStatus.equalsIgnoreCase("experienced"))
			{
				tpCrp.selectCandidateExperienceSector(sector1);
				tpCrp.selectCandidateExperienceJobRole(jobRole1, jobRoleCode1);
				tpCrp.selectExperienceMonths(experienceInMonths);
			}
			tpCrp.clickSaveAndContinue();
			Thread.sleep(8000);
			//Hear about us and Course Preferences Page
//			tpCrp.selectSector(sector1);
//			tpCrp.selectSubSector(subSector1);
//			tpCrp.selectJobRole(jobRole1, jobRoleCode1);
//			Thread.sleep(2000);
			tpCrp.clickSaveAndContinue();
			Thread.sleep(7000);
			tpCrp.clickIAgree();
			Thread.sleep(1000);
			tpCrp.clickToAgreeAndSubmit();
			Thread.sleep(5000);
			tpCrp.clickOK();
			Thread.sleep(2000);
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
}