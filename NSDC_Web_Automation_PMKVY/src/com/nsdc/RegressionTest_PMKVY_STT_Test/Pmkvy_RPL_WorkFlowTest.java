package com.nsdc.RegressionTest_PMKVY_STT_Test;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.AddCampsPage;
import com.nsdc.Pages_PMKVY_Pages.AssessmentAgencyPage;
import com.nsdc.Pages_PMKVY_Pages.AssessmentCertificationPage;
import com.nsdc.Pages_PMKVY_Pages.AssessorPage;
import com.nsdc.Pages_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
import com.nsdc.Pages_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_PMKVY_Pages.ListofEligibleCandiatePage;
import com.nsdc.Pages_PMKVY_Pages.LogOutPage;
import com.nsdc.Pages_PMKVY_Pages.MySchemeOrProjectPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_SPPMU_SelectedSchemepage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_Type_RPL_SchemePage;
import com.nsdc.Pages_PMKVY_Pages.PMU_RPL_Schmepage;
import com.nsdc.Pages_PMKVY_Pages.RPL_dashboardpage;
import com.nsdc.Pages_PMKVY_Pages.RPl_createBatchpage;
import com.nsdc.Pages_PMKVY_Pages.Rpl_addTrainerpage;
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.TrainingCalenderPage;
import com.nsdc.generic.UploadFile;
import com.nsdc.testConfig.TestConfiguration;

public class Pmkvy_RPL_WorkFlowTest extends TestConfiguration {

	@DataProvider
	public Object[][] addProject_RPL()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01");
	}
	
//@Test(dataProvider="addProject_RPL")
	public void addProject_RPL_TC_01(String sno,String loginid, String password,String SelectedScheme,
			String Trainingtype,String Subscheme,
			String ProjectProposalID,String ProjectName,String rpltype,String miniumSize,String maximumSize,
			String agreementDate,String projectduration,String orgName,String fullname,String designation
			,String mobilenumber,String email,String Address,String target,String assessmentMode,String duallogo,String img) throws Exception
	{
		precondition();
		int srno = Integer.parseInt(sno);
//		Thread.sleep(3000);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
		LaunchPage lp = new LaunchPage(driver);
		Thread.sleep(3000);
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
		MySchemeOrProjectPage msp = new MySchemeOrProjectPage(driver);
		msp.ClickApplySchemeProgram();
		SelectSchemeOrProgramPage ssp = new SelectSchemeOrProgramPage(driver);
		Thread.sleep(3000);
		ssp.ClickPageNumber2();
		//ssp.ClickPageNumber3();
       
       Thread.sleep(3000);
       WebElement MySchemesListTable = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table notranslate']"));
		
		List<WebElement> rowstable = MySchemesListTable.findElements(By.tagName("tr"));

		int rows_count = rowstable.size();

		for (int row = 1; row < rows_count; row++) {

	 String TrainingType	 = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table notranslate']//tr["+row+"]//td[3]")).getText();

				String SUBScheme = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table notranslate']//tr//td[span[span[text()='"+Subscheme+"']]]")).getText();
				
				if (TrainingType.equals(Trainingtype)&& SUBScheme.equals(Subscheme))
				{
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[i[@class='la la-ellipsis-h']]")).click();
				    driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[contains(text(),'Add Project')]")).click();
				    Thread.sleep(3000);
				break;
				}
				
			}
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'"+SelectedScheme+"')]")).getText(), SelectedScheme);
		
		
		PMKVY_Type_RPL_SchemePage Schemepage=new PMKVY_Type_RPL_SchemePage(driver);
		
		Thread.sleep(3000);
		Schemepage.EnterTheProjectProposalID(ProjectProposalID);
	Thread.sleep(3000);
		Schemepage.EnterTheProjecName(ProjectName);
		String rplType = driver.findElement(By.xpath("(//label[@class='col-lg-3 col-form-label'])[3]/..//select[@formcontrolname='rplType']")).getText();
		
		ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno, 8, rplType);
		Thread.sleep(3000);
		Schemepage.ClickProjectType();
		Thread.sleep(3000);
		 String minimumbatchSize=driver.findElement(By.xpath("//input[@placeholder='Enter Proposed Minimum Batch Size']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,9, minimumbatchSize);
		 String MaximumbatchSize=driver.findElement(By.xpath("//input[@placeholder='Enter Proposed Maximum Batch Size']")).getAttribute("value");
		
		 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,10,MaximumbatchSize );
		 Schemepage.ClickOnAgreementDate();
	Thread.sleep(3000);
		 Schemepage.SelectAgreementDate(agreementDate);
		 Thread.sleep(3000);
		 Schemepage.EnterProjectDuration(projectduration);
		 Thread.sleep(3000);
		 Schemepage.EnterFacilitatorOrganizationNameTextBox(orgName);
		 Thread.sleep(3000);
		 Schemepage.ClickOnAddButton();
		 Thread.sleep(3000);
		 Schemepage.ClickOnAddPromoterButton();
		 Thread.sleep(3000);
		 Schemepage.EnterTheFullName(fullname);
		 Schemepage.EnterDesignationTextbox(designation);
		 Schemepage.EnterMobilenumberTextbox(mobilenumber);
		 Schemepage.EnterEmailAdress(email);
		 Schemepage.ClickOnUploadDocumentRadiobutton();
		 Schemepage.EnterAdress(Address);
		 Thread.sleep(3000);
		 Schemepage.ClickOnSubmit();
		 Thread.sleep(3000);
		 Schemepage.EnterprojectTarget(target);
		 String assessmentMode1 = driver.findElement(By.xpath("//input[@placeholder='Assessment Mode']")).getAttribute("value");
		 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,20,assessmentMode1);
		 Schemepage.SelectdualLogoDropdownlist(duallogo);
		 if(duallogo.equalsIgnoreCase("yes"))
		 {
		 Schemepage.ClickOnDuallogoBrowser();
		 
		 UploadFile.upload(img);
		 Thread.sleep(3000);
		 Schemepage.ClickonUploadButton();
		 Thread.sleep(3000);
		 }
	
