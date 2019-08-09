package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.MobileHandlers;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.mobile.ui.object.Assessor_AcceptedRequestsScreen;
import com.nsdc.mobile.ui.object.Assessor_AddClassroomPhotosScreen;
import com.nsdc.mobile.ui.object.Assessor_AttendanceScreen;
import com.nsdc.mobile.ui.object.Assessor_BatchProfile_InfoScreen;
import com.nsdc.mobile.ui.object.Assessor_ChooseYourUserGroupScreen;
import com.nsdc.mobile.ui.object.Assessor_DeviceLocationAccessPermissionScreen;
import com.nsdc.mobile.ui.object.Assessor_List_Of_JobRoleScreen;
import com.nsdc.mobile.ui.object.Assessor_LoginScreen;
import com.nsdc.mobile.ui.object.Assessor_LogoutScreen;
import com.nsdc.mobile.ui.object.Assessor_MarksUpload_ApplicantsListScreen;
import com.nsdc.mobile.ui.object.Assessor_MarksUpload_For_IndividualApplicantScreen;
import com.nsdc.mobile.ui.object.Assessor_MyDashboardScreen;
import com.nsdc.testConfig.CreateAppiumDriver;
import io.appium.java_client.AppiumDriver;

public class ToT_AssessorAppSC_22 
{
	@DataProvider()
    public Object[][] totBatchData() throws Exception
    {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches");
    }
	@Test(dataProvider="totBatchData")
	public void assessor_DomainJobRole_AttendanceUploadTC_01(String serialNo,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime, String domainJobRoleAttendance, String platformJobRoleAttendance, String domainJobRoleLevel, String platformJobRoleLevel, String tcSPOCName, String domainJobRoleVersion, String platfromJobRoleVersion) throws Exception
	{
    	if(serialNo.equals("1"))
    	{
    		AppiumDriver appDriver=CreateAppiumDriver.getDriverInstance();
    		Assessor_ChooseYourUserGroupScreen aCuGs=new Assessor_ChooseYourUserGroupScreen(appDriver);
    		aCuGs.getAssessorButton().click();
    		Assessor_LoginScreen als=new Assessor_LoginScreen(appDriver);
    		als.getEmailTextbox().clear();
    		als.getEmailTextbox().sendKeys(dmasterAssessorID);
    		als.getPasswordTextbox().clear();
    		als.getPasswordTextbox().sendKeys(dmasterAssessorPassword);
    		als.getLoginButton().click();
    		Assessor_MyDashboardScreen aMdS=new Assessor_MyDashboardScreen(appDriver);
    		aMdS.getAcceptedRequestsSection().click();
    		Assessor_AcceptedRequestsScreen aArS=new Assessor_AcceptedRequestsScreen(appDriver);
    		aArS.scrollToBatch(appDriver, batchID);
    		Assert.assertEquals(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")\n"+tcID+"\nAssessment Pending");
    		aArS.getAcceptedBatchID(batchID).click();
    		Assessor_List_Of_JobRoleScreen aljs=new Assessor_List_Of_JobRoleScreen(appDriver);
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! no show of domain job role code in List of Job Roles screen OR something went wrong!");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+domainJobRole+"')]")).isDisplayed(),"OMG!!! no show of domain job role in List of Job Roles screen OR something went wrong!");
    		aljs.chooseDomainJobRole(domainJobRole);
    		WebDriverWait wait=new WebDriverWait(appDriver, 30);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-info")));
    		Assert.assertEquals(appDriver.findElement(By.id("profile-name")).getText().trim().toLowerCase(), batchType.toLowerCase()+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'"+batchID+"')]")).isDisplayed(),"OMG!!! No show of Batch ID");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Traning Centre Address')]")).getText().contains(mandal+" "+district+" "+state+" - "+tcPincode));
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Sector Name / Sub Sector Name')]")).getText().contains(expectedSector+" / "+subSector));
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Job Role')]")).getText().contains(domainJobRole+"/ "+domainJobRoleCode+" / "+domainJobRoleLevel+" "+platformJobRole+"/ "+platformJobRoleCode+" / "+platformJobRoleLevel));
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Candidates to be assessed')]")).getText().contains("5"));//SSC approved Applicants Number
    		Assert.assertEquals(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Full Name')]")).getText().trim(), tcSPOCName);
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Mobile')]")).getAttribute("value").contains(tcSPOCMobile));
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Email ID')]")).getAttribute("value").contains(tcSPOCEmail));
    		Assessor_BatchProfile_InfoScreen abps=new Assessor_BatchProfile_InfoScreen(appDriver);
    		MobileHandlers.scrollScreen(appDriver);
    		MobileHandlers.scrollScreen(appDriver);
    		abps.getStartAssessmentButton().click();
    		Assessor_DeviceLocationAccessPermissionScreen adaps=new Assessor_DeviceLocationAccessPermissionScreen(appDriver);
    		adaps.getAllowToAccessDeviceLocationButton().click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-hdr-0")));
    		Assert.assertEquals(appDriver.findElement(By.id("alert-hdr-0")).getText().trim(), "Success !");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'You are about to begin the assessment.')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+tcAddress+district+"')]")).isDisplayed());
    		adaps.clickOkForDeviceLocationAccessSuccess();
    		//Attendance Page
    		String applicantID_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 1);
    		String applicantName_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 4);
    		String applicantID_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 4);
    		String applicantName_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 4);
    		String applicantID_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 4);
    		String applicantName_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 4);
    		String applicantID_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 4);
    		String applicantName_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 4);
    		String applicantID_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 4);
    		String applicantName_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 4);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@text,'"+applicantID_1+"')]")));
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_1+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_1+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_2+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_2+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_3+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_3+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_4+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_4+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_5+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_5+"')]")).isDisplayed());
    		Assessor_AttendanceScreen aas=new Assessor_AttendanceScreen(appDriver);
    		aas.clickToGivePresenceForDomainApplicnat1();
    		aas.clickToGivePresenceForDomainApplicnat2();
    		aas.clickToGivePresenceForDomainApplicnat3();
    		aas.clickToGivePresenceForDomainApplicnat4();
    		aas.clickToGivePresenceForDomainApplicnat5();
    		//Uploading Classroom Pics
    		Assessor_AddClassroomPhotosScreen acps=new Assessor_AddClassroomPhotosScreen(appDriver);
    		MobileHandlers.scrollScreen(appDriver);
    		MobileHandlers.scrollScreen(appDriver);
    		acps.clickFirstCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'ALLOW')]")));
    		acps.clickAllowToAccessDevicePhotos();
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickSecondCameraImage();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
        	acps.clickToSwitchCameraToSelfieMode();
        	acps.clickToTakePictureFromCamera();
        	acps.clickDoneButtonToUploadJustclickedPic();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickThirdCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		MobileHandlers.scrollScreen(appDriver);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickFourthCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickFifthCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickSixthCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		MobileHandlers.scrollScreen(appDriver);
    		acps.clickStopAssessemnt();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-hdr-1")));
    		Assert.assertEquals(appDriver.findElement(By.id("alert-hdr-1")).getText().trim(), "Assessment Completed Successfully !");
    		Assert.assertEquals(appDriver.findElement(By.id("alert-msg-1")).getText().trim(), "Assessment is conducted, you can now upload the marks for the batch.");
    		acps.clickLaterForMarksUpload();
    		Assessor_LogoutScreen al= new Assessor_LogoutScreen(appDriver);
    		al.performAssessorLogout();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-subhdr-0")));
    		Assert.assertEquals(appDriver.findElement(By.id("alert-subhdr-0")).getText().trim(), "Your are logged out Successfully");
    		al.clickOkButton();
    	}
	}
    
    @Test(dataProvider="totBatchData")
	public void assessor_PlatformJobRole_AttendanceUploadTC_02(String serialNo,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime, String domainJobRoleAttendance, String platformJobRoleAttendance, String domainJobRoleLevel, String platformJobRoleLevel, String tcSPOCName, String domainJobRoleVersion, String platfromJobRoleVersion) throws Exception
	{
    	if(serialNo.equals("1"))
    	{
    		AppiumDriver appDriver=CreateAppiumDriver.getDriverInstance();
    		Assessor_ChooseYourUserGroupScreen aCuGs=new Assessor_ChooseYourUserGroupScreen(appDriver);
    		aCuGs.getAssessorButton().click();
    		Assessor_LoginScreen als=new Assessor_LoginScreen(appDriver);
    		als.getEmailTextbox().clear();
    		als.getEmailTextbox().sendKeys(pmasterAssessorID);
    		als.getPasswordTextbox().clear();
    		als.getPasswordTextbox().sendKeys(pmasterAssessorPassword);
    		als.getLoginButton().click();
    		Assessor_MyDashboardScreen aMdS=new Assessor_MyDashboardScreen(appDriver);
    		aMdS.getAcceptedRequestsSection().click();
    		Assessor_AcceptedRequestsScreen aArS=new Assessor_AcceptedRequestsScreen(appDriver);
    		aArS.scrollToBatch(appDriver, batchID);
    		Assert.assertEquals(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")\n"+tcID+"\nAssessment Pending");
    		aArS.getAcceptedBatchID(batchID).click();
    		Assessor_List_Of_JobRoleScreen aljs=new Assessor_List_Of_JobRoleScreen(appDriver);
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+platformJobRoleCode+"')]")).isDisplayed(),"OMG!!! no show of platform job role code in List of Job Roles screen OR something went wrong!");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+platformJobRole+"')]")).isDisplayed(),"OMG!!! no show of platform job role in List of Job Roles screen OR something went wrong!");
    		aljs.choosePlatformJobRole(platformJobRole);
    		WebDriverWait wait=new WebDriverWait(appDriver, 30);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-info")));
    		Assert.assertEquals(appDriver.findElement(By.id("profile-name")).getText().trim().toLowerCase(), batchType.toLowerCase()+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'"+batchID+"')]")).isDisplayed(),"OMG!!! No show of Batch ID");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Traning Centre Address')]")).getText().contains(mandal+" "+district+" "+state+" - "+tcPincode));
