package com.nsdc.regressionTest;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.CandidateRegistrationPage;
import com.nsdc.pages.Candidate_DashboardPage;
import com.nsdc.pages.Candidate_ProfilePage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.testConfig.TestConfiguration;

public class CandidateRegistrationWorkflowTestSC_11 extends TestConfiguration
{
	@DataProvider
	public Object[][] candidateProfileData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Candidate-Workflow.xls", "CandidateProfileSC11TC01");
	}
	
	@Test(dataProvider="candidateProfileData")
	public void candidateRegistrationTC_01(String sno, String userType, String candidateName, String guardianName, String gender, String email, String mobileNumber, String education, String pincode, String state, String district, String sector, String subSector, String jobRole, String candidateID, String passwordID, String newPassword, String confirmPassword, String prefix, String uploadFilePath, String guardianRelation, String idtype, String idNumber, String upload_idFile, String category, String religion, String disablity, String disablityType, String upload_DisablityFile, String address, String parliamentryConstituency, String subDistrict, String villageORCity, String firstPassingYear, String firstSpecialization, String firstEducationFile, String secondEducation, String secondPassingYear, String secondSpecialization, String secondEducationFile, String thirdEducation, String thirdPassingYear, String thirdSpecialization, String thirdEducationFile, String hearFromWhere, String secondSector, String secondSubSector, String secondJobRole, String thirdSector, String thirdSubSector, String thirdJobRole) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		//lp.clickLogin();
		lp.clickRegister();
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.selectDropdownList(userType);
		
		CandidateRegistrationPage crp = new  CandidateRegistrationPage(driver);
		crp.enterCandidateFullName(candidateName);
		crp.enterGuardianName(guardianName);
		crp.clickOnDateOfBirthField();
		String dob = driver.findElement(By.xpath("//input[@formcontrolname='dob']")).getAttribute("value");
		crp.selectGender(gender);
		crp.enterCandidateEmailAddress(email);
		crp.enterCandidateMobileNumber(mobileNumber);
		crp.selectEducationLevel(education);
		crp.enterLocation_PinCode(pincode);
		Thread.sleep(2000);
		crp.selectState_Location(state);
		crp.selectDistrict_Location(district);
		crp.selectForSector(sector);
		crp.selectForSubSector(subSector);
		crp.selectCandidate_JobRole(jobRole);
		Thread.sleep(4000);
		crp.clickForSubmit();
		String username = driver.findElement(By.xpath("(//h2/b)[1]")).getText();
		candidateID = username.replace("Candidate Id - ", "");
		ReadWriteData.setExcelData("./TestData/Workflow/Candidate-Workflow.xls", "CandidateProfileSC11TC01", Integer.parseInt(sno), 14, candidateID);
		String password = driver.findElement(By.xpath("(//h2/b)[2]")).getText();
		passwordID = password.replace("Password - ", "");
		ReadWriteData.setExcelData("./TestData/Workflow/Candidate-Workflow.xls", "CandidateProfileSC11TC01", Integer.parseInt(sno), 15, passwordID);
		crp.clickOnOK();
		
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(candidateID, passwordID);
		rp.enterOldPassword(passwordID);
		rp.enterNewPassword(newPassword);
		rp.enterConfirmPassword(confirmPassword);
		rp.clickResetResubmit();
		rp.clickConfirmationOkMessage();
		Thread.sleep(2000);
		elp.performlogin(candidateID, confirmPassword);
		
		Candidate_DashboardPage cd = new Candidate_DashboardPage(driver);
		Thread.sleep(2000);
		cd.clickOnMyProfile();
		
		Candidate_ProfilePage cpp = new Candidate_ProfilePage(driver);
		cpp.selectNamePrefix(prefix);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).getAttribute("value"), candidateName);
		Thread.sleep(2000);
		cpp.clickOnBrowseFileForProfilePicture();
		Thread.sleep(2000);
		UploadFile.upload(uploadFilePath);
		Thread.sleep(2000);
		cpp.clickOnUploadFileForProfilePicture();
		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='gender']")).getAttribute("value"), gender);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='dob']")).getAttribute("value"), dob);
		cpp.selectRelationWithGuardian(guardianRelation);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='guardianName']")).getAttribute("value"), guardianName);
		cpp.selectAlternateID_Type(idtype);
		Thread.sleep(8000);
		cpp.enterAlternateID_Number(idNumber);
		cpp.clickOnBrowseFileForIDProofCopy();
		Thread.sleep(2000);
		UploadFile.upload(upload_idFile);
		Thread.sleep(2000);
		cpp.clickOnUploadFileForIDProofCopy();
		cpp.selectCategory(category);
		cpp.selectReligion(religion);
		cpp.selectDisablity(disablity);
		if(disablity.equals("Yes")) 
		{
			cpp.selectDisablityType(disablityType);
			Thread.sleep(3000);
			cpp.clickOnBrowseFileForDisablitySupportingDocument();
			Thread.sleep(2000);
			UploadFile.upload(upload_DisablityFile);
			Thread.sleep(2000);
			cpp.clickOnUploadFileForDisblitySupportingDocument();
		}
		Thread.sleep(3000);
		cpp.clickOnSaveAndNext();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='phone']")).getAttribute("value"), mobileNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='email']")).getAttribute("value"), email);
		Thread.sleep(2000);
		cpp.enterPermanent_AddressTextbox(address);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='pinCode'])[1]")).getAttribute("value"), pincode);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='state'])[1]")).getAttribute("value").substring(3).replace(" ", ""), state.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='district'])[1]")).getAttribute("value").substring(3).replace(" ", ""), district.replace(" ", ""));
		cpp.selectPermanent_ParliamentryConstituency(parliamentryConstituency);
		cpp.selectPermanent_SubDistrict(subDistrict);
		cpp.selectPermanent_VillageOrCity(villageORCity);
		cpp.clickOnSameAsPermanentAddressCheckBox();
		Assert.assertEquals(driver.findElement(By.xpath("(//textarea[@formcontrolname='address1'])[2]")).getAttribute("value"), address);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='pinCode'])[2]")).getAttribute("value"), pincode);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='state'])[2]")).getAttribute("value").substring(3).replace(" ", ""), state.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='district'])[2]")).getAttribute("value").substring(3).replace(" ", ""), district.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='parliamentaryConstituency'])[2]")).getAttribute("value").substring(3).replace(" ", ""), parliamentryConstituency.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='subDistrict'])[2]")).getAttribute("value").substring(3).replace(" ", ""), subDistrict.replace(" ", ""));
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='city'])[2]")).getAttribute("value").substring(3).replace(" ", ""), villageORCity.replace(" ", ""));
		Thread.sleep(2000);
		cpp.clickOnSaveAndNext();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='education'])[1]")).getAttribute("value").substring(3).replace(" ", ""), education.replace(" ", ""));
		Thread.sleep(5000);
		cpp.selectYearOfPassing(firstPassingYear);
		cpp.enterSpecialization(firstSpecialization);
		Thread.sleep(2000);
		cpp.clickOnBrowseFileForSpecializationSupportDocument();
		Thread.sleep(2000);
		UploadFile.upload(firstEducationFile);
		Thread.sleep(2000);
		cpp.clickOnUploadFileForSpecializationSupportDocument();
		Thread.sleep(2000);
		cpp.clickOnAddEducationDetails();
		cpp.select_SecondEduation(secondEducation);
		cpp.select_SecondYearOfPassing(secondPassingYear);
		cpp.enter_SecondSpecialization(secondSpecialization);
		Thread.sleep(2000);
		cpp.clickOn_SecondBrowseFileForSpecializationSupportDocument();
		Thread.sleep(2000);
		UploadFile.upload(secondEducationFile);
		Thread.sleep(2000);
		cpp.clickOn_SecondUploadFileForSpecializationSupportDocument();
		Thread.sleep(2000);
		cpp.clickOnAddEducationDetails();
		Thread.sleep(2000);
		cpp.select_ThirdEduation(thirdEducation);
		cpp.select_ThirdYearOfPassing(thirdPassingYear);
		cpp.enter_ThirdSpecialization(thirdSpecialization);
		Thread.sleep(2000);
		cpp.clickOn_ThirdBrowseFileForSpecializationSupportDocument();
		Thread.sleep(2000);
		UploadFile.upload(thirdEducationFile);
		Thread.sleep(2000);
		cpp.clickOn_ThirdUploadFileForSpecializationSupportDocument();
		Thread.sleep(4000);
		cpp.clickOnSaveAndNext();
		cpp.selectFromWhereYouHear(hearFromWhere);
		Thread.sleep(2000);
		//Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='sectorObj']")).getText(), sector);
		//Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='subSectorObj']")), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='jobRole']")).getAttribute("value").substring(3).replace(" ", ""), jobRole.replace(" ", ""));
		Thread.sleep(2000);
		cpp.clickOnAddAnotherPrefrences();
		cpp.selectSecond_Sector(secondSector);
		cpp.selectSecond_SubSector(secondSubSector);
		cpp.selectSecond_JobRole(secondJobRole);
		Thread.sleep(2000);
		cpp.clickOnAddAnotherPrefrences();
		Thread.sleep(2000);
		cpp.selectThird_Sector(thirdSector);
		cpp.selectThird_SubSector(thirdSubSector);
		cpp.selectThird_JobRole(thirdJobRole);
		Thread.sleep(2000);
		cpp.clickOnSaveAndNext();
		Thread.sleep(4000);
		cpp.clickOn_SecondAgreeAndSave();
		Thread.sleep(2000);
		cpp.clickOnClose();
					
	}
	

}
