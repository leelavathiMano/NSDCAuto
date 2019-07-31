package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.CandidateRegistrationPage;
import com.nsdc.pages.Candidate_DashboardPage;
import com.nsdc.pages.Candidate_ProfilePage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.testConfig.TestConfiguration;

public class CandidateRegistrationWorkflowTestSC_05  extends TestConfiguration
{
	@DataProvider
	public Object[][] candidateProfileData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Candidate-Workflow.xls", "CandidateProfileSC11TC01");
	}
	
	@Test(dataProvider="candidateProfileData")
	public void candidateRegistrationTC_01(String sno, String userType, String candidateName, String guardianName, String gender, String email, String mobileNumber, String education, String pincode, String state, String district, String sector, String subSector, String jobRole, String associateProgram, String profilePicture, String cioType, String cioName, String candidateID, String passwordID, String newPassword, String confirmPassword, String prefix, String uploadFilePath, String guardianRelation, String aadharNumber, String idtype, String idNumber, String upload_idFile, String category, String religion, String disablity, String disablityType, String upload_DisablityFile, String address, String landmark, String tehsil, String villageORCity, String parliamentryConstituency, String educationName, String firstPassingYear, String firstSpecialization, String firstEducationFile, String secondEducation, String secondPassingYear, String secondSpecialization, String secondEducationFile, String thirdEducation, String thirdPassingYear, String thirdSpecialization, String thirdEducationFile, String hearFromWhere, String secondSector, String secondSubSector, String secondJobRole, String thirdSector, String thirdSubSector, String thirdJobRole, String identificationType, String otherIdentityType, String accountHolderName, String accountNumber, String ifsc, String bankName, String bankAddress) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		//lp.clickLogin();
		lp.clickRegister();
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.selectDropdownList(userType);
		
		CandidateRegistrationPage crp = new  CandidateRegistrationPage(driver);
		Thread.sleep(3000);
		crp.enterCandidateFullName(candidateName);
		Thread.sleep(3000);
		crp.enterGuardianName(guardianName);
		Thread.sleep(3000);
		crp.clickOnDateOfBirthField();
		String dob = driver.findElement(By.xpath("//input[@id='dob']")).getAttribute("value");
		crp.selectGender(gender);
		crp.enterCandidateEmailAddress(email);
		crp.enterCandidateMobileNumber(mobileNumber);
		crp.selectEducationLevel(education);
		crp.enterLocation_PinCode(pincode);
		
		Thread.sleep(3000);
		crp.selectState_Location(state);
		crp.selectDistrict_Location(district);
		//crp.enterGeoTag(district);
		crp.selectForSector(sector);
		crp.selectForSubSector(subSector);
		crp.selectCandidate_JobRole(jobRole);
		crp.selectAssociateProgramName(associateProgram);
		if(associateProgram.equals("Counselling"))
		{
			Thread.sleep(3000);
			crp.clickOnUploadProfilePicture();
			Thread.sleep(3000);
			UploadFile.upload(profilePicture);
			Thread.sleep(3000);
			crp.selectCIOType(cioType);
			String cIOType = driver.findElement(By.xpath("//select[@formcontrolname='cioType']")).getText();
			ReadWriteData.setExcelData("./TestData/Workflow/Candidate-Workflow.xls", "CandidateProfileSC11TC01", Integer.parseInt(sno), 16, cIOType);		
			crp.selectCIOName(cioName);
			String cIOName = driver.findElement(By.xpath("//select[@formcontrolname='cioName']")).getText();
			ReadWriteData.setExcelData("./TestData/Workflow/Candidate-Workflow.xls", "CandidateProfileSC11TC01", Integer.parseInt(sno), 17, cIOName);
			Thread.sleep(3000);
			crp.clickOnIntrestedInPMKVYTraining();
			crp.clickOnIAgree();
			Thread.sleep(5000);
			crp.clickForSubmit();
			
		}
		else
		{
			Thread.sleep(3000);
			crp.clickOnIntrestedInPMKVYTraining();
			crp.clickOnIAgree();
			Thread.sleep(5000);
			crp.clickForSubmit();
			
		}
		
		String username = driver.findElement(By.xpath("(//h2/b)[1]")).getText();
		candidateID = username.replace("Candidate Id - ", "");
		ReadWriteData.setExcelData("./TestData/Workflow/Candidate-Workflow.xls", "CandidateProfileSC11TC01", Integer.parseInt(sno), 18, candidateID);
		String password = driver.findElement(By.xpath("(//h2/b)[2]")).getText();
		passwordID = password.replace("Password - ", "");
		ReadWriteData.setExcelData("./TestData/Workflow/Candidate-Workflow.xls", "CandidateProfileSC11TC01", Integer.parseInt(sno), 19, passwordID);
		crp.clickOnOK();
		Thread.sleep(3000);
		crp.clickForClose();
		Thread.sleep(3000);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(candidateID, passwordID);
		rp.enterOldPassword(passwordID);
		rp.enterNewPassword(newPassword);
		rp.enterConfirmPassword(confirmPassword);
		Thread.sleep(3000);
		rp.clickResetResubmit();
		rp.clickConfirmationOkMessage();
		Thread.sleep(3000);
		//BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
		elp.performlogin(candidateID, confirmPassword);
		
		Candidate_DashboardPage cd = new Candidate_DashboardPage(driver);
		Thread.sleep(3000);
		cd.clickOnMyProfile();
		
		Candidate_ProfilePage cpp = new Candidate_ProfilePage(driver);
		cpp.selectNamePrefix(prefix);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), candidateName);
		Thread.sleep(3000);
		cpp.clickOnBrowseFileForProfilePicture();
		Thread.sleep(3000);
		UploadFile.upload(uploadFilePath);
		Thread.sleep(3000);
		cpp.clickOnUploadFileForProfilePicture();
		Assert.assertEquals(driver.findElement(By.xpath("//select[@id='gender']")).getAttribute("value").substring(3), gender);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Date of Birth']")).getAttribute("value"), dob);
		cpp.selectRelationWithGuardian(guardianRelation);
		cpp.enterGuardianName(guardianName);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parentName']")).getAttribute("value"), guardianName);
