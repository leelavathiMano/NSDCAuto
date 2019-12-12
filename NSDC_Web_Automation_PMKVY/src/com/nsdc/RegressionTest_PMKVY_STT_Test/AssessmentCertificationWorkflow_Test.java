package com.nsdc.RegressionTest_PMKVY_STT_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.AssessmentAgencyPage;
import com.nsdc.Pages_PMKVY_Pages.AssessmentCertificationPage;
import com.nsdc.Pages_PMKVY_Pages.AssessorPage;
import com.nsdc.Pages_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_PMKVY_Pages.LogOutPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.testConfig.TestConfiguration;

public class AssessmentCertificationWorkflow_Test extends TestConfiguration {
	@DataProvider
	public Object[][] CreateSpecialProjectData() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls",
				"AssessmentCertification");
	}
	@Test(dataProvider = "CreateSpecialProjectData")

	public void Addspecialprojectdata_01(String username, String password,String assignAssessor, String AAID,
			String AApassword,String assessorName,String AR,String ARpassword,String batchId) throws Exception {

		precondition();
	LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//	Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//	bsp.clickToClose();
//	Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(username, password);
//		Thread.sleep(3000);
	AssessmentCertificationPage acp=new AssessmentCertificationPage(driver);
//		Thread.sleep(3000);
//		acp.ClickOnAssessmentCertification();
//		Thread.sleep(4000);
//		acp.ClickOnBatchAssigned();
//		acp.ClickOnAcceptedIcon();
//		Thread.sleep(3000);
//		acp.ClicKonAction();
//		Thread.sleep(3000);
//		acp.ClickOnAssignAssessmentAgency();
//		Thread.sleep(3000);
//		acp.SelectAAId(assignAssessor);
//		Thread.sleep(3000);
//		acp.ClickOnSubmitButton();
//		Thread.sleep(5000);
//		acp.ClickOnOkButton();
//		Thread.sleep(3000);
      LogOutPage plp = new LogOutPage(driver);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout(); // //
//			Thread.sleep(5000);
////			
////			
//			lp.clickLogin();
//			bsp.clickToClose();
//			elp.performlogin(AAID, AApassword);
	AssessmentAgencyPage aap=new AssessmentAgencyPage(driver);
//			Thread.sleep(10000);
//			aap.ClickonAssessmentRequest();
//			Thread.sleep(5000);
//			aap. ClickonAction();
//			Thread.sleep(2000);
//			aap.ClickonAcceptBatch();
//			Thread.sleep(2000);
//			aap.ClickonYesButton();
//			Thread.sleep(2000);
//			aap.ClickOnOkButton();
//			Thread.sleep(3000);
//			aap.ClickOnAcceptedButton();
//		Thread.sleep(3000);
//		aap.ClickOnAcceptedAction();
//			aap.ClickOnAssignAssessorIcon();
//			aap.SelectAssessor(assessorName);
//			aap.ClickOnSubmitButton();
//			Thread.sleep(2000);
//			aap.ClickOnOkButton();
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout(); // //
//			Thread.sleep(5000);
		//////////////////////////ARARuncommittedcode	
//			lp.clickLogin();
//			Thread.sleep(3000);
//			bsp.clickToClose();
//			Thread.sleep(3000);
//			elp.performlogin(AR,ARpassword);
//			Thread.sleep(3000);
//			AssessorPage ar=new AssessorPage(driver);
//			Thread.sleep(3000);
//			ar.ClickOnAssessor();
//			Thread.sleep(5000);
//			ar.ClickOnAssessmentRequest();
			////////////////////////////////////////////ARuncommittedcode
//			Thread.sleep(2000);
//			//ar.ClickonAction();
//			
//			//ar.ClickonAcceptBatch();
//			
//			//ar.ClickonYesButton();
//			
//			//ar.ClickOnOkButton();
//			//Thread.sleep(5000);
			/////////ARuncommittedcode
//			Thread.sleep(3000);
//			ar.ClickonAssessedBatchRequest();
//			Thread.sleep(3000);
//			ar.ClickonARactionIcon();
//			Thread.sleep(1000);
//			ar.ClickonAR_ViewDetails();
//			Thread.sleep(3000);
//			ar.ClickOnAssessedCandidatesIcon();
//			Thread.sleep(3000);
//			
//			String TotalCandidates=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", 1, 0);
//		 	int NumberOFCandidates=Integer.parseInt(TotalCandidates);
//			for(int i=1;i<=NumberOFCandidates;i++)
//			{
//		 String status = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[4]//span")).getText();
//			
//			if(status.equalsIgnoreCase("Marks Not Uploaded"))
//			{
//				
//				String presentCan=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", 1, 1);
//				int Numberofpresentcandidtes=Integer.parseInt(presentCan);
//				for(int k=2;k<=Numberofpresentcandidtes;k++)
//				{
//				driver.findElement(By.xpath("(//span//a[i[@class='la la-ellipsis-h']])["+k+"]")).click();
//				driver.findElement(By.xpath("(//a[span[contains(text(),'Upload Marks')]])")).click();
//				
//				
//				
//				String NosTypes=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", 1, 2);
//				int numberOfNostypes=Integer.parseInt(NosTypes);
//				for(int j=1;j<=numberOfNostypes;j++)
//				   {      
//			        String TheoryMarks=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", j, 3);
//			        String PracticalMarks=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", j, 4);
//			         driver.findElement(By.xpath("(//input[@id='compTheory'])["+j+"]")).sendKeys(TheoryMarks);
//			         Thread.sleep(1000);
//			 	     driver.findElement(By.xpath("(//input[@id='compPractical'])["+j+"]")).sendKeys(PracticalMarks);
//			 	    }
//			      Thread.sleep(3000);
//				driver.findElement(By.xpath("//button[contains(text(),'Save & Upload')]")).click();
//				 Thread.sleep(5000);
//				driver.findElement(By.xpath("//button[text()='OK']")).click();
//				Thread.sleep(1000);
//				driver.findElement(By.xpath("//button[text()='Go Back']")).click();
//				Thread.sleep(3000);
//				ar.ClickOnAssessedCandidatesIcon();
//					Thread.sleep(5000);
//				}
//			}
//			
//			}
//			
//		ar.ClickOnSubmitApprovalToAA_Button();
//			Thread.sleep(3000);
//			ar.ClickOnOkButton();
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout(); // //
//			Thread.sleep(3000);
		//////////////////////////////////////////////////////////////////////////////////////////////ARuncommittedcode	
			
//			lp.clickLogin();
//		bsp.clickToClose();
//	elp.performlogin(AAID, AApassword);
//
//	Thread.sleep(3000);
//aap.ClickonAssessmentRequest();
//	////////////////////////////////////saturd
//Thread.sleep(3000);
//	aap.ClickOnAssessedBatchRequestButton();
//	Thread.sleep(3000);
//	aap.ClickOnAssessedBatchRequestActionButton();
//	Thread.sleep(3000);
//	aap.ClickOnViewBatchDetailsButton();
//	Thread.sleep(3000);
//	aap.ClickOnAA_AssessedCandidatesTab();
//	
//	
//	String TotalApplicanIds=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", 1, 0);
// 	int NumberofApplicationIds=Integer.parseInt(TotalApplicanIds);
//	for(int i=2;i<=NumberofApplicationIds;i++)
//	{
// String statusUPLoadedAssessor = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[3]//span")).getText();
//	
//	if(statusUPLoadedAssessor.equalsIgnoreCase("Uploaded by Assessor"))
//	{
//		
//		String presentCan=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", 1, 1);
//		int Numberofpresentcandidtes=Integer.parseInt(presentCan);
//		for(int k=1;k<=Numberofpresentcandidtes;k++)
//		{
//			Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[i[@class='la la-ellipsis-h']])["+(k+1)+"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[span[contains(text(),'View Marks')]])["+k+"]")).click();
//		
//		Thread.sleep(5000);
//		aap.ClickOnApproveButton();
//		
//		 Thread.sleep(5000);
//			driver.findElement(By.xpath("//button[text()='OK']")).click();
//			Thread.sleep(3000);
//		    //driver.findElement(By.xpath("//button[text()='Go Back']")).click();
//			//Thread.sleep(1000);
//			aap.ClickOnAA_AssessedCandidatesTab();
//			
//		}
//	}
//}
//	
//aap.CliCkOnSendToSSC();
//Thread.sleep(3000);
//aap.ClickonYesButton();
//Thread.sleep(3000);
//aap.ClickOnOkButton();
//Thread.sleep(3000);
//plp.clickOnProfileLogo();
//plp.clickOnLogout(); // //
//Thread.sleep(3000);
////////////////////////
lp.clickLogin();
bsp.clickToClose();
elp.performlogin(username, password);
Thread.sleep(3000);
acp.ClickOnAssessmentCertification();
Thread.sleep(3000);
acp.ClickOnResult_Verification();
Thread.sleep(3000);
  



acp.EnterTheBatchId(batchId);
Thread.sleep(1000);
acp.ClickOnApplyButton();
Thread.sleep(3000);

acp.ClickOnSSC_Action();
Thread.sleep(1000);
acp.ClickOnView_Batch_Details();
Thread.sleep(3000);
acp.ClickOnAssessedCandidates();
Thread.sleep(3000);
acp.ClickOnCheckBox();
Thread.sleep(1000);
acp.ClickOnApproveButton();
Thread.sleep(1000);
acp.ClickOnOkButton();
Thread.sleep(1000);
acp.ClickOnApproveForCertification();
Thread.sleep(1000);
acp.ClickOnOkButton();
Thread.sleep(1000);




//
//	   driver.findElement(By.xpath("(//a[i[@class='la la-ellipsis-h']])[5]")).click();
//	   Thread.sleep(1000);
//	 driver.findElement(By.xpath("(//span[@class='m-nav__link-text hover-padding'])[5]")).click();
//	  Thread.sleep(3000);
//	   
//	 driver.findElement(By.xpath("//a[h5[contains(text(),'Assessed Candidates')]]")).click();//assessedcandidates
//	 Thread.sleep(3000); 
//	 driver.findElement(By.xpath("//tbody//tr//th//label//span")).click();//checkbox
//	 Thread.sleep(1000); 
//	 driver.findElement(By.xpath("//div//button[text()='Approve']")).click();//approve button
//	 Thread.sleep(1000);
//	 ////////////////////////
//	 driver.findElement(By.xpath("//button[text()='OK']")).click();//ok button
//	 Thread.sleep(2000); 
//	 driver.findElement(By.xpath("//button[text()='Approve for Certification']")).click();
//	 Thread.sleep(2000);
//	 driver.findElement(By.xpath("//button[text()='OK']")).click();
//	 
	//button[text()='OK']
	 
	 
	 
	 
	


}
	}