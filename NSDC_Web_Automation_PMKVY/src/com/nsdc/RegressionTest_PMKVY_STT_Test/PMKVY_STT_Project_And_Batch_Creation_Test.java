package com.nsdc.RegressionTest_PMKVY_STT_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
import com.nsdc.Pages_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_PMKVY_Pages.LogOutPage;
import com.nsdc.Pages_PMKVY_Pages.MySchemeOrProjectPage;
import com.nsdc.Pages_PMKVY_Pages.STT_AddProject;
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.testConfig.TestConfiguration;

public class PMKVY_STT_Project_And_Batch_Creation_Test extends TestConfiguration{


	@DataProvider
    public Object[][] projectAndBatchCreation()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflow.xls", "ProjectAndBatchCreation");
    }
    
    @Test(dataProvider="projectAndBatchCreation")
    public void Project_And_Batch_Creation(String userType, String name,String ProjectProposalID, String ProjecName, String aggrementDate, String StartDate, String EndDate) throws Exception
	{
		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		//Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		//Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(userType, name);
		DashboardPage db=new DashboardPage(driver);
		db.ClickMySchemeOrPrograms();
		MySchemeOrProjectPage msp=new MySchemeOrProjectPage(driver);
		msp.ClickApplySchemeProgram();
		SelectSchemeOrProgramPage ssp= new SelectSchemeOrProgramPage(driver);
		ssp.ClickPageNumber4();
		ssp.Click_STT_Actionbutton();
		ssp.ClickOn_STT_AddProject();
		STT_AddProject ap=new STT_AddProject(driver);
		ap.EnterTheProjectProposalID(ProjectProposalID);
		//ap.EnterTheProjecName(ProjecName);
		ap.ClickProjectType();
		ap.ClickAggrementDate();
		ap.SelectAggrementDate(aggrementDate);
		ap.ClickStartDate();
		ap.SelectProjectDurationStartDate(StartDate);
		ap.ClickEndDate();
		ap.SelectProjectDurationEndDate(EndDate);
		ap.ClickAddButton();
		
		
		
		
		
		//LogOutPage plp = new LogOutPage(driver);
		//plp.clickOnProfileLogo();
		//plp.clickOnLogout();
		
		
	}
}