//		Thread.sleep(3000);
//		cpp.enterAadharNumber(aadharNumber);
//		cpp.clickOnVerify();
//		Thread.sleep(30000);
//		cpp.selectAlternateID_Type(idtype);
//		Thread.sleep(4000);
//		cpp.enterAlternateID_Number(idNumber);
//		cpp.clickOnBrowseFileForIDProofCopy();
//		Thread.sleep(3000);
//		UploadFile.upload(upload_idFile);
//		Thread.sleep(3000);
//		cpp.clickOnUploadFileForIDProofCopy();
		cpp.selectCategory(category);
		cpp.selectReligion(religion);
		cpp.selectDisablity(disablity);
		if(disablity.equals("Yes")) 
		{
			cpp.selectDisablityType(disablityType);
			Thread.sleep(5000);
//			cpp.clickOnBrowseFileForDisablitySupportingDocument();
//			Thread.sleep(3000);
//			UploadFile.upload(upload_DisablityFile);
//			Thread.sleep(3000);
//			cpp.clickOnUploadFileForDisblitySupportingDocument();
			cpp.clickOnBrowseFileDisablitySupportingDocument();
			Thread.sleep(3000);
			UploadFile.upload(upload_DisablityFile);
			Thread.sleep(3000);
			cpp.clickOnUploadFileDisblitySupportingDocument();
//			Thread.sleep(5000);
//			cpp.clickOnSaveAndNext();
		}
		
