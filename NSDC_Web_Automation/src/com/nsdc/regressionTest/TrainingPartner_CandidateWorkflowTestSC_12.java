package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
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

public class TrainingPartner_CandidateWorkflowTestSC_12 extends TestConfiguration
{
	@DataProvider
	public Object[][] candidateRegistrationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TrainingPartner_Candidate-Workflow.xls", "CandidateRegistration");
	}
	
	@Test(dataProvider="candidateRegistrationData")
	public void candidateRegistrationTC_01(String serialNum, String createdCandidateID, String trainingPartnerID, String trainingPartnerPassword, String typeOfRegistration, String bulkExcelFile, String namePrefix, String fullName, String profilePicture, String gender, String dob, String guardianRelation, String guardianname, String maritalStatus, String placeOfBirth, String cast, String religion, String isDisabled, String disablity, String disabilityProofDoc, String address, String village, String state, String district, String subDistrict, String pincode, String parlimentaryConstituency, String identificationType, String identificationIDnumber, String identificationProof, String isCommunicationAddressSameAsPermanentAddress, String cAddress, String cVillage, String cState, String cDistrict, String cSubDistrict, String cPincode, String cParlimentaryConstituency, String education1, String specialisation1, String yearOfPassing1, String education1Proof, String education2, String specialisation2, String othersEducationName, String yearOfPassing2, String education2Proof, String education3, String specialisation3, String yearOfPassing3, String education3Proof , String hearAboutUs, String sector1, String subSector1, String jobRole1, String sector2, String subSector2, String jobRole2, String sector3, String subSector3, String jobRole3) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(trainingPartnerID, trainingPartnerPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingpartner","Login Unsuccessfull");
		TrainingPartnerDashboardPage tDp=new TrainingPartnerDashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		tDp.clickMyCandidates();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingpartnercandidatesregistered","OMG!!! navigation to My Candidates page is unsuccessfull OR something is wrong! ");
		Thread.sleep(4000);
		TrainingPartner_MyCandidatesPage tpMp=new TrainingPartner_MyCandidatesPage(driver);
		tpMp.clickRegisterCandidate();
		Thread.sleep(2000);
		if(typeOfRegistration.equalsIgnoreCase("individual"))
		{
			tpMp.clickToChooseIndividualCandidateRegistration();
			Thread.sleep(2000);
			tpMp.clickRegister();
			Thread.sleep(4000);
			//Personal Details Page
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationpersonal-details","OMG!!! navigation to Individual Candidate Registration Personal Details page is unsuccessfull OR something is wrong! ");
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
			tpCrp.clickToChooseGender(gender);
			Thread.sleep(4000);
			tpCrp.clickToSelectDOB();
			Thread.sleep(4000);
			String selectedDateOfBirth=driver.findElement(By.id("dob")).getAttribute("value");
	        ReadWriteData.setExcelData("./TestData/Workflow/TrainingPartner_Candidate-Workflow.xls", "CandidateRegistration", Integer.parseInt(serialNum), 10, selectedDateOfBirth);
	        tpCrp.selectRelationWithGuardian(guardianRelation);
			Thread.sleep(2000);
			tpCrp.enterGuardianName(guardianname);
			Thread.sleep(2000);
			tpCrp.selectMaritalStatus(maritalStatus);
			Thread.sleep(2000);
			tpCrp.enterPlaceOfBirth(placeOfBirth);
			Thread.sleep(2000);
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
				Thread.sleep(8000);
			}
			else if(isDisabled.equalsIgnoreCase("no"))
			{
				tpCrp.clickDisabilityNo();
			}
			Thread.sleep(4000);
			tpCrp.enterAddress(address);
			Thread.sleep(4000);
			tpCrp.selectState(state);
			Thread.sleep(2000);
			tpCrp.selectDistrict(district);
			Thread.sleep(2000);
			tpCrp.selectSubDistrict(subDistrict);
			Thread.sleep(4000);
			tpCrp.selectVillage(village);
			Thread.sleep(4000);
			tpCrp.enterPincode(pincode);
			Thread.sleep(2000);
			tpCrp.selectParlimentaryConstituency(parlimentaryConstituency);
			Thread.sleep(4000);
			tpCrp.clickSaveAndContinue();
			Thread.sleep(8000);
			//Contact Details Page
			//Assert.assertFalse(driver.getCurrentUrl().contains("CAN_"),"OMG!!! Candidate Has been Registered before submitting registration form!!! ");
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationcontact-details"),"OMG!!! navigation to Contact Details page is unsuccessfull OR something is wrong! ");
			tpCrp.selectIdentificationType(identificationType);
			Thread.sleep(4000);
			tpCrp.enterIdentificationIDNumber(identificationIDnumber);
			Thread.sleep(4000);
			tpCrp.clickToBrowseIdentificationProofDoc();
			Thread.sleep(4000);
			UploadFile.upload(identificationProof);
			Thread.sleep(4000);
			tpCrp.clickToUploadIdentificationProofDoc();
			Thread.sleep(8000);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='alternateIdNumber']")).getAttribute("value").trim(), identificationIDnumber);
			if(isCommunicationAddressSameAsPermanentAddress.equalsIgnoreCase("yes"))
			{
				tpCrp.clickSameAsPermanetAddress();
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='address1']")).getAttribute("value").trim(), address);
				Select selectedVillage=new Select(driver.findElement(By.xpath("//select[@formcontrolname='city']")));
				Assert.assertEquals(selectedVillage.getFirstSelectedOption().getText().trim(), village);
				Select selectedState=new Select(driver.findElement(By.xpath("//select[@formcontrolname='state']")));
				Assert.assertEquals(selectedState.getFirstSelectedOption().getText().trim(), state);
				Select selectedDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='district']")));
				Assert.assertEquals(selectedDistrict.getFirstSelectedOption().getText().trim(), district);
				Select selectedSubDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='subDistrict']")));
				Assert.assertEquals(selectedSubDistrict.getFirstSelectedOption().getText().trim(), subDistrict);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='pinCode']")).getAttribute("value").trim(), pincode);
				Select selectedParlimentaryConstituency=new Select(driver.findElement(By.xpath("//select[@formcontrolname='parliamentaryConstituency']")));
				Assert.assertEquals(selectedParlimentaryConstituency.getFirstSelectedOption().getText().trim(), parlimentaryConstituency);
			}
			else if(isCommunicationAddressSameAsPermanentAddress.equalsIgnoreCase("no"))
			{
				tpCrp.enterAddress(cAddress);
				Thread.sleep(4000);
				tpCrp.selectState(cState);
				Thread.sleep(2000);
				tpCrp.selectDistrict(cDistrict);
				Thread.sleep(2000);
				tpCrp.selectSubDistrict(cSubDistrict);
				Thread.sleep(4000);
				tpCrp.selectVillage(cVillage);
				Thread.sleep(4000);
				tpCrp.enterPincode(cPincode);
				Thread.sleep(2000);
				tpCrp.selectParlimentaryConstituency(cParlimentaryConstituency);
				Thread.sleep(2000);
			}
			tpCrp.clickSaveAndContinue();
			Thread.sleep(8000);
			//Education Details Page
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationeducation-details"),"OMG!!! navigation to Education Details page is unsuccessfull OR something is wrong! ");
			if(education1.equalsIgnoreCase("uneducated"))
			{
				Thread.sleep(2000);
				tpCrp.selectEducation(education1);
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//label[contains(text(),'Specialisation')]")).size()==0,"OMG!!! Education Details Fields should be hidden in case of uneducated candidate OR Something went wring! ");
				Assert.assertTrue(driver.findElements(By.xpath("//button[contains(text(),'Add Education Details')]")).size()==0,"OMG!!! Add Education Details button should be hidden in case of uneducated candidate OR Something went wrong! ");
			}
			else
			{
				Thread.sleep(2000);
				tpCrp.selectEducation(education1);
				Thread.sleep(2000);
				tpCrp.enterSpecialisation(specialisation1);
				Thread.sleep(2000);
				tpCrp.selectYearOfPassing(yearOfPassing1);
				Thread.sleep(2000);
				tpCrp.clickToBrowseEducationProofDoc();
				Thread.sleep(4000);
				UploadFile.upload(education1Proof);
				Thread.sleep(4000);
				tpCrp.clickToUploadEducationProof();
				Thread.sleep(8000);
				//Second Education Record
				Thread.sleep(2000);
				tpCrp.clickToAddOneMoreEducationRecord();
				Thread.sleep(4000);
				tpCrp.seelctSecondEducation(education2);
				Thread.sleep(4000);
				tpCrp.enterSecondSpecialisation(specialisation2);
				Thread.sleep(4000);
				tpCrp.enterEducationNameInCaseOFOthers(othersEducationName);
				Thread.sleep(4000);
				tpCrp.selectSecondYearOfPassing(yearOfPassing2);
				Thread.sleep(4000);
				tpCrp.clickToBrowseSecondEducationProof();
				Thread.sleep(4000);
				UploadFile.upload(education2Proof);
				Thread.sleep(4000);
				tpCrp.clickToUploadSecondEducationProof();
				Thread.sleep(8000);
				//Third Education Record
				tpCrp.clickToAddOneMoreEducationRecord();
				Thread.sleep(4000);
				tpCrp.selectThirdEducation(education3);
				Thread.sleep(4000);
				tpCrp.enterThirdSpecialisation(specialisation3);
				Thread.sleep(4000);
				tpCrp.selectThirdYearOfPassing(yearOfPassing3);
				Thread.sleep(4000);
				tpCrp.clickToBrowseThirdEducationProof();
				Thread.sleep(4000);
				UploadFile.upload(education3Proof);
				Thread.sleep(8000);
				tpCrp.clickToUploadThirdEducationProof();
				Thread.sleep(5000);
				//Removing added third Education record
				tpCrp.clickToRemoveAddedThirdEducationRecord();
				Thread.sleep(4000);
				Assert.assertTrue(driver.findElements(By.xpath("(//select[@formcontrolname='education'])[3]")).size()==0,"OMG!!! Removed third education record fields present OR Something is wrong! ");
				Assert.assertTrue(driver.findElements(By.xpath("(//select[@formcontrolname='education'])[2]")).size()==1,"OMG!!! Added Second Education Record not present OR Something is wrong! ");
				Assert.assertTrue(driver.findElements(By.xpath("(//select[@formcontrolname='education'])[1]")).size()==1,"OMG!!! Added First Education Record not present OR Something is wrong! ");
			}
			Thread.sleep(2000);
			tpCrp.clickSaveAndContinue();
			Thread.sleep(8000);
			//Course Preferences Page
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationcourse-preferences"),"OMG!!! navigation to Course Preference page is unsuccessfull OR something is wrong! ");
			Thread.sleep(2000);
			tpCrp.selectHearAboutUs(hearAboutUs);
			Thread.sleep(4000);
			tpCrp.selectSector(sector1);
			Thread.sleep(4000);
			tpCrp.selectSubSector(subSector1);
			Thread.sleep(4000);
			tpCrp.selectJobRole(jobRole1);
			Thread.sleep(4000);
			//Second Preference
			tpCrp.clickToAddAnotherPreference();
			Thread.sleep(4000);
			tpCrp.selectSecondSector(sector2);
			Thread.sleep(2000);
			tpCrp.selectSecondSubSector(subSector2);
			Thread.sleep(2000);
			tpCrp.selectSecondJobRole(jobRole2);
			Thread.sleep(2000);
			//Third Preference
			tpCrp.clickToAddAnotherPreference();
			Thread.sleep(4000);
			tpCrp.selectThirdSector(sector3);
			Thread.sleep(2000);
			tpCrp.selectThirdSubSector(subSector3);
			Thread.sleep(2000);
			tpCrp.selectThirdJobRole(jobRole3);
			Thread.sleep(2000);
			//Removing Third Preference
			tpCrp.clickToRemoveAddedThirdPreference();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElements(By.xpath("(//select[@formcontrolname='sector'])[3]")).size()==0,"OMG!!! Removed Third preference Still Present OR Something is wrong! ");
			tpCrp.clickSaveAndContinue();
			Thread.sleep(8000);
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationdeclaration"),"OMG!!! navigation to Declaration page is unsuccessfull OR something is wrong! ");
			//Declaration Page -> Review Feature -> Verification OF Entered Data
			tpCrp.clickToReviewBeforeSubmission();
			Thread.sleep(8000);
			//Personal Details Review PAge
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationpersonal-details"),"OMG!!! navigation to Personal Details Review Page is unsuccessfull OR something is wrong! ");
			Select selectedNamePrefix=new Select(driver.findElement(By.xpath("//select[@formcontrolname='namePrefix']")));
			Assert.assertEquals(selectedNamePrefix.getFirstSelectedOption().getText(),namePrefix);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).getAttribute("value"), fullName);
			Assert.assertEquals(driver.findElement(By.xpath("//label[@class='custom-file-label ']/span")).getText().trim(), profilePicture);
			Assert.assertTrue(driver.findElement(By.xpath("//input[@value='"+gender+"']")).isSelected());
			Assert.assertEquals(driver.findElement(By.id("dob")).getAttribute("value"), selectedDateOfBirth);
			Select selectedGuardianRelation=new Select(driver.findElement(By.xpath("//select[@formcontrolname='relationWithGuardian']")));
			Assert.assertEquals(selectedGuardianRelation.getFirstSelectedOption().getText(),guardianRelation);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='guardianName']")).getAttribute("value").trim(), guardianname);
			Select selectedMaritalstatus=new Select(driver.findElement(By.xpath("//select[@formcontrolname='maritialStatus']")));
			Assert.assertEquals(selectedMaritalstatus.getFirstSelectedOption().getText(), maritalStatus);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='placeOfBirth']")).getAttribute("value"), placeOfBirth);
			if(isDisabled.equalsIgnoreCase("yes"))
			{
				Assert.assertTrue(driver.findElement(By.xpath("(//input[@formcontrolname='differentlyAbled'])[1]")).isSelected());
				Select selectedDisability=new Select(driver.findElement(By.xpath("//select[@formcontrolname='disabilityCategory']")));
				Assert.assertEquals(selectedDisability.getFirstSelectedOption().getText(), disablity);
				Assert.assertEquals(driver.findElement(By.xpath("(//label[@class='custom-file-label ']/span)[2]")).getText().trim(), disabilityProofDoc);
			}
			else
			{
				Assert.assertTrue(driver.findElement(By.xpath("(//input[@formcontrolname='differentlyAbled'])[2]")).isSelected());
			}
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='address1']")).getAttribute("value"), address);
			Select selectedVillage=new Select(driver.findElement(By.xpath("//select[@formcontrolname='city']")));
			Assert.assertEquals(selectedVillage.getFirstSelectedOption().getText(), village);
			Select selectedState=new Select(driver.findElement(By.xpath("//select[@formcontrolname='state']")));
			Assert.assertEquals(selectedState.getFirstSelectedOption().getText(), state);
			Select selectedDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='district']")));
			Assert.assertEquals(selectedDistrict.getFirstSelectedOption().getText(), district);
			Select selectedSubDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='subDistrict']")));
			Assert.assertEquals(selectedSubDistrict.getFirstSelectedOption().getText(), subDistrict);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='pinCode']")).getAttribute("value"), pincode);
			Select selectedParlimentaryConstituency=new Select(driver.findElement(By.xpath("//select[@formcontrolname='parliamentaryConstituency']")));
			Assert.assertEquals(selectedParlimentaryConstituency.getFirstSelectedOption().getText(), parlimentaryConstituency);
			tpCrp.clickSaveAndContinue();
			Thread.sleep(8000);
			//Contact Details Review Page
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationcontact-details"),"OMG!!! navigation to Contact Details Review page is unsuccessfull OR something is wrong! ");
			Select selectedIdentificationType=new Select(driver.findElement(By.xpath("//select[@formcontrolname='alternateIdType']")));
			Assert.assertEquals(selectedIdentificationType.getFirstSelectedOption().getText(), identificationType);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='alternateIdNumber']")).getAttribute("value"), identificationIDnumber);
			Assert.assertEquals(driver.findElement(By.xpath("//label[@class='custom-file-label ']/span")).getText().trim(), identificationProof);
			if(isCommunicationAddressSameAsPermanentAddress.equalsIgnoreCase("yes"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='address1']")).getAttribute("value"), address);
				selectedVillage=new Select(driver.findElement(By.xpath("//select[@formcontrolname='city']")));
				Assert.assertEquals(selectedVillage.getFirstSelectedOption().getText(), village);
				selectedState=new Select(driver.findElement(By.xpath("//select[@formcontrolname='state']")));
				Assert.assertEquals(selectedState.getFirstSelectedOption().getText(), state);
				selectedDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='district']")));
				Assert.assertEquals(selectedDistrict.getFirstSelectedOption().getText(), district);
				selectedSubDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='subDistrict']")));
				Assert.assertEquals(selectedSubDistrict.getFirstSelectedOption().getText(), subDistrict);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='pinCode']")).getAttribute("value"), pincode);
				selectedParlimentaryConstituency=new Select(driver.findElement(By.xpath("//select[@formcontrolname='parliamentaryConstituency']")));
				Assert.assertEquals(selectedParlimentaryConstituency.getFirstSelectedOption().getText(), parlimentaryConstituency);
			}
			else if(isCommunicationAddressSameAsPermanentAddress.equalsIgnoreCase("no"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='address1']")).getAttribute("value"), cAddress);
				Select cSelectedVillage=new Select(driver.findElement(By.xpath("//select[@formcontrolname='city']")));
				Assert.assertEquals(cSelectedVillage.getFirstSelectedOption().getText(), cVillage);
				Select cSelectedState=new Select(driver.findElement(By.xpath("//select[@formcontrolname='state']")));
				Assert.assertEquals(cSelectedState.getFirstSelectedOption().getText(), cState);
				Select cSelectedDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='district']")));
				Assert.assertEquals(cSelectedDistrict.getFirstSelectedOption().getText(), cDistrict);
				Select cSelectedSubDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='subDistrict']")));
				Assert.assertEquals(cSelectedSubDistrict.getFirstSelectedOption().getText(), cSubDistrict);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='pinCode']")).getAttribute("value"), cPincode);
				Select cSelectedParlimentaryConstituency=new Select(driver.findElement(By.xpath("//select[@formcontrolname='parliamentaryConstituency']")));
				Assert.assertEquals(cSelectedParlimentaryConstituency.getFirstSelectedOption().getText(), cParlimentaryConstituency);
			
			}
			tpCrp.clickSaveAndContinue();
			Thread.sleep(8000);
			//Education Details Review Page
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationeducation-details"),"OMG!!! navigation to Education Details Review page is unsuccessfull OR something is wrong! ");
			Select selectedEducation1=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='education'])[1]")));
			if(education1.equalsIgnoreCase("uneducated"))
			{
				Assert.assertEquals(selectedEducation1.getFirstSelectedOption().getText(), education1);
			}
			else
			{
				Assert.assertEquals(selectedEducation1.getFirstSelectedOption().getText(), education1);
				Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='specialization'])[1]")).getAttribute("value").trim(), specialisation1);
				Select selectedPassingYear1=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='passingYear'])[1]")));
				Assert.assertEquals(selectedPassingYear1.getFirstSelectedOption().getText(), yearOfPassing1);
				Assert.assertEquals(driver.findElement(By.xpath("(//label[@class='custom-file-label ']/span)[1]")).getText().trim(), education1Proof);
				//Second Education Record
				Select selectedEducation2=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='education'])[2]")));
				Assert.assertEquals(selectedEducation2.getFirstSelectedOption().getText(), education2);
				Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='specialization'])[2]")).getAttribute("value").trim(), specialisation2);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='educationName']")).getAttribute("value").trim(), othersEducationName);
				Select selectedYearOfPassing2=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='passingYear'])[2]")));
				Assert.assertEquals(selectedYearOfPassing2.getFirstSelectedOption().getText(), yearOfPassing2);
				Assert.assertEquals(driver.findElement(By.xpath("(//label[@class='custom-file-label ']/span)[2]")).getText().trim(), education2Proof);
			}
			tpCrp.clickSaveAndContinue();
			Thread.sleep(8000);
			//Course Preference Review Page
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationcourse-preferences"),"OMG!!! navigation to Course Preferences Review page is unsuccessfull OR something is wrong! ");
			Select selectedHearedFrom=new Select(driver.findElement(By.xpath("//select[@formcontrolname='heardFrom']")));
			Assert.assertEquals(selectedHearedFrom.getFirstSelectedOption().getText(), hearAboutUs);
			Select selectedSector1=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='sector'])[1]")));
			Assert.assertEquals(selectedSector1.getFirstSelectedOption().getText().trim(), sector1);
			Select selectedSubSector1=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='subSector'])[1]")));
			Assert.assertEquals(selectedSubSector1.getFirstSelectedOption().getText(), subSector1);
			Select selectedJobRole1=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='jobRole'])[1]")));
			Assert.assertEquals(selectedJobRole1.getFirstSelectedOption().getText(), jobRole1);
			//Second Preference
			Select selectedSector2=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='sector'])[2]")));
			Assert.assertEquals(selectedSector2.getFirstSelectedOption().getText().trim(), sector2);
			Select selectedSubSector2=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='subSector'])[2]")));
			Assert.assertEquals(selectedSubSector2.getFirstSelectedOption().getText(), subSector2);
			Select selectedJobRole2=new Select(driver.findElement(By.xpath("(//select[@formcontrolname='jobRole'])[2]")));
			Assert.assertEquals(selectedJobRole2.getFirstSelectedOption().getText(), jobRole2);
			tpCrp.clickSaveAndContinue();
			Thread.sleep(8000);
			//Declaration Page after Successful Review
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainingpartnercandidate-registrationdeclaration"),"OMG!!! navigation to Declaration page after Review is unsuccessfull OR something is wrong! ");
			tpCrp.clickToAgreeAndSubmit();
			Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().contains("success"));
			String createdCanidate=driver.findElement(By.id("swal2-content")).getText();
			String[] parts=createdCanidate.split(" ");
			String candidateID=parts[1];
			ReadWriteData.setExcelData("./TestData/Workflow/TrainingPartner_Candidate-Workflow.xls", "CandidateRegistration", Integer.parseInt(serialNum), 1, candidateID);
			tpCrp.clickOK();
			Thread.sleep(4000);
			tpMp.enterCandidateIDToSearch(candidateID);
			Thread.sleep(4000);
			tpMp.clickToApplySearchFilters();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+candidateID+"')]]")).size()==1,"OMG!!! No show of TP registered candidate - "+candidateID+" ! ");
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+candidateID+"')]")).getText().trim(), candidateID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+fullName+"')]")).getText().trim(), fullName);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+gender+"')]")).getText().trim(), gender);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
			tpMp.clickToSelectCreatedCandidateRecord();
			Thread.sleep(4000);
			tpMp.clickToDownloadReportForSelectedCandidates();
			Thread.sleep(4000);
		}
		else if(typeOfRegistration.equalsIgnoreCase("bulk"))
		{
			tpMp.clickToChooseBulkExcelSheetUpload();
			Thread.sleep(2000);
			tpMp.clickForExcelFileBrowse();
			Thread.sleep(4000);
			UploadFile.upload(bulkExcelFile);
			Thread.sleep(4000);
			tpMp.clickRegister();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim().contains("Candidates Registered Successfully"), "OMG!!! Toast Message Regarding Successful Candidate Registration does not displayed! ");
			for(int i=4;i<9;i++)
			{
				String bulkCandidateName=ReadWriteData.getData("./UploadFiles/"+bulkExcelFile, "Sheet1", i, 1);
				String bulkCandidateGender=ReadWriteData.getData("./UploadFiles/"+bulkExcelFile, "Sheet1", i, 2);
				String bulkCandidateState=ReadWriteData.getData("./UploadFiles/"+bulkExcelFile, "Sheet1", i, 26);
				String bulkCandidateDistrict=ReadWriteData.getData("./UploadFiles/"+bulkExcelFile, "Sheet1", i, 24);
				Thread.sleep(4000);
				tpMp.enterKeywordsToSearch(bulkCandidateName);
				Thread.sleep(4000);
				tpMp.clickToApplySearchFilters();
				Thread.sleep(4000);
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+bulkCandidateName+"')]]")).size()==1,"OMG!!! No show of bulk registration candidate of name - "+bulkCandidateName+" !! ");
				Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'CAN_')]")).isDisplayed());
				Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+bulkCandidateGender+"')]")).getText().trim(), bulkCandidateGender);
				Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+bulkCandidateState+"')]")).getText().trim(), bulkCandidateState);
				Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+bulkCandidateDistrict+"')]")).getText().trim(), bulkCandidateDistrict);
				Thread.sleep(4000);
				driver.findElement(By.xpath("//tr[td[contains(text(),'"+bulkCandidateName+"')]]/th/label/span")).click();
				tpMp.clickToDownloadReportForSelectedCandidates();
				Thread.sleep(4000);
			}
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(4000);
		plp.clickOnLogout();
	}
}