//		 String NameofPrimarySPOC = driver.findElement(By.xpath("//input[@class='form-control m-input ng-pristine ng-valid ng-touched']")).getAttribute("value");
//		 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,,assessmentMode );
		 Thread.sleep(3000);
		 Schemepage.ClickOnSaveAndNextButton();
		 Thread.sleep(3000);
		
		 String numberOfSectors_jobroles=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", 1, 1);
		 	int total_sectors_jobRoles=Integer.parseInt(numberOfSectors_jobroles);
		 	
			for(int i=1;i<=total_sectors_jobRoles;i++)
			{
				Thread.sleep(10000);
				Schemepage.ClickOnAddSectorsAndjobRole();
				Thread.sleep(2000);
				
				String Sectors=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", i, 2);
				String JobRoles=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", i, 3);
				Schemepage.SelectSector(Sectors);
				Thread.sleep(1000);
				Schemepage.SelectjobRoleName(JobRoles);
				Thread.sleep(1000);
				
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
				
				
				String Targets=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", i, 7);
				Thread.sleep(2000);
				Schemepage.EnterSectorAndJobTarget(Targets);
				Thread.sleep(2000);
				Schemepage.ClickOnSavebutton();
				Thread.sleep(3000);
			}
			//Add location
			String numberOfLocations=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddLocation", 1, 1);
		 	int totalLocations=Integer.parseInt(numberOfLocations);
			
			for(int i=1;i<=totalLocations;i++)
			{
				String states=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddLocation", i, 2);
				Schemepage.selectState(states);
			String districts =ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddLocation", i, 3);
			Schemepage.selectDistrict(districts);
			Thread.sleep(3000);
			Schemepage.clickAdd();
			String Targets=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddsectorsAndJObRole _workflow", i, 7);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@formcontrolname='target'])["+i+"]")).sendKeys(Targets);
			break;
			
			}
			
			 Thread.sleep(5000);
			 Schemepage.ClickOnSaveAndNextButton();
			 Thread.sleep(10000);
			 
			 Schemepage.ClickOnTPSigned_TermSheetBrowse();
				Thread.sleep(3000);
				UploadFile.upload(img);
				Thread.sleep(3000);
				Schemepage.clickOnTPSigned_TermSheetUpLoad();
				Thread.sleep(3000);
				Schemepage.ClickOnIndemnityBrowse();
				Thread.sleep(3000);
				UploadFile.upload(img);
				Thread.sleep(3000);
				Schemepage.ClickOnIndemnityBrowseUpLoad();
				Thread.sleep(5000);
			   Schemepage.ClickOnSaveAndSubmit();
			   Thread.sleep(10000);
			   Schemepage.ClickonOK();
			    Thread.sleep(10000);
			    Schemepage.ClickonOK();
			    Thread.sleep(10000);
