package com.nsdc.RegressionTest_PMKVY_STT_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
import com.nsdc.Pages_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_PMKVY_Pages.MySchemeOrProjectPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_Type_RPL_SchemePage;
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.testConfig.TestConfiguration;

public class Pmkvy_RPL_WorkFlowTest extends TestConfiguration {

	@DataProvider
	public Object[][] addProject_RPL()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01");
	}
	
	@Test(dataProvider="addProject_RPL")
	public void addProject_RPL_TC_01(String sno,String loginid, String password,String SelectedScheme,
			String Trainingtype,String Subscheme,
			String ProjectProposalID,String ProjectName,String rpltype,String miniumSize,String maximumSize,
			String agreementDate,String projectduration,String orgName,String fullname,String designation
			,String mobilenumber,String email,String Address,String target,String assessmentMode,String duallogo,String img) throws Exception
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
		MySchemeOrProjectPage msp = new MySchemeOrProjectPage(driver);
		msp.ClickApplySchemeProgram();
		SelectSchemeOrProgramPage ssp = new SelectSchemeOrProgramPage(driver);
		Thread.sleep(3000);
       ssp.ClickPageNumber2();
       Thread.sleep(3000);
       WebElement MySchemesListTable = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']"));
		
		List<WebElement> rowstable = MySchemesListTable.findElements(By.tagName("tr"));

		int rows_count = rowstable.size();

		for (int row = 1; row < rows_count; row++) {

	 String TrainingType	 = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[3]")).getText();

				String SUBScheme = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr//td[span[span[text()='"+Subscheme+"']]]")).getText();
				
				if (TrainingType.equals(Trainingtype)&& SUBScheme.equals(Subscheme))
				{
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
				    driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[contains(text(),'Add Project')]")).click();
				    Thread.sleep(3000);
				break;
				}
				
			}
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'"+SelectedScheme+"')]")).getText(), SelectedScheme);
		
		
		PMKVY_Type_RPL_SchemePage Schemepage=new PMKVY_Type_RPL_SchemePage(driver);
		
		
		Schemepage.EnterTheProjectProposalID(ProjectProposalID);
		Schemepage.EnterTheProjecName(ProjectName);
		String rplType = driver.findElement(By.xpath("(//label[@class='col-lg-3 col-form-label'])[3]/..//select[@formcontrolname='rplType']")).getText();
		
		ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno, 8, rplType);
		
		Schemepage.ClickProjectType();
		
		 String minimumbatchSize=driver.findElement(By.xpath("//input[@placeholder='Enter Proposed Minimum Batch Size']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,9, minimumbatchSize);
		 String MaximumbatchSize=driver.findElement(By.xpath("//input[@placeholder='Enter Proposed Maximum Batch Size']")).getAttribute("value");
		
		 ReadWriteData.setExcelData("./TestData/Workflow/Pmkvy_RPL_workflow.xls", "addProject_RPL_TC01", srno,10,MaximumbatchSize );
		 Schemepage.ClickOnAgreementDate();
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
		 
	}
	
}