//    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Sector Name / Sub Sector Name')]")).getText().contains(batchSector+" / "+batchSubSector));
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Job Role')]")).getText().contains(domainJobRole+"/ "+domainJobRoleCode+" / "+domainJobRoleLevel+" "+platformJobRole+"/ "+platformJobRoleCode+" / "+platformJobRoleLevel));
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Candidates to be assessed')]")).getText().contains("5"));//SSC approved Applicants Number
//    		Assert.assertEquals(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Full Name')]")).getText().trim(), tcSPOCName);
//    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Mobile')]")).getAttribute("value").contains(tcSPOCMobile));
//    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'Email ID')]")).getAttribute("value").contains(tcSPOCEmail));
    		Assessor_BatchProfile_InfoScreen abps=new Assessor_BatchProfile_InfoScreen(appDriver);
    		MobileHandlers.scrollScreen(appDriver);
    		MobileHandlers.scrollScreen(appDriver);
    		abps.getStartAssessmentButton().click();
    		Assessor_DeviceLocationAccessPermissionScreen adaps=new Assessor_DeviceLocationAccessPermissionScreen(appDriver);
    		adaps.getAllowToAccessDeviceLocationButton().click();
    		Assert.assertEquals(appDriver.findElement(By.id("alert-hdr-0")).getText().trim(), "Success !");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'You are about to begin the assessment.')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+tcAddress+district+"')]")).isDisplayed());
    		adaps.clickOkForDeviceLocationAccessSuccess();
    		//Attendance Page
    		String applicantID_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 1);
    		String applicantName_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 4);
    		String applicantID_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 4);
    		String applicantName_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 4);
    		String applicantID_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 4);
    		String applicantName_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 4);
    		String applicantID_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 4);
    		String applicantName_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 4);
    		String applicantID_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 4);
    		String applicantName_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 4);
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_1+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_1+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_2+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_2+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_3+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_3+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_4+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_4+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_5+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_5+"')]")).isDisplayed());
    		Assessor_AttendanceScreen aas=new Assessor_AttendanceScreen(appDriver);
    		aas.clickToGivePresenceForPlatformApplicnat1();
    		aas.clickToGivePresenceForPlatformApplicnat2();
    		aas.clickToGivePresenceForPlatformApplicnat3();
    		aas.clickToGivePresenceForPlatformApplicnat4();
    		aas.clickToGivePresenceForPlatformApplicnat5();
    		//Uploading Classroom Pics
    		Assessor_AddClassroomPhotosScreen acps=new Assessor_AddClassroomPhotosScreen(appDriver);
    		MobileHandlers.scrollScreen(appDriver);
    		MobileHandlers.scrollScreen(appDriver);
    		acps.clickFirstCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'ALLOW')]")));
    		acps.clickAllowToAccessDevicePhotos();
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickSecondCameraImage();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
        	acps.clickToSwitchCameraToSelfieMode();
        	acps.clickToTakePictureFromCamera();
        	acps.clickDoneButtonToUploadJustclickedPic();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickThirdCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		MobileHandlers.scrollScreen(appDriver);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickFourthCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickFifthCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Image[@text='default'])[1]")));
    		acps.clickSixthCameraImage();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mediatek.camera:id/rlk_camera_switcher")));
    		acps.clickToSwitchCameraToSelfieMode();
    		acps.clickToTakePictureFromCamera();
    		acps.clickDoneButtonToUploadJustclickedPic();
    		MobileHandlers.scrollScreen(appDriver);
    		acps.clickStopAssessemnt();
    		Assert.assertEquals(appDriver.findElement(By.id("alert-hdr-2")).getText().trim(), "Assessment Completed Successfully !");
    		Assert.assertEquals(appDriver.findElement(By.id("alert-msg-2")).getText().trim(), "Assessment is conducted, you can now upload the marks for the batch.");
    		acps.clickLaterForMarksUpload();
    		Assessor_LogoutScreen al= new Assessor_LogoutScreen(appDriver);
    		al.performAssessorLogout();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-subhdr-0")));
    		Assert.assertEquals(appDriver.findElement(By.id("alert-subhdr-0")).getText().trim(), "Your are logged out Successfully");
    		al.clickOkButton();
    	}
	}
      
    //Marks Upload by Assessor
    @Test(dataProvider="totBatchData",dependsOnMethods= {"assessor_DomainJobRole_AttendanceUploadTC_01","assessor_PlatformJobRole_AttendanceUploadTC_02"})
   	public void assessor_DomainJobRole_MarksUploadTC_03(String serialNo,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime, String domainJobRoleAttendance, String platformJobRoleAttendance, String domainJobRoleLevel, String platformJobRoleLevel, String tcSPOCName, String domainJobRoleVersion, String platfromJobRoleVersion) throws Exception
   	{
    	if(serialNo.equals("1"))
    	{
    		AppiumDriver appDriver=CreateAppiumDriver.getDriverInstance();
    		Assessor_ChooseYourUserGroupScreen aCuGs=new Assessor_ChooseYourUserGroupScreen(appDriver);
    		aCuGs.getAssessorButton().click();
    		Assessor_LoginScreen als=new Assessor_LoginScreen(appDriver);
    		als.getEmailTextbox().clear();
    		als.getEmailTextbox().sendKeys(dmasterAssessorID);
    		als.getPasswordTextbox().clear();
    		als.getPasswordTextbox().sendKeys(dmasterAssessorPassword);
    		als.getLoginButton().click();
    		Thread.sleep(5000);
    		Assessor_MyDashboardScreen aMdS=new Assessor_MyDashboardScreen(appDriver);
    		aMdS.getAcceptedRequestsSection().click();
    		Assessor_AcceptedRequestsScreen aArS=new Assessor_AcceptedRequestsScreen(appDriver);
    		aArS.scrollToBatch(appDriver, batchID);
//    		Assert.assertEquals(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")\n"+tcID+"\nMarks Upload Pending");
    		aArS.getAcceptedBatchID(batchID).click();
    		Assessor_List_Of_JobRoleScreen aljs=new Assessor_List_Of_JobRoleScreen(appDriver);
    		WebDriverWait wait=new WebDriverWait(appDriver, 10);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@text,'"+domainJobRoleCode+"')]")));
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! no show of Domain job role code in List of Job Roles screen OR something went wrong!");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+domainJobRole+"')]")).isDisplayed(),"OMG!!! no show of Domain job role in List of Job Roles screen OR something went wrong!");
    		Assert.assertTrue(appDriver.findElement(By.xpath("(//android.view.View[@text='5 / 5'])[1]")).isDisplayed(),"OMG!!! no show of Domain job role Attendance in List of Job Roles screen OR something went wrong!");
    		aljs.chooseDomainJobRole(domainJobRole);
    		String applicantID_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 1);
    		String applicantName_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 4);
    		String applicantID_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 1);
    		String applicantName_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 4);
    		String applicantID_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 1);
    		String applicantName_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 4);
    		String applicantID_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 1);
    		String applicantName_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 4);
    		String applicantID_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 1);
    		String applicantName_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 4);
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_1+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_1+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_2+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_2+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_3+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_3+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_4+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_4+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_5+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_5+"')]")).isDisplayed());
    		Assessor_MarksUpload_ApplicantsListScreen amuals=new Assessor_MarksUpload_ApplicantsListScreen(appDriver);
    		//NoS and Marks
    		String NOS_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 1, 1);
    		String NOS_1_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 1, 5);
    		String NOS_1_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 1, 6);
    		//
    		String NOS_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 2, 1);
    		String NOS_2_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 2, 5);
    		String NOS_2_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 2, 6);
    		//
    		String NOS_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 3, 1);
    		String NOS_3_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 3, 5);
    		String NOS_3_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 3, 6);
    		//
    		String NOS_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 4, 1);
    		String NOS_4_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 4, 5);
    		String NOS_4_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 4, 6);
    		//
    		String NOS_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 5, 1);
    		String NOS_5_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 5, 5);
    		String NOS_5_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 5, 6);
    		//
    		String NOS_6=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 6, 1);
    		String NOS_6_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 6, 5);
    		String NOS_6_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 6, 6);
    		//
    		String NOS_7=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 7, 1);
    		String NOS_7_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 7, 5);
    		String NOS_7_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 7, 6);
    		//
    		String NOS_8=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 8, 1);
    		String NOS_8_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 8, 5);
    		String NOS_8_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 8, 6);
    		//
    		String NOS_9=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 9, 1);
    		String NOS_9_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 9, 5);
    		String NOS_9_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 9, 6);
    		//
    		String NOS_10=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 10, 1);
    		String NOS_10_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 10, 5);
    		String NOS_10_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 10, 6);
    		//
    		String NOS_11=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 11, 1);
    		String NOS_11_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 11, 5);
    		String NOS_11_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 11, 6);
    		//Over all Percentage after entering respected NOS Marks
    		String percentage_After_1st_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 1, 8);
    		String percentage_After_2nd_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 2, 8);
    		String percentage_After_3rd_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 3, 8);
    		String percentage_After_4th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 4, 8);
    		String percentage_After_5th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 5, 8);
    		String percentage_After_6th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 6, 8);
    		String percentage_After_7th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 7, 8);
    		String percentage_After_8th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 8, 8);
    		String percentage_After_9th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 9, 8);
    		String percentage_After_10th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 10, 8);
    		String percentage_After_11th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "DomainJobRole_NOS", 11, 8);
    		for(int i=3; i<6; i++)
    		{
    			String applicantID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", i, 1);
        		String applicantName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", i, 4);
    			amuals.clickApplicantToStartMarksUploading(applicantID);
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@text,'UPLOAD MARKS')]")));
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'0%progress')]")).isDisplayed(),"OMG!!! No show of initial marks percentage");
        		Assessor_MarksUpload_For_IndividualApplicantScreen amuias=new Assessor_MarksUpload_For_IndividualApplicantScreen(appDriver);
        		//NOS_1
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_1+"')]")).isDisplayed());
        		amuias.enterDomainNOS1_TheoryMarks(NOS_1_Obtained_TheoryMarks);
        		amuias.enterDomainNOS1_PracticalMarks(NOS_1_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_1);
        		amuias.clickToSaveDomainNOS1_Marks();
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-subhdr-0")));
        		Assert.assertEquals(appDriver.findElement(By.id("alert-subhdr-0")).getText().trim(), "Successfully Saved");
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_1st_NOS+"%progress')]")).isDisplayed());
        		//NOS_2
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_2+"')]")).isDisplayed());
        		amuias.enterDomainNOS2_TheoryMarks(NOS_2_Obtained_TheoryMarks);
        		amuias.enterDomainNOS2_PracticalMarks(NOS_2_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_2);
        		amuias.clickToSaveDomainNOS2_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_2nd_NOS+"%progress')]")).isDisplayed());
        		//NOS_3
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_3+"')]")).isDisplayed());
        		amuias.enterDomainNOS3_TheoryMarks(NOS_3_Obtained_TheoryMarks);
        		amuias.enterDomainNOS3_PracticalMarks(NOS_3_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_3);
        		amuias.clickToSaveDomainNOS3_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_3rd_NOS+"%progress')]")).isDisplayed());
        		//NOS_4
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_4+"')]")).isDisplayed());
        		amuias.enterDomainNOS4_TheoryMarks(NOS_4_Obtained_TheoryMarks);
        		amuias.enterDomainNOS4_PracticalMarks(NOS_4_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_4);
        		amuias.clickToSaveDomainNOS4_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_4th_NOS+"%progress')]")).isDisplayed());
        		//NOS_5
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_5+"')]")).isDisplayed());
        		amuias.enterDomainNOS5_TheoryMarks(NOS_5_Obtained_TheoryMarks);
        		amuias.enterDomainNOS5_PracticalMarks(NOS_5_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_5);
        		amuias.clickToSaveDomainNOS5_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_5th_NOS+"%progress')]")).isDisplayed());
        		//NOS_6
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_6+"')]")).isDisplayed());
        		amuias.enterDomainNOS6_TheoryMarks(NOS_6_Obtained_TheoryMarks);
        		amuias.enterDomainNOS6_PracticalMarks(NOS_6_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_6);
        		amuias.clickToSaveDomainNOS6_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_6th_NOS+"%progress')]")).isDisplayed());
        		//NOS_7
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_7+"')]")).isDisplayed());
        		amuias.enterDomainNOS7_TheoryMarks(NOS_7_Obtained_TheoryMarks);
        		amuias.enterDomainNOS7_PracticalMarks(NOS_7_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_7);
        		amuias.clickToSaveDomainNOS7_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_7th_NOS+"%progress')]")).isDisplayed());
        		//NOS_8
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_8+"')]")).isDisplayed());
        		amuias.enterDomainNOS8_TheoryMarks(NOS_8_Obtained_TheoryMarks);
        		amuias.enterDomainNOS8_PracticalMarks(NOS_8_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_8);
        		amuias.clickToSaveDomainNOS8_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_8th_NOS+"%progress')]")).isDisplayed());
        		//NOS_9
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_9+"')]")).isDisplayed());
        		amuias.enterDomainNOS9_TheoryMarks(NOS_9_Obtained_TheoryMarks);
        		amuias.enterDomainNOS9_PracticalMarks(NOS_9_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_9);
        		amuias.clickToSaveDomainNOS9_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_9th_NOS+"%progress')]")).isDisplayed());
        		//NOS_10
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_10+"')]")).isDisplayed());
        		amuias.enterDomainNOS10_TheoryMarks(NOS_10_Obtained_TheoryMarks);
        		amuias.enterDomainNOS10_PracticalMarks(NOS_10_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_10);
        		amuias.clickToSaveDomainNOS10_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_10th_NOS+"%progress')]")).isDisplayed());
        		//NOS_11
        		MobileHandlers.scrollScreen(appDriver);
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_11+"')]")).isDisplayed());
        		amuias.enterDomainNOS11_TheoryMarks(NOS_11_Obtained_TheoryMarks);
        		amuias.enterDomainNOS11_PracticalMarks(NOS_11_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_11);
        		amuias.clickToSaveDomainNOS11_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_11th_NOS+"%progress')]")).isDisplayed());
        		MobileHandlers.scrollScreen(appDriver);
        		amuias.clickNext();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.view.View[@text='Please wait...']")));
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_11th_NOS+"%progress')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'Step 2 of 3')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'Elective NOS is not Available')]")).isDisplayed());
        		amuias.clickNext();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_11th_NOS+"%progress')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'Step 3 of 3')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'Optional NOS is not Available')]")).isDisplayed());
        		amuias.clickNext();
        		amuias.clickOK();
    		}
    		Assessor_LogoutScreen al= new Assessor_LogoutScreen(appDriver);
    		al.performAssessorLogout();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-subhdr-0")));
    		Assert.assertEquals(appDriver.findElement(By.id("alert-subhdr-0")).getText().trim(), "Your are logged out Successfully");
    		al.clickOkButton();
    	}	
   	}
    
    //Platform Job role Marks Upload
    @Test(dataProvider="totBatchData")//,dependsOnMethods= {"assessor_DomainJobRole_AttendanceUploadTC_01","assessor_PlatformJobRole_AttendanceUploadTC_02"})
   	public void assessor_PlatformJobRole_MarksUploadTC_04(String serialNo,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime, String domainJobRoleAttendance, String platformJobRoleAttendance, String domainJobRoleLevel, String platformJobRoleLevel, String tcSPOCName, String domainJobRoleVersion, String platfromJobRoleVersion) throws Exception
   	{
    	if(serialNo.equals("1"))
    	{
    		AppiumDriver appDriver=CreateAppiumDriver.getDriverInstance();
    		Assessor_ChooseYourUserGroupScreen aCuGs=new Assessor_ChooseYourUserGroupScreen(appDriver);
    		aCuGs.getAssessorButton().click();
    		Assessor_LoginScreen als=new Assessor_LoginScreen(appDriver);
    		als.getEmailTextbox().clear();
    		als.getEmailTextbox().sendKeys(pmasterAssessorID);
    		als.getPasswordTextbox().clear();
    		als.getPasswordTextbox().sendKeys(pmasterAssessorPassword);
    		als.getLoginButton().click();
    		Thread.sleep(5000);
    		Assessor_MyDashboardScreen aMdS=new Assessor_MyDashboardScreen(appDriver);
    		aMdS.getAcceptedRequestsSection().click();
    		Assessor_AcceptedRequestsScreen aArS=new Assessor_AcceptedRequestsScreen(appDriver);
    		aArS.scrollToBatch(appDriver, batchID);
//    		Assert.assertEquals(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'("+batchID+")')]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")\n"+tcID+"\nMarks Upload Pending");
    		aArS.getAcceptedBatchID(batchID).click();
    		Assessor_List_Of_JobRoleScreen aljs=new Assessor_List_Of_JobRoleScreen(appDriver);
    		WebDriverWait wait=new WebDriverWait(appDriver, 10);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@text,'"+domainJobRoleCode+"')]")));
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+platformJobRoleCode+"')]")).isDisplayed(),"OMG!!! no show of Platform job role code in List of Job Roles screen OR something went wrong!");
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+platformJobRole+"')]")).isDisplayed(),"OMG!!! no show of Platform job role in List of Job Roles screen OR something went wrong!");
    		Assert.assertTrue(appDriver.findElement(By.xpath("(//android.view.View[@text='5 / 5'])[1]")).isDisplayed(),"OMG!!! no show of Platform job role Attendance in List of Job Roles screen OR something went wrong!");
    		aljs.chooseDomainJobRole(platformJobRole);
    		String applicantID_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 1);
    		String applicantName_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 4);
    		String applicantID_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 1);
    		String applicantName_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 4);
    		String applicantID_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 1);
    		String applicantName_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 4);
    		String applicantID_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 1);
    		String applicantName_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 4);
    		String applicantID_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 1);
    		String applicantName_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 4);
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_1+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_1+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_2+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_2+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_3+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_3+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_4+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_4+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID_5+"')]")).isDisplayed());
    		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName_5+"')]")).isDisplayed());
    		Assessor_MarksUpload_ApplicantsListScreen amuals=new Assessor_MarksUpload_ApplicantsListScreen(appDriver);
    		//NoS and Marks
    		String NOS_1=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 1, 1);
    		String NOS_1_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 1, 5);
    		String NOS_1_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 1, 6);
    		//
    		String NOS_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 2, 1);
    		String NOS_2_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 2, 5);
    		String NOS_2_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 2, 6);
    		//
    		String NOS_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 3, 1);
    		String NOS_3_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 3, 5);
    		String NOS_3_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 3, 6);
    		//
    		String NOS_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 4, 1);
    		String NOS_4_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 4, 5);
    		String NOS_4_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 4, 6);
    		//
    		String NOS_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 5, 1);
    		String NOS_5_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 5, 5);
    		String NOS_5_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 5, 6);
    		//
    		String NOS_6=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 6, 1);
    		String NOS_6_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 6, 5);
    		String NOS_6_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 6, 6);
    		//
    		String NOS_7=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 7, 1);
    		String NOS_7_Obtained_TheoryMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 7, 5);
    		String NOS_7_Obtained_PracticalMarks=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 7, 6);
    		//Over all Percentage after entering respected NOS Marks
    		String percentage_After_1st_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 1, 8);
    		String percentage_After_2nd_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 2, 8);
    		String percentage_After_3rd_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 3, 8);
    		String percentage_After_4th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 4, 8);
    		String percentage_After_5th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 5, 8);
    		String percentage_After_6th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 6, 8);
    		String percentage_After_7th_NOS=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "PlatformJobRole_NOS", 7, 8);
    		for(int i=5; i<6; i++)
    		{
    			String applicantID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", i, 1);
        		String applicantName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", i, 4);
    			amuals.clickApplicantToStartMarksUploading(applicantID);
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@text,'UPLOAD MARKS')]")));
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'0%progress')]")).isDisplayed(),"OMG!!! No show of initial marks percentage");
        		Assessor_MarksUpload_For_IndividualApplicantScreen amuias=new Assessor_MarksUpload_For_IndividualApplicantScreen(appDriver);
        		//NOS_1
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_1+"')]")).isDisplayed());
        		amuias.enterDomainNOS1_TheoryMarks(NOS_1_Obtained_TheoryMarks);
        		amuias.enterDomainNOS1_PracticalMarks(NOS_1_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_1);
        		amuias.clickToSaveDomainNOS1_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_1st_NOS+"%progress')]")).isDisplayed());
        		//NOS_2
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_2+"')]")).isDisplayed());
        		amuias.enterDomainNOS2_TheoryMarks(NOS_2_Obtained_TheoryMarks);
        		amuias.enterDomainNOS2_PracticalMarks(NOS_2_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_2);
        		amuias.clickToSaveDomainNOS2_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_2nd_NOS+"%progress')]")).isDisplayed());
        		//NOS_3
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_3+"')]")).isDisplayed());
        		amuias.enterDomainNOS3_TheoryMarks(NOS_3_Obtained_TheoryMarks);
        		amuias.enterDomainNOS3_PracticalMarks(NOS_3_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_3);
        		amuias.clickToSaveDomainNOS3_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_3rd_NOS+"%progress')]")).isDisplayed());
        		//NOS_4
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_4+"')]")).isDisplayed());
        		amuias.enterDomainNOS4_TheoryMarks(NOS_4_Obtained_TheoryMarks);
        		amuias.enterDomainNOS4_PracticalMarks(NOS_4_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_4);
        		amuias.clickToSaveDomainNOS4_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_4th_NOS+"%progress')]")).isDisplayed());
        		//NOS_5
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_5+"')]")).isDisplayed());
        		amuias.enterDomainNOS5_TheoryMarks(NOS_5_Obtained_TheoryMarks);
        		amuias.enterDomainNOS5_PracticalMarks(NOS_5_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_5);
        		amuias.clickToSaveDomainNOS5_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_5th_NOS+"%progress')]")).isDisplayed());
        		//NOS_6
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_6+"')]")).isDisplayed());
        		amuias.enterDomainNOS6_TheoryMarks(NOS_6_Obtained_TheoryMarks);
        		amuias.enterDomainNOS6_PracticalMarks(NOS_6_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_6);
        		amuias.clickToSaveDomainNOS6_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_6th_NOS+"%progress')]")).isDisplayed());
        		//NOS_7
        		MobileHandlers.scrollScreen(appDriver);
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+NOS_7+"')]")).isDisplayed());
        		amuias.enterDomainNOS7_TheoryMarks(NOS_7_Obtained_TheoryMarks);
        		MobileHandlers.scrollScreen(appDriver);
        		amuias.enterDomainNOS7_PracticalMarks(NOS_7_Obtained_PracticalMarks);
        		amuias.tapNocCode(NOS_7);
        		amuias.clickToSaveDomainNOS7_Marks();
        		amuias.clickOK();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_7th_NOS+"%progress')]")).isDisplayed());
        		MobileHandlers.scrollScreen(appDriver);
        		amuias.clickNext();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_7th_NOS+"%progress')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'Step 2 of 3')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'Elective NOS is not Available')]")).isDisplayed());
        		amuias.clickNext();
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+percentage_After_7th_NOS+"%progress')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantID+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+applicantName+"')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'Step 3 of 3')]")).isDisplayed());
        		Assert.assertTrue(appDriver.findElement(By.xpath("//android.view.View[contains(@text,'Optional NOS is not Available')]")).isDisplayed());
        		amuias.clickSubmit();
        		amuias.clickOK();
    		}
    		Assessor_LogoutScreen al= new Assessor_LogoutScreen(appDriver);
    		al.performAssessorLogout();
    		al.clickOkButton();
    	}	
   	}
}