//			    driver.findElement(By.xpath("(//a[i[@class='la la-ellipsis-h']])[3]")).click();
//			    Thread.sleep(3000);
//			    driver.findElement(By.xpath("(//a[contains(text(),'View Details')])[3]")).click();
//			    Thread.sleep(3000);
//			    
//			    String status="Approval in Progress";
//			    Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Approval in Progress']")).getText(),status );
//						    
			    
			  LogOutPage plp = new LogOutPage(driver);
			     Thread.sleep(3000);
				plp.clickOnProfileLogo();
				 Thread.sleep(3000);
				plp.clickOnLogout(); 
		 
	}

	@DataProvider
	public Object[][] approveProject_RPL()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "ApproveProject_RPL_TC02");
	}
	
	//@Test(dataProvider="approveProject_RPL")//dependsOnMethods="addProject_RPL_TC_01")
	public void approveProject_RPL_TC_02(String sno,String loginid,String password,String tpId,
			String ExpectedProjectProposalID,String ExpectedProjectName,String ExpectedRPLtype,
			String ExpectedMiniumBatchSize,String ExpectedMaximumSize,String ExpetedAgreementDate,
			String ExpectedProjectDuration,String ExpectedTarget,String ExpetedAssessmentMode,
			String AssessorCertified,String MultipleorSpillOverAssessmentDateisAllowed,String TrainerCertified, 
			String AttendanceMode,String Comments,String advancedpayment ,String Advancedamount,
			String ceilingcostdiscount,String discountOnAssessment1,String discountOnAssessment2,
			String approvedBy,String referenceId,String approvalDate,String img,String Pmu_comments )throws Exception
	{
		precondition();
		int srno = Integer.parseInt(sno);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	     bsp.clickToClose();
		Thread.sleep(3000);
     EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(loginid, password);
		Thread.sleep(3000);
		RPL_dashboardpage dp= new RPL_dashboardpage(driver);
		dp.ClicKOnRPLSchemeAddrequest();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpId+"']]]])[1]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	    driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpId+"']]]])[1]//a[contains(text(),'View Details')]")).click();
//	    Thread.sleep(5000);
//	    Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='projectProposalId']")).getAttribute("value"),ExpectedProjectProposalID);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter project name']")).getAttribute("value"),ExpectedProjectName );
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='min']")).getAttribute("value"),ExpectedMiniumBatchSize);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='max']")).getAttribute("value"),ExpectedMaximumSize);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Date']")).getAttribute("value"),ExpetedAgreementDate );
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='projectDuration']")).getAttribute("value"),ExpectedProjectDuration);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='target']")).getAttribute("value"),ExpectedTarget);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='assessmentMode']")).getAttribute("value"),ExpetedAssessmentMode );
		PMU_RPL_Schmepage pmu= new PMU_RPL_Schmepage(driver);
		
		pmu.SelectAssessorCertified(AssessorCertified);
		Thread.sleep(3000);
		pmu.SelectSpillOverAssessment(MultipleorSpillOverAssessmentDateisAllowed);
		Thread.sleep(3000);
		pmu.SelecttrainerCertified(TrainerCertified);
		Thread.sleep(3000);
		pmu.SelectAttendanceMode(AttendanceMode);
		Thread.sleep(3000);
		pmu.EnterprojectDetailsComments(Comments);
		Thread.sleep(3000);
		pmu.ClickOnSaveAndNextButton();
		Thread.sleep(10000);
		pmu.EnterlocationCommentComments(Comments);//location comments
		
		Thread.sleep(3000);
		pmu.ClickOnSaveAndNextButton();
		Thread.sleep(10000);
		pmu.SelectadvancePayment(advancedpayment);
		Thread.sleep(3000);
		pmu.Enteramount(Advancedamount);
		Thread.sleep(3000);
		pmu.EnterdiscountOnCeilingCostTextBox(ceilingcostdiscount);
		Thread.sleep(3000);
	    pmu.EnterdiscountOnAssessmentFee1(discountOnAssessment1);
	    Thread.sleep(3000);
