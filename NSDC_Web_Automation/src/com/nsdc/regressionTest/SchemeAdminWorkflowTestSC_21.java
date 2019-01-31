package com.nsdc.regressionTest;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.nsdc.generic.GUIFunctionality;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BusinessOwner_AddASchemeOwnerPage;
import com.nsdc.pages.BusinessOwner_AllApprovalRequestsPage;
import com.nsdc.pages.BusinessOwner_ApproveOrRejectSchemesPage;
import com.nsdc.pages.BusinessOwner_AssignSchemePage;
import com.nsdc.pages.BusinessOwner_AssignToSchemeOwnerPage;
import com.nsdc.pages.BusinessOwner_Dashboardpage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.NSDCAdmin_AddBusinessOwnerPage;
import com.nsdc.pages.NSDCAdmin_CreateSchemePage;
import com.nsdc.pages.NSDCAdmin_DashboardPage;
import com.nsdc.pages.NSDCAdmin_ManageBusinessOwnersPage;
import com.nsdc.pages.NSDCAdmin_ManageUsersPage;
import com.nsdc.pages.NSDCAdmin_UserManagementPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.SchemeAdmin_AddQpsToSchemePage;
import com.nsdc.pages.SchemeAdmin_DashboardPage;
import com.nsdc.pages.SchemeAdmin_InstantialteJobRolesPage;
import com.nsdc.pages.SchemeAdmin_UpdateSchemeDetailsPage;
import com.nsdc.pages.SchemeAdmin_UpdateSchemePage;
import com.nsdc.pages.SchemeAdmin_ViewAllSchemesPage;
import com.nsdc.pages.SchemeAdmin_ViewAllSchemes_ViewSchemesDetailsPage;
import com.nsdc.pages.SchemeOwner_AddASchemeAdminPage;
import com.nsdc.pages.SchemeOwner_AllApprovalRequestsPage;
import com.nsdc.pages.SchemeOwner_ApproveOrRejectSchemesPage;
import com.nsdc.pages.SchemeOwner_AssignSchemePage;
import com.nsdc.pages.SchemeOwner_AssignToSchemeAdminPage;
import com.nsdc.pages.SchemeOwner_Dashboardpage;
import com.nsdc.testConfig.TestConfiguration;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;

public class SchemeAdminWorkflowTestSC_21 extends TestConfiguration {
	public String created_Bo_Username;
	public String created_So_Username;
	public String created_Sa_Username;