//		else 
//		{
//			Thread.sleep(5000);
//			cpp.clickOnSaveAndNext();
//		}
		
		if(identificationType.equals("Aadhar"))
		{
			Thread.sleep(5000);
			cpp.clickOnAadhar();
			cpp.enter_AadharNumber(aadharNumber);
			cpp.clickOnVerify();
			Thread.sleep(15000);
		}
		else
		{
			Thread.sleep(5000);
			cpp.clickOnAlternateID();
			cpp.selectAlternateIDType(idtype);
			if(idtype.equals("Other"))
			{
				cpp.enterOtherIdentityType(otherIdentityType);
			}
			cpp.enterAlternateIDNumber(idNumber);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0, 900)");
			Thread.sleep(8000);
			cpp.clickOnBrowseFileForAlternateIDProofCopy();
			Thread.sleep(3000);
			UploadFile.upload(upload_idFile);
			Thread.sleep(3000);
			cpp.clickOnUploadFileForAlternateIDProofCopy();
		}
		
		Thread.sleep(5000);
		cpp.clickOnSaveAndNext();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='phone']")).getAttribute("value"), mobileNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), email);
		Thread.sleep(3000);
		cpp.enterPermanent_AddressTextbox(address);
		cpp.enterPermanent_NearByLandmark(landmark);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@id='pincode'])[1]")).getAttribute("value"), pincode);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='state'])[1]")).getAttribute("value").substring(3).replace(" ", ""), state.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='district'])[1]")).getAttribute("value").substring(3).replace(" ", ""), district.replace(" ", ""));
		Thread.sleep(3000);
		cpp.selectPermanent_TehsilOrBlock(tehsil);
		Thread.sleep(2000);
		cpp.selectPermanent_VillageOrCity(villageORCity);
		Thread.sleep(2000);
		cpp.selectPermanent_ParliamentryConstituency(parliamentryConstituency);
		Thread.sleep(3000);
		cpp.clickOnSameAsPermanentAddressCheckBox();
		Assert.assertEquals(driver.findElement(By.xpath("(//textarea[@id='address1'])[2]")).getAttribute("value"), address);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@id='landmark'])[2]")).getAttribute("value"), landmark);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@id='pincode'])[2]")).getAttribute("value"), pincode);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='state'])[2]")).getAttribute("value").substring(3).replace(" ", ""), state.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='district'])[2]")).getAttribute("value").substring(3).replace(" ", ""), district.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='tehsil'])[2]")).getAttribute("value").substring(3).replace(" ", ""), tehsil.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='city'])[2]")).getAttribute("value").substring(3).replace(" ", "").replace(":", ""), villageORCity.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='parliamentaryConstituency'])[2]")).getAttribute("value").substring(3).replace(" ", ""), parliamentryConstituency.replace(" ", ""));
		
		Thread.sleep(3000);
		cpp.enterAccountHolderName(accountHolderName);
		cpp.enterAccountNumber(accountNumber);
		cpp.enterIFSC(ifsc);
		cpp.enterBankName(bankName);
		cpp.enterBankAddress(bankAddress);
		
		Thread.sleep(5000);
		cpp.clickOnSaveAndNext();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='education'])[1]")).getAttribute("value").substring(3).replace(" ", ""), education.replace(" ", ""));
		Thread.sleep(5000);
		if(education.equals("Others"))
		{
			cpp.enterOthers_EducationName(educationName);
			cpp.selectYearOfPassing(firstPassingYear);
			cpp.enterSpecialization(firstSpecialization);
			Thread.sleep(3000);
			cpp.clickOnBrowseFileForSpecializationSupportDocument();
			Thread.sleep(3000);
			UploadFile.upload(firstEducationFile);
			Thread.sleep(3000);
			cpp.clickOnUploadFileForSpecializationSupportDocument();
			Thread.sleep(4000);
		}
		else
		{
			cpp.selectYearOfPassing(firstPassingYear);
			cpp.enterSpecialization(firstSpecialization);
			Thread.sleep(3000);
			cpp.clickOnBrowseFileForSpecializationSupportDocument();
			Thread.sleep(3000);
			UploadFile.upload(firstEducationFile);
			Thread.sleep(3000);
			cpp.clickOnUploadFileForSpecializationSupportDocument();
			Thread.sleep(4000);
		}
		cpp.clickOnAddEducationDetails();
		cpp.select_SecondEduation(secondEducation);
		if(secondEducation.equals("Others"))
		{
			cpp.enterOthers_EducationName(educationName);
			cpp.select_SecondYearOfPassing(secondPassingYear);
			cpp.enter_SecondSpecialization(secondSpecialization);
			Thread.sleep(3000);
			cpp.clickOn_SecondBrowseFileForSpecializationSupportDocument();
			Thread.sleep(3000);
			UploadFile.upload(secondEducationFile);
			Thread.sleep(3000);
			cpp.clickOn_SecondUploadFileForSpecializationSupportDocument();
			Thread.sleep(4000);
		}
		else
		{
			cpp.select_SecondYearOfPassing(secondPassingYear);
			cpp.enter_SecondSpecialization(secondSpecialization);
			Thread.sleep(3000);
			cpp.clickOn_SecondBrowseFileForSpecializationSupportDocument();
			Thread.sleep(3000);
			UploadFile.upload(secondEducationFile);
			Thread.sleep(3000);
			cpp.clickOn_SecondUploadFileForSpecializationSupportDocument();
			Thread.sleep(4000);
		}
		
		cpp.clickOnAddEducationDetails();
		Thread.sleep(3000);
		cpp.select_ThirdEduation(thirdEducation);
		if(thirdEducation.equals("Others"))
		{
			cpp.enterOthers_EducationName(educationName);
			cpp.select_ThirdYearOfPassing(thirdPassingYear);
			cpp.enter_ThirdSpecialization(thirdSpecialization);
			Thread.sleep(3000);
			cpp.clickOn_ThirdBrowseFileForSpecializationSupportDocument();
			Thread.sleep(3000);
			UploadFile.upload(thirdEducationFile);
			Thread.sleep(3000);
			cpp.clickOn_ThirdUploadFileForSpecializationSupportDocument();
			Thread.sleep(5000);
		}
		else
		{
			cpp.select_ThirdYearOfPassing(thirdPassingYear);
			cpp.enter_ThirdSpecialization(thirdSpecialization);
			Thread.sleep(3000);
			cpp.clickOn_ThirdBrowseFileForSpecializationSupportDocument();
			Thread.sleep(3000);
			UploadFile.upload(thirdEducationFile);
			Thread.sleep(3000);
			cpp.clickOn_ThirdUploadFileForSpecializationSupportDocument();
			Thread.sleep(5000);
		}
		Thread.sleep(10000);
		cpp.clickOnSaveAndNext();
		cpp.selectFromWhereYouHear(hearFromWhere);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='sector'])[1]")).getAttribute("value"), sector);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='subSector'])[1]")).getAttribute("value"), subSector);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='jobRole'])[1]")).getAttribute("value").substring(3).replace(" ", "").replace(":", ""), jobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='jobRole'])[1]")).getAttribute("value"), jobRole);

		Thread.sleep(3000);
		cpp.clickOnAddAnotherPrefrences();
		cpp.selectSecond_Sector(secondSector);
		cpp.selectSecond_SubSector(secondSubSector);
		cpp.selectSecond_JobRole(secondJobRole);
		Thread.sleep(3000);
		cpp.clickOnAddAnotherPrefrences();
		Thread.sleep(3000);
		cpp.selectThird_Sector(thirdSector);
		cpp.selectThird_SubSector(thirdSubSector);
		cpp.selectThird_JobRole(thirdJobRole);
		Thread.sleep(5000);
		cpp.clickOnSaveAndNext();
		
		Thread.sleep(3000);
		cpp.clickOnIAgree();
		
		Thread.sleep(4000);
		cpp.clickOnAgreeAndSave();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Candidate Registration - Success')]")).getText(), "Candidate Registration - Success");
		Thread.sleep(3000);
		cpp.clickOnClose();
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
					
	}
	

}