//	   pmu.EnterdiscountOnAssessmentFee2(discountOnAssessment2);
//	    Thread.sleep(3000);
	    pmu.ClickOnDownloadSignerTermSheet();
	    Thread.sleep(3000);
	    pmu.SelectapprovedBy(approvedBy);
	    Thread.sleep(3000);
	    pmu.EnterreferenceId(referenceId);
	    Thread.sleep(1000);
	    pmu.ClickOnApprovalDate();
	    Thread.sleep(1000);
	   pmu.SelectApprovalDate(approvalDate);
	   Thread.sleep(3000);
	    Thread.sleep(3000);
	    pmu.ClickOnApprovalDocumentsBrowser();
	    Thread.sleep(3000);
	    UploadFile.upload(img);
	    Thread.sleep(3000);
	    pmu.ClickOnUploadButton();
	    Thread.sleep(5000);
	    pmu.Selectpmu_CommentsTextBox(Pmu_comments);
	    Thread.sleep(5000);
	    pmu.ClickOnSaveAndSubmit();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();
	   Thread.sleep(5000);
	    pmu.ClickOnOK();
	    Thread.sleep(5000);
	    LogOutPage plp = new LogOutPage(driver);
	     Thread.sleep(3000);
		plp.clickOnProfileLogo();
		 Thread.sleep(3000);
		plp.clickOnLogout(); 
	    
	}
	@DataProvider
	public Object[][] AddCamps()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddCampsWorkFlow_TC03");
	}
	
	//@Test(dataProvider="AddCamps")//,dependsOnMethods="approveProject_RPL_TC_02")
	public void AddCamps_TC_03(String sno,String loginid,String password,String campsid,String Trainingtype,
			String Subscheme,String locationName,String address,String pincode,String state,String district,
			String ParliamentaryConsistuency,String Spocname,String contactnumber,String email,String sector,
			String jobrole,String target)throws Exception
	{
		precondition();
		int srno = Integer.parseInt(sno);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		 Thread.sleep(3000);
	    driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[contains(text(),'View Details')]")).click();
	    Thread.sleep(3000);
	    AddCampsPage camps= new AddCampsPage(driver);
	    camps.ClickOnRPLAction();
	    camps.ClickOnViewDetails();
	    Thread.sleep(3000);
	    camps.ClickonViewCamps();
	    Thread.sleep(3000);
	    camps.ClickOnAdd_Camps();
	    Thread.sleep(3000);
	    camps.EnterlocationName(locationName);
	    Thread.sleep(3000);
	    camps.EnterAddress(address);
	    Thread.sleep(3000);
	    camps.EnterPincode(pincode);
	    Thread.sleep(3000);
	   // camps.ClickOnstate();
	    camps.SelectState(state);
	    Thread.sleep(3000);
	    camps.selectDistrict(district);
	    Thread.sleep(3000);
	    camps.SelectParliamentaryConsistuency(ParliamentaryConsistuency);
	    Thread.sleep(3000);
	    camps.EnterPrimarySpocName(Spocname);
	    Thread.sleep(3000);
	    camps.EntercontactNumber(contactnumber);
	    Thread.sleep(3000);
	    camps.EnterEmailid(email);
	    Thread.sleep(3000);
	    camps.SelectSector(sector);
	    Thread.sleep(3000);
	    camps.SelectJobRole(jobrole);
	    Thread.sleep(3000);
	    camps.EnterTrainingTarget(target);
	    Thread.sleep(3000);
	    camps.ClickonAdd();
	    Thread.sleep(3000);
	    camps.ClickOnSaveChanges();
	    Thread.sleep(3000);
	    
	  String CampsAdd = driver.findElement(By.xpath("//h2[@id='swal2-title']")).getText();//h2[@id='swal2-title']
	  String arr[] = CampsAdd.split(" "); 
	     String CampsID1 = arr[arr.length-1];
	    String CampsID2 = CampsID1.replace("(", "");
	   String CampsIDLogin =CampsID2.replace(")", "");
	   ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddCampsWorkFlow_TC03", srno, 3, CampsIDLogin);
	   ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddTrainerWorkFlow_TC04", srno, 1, CampsIDLogin);
	   ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "CreateBatchWorkFlow_TC05", srno, 1, CampsIDLogin);
	   Thread.sleep(3000);
	   camps.ClickOnClose();
		
	   LogOutPage plp = new LogOutPage(driver);
	     Thread.sleep(3000);
		plp.clickOnProfileLogo();
		 Thread.sleep(3000);
		plp.clickOnLogout(); 
	}
	@DataProvider
	public Object[][] AddTrainer()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls",
				"AddTrainerWorkFlow_TC04");
	}
	
	//@Test(dataProvider="AddTrainer")//,dependsOnMethods="AddCamps_TC_03")
	public void addTrainer_TC_04(String sno,String loginid,String oldpassword,String newPassword,
			String confirmPassword,String trainerName,String trainerEmail,String Phonenumber,String aadharnumber,String img,String fromDate,
			String toDate,String jobroles,String mobileOtp,String emailOtp)throws Exception
	{
		precondition();
		int srno = Integer.parseInt(sno);
//		String randomNumbers = RandomStringUtils.randomNumeric(5);
//		String phNo = "49393"+randomNumbers;	
//		System.out.println(phNo);
//		 String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
//		    String email = "";
//		    String temp = RandomStringUtils.random(17, allowedChars);
//		    email = temp.substring(0, temp.length() - 9) + "@testdata.com";
//		    
//		System.out.println(email);
		
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	     bsp.clickToClose();
	     EnterLoginPage elp = new EnterLoginPage(driver);
			elp.performlogin(loginid,oldpassword);
			Thread.sleep(2000);
			elp.EnteroldPassword(oldpassword);
			elp.Enternewpassword(newPassword);
			Thread.sleep(2000);
			elp.EnterConfirmPassword(confirmPassword);
			elp.ClickOnResetAndRelogin();
			Thread.sleep(3000);
			elp.ClickOnOK();
			Thread.sleep(3000);
			 bsp.clickToClose();
			 elp.performlogin(loginid,newPassword);
			 Thread.sleep(3000);
			 DashboardPage db = new DashboardPage(driver);
				db.ClickMySchemeOrPrograms();
				Rpl_addTrainerpage trainer=new Rpl_addTrainerpage(driver);
				Thread.sleep(3000);
				trainer.ClickOnAdd_Camps();
				trainer.ClickOnviewDetails();
				Thread.sleep(3000);
				trainer.Projectlist_Action();
				trainer.Projectlist_viewDetailsIcon();
				Thread.sleep(2000);
				trainer.ClickOnViewTrainers();
				Thread.sleep(10000);
				trainer.ClickOnAddTrainer();
				Thread.sleep(3000);
				trainer.EnterName(trainerName);
				trainer.EnterEmail(trainerEmail);
				trainer.EnterPhoneNumber(Phonenumber);
				
				
				trainer.ClickOnAdhaarRadio();
				Thread.sleep(2000);
				trainer.EnterThePanOrAadharNumber(aadharnumber);
				Thread.sleep(2000);
				trainer.ClickOnPanUploadBrowser();
				Thread.sleep(2000);
				
				UploadFile.upload(img);
				Thread.sleep(5000);
				trainer.ClickOnPanUploadButton();
				Thread.sleep(5000);
				trainer.ClickOnFromDate();
				Thread.sleep(2000);
				trainer.SelectFromDate(fromDate);
				trainer.ClickOnToDate();
				Thread.sleep(2000);
				trainer.SelectTODate(toDate);
				trainer.ClickOnassociatedDocumentsBrowser();
				Thread.sleep(2000);
				UploadFile.upload(img);
				Thread.sleep(5000);
				trainer.ClickOnassociatedDocumentUpload();
				Thread.sleep(2000);
				trainer.SelectAssociatedJobRoles(jobroles);
				Thread.sleep(2000);
				trainer.ClickOnGenerateOtp();
				Thread.sleep(2000);
				trainer.EnterMobileOtp(mobileOtp);
				Thread.sleep(2000);
				trainer.EnterEmailOtp(emailOtp);
				Thread.sleep(2000);
				trainer. ClickOnVerifyOtp();
				String trainerID=driver.findElement(By.xpath("(//tbody//tr//td[2]//span)[2]")).getText();
				
				 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "CreateBatchWorkFlow_TC05", 1, 8, trainerID);
