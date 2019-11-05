package com.nsdc.RegressionTest_NON_PMKVY_STT_Test;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_NON_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_NON_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_NON_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_MySchemeDashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TrainingPartnerDashboardPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;

import com.nsdc.testConfig.TestConfiguration;

public class Feebased_AddschemeworkFlowTest extends TestConfiguration {
	@DataProvider
	public Object[][] addScheme_FeeBased() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Feebased_addschme_workflow/feebased_addscheme_workflowData.xls",
				"feebasedaddscheme");
	}
		@Test(dataProvider="addScheme_FeeBased")
		public void addSchemeTC_01(String tpUsername, String tpPassword,String schemeName,String Funded,String aggrementDate,String DisbursementDate,String ProjectID,String ProjectName) throws Exception
		{
		
			precondition();
			LaunchPage lp = new LaunchPage(driver);
			lp.clickLogin();
		Thread.sleep(3000);
			BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
			bsp.clickToClose();
			Thread.sleep(3000);
			EnterLoginPage elp = new EnterLoginPage(driver);
			elp.performlogin(tpUsername, tpPassword);
		
			TrainingPartnerDashboardPage tpd = new TrainingPartnerDashboardPage(driver);
			Thread.sleep(10000);
			tpd.clickOnMySchemes();
			TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
			Thread.sleep(3000);
			tpms.clickOnAddSchemeOrProgram();
			Thread.sleep(3000);
            tpms.ClickOnAction();
			tpms.ClickOnAddProgram();
			tpms.SelectFinancialModelType(Funded);
			tpms.ClickAggrementDate();
		
		//tpms.SelectAggrementDate(aggrementDate);
		tpms.ClickOnDate();	
		tpms.CliCkOnFirstDisbursementDate();
		//tpms.SelectFirstDisbursementDate(DisbursementDate);
		tpms.ClickOnDate();
		tpms.EnterProjectProosalID(ProjectID);
		tpms.EnterProject_Name(ProjectName);
		
		
	}
 

}
