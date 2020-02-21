package com.nsdc.RegressionTest_PMKVY_STT_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.AddCampsPage;
import com.nsdc.Pages_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
import com.nsdc.Pages_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_PMKVY_Pages.LogOutPage;
import com.nsdc.Pages_PMKVY_Pages.MySchemeOrProjectPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_SPPMU_SelectedSchemepage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_Type_RPL_SchemePage;
import com.nsdc.Pages_PMKVY_Pages.PMU_RPL_Schmepage;
import com.nsdc.Pages_PMKVY_Pages.RPL_dashboardpage;
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.testConfig.TestConfiguration;

public class Pmkvy_RPL_WorkFlowTest extends TestConfiguration {

//	@DataProvider
//	public Object[][] addProject_RPL()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01");
//	}
//	
//	@Test(dataProvider="addProject_RPL")
//	public void addProject_RPL_TC_01(String sno,String loginid, String password,String SelectedScheme,
//			String Trainingtype,String Subscheme,
//			String ProjectProposalID,String ProjectName,String rpltype,String miniumSize,String maximumSize,
//			String agreementDate,String projectduration,String orgName,String fullname,String designation
//			,String mobilenumber,String email,String Address,String target,String assessmentMode,String duallogo,String img) throws Exception
//	{
//		precondition();
//		int srno = Integer.parseInt(sno);
//		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
////		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//	     bsp.clickToClose();
////		Thread.sleep(3000);
//     EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(loginid, password);
////		Thread.sleep(3000);
//	DashboardPage db = new DashboardPage(driver);
//		db.ClickMySchemeOrPrograms();
//		MySchemeOrProjectPage msp = new MySchemeOrProjectPage(driver);
//		msp.ClickApplySchemeProgram();
//		SelectSchemeOrProgramPage ssp = new SelectSchemeOrProgramPage(driver);
////		Thread.sleep(3000);
//       ssp.ClickPageNumber2();
//       Thread.sleep(3000);
//       WebElement MySchemesListTable = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']"));
//		
//		List<WebElement> rowstable = MySchemesListTable.findElements(By.tagName("tr"));
//
//		int rows_count = rowstable.size();
//
//		for (int row = 1; row < rows_count; row++) {
//
//	 String TrainingType	 = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[3]")).getText();
//
//				String SUBScheme = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr//td[span[span[text()='"+Subscheme+"']]]")).getText();
//				
//				if (TrainingType.equals(Trainingtype)&& SUBScheme.equals(Subscheme))
//				{
//					
//					Thread.sleep(2000);
//					driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//				    driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[contains(text(),'Add Project')]")).click();
//				    Thread.sleep(3000);
//				break;
//				}
//				
//			}
//		
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'"+SelectedScheme+"')]")).getText(), SelectedScheme);
//		
//		
//		PMKVY_Type_RPL_SchemePage Schemepage=new PMKVY_Type_RPL_SchemePage(driver);
//		
//		Thread.sleep(3000);
//		Schemepage.EnterTheProjectProposalID(ProjectProposalID);
//	Thread.sleep(3000);
//		Schemepage.EnterTheProjecName(ProjectName);
//		String rplType = driver.findElement(By.xpath("(//label[@class='col-lg-3 col-form-label'])[3]/..//select[@formcontrolname='rplType']")).getText();
//		
//		ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno, 8, rplType);
//		Thread.sleep(3000);
//		Schemepage.ClickProjectType();
//		Thread.sleep(3000);
//		 String minimumbatchSize=driver.findElement(By.xpath("//input[@placeholder='Enter Proposed Minimum Batch Size']")).getAttribute("value");
//		ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,9, minimumbatchSize);
//		 String MaximumbatchSize=driver.findElement(By.xpath("//input[@placeholder='Enter Proposed Maximum Batch Size']")).getAttribute("value");
//		
//		 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,10,MaximumbatchSize );
//		 Schemepage.ClickOnAgreementDate();
//	Thread.sleep(3000);
//		 Schemepage.SelectAgreementDate(agreementDate);
//		 Thread.sleep(3000);
//		 Schemepage.EnterProjectDuration(projectduration);
//		 Thread.sleep(3000);
//		 Schemepage.EnterFacilitatorOrganizationNameTextBox(orgName);
//		 Thread.sleep(3000);
//		 Schemepage.ClickOnAddButton();
//		 Thread.sleep(3000);
//		 Schemepage.ClickOnAddPromoterButton();
//		 Thread.sleep(3000);
//		 Schemepage.EnterTheFullName(fullname);
//		 Schemepage.EnterDesignationTextbox(designation);
//		 Schemepage.EnterMobilenumberTextbox(mobilenumber);
//		 Schemepage.EnterEmailAdress(email);
//		 Schemepage.ClickOnUploadDocumentRadiobutton();
//		 Schemepage.EnterAdress(Address);
//		 Thread.sleep(3000);
//		 Schemepage.ClickOnSubmit();
//		 Thread.sleep(3000);
//		 Schemepage.EnterprojectTarget(target);
//		 String assessmentMode1 = driver.findElement(By.xpath("//input[@placeholder='Assessment Mode']")).getAttribute("value");
//		 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,20,assessmentMode1);
//		 Schemepage.SelectdualLogoDropdownlist(duallogo);
//		 if(duallogo.equalsIgnoreCase("yes"))
//		 {
//		 Schemepage.ClickOnDuallogoBrowser();
//		 
//		 UploadFile.upload(img);
//		 Thread.sleep(3000);
//		 Schemepage.ClickonUploadButton();
//		 Thread.sleep(3000);
//		 }
//	
////		 String NameofPrimarySPOC = driver.findElement(By.xpath("//input[@class='form-control m-input ng-pristine ng-valid ng-touched']")).getAttribute("value");
////		 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,,assessmentMode );
//		 Thread.sleep(3000);
//		 Schemepage.ClickOnSaveAndNextButton();
//		 Thread.sleep(3000);
//		
//		 String numberOfSectors_jobroles=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", 1, 1);
//		 	int total_sectors_jobRoles=Integer.parseInt(numberOfSectors_jobroles);
//		 	
//			for(int i=1;i<=total_sectors_jobRoles;i++)
//			{
//				Thread.sleep(10000);
//				Schemepage.ClickOnAddSectorsAndjobRole();
//				Thread.sleep(2000);
//				
//				String Sectors=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", i, 2);
//				String JobRoles=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", i, 3);
//				Schemepage.SelectSector(Sectors);
//				Thread.sleep(1000);
//				Schemepage.SelectjobRoleName(JobRoles);
//				Thread.sleep(1000);
//				
//				 String Qpcode = driver.findElement(By.xpath("//input[@class='form-control m-input']")).getAttribute("value");
//				 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow",  i, 4, Qpcode);
//				 
//				 
//				 
//				 String NSQfLevel = driver.findElement(By.xpath("//input[@formcontrolname='nsqfLevel']")).getAttribute("value");
//				 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow",  i, 5, NSQfLevel);
//				 
//				 String trainingHours = driver.findElement(By.xpath("//input[@formcontrolname='proposedHours']")).getAttribute("value");
//				 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow",  i, 6, trainingHours);
//				
//				
//				
//				String Targets=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", i, 7);
//				Thread.sleep(2000);
//				Schemepage.EnterSectorAndJobTarget(Targets);
//				Thread.sleep(2000);
//				Schemepage.ClickOnSavebutton();
//				Thread.sleep(3000);
//			}
//			//Add location
//			String numberOfLocations=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddLocation", 1, 1);
//		 	int totalLocations=Integer.parseInt(numberOfLocations);
//			
//			for(int i=1;i<=totalLocations;i++)
//			{
//				String states=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddLocation", i, 2);
//				Schemepage.selectState(states);
//			String districts =ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddLocation", i, 3);
//			Schemepage.selectDistrict(districts);
//			Thread.sleep(3000);
//			Schemepage.clickAdd();
//			String Targets=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", i, 7);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//input[@formcontrolname='target'])["+i+"]")).sendKeys(Targets);
//			
//			}
//			
//			 Thread.sleep(5000);
//			 Schemepage.ClickOnSaveAndNextButton();
//			 Thread.sleep(10000);
//			 
//			 Schemepage.ClickOnTPSigned_TermSheetBrowse();
//				Thread.sleep(3000);
//				UploadFile.upload(img);
//				Thread.sleep(3000);
//				Schemepage.clickOnTPSigned_TermSheetUpLoad();
//				Thread.sleep(3000);
//				Schemepage.ClickOnIndemnityBrowse();
//				Thread.sleep(3000);
//				UploadFile.upload(img);
//				Thread.sleep(3000);
//				Schemepage.ClickOnIndemnityBrowseUpLoad();
//				Thread.sleep(5000);
//			   Schemepage.ClickOnSaveAndSubmit();
//			   Schemepage.ClickonOK();
//			    Thread.sleep(5000);
//			    Schemepage.ClickonOK();
//			    Thread.sleep(6000);
//			    driver.findElement(By.xpath("//a[i[@class='la la-ellipsis-h']]")).click();
//			    Thread.sleep(3000);
//			    driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//			    Thread.sleep(3000);
//			    
//			    String status="Approval in Progress";
//			    Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Approval in Progress']")).getText(),status );
//						    
//			    
//			  LogOutPage plp = new LogOutPage(driver);
//			     Thread.sleep(3000);
//				plp.clickOnProfileLogo();
//				 Thread.sleep(3000);
//				plp.clickOnLogout(); 
//		 
//	}
//	@DataProvider
//	public Object[][] approveProject_RPL()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "ApproveProject_RPL_TC02");
//	}
//	
//	@Test(dataProvider="approveProject_RPL",dependsOnMethods="addProject_RPL_TC_01")
//	public void approveProject_RPL_TC_02(String sno,String loginid,String password,String tpId,
//			String ExpectedProjectProposalID,String ExpectedProjectName,String ExpectedRPLtype,
//			String ExpectedMiniumBatchSize,String ExpectedMaximumSize,String ExpetedAgreementDate,
//			String ExpectedProjectDuration,String ExpectedTarget,String ExpetedAssessmentMode,
//			String AssessorCertified,String MultipleorSpillOverAssessmentDateisAllowed,String TrainerCertified, 
//			String AttendanceMode,String Comments,String advancedpayment ,String Advancedamount,
//			String ceilingcostdiscount,String discountOnAssessment1,String discountOnAssessment2,
//			String approvedBy,String referenceId,String approvalDate,String img,String Pmu_comments )throws Exception
//	{
//		precondition();
//		int srno = Integer.parseInt(sno);
//		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//	     bsp.clickToClose();
//		Thread.sleep(3000);
//     EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(loginid, password);
//		Thread.sleep(3000);
//		RPL_dashboardpage dp= new RPL_dashboardpage(driver);
//		dp.ClicKOnRPLSchemeAddrequest();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpId+"']]]])[1]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//	    driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpId+"']]]])[1]//a[contains(text(),'View Details')]")).click();
////	    Thread.sleep(5000);
////	    Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='projectProposalId']")).getAttribute("value"),ExpectedProjectProposalID);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter project name']")).getAttribute("value"),ExpectedProjectName );
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='min']")).getAttribute("value"),ExpectedMiniumBatchSize);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='max']")).getAttribute("value"),ExpectedMaximumSize);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Date']")).getAttribute("value"),ExpetedAgreementDate );
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='projectDuration']")).getAttribute("value"),ExpectedProjectDuration);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='target']")).getAttribute("value"),ExpectedTarget);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='assessmentMode']")).getAttribute("value"),ExpetedAssessmentMode );
//		PMU_RPL_Schmepage pmu= new PMU_RPL_Schmepage(driver);
//		
//		pmu.SelectAssessorCertified(AssessorCertified);
//		Thread.sleep(3000);
//		pmu.SelectSpillOverAssessment(MultipleorSpillOverAssessmentDateisAllowed);
//		Thread.sleep(3000);
//		pmu.SelecttrainerCertified(TrainerCertified);
//		Thread.sleep(3000);
//		pmu.SelectAttendanceMode(AttendanceMode);
//		Thread.sleep(3000);
//		pmu.EnterprojectDetailsComments(Comments);
//		Thread.sleep(3000);
//		pmu.ClickOnSaveAndNextButton();
//		Thread.sleep(10000);
//		pmu.EnterlocationCommentComments(Comments);//location comments
//		
//		Thread.sleep(3000);
//		pmu.ClickOnSaveAndNextButton();
//		Thread.sleep(10000);
//		pmu.SelectadvancePayment(advancedpayment);
//		Thread.sleep(3000);
//		pmu.Enteramount(Advancedamount);
//		Thread.sleep(3000);
//		pmu.EnterdiscountOnCeilingCostTextBox(ceilingcostdiscount);
//		Thread.sleep(3000);
//	    pmu.EnterdiscountOnAssessmentFee1(discountOnAssessment1);
//	    Thread.sleep(3000);
//	   pmu.EnterdiscountOnAssessmentFee2(discountOnAssessment2);
//	    Thread.sleep(3000);
//	    pmu.ClickOnDownloadSignerTermSheet();
//	    Thread.sleep(3000);
//	    pmu.SelectapprovedBy(approvedBy);
//	    Thread.sleep(3000);
//	    pmu.EnterreferenceId(referenceId);
//	    Thread.sleep(3000);
//	   pmu.SelectApprovalDate(approvalDate);
//	   Thread.sleep(3000);
//	    Thread.sleep(3000);
//	    pmu.ClickOnApprovalDocumentsBrowser();
//	    Thread.sleep(3000);
//	    UploadFile.upload(img);
//	    Thread.sleep(3000);
//	    pmu.ClickOnUploadButton();
//	    Thread.sleep(5000);
//	    pmu.Selectpmu_CommentsTextBox(Pmu_comments);
//	    Thread.sleep(5000);
//	    pmu.ClickOnSaveAndSubmit();
//	    Thread.sleep(5000);
//	    pmu.ClickOnOK();
//	    Thread.sleep(3000);
//	    pmu.ClickOnOK();
//	    Thread.sleep(3000);
//	    LogOutPage plp = new LogOutPage(driver);
//	     Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		 Thread.sleep(3000);
//		plp.clickOnLogout(); 
//	    
//	}
	@DataProvider
	public Object[][] AddCamps()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddCampsWorkFlow_TC03");
	}
	
	@Test(dataProvider="AddCamps")//,dependsOnMethods="approveProject_RPL_TC_02")
	public void AddCamps_TC_03(String sno,String loginid,String password,String Trainingtype,String Subscheme)throws Exception
	{
		precondition();
		int srno = Integer.parseInt(sno);
		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	     bsp.clickToClose();
		Thread.sleep(3000);
        EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(loginid, password);
		Thread.sleep(3000);
		DashboardPage db = new DashboardPage(driver);
		db.ClickMySchemeOrPrograms();
		//////
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	    driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[contains(text(),'View Details')]")).click();
	    Thread.sleep(3000);
	    AddCampsPage camps= new AddCampsPage(driver);
	    camps.ClickOnRPL_action();
	    camps.ClickOnViewDetails();
		
		
//		 WebElement MySchemesListTable = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']"));
//			
//			List<WebElement> rowstable = MySchemesListTable.findElements(By.tagName("tr"));
//	
//			int rows_count = rowstable.size();
//	
//			for (int row = 1; row < rows_count; row++) {
//	
//		 String TrainingType	 = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[3]")).getText();
//	
//					String SUBScheme = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr//td[span[span[text()='"+Subscheme+"']]]")).getText();
//					
//					if (TrainingType.equals(Trainingtype)&& SUBScheme.equals(Subscheme))
//					{
//						
//						Thread.sleep(2000);
//						driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//					    driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[contains(text(),'View Details')]")).click();
//					    Thread.sleep(3000);
//					break;
//					}
//					
//				}
		
	
	}
	
}