//				  LogOutPage plp = new LogOutPage(driver);
//				     Thread.sleep(3000);
//					plp.clickOnProfileLogo();
//					 Thread.sleep(3000);
//					plp.clickOnLogout(); 
}

	@DataProvider
	public Object[][] CreateBatch()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls",
				"CreateBatchWorkFlow_TC05");
	}
	
	@Test(dataProvider="CreateBatch")//,dependsOnMethods="addTrainer_TC_04")
	public void CreateBatch_TC_05(String sno,String loginid,String password,String AssociatedQP_JobRole,
			String tryingHours,String BatchInTiming,String batchoutTime,String batchStartDate,String trainerName,
			String myTP,String canState,String CanDistric,String batchid)throws Exception
	{
		precondition();
		int srno = Integer.parseInt(sno);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	     bsp.clickToClose();
	     EnterLoginPage elp = new EnterLoginPage(driver);
	     elp.performlogin(loginid,password);
		 Thread.sleep(3000);
		 DashboardPage db = new DashboardPage(driver);
			db.ClickMySchemeOrPrograms();
			Rpl_addTrainerpage trainer=new Rpl_addTrainerpage(driver);
			Thread.sleep(5000);
			trainer.ClickOnAdd_Camps();
			trainer.ClickOnviewDetails();
			Thread.sleep(5000);
			trainer.Projectlist_Action();
			trainer.Projectlist_viewDetailsIcon();
			Thread.sleep(2000);
			trainer.ClickOnViewAllBatches();
			RPl_createBatchpage batch= new RPl_createBatchpage(driver);
			Thread.sleep(10000);
			batch.ClickOnCreateBatch();
			Thread.sleep(2000);
			batch.SelectAssociatedQP(AssociatedQP_JobRole);
			batch.EnterTrainingHours(tryingHours);
			batch.TAB_FromTrainingHours();
			Thread.sleep(2000);
			batch.ClickTrainingHours();
		    batch.TAB_FromTrainingHours();
		    batch.BatchinTimeSelect(BatchInTiming);
		    Thread.sleep(5000);
		    batch.BatchoutTimeSelect(batchoutTime);
			 batch.ClickAddBatchTiming(); 
			 Thread.sleep(1000); 
			 batch.ClickStartDate();
			 batch.SelectBatchStartDate(batchStartDate);
			   Thread.sleep(5000);
			 batch.SelectTrainerName(trainerName);
			   Thread.sleep(5000);
				batch.SelectAssessmentLanguage();
				   Thread.sleep(2000);
				 batch.ClickDisclaimer(); 
				   Thread.sleep(2000);
				batch.ClickOnSaveAndNext();
				Thread.sleep(10000);
				batch.ClickOnOKButton();
				Thread.sleep(3000);
				
				String batchid1 = driver.findElement(By.xpath("//h3//b[contains(text(),'Batch ID')]")).getText();
//				 String arr[] = batchid1.split(" "); 
//			     String BID1 = arr[arr.length-1];
//			    String BID2 =BID1.replace("(", "");
//			   String batchid2 =BID2.replace(")", "");
				
				
				ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "CreateBatchWorkFlow_TC05", 1, 12, batchid1);
				ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "A&CworkFlow_TC07", 1, 8, batchid1);
			
				
				
				
				
				
		/////////////////
		TrainingCalenderPage tcp = new TrainingCalenderPage(driver);
