package com.nsdc.RegressionTest_PMKVY_STT_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
import com.nsdc.Pages_PMKVY_Pages.MySchemeOrProjectPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_SPPMUpage;
import com.nsdc.Pages_PMKVY_Pages.Pmkvy_SpecialProjectCreationPage;
import com.nsdc.Pages_PMKVY_Pages.SPPMU_All_TP_ProjectimplementingAgencypage;
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LaunchPage;
import com.nsdc.pages.LogOutPage;
import com.nsdc.testConfig.TestConfiguration;

public class PMKVY_SP_workflowTest extends TestConfiguration {
	@DataProvider
	public Object[][] CreateSpecialProjectData() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls",
				"Sp-workflow-data");
	}

	@Test(dataProvider = "CreateSpecialProjectData")

	public void addspecialprojectdata(String username, String password, String value, String projectproposalID,
			String projectname, String registeredAs, String proposingorganisationName, String state, String district,
			String img1, String img2,String loginId,String password2) throws Exception {

		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		// Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		// Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(username, password);
		Thread.sleep(3000);
		DashboardPage db = new DashboardPage(driver);
		db.ClickMySchemeOrPrograms();
		MySchemeOrProjectPage msp=new MySchemeOrProjectPage(driver);
		msp.ClickApplySchemeProgram();
		SelectSchemeOrProgramPage ssp= new SelectSchemeOrProgramPage(driver);
		ssp.ClickPageNumber3();
//ssp.selectValue(value);
		Thread.sleep(3000);
   ssp.ClickOn_SP_Action();
   ssp.ClickOn_SP_AddProject();
   
   Pmkvy_SpecialProjectCreationPage sp=new Pmkvy_SpecialProjectCreationPage(driver);
   Thread.sleep(2000);
sp.EnterTheProjectProposalID(projectproposalID);
sp.EnterTheProjecName(projectname);
sp.ClickProjectType();
sp.selectRegisteredAslist(registeredAs);
sp.EnterProposingOrganisationName(proposingorganisationName);
sp.selectState(state);
sp.selectDistrict(district);
Thread.sleep(3000);
sp.clickAdd();
sp.clickOnIndemnityBondBrowse();
Thread.sleep(3000);
UploadFile.upload(img1);
sp.clickOnIndemnityBondUploadButton();
Thread.sleep(3000);

sp.clickOnOtherSupportingDocumentsBrowse();
Thread.sleep(3000);
UploadFile.upload(img2);
sp.clickOnOtherSupportingDocumentsUpload();
Thread.sleep(3000);
sp.clickSaveAndSumbit();
Thread.sleep(3000);
LogOutPage plp = new LogOutPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		Thread.sleep(3000);
		lp.clickLogin();
		bsp.clickToClose();
		elp.performlogin(loginId, password2);
		PMKVY_SPPMUpage sppmu=new PMKVY_SPPMUpage(driver);
		Thread.sleep(3000);
		sppmu.ClickOnViewAllSchemeAddRequests();
		
		SPPMU_All_TP_ProjectimplementingAgencypage allPIA=new SPPMU_All_TP_ProjectimplementingAgencypage(driver);
		Thread.sleep(3000);
		allPIA.ClickOnAction();
		Thread.sleep(3000);
		allPIA.ClickOnViewDetails();
		


		

	}

}
