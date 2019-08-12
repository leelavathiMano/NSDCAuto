package com.nsdc.RegressionTest_PMKVY_STT_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
import com.nsdc.Pages_PMKVY_Pages.MySchemeOrProjectPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LaunchPage;
import com.nsdc.testConfig.TestConfiguration;

public class PMKVY_spworkflowTest extends TestConfiguration {
	@DataProvider
	public Object[][] CreateSpecialProjectData() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls",
				"Sp-workflow-data");
	}

	@Test(dataProvider = "CreateSpecialProjectData")

	public void addspecialprojectdata(String username, String password, String value, String projectproposalID,
			String projectname, String registeredAs, String proposingorganisationName, String state, String district,
			String img1, String img2) throws Exception {

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

		MySchemeOrProjectPage msp = new MySchemeOrProjectPage(driver);
		msp.ClickApplySchemeProgram();

	}

}