//		String sno1=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddTrainingCalender_TC06", 1, 0);
//		int totalSessions=Integer.parseInt(sno1);
//		for(int i=1;i<=totalSessions;i++)	
//		{  
//			Thread.sleep(3000);
//			String DayAndDate=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddTrainingCalender_TC06", i, 1);
//			String SessionPlan=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddTrainingCalender_TC06", i, 2);
//			String Description=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddTrainingCalender_TC06", i, 3);
//			String NOSTaught=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddTrainingCalender_TC06", i, 4);
//			String StartTime=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddTrainingCalender_TC06", i, 5);
//			String EndTime=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "AddTrainingCalender_TC06", i, 6);
//			Thread.sleep(3000);
//			tcp.ClickDayAndDate();
//			Thread.sleep(3000);
//			tcp.SelectDayAndDate(DayAndDate);
//			Thread.sleep(3000);
//			tcp.SelectSessionPlanned(SessionPlan);
//				tcp.SelectNOSTaught(NOSTaught);
//				Thread.sleep(3000);
//				tcp.TAB_FromNOSTaught();
//				tcp.EnterStartTime(StartTime);
//				Thread.sleep(3000);
//				//tcp.TAB_BatchIntime();
//				tcp.ClickonBatchOutTime();
//				tcp.EnterEndTime(EndTime);
//				tcp.EnterDescription(Description);
//		        tcp.ClickAddSession();
//		        Thread.sleep(5000);
//		
//			
//				
//		}		
//				
	    	Thread.sleep(3000);
			tcp.ClickSaveBtn();
			Thread.sleep(3000);
			tcp.ClickOnOKButton();
			Thread.sleep(3000);			
				
			tcp.ClickOnEnrollCandidates();
			Thread.sleep(3000);
			ListofEligibleCandiatePage enrollcandite= new ListofEligibleCandiatePage(driver);
			Thread.sleep(3000);
			String sourceofregistration="My TP/PIA/SPIA Candidates";
			enrollcandite.SelectSourceofregistration(sourceofregistration);
			Thread.sleep(3000);
			enrollcandite.SelectState(canState);
			enrollcandite.Selectdistric(CanDistric);
			enrollcandite.ClickOnApply();
			/*String modeOfmobilization=driver.findElement(By.xpath("(//tr[@formarrayname='candidates'])[1]//td[text()='Bulk Registered By TP']")).getText();
			
			if(modeOfmobilization.equalsIgnoreCase("Bulk Registered By TP"))
			{
				Thread.sleep(3000);
				enrollcandite.ClickOnCandiateIdCheckBox();
				Thread.sleep(3000);
			 	enrollcandite.ClickonEnrollCandidates();
			 	Thread.sleep(3000);
				enrollcandite.ClickOnOKButton();
			 	List<WebElement> adharid = driver.findElements(By.xpath("//tr//td//span[text()='Update Aadhaar']"));
			 	int id=adharid.size();
			 	for (int i=0;i<=id;i++) {
			 		adharid.get(i).click();
			 		WebElement adharidnumber = driver.findElement(By.xpath("//input[@formcontrolname='aadharNumber']"));
			 		
			 		
			 	}
			}
			else {*/
			enrollcandite.ClickOnCandiateIdCheckBox();//up to working fine
			String modelOfBandL="Self";
			String numCAN=ReadWriteData.getData("./TestData/Workflow/Pmkvy_RPL_workflow.xls","NumberOFenrollcandidates", 1, 0);
		 	int numberOfcan =Integer.parseInt(numCAN);
		 	for(int i=1;i<=numberOfcan;i++)	
			{    
		 		Thread.sleep(3000);
				WebElement BandLOpted = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[14]//span"));
				JavascriptExecutor executor2= (JavascriptExecutor) driver;
				executor2.executeScript("arguments[0].click();",BandLOpted );
		 		
				
		 		Thread.sleep(1000);
		 	WebElement modeofBk = driver.findElement(By.xpath("(//select[@formcontrolname='modeOfBkl'])["+i+"]"));
		 		  Select sel=new Select(modeofBk);
		 				  sel.selectByVisibleText(modelOfBandL);
		 				 Thread.sleep(1000);
			
			
			
		 	Thread.sleep(3000);
		 	enrollcandite.ClickonEnrollCandidates();
		 	Thread.sleep(3000);
			enrollcandite.ClickOnOKButton();
			Thread.sleep(3000);
			}
		 	enrollcandite.ClickonSubmitToEnrollcandidatesButton();
		 	Thread.sleep(3000);
		 	enrollcandite.ClickonYesButton();
			Thread.sleep(3000);
			
