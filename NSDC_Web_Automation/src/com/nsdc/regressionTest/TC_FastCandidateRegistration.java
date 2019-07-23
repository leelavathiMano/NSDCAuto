package com.nsdc.regressionTest;

import org.openqa.selenium.By;
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
import com.nsdc.testConfig.TestConfiguration;

public class TC_FastCandidateRegistration extends TestConfiguration
{
	@Test
	public void tpRegisteringCandidates() throws Exception
	{
		String total_Candidates=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Configurable-Fields", 1, 1);
		int totalCandidates=Integer.parseInt(total_Candidates);
		for(int i=1;i<=totalCandidates;i++)
		{
			String trainingPartnerID=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 2);
			String trainingPartnerPassword=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 3);
			String mobileNumber=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 4);
			String emailID=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 5);
			String sector1=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 6);
			String subSector1=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 7);
			String jobRole1=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 8);
			String jobRoleCode1=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Configurable-Fields", i, 9);
			String namePrefix=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 4);
			String fullName=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 5);
			String profilePicture=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 6);
			String countryCode=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 7);
			String gender=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 10);
			String maritalStatus=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 12);
			String birthState=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 14);
			String birthDistrict=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 15);
			String cast=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 16);
			String religion=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 17);
			String isDisabled=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 18);
			String disablity=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 19);
			String disabilityProofDoc=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 20);
			String motherName=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 21);
			String fatherName=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 22);
			String guardianName=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 23);
			String aadhaarOrAlterternateId=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 24);
			String aadhaarNumber=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 25);
			String alternateIdType=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 26);
			String alternateID=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 27);
			String alternateIdFile=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 28);
			String address=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 29);
			String state=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 31);
			String district=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 32);
			String subDistrict=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 33);
			String pincode=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 34);
			String parlimentaryConstituency=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 35);
			String accountNumber=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 65);
			String ifsc=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 66);
			String education1=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 44);
			String yearOfPassing1=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 46);
			String education1Proof=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 47);
			String preTrainingStatus=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 53);
			String experienceInMonths=ReadWriteData.getData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 54);
			
			WebDriverWait wait=new WebDriverWait(driver,25);
			TC_CandidateRegistrationPage tcCrp=new TC_CandidateRegistrationPage(driver);
			TC_MyCandidatesPage tcMp=new TC_MyCandidatesPage(driver);
			if(i==1)
			{
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
		        bvp.clickToClose();
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(trainingPartnerID, trainingPartnerPassword);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				tcCrp.clickMyCandidates();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Register Candidate')]")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Register Candidate')]")));
				tcMp.clickRegisterCandidate();
			}
			if(i!=1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Register Candidate')]")));
				tcMp.clickRegisterCandidate();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[@class='m-radio'])[2]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[@class='m-radio'])[2]")));
			tcMp.clickToChooseIndividualCandidateRegistration();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Register')]")));
			tcMp.clickRegister();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[input[@formcontrolname='gender']])[1]")));
			//Personal Details Page
			tcCrp.selectNamePrefix(namePrefix);
			tcCrp.enterFullName(fullName);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Candidate Full Name:')]")));
			tcCrp.clickToBrowseProfilePicture();
			Thread.sleep(2000);
			UploadFile.upload(profilePicture);
			Thread.sleep(2000);
			tcCrp.clickToUploadProfilePicture();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'file uploaded successfully')]")));
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'file uploaded successfully')]")));
			tcCrp.selectCountryCode(countryCode);
			tcCrp.enterMobileNumber(mobileNumber);
			tcCrp.enterEmailID(emailID);
			tcCrp.clickToChooseGender(gender);
			tcCrp.clickToSelectDOB();
			String selectedDateOfBirth=driver.findElement(By.xpath("//input[@placeholder='Select Date of Birth']")).getAttribute("value");
		    ReadWriteData.setExcelData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 11, selectedDateOfBirth);
//		  	tpCrp.selectMaritalStatus(maritalStatus);
//			tpCrp.enterPlaceOfBirth(placeOfBirth);
			tcCrp.selectBirthState(birthState);
			tcCrp.selectBirthDistrict(birthDistrict);
			tcCrp.selectCast(cast);
			tcCrp.selectReligion(religion);	
			if(isDisabled.equalsIgnoreCase("yes"))
			{
				tcCrp.clickDisabilityYes();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='disabilityCategory']")));
				tcCrp.selectDisablity(disablity);
				tcCrp.clickToBrowsedisabilityProofDoc();
				Thread.sleep(2000);
				UploadFile.upload(disabilityProofDoc);
				Thread.sleep(2000);
				tcCrp.clickToUploadDisabilityProofDoc();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'1 file uploaded successfully')]")));