	public static void nsdcAdminLogin(WebDriver driver) throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin("NSDCADMIN", "Qwerty@123");
		Thread.sleep(10000);
	}

	/*
	 * @Test public void checkSikuli() throws Exception {
	 * GUIFunctionality.dateuploadFile(); }
	 */
	@DataProvider
	public Object[][] AddBusinessOwnerData() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls",
				"AddingBusinessOwner");
	}

	@Test(dataProvider = "AddBusinessOwnerData")
	public void schemeAdminTC_01(String serialNum, String created_BO_Username, String nsdcAdmin_Username,
			String nsdcAdmin_Password, String name_Of_User, String mobile_Number, String email_Id, String address,
			String near_By_Landmark, String pincode, String state_Or_UnionTerritory, String district,
			String tehsil_Or_Mandal_Or_Block, String city_Or_Village_Or_Town, String parliamentary_Constituency,
			String select_Scheme, String select_A_Scheme_Type, String select_A_Training_Type, String enter_Scheme_Name,
			String enter_Scheme_Department_Or_Ministry, String select_Payout_Advice, String assign_To_Business_Owner,
			String created_So_Username, String bo_Old_Password, String bo_New_Password, String bo_Confirm_Password,
			String so_Full_Name, String so_Email_Address, String so_Mobile_Number, String select_Scheme_Owner,
			String so_Old_Password, String so_New_Password, String so_Confirm_Password, String sa_Full_Name,
			String sa_Email_Address, String sa_Mobile_Number, String created_Sa_Username, String sa_Old_Password,
			String sa_New_Password, String sa_Confirm_Password, String description_Of_the_Scheme,
			String documents_Required, String prerequisite_To_Scheme, String uploadFile, String disability,
			String gender, String caste, String religion, String type_Of_Project_Implementing_Agency,
			String training_Centre_Registration_Process_Driven_By, String registration_Fee,
			String type_Of_Training_Partner_Or_PIA, String scheme_Registration_Fee, String scheme_Registration_Amount,
			String additional_Documents_Required, String target_Allocation_Required,
			String target_Allocation_Prohibition_For, String target_Allocated_At_Level, String location_Specificity,
			String select_District, String version, String submitted_Status, String approved_Status,
			String select_Sector, String select_SubSector, String search_By_QpCode) throws Exception {
		SchemeAdminWorkflowTestSC_21.nsdcAdminLogin(driver);
		NSDCAdmin_DashboardPage dp = new NSDCAdmin_DashboardPage(driver);
		dp.clickOnUserManagement();
		Thread.sleep(10000);
		NSDCAdmin_UserManagementPage userManagement = new NSDCAdmin_UserManagementPage(driver);
		userManagement.clickOnManageUsers();
		Thread.sleep(10000);
		NSDCAdmin_ManageUsersPage manageUsers = new NSDCAdmin_ManageUsersPage(driver);
		manageUsers.clickOnManageBusinessOwners();
		Thread.sleep(10000);
		NSDCAdmin_ManageBusinessOwnersPage manageBusinessOwner = new NSDCAdmin_ManageBusinessOwnersPage(driver);
		manageBusinessOwner.clickOnAddBusinessOwner();
		NSDCAdmin_AddBusinessOwnerPage addBusinessOwner = new NSDCAdmin_AddBusinessOwnerPage(driver);
		addBusinessOwner.enterNameOfTheUser(name_Of_User);
		addBusinessOwner.enterMobileNumber(mobile_Number);
		addBusinessOwner.enterEmailId(email_Id);
		addBusinessOwner.enterAddress(address);
		addBusinessOwner.enterNearByLandmark(near_By_Landmark);
		addBusinessOwner.enterPincode(pincode);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(6000);
		
		addBusinessOwner.selectStateOrUnionTerritory(state_Or_UnionTerritory);
		addBusinessOwner.selectDistrict(district);
		Thread.sleep(4000);
		addBusinessOwner.selectTehsilOrMandalOrBlock(tehsil_Or_Mandal_Or_Block);
		Thread.sleep(3000);
		addBusinessOwner.selectCityOrVillageOrTown(city_Or_Village_Or_Town);
		addBusinessOwner.selectParliamentaryConstituency(parliamentary_Constituency);
		Thread.sleep(6000);
		addBusinessOwner.clickOnSubmit();
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Business Owner created successfully')]"))
				.getText().trim(), "Business Owner created successfully");
		String createdBusiness_Owner = driver.findElement(By.xpath("//div[contains(text(),'Business Owner ID')]"))
				.getText();
		created_Bo_Username = createdBusiness_Owner.replace("Business Owner ID - ", "");
		System.out.println(created_Bo_Username);
		addBusinessOwner.clickOnOk();
		Thread.sleep(6000);
		ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
				Integer.parseInt(serialNum), 1, created_Bo_Username);
		ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
				Integer.parseInt(serialNum), 21, created_Bo_Username);
		// ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls",
		// "AddingSchemeOwner", Integer.parseInt(serialNum), 2, created_Bo_Username);
		manageBusinessOwner.enterBoUsername(created_Bo_Username);
		Thread.sleep(3000);
		manageBusinessOwner.clickOnSearch();
		Thread.sleep(3000);
		// Assert Business Owner Data
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + created_Bo_Username + "')]")).getText(),
				created_Bo_Username);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + email_Id + "')]")).getText(),
				email_Id);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + mobile_Number + "')]")).getText(),
				mobile_Number);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + state_Or_UnionTerritory + "')]")).getText(),
				state_Or_UnionTerritory);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + district + "')]")).getText(),
				district);
		Thread.sleep(2000);
		manageBusinessOwner.clickOnReset();
		Thread.sleep(3000);
		manageBusinessOwner.clickOnNsdcAdminDashboard();
		Thread.sleep(6000);
		dp.clickOnCreateScheme();
		Thread.sleep(10000);
		NSDCAdmin_CreateSchemePage createScheme = new NSDCAdmin_CreateSchemePage(driver);
		if (select_Scheme.equals("PMKVY")) {

			Thread.sleep(3000);
			createScheme.selectScheme(select_Scheme);
			createScheme.selectASchemeType(select_A_Scheme_Type);
			Thread.sleep(4000);

			if (select_A_Training_Type.equals("RPL") || select_A_Training_Type.equals("STT")
					|| select_A_Training_Type.equals("India Internal")
					|| select_A_Training_Type.equals("Special Project") || select_A_Training_Type.equals("Others")) {
				Thread.sleep(6000);
				createScheme.selectATrainingType(select_A_Training_Type);
				createScheme.selectPayoutAdvice(select_Payout_Advice);
				Thread.sleep(4000);
				createScheme.selectAssignToBusinessOwner(created_Bo_Username);
				Thread.sleep(4000);
			}
		}

		else if (select_Scheme.equals("NON-PMKVY") || select_Scheme.equals("Integration")) {
			Thread.sleep(3000);
			createScheme.selectScheme(select_Scheme);
			createScheme.enterSchemeName(enter_Scheme_Name);
			createScheme.enterSchemeDepartmentOrMinistry(enter_Scheme_Department_Or_Ministry);
			Thread.sleep(6000);
			createScheme.selectPayoutAdvice(select_Payout_Advice);
			Thread.sleep(4000);
			createScheme.selectAssignToBusinessOwner(created_Bo_Username);
			Thread.sleep(4000);
		}

		Thread.sleep(6000);
		createScheme.clickOnSubmitAndAssignToBusinessAdmin();
		Thread.sleep(6000);
		Assert.assertEquals(driver
				.findElement(By.xpath("//h2[contains(text(),'scheme created and assigned successfully')]")).getText(),
				"scheme created and assigned successfully");
		createScheme.clickOnOk();
		Thread.sleep(6000);
		dp.clickOnNewNSDCProfile();
		Thread.sleep(4000);
		dp.clickOnNSDCLogOut();
		Thread.sleep(4000);
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(created_Bo_Username, "ekaushal");
		Thread.sleep(2000);
		RegistrationPage rp = new RegistrationPage(driver);
		rp.enterOldPassword(bo_Old_Password);
		rp.enterNewPassword(bo_New_Password);
		rp.enterConfirmPassword(bo_Confirm_Password);
		rp.clickResetResubmit();
		Thread.sleep(2000);
		rp.clickConfirmationOkMessage();
		elp.performlogin(created_Bo_Username, bo_Confirm_Password);
		Thread.sleep(12000);
		BusinessOwner_Dashboardpage bo_Dashboard = new BusinessOwner_Dashboardpage(driver);
		bo_Dashboard.clickOnAddASchemeOwner();
		BusinessOwner_AddASchemeOwnerPage addSchemeOwner = new BusinessOwner_AddASchemeOwnerPage(driver);
		addSchemeOwner.enterFullName(so_Full_Name);
		addSchemeOwner.enterEmailAddress(so_Email_Address);
		addSchemeOwner.enterMobileNumber(so_Mobile_Number);
		Thread.sleep(3000);
		addSchemeOwner.clickOnSubmit();
		Thread.sleep(3000);
		String createdScheme_Owner = driver
				.findElement(By.xpath("//h2[contains(text(),'Scheme Admin created. Please save the username: ')]"))
				.getText();
		created_So_Username = createdScheme_Owner.replace("Scheme Admin created. Please save the username: ", "");
		System.out.println(created_So_Username);
		ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
				Integer.parseInt(serialNum), 22, created_So_Username);
		ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
				Integer.parseInt(serialNum), 29, created_So_Username);
		String soConfirmationMsg = "Scheme Admin created. Please save the username: " + created_So_Username;
		System.out.println(soConfirmationMsg);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[h2[contains(text(),'Scheme Admin created.')]]")).getText().trim(),
				soConfirmationMsg);
		Thread.sleep(4000);
		addSchemeOwner.clickOnOk();
		Thread.sleep(4000);
		bo_Dashboard.clickOnAssignToSchemeOwner();
		BusinessOwner_AssignToSchemeOwnerPage assignSchemeOwner = new BusinessOwner_AssignToSchemeOwnerPage(driver);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText().trim(),
				select_Scheme);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText().trim(),
				enter_Scheme_Name);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]"))
				.getText().trim(), select_A_Scheme_Type);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]"))
				.getText().trim(), select_A_Training_Type);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText().trim(),
				enter_Scheme_Department_Or_Ministry);
		if (select_A_Training_Type.equals("RPL")) {
			Thread.sleep(4000);
			assignSchemeOwner.clickOnRplAction();
			Thread.sleep(5000);
			assignSchemeOwner.clickOnRplAssignScheme();
		} else if (select_A_Training_Type.equals("STT")) {
			Thread.sleep(4000);
			assignSchemeOwner.clickOnSTTAction();
			Thread.sleep(5000);
			assignSchemeOwner.clickOnSTTAssignScheme();
		} else if (select_A_Training_Type.equals("India Internal")) {
			Thread.sleep(4000);
			assignSchemeOwner.clickOnIndiaInternalAction();
			Thread.sleep(5000);
			assignSchemeOwner.clickOnIndiaInternalAssignScheme();
		} else if (select_A_Training_Type.equals("Special Project")) {
			Thread.sleep(4000);
			assignSchemeOwner.clickOnSpecialProjectAction();
			Thread.sleep(5000);
			assignSchemeOwner.clickOnSpecialProjectAssignScheme();
		} else if (select_A_Training_Type.equals("Others")) {
			Thread.sleep(4000);
			assignSchemeOwner.clickOnOthersAction();
			Thread.sleep(5000);
			assignSchemeOwner.clickOnOthersAssignScheme();
		} else if (select_Scheme.equals("NON-PMKVY")) {
			Thread.sleep(4000);
			assignSchemeOwner.clickOnNonPMKVYAction();
			Thread.sleep(5000);
			assignSchemeOwner.clickOnNonPMKVYAssignScheme();
		} else if (select_Scheme.equals("Integration")) {
			Thread.sleep(4000);
			assignSchemeOwner.clickOnIntegrationAction();
			Thread.sleep(5000);
			assignSchemeOwner.clickOnIntegrationAssignScheme();
		}

		Thread.sleep(3000);
		BusinessOwner_AssignSchemePage assignScheme = new BusinessOwner_AssignSchemePage(driver);
		assignScheme.selectSchemeOwner(created_So_Username);
		Thread.sleep(3000);
		assignScheme.clickOnSubmitAndAssignScheme();
		Assert.assertEquals(driver.findElement(By.xpath("//div[h2[contains(text(),'scheme assigned successfully')]]"))
				.getText().trim(), "scheme assigned successfully");
		assignScheme.clickOnOk();
		Thread.sleep(5000);
		bo_Dashboard.clickOnBOProfile();
		Thread.sleep(5000);
		bo_Dashboard.clickOnBOLogOut();
		lp.clickLogin();
		elp.performlogin(created_So_Username, "ekaushal");
		Thread.sleep(3000);
		rp.enterOldPassword(so_Old_Password);
		rp.enterNewPassword(so_New_Password);
		rp.enterConfirmPassword(so_Confirm_Password);
		rp.clickResetResubmit();
		Thread.sleep(2000);
		rp.clickConfirmationOkMessage();
		elp.performlogin(created_So_Username, so_Confirm_Password);
		Thread.sleep(10000);
		SchemeOwner_Dashboardpage so_Dashboard = new SchemeOwner_Dashboardpage(driver);
		so_Dashboard.clickOnAddASchemeAdmin();
		SchemeOwner_AddASchemeAdminPage addSchemeAdmin = new SchemeOwner_AddASchemeAdminPage(driver);
		addSchemeAdmin.enterFullName(sa_Full_Name);
		addSchemeAdmin.enterEmailAddress(sa_Email_Address);
		addSchemeAdmin.enterMobileNumber(sa_Mobile_Number);
		Thread.sleep(3000);
		addSchemeAdmin.clickOnSubmit();
		String createdScheme_Admin = driver
				.findElement(By.xpath("//h2[contains(text(),'Scheme Admin created. Please save the username: ')]"))
				.getText();
		created_Sa_Username = createdScheme_Admin.replace("Scheme Admin created. Please save the username: ", "");
		System.out.println(created_Sa_Username);
		ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
				Integer.parseInt(serialNum), 36, created_Sa_Username);
		;
		String saConfirmationMsg = "Scheme Admin created. Please save the username: " + created_Sa_Username;
		System.out.println(saConfirmationMsg);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[h2[contains(text(),'Scheme Admin created.')]]")).getText().trim(),
				saConfirmationMsg);
		Thread.sleep(6000);
		addSchemeOwner.clickOnOk();
		Thread.sleep(6000);
		so_Dashboard.clickOnAssignToSchemeAdmin();
		SchemeOwner_AssignToSchemeAdminPage assignSchemeAdmin = new SchemeOwner_AssignToSchemeAdminPage(driver);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText().trim(),
				select_Scheme);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText().trim(),
				enter_Scheme_Name);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]"))
				.getText().trim(), select_A_Scheme_Type);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]"))
				.getText().trim(), select_A_Training_Type);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText().trim(),
				enter_Scheme_Department_Or_Ministry);
		if (select_A_Training_Type.equals("RPL")) {
			Thread.sleep(4000);
			assignSchemeAdmin.clickOnRplAction();
			Thread.sleep(5000);
			assignSchemeAdmin.clickOnRplAssignScheme();
		} else if (select_A_Training_Type.equals("STT")) {
			Thread.sleep(4000);
			assignSchemeAdmin.clickOnSTTAction();
			Thread.sleep(5000);
			assignSchemeAdmin.clickOnSTTAssignScheme();
		} else if (select_A_Training_Type.equals("India Internal")) {
			Thread.sleep(4000);
			assignSchemeAdmin.clickOnIndiaInternalAction();
			Thread.sleep(5000);
			assignSchemeAdmin.clickOnIndiaInternalAssignScheme();
		} else if (select_A_Training_Type.equals("Special Project")) {
			Thread.sleep(4000);
			assignSchemeAdmin.clickOnSpecialProjectAction();
			Thread.sleep(5000);
			assignSchemeAdmin.clickOnSpecialProjectAssignScheme();
		} else if (select_A_Training_Type.equals("Others")) {
			Thread.sleep(4000);
			assignSchemeAdmin.clickOnOthersAction();
			Thread.sleep(5000);
			assignSchemeAdmin.clickOnOthersAssignScheme();
		} else if (select_Scheme.equals("NON-PMKVY")) {
			Thread.sleep(4000);
			assignSchemeAdmin.clickOnNonPMKVYAction();
			Thread.sleep(5000);
			assignSchemeAdmin.clickOnNonPMKVYAssignScheme();
		} else if (select_Scheme.equals("Integration")) {
			Thread.sleep(4000);
			assignSchemeAdmin.clickOnIntegrationAction();
			Thread.sleep(5000);
			assignSchemeAdmin.clickOnIntegrationAssignScheme();
		}

		SchemeOwner_AssignSchemePage assignSchemeToSA = new SchemeOwner_AssignSchemePage(driver);
		assignSchemeToSA.selectSchemeOwner(created_Sa_Username);
		Thread.sleep(6000);
		assignSchemeToSA.clickOnSubmitAndAssignScheme();
		Assert.assertEquals(driver.findElement(By.xpath("//div[h2[contains(text(),'scheme assigned successfully')]]"))
				.getText().trim(), "scheme assigned successfully");
		assignSchemeToSA.clickOnOk();
		Thread.sleep(6000);
		so_Dashboard.clickOnSOProfile();
		Thread.sleep(4000);
		so_Dashboard.clickOnSOLogOut();
		Thread.sleep(6000);

		lp.clickLogin();
		elp.performlogin(created_Sa_Username, "ekaushal");
		Thread.sleep(3000);
		rp.enterOldPassword(sa_Old_Password);
		rp.enterNewPassword(sa_New_Password);
		rp.enterConfirmPassword(sa_Confirm_Password);
		rp.clickResetResubmit();
		Thread.sleep(2000);
		rp.clickConfirmationOkMessage();
		elp.performlogin(created_Sa_Username, sa_Confirm_Password);
		Thread.sleep(10000);
		SchemeAdmin_DashboardPage sa_Dashboard = new SchemeAdmin_DashboardPage(driver);
		sa_Dashboard.clickOnUpdateScheme();
		Thread.sleep(4000);
		SchemeAdmin_UpdateSchemePage updateScheme = new SchemeAdmin_UpdateSchemePage(driver);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText().trim(),
				select_Scheme);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText().trim(),
				enter_Scheme_Name);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]"))
				.getText().trim(), select_A_Scheme_Type);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]"))
				.getText().trim(), select_A_Training_Type);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText().trim(),
				enter_Scheme_Department_Or_Ministry);
		if (select_A_Training_Type.equals("RPL")) {
			Thread.sleep(4000);
			updateScheme.clickOnRplAction();
			Thread.sleep(5000);
			updateScheme.clickOnRplUpdateScheme();
		} else if (select_A_Training_Type.equals("STT")) {
			Thread.sleep(4000);
			updateScheme.clickOnSTTAction();
			Thread.sleep(5000);
			updateScheme.clickOnSTTUpdateScheme();
		} else if (select_A_Training_Type.equals("India Internal")) {
			Thread.sleep(4000);
			updateScheme.clickOnIndiaInternalAction();
			Thread.sleep(5000);
			updateScheme.clickOnIndiaInternalUpdateScheme();
		} else if (select_A_Training_Type.equals("Special Project")) {
			Thread.sleep(4000);
			updateScheme.clickOnSpecialProjectAction();
			Thread.sleep(5000);
			updateScheme.clickOnSpecialProjectUpdateScheme();
		} else if (select_A_Training_Type.equals("Others")) {
			Thread.sleep(4000);
			updateScheme.clickOnOthersAction();
			Thread.sleep(5000);
			updateScheme.clickOnOthersUpdateScheme();
		} else if (select_Scheme.equals("NON-PMKVY")) {
			Thread.sleep(4000);
			updateScheme.clickOnNonPMKVYAction();
			Thread.sleep(5000);
			updateScheme.clickOnNonPMKVYUpdateScheme();
		} else if (select_Scheme.equals("Integration")) {
			Thread.sleep(4000);
			updateScheme.clickOnIntegrationAction();
			Thread.sleep(5000);
			updateScheme.clickOnIntegrationUpdateScheme();
		}

		Thread.sleep(3000);

		SchemeAdmin_UpdateSchemeDetailsPage updateSchemeDetails = new SchemeAdmin_UpdateSchemeDetailsPage(driver);
		updateSchemeDetails.enterDescriptionOftheScheme(description_Of_the_Scheme);
		updateSchemeDetails.enterDocumentsRequired(documents_Required);
		updateSchemeDetails.enterPrerequisiteToScheme(prerequisite_To_Scheme);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(6000);
		updateSchemeDetails.clickBrowseFile();
		Thread.sleep(4000);
		UploadFile.upload(uploadFile);
		Thread.sleep(4000);
		updateSchemeDetails.clickUploadFile();
		Thread.sleep(4000);
		updateSchemeDetails.selectDisabilityForthescheme(disability);
		updateSchemeDetails.selectGenderCatered(gender);
		updateSchemeDetails.selectCaste(caste);
		updateSchemeDetails.selectReligion(religion);
		Thread.sleep(5000);
		updateSchemeDetails.clickOnSaveAndSubmit();
		Thread.sleep(5000);
		updateSchemeDetails.selectTypeOfProjectImplementingAgency(type_Of_Project_Implementing_Agency);
		updateSchemeDetails
				.selectTrainingCentreRegistrationProcessDrivenBy(training_Centre_Registration_Process_Driven_By);
		updateSchemeDetails.enterRegistrationFee(registration_Fee);
		updateSchemeDetails.selectTypeOfTrainingPartnerOrPIA(type_Of_Training_Partner_Or_PIA);
		updateSchemeDetails.selectSchemeRegistrationFee(scheme_Registration_Fee);
		updateSchemeDetails.enterSchemeRegistrationAmount(scheme_Registration_Amount);
		updateSchemeDetails.selectAdditionalDocumentsRequired(additional_Documents_Required);
		updateSchemeDetails.clickOnSaveAndAddAnotherTrainingPartnerType();
		updateSchemeDetails.selectTargetAllocationRequired(target_Allocation_Required);
		if (target_Allocation_Required.equals("Yes")) {
			updateSchemeDetails.selectTargetAllocationProhibitionFor(target_Allocation_Prohibition_For);
			updateSchemeDetails.selectTargetAllocatedAtLevel(target_Allocated_At_Level);
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(3000);
			GUIFunctionality.selectDate();
			Thread.sleep(3000);

		} else if (target_Allocation_Required.equals("No")) {
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(3000);
			GUIFunctionality.selectDate();
			Thread.sleep(3000);

		}
		Thread.sleep(5000);
		updateSchemeDetails.clickOnSaveAndContinue1();
		Thread.sleep(4000);
		updateSchemeDetails.selectLocationSpecificity(location_Specificity);
		updateSchemeDetails.selectDistrict(select_District);
		updateSchemeDetails.clickOnAadhaarMandatory();
		Thread.sleep(3000);
		updateSchemeDetails.clickOnSpecialStateStudentWithoutAadhaarAllowed();
		Thread.sleep(5000);
		updateSchemeDetails.clickOnAdd();
		Thread.sleep(5000);
		updateSchemeDetails.clickOnSaveAndContinue2();
		Thread.sleep(5000);
		updateSchemeDetails.clickOnSubmit();
		Assert.assertEquals(
				driver.findElement(By.xpath("//h2[contains(text(),'Scheme sent for approval')]")).getText().trim(),
				"Scheme sent for approval");
		updateSchemeDetails.clickOnOk();
		Thread.sleep(4000);
		sa_Dashboard.clickOnViewAllSchemes();
		Thread.sleep(4000);

		SchemeAdmin_ViewAllSchemesPage viewAllSchemes = new SchemeAdmin_ViewAllSchemesPage(driver);
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + created_Sa_Username + "')]"))
				.getText().trim(), created_Sa_Username);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + created_Sa_Username + "')]")).getText() + " "
						+ created_Sa_Username);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText().trim(),
				select_Scheme);
		System.out.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText()
				+ " " + select_Scheme);

		Assert.assertEquals(driver.findElement(By
				.xpath("(//table[thead[tr[th[contains(text(),'version')]]]]/tbody/tr/td[text()='" + version + "'])[2]"))
				.getText().trim(), version);
		System.out.println(driver.findElement(By
				.xpath("(//table[thead[tr[th[contains(text(),'version')]]]]/tbody/tr/td[text()='" + version + "'])[2]"))
				.getText() + " " + version);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + submitted_Status + "')]")).getText().trim(),
				submitted_Status);
		System.out
				.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + submitted_Status + "')]")).getText()
						+ " " + submitted_Status);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText().trim(),
				enter_Scheme_Name);
		System.out
				.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText()
						+ " " + enter_Scheme_Name);

		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]"))
				.getText().trim(), select_A_Scheme_Type);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]")).getText() + " "
						+ select_A_Scheme_Type);

		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]"))
				.getText().trim(), select_A_Training_Type);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]")).getText()
						+ " " + select_A_Training_Type);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText().trim(),
				enter_Scheme_Department_Or_Ministry);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText() + " " + enter_Scheme_Department_Or_Ministry);

		if (select_A_Training_Type.equals("RPL")) {
			Thread.sleep(4000);
			viewAllSchemes.clickOnRplAction();
			Thread.sleep(5000);
			viewAllSchemes.clickOnRplViewScheme();
		} else if (select_A_Training_Type.equals("STT")) {
			Thread.sleep(4000);
			viewAllSchemes.clickOnSTTAction();
			Thread.sleep(5000);
			viewAllSchemes.clickOnSTTViewScheme();
		} else if (select_A_Training_Type.equals("India Internal")) {
			Thread.sleep(4000);
			viewAllSchemes.clickOnIndiaInternalAction();
			Thread.sleep(5000);
			viewAllSchemes.clickOnIndiaInternalViewScheme();
		} else if (select_A_Training_Type.equals("Special Project")) {
			Thread.sleep(4000);
			viewAllSchemes.clickOnSpecialProjectAction();
			Thread.sleep(5000);
			viewAllSchemes.clickOnSpecialProjectViewScheme();
		} else if (select_A_Training_Type.equals("Others")) {
			Thread.sleep(4000);
			viewAllSchemes.clickOnOthersAction();
			Thread.sleep(5000);
			viewAllSchemes.clickOnOthersViewScheme();
		} else if (select_Scheme.equals("NON-PMKVY")) {
			Thread.sleep(4000);
			viewAllSchemes.clickOnNonPMKVYAction();
			Thread.sleep(5000);
			viewAllSchemes.clickOnNonPMKVYViewScheme();
		} else if (select_Scheme.equals("Integration")) {
			Thread.sleep(4000);
			viewAllSchemes.clickOnIntegrationAction();
			Thread.sleep(5000);
			viewAllSchemes.clickOnIntegrationViewScheme();
		}

		Thread.sleep(3000);
		if (select_A_Training_Type.equals("RPL") || select_A_Training_Type.equals("STT")
				|| select_A_Training_Type.equals("India Internal") || select_A_Training_Type.equals("Special Project")
				|| select_A_Training_Type.equals("Others") || select_A_Training_Type.equals("NON-PMKVY")
				|| select_A_Training_Type.equals("Integration")) {
			Thread.sleep(4000);
			Assert.assertEquals(
					driver.findElement(By.xpath("//textarea[@placeholder='Enter the Description of the Scheme']"))
							.getAttribute("value"),
					description_Of_the_Scheme);
			Assert.assertEquals(driver
					.findElement(By.xpath("//textarea[@placeholder='Enter the documents required for the scheme']"))
					.getAttribute("value"), documents_Required);
			Assert.assertEquals(
					driver.findElement(By.xpath("//textarea[@placeholder='Enter the pre-requisite to scheme']"))
							.getAttribute("value"),
					prerequisite_To_Scheme);
			Select selectedDisability = new Select(
					driver.findElement(By.xpath("//select[@title='Select Disability']")));
			Assert.assertEquals(selectedDisability.getFirstSelectedOption().getText(), disability);
			Select selectedGender = new Select(driver.findElement(By.xpath("//select[@title='Select Gender']")));
			Assert.assertEquals(selectedGender.getFirstSelectedOption().getText(), gender);
			Select selectedCaste = new Select(driver.findElement(By.xpath("//select[@title='Select Caste']")));
			Assert.assertEquals(selectedCaste.getFirstSelectedOption().getText(), caste);
			Select selectedReligion = new Select(driver.findElement(By.xpath("//select[@title='Select Religion']")));
			Assert.assertEquals(selectedReligion.getFirstSelectedOption().getText(), religion);
			SchemeAdmin_ViewAllSchemes_ViewSchemesDetailsPage view_Schemes_Details = new SchemeAdmin_ViewAllSchemes_ViewSchemesDetailsPage(
					driver);
			view_Schemes_Details.clickOnNext1();
			Thread.sleep(4000);
			Assert.assertEquals(type_Of_Project_Implementing_Agency,
					driver.findElement(
							By.xpath("//tbody/tr/td[contains(text(),'" + type_Of_Project_Implementing_Agency + "')]"))
							.getText());
			Assert.assertEquals(training_Centre_Registration_Process_Driven_By,
					driver.findElement(By.xpath(
							"//tbody/tr/td[contains(text(),'" + training_Centre_Registration_Process_Driven_By + "')]"))
							.getText());
			Assert.assertEquals(registration_Fee,
					driver.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + registration_Fee + "')])[1]"))
							.getText());
			Assert.assertEquals(type_Of_Training_Partner_Or_PIA,
					driver.findElement(
							By.xpath("//tbody/tr/td[contains(text(),'" + type_Of_Training_Partner_Or_PIA + "')]"))
							.getText());
			String str1 = ReadWriteData.getData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
					Integer.parseInt(serialNum), 52);
			System.out.println(str1);
			String schemeRegistrationFee;
			schemeRegistrationFee = str1.toLowerCase();
			System.out.println(schemeRegistrationFee);
			Thread.sleep(9000);
			System.out.println(
					driver.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + schemeRegistrationFee + "')])[1]"))
							.getText() + " " + schemeRegistrationFee);
			Assert.assertEquals(schemeRegistrationFee,
					driver.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + schemeRegistrationFee + "')])[1]"))
							.getText());
			Assert.assertEquals(scheme_Registration_Amount,
					driver.findElement(
							By.xpath("(//tbody/tr/td[contains(text(),'" + scheme_Registration_Amount + "')])[2]"))
							.getText());
			String str2 = ReadWriteData.getData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
					Integer.parseInt(serialNum), 54);
			System.out.println(str2);
			String additionalDocumentsRequired;
			additionalDocumentsRequired = str2.toLowerCase();
			System.out.println(additionalDocumentsRequired);
			Thread.sleep(9000);
			System.out.println(driver
					.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + additionalDocumentsRequired + "')])[2]"))
					.getText() + " " + additionalDocumentsRequired);

			Assert.assertEquals(additionalDocumentsRequired,
					driver.findElement(
							By.xpath("(//tbody/tr/td[contains(text(),'" + additionalDocumentsRequired + "')])[2]"))
							.getText());
			Select selectedtargetAllocationRequired = new Select(
					driver.findElement(By.xpath("//select[@id='exampleSelect1']")));

			if (target_Allocation_Required.equals("Yes")) {
				System.out.println(selectedtargetAllocationRequired.getFirstSelectedOption().getText() + " "
						+ target_Allocation_Required);
				Assert.assertEquals(selectedtargetAllocationRequired.getFirstSelectedOption().getText(),
						target_Allocation_Required);
				Select selectedtargetAllocationProhibitionFor = new Select(
						driver.findElement(By.xpath("//select[@id='exampleSelect3']")));
				Assert.assertEquals(selectedtargetAllocationProhibitionFor.getFirstSelectedOption().getText(),
						target_Allocation_Prohibition_For);
				Select selectedtargetAllocatedAtLevel = new Select(
						driver.findElement(By.xpath("//select[@id='exampleSelect4']")));
				Assert.assertEquals(selectedtargetAllocatedAtLevel.getFirstSelectedOption().getText(),
						target_Allocated_At_Level);
				// Assert.assertEquals(select_District,
				// driver.findElement(By.xpath("//select[@title='Select Caste']")).getText());
			} else if (target_Allocation_Required.equals("No")) {
				System.out.println(selectedtargetAllocationRequired.getFirstSelectedOption().getText() + " "
						+ target_Allocation_Required);
				Assert.assertEquals(selectedtargetAllocationRequired.getFirstSelectedOption().getText(),
						target_Allocation_Required);
			}

			view_Schemes_Details.clickOnNext2();
			Thread.sleep(5000);
			Assert.assertEquals(location_Specificity,
					driver.findElement(By.xpath("//tr/td[contains(text(),'ANDAMAN AND NICOBAR ISLANDS')]")).getText());
			Thread.sleep(5000);
			Assert.assertEquals(district,
					driver.findElement(By.xpath("//tr/td/span[contains(text(),' NICOBARS')]")).getText());
			Thread.sleep(5000);
			// Assert.assertEquals(registration_Fee,
			// driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'123456')]")).getText());
			// Assert.assertEquals(type_Of_Training_Partner_Or_PIA,
			// driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'Gov')]")).getText());
			view_Schemes_Details.clickOnNext3();
			Thread.sleep(4000);
			view_Schemes_Details.clickOnSubmit();
			Thread.sleep(4000);
			Assert.assertEquals(
					driver.findElement(By.xpath("//h2[contains(text(),'Scheme sent for approval')]")).getText().trim(),
					"Scheme sent for approval");
			view_Schemes_Details.clickOnOk();
		}
		Thread.sleep(6000);
		sa_Dashboard.clickOnSaProfile();
		Thread.sleep(4000);
		sa_Dashboard.clickOnSaLogOut();
		Thread.sleep(6000);
		lp.clickLogin();

		elp.performlogin(created_So_Username, so_Confirm_Password);
		Thread.sleep(10000);
		so_Dashboard.clickOnAllApprovalRequests();

		SchemeOwner_AllApprovalRequestsPage approvalRequest = new SchemeOwner_AllApprovalRequestsPage(driver);
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + created_Sa_Username + "')]"))
				.getText().trim(), created_Sa_Username);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + created_Sa_Username + "')]")).getText() + " "
						+ created_Sa_Username);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText().trim(),
				select_Scheme);
		System.out.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText()
				+ " " + select_Scheme);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + submitted_Status + "')]")).getText().trim(),
				submitted_Status);
		System.out
				.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + submitted_Status + "')]")).getText()
						+ " " + submitted_Status);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText().trim(),
				enter_Scheme_Name);
		System.out
				.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText()
						+ " " + enter_Scheme_Name);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]"))
				.getText().trim(), select_A_Scheme_Type);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]")).getText() + " "
						+ select_A_Scheme_Type);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]"))
				.getText().trim(), select_A_Training_Type);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]")).getText()
						+ " " + select_A_Training_Type);
		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText().trim(),
				enter_Scheme_Department_Or_Ministry);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText() + " " + enter_Scheme_Department_Or_Ministry);

		if (select_A_Training_Type.equals("RPL")) {
			Thread.sleep(4000);
			approvalRequest.clickOnRplAction();
			Thread.sleep(5000);
			approvalRequest.clickOnRplApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("STT")) {
			Thread.sleep(4000);
			approvalRequest.clickOnSTTAction();
			Thread.sleep(5000);
			approvalRequest.clickOnSTTApproveOrRejectScheme();
		}

		if (select_A_Training_Type.equals("India Internal")) {
			Thread.sleep(4000);
			approvalRequest.clickOnIndiaInternalAction();
			Thread.sleep(5000);
			approvalRequest.clickOnIndiaInternalApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("Special Project")) {
			Thread.sleep(4000);
			approvalRequest.clickOnSpecialProjectAction();
			Thread.sleep(5000);
			approvalRequest.clickOnSpecialProjectApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("Others")) {
			Thread.sleep(4000);
			approvalRequest.clickOnOthersAction();
			Thread.sleep(5000);
			approvalRequest.clickOnOthersApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("NON-PMKVY")) {
			Thread.sleep(4000);
			approvalRequest.clickOnNonPMKVYAction();
			Thread.sleep(5000);
			approvalRequest.clickOnNonPMKVYApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("Integration")) {
			Thread.sleep(4000);
			approvalRequest.clickOnIntegrationAction();
			Thread.sleep(5000);
			approvalRequest.clickOnIntegrationApproveOrRejectScheme();
		}

		Thread.sleep(4000);
		Assert.assertEquals(
				driver.findElement(By.xpath("//textarea[@placeholder='Enter the Description of the Scheme']"))
						.getAttribute("value"),
				description_Of_the_Scheme);
		Assert.assertEquals(
				driver.findElement(By.xpath("//textarea[@placeholder='Enter the documents required for the scheme']"))
						.getAttribute("value"),
				documents_Required);
		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@placeholder='Enter the pre-requisite to scheme']"))
				.getAttribute("value"), prerequisite_To_Scheme);
		Select selectedDisability = new Select(driver.findElement(By.xpath("//select[@title='Select Disability']")));
		Assert.assertEquals(selectedDisability.getFirstSelectedOption().getText(), disability);
		Select selectedGender = new Select(driver.findElement(By.xpath("//select[@title='Select Gender']")));
		Assert.assertEquals(selectedGender.getFirstSelectedOption().getText(), gender);
		Select selectedCaste = new Select(driver.findElement(By.xpath("//select[@title='Select Caste']")));
		Assert.assertEquals(selectedCaste.getFirstSelectedOption().getText(), caste);
		Select selectedReligion = new Select(driver.findElement(By.xpath("//select[@title='Select Religion']")));
		Assert.assertEquals(selectedReligion.getFirstSelectedOption().getText(), religion);
		SchemeOwner_ApproveOrRejectSchemesPage approveOrRejectSchemes = new SchemeOwner_ApproveOrRejectSchemesPage(
				driver);
		approveOrRejectSchemes.clickOnNext1();
		Assert.assertEquals(type_Of_Project_Implementing_Agency,
				driver.findElement(
						By.xpath("//tbody/tr/td[contains(text(),'" + type_Of_Project_Implementing_Agency + "')]"))
						.getText());
		Assert.assertEquals(training_Centre_Registration_Process_Driven_By,
				driver.findElement(By.xpath(
						"//tbody/tr/td[contains(text(),'" + training_Centre_Registration_Process_Driven_By + "')]"))
						.getText());
		Assert.assertEquals(registration_Fee, driver
				.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + registration_Fee + "')])[1]")).getText());
		Assert.assertEquals(type_Of_Training_Partner_Or_PIA,
				driver.findElement(
						By.xpath("//tbody/tr/td[contains(text(),'" + type_Of_Training_Partner_Or_PIA + "')]"))
						.getText());
		String str1 = ReadWriteData.getData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
				Integer.parseInt(serialNum), 52);
		System.out.println(str1);
		String schemeRegistrationFee;
		schemeRegistrationFee = str1.toLowerCase();
		System.out.println(schemeRegistrationFee);
		Thread.sleep(9000);
		System.out.println(
				driver.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + schemeRegistrationFee + "')])[1]"))
						.getText() + " " + schemeRegistrationFee);
		Assert.assertEquals(schemeRegistrationFee,
				driver.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + schemeRegistrationFee + "')])[1]"))
						.getText());
		Assert.assertEquals(scheme_Registration_Amount,
				driver.findElement(
						By.xpath("(//tbody/tr/td[contains(text(),'" + scheme_Registration_Amount + "')])[2]"))
						.getText());
		String str2 = ReadWriteData.getData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
				Integer.parseInt(serialNum), 54);
		System.out.println(str2);
		String additionalDocumentsRequired;
		additionalDocumentsRequired = str2.toLowerCase();
		System.out.println(additionalDocumentsRequired);
		Thread.sleep(9000);
		System.out.println(driver
				.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + additionalDocumentsRequired + "')])[2]"))
				.getText() + " " + additionalDocumentsRequired);
		Assert.assertEquals(additionalDocumentsRequired,
				driver.findElement(
						By.xpath("(//tbody/tr/td[contains(text(),'" + additionalDocumentsRequired + "')])[2]"))
						.getText());
		Select selectedtargetAllocationRequired = new Select(
				driver.findElement(By.xpath("//select[@id='exampleSelect1']")));
		if (target_Allocation_Required.equals("Yes")) {
			System.out.println(selectedtargetAllocationRequired.getFirstSelectedOption().getText() + " "
					+ target_Allocation_Required);
			Assert.assertEquals(selectedtargetAllocationRequired.getFirstSelectedOption().getText(),
					target_Allocation_Required);
			Select selectedtargetAllocationProhibitionFor = new Select(
					driver.findElement(By.xpath("//select[@id='exampleSelect3']")));
			Assert.assertEquals(selectedtargetAllocationProhibitionFor.getFirstSelectedOption().getText(),
					target_Allocation_Prohibition_For);
			Select selectedtargetAllocatedAtLevel = new Select(
					driver.findElement(By.xpath("//select[@id='exampleSelect4']")));
			Assert.assertEquals(selectedtargetAllocatedAtLevel.getFirstSelectedOption().getText(),
					target_Allocated_At_Level);
		} else if (target_Allocation_Required.equals("No")) {
			System.out.println(selectedtargetAllocationRequired.getFirstSelectedOption().getText() + " "
					+ target_Allocation_Required);
			Assert.assertEquals(selectedtargetAllocationRequired.getFirstSelectedOption().getText(),
					target_Allocation_Required);
		}
		// Assert.assertEquals(select_District,
		// driver.findElement(By.xpath("//select[@title='Select Caste']")).getText());
		approveOrRejectSchemes.clickOnNext2();
		Thread.sleep(5000);
		Assert.assertEquals(location_Specificity,
				driver.findElement(By.xpath("//tr/td[contains(text(),'ANDAMAN AND NICOBAR ISLANDS')]")).getText());
		Thread.sleep(5000);
		Assert.assertEquals(district,
				driver.findElement(By.xpath("//tr/td/span[contains(text(),' NICOBARS')]")).getText());
		Thread.sleep(5000);
		// Assert.assertEquals(registration_Fee,
		// driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'123456')]")).getText());
		// Assert.assertEquals(type_Of_Training_Partner_Or_PIA,
		// driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'Gov')]")).getText());
		approveOrRejectSchemes.clickOnNext3();
		Thread.sleep(4000);
		approveOrRejectSchemes.clickOnApprove();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Scheme approved')]")).getText().trim(),
				"Scheme approved");
		Thread.sleep(4000);
		approveOrRejectSchemes.clickOnOk();
		Thread.sleep(6000);
		so_Dashboard.clickOnSOProfile();
		Thread.sleep(4000);
		so_Dashboard.clickOnSOLogOut();
		Thread.sleep(6000);
		lp.clickLogin();
		elp.performlogin(created_BO_Username, bo_Confirm_Password);
		Thread.sleep(10000);
		bo_Dashboard.clickOnAllApprovalRequests();
		BusinessOwner_AllApprovalRequestsPage bo_ApprovalRequest = new BusinessOwner_AllApprovalRequestsPage(driver);
		Thread.sleep(8000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + created_So_Username + "')]"))
				.getText().trim(), created_So_Username);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + created_So_Username + "')]")).getText() + " "
						+ created_So_Username);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText().trim(),
				select_Scheme);
		System.out.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText()
				+ " " + select_Scheme);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + submitted_Status + "')]")).getText().trim(),
				submitted_Status);
		System.out
				.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + submitted_Status + "')]")).getText()
						+ " " + submitted_Status);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText().trim(),
				enter_Scheme_Name);
		System.out
				.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText()
						+ " " + enter_Scheme_Name);

		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]"))
				.getText().trim(), select_A_Scheme_Type);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]")).getText() + " "
						+ select_A_Scheme_Type);

		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]"))
				.getText().trim(), select_A_Training_Type);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]")).getText()
						+ " " + select_A_Training_Type);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText().trim(),
				enter_Scheme_Department_Or_Ministry);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText() + " " + enter_Scheme_Department_Or_Ministry);

		if (select_A_Training_Type.equals("RPL")) {
			Thread.sleep(4000);
			bo_ApprovalRequest.clickOnRplAction();
			Thread.sleep(5000);
			bo_ApprovalRequest.clickOnRplApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("STT")) {
			Thread.sleep(4000);
			bo_ApprovalRequest.clickOnSTTAction();
			Thread.sleep(5000);
			bo_ApprovalRequest.clickOnSTTApproveOrRejectScheme();
		}

		if (select_A_Training_Type.equals("India Internal")) {
			Thread.sleep(4000);
			bo_ApprovalRequest.clickOnIndiaInternalAction();
			Thread.sleep(5000);
			bo_ApprovalRequest.clickOnIndiaInternalApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("Special Project")) {
			Thread.sleep(4000);
			bo_ApprovalRequest.clickOnSpecialProjectAction();
			Thread.sleep(5000);
			bo_ApprovalRequest.clickOnSpecialProjectApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("Others")) {
			Thread.sleep(4000);
			bo_ApprovalRequest.clickOnOthersAction();
			Thread.sleep(5000);
			bo_ApprovalRequest.clickOnOthersApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("NON-PMKVY")) {
			Thread.sleep(4000);
			bo_ApprovalRequest.clickOnNonPMKVYAction();
			Thread.sleep(5000);
			bo_ApprovalRequest.clickOnNonPMKVYApproveOrRejectScheme();
		}

		else if (select_A_Training_Type.equals("Integration")) {
			Thread.sleep(4000);
			bo_ApprovalRequest.clickOnIntegrationAction();
			Thread.sleep(5000);
			bo_ApprovalRequest.clickOnIntegrationApproveOrRejectScheme();
		}

		Thread.sleep(4000);
		Assert.assertEquals(
				driver.findElement(By.xpath("//textarea[@placeholder='Enter the Description of the Scheme']"))
						.getAttribute("value"),
				description_Of_the_Scheme);
		Assert.assertEquals(
				driver.findElement(By.xpath("//textarea[@placeholder='Enter the documents required for the scheme']"))
						.getAttribute("value"),
				documents_Required);
		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@placeholder='Enter the pre-requisite to scheme']"))
				.getAttribute("value"), prerequisite_To_Scheme);
		Select selectedDisability1 = new Select(driver.findElement(By.xpath("//select[@title='Select Disability']")));
		Assert.assertEquals(selectedDisability1.getFirstSelectedOption().getText(), disability);
		Select selectedGender1 = new Select(driver.findElement(By.xpath("//select[@title='Select Gender']")));
		Assert.assertEquals(selectedGender1.getFirstSelectedOption().getText(), gender);
		Select selectedCaste1 = new Select(driver.findElement(By.xpath("//select[@title='Select Caste']")));
		Assert.assertEquals(selectedCaste1.getFirstSelectedOption().getText(), caste);
		Select selectedReligion1 = new Select(driver.findElement(By.xpath("//select[@title='Select Religion']")));
		Assert.assertEquals(selectedReligion1.getFirstSelectedOption().getText(), religion);
		BusinessOwner_ApproveOrRejectSchemesPage bo_approveOrRejectSchemes = new BusinessOwner_ApproveOrRejectSchemesPage(
				driver);
		bo_approveOrRejectSchemes.clickOnNext1();
		Assert.assertEquals(type_Of_Project_Implementing_Agency,
				driver.findElement(
						By.xpath("//tbody/tr/td[contains(text(),'" + type_Of_Project_Implementing_Agency + "')]"))
						.getText());
		Assert.assertEquals(training_Centre_Registration_Process_Driven_By,
				driver.findElement(By.xpath(
						"//tbody/tr/td[contains(text(),'" + training_Centre_Registration_Process_Driven_By + "')]"))
						.getText());
		Assert.assertEquals(registration_Fee, driver
				.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + registration_Fee + "')])[1]")).getText());
		Assert.assertEquals(type_Of_Training_Partner_Or_PIA,
				driver.findElement(
						By.xpath("//tbody/tr/td[contains(text(),'" + type_Of_Training_Partner_Or_PIA + "')]"))
						.getText());
		String str3 = ReadWriteData.getData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
				Integer.parseInt(serialNum), 52);
		System.out.println(str3);
		String schemeRegistrationFee1;
		schemeRegistrationFee1 = str3.toLowerCase();
		System.out.println(schemeRegistrationFee1);
		Thread.sleep(9000);
		System.out.println(
				driver.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + schemeRegistrationFee1 + "')])[1]"))
						.getText() + " " + schemeRegistrationFee1);
		Assert.assertEquals(schemeRegistrationFee1,
				driver.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + schemeRegistrationFee1 + "')])[1]"))
						.getText());
		Assert.assertEquals(scheme_Registration_Amount,
				driver.findElement(
						By.xpath("(//tbody/tr/td[contains(text(),'" + scheme_Registration_Amount + "')])[2]"))
						.getText());
		String str4 = ReadWriteData.getData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner",
				Integer.parseInt(serialNum), 54);
		System.out.println(str4);
		String additionalDocumentsRequired1;
		additionalDocumentsRequired1 = str4.toLowerCase();
		System.out.println(additionalDocumentsRequired1);
		Thread.sleep(9000);
		System.out.println(driver
				.findElement(By.xpath("(//tbody/tr/td[contains(text(),'" + additionalDocumentsRequired1 + "')])[2]"))
				.getText() + " " + additionalDocumentsRequired1);
		Assert.assertEquals(additionalDocumentsRequired1,
				driver.findElement(
						By.xpath("(//tbody/tr/td[contains(text(),'" + additionalDocumentsRequired1 + "')])[2]"))
						.getText());
		Select selectedtargetAllocationRequired1 = new Select(
				driver.findElement(By.xpath("//select[@id='exampleSelect1']")));

		if (target_Allocation_Required.equals("Yes")) {
			System.out.println(selectedtargetAllocationRequired1.getFirstSelectedOption().getText() + " "
					+ target_Allocation_Required);
			Assert.assertEquals(selectedtargetAllocationRequired1.getFirstSelectedOption().getText(),
					target_Allocation_Required);
			Select selectedtargetAllocationProhibitionFor1 = new Select(
					driver.findElement(By.xpath("//select[@id='exampleSelect3']")));
			Assert.assertEquals(selectedtargetAllocationProhibitionFor1.getFirstSelectedOption().getText(),
					target_Allocation_Prohibition_For);
			Select selectedtargetAllocatedAtLevel1 = new Select(
					driver.findElement(By.xpath("//select[@id='exampleSelect4']")));
			Assert.assertEquals(selectedtargetAllocatedAtLevel1.getFirstSelectedOption().getText(),
					target_Allocated_At_Level);
			// Assert.assertEquals(select_District,
			// driver.findElement(By.xpath("//select[@title='Select Caste']")).getText());
		} else if (target_Allocation_Required.equals("No")) {
			System.out.println(selectedtargetAllocationRequired1.getFirstSelectedOption().getText() + " "
					+ target_Allocation_Required);
			Assert.assertEquals(selectedtargetAllocationRequired1.getFirstSelectedOption().getText(),
					target_Allocation_Required);
		}

		bo_approveOrRejectSchemes.clickOnNext2();
		Thread.sleep(5000);
		Assert.assertEquals(location_Specificity,
				driver.findElement(By.xpath("//tr/td[contains(text(),'ANDAMAN AND NICOBAR ISLANDS')]")).getText());
		Thread.sleep(5000);
		Assert.assertEquals(district,
				driver.findElement(By.xpath("//tr/td/span[contains(text(),' NICOBARS')]")).getText());
		Thread.sleep(5000);
		// Assert.assertEquals(registration_Fee,
		// driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'123456')]")).getText());
		// Assert.assertEquals(type_Of_Training_Partner_Or_PIA,
		// driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'Gov')]")).getText());
		bo_approveOrRejectSchemes.clickOnNext3();
		Thread.sleep(4000);
		bo_approveOrRejectSchemes.clickOnApprove();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Scheme approved')]")).getText().trim(),
				"Scheme approved");
		Thread.sleep(4000);
		bo_approveOrRejectSchemes.clickOnOk();
		Thread.sleep(4000);

		bo_Dashboard.clickOnBOProfile();
		Thread.sleep(5000);
		bo_Dashboard.clickOnBOLogOut();
		lp.clickLogin();
		elp.performlogin(created_Sa_Username, sa_Confirm_Password);
		Thread.sleep(10000);
		sa_Dashboard.clickOnInstantialteJobRoles();
		Thread.sleep(4000);
		SchemeAdmin_InstantialteJobRolesPage sa_InstantialteJobRoles = new SchemeAdmin_InstantialteJobRolesPage(driver);

		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + created_So_Username + "')]"))
				.getText().trim(), created_So_Username);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + created_So_Username + "')]")).getText() + " "
						+ created_So_Username);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText().trim(),
				select_Scheme);
		System.out.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_Scheme + "')]")).getText()
				+ " " + select_Scheme);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + approved_Status + "')]")).getText().trim(),
				approved_Status);
		System.out.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + approved_Status + "')]")).getText()
				+ " " + approved_Status);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText().trim(),
				enter_Scheme_Name);
		System.out
				.println(driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Name + "')]")).getText()
						+ " " + enter_Scheme_Name);

		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]"))
				.getText().trim(), select_A_Scheme_Type);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Scheme_Type + "')]")).getText() + " "
						+ select_A_Scheme_Type);

		Assert.assertEquals(driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]"))
				.getText().trim(), select_A_Training_Type);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + select_A_Training_Type + "')]")).getText()
						+ " " + select_A_Training_Type);

		Assert.assertEquals(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText().trim(),
				enter_Scheme_Department_Or_Ministry);
		System.out.println(
				driver.findElement(By.xpath("//tr/td[contains(text(),'" + enter_Scheme_Department_Or_Ministry + "')]"))
						.getText() + " " + enter_Scheme_Department_Or_Ministry);

		if (select_A_Training_Type.equals("RPL")) {
			Thread.sleep(4000);
			sa_InstantialteJobRoles.clickOnRplAction();
			Thread.sleep(5000);
			sa_InstantialteJobRoles.clickOnRplAddQpsToScheme();
		} else if (select_A_Training_Type.equals("STT")) {
			Thread.sleep(4000);
			sa_InstantialteJobRoles.clickOnSTTAction();
			Thread.sleep(5000);
			sa_InstantialteJobRoles.clickOnSTTAddQpsToScheme();
		} else if (select_A_Training_Type.equals("India Internal")) {
			Thread.sleep(4000);
			sa_InstantialteJobRoles.clickOnIndiaInternalAction();
			Thread.sleep(5000);
			sa_InstantialteJobRoles.clickOnIndiaInternalAddQpsToScheme();
		} else if (select_A_Training_Type.equals("Special Project")) {
			Thread.sleep(4000);
			sa_InstantialteJobRoles.clickOnSpecialProjectAction();
			Thread.sleep(5000);
			sa_InstantialteJobRoles.clickOnSpecialProjectAddQpsToScheme();
		} else if (select_A_Training_Type.equals("Others")) {
			Thread.sleep(4000);
			sa_InstantialteJobRoles.clickOnOthersAction();
			Thread.sleep(5000);
			sa_InstantialteJobRoles.clickOnOthersAddQpsToScheme();
		} else if (select_Scheme.equals("NON-PMKVY")) {
			Thread.sleep(4000);
			sa_InstantialteJobRoles.clickOnNonPMKVYAction();
			Thread.sleep(5000);
			sa_InstantialteJobRoles.clickOnNonPMKVYAddQpsToScheme();
		} else if (select_Scheme.equals("Integration")) {
			Thread.sleep(4000);
			sa_InstantialteJobRoles.clickOnIntegrationAction();
			Thread.sleep(5000);
			sa_InstantialteJobRoles.clickOnIntegrationAddQpsToScheme();
		}

		Thread.sleep(3000);
		SchemeAdmin_AddQpsToSchemePage sa_AddQpsToScheme = new SchemeAdmin_AddQpsToSchemePage(driver);
		sa_AddQpsToScheme.selectSector(select_Sector);
		Thread.sleep(4000);
		sa_AddQpsToScheme.selectSubSector(select_SubSector);
		Thread.sleep(4000);
		sa_AddQpsToScheme.enterSearchByQPCode(search_By_QpCode);
		Thread.sleep(4000);
		sa_AddQpsToScheme.clickOnSearch();
		Thread.sleep(4000);
		sa_AddQpsToScheme.clickOnAddToScheme();

	}
}