////		 	enrollcandite.ClickOnOKButton();
////			Thread.sleep(3000);
//			enrollcandite.ClickOnSubmit_To_SSC();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();
//		 	//enrollcandite.ClickOnOKButton();
//		 	
//		 	Thread.sleep(3000);
//		 	driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();
//		 	enrollcandite.ClickOnOKButton();
//		 	Thread.sleep(3000);
//		 	enrollcandite.ClickOnOKButton();
	
//////		 	 Thread.sleep(7000); 
//////		plp.clickOnProfileLogo();
//////				plp.clickOnLogout(); 
//				
				
				
}
	@DataProvider
	public Object[][] AssessementCertificationData() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls",
				"A&CworkFlow_TC07");
	}
	//@Test(dataProvider = "AssessementCertificationData")

	public void SSCtoAAData_01(String username, String password,String assignAssementAgency, String AAID,
			String AApassword,String assessorName,String AR,String ARpassword,String batchId) 
					throws Exception {

		precondition();
	LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
	Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	bsp.clickToClose();
	Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(username, password);
		Thread.sleep(3000); 
	AssessmentCertificationPage acp=new AssessmentCertificationPage(driver);
		Thread.sleep(3000);
		acp.ClickOnAssessmentCertification();
		Thread.sleep(4000);
		acp.ClickOnBatchAssigned();
		Thread.sleep(10000);
		acp.ClickOnAcceptedIcon();
		Thread.sleep(5000);
		acp.ClicKonAction();
		Thread.sleep(3000);
		acp.ClickOnAssignAssessmentAgency();
		Thread.sleep(3000);
		acp.SelectAAId(assignAssementAgency);
		Thread.sleep(3000);
		acp.ClickOnSubmitButton();
		Thread.sleep(5000);
		acp.ClickOnYesButton();
		Thread.sleep(3000);
		acp.ClickOnOkButton();
		Thread.sleep(3000);
      LogOutPage plp = new LogOutPage(driver);
			plp.clickOnProfileLogo();
			plp.clickOnLogout(); // //
			Thread.sleep(5000);
	}	
			
	//@Test(dataProvider = "AssessementCertificationData")
	public void AAdata(String username, String password,String assignAssementAgency, String AAID,
			String AApassword, String assessorName,String AR,String ARpassword,String batchid,String NumberOfenrollcandidates) 
					throws Exception {
		precondition();
	LaunchPage lp = new LaunchPage(driver);
//			lp.clickLogin();
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//			Thread.sleep(3000);
//			bsp.clickToClose();
			EnterLoginPage elp = new EnterLoginPage(driver);
//			Thread.sleep(3000);
//			elp.performlogin(AAID, AApassword);
//	AssessmentAgencyPage aap=new AssessmentAgencyPage(driver);
//			Thread.sleep(10000);
//			aap.ClickonAssessmentRequest();
//			Thread.sleep(5000);
//			aap. ClickonAction();
//			Thread.sleep(2000);
//			aap.ClickonAcceptBatch();
//			Thread.sleep(2000);
//			aap.ClickOnOkButton();
// 			Thread.sleep(3000);
// 			aap.ClickOnOkButton();
// 			Thread.sleep(5000);
//			aap.ClickOnAcceptedButton();
//		Thread.sleep(3000);
//		//aap.EnterBatchId(batchid);
//		//driver.findElement(By.xpath("//button[contains(text(),' Apply')]")).click();
//		Thread.sleep(3000);
//		aap.ClickOnAcceptedAction();
//			aap.ClickOnAssignAssessorIcon();
//			aap.SelectAssessor(assessorName);
//			aap.ClickOnSubmitButton();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[text()='Yes']")).click();
//			aap.ClickOnOkButton();
//			 LogOutPage plp = new LogOutPage(driver);
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout(); // //
//			Thread.sleep(5000);
			//AR flow
			lp.clickLogin();
			Thread.sleep(3000);
			bsp.clickToClose();
			Thread.sleep(3000);
			elp.performlogin(AR,ARpassword);
			Thread.sleep(3000);
			AssessorPage ar=new AssessorPage(driver);
			Thread.sleep(3000);
			ar.ClickOnAssessor();
			Thread.sleep(5000);
			ar.ClickOnAssessmentRequest();
//			Thread.sleep(2000);
//			ar.ClickonAction();
//			ar.ClickonAcceptBatch();
//			ar.ClickonYesButton();
//			ar.ClickOnOkButton();
			Thread.sleep(5000);
			ar.ClickonAssessedBatchRequest();
			Thread.sleep(5000);
			ar.EnterTheBAtchId(batchid);
			Thread.sleep(3000);
			ar.ClickOnApplyButton();
			Thread.sleep(3000);
			WebElement action = driver.findElement(By.xpath("//a[i[@class='la la-ellipsis-h']]"));
		    WebElement viewDetails = driver.findElement(By.xpath("//a[span[contains(text(),'View Details')]]"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();",action);
	    	Thread.sleep(3000);
	    	js.executeScript("arguments[0].click();",viewDetails);
				Thread.sleep(5000);
			ar.ClickOnAssessedCandidatesIcon();
			Thread.sleep(5000);
//			String pagenumber ="50";
//			ar.SelectPageDropdownlist(pagenumber);
//			Thread.sleep(5000);
//			
//			 JavascriptExecutor js1 = (JavascriptExecutor) driver;
//				js1.executeScript("window.scrollBy(0,-1500)");
//				Thread.sleep(5000);
//			int numberofcandidates=Integer.parseInt(NumberOfenrollcandidates);
//			List<WebElement> Attendencepresentcheckbox = driver.findElements(By.xpath("//label[@class='offset-1 m-radio present col-3']/span"));
//			for(int i=0;i<=numberofcandidates-1;i++)
//			{
//				Thread.sleep(3000);
//				Attendencepresentcheckbox.get(i).click();
//				Thread.sleep(3000);
//			}
//			
//			Thread.sleep(3000);
//			ar.ClickOnSubmitAttendenceButton();
//			Thread.sleep(3000);
//			ar.ClickonYes();
			////////
			String pagenumber ="50";
			ar.SelectPageDropdownlist(pagenumber);
			Thread.sleep(5000);
			
			 JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("window.scrollBy(0,-1500)");
				Thread.sleep(5000);
			String TotalCandidates=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", 1, 0);
		 	int NumberOFCandidates=Integer.parseInt(TotalCandidates);
			for(int i=1;i<=NumberOFCandidates;i++)
			{
		 String status = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[4]//span")).getText();
			
			if(status.equalsIgnoreCase("Marks Not Uploaded"))
			{ 
				
				String presentCan=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", 1, 1);
				int Numberofpresentcandidtes=Integer.parseInt(presentCan);
				for(int k=16;k<=Numberofpresentcandidtes;k++)
				{
				driver.findElement(By.xpath("(//span//a[i[@class='la la-ellipsis-h']])["+k+"]")).click();
				driver.findElement(By.xpath("(//a[span[contains(text(),'Upload Marks')]])")).click();
				String NosTypes=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", 1, 2);
				int numberOfNostypes=Integer.parseInt(NosTypes);
				for(int j=1;j<=numberOfNostypes;j++)
				   {      
			        String TheoryMarks=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", j, 3);
			        String PracticalMarks=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "UploadMarksSheet", j, 4);
			         driver.findElement(By.xpath("(//input[@id='compTheory'])["+j+"]")).sendKeys(TheoryMarks);
			         Thread.sleep(1000);
			 	     driver.findElement(By.xpath("(//input[@id='compPractical'])["+j+"]")).sendKeys(PracticalMarks);
			 	    }
			      Thread.sleep(3000);
				driver.findElement(By.xpath("//span[contains(text(),'Calculate & Upload')]")).click();
				 Thread.sleep(5000);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				Thread.sleep(3000);
				ar.SelectPageDropdownlist(pagenumber);
				Thread.sleep(10000);
//				driver.findElement(By.xpath("//button[text()='Go Back']")).click();
//				Thread.sleep(3000);
//				ar.ClickOnAssessedCandidatesIcon();
//					Thread.sleep(5000);
				}
			}
			
			}
			
		ar.ClickOnSubmitApprovalToAA_Button();
		//yesbutton
			Thread.sleep(3000);
			ar.ClickOnOkButton();
			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout(); // //
//			Thread.sleep(3000);
			
			 
	}	
	
	
	
}
