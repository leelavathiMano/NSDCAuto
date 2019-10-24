package com.nsdc.RegressionTest_PMKVY_STT_Test;

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
import com.nsdc.testConfig.TestConfiguration;

public class AssessmentCertificationWorkflow_Test extends TestConfiguration {
	@DataProvider
	public Object[][] CreateSpecialProjectData() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls",
				"AssessmentCertification");
	}
	@Test(dataProvider = "CreateSpecialProjectData")

	public void Addspecialprojectdata_01(String username, String password,String assignAssessor, String AAID,String AApassword,String assessorName,String AR,String ARpassword) throws Exception {

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
		acp.ClickOnAcceptedIcon();
		Thread.sleep(3000);
		acp.ClicKonAction();
		Thread.sleep(3000);
		acp.ClickOnAssignAssessmentAgency();
		Thread.sleep(3000);
		acp.SelectAAId(assignAssessor);
		Thread.sleep(3000);
		acp.ClickOnSubmitButton();
		Thread.sleep(5000);
		acp.ClickOnOkButton();
		Thread.sleep(3000);
      LogOutPage plp = new LogOutPage(driver);
			plp.clickOnProfileLogo();
			plp.clickOnLogout(); // //
			Thread.sleep(5000);
			
			
			lp.clickLogin();
			bsp.clickToClose();
			elp.performlogin(AAID, AApassword);
			AssessmentAgencyPage aap=new AssessmentAgencyPage(driver);
			Thread.sleep(10000);
			aap.ClickonAssessmentRequest();
			Thread.sleep(2000);
			aap. ClickonAction();
			Thread.sleep(2000);
			aap.ClickonAcceptBatch();
			Thread.sleep(2000);
			aap.ClickonYesButton();
			Thread.sleep(2000);
			aap.ClickOnOkButton();
			Thread.sleep(3000);
			aap.ClickOnAcceptedButton();
		Thread.sleep(3000);
			aap.ClickOnAcceptedAction();
			aap.ClickOnAssignAssessorIcon();
			aap.SelectAssessor(assessorName);
			aap.ClickOnSubmitButton();
			Thread.sleep(2000);
			aap.ClickOnOkButton();
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout(); // //
			Thread.sleep(5000);
			
			lp.clickLogin();
			bsp.clickToClose();
			elp.performlogin(AR,ARpassword);
			
			AssessorPage ap=new AssessorPage(driver);
			ap.ClickOnAssessor();
			Thread.sleep(5000);
			ap.ClickOnAssessmentRequest();
			Thread.sleep(2000);
			ap.ClickonAction();
			
			ap.ClickonAcceptBatch();
			
			ap.ClickonYesButton();
			
			ap.ClickOnOkButton();
			Thread.sleep(5000);
}
}