//				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'1 file uploaded successfully')]")));
			}
//			else if(isDisabled.equalsIgnoreCase("no"))
//			{
//				tcCrp.clickDisabilityNo();
//			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[input[@formcontrolname='gender']])[1]")));
			tcCrp.enterMotherName(motherName);
			tcCrp.enterFatherName(fatherName);
//			tcCrp.enterNameOFGuardian(guardianName);
			if(aadhaarOrAlterternateId.equalsIgnoreCase("aadhaar"))
			{
				tcCrp.clickToChooseAadhaar();
				tcCrp.enterAadhaarNumber(aadhaarNumber);
//				tcCrp.clickToVerifyAadhaar();
				tcCrp.clickDummyVerify();
			}
			else
			{
				tcCrp.clickToChooseAlternateId();
				tcCrp.selectAlternateIdtype(alternateIdType);
				tcCrp.enterAlternateID(alternateID);
				tcCrp.clickToBrowseAlternateIdFile(isDisabled);
				Thread.sleep(2000);
				UploadFile.upload(alternateIdFile);
				tcCrp.clickToUploadAlternateIdFile(isDisabled);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'file uploaded successfully')]")));
//				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'file uploaded successfully')]")));
			}
			tcCrp.enterAddress(address);
			tcCrp.selectState(state);
			tcCrp.selectDistrict(district);	
			wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.xpath("//select[@formcontrolname='subDistrict']"), By.tagName("option")));
			Thread.sleep(3000);
//			tcCrp.selectSubDistrict(subDistrict);
			tcCrp.enterPincode(pincode);
//			tpCrp.selectParlimentaryConstituency(parlimentaryConstituency);
//			tpCrp.enterLocationSPOC(locationSPOC);
			tcCrp.clickSaveAndContinue();
			Thread.sleep(3000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[label[contains(text(),'Same as Permanent Address')]]/div/label/span")));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[label[contains(text(),'Same as Permanent Address')]]/div/label/span")));
			//Contact Details Page
			String candidateIDUrl=driver.getCurrentUrl();
			String parts[]=candidateIDUrl.split("/");
			String registeredCandidateID=parts[parts.length-1];
			ReadWriteData.setExcelData("./TestData/Workflow/TC_Fast_CanRegist-Workflow.xls", "Individual_Registration", i, 1, registeredCandidateID);
			tcCrp.clickSameAsPermanetAddress();
			Thread.sleep(2000);
			tcCrp.enterAccountHolderName(fullName);	
			tcCrp.enterAccountNumber(accountNumber);
			tcCrp.enterIFSC(ifsc);
			tcCrp.clickToGetAutopopulatedBankDetails();
			Thread.sleep(3000);
//			tpCrp.enterBankName(bankName);
//			tpCrp.enterBankAddress(bankAddress);
//			tpCrp.selectBoardingAndLodging(boardingAndLodging);
			tcCrp.clickSaveAndContinue();
			Thread.sleep(2000);
			//Education
			tcCrp.selectEducation(education1);
			tcCrp.selectYearOfPassing(yearOfPassing1);
			tcCrp.clickToBrowseEducationProofDoc();
			Thread.sleep(2000);
			UploadFile.upload(education1Proof);
			Thread.sleep(3000);
			tcCrp.clickToUploadEducationProof();
			Thread.sleep(4000);
			//Candidate Experience
			tcCrp.selectPreTrainingStatus(preTrainingStatus);
			if(preTrainingStatus.equalsIgnoreCase("experienced"))
			{
				tcCrp.selectCandidateExperienceSector(sector1);
				tcCrp.selectCandidateExperienceJobRole(jobRole1, jobRoleCode1);
				tcCrp.selectExperienceMonths(experienceInMonths);
			}
			Thread.sleep(3000);
			tcCrp.clickSaveAndContinue();
			Thread.sleep(3000);
			//hearaboutus and Course Preferences Page
//			tcCrp.selectSector(sector1);
//			tcCrp.selectSubSector(subSector1);
//			tcCrp.selectJobRole(jobRole1, jobRoleCode1);
			tcCrp.clickSaveAndContinue();
			Thread.sleep(2000);
			tcCrp.clickIAgree();
			Thread.sleep(1000);
			tcCrp.clickToAgreeAndSubmit();
			tcCrp.clickOK();
			Thread.sleep(5000);
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